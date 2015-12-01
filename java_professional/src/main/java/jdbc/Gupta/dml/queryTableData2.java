package jdbc.Gupta.dml;


import jdbc.DbConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class queryTableData2 {

    public static void main(String[] args) {


    try (Connection c = DbConnector.connectToDb();
         Statement s = c.createStatement();
            )  {

        ResultSet r = s.executeQuery("select id, title, publication_year from Book");

        while (r.next()) {
            System.out.print(r.getInt("id") + "\t");
            System.out.print(r.getString("title") + "\t");
            System.out.print(r.getInt("publication_year") + "\t");
            System.out.println();
        }



    }  catch (SQLException e){
        System.out.print(e.getStackTrace());

    }

    }
}
