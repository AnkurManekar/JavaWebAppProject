package pr20390946.webapp.rating.PR20390946_webapp_Rating;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectionDone {

	public static Connection  getConnection(){
		 Connection conn = null;
		 String url = "jdbc:mysql://localhost:3306/sys";
		 String uname = "root";
		 String password = "Mysql1999";
	  	  
		  
		  try {
			   Class.forName("com.mysql.cj.jdbc.Driver");
			     conn = DriverManager.getConnection(url, uname, password);
					  
		  } catch (ClassNotFoundException e) {
		   e.printStackTrace();
		  } catch (SQLException e) {
		   e.printStackTrace();
		  }
		  
		  
		  return conn;
	}

}
