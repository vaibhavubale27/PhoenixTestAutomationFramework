package com.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.api.utils.ConfigManager;

import groovy.transform.Synchronized;

public class DatabaseManagerOld {
	private static final String DB_URL = ConfigManager.getProperty("DB_URL");
	private static final String DB_USER_NAME = ConfigManager.getProperty("DB_USER_NAME");
	private static final String PASSWORD = ConfigManager.getProperty("PASSWORD");
	private volatile static Connection conn; // Any update happened to this conn variable.
	// All the threads will be aware about it.

	private DatabaseManagerOld() {

	}

	public static void createConnection() throws SQLException, IOException  {
		
		if(conn==null) { // first check which all the parallel threads will enter
			synchronized (DatabaseManagerOld.class) {
				if(conn==null) {
		          conn = DriverManager.getConnection(DB_URL, DB_USER_NAME, PASSWORD);
				}
		    
			}
		
		}
		System.out.println(conn);
		}

}
