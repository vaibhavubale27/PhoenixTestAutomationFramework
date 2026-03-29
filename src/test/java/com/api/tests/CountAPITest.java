package com.api.tests;

import org.testng.annotations.Test;

import com.api.utils.SpecUtil;

import static org.hamcrest.Matchers.*;
import static com.api.constants.Role.*;
import static com.api.utils.ConfigManager.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static io.restassured.RestAssured.*;

import java.io.IOException;

public class CountAPITest {
	
	@Test
	public void verifyCountAPIResponse() throws IOException {
		given()
			.spec(SpecUtil.requestSpecWithAuthinticationToken(FD))
	    .when()
	    	.get("/dashboard/count")
	    .then()
	    	.spec(SpecUtil.responseSpec_OK())
	    	.body("data",notNullValue())
	    	.body("data.size()", equalTo(3))
	    	.body("data.count", everyItem(greaterThanOrEqualTo(0)))
			.body("data.label",everyItem(not(blankOrNullString())))
			.body("data.key", containsInAnyOrder("pending_fst_assignment","created_today","pending_for_delivery") )
			.body(matchesJsonSchemaInClasspath("response-schema/CountAPIResponseSchema.json"));
			}
	
	@Test
	public void countAPIRequest_MissingAuthToken() throws IOException {
		  given()
		  	.spec(SpecUtil.requestSpec()) //Negative test case: Passing Authorization token null
	  	.when()
	  		.get("/dashboard/count")
	    .then()
	    	.spec(SpecUtil.responseSpec_Text(401));
	}

}
