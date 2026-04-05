package com.api.tests;

import static com.api.constants.Role.FD;
import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.api.request.model.CreateJobPayload;
import com.api.request.model.Customer;
import com.api.request.model.Customer_address;
import com.api.request.model.Customer_product;
import com.api.request.model.Problems;
import static com.api.utils.DateTimeUtil.*;
import com.api.utils.SpecUtil;

import io.restassured.module.jsv.JsonSchemaValidator;

public class CreateJobAPITest {

	@Test
	public void createJobAPITest() throws IOException {
			
		Customer customer=new Customer("Jatin", "Shharma", "9897969594", "", "Jatin.Sharma@techwithjatin.com", "Jatin.Sharma@techwithjatin.com");
		Customer_address customer_address=new Customer_address("902","Yashwin Urbo","Pune-Banglore highway","Wakad","Pune","411033","India","Maharashtra");
		Customer_product customer_product=new Customer_product(getTimeWithDaysAgo(10),"99384702977777","99384702977777", "99384702977777",getTimeWithDaysAgo(10),1,1);
		Problems problems=new Problems(1, "Phone is dead");
		List <Problems> problemsList=new ArrayList<Problems>();
		problemsList.add(problems);
		CreateJobPayload createJobPayload=new CreateJobPayload(0, 2, 1, 1, customer , customer_address, customer_product, problemsList);
		given()
			.spec(SpecUtil.requestSpecWithAuthinticationToken(FD, createJobPayload))
		.when()
			.post("/job/create")
		.then()
			.spec(SpecUtil.responseSpec_OK())
			.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("response-schema\\CreateJobResponseSchema.json"))
			.body("message", equalTo("Job created successfully. "))
			.body("data.job_number", startsWith("JOB_"))
			.body("data.mst_warrenty_status_id", equalTo(1));
		
	}

}
