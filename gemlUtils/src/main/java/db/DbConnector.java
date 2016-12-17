package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {

    private static String userName;
    private static String password;
    private static String schema;


    public static void setCredentials(String userName, String password, String schema) {
        DbConnector.userName = userName;
        DbConnector.password = password;
        DbConnector.schema = schema.replace("_", "");

    }


    public static Connection connectToDb() throws SQLException {
        String url = "jdbc:oracle:thin:@myczvl1dl0emldb:1521:" + schema;

        return DriverManager.getConnection(url, userName, password);

    }
}
