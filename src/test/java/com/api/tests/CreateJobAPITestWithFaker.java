package com.api.tests;

import static com.api.constants.Role.FD;
import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.constants.Model;
import com.api.constants.OEM;
import com.api.constants.Platform;
import com.api.constants.Problem;
import com.api.constants.Product;
import com.api.constants.Service_Location;
import com.api.constants.Warrenty_Status;
import com.api.request.model.CreateJobPayload;
import com.api.request.model.Customer;
import com.api.request.model.Customer_address;
import com.api.request.model.Customer_product;
import com.api.request.model.Problems;
import com.api.utils.DateTimeUtil;
import com.github.javafaker.Faker;

import static com.api.utils.DateTimeUtil.*;
import static com.api.utils.SpecUtil.*;

import io.restassured.module.jsv.JsonSchemaValidator;

public class CreateJobAPITestWithFaker {
	
	private final static String COUNTRY="India";
	
	private CreateJobPayload createJobPayload;
	
	@BeforeMethod(description = "Creating createjob api request payload")
	public void setup() {
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
		
		String fakeRemark=faker.lorem().sentence(5);
		Random random=new Random();
		int randomProblemId=random.nextInt(26)+1;
		
		Problems problems=new Problems(randomProblemId, fakeRemark);
		
		List<Problems> problemlist=new ArrayList<Problems>();
		problemlist.add(problems);
		
//		Create Job Payload
		
		createJobPayload=new CreateJobPayload(0, 2, 1, 1, customer, customerAddress, customerProduct, problemlist);
		
		
	}

	@Test(description = "Vrifying the Create Job API Test is able to create inwarrenty job",groups = {"smoke","regression","api"})
	public void createJobAPITest() throws IOException {
			
		given()
			.spec(requestSpecWithAuthinticationToken(FD, createJobPayload))
		.when()
			.post("/job/create")
		.then()
			.spec(responseSpec_OK())
			.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("response-schema/CreateJobResponseSchema.json"))
			.body("message", equalTo("Job created successfully. "))
			.body("data.job_number", startsWith("JOB_"))
			.body("data.mst_warrenty_status_id", equalTo(1));
		
	}

}
