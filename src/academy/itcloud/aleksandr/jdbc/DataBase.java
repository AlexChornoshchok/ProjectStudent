package academy.itcloud.aleksandr.jdbc;

import java.sql.*;

public class DataBase {

    private static final String DB_CONNECTION = "jdbc:h2:d:/ITCloud/AlexChernochshok/test";
    //    private static final String DB_CONNECTION ="jdbc:h2:~test";
    private static final String DB_LOGIN = "";
    private static final String DB_PASSWORD = "";
    private static final String CREATE_TABLE_TRAINER = "CREATE TABLE trainer (id int AUTO_INCREMENT, " +
            "firstname varchar(50), lastname varchar(50), age int(3), PRIMARY KEY (id))";
    private static final String CREATE_TABLE_STUDENT = "CREATE TABLE student (id int AUTO_INCREMENT, " +
            "firstname varchar(50), lastname varchar(50), age int(3), PRIMARY KEY (id))";
    private static final String CREATE_TABLE_COURSE = "CREATE TABLE course (id int AUTO_INCREMENT, " +
            "name varchar(50), description varchar(50), data_start varchar(10), data_end varchar(10), daysOfWeek varchar(50)," +
            "trainer_id int(2), " +
            "foreign key (trainer_id) references trainer(id), " +
            "PRIMARY KEY (id))";
    private static final String CREATE_TABLE_JOURNAL = "CREATE TABLE journal (id int AUTO_INCREMENT," +
            "task varchar(50), score int (2)," +
            "course_id int(2), student_id int(2)," +
            "foreign key (course_id) references course(id), " +
            "foreign key (student_id) references student(id), PRIMARY KEY (id))";
    /// *********** Add
    private static final String ADD_TRAINER = "INSERT INTO trainer " +
            "(firstname, lastname, age) " +
            "VALUES (?, ?, ?)";

    private static final String ADD_TRAINER1 = "INSERT INTO trainer (firstname, lastname, age) VALUES ('Lev', 'Landou', 110)";
    private static final String ADD_TRAINER2 = "INSERT INTO trainer (firstname, lastname, age) VALUES ('Albert', 'Einstein', 139)";
    private static final String ADD_TRAINER3 = "INSERT INTO trainer (firstname, lastname, age) VALUES ('Bill', 'Gates', 63)";

    private static final String ADD_SDUTENT1 = "INSERT INTO student (firstname, lastname, age) VALUES ('Alex', 'Alexandrov', 25)";
    private static final String ADD_SDUTENT2 = "INSERT INTO student (firstname, lastname, age) VALUES ('Petr', 'Ptrov', 25)";
    private static final String ADD_SDUTENT3 = "INSERT INTO student (firstname, lastname, age) VALUES ('Ivan', 'Ivanov', 25)";
    /// ************ selekt
    private static final String SELECT_TRAINER = "SELECT * FROM trainer";
    private static final String SELECT_STUDENT = "SELECT * FROM student";
    private static final String SELECT_COURSE = "SELECT * FROM course";

    public static Connection getConnect(){
        try {
           return DriverManager.getConnection(DB_CONNECTION, DB_LOGIN, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void connectDriver(){
        try {
            Class.forName("org.h2.Driver").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String... arg)   {


        Statement statement = null;
        try {
            //        statement.execute(CREATE_TABLE_TRAINER);
//        statement.execute(CREATE_TABLE_STUDENT);
//        statement.execute(CREATE_TABLE_COURSE);
//        statement.execute(CREATE_TABLE_JOURNAL);
//        statement.execute(ADD_TRAINER1);
//        statement.execute(ADD_TRAINER2);
//        statement.execute(ADD_TRAINER3);
//        statement.execute(ADD_SDUTENT1);
//        statement.execute(ADD_SDUTENT2);
//        statement.execute(ADD_SDUTENT3);
            statement = getConnect().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        ResultSet resultSet = statement.executeQuery(SELECT_TRAINER);
        System.out.println("Trainer");
        while (resultSet.next()) {
            System.out.print(resultSet.getInt("id") + ", ");
            System.out.print(resultSet.getString("firstname") + ", ");
            System.out.print(resultSet.getString("lastname") + ", ");
            System.out.println(resultSet.getInt("age"));
        }

        System.out.println();

        Statement statement1 = getConnect();
        ResultSet resultSet1 = statement1.executeQuery(SELECT_STUDENT);
        System.out.println("Student");
        while (resultSet1.next()) {
            System.out.print(resultSet1.getInt("id") + ", ");
            System.out.print(resultSet1.getString("firstname") + ", ");
            System.out.print(resultSet1.getString("lastname") + ", ");
            System.out.println(resultSet1.getInt("age"));
        }
    }

}
