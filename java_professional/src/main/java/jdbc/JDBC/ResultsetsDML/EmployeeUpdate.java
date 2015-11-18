package jdbc.JDBC.ResultsetsDML;

import jdbc.DbConnector;
import java.sql.*;

public class EmployeeUpdate {

    public static void main(String[] args) {
        try (
                Connection connection = DbConnector.connectToDb();
                Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = statement.executeQuery("select employee_id, first_name, phone_number from employees where first_name like '%Peter%'")) {
            System.out.println("\temployee_id \tfirst_name \tphone");

            // before update
            while (rs.next()) {
                System.out.println(
                        "\t" + rs.getInt("employee_id")
                        + "\t\t" + rs.getString("first_name")
                        + "\t\t" + rs.getString("phone_number"));
            }

            // set CURSOR to first row
            rs.absolute(1);
            // update String
            rs.updateString("phone_number", "999999999");
            // write update to DB
            rs.updateRow();

            System.out.println("After the update");
            System.out.println("\temployee_id \tfirst_name \tphone");
            rs.beforeFirst();

            // before update
            while (rs.next()) {
                System.out.println(
                        "\t" + rs.getInt("employee_id")
                        + "\t\t" + rs.getString("first_name")
                        + "\t\t" + rs.getString("phone_number"));
            }

        } catch (SQLException sqle) {
            System.out.println(sqle);

        }

    }

}
