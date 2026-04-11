package com.api.tests.datadriven;

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

public class CreateJobAPIDatadrivenTest {
	
	private CreateJobPayload createJobPayload;


	@Test(description = "Vrifying the Create Job API Test is able to create inwarrenty job",groups = {"smoke","regression","api"},
			dataProviderClass = com.dataproviders.DataProviderUtils.class,
			dataProvider = "CreateJobAPIDataProvider"
			)
	public void createJobAPITest(CreateJobPayload createJobPayload) throws IOException {
			
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
