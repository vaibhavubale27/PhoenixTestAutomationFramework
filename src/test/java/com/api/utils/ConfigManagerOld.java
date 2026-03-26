package com.api.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManagerOld                                                                                                                                                                                                                                                                                                                {
	//Write a program to read the properties file from src/test/resources/config.properties file
	
	private ConfigManagerOld(){
		
	}
	
	private static Properties prop=new Properties();
	
	static {
		InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("config/config.properties");
		
		try {
			prop.load(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static String getProperty(String key) throws IOException {
		//Special class in java to read the properties file 
		
	
		
		return prop.getProperty("BASE_URI");
		
		
	}
	

}
