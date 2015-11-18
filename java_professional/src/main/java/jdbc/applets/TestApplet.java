/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.applets;

import java.applet.Applet;
import java.awt.Graphics;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import jdbc.DbConnector;

public class TestApplet extends Applet {

    private Connection conn;
    
    private static int queryCount = 0;

    private Timestamp created = new Timestamp(System.currentTimeMillis());

    public void init() {
        try {
            conn = DbConnector.connectToDb();
        } catch (SQLException e) {
            System.err.println("init(): SQLException: " + e.getMessage());
        }
    }

    public void start() {
        System.out.println("start(): ");
    }

    public void stop() {
        System.out.println("stop(): ");
    }

    public void paint(Graphics g) {
        queryCount++;
        System.out.println("paint(): querying the database " + queryCount);
        int i = 0;
        try {
            Statement stmt = conn.createStatement();
            
            ResultSet rset = stmt.executeQuery("select last_name result from employees");
            while (rset.next()) {
                i+=20;
                g.drawString(rset.getString(1), 10 , i);
            }
            rset.close();
            stmt.close();
        } catch (SQLException e) {
            System.err.println("paint(): SQLException: " + e.getMessage());
        }
    }

    public void destroy() {
        System.out
                .println("destroy(): closing connection for applet created at "
                        + created.toString());
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("destroy: SQLException: " + e.getMessage());
        }
    }
}

//TestApplet.html
/*
 <html>
 <head>
 </head>
 <body>
 <applet code=TestApplet archive=TestApplet.zip width=100 height=50></applet>
 </body>
 </html>

 */
