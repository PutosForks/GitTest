/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc.applets;

import jdbc.Gupta.connection.DbConnector;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DropTable extends JApplet implements ActionListener {

    private Connection connection;

    private JList tableList;

    private JButton dropButton;

    public void init() {
        try {
            connection = DbConnector.connectToDb();
        } catch (SQLException connectException) {
            connectException.printStackTrace();
        }

        Container c = getContentPane();
        tableList = new JList();
        loadTables();
        c.add(new JScrollPane(tableList), BorderLayout.EAST);

        dropButton = new JButton("Drop Table");
        dropButton.addActionListener(this);
        c.add(dropButton, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Selected values are: " + tableList.getSelectedValue());
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("DROP TABLE " + tableList.getSelectedValue());
            loadTables();
        } catch (SQLException actionException) {
            JOptionPane.showMessageDialog(null, actionException, null,
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadTables() {
        List<String> v = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("Select *From user_tables");

            while (rs.next()) {
                v.add(rs.getString("TABLE_NAME"));
            }
            rs.close();
        } catch (SQLException e) {
        }
        v.add("acc_acc");
        v.add("acc_add");
        v.add("junk");
        tableList.setListData(v.toArray());
    }
}

/*

 <html>
 <applet code="Drop.class" width=200 height=200>
 </applet>
 </html>

 */
