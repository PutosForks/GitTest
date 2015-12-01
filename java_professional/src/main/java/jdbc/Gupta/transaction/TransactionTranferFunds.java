package jdbc.Gupta.transaction;


import jdbc.DbConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionTranferFunds {

    public static void main(String[] args) {
        try (
                Connection c = DbConnector.connectToDb();
                Statement s = c.createStatement();
        ) {
            int result = s.executeUpdate("delete from transaction");
            System.out.println(result);

            result = s.executeUpdate
            ("INSERT INTO transaction VALUES " +
                    " (2, '7777', 'cr', 55.0, to_date('01.01.2012', 'DD.MM.YYYY'))");

            System.out.println(result);

            result = s.executeUpdate
                    ("INSERT INTO transaction VALUES " +
                            " (1, '5555', 'db', 55.0, to_date('01.03.2012', 'DD.MM.YYYY'))");

            System.out.println(result);

        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

}
