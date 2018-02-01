package academy.itcloud.aleksandr.system;

import academy.itcloud.aleksandr.jdbc.GetConnection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CreateBD extends GetConnection {

    private static final String DRIVER = "org.h2.Driver";
    //    private static final String DB_CONNECTION = "jdbc:h2:d:/MyJob/student_bd";
    private static final String DB_CONNECTION = "jdbc:h2:d:/ITCloud/AlexChernochshok/student_bd";
    //    private static final String DB_CONNECTION ="jdbc:h2:~test";
    private static final String DB_LOGIN = "";
    private static final String DB_PASSWORD = "";

    private static final String CREATE_TABLE_TRAINER = "CREATE TABLE trainer (trainer_id int(2) AUTO_INCREMENT, " +
            "firstname varchar(50), lastname varchar(50), age int(3), PRIMARY KEY (trainer_id))";
    private static final String CREATE_TABLE_STUDENT = "CREATE TABLE student (student_id int(2) AUTO_INCREMENT, " +
            "firstname varchar(50), lastname varchar(50), age int(3), PRIMARY KEY (student_id))";
    private static final String CREATE_TABLE_COURSE = "CREATE TABLE course (course_id int(2) AUTO_INCREMENT, " +
            "name varchar(50), description varchar(150), data_start varchar(10), data_end varchar(10), daysOfWeek varchar(50)," +
            "trainer_id int(2), " +
            "foreign key (trainer_id) references trainer(trainer_id), " +
            "PRIMARY KEY (course_id))";
    private static final String CREATE_TABLE_TASK = "CREATE TABLE task (task_id int(2) AUTO_INCREMENT," +
            "task_name varchar(50), course_id int(2), foreign key (course_id) references course(course_id), PRIMARY KEY (task_id))";
    private static final String CREATE_TABLE_COURSE_STUDENT = "CREATE TABLE course_student (id int AUTO_INCREMENT," +
            "course_id int(2), student_id int(2), " +
            "foreign key (course_id) references course(course_id), " +
            "foreign key (student_id) references student(student_id), " +
            "PRIMARY KEY (id))";
    private static final String CREATE_TABLE_JOURNAL = "CREATE TABLE journal (journal_id int AUTO_INCREMENT," +
            "score int(2)," +
            "course_id int(2), student_id int(2), task_id int(2)," +
            "foreign key (course_id) references course(course_id), " +
            "foreign key (student_id) references student(student_id)," +
            "foreign key (task_id) references task(task_id), " +
            "PRIMARY KEY (journal_id))";
    /// *********** Add
    private static final String ADD_TRAINER = "INSERT INTO trainer (firstname, lastname, age) VALUES (?, ?, ?)";
    private static final String ADD_STUDENT = "INSERT INTO student (firstname, lastname, age) VALUES (?, ?, ?)";
    private static final String ADD_COURSE = "INSERT INTO course (name, description, data_start, data_end, daysOfWeek, trainer_id) VALUES (?,?,?,?,?)";
    private static final String ADD_JOURNAL = "INSERT INTO journal (score, course_id, student_id, task_id) VALUES (?,?,?,?)";

    private static final String ADD_TRAINER1 = "INSERT INTO trainer (firstname, lastname, age) VALUES ('Lev', 'Landou', 110)";
    private static final String ADD_TRAINER2 = "INSERT INTO trainer (firstname, lastname, age) VALUES ('Albert', 'Einstein', 139)";
    private static final String ADD_TRAINER3 = "INSERT INTO trainer (firstname, lastname, age) VALUES ('Bill', 'Gates', 63)";

    private static final String ADD_STUDENT1 = "INSERT INTO student (firstname, lastname, age) VALUES ('Alex', 'Alexandrov', 25)";
    private static final String ADD_STUDENT2 = "INSERT INTO student (firstname, lastname, age) VALUES ('Petr', 'Ptrov', 25)";
    private static final String ADD_STUDENT3 = "INSERT INTO student (firstname, lastname, age) VALUES ('Ivan', 'Ivanov', 25)";


    private static final String SELECT_TRAINER = "SELECT * FROM trainer";
    private static final String SELECT_STUDENT = "SELECT * FROM student";
    private static final String SELECT_ONE_COURSE = "SELECT * FROM course JOIN trainer ON course.trainer_id=trainer.trainer_id WHERE course.course_id = ?";
    private static final String SELECT_COURSE = "SELECT * FROM course JOIN trainer ON course.trainer_id=trainer.trainer_id";
    private static final String JOURNAL = "SELECT * FROM journal JOIN student ON journal.student_id=student.student_id " +
            "JOIN task ON journal.task_id=task.task_id " +
            "WHERE journal.course_id=1 ORDER BY student.lastname";
    //    private static final String SELECT_STUDENT_COURSE =
//            "SELECT  * FROM journal JOIN course ON journal.course_id=course.course_id " +
//                    "RIGHT JOIN student ON journal.student_id=student.student_id " +
//                    "WHERE journal.course_id=1";
    private static final String SELECT_STUDENT_COURSE =
            "SELECT DISTINCT student.student_id, firstname, lastname FROM student RIGHT JOIN journal ON journal.student_id=student.student_id " +
                    "WHERE journal.course_id=1";
    /// ************ selekt


    public static void main(String... args) {


        try {
            Class.forName(DRIVER).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try {
            DriverManager.getConnection(DB_CONNECTION, DB_LOGIN, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ResultSet resultSet;
        try (Statement statement = getConnection().createStatement()) {
//            statement.execute(CREATE_TABLE_TRAINER);
//            statement.execute(CREATE_TABLE_STUDENT);
//            statement.execute(CREATE_TABLE_COURSE);
//            statement.execute(CREATE_TABLE_TASK);
//            statement.execute(CREATE_TABLE_COURSE_STUDENT);
//            statement.execute(CREATE_TABLE_JOURNAL);
//            statement.execute("INSERT INTO trainer (firstname, lastname, age) VALUES ('Lev', 'Landou', 110)"); //1
//            statement.execute("INSERT INTO trainer (firstname, lastname, age) VALUES ('Albert', 'Einstein', 139)"); //2
//            statement.execute("INSERT INTO trainer (firstname, lastname, age) VALUES ('Bill', 'Gates', 63)"); //3

//            statement.execute("INSERT INTO student (firstname, lastname, age) VALUES ('Alex', 'Alexandrov', 25)"); //1
//            statement.execute("INSERT INTO student (firstname, lastname, age) VALUES ('Petr', 'Ptrov', 23)"); //2
//            statement.execute("INSERT INTO student (firstname, lastname, age) VALUES ('Ivan', 'Ivanov', 24)"); //3
//            statement.execute("INSERT INTO student (firstname, lastname, age) VALUES ('Serg', 'Naznajka', 25)"); //4
//            statement.execute("INSERT INTO student (firstname, lastname, age) VALUES ('Anna', 'Zlata', 29)"); //5
//            statement.execute("INSERT INTO student (firstname, lastname, age) VALUES ('Marry', 'Popyns', 26)"); //6
//            statement.execute("INSERT INTO student (firstname, lastname, age) VALUES ('Olga', 'Pavlova', 21)"); //7

//            statement.execute("INSERT INTO course (name, description, data_start, data_end, daysOfWeek, trainer_id) VALUES " +
//                    "('Basics of programming', 'This is exactly the course that a beginner needs to try his hand at programming'," +
//                    " '2018-02-10', '2018-04-20', 'WEN TUS SUB', 1)");
//            statement.execute("INSERT INTO course (name, description, data_start, data_end, daysOfWeek,  trainer_id) VALUES " +
//                    "('Front End Development', 'Development of the frontend is becoming more popular today, and specialists of this profile are all more necessary.'," +
//                    " '2018-02-10', '2018-04-20', 'WEN TUS SUB', 2)");

//            statement.execute("INSERT INTO task (task_name, course_id) VALUES ('Task-1 for course 1', 1)");
//            statement.execute("INSERT INTO task (task_name, course_id) VALUES ('Task-2 for course 1', 1)");
//            statement.execute("INSERT INTO task (task_name, course_id) VALUES ('Task-3 for course 1', 1)");
//            statement.execute("INSERT INTO task (task_name, course_id) VALUES ('1-Task for course 1', 2)");
//            statement.execute("INSERT INTO task (task_name, course_id) VALUES ('1-Task for course 1', 2)");
//            statement.execute("INSERT INTO task (task_name, course_id) VALUES ('1-Task for course 1', 2)");
//            statement.execute("INSERT INTO task (task_name, course_id) VALUES ('1-Task for course 1', 2)");

//            statement.execute("INSERT INTO journal (score, course_id, student_id, task_id) VALUES (10, 1, 1, 1)");
//            statement.execute("INSERT INTO journal (score, course_id, student_id, task_id) VALUES (9, 1, 1, 2)");
//            statement.execute("INSERT INTO journal (score, course_id, student_id, task_id) VALUES (11, 1, 1, 2)");
//            statement.execute("INSERT INTO journal (score, course_id, student_id, task_id) VALUES (12, 2, 1, 1)");
//            statement.execute("INSERT INTO journal (score, course_id, student_id, task_id) VALUES (10, 2, 1, 2)");
//            statement.execute("INSERT INTO journal (score, course_id, student_id, task_id) VALUES (11, 2, 1, 3)");
//            statement.execute("INSERT INTO journal (score, course_id, student_id, task_id) VALUES (8, 2, 1, 4)");
//
//            statement.execute("INSERT INTO journal (score, course_id, student_id, task_id) VALUES (10, 1, 2, 1)");
//            statement.execute("INSERT INTO journal (score, course_id, student_id, task_id) VALUES (9, 1, 2, 2)");
//            statement.execute("INSERT INTO journal (score, course_id, student_id, task_id) VALUES (11, 1, 2, 2)");
//            statement.execute("INSERT INTO journal (score, course_id, student_id, task_id) VALUES (12, 2, 3, 1)");
//            statement.execute("INSERT INTO journal (score, course_id, student_id, task_id) VALUES (10, 2, 3, 2)");
//            statement.execute("INSERT INTO journal (score, course_id, student_id, task_id) VALUES (11, 2, 3, 3)");
//            statement.execute("INSERT INTO journal (score, course_id, student_id, task_id) VALUES (8, 2, 3, 4)");
//
//            statement.execute("INSERT INTO journal (score, course_id, student_id, task_id) VALUES (10, 1, 4, 1)");
//            statement.execute("INSERT INTO journal (score, course_id, student_id, task_id) VALUES (9, 1, 4, 2)");
//            statement.execute("INSERT INTO journal (score, course_id, student_id, task_id) VALUES (11, 1, 4, 2)");
//            statement.execute("INSERT INTO journal (score, course_id, student_id, task_id) VALUES (12, 2, 5, 1)");
//            statement.execute("INSERT INTO journal (score, course_id, student_id, task_id) VALUES (10, 2, 5, 2)");
//            statement.execute("INSERT INTO journal (score, course_id, student_id, task_id) VALUES (11, 2, 5, 3)");
//            statement.execute("INSERT INTO journal (score, course_id, student_id, task_id) VALUES (8, 2, 5, 4)");
//            resultSet = statement.executeQuery(SELECT_TRAINER);
//            System.out.println("Trainer");
//            while (resultSet.next()) {
//                System.out.printf("%d, %s, %s, %d\n", resultSet.getInt("trainer_id"), resultSet.getString("firstname"), resultSet.getString("lastname"), resultSet.getInt("age"));
//            }
//
//            resultSet = statement.executeQuery(SELECT_STUDENT);
//            System.out.println("Student");
//            while (resultSet.next()) {
//                System.out.printf("%d, %s, %s, %d\n", resultSet.getInt("student_id"), resultSet.getString("firstname"), resultSet.getString("lastname"), resultSet.getInt("age"));
//            }

//            resultSet = statement.executeQuery(SELECT_COURSE);
//            while (resultSet.next()) {
//                System.out.printf("Course: %d\n", resultSet.getInt("course_id"));
//                System.out.println(resultSet.getString("name"));
//                System.out.println(resultSet.getString("description"));
//                System.out.printf("Trainer: %s, %s, %d\n",resultSet.getString("firstname"), resultSet.getString("lastname"), resultSet.getInt("age"));
//                System.out.printf("Period: from %s, to %s\n", resultSet.getString("data_start"), resultSet.getString("data_end") );
//                System.out.printf("Days of the week: %s\n\n", resultSet.getString("daysOfWeek"));
//            }

//           resultSet = statement.executeQuery(SELECT_STUDENT_COURSE);
//           while (resultSet.next()) {
//                System.out.printf("Student: ID-%d, %s %s\n", resultSet.getInt("student_id"), resultSet.getString("firstname"), resultSet.getString("lastname"));
//            }

            resultSet = statement.executeQuery(JOURNAL);
            int studentId = 0;
            while (resultSet.next()) {
                if (studentId != resultSet.getInt("student_id")) {
                    System.out.printf("Student: ID-%d, %s %s\n", resultSet.getInt("student_id"), resultSet.getString("firstname"), resultSet.getString("lastname"));
                    studentId = resultSet.getInt("student_id");
                }
                System.out.printf("%s: score %d\n", resultSet.getString("task_name"), resultSet.getInt("score"));
            }

//            List<String> myList = new ArrayList();
//            statement.execute(SELECT_STUDENT_COURSE);
//            resultSet = statement.getResultSet();
//            while (resultSet.next()) {
//                System.out.println();
//            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

    }

}
