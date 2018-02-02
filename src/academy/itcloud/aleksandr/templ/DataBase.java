package academy.itcloud.aleksandr.templ;

import java.sql.*;

public class DataBase {

    private static final String DB_CONNECTION = "jdbc:h2:d:/ITCloud/AlexChernochshok/test";
    //    private static final String DB_CONNECTION ="jdbc:h2:~test";
    private static final String DB_LOGIN = "";
    private static final String DB_PASSWORD = "";
    /// *********** Add
    private static final String ADD_TRAINER = "INSERT INTO trainer (firstname, lastname, age) VALUES (?, ?, ?)";
    private static final String ADD_STUDENT = "INSERT INTO student (firstname, lastname, age) VALUES (?, ?, ?)";


    private static final String ADD_TRAINER1 = "INSERT INTO trainer (firstname, lastname, age) VALUES ('Lev', 'Landou', 110)";
    private static final String ADD_TRAINER2 = "INSERT INTO trainer (firstname, lastname, age) VALUES ('Albert', 'Einstein', 139)";
    private static final String ADD_TRAINER3 = "INSERT INTO trainer (firstname, lastname, age) VALUES ('Bill', 'Gates', 63)";

    private static final String ADD_STUDENT1 = "INSERT INTO student (firstname, lastname, age) VALUES ('Alex', 'Alexandrov', 25)";
    private static final String ADD_STUDENT2 = "INSERT INTO student (firstname, lastname, age) VALUES ('Petr', 'Ptrov', 25)";
    private static final String ADD_STUDENT3 = "INSERT INTO student (firstname, lastname, age) VALUES ('Ivan', 'Ivanov', 25)";
    /// ************ selekt
    private static final String SELECT_TRAINER = "SELECT * FROM trainer";
    private static final String SELECT_STUDENT = "SELECT * FROM student";
    private static final String SELECT_COURSE = "SELECT * FROM course";

    public static Connection getConnection(){
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


        try(Statement statement = getConnection().createStatement()) {
            //        statement.execute(CREATE_TABLE_TRAINER);
//        statement.execute(CREATE_TABLE_STUDENT);
//        statement.execute(CREATE_TABLE_COURSE);
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

        try(Statement statement = getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_TRAINER);
            System.out.println("Trainer");
            while (resultSet.next()) {
                System.out.print(resultSet.getInt("id") + ", ");
                System.out.print(resultSet.getString("firstname") + ", ");
                System.out.print(resultSet.getString("lastname") + ", ");
                System.out.println(resultSet.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println();

        Statement statement1 = null;
        try {
            statement1 = getConnection().createStatement();

        ResultSet resultSet1 = statement1.executeQuery(SELECT_STUDENT);
        System.out.println("Student");
        while (resultSet1.next()) {
            System.out.print(resultSet1.getInt("id") + ", ");
            System.out.print(resultSet1.getString("firstname") + ", ");
            System.out.print(resultSet1.getString("lastname") + ", ");
            System.out.println(resultSet1.getInt("age"));
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
