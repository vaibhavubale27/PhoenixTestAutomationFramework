package com.api.tests;

import java.util.Iterator;

import com.api.utils.CSVReaderUtil;
import com.dataproviders.api.bean.CreateJobBean;

public class Demo {
	
	public static void main(String [] args) {
		
		Iterator<CreateJobBean> Data = CSVReaderUtil.loadCSV("testData\\CreateJobData.csv", CreateJobBean.class);
		
		while(Data.hasNext()){
			System.out.println(Data.next());
		}
		
	}

}
