
package jdbc.Gupta.connection;

import java.sql.*;
import java.util.*;

public class DbConnector {

    public static Connection connectToDb() throws SQLException {
        //String url = "jdbc:oracle:thin:@comdbtstx:1521:";
        //String database = "comodadev";
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        Properties prop = new Properties();
        prop.put("user", "hr_remote");
        prop.put("password", "hr");

        String userName = "developer5";
        String password = "tomas32";

        return DriverManager.getConnection(url, prop);

    }
}
