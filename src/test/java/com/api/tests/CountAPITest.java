package com.api.tests;

import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;
import static com.api.constants.Role.*;
import static com.api.utils.AuthTokenProvider.*;
import static com.api.utils.ConfigManager.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static io.restassured.RestAssured.*;

import java.io.IOException;

public class CountAPITest {
	
	@Test
	public void verifyCountAPIResponse() throws IOException {
		given()
			.baseUri(getProperty("BASE_URI"))
			.and()
			.header("Authorization",tokenProvider(FD))
			.log().uri()
	    .when()
	    	.get("/dashboard/count")
	    .then()
	    	.log().all()
	    	.statusCode(200)
	    	.body("message",equalTo("Success"))
	    	.time(lessThan(1000L))
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
		  	.baseUri(getProperty("BASE_URI"))
		  	.and()
		  	//.header("Authorization",tokenProvider(null))
	  	.when()
	  		.get("/dashboard/count")
	    .then()
	    	.statusCode(401);
	}

}
