package jdbc.Gupta.dml;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.DbConnector;

public class UpdateBook {

    public static void main(String[] args) {
        try (
                Connection c = DbConnector.connectToDb();
                Statement s = c.createStatement()) {

            int ret = s.executeUpdate("update book set author = 'Dominik'");
            
            System.out.println(ret);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(UpdateBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
