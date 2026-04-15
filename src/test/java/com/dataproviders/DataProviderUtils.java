package com.dataproviders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.api.request.model.CreateJobPayload;
import com.api.request.model.UserCredentials;
import com.api.utils.CSVReaderUtil;
import com.api.utils.CreateJobBeanMapper;
import com.api.utils.ExcelReaderUtil2;
import com.api.utils.ExcelReaderUtil3;
import com.api.utils.FakerDataGenerator;
import com.api.utils.JsonReaderUtil;
import com.dataproviders.api.bean.CreateJobBean;
import com.dataproviders.api.bean.UserBean;

public class DataProviderUtils {

	@DataProvider(name = "LoginAPIDataProvider",parallel = true)
	public static Iterator<UserBean> loginAPIDataProvider() {
		return CSVReaderUtil.loadCSV("testData/LoginCreds.csv",UserBean.class);
	}
	
	@DataProvider(name = "CreateJobAPIDataProvider",parallel = true)
	public static Iterator<CreateJobPayload> createJobAPIDataProvider() {
		Iterator<CreateJobBean> createJobBeanIterator = CSVReaderUtil.loadCSV("testData/CreateJobData.csv", CreateJobBean.class);
	 
		List<CreateJobPayload> payLoadList = new ArrayList<CreateJobPayload>();
		CreateJobBean tempBean;
		CreateJobPayload tempPayload;
		
		while(createJobBeanIterator.hasNext()) {
			tempBean = createJobBeanIterator.next();
			tempPayload = CreateJobBeanMapper.mapper(tempBean);
			payLoadList.add(tempPayload);
			
		}
		
		return payLoadList.iterator();
	}
	
	@DataProvider(name = "CreateJobAPIFakeDataProvider",parallel = true)
	public static Iterator<CreateJobPayload> CreateJobAPIFakerDataProvider() {
		String fakercount=System.getProperty("fakercount", "5");
		int count=Integer.parseInt(fakercount);
		Iterator<CreateJobPayload> payLoadIterator = FakerDataGenerator.generateFakeCreateJobData(count);
		return payLoadIterator;
	}
	
	@DataProvider(name = "LoginAPIJsonDataProvider",parallel = true)
	public static Iterator<UserCredentials> LoginAPIJsonDataProvider() {
		return JsonReaderUtil.loadJson("testData\\LoginUserDetails.json",UserCredentials[].class);
		
	}
	
	@DataProvider(name = "CreateJobAPIJsonDataProvider",parallel = true)
	public static Iterator<CreateJobPayload> CreateJobAPIJsonrDataProvider() {
		return JsonReaderUtil.loadJson("testData\\CreateJobAPIPayload.json", CreateJobPayload[].class);
	}
	
	@DataProvider(name = "LoginAPIExcelDataProvider",parallel = true)
	public static Iterator<UserBean> LoginAPIExcelDataProvider() throws IOException {
		return ExcelReaderUtil3.loadExcelData("testData\\PhoenixTestData.xlsx","LoginTestData", UserBean.class);
		
	}

}
