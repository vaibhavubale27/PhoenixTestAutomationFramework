package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
	
	public static void main(String[] args) throws SQLException {
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://64.227.160.186:3306/SR_DEV",
				"srdev_ro_automation",
				"Srdev@123");
	   System.out.println("Connection succefull!!");
	   
	   Statement statement = conn.createStatement();
	   
	   ResultSet resultSet = statement.executeQuery("Select first_name,last_name,mobile_number   from tr_customer");

	   while(resultSet.next()) {
		   String firstName=resultSet.getString("first_name");
		   String lastName=resultSet.getString("last_name");
		   String mobilenumber=resultSet.getString("mobile_number");
		   System.out.println(firstName+"|"+lastName+"|"+mobilenumber );
		   
	   }
		
	}

}
