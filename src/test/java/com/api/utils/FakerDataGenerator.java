package com.api.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import com.api.request.model.CreateJobPayload;
import com.api.request.model.Customer;
import com.api.request.model.Customer_address;
import com.api.request.model.Customer_product;
import com.api.request.model.Problems;
import com.github.javafaker.Faker;

public class FakerDataGenerator {
//Utility class	
	private final static String COUNTRY="India";
	private static Faker faker=new Faker(new Locale("en_IND"));
	private static Random random=new Random();
	private static int MST_SERVICE_LOCATION_ID=0;
	private static int MST_PLATFORM_ID=2;
	private static int MST_WARRENTY_STATUS_ID=1;
	private static int MST_OEM_ID=1;
	private static int PRODUCT_ID=1;
	private static int MST_MODEL_ID=1;
	private static final int VALID_PROBLEM_IDS[]= {1,2,3,4,5,6,7,8,9,10,11,12,15,16,17,19,20,22,24,26,27,28,29};

	
	private FakerDataGenerator() {
		
	}
	
	public static CreateJobPayload generateFakeCreateJobData() {
		
		Customer customer=genrateFakeCustomerData();
		Customer_address customerAddress=generateFakeCustomerAddress();
		Customer_product customerProduct=generateFakeCustomerProduct();
		List<Problems> problemlist=generateFakeProblems();
        CreateJobPayload createJobPayload=new CreateJobPayload(MST_SERVICE_LOCATION_ID, MST_PLATFORM_ID, MST_WARRENTY_STATUS_ID, MST_OEM_ID, customer, customerAddress, customerProduct, problemlist);
				
		return createJobPayload;
	}
	
	public static Iterator<CreateJobPayload> generateFakeCreateJobData(int count) {
		
		List<CreateJobPayload> payloadList=new ArrayList<CreateJobPayload>();
		
		for(int i=1;i<=count;i++) {		
		Customer customer=genrateFakeCustomerData();
		Customer_address customerAddress=generateFakeCustomerAddress();
		Customer_product customerProduct=generateFakeCustomerProduct();
		List<Problems> problemlist=generateFakeProblems();
        CreateJobPayload createJobPayload=new CreateJobPayload(MST_SERVICE_LOCATION_ID, MST_PLATFORM_ID, MST_WARRENTY_STATUS_ID, MST_OEM_ID, customer, customerAddress, customerProduct, problemlist);
        payloadList.add(createJobPayload);
		}	
		return payloadList.iterator();
	}

	private static Customer genrateFakeCustomerData() {
		
		Customer customer=new Customer(
				faker.name().firstName(),
				faker.name().lastName(),
				faker.numerify("9075######"),
				faker.numerify("7789######"),
				faker.internet().emailAddress(),
				faker.internet().emailAddress());
		return customer;
	}
	
	private static Customer_address generateFakeCustomerAddress() {
		
		Customer_address customerAddress=new Customer_address(
				faker.numerify("###"),
				faker.address().streetName(),
				faker.address().streetName(),
				faker.address().streetName(),
				faker.address().city(),
				faker.numerify("######"),
				COUNTRY,
				faker.address().state());	
		return customerAddress;
	}
	
	private static Customer_product generateFakeCustomerProduct() {
		
		String ImeiNo = faker.numerify("###############");
		String dop=DateTimeUtil.getTimeWithDaysAgo(30);
		
		Customer_product customerProduct =new Customer_product(
				dop,
				ImeiNo,
				ImeiNo,
				ImeiNo,
				faker.internet().url(),
				PRODUCT_ID,
				MST_MODEL_ID);
		return customerProduct;
	}
	
	private static List<Problems> generateFakeProblems() {
		
		int count=random.nextInt(3)+1;
		String fakeRemark;
		int randomIndex;
		Problems problems;
		List<Problems> problemlist=new ArrayList<Problems>();
		
		for(int i=1;i<=count;i++) {
		fakeRemark=faker.lorem().sentence(5);
        randomIndex=random.nextInt(VALID_PROBLEM_IDS.length);
        problems=new Problems(VALID_PROBLEM_IDS[randomIndex], fakeRemark);
		problemlist.add(problems);
		}
		return problemlist;
	}


}
