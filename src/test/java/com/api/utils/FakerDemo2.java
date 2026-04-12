package com.api.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import com.api.constants.Model;
import com.api.constants.Product;
import com.api.request.model.CreateJobPayload;
import com.api.request.model.Customer;
import com.api.request.model.Customer_address;
import com.api.request.model.Customer_product;
import com.api.request.model.Problems;
import com.github.javafaker.Faker;

public class FakerDemo2 {
	//we will be using faker library for out of fake test data creatiom..!!
	
	//we will create fake util that that uses faker library!
	
	private final static String COUNTRY="India";
	
	public static void main(String[] args) {
		//Create Job API payload request payload
		//I want to create fake customer object
		
		Faker faker=new Faker(new Locale("en_IND"));  //India specific data

//		Customer
		
		Customer customer=new Customer(
				faker.name().firstName(),
				faker.name().lastName(),
				faker.numerify("9075######"),
				faker.numerify("7789######"),
				faker.internet().emailAddress(),
				faker.internet().emailAddress());
		
//		Customer_address 
		
		Customer_address customerAddress=new Customer_address(
				faker.numerify("###"),
				faker.address().streetName(),
				faker.address().streetName(),
				faker.address().streetName(),
				faker.address().city(),
				faker.numerify("######"),
				COUNTRY,
				faker.address().state());	
		
//		 customer_product
		
		String ImeiNo = faker.numerify("###############");
		String dop=DateTimeUtil.getTimeWithDaysAgo(30);
		int product_id=Product.NEXUS_2.getCode();
		int mst_model_id=Model.NEXUS_2_BLUE.getCode();
		
		Customer_product customerProduct =new Customer_product(
				dop,
				ImeiNo,
				ImeiNo,
				ImeiNo,
				faker.internet().url(),
				product_id,
				mst_model_id);
		
//	    "problems
		
		String fakeRemark=faker.lorem().sentence(20);
		Random random=new Random();
		int randomProblemId=random.nextInt(27)+1;
		
		Problems problems=new Problems(randomProblemId, fakeRemark);
		
		List<Problems> problemlist=new ArrayList<Problems>();
		problemlist.add(problems);
		
//		Create Job Payload
		
		CreateJobPayload createJobPayload=new CreateJobPayload(0, 2, 1, 1, customer, customerAddress, customerProduct, problemlist);
		
		
		
		   }

}
