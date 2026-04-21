package com.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.api.utils.ConfigManager;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariCPDemo {

	public static void main(String[] args) throws SQLException {
		
		HikariConfig hikariConfig=new HikariConfig();
		hikariConfig.setJdbcUrl(ConfigManager.getProperty("DB_URL"));
		hikariConfig.setUsername(ConfigManager.getProperty("DB_USER_NAME"));
		hikariConfig.setPassword(ConfigManager.getProperty("PASSWORD"));
		hikariConfig.setMaximumPoolSize(10);
		hikariConfig.setMinimumIdle(2);
		hikariConfig.setConnectionTimeout(10000);
		hikariConfig.setIdleTimeout(10000);
		hikariConfig.setMaxLifetime(180000);
		
		HikariDataSource DS =new HikariDataSource(hikariConfig);
		Connection conn = DS.getConnection();
		System.out.println(conn.toString());
		
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery("Select first_name,last_name,mobile_number from tr_customer");
		
		while(result.next()) {
			System.out.println(result.getString("first_name")+"|");
			System.out.print(result.getString("first_name")+"|");
			System.out.print(result.getString("first_name"));
			
		}
		
		conn.close();

	}

}
