package jdbc.Gupta.resultsets;

import jdbc.Gupta.connection.DbConnector;
import java.sql.*;

public class Employees {

    public static void main(String[] args) {
        try (
                Connection connection = DbConnector.connectToDb();
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select *from employees")) {

            System.out.println("\t\temployee_id \t\tfirst_name \t\tlast_name \t\temail \t\tphone_number \t\thire_date \t\tjob_id \t\tsalary \t\tcommission_pct \t\tmanager_id \t\tdepartment_id");
            while (rs.next()) {
                System.out.println(
                          "\t\t" + rs.getInt(1)
                        + "\t\t" + rs.getString(2)
                        + "\t\t" + rs.getString(3)
                        + "\t\t" + rs.getString(4)
                        + "\t\t" + rs.getString(5)
                        + "\t" + rs.getDate(6)
                        + "\t" + rs.getString(7)
                        + "\t" + rs.getDouble(8)
                        + "\t" + rs.getDouble(9)
                        + "\t" + rs.getDouble(10)
                        + "\t" + rs.getDouble(11));
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            System.exit(-1);
        }

    }

}
