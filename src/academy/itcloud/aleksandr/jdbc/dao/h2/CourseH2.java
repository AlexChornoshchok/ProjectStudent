package academy.itcloud.aleksandr.jdbc.dao.h2;

import academy.itcloud.aleksandr.jdbc.GetConnection;
import academy.itcloud.aleksandr.jdbc.dao.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CourseH2 extends GetConnection implements CourseDAO {
    private static final String ADD_COURSE = "INSERT INTO course (name, description, data_start, data_end, daysOfWeek, trainer_id) VALUES (?,?,?,?,?,?)";

    private static final String SELECT_ONE_COURSE = "SELECT * FROM course LEFT JOIN trainer ON course.trainer_id=trainer.trainer_id WHERE course.course_id=?";
    private static final String SELECT_COURSE = "SELECT * FROM course JOIN trainer ON course.trainer_id=trainer.trainer_id";
    private static final String SELECT_STUDENTS_ON_COURSE = "SELECT DISTINCT student.student_id, firstname, lastname FROM student " +
            "RIGHT JOIN journal ON journal.student_id=student.student_id WHERE journal.course_id=?";

    private ResultSet resultSet;

    @Override
    public boolean addCourse(String name, String description, String data_start, String data_end, String daysOfWeek, int ID) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(ADD_COURSE)) {
            return fillCourse(preparedStatement, name, description, data_start, data_end, daysOfWeek, ID).execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private PreparedStatement fillCourse(PreparedStatement prst, String name, String description, String data_start, String data_end, String daysOfWeek, int ID) throws SQLException {
        prst.setString(1, name);
        prst.setString(2, description);
        prst.setString(3, data_start);
        prst.setString(4, data_end);
        prst.setString(5, daysOfWeek);
        prst.setInt(6, ID);
        return prst;
    }

    @Override
    public void selectAllCourse() {
        try (Statement statement = getConnection().createStatement()) {
            resultSet = statement.executeQuery(SELECT_COURSE);
            while (resultSet.next()) {
                System.out.printf("Course %d: %s\n", resultSet.getInt("course_id"), resultSet.getString("name"));
                System.out.println(resultSet.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void selectStudentsOnCourse(int ID) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(SELECT_STUDENTS_ON_COURSE)) {
            preparedStatement.setInt(1, ID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.printf("Student: ID-%d, %s %s\n", resultSet.getInt("student_id"), resultSet.getString("firstname"), resultSet.getString("lastname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void selectNameCourse(int ID) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(SELECT_ONE_COURSE)) {
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
    public void selectOneCourse(int ID) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(SELECT_ONE_COURSE)) {
            preparedStatement.setInt(1, ID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.printf("Course %d: %s\n", resultSet.getInt("course_id"), resultSet.getString("name"));
                System.out.println(resultSet.getString("description"));
                System.out.printf("Trainer: %s, %s, %d\n", resultSet.getString("firstname"), resultSet.getString("lastname"), resultSet.getInt("age"));
                System.out.printf("Period: from %s to %s\n", resultSet.getString("data_start"), resultSet.getString("data_end"));
                System.out.printf("Days of the week: %s\n", resultSet.getString("daysOfWeek"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean update(int ID) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(int ID) {
        throw new UnsupportedOperationException();
    }
}
