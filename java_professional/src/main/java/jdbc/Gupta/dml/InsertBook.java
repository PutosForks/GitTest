package jdbc.Gupta.dml;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.DbConnector;

public class InsertBook {

    public static void main(String[] args) {
        // try with resource - automatically close
        try (Connection c = DbConnector.connectToDb();
             Statement s = c.createStatement()) {
            int ret;

            ret = s.executeUpdate("INSERT INTO book VALUES "
                    + "(1, 'Expert In Java', 'Mantheakis', 2009, 59.9)");

            System.out.println(ret);

        } catch (SQLException ex) {
            Logger.getLogger(InsertBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
