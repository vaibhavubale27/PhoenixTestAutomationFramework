package com.api.tests;

import static io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.api.pojo.UserCredentials;

import io.restassured.module.jsv.JsonSchemaValidator;


public class LoginAPITest {
	
	@Test
	public void loginAPITest() {
		
		//Rest Assured code
		
		UserCredentials userCredentials=new UserCredentials("iamfd","password");
		
		given()
			  .baseUri("http://64.227.160.186:9000/v1")
			.and()
			.contentType(JSON)
			.and()
			.accept(JSON)
			.and()
			  .body(userCredentials)
			.log().uri()
			.log().headers()
			.log().method()
			.log().body()
		.when()
			.post("login")
		.then()
			.log().all()
			.statusCode(200)
			.time(lessThan(1200L))
			.and()
			.body("message", equalTo("Success"))
			.and()
			.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("response-schema/LoginResponseSchema.json"))
			;
		
		
	}

}
