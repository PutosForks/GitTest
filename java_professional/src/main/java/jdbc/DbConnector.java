
package jdbc;

import java.sql.*;

public class DbConnector {

    public static Connection connectToDb() throws SQLException {
        String url = "jdbc:oracle:thin:@comdbtstx:1521:";
        String database = "comodadev";
        String userName = "developer7";
        String password = "marko14";

        return DriverManager.getConnection(url + database, userName, password);

    }
}
