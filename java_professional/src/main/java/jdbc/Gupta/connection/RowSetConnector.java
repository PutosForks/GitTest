package jdbc.Gupta.connection;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class RowSetConnector {

    public JdbcRowSet jdbcRS = null;

    public RowSetConnector() throws SQLException {

        // Use RowSetProvider to get the default implementation of RowSetFactory
        RowSetFactory rowSetFactory = RowSetProvider.newFactory();
        //Use RowSetFactory to create an object of JdbcRowSet
        jdbcRS = rowSetFactory.createJdbcRowSet();
        //Call JdbcRowSet’s method setURL to define connection URL
        jdbcRS.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
        /*
         Call JdbcRowSet’s methods setUsername and 
         setPassword to set username and password
         */
        jdbcRS.setUsername("hr_remote");
        jdbcRS.setPassword("hr");
    }

    public void close() {
        try {
            jdbcRS.close();

        } catch (SQLException ex) {
            Logger.getLogger(RowSetConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
