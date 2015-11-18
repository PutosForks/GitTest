
package jdbc.JDBC.Oracle_Connect;

import java.sql.*;

// The class attempts to acquire a connection with the database
class DbConnect {
  	public static void main(String[] args) {
  		// url points to jdbc protocol : mysql subprotocol; localhost is the address 
  		// of the server where we installed our DBMS (i.e. on local machine) and 
  		// 3306 is the port on which we need to contact our DBMS
  		String url = "jdbc:oracle:thin:@localhost:1521:";
  		// we are connecting to the addressBook database we created earlier 
		String database = "XE";
		// we login as "hr_remote" user with password "hr" 
	  	String userName = "hr_remote"; 
	  	String password = "hr";
	  	try (Connection connection = DriverManager.getConnection
(url + database, userName, password)){
	  		System.out.println("Database connection: Successful");
	  	} catch (Exception e) {
	  		System.out.println("Database connection: Failed");
		  	e.printStackTrace();
	  	}
  	}
} 
