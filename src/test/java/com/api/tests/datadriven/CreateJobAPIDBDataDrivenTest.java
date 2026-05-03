package com.api.tests.datadriven;

import static com.api.constants.Role.FD;
import static io.restassured.RestAssured.given;

import java.io.IOException;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.api.request.model.CreateJobPayload;
import com.dataproviders.api.bean.CreateJobBean;

import static com.api.utils.SpecUtil.*;

import io.restassured.module.jsv.JsonSchemaValidator;

public class CreateJobAPIDBDataDrivenTest {
	
	//private CreateJobBean createJobBean;


	@Test(description = "Verifying the Create Job API Test is able to create inwarrenty job",groups = {"smoke","regression","api","faker"},
			dataProviderClass = com.dataproviders.DataProviderUtils.class,
			dataProvider = "CreateJobAPIDBDataProvider"
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
