package jdbc.Gupta.dml;


import jdbc.DbConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class queryTableData {

    public static void main(String[] args) {
        try (
                Connection c = DbConnector.connectToDb();
                Statement s = c.createStatement()) {

            ResultSet r = s.executeQuery("select *From book");

            int cnt = r.getMetaData().getColumnCount();

            for (int i = 1; i <= cnt; i++) {
                System.out.printf("%-15s\t", r.getMetaData().getColumnName(i));
            }

            System.out.println("");
            while (r.next()) {
                for (int i = 1; i <= cnt; i++) {
                    System.out.printf("%-15s\t", r.getString(i));

                }
                System.out.println();
            }

            System.out.println("");

        } catch (SQLException ex) {
            Logger.getLogger(queryTableData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
