package com.api.utils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import com.dataproviders.api.bean.UserBean;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CSVReaderUtil {
	/*
	CSVReader is a utility so
	-All methods inside it are static in nature
	-Job: Help me to Read the CSV file and map it to Bean
	
	
	 */
	
	private CSVReaderUtil() {
		//-The constructor is private so no one can create a object of it
		//-Singleton class constructor are private 
	}
	

	public static Iterator<UserBean> loadCSV(String pathOFCSVFile) {
		
		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(pathOFCSVFile);
		
		InputStreamReader isr=new InputStreamReader(inputStream);
		
		CSVReader csvReader=new CSVReader(isr); //CSV Reader constructor require Reader

		
		CsvToBean<UserBean> csvTobean=new CsvToBeanBuilder(csvReader)
				.withType(UserBean.class)
				.withIgnoreEmptyLine(true)
				.build();
		
		List<UserBean> userList = csvTobean.parse();
		
		//System.out.print(userList);
		
		//Here the Data provider concept came in a picture
		
		return userList.iterator();
		
		
		


	}

}
