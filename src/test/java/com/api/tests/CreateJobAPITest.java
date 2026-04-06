package com.api.tests;

import static com.api.constants.Role.FD;
import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import static com.api.utils.DateTimeUtil.*;
import static com.api.utils.SpecUtil.*;

import io.restassured.module.jsv.JsonSchemaValidator;

public class CreateJobAPITest {
	
	private CreateJobPayload createJobPayload;
	
	@BeforeMethod(description = "Creating createjob api request payload")
	public void setup() {
		Customer customer=new Customer("Jatin", "Shharma", "9897969594", "", "Jatin.Sharma@techwithjatin.com", "Jatin.Sharma@techwithjatin.com");
		Customer_address customer_address=new Customer_address("902","Yashwin Urbo","Pune-Banglore highway","Wakad","Pune","411033","India","Maharashtra");
		Customer_product customer_product=new Customer_product(getTimeWithDaysAgo(10),"99374702977770","99374702977770", "99374702977770",getTimeWithDaysAgo(10),Product.NEXUS_2.getCode(),Model.NEXUS_2_BLUE.getCode());
		Problems problems=new Problems(Problem.SMARTPHONE_IS_RUNNING_SLOW.getCode(), "Phone is running too slow");
		List <Problems> problemsList=new ArrayList<Problems>();
		problemsList.add(problems);
		createJobPayload=new CreateJobPayload(Service_Location.SERVICE_LOCATION_A.getCode(), Platform.FRONT_DESK.getCode(), Warrenty_Status.IN_WARRENTY.getCode(), OEM.GOOGLE.getCode(), customer , customer_address, customer_product, problemsList);
		
		
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
