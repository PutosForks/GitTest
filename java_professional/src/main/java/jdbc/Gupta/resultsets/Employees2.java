package jdbc.Gupta.resultsets;

import jdbc.Gupta.connection.DbConnector;
import java.sql.*;

public class Employees2 {

    public static void main(String[] args) {
        try (
                Connection connection = DbConnector.connectToDb();
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select *from employees")) {

            int ColNum = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= ColNum; i++) {
                    // since we do not know the column type
                    System.out.print("\t\t" + rs.getObject(i));
                }
                System.out.println("");
                
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
            System.exit(-1);
        }

    }

}
