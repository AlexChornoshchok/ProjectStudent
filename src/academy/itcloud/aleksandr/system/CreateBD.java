package academy.itcloud.aleksandr.system;

import academy.itcloud.aleksandr.jdbc.GetConnection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CreateBD extends GetConnection {

    private static final String DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:d:/MyJob/student_bd";
    //    private static final String DB_CONNECTION ="jdbc:h2:~test";
    private static final String DB_LOGIN = "";
    private static final String DB_PASSWORD = "";

    private static final String CREATE_TABLE_TRAINER = "CREATE TABLE trainer (id int AUTO_INCREMENT, " +
            "firstname varchar(50), lastname varchar(50), age int(3), PRIMARY KEY (id))";
    private static final String CREATE_TABLE_STUDENT = "CREATE TABLE student (id int AUTO_INCREMENT, " +
            "firstname varchar(50), lastname varchar(50), age int(3), PRIMARY KEY (id))";
    private static final String CREATE_TABLE_COURSE = "CREATE TABLE course (id int AUTO_INCREMENT, " +
            "name varchar(50), description varchar(150), data_start varchar(10), data_end varchar(10), daysOfWeek varchar(50)," +
            "trainer_id int(2), " +
            "foreign key (trainer_id) references trainer(id), " +
            "PRIMARY KEY (id))";
    private static final String CREATE_TABLE_TASK = "CREATE TABLE task (id int AUTO_INCREMENT," +
            "task varchar(50), " +
            "course_id int(2), foreign key (course_id) references course(id), " +
            " PRIMARY KEY (id))";
    private static final String CREATE_TABLE_COURSE_STUDENT = "CREATE TABLE coursestudent (id int AUTO_INCREMENT," +
            "course_id int(2), student_id int(2), " +
            "foreign key (course_id) references course(id), " +
            "foreign key (student_id) references student(id), " +
            "PRIMARY KEY (id))";
    private static final String CREATE_TABLE_JOURNAL = "CREATE TABLE journal (id int AUTO_INCREMENT," +
            "score int(2)," +
            "course_id int(2), student_id int(2), task_id int(2)," +
            "foreign key (course_id) references course(id), " +
            "foreign key (student_id) references student(id)," +
            "foreign key (task_id) references task(id), " +
            "PRIMARY KEY (id))";
    /// *********** Add

    private static final String ADD_TRAINER1 = "INSERT INTO trainer (firstname, lastname, age) VALUES ('Lev', 'Landou', 110)";
    private static final String ADD_TRAINER2 = "INSERT INTO trainer (firstname, lastname, age) VALUES ('Albert', 'Einstein', 139)";
    private static final String ADD_TRAINER3 = "INSERT INTO trainer (firstname, lastname, age) VALUES ('Bill', 'Gates', 63)";

    private static final String ADD_STUDENT1 = "INSERT INTO student (firstname, lastname, age) VALUES ('Alex', 'Alexandrov', 25)";
    private static final String ADD_STUDENT2 = "INSERT INTO student (firstname, lastname, age) VALUES ('Petr', 'Ptrov', 25)";
    private static final String ADD_STUDENT3 = "INSERT INTO student (firstname, lastname, age) VALUES ('Ivan', 'Ivanov', 25)";

    private static final String ADD_COURSE = "INSERT INTO course (name, description, data_start, data_end, daysOfWeek) VALUES (?,?,?,?,?)";

    private static final String SELECT_TRAINER = "SELECT * FROM trainer";
    private static final String SELECT_STUDENT = "SELECT * FROM student";
    private static final String SELECT_COURSE = "SELECT * FROM course";
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
//            statement.execute("INSERT INTO trainer (firstname, lastname, age) VALUES ('Lev', 'Landou', 110)");
//            statement.execute("INSERT INTO trainer (firstname, lastname, age) VALUES ('Albert', 'Einstein', 139)");
//            statement.execute("INSERT INTO trainer (firstname, lastname, age) VALUES ('Bill', 'Gates', 63)");
//            statement.execute("INSERT INTO student (firstname, lastname, age) VALUES ('Alex', 'Alexandrov', 25)");
//            statement.execute("INSERT INTO student (firstname, lastname, age) VALUES ('Petr', 'Ptrov', 23)");
//            statement.execute("INSERT INTO student (firstname, lastname, age) VALUES ('Ivan', 'Ivanov', 24)");
//            statement.execute("INSERT INTO student (firstname, lastname, age) VALUES ('Serg', 'Naznajka', 25)");
//            statement.execute("INSERT INTO student (firstname, lastname, age) VALUES ('Anna', 'Zlata', 29)");
//            statement.execute("INSERT INTO student (firstname, lastname, age) VALUES ('Marry', 'Popyns', 26)");
//            statement.execute("INSERT INTO student (firstname, lastname, age) VALUES ('Olga', 'Pavlova', 21)");
//            statement.execute("INSERT INTO course (name, description, data_start, data_end, daysOfWeek, trainer_id) VALUES " +
//                    "('Basics of programming', 'This is exactly the course that a beginner needs to try his hand at programming'," +
//                    " '2018-02-10', '2018-04-20', 'WEN TUS SUB', 1)");
//            statement.execute("INSERT INTO course (name, description, data_start, data_end, daysOfWeek,  trainer_id) VALUES " +
//                    "('Front End Development', 'Development of the frontend is becoming more popular today, and specialists of this profile are all more necessary.'," +
//                    " '2018-02-10', '2018-04-20', 'WEN TUS SUB', 2)");

//            resultSet = statement.executeQuery(SELECT_TRAINER);
//            System.out.println("Trainer");
//            while (resultSet.next()) {
//                System.out.printf("%d, %s, %s, %d\n", resultSet.getInt("id"), resultSet.getString("firstname"), resultSet.getString("lastname"), resultSet.getInt("age"));
//            }
//
//            resultSet = statement.executeQuery(SELECT_STUDENT);
//            System.out.println("Student");
//            while (resultSet.next()) {
//                System.out.printf("%d, %s, %s, %d\n", resultSet.getInt("id"), resultSet.getString("firstname"), resultSet.getString("lastname"), resultSet.getInt("age"));
//            }
            resultSet = statement.executeQuery(SELECT_COURSE);
//            resultSetTrainer = statement.executeQuery("SELECT * FROM trainer WHERE id=1");

            while (resultSet.next()) {
                System.out.printf("Course: %d\n", resultSet.getInt("id"));
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getString("description"));
//                resultSetTrainer = statement.executeQuery("SELECT * FROM trainer WHERE id=" + resultSet.getInt("trainer_id"));
                System.out.print("Trainer: \n");
//                System.out.printf("%d, %s, %s, %d\n", resultSet.getInt("id"), resultSet.getString("firstname"), resultSet.getString("lastname"), resultSet.getInt("age"));
                System.out.printf("Period: from %s, to %s\n", resultSet.getString("data_start"), resultSet.getString("data_end") );
                System.out.println("Days of the week: " + resultSet.getString("daysOfWeek"));
            }
        } catch (
                SQLException e) {
            e.printStackTrace();
        }

    }

}
