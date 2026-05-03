package com.api.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.poiji.bind.Poiji;

public class ExcelReaderUtil3 {
	
	private ExcelReaderUtil3() {
		
	}
	
	public static  <T> Iterator<T> loadExcelData(String filepath, String sheetName,Class<T> clazz) throws IOException {
		//Apache POI library
		
		InputStream inputStream=Thread.currentThread().getContextClassLoader().getResourceAsStream(filepath);
		
		XSSFWorkbook myWorkBook=new XSSFWorkbook(inputStream);
		XSSFSheet mySheet=myWorkBook.getSheet(sheetName);
		
		List<T> datalist=Poiji.fromExcel(mySheet, clazz);
		
		return datalist.iterator();
   }






}
