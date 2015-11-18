package jdbc.Gupta.resultsets;

import jdbc.Gupta.connection.DbConnector;
import java.sql.*;

public class Contacts {

    public static void main(String[] args) {
        // try with resource
        try (
        //“Connection” – object which is returned if successfully connected to db
                Connection connection = DbConnector.connectToDb();
        // “Statement” object is created from Connection
                Statement statement = connection.createStatement();
        // "ResultSet" object stores the result of the query
                ResultSet rs = statement.executeQuery("select *From contact")) {

            System.out.println("ID \tfName \tlName \temail \t\tphoneNo");

            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t"
                        + rs.getString("firstName") + "\t"
                        + rs.getString("lastName") + "\t"
                        + rs.getString("email") + "\t"
                        + rs.getString("phoneNo"));
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            System.exit(-1);
        }
    }
}
