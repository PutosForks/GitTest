package jdbc.Gupta.resultsetsDML;


import jdbc.DbConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertContact {

    public static void main(String[] args) throws SQLException {

        try (
                Connection connection = DbConnector.connectToDb();
                Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = statement.executeQuery("select contact.* From contact")) {

            System.out.println("Before update");

            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t"
                        + rs.getString("firstName") + "\t"
                        + rs.getString("lastName") + "\t"
                        + rs.getString("email") + "\t"
                        + rs.getString("phoneNo"));
            }

            rs.moveToInsertRow();

            rs.updateInt("id", 3);
            rs.updateString("firstName", "Dominik");
            rs.updateString("lastName", "Ziza");
            rs.updateString("email", "dominikmarko@gmail.com");
            rs.updateString("phoneNo", "+381-21-57654");

            rs.insertRow();

            try (
                    ResultSet rs2 = statement.executeQuery("select contact.* From contact")) {

                System.out.println("After insert");

                while (rs2.next()) {
                    System.out.println(rs2.getInt("id") + "\t"
                            + rs2.getString("firstName") + "\t"
                            + rs2.getString("lastName") + "\t"
                            + rs2.getString("email") + "\t"
                            + rs2.getString("phoneNo"));
                }

            } catch (SQLException sqle) {
                System.out.println(sqle);
            }

        }
    }
}
