package academy.itcloud.aleksandr.jdbc.dao.h2;

import academy.itcloud.aleksandr.jdbc.GetConnection;
import academy.itcloud.aleksandr.jdbc.dao.*;


import java.sql.*;


public class StudentH2 extends GetConnection implements StudentDAO {

    private static final String ADD_STUDENT = "INSERT INTO student (firstname, lastname, age) VALUES (?, ?, ?)";
    private static final String SELECT_STUDENT = "SELECT * FROM student WHERE student.student_id=?";
    private static final String SELECT_ALL_STUDENT = "SELECT * FROM student";
    private static final String SELECT_STUDENT_HIS_COURSES = "SELECT DISTINCT course.course_id, name FROM course RIGHT JOIN journal ON journal.course_id=course.course_id " +
                    "LEFT JOIN student ON journal.student_id=student.student_id WHERE student.student_id=?";
    private ResultSet resultSet;

    @Override
    public boolean addStudent(String firstName, String lastName, int age) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(ADD_STUDENT)) {
            return fillStudent(preparedStatement, firstName, lastName, age).execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private PreparedStatement fillStudent(PreparedStatement prst, String firstName, String lastName, int age) throws SQLException {
        prst.setString(1, firstName);
        prst.setString(2, lastName);
        prst.setInt(3, age);
        return prst;
    }

    @Override
    public boolean update(int ID) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(int ID) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void selectAllStudent() {
        try (Statement statement = getConnection().createStatement()) {
            resultSet = statement.executeQuery(SELECT_ALL_STUDENT);
            System.out.println("Students:");
            while (resultSet.next()) {
                System.out.printf("%d, %s, %s, %d\n", resultSet.getInt("student_id"), resultSet.getString("firstname"), resultSet.getString("lastname"), resultSet.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void selectStudentHisCourse(int ID) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(SELECT_STUDENT_HIS_COURSES)){
            preparedStatement.setInt(1, ID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.printf("Course %d: %s\n", resultSet.getInt("course_id"), resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void selectOneStudent(int ID) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(SELECT_STUDENT)){
            preparedStatement.setInt(1, ID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.printf("%d Student %s, %s, %d\n", resultSet.getInt("student_id"), resultSet.getString("firstname"), resultSet.getString("lastname"), resultSet.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
