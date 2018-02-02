package academy.itcloud.aleksandr.jdbc.dao.h2;

import academy.itcloud.aleksandr.jdbc.GetConnection;
import academy.itcloud.aleksandr.jdbc.dao.*;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JournalH2 extends GetConnection implements JournalDAO {
    private static final String ADD_JOURNAL = "INSERT INTO journal (score, course_id, student_id, task_id) VALUES (?,?,?,?)";
    private static final String JOURNAL_OF_THE_COURSE = "SELECT * FROM journal JOIN student ON journal.student_id=student.student_id " +
            "JOIN task ON journal.task_id=task.task_id WHERE journal.course_id=? ORDER BY student.lastname";

    private ResultSet resultSet;

    @Override
    public void selectJournalOfTheCourse(int courseId) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(JOURNAL_OF_THE_COURSE)) {
            preparedStatement.setInt(1, courseId);
            resultSet = preparedStatement.executeQuery();
            int studentId = 0; // TODO "переделать на коллекцию"
            while (resultSet.next()) {
                if (studentId != resultSet.getInt("student_id")) {
                    System.out.printf("Student: ID-%d, %s %s\n", resultSet.getInt("student_id"), resultSet.getString("firstname"), resultSet.getString("lastname"));
                    studentId = resultSet.getInt("student_id");
                }
                System.out.printf("%s: score %d\n", resultSet.getString("task_name"), resultSet.getInt("score"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean addJournal(int coursId, int studentId, int taskId) {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(ADD_JOURNAL)) {
            return fillStudent(preparedStatement, coursId, studentId, taskId).execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private PreparedStatement fillStudent(PreparedStatement prst, int coursId, int studentId, int taskId) throws SQLException {
        prst.setInt(1, (int) (Math.random() * 12));
        prst.setInt(2, coursId);
        prst.setInt(3, studentId);
        prst.setInt(4, taskId);
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
}
