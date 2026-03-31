package com.api.tests;

import static com.api.constants.Role.FD;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.blankOrNullString;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.utils.SpecUtil;

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
