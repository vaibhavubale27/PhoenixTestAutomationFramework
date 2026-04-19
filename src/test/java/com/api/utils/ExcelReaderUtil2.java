package com.api.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.api.request.model.UserCredentials;

public class ExcelReaderUtil2 {
	
	private ExcelReaderUtil2() {
		
	}
	
	public static  Iterator<UserCredentials> loadExcelData(String filepath) throws IOException {
		//Apache POI library
		
		InputStream inputStream=Thread.currentThread().getContextClassLoader().getResourceAsStream(filepath);
		
		XSSFWorkbook myWorkBook=new XSSFWorkbook(inputStream);
		XSSFSheet mySheet=myWorkBook.getSheet("LoginTestData");
		
		
		XSSFCell cellValue;
		
		//----->Read the Excel File and Stored the values in the ArrayList <UserCredentials>
		
		XSSFRow headerRow=mySheet.getRow(0);  //Header row ---> Username and password
		
		int usernameIndex=-1;
		int passwordIndex=-1;
		for(Cell cell:headerRow) {
			if(cell.getStringCellValue().trim().equalsIgnoreCase("username")) {
				usernameIndex=cell.getColumnIndex();
				
			}
			else if(cell.getStringCellValue().trim().equalsIgnoreCase("password")) {
				passwordIndex=cell.getColumnIndex()	;
			}
			
		}
		
		System.out.println(usernameIndex +" "+passwordIndex);
		
		int lastRowIndex=mySheet.getLastRowNum();
		XSSFRow rowData;
		UserCredentials userCredentials=null;
		ArrayList<UserCredentials> userList=new ArrayList<UserCredentials>();
		for(int rowindex=1;rowindex<=lastRowIndex;rowindex++) {
			rowData=mySheet.getRow(rowindex);
			userCredentials=new UserCredentials(rowData.getCell(usernameIndex).toString(),rowData.getCell(passwordIndex).toString());
			userList.add(userCredentials);	
		}
		System.out.println(userList);
		return userList.iterator();
		
		
		
		
		
		
		
	}

}
