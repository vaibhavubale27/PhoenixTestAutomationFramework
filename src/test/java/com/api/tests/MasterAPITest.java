package com.api.tests;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static com.api.constants.Role.*;
import static com.api.utils.AuthTokenProvider.*;
import static com.api.utils.ConfigManager.*;

import static io.restassured.http.ContentType.*;

import static io.restassured.RestAssured.*;

import java.io.IOException;

public class MasterAPITest {
	
	@Test
	public void masterAPITest() throws IOException {
		
		given()
			.baseUri(getProperty("BASE_URI"))
			.and()
			.header("Authorization",tokenProvider(FD))
			.and()
			.contentType("")  //whenever the body in post request is empty, the default content type is  application-url/formencoded
		.when()
			.post("master")
		.then()
			.statusCode(200)
			.log().all()
			.time(lessThan(1000L))
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
		    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("response-schema\\MasterAPIResponseSchema.json"));
		
	}
	
	@Test
	public void masterAPINegativeTest() throws IOException {
		given()
			.baseUri(getProperty("BASE_URI"))
			.header("Authorization","")
			.contentType("")
		.when()
			.post("master")
		.then()
			.statusCode(401);
		
	}

}
