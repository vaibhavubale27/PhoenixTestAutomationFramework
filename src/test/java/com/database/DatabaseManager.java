package com.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.api.utils.ConfigManager;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import groovy.transform.Synchronized;

public class DatabaseManager {
	private static final String DB_URL = ConfigManager.getProperty("DB_URL");
	private static final String DB_USER_NAME = ConfigManager.getProperty("DB_USER_NAME");
	private static final String PASSWORD = ConfigManager.getProperty("PASSWORD");
	private static final int MAXIMUMPOOLSIZE =Integer.parseInt(ConfigManager.getProperty("MAXIMUMPOOLSIZE"));
	private static final int SETMINIMUMIDLE =Integer.parseInt(ConfigManager.getProperty("MINIMUMIDLE"));
	private static final int CONNECTIONTIMEOUT_IN_SEC =Integer.parseInt(ConfigManager.getProperty("CONNECTIONTIMEOUT_IN_SEC"));
	private static final int IDLETIMEOUT_IN_SEC =Integer.parseInt(ConfigManager.getProperty("IDLETIMEOUT_IN_SEC"));
	private static final int MAXLIFETIME_IN_MIN =Integer.parseInt(ConfigManager.getProperty("MAXLIFETIME_IN_MIN"));
	private static final String POOLNAME =ConfigManager.getProperty("POOLNAME");
	private static HikariConfig hikariConfig;
	private static volatile HikariDataSource hikariDataSource;
	
	private static Connection conn=null; // Any update happened to this conn variable.
	// All the threads will be aware about it.

	private DatabaseManager() {

	}

	public static void intializePool() throws SQLException, IOException  {
		
		if(hikariDataSource==null) { // first check which all the parallel threads will enter
			synchronized (DatabaseManager.class) {
				if(hikariDataSource==null) {
					hikariConfig=new HikariConfig();
					hikariConfig.setJdbcUrl(DB_URL);
					hikariConfig.setUsername(DB_USER_NAME);
					hikariConfig.setPassword(PASSWORD);
					hikariConfig.setMaximumPoolSize(MAXIMUMPOOLSIZE);
					hikariConfig.setMinimumIdle(SETMINIMUMIDLE);
					hikariConfig.setConnectionTimeout(CONNECTIONTIMEOUT_IN_SEC*1000);
					hikariConfig.setIdleTimeout(IDLETIMEOUT_IN_SEC*1000);
					hikariConfig.setMaxLifetime(MAXLIFETIME_IN_MIN);
					hikariConfig.setPoolName(POOLNAME);
					
					hikariDataSource=new HikariDataSource(hikariConfig);
				}
		    
			}
		
		}
		//System.out.println(conn);
		

		}
	
	public static  Connection getConnection() throws SQLException, IOException {
		if(hikariDataSource==null) {
			intializePool();
		}
		else if(hikariDataSource.isClosed()) {
			throw new SQLException("HIKARI DATA SOURCE IS CLOSED") ;
		}
		
		
		conn=hikariDataSource.getConnection();
	
		return conn;
		
	}

}
