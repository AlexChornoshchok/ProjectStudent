package academy.itcloud.aleksandr.templ;

import academy.itcloud.aleksandr.jdbc.GetConnection;

import java.sql.SQLException;
import java.sql.Statement;


public class CreateBD extends GetConnection {

    private static final String CREATE_TABLE_TRAINER = "CREATE TABLE trainer (id int AUTO_INCREMENT, " +
            "firstname varchar(50), lastname varchar(50), age int(3), PRIMARY KEY (id))";
    private static final String CREATE_TABLE_STUDENT = "CREATE TABLE student (id int AUTO_INCREMENT, " +
            "firstname varchar(50), lastname varchar(50), age int(3), PRIMARY KEY (id))";
    private static final String CREATE_TABLE_COURSE = "CREATE TABLE course (id int AUTO_INCREMENT, " +
            "name varchar(50), description varchar(50), data_start varchar(10), data_end varchar(10), daysOfWeek varchar(50)," +
            "trainer_id int(2), " +
            "foreign key (trainer_id) references trainer(id), " +
            "PRIMARY KEY (id))";
    private static final String CREATE_TABLE_TASK = "CREATE TABLE task (id int AUTO_INCREMENT," +
            "task varchar(50), " +
            "course_id int(2), foreign key (course_id) references course(id), " +
            " PRIMARY KEY (id))";
    private static final String CREATE_TABLE_COURSE_STUDENT = "CREATE TABLE coursestudent (id int AUTO_INCREMENT," +
            "course_id int(2), student_id, " +
            "foreign key (course_id) references course(id), " +
            "foreign key (student_id) references student(id), " +
            "PRIMARY KEY (id))";
    private static final String CREATE_TABLE_JOURNAL = "CREATE TABLE journal (id int AUTO_INCREMENT," +
            "score int (2)," +
            "course_id int(2), student_id int(2), task_id int(2)" +
            "foreign key (course_id) references course(id), " +
            "foreign key (student_id) references student(id)," +
            "foreign key (task_id) references task(id), " +
            " PRIMARY KEY (id))";
    /// *********** Add

    private static final String ADD_TRAINER1 = "INSERT INTO trainer (firstname, lastname, age) VALUES ('Lev', 'Landou', 110)";
    private static final String ADD_TRAINER2 = "INSERT INTO trainer (firstname, lastname, age) VALUES ('Albert', 'Einstein', 139)";
    private static final String ADD_TRAINER3 = "INSERT INTO trainer (firstname, lastname, age) VALUES ('Bill', 'Gates', 63)";

    private static final String ADD_STUDENT1 = "INSERT INTO student (firstname, lastname, age) VALUES ('Alex', 'Alexandrov', 25)";
    private static final String ADD_STUDENT2 = "INSERT INTO student (firstname, lastname, age) VALUES ('Petr', 'Ptrov', 25)";
    private static final String ADD_STUDENT3 = "INSERT INTO student (firstname, lastname, age) VALUES ('Ivan', 'Ivanov', 25)";

    private static final String ADD_COURSE = "INSERT INTO course (name, description, data_start, data_end, daysOfWeek) VALUES (?,?,?,?,?)";
    /// ************ selekt


    public static void main(String... args) {

        connectDriver();

        try (Statement statement = getConnection().createStatement()) {
//        statement.execute(CREATE_TABLE_TRAINER);
//        statement.execute(CREATE_TABLE_STUDENT);
//        statement.execute(CREATE_TABLE_COURSE);
//        statement.execute(CREATE_TABLE_TASK);
//        statement.execute(CREATE_TABLE_COURSE_STUDENT);
//        statement.execute(CREATE_TABLE_JOURNAL);
//        statement.execute(ADD_TRAINER1);
//        statement.execute(ADD_TRAINER2);
//        statement.execute(ADD_TRAINER3);
//        statement.execute(ADD_STUDENT1);
//        statement.execute(ADD_STUDENT2);
//        statement.execute(ADD_STUDENT3);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
