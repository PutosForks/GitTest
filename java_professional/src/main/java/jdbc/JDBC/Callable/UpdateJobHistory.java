/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.JDBC.Callable;

import java.sql.*;
import java.util.*;
import jdbc.DbConnector;

public class UpdateJobHistory {

    public static void main(String[] args) {

        try (
                Connection conn = DbConnector.connectToDb();
                CallableStatement cs = conn.prepareCall("{call add_job_history(?,?,?,?,?)}")) {

            String FromDate = "2000-11-01";
            String ToDate = "2012-10-20";
            java.sql.Date fd = java.sql.Date.valueOf(FromDate);
            java.sql.Date td = java.sql.Date.valueOf(ToDate);

            cs.setInt(1, 101);
            cs.setDate(2, fd);
            cs.setDate(3, td);
            cs.setString(4, "SA_MAN");
            cs.setInt(5, 50);
            
            cs.executeQuery();

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

    }

}
