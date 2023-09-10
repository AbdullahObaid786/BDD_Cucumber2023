package pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePage {
	Connection connect;
	Statement state;
	ResultSet result;
	String columnValue;

	public String getDataFromDb(String columnName) {
		
		try {
			// Set Properties of mysql
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String sqlUrl = "jdbc:mysql://localhost:3306/sep2023";
			String sqlUsername = "root";
			String sqlPassword = "Obaid@2027";
			String sqlQuery = "Select * from users;";
			
			// Create connection to the local database
		  connect = DriverManager.getConnection(sqlUrl, sqlUsername, sqlPassword);
		  
		  // Empower the connection reference variable to execute queries
		  state = connect.createStatement();
		  
		  // Deliver the query
		  result = state.executeQuery(sqlQuery);
		  
		  while(result.next()) {
			  columnValue =  result.getString(columnName);
		  }
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return columnValue;
		
		
		
	}
	
	
	
	
}
