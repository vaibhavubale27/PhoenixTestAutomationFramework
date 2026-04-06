package com.api.tests;

import static com.api.constants.Role.FD;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

import java.io.IOException;

import org.testng.annotations.Test;

import static com.api.utils.SpecUtil.*;

public class CountAPITest {
	
	@Test(description = "Vrifying the Count API is giving correct response or not",groups = {"smoke","regression","api"})
	public void verifyCountAPIResponse() throws IOException {
		given()
			.spec(requestSpecWithAuthinticationToken(FD))
	    .when()
	    	.get("/dashboard/count")
	    .then()
	    	.spec(responseSpec_OK())
	    	.body("data",notNullValue())
	    	.body("data.size()", equalTo(3))
	    	.body("data.count", everyItem(greaterThanOrEqualTo(0)))
			.body("data.label",everyItem(not(blankOrNullString())))
			.body("data.key", containsInAnyOrder("pending_fst_assignment","created_today","pending_for_delivery") )
			.body(matchesJsonSchemaInClasspath("response-schema/CountAPIResponseSchema.json"));
			}
	
	@Test(description = "Vrifying the Count API is giving correct response or not for invalid token",groups = {"negative","smoke","regression","api"})
	public void countAPIRequest_MissingAuthToken() throws IOException {
		  given()
		  	.spec(requestSpec()) //Negative test case: Passing Authorization token null
	  	.when()
	  		.get("/dashboard/count")
	    .then()
	    	.spec(responseSpec_Text(401));
	}

}
