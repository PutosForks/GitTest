package jdbc.JDBC.Binds;

import jdbc.DbConnector;
import java.sql.*;

public class BindSQL {

    public static void main(String[] args) throws SQLException {

        String query = "select *From employees where first_name = ?";
        try (
                Connection conn = DbConnector.connectToDb();
                PreparedStatement ps = conn.prepareStatement(query)) {

        ps.setString(1, "Peter");        
        ResultSet rs =  ps.executeQuery();
        
        while (rs.next()) {
            System.out.println(
                            "\t" + rs.getString(1)
                            + "\t" + rs.getString(2)
                            + "\t" + rs.getString(3)
                            + "\t" + rs.getString(4));
        }
        
        System.out.println("Second bind and execute");        
        ps.setString(1, "John");
        rs =  ps.executeQuery();
        
        while (rs.next()) {
            System.out.println(
                            "\t" + rs.getString(1)
                            + "\t" + rs.getString(2)
                            + "\t" + rs.getString(3)
                            + "\t" + rs.getString(4));
        }
        
        
        
        
        
        
        
            
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

}
