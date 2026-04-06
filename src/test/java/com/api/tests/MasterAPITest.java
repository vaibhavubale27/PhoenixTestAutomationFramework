package com.api.tests;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import static com.api.utils.SpecUtil.*;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

import static com.api.constants.Role.*;

import static io.restassured.RestAssured.*;

import java.io.IOException;

public class MasterAPITest {
	
	@Test(description = "Vrifying the master API is giving correct response or not",groups = {"smoke","regression","api"})
	public void masterAPITest() throws IOException {
		
		given()
		    .spec(requestSpecWithAuthinticationToken(FD))
			.contentType("")  //whenever the body in post request is empty, the default content type is  application-url/formencoded
		.when()
			.post("master")
		.then()
			.spec(responseSpec_OK())
			.body("message", equalTo("Success"))
			.body("data", notNullValue())
			.body("data",hasKey("mst_model"))
			.body("data", hasKey("map_fst_pincode"))
			.body("$", hasKey("data"))
			.body("data.mst_oem.size()", greaterThan(0))
		    .body("data.mst_oem.size()", equalTo(2))
		    .body("data.mst_model.size()", equalTo(3))
		    .body("data.mst_oem.id",everyItem(notNullValue()))
		    .body("data.mst_oem.name",everyItem(notNullValue()))
		    .body(matchesJsonSchemaInClasspath("response-schema/MasterAPIResponseSchema.json"));
		
	}
	
	@Test(description = "Vrifying the master API is giving correct response or not for invalid token",groups = {"negative","smoke","regression","api"})
	public void masterAPINegativeTest() throws IOException {
		given()
			.spec(requestSpec())
		.when()
			.post("master")
		.then()
			.spec(responseSpec_Text(401));
		
	}

}
