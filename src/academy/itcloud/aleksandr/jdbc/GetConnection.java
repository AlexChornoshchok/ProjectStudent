package academy.itcloud.aleksandr.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class GetConnection {

    private static final String DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:d:/MyJob/student_bd";
    //    private static final String DB_CONNECTION ="jdbc:h2:~test";
    private static final String DB_LOGIN = "";
    private static final String DB_PASSWORD = "";

    public static void connectDriver(){
        try {
            Class.forName(DRIVER).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(DB_CONNECTION, DB_LOGIN, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
