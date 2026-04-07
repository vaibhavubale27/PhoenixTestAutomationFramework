package com.demo.csv;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class ReadCSVFile {

	public static void main(String[] args) throws IOException, CsvException {
		//code to read a csv file using java
		
//		File csvFile=new File("C:\\Users\\vaibh\\eclipse-workspace\\PhoenixTestAutomationFramework\\src\\main\\resources\\testData\\LoginCreds.csv");
		
//		FileReader fileReader=new FileReader(csvFile);
		
		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("testData/LoginCreds.csv");
		
		InputStreamReader isr=new InputStreamReader(inputStream);
		
		CSVReader csvReader=new CSVReader(isr); //CSV Reader constructor require Reader
		
		List<String[]> dataList =csvReader.readAll();
		
		for(String [] dt:dataList) {
			System.out.println(dt[0]);
			System.out.println(dt[1]);
		}

	}

}
