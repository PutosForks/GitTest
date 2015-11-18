package jdbc.JDBC.ResultsetsDML;

import jdbc.DbConnector;
import java.sql.*;

public class DeleteContact {

    public static void main(String[] args) throws SQLException {

        try (
                Connection connection = DbConnector.connectToDb();
                Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = statement.executeQuery("select contact.* from contact")) {

            System.out.println("Before update");
            while (rs.next()) {
                System.out.println(
                        "\t" + rs.getString(1)
                        + "\t" + rs.getString(2)
                        + "\t" + rs.getString(3)
                        + "\t" + rs.getString(4));
            }

            rs.last();
            rs.deleteRow();

            try (
                    ResultSet rs2 = statement.executeQuery("select contact.* from contact")) {

                System.out.println("After update");
                while (rs2.next()) {
                    System.out.println(
                            "\t" + rs2.getString(1)
                            + "\t" + rs2.getString(2)
                            + "\t" + rs2.getString(3)
                            + "\t" + rs2.getString(4));
                }

            } catch (SQLException sqle) {
                sqle.printStackTrace();
                System.exit(-1);
            }

        }

    }
}
