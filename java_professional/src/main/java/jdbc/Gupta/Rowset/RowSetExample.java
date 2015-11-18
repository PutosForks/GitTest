package jdbc.Gupta.Rowset;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.RowSetConnector;

public class RowSetExample {

    public static void main(String[] args) {
        RowSetConnector rs = null;
        try {
            rs = new RowSetConnector();
            rs.jdbcRS.setCommand("select last_name, first_name From employees");
            rs.jdbcRS.execute();

            while (rs.jdbcRS.next()) {
                System.out.println(rs.jdbcRS.getString("last_name") + " " + rs.jdbcRS.getString("first_name"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(RowSetExample.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            rs.close();
        }
    }
}
