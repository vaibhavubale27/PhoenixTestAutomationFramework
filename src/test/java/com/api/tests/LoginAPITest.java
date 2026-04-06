package com.api.tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.request.model.UserCredentials;
import static com.api.utils.SpecUtil.*;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class LoginAPITest {
	
	private UserCredentials userCredentials;
	
	@BeforeMethod(description = "This setup block needs to be executed before login API Test, It will create payload for login API")
	public void setUp() {
		userCredentials=new UserCredentials("iamfd","password");
	}
	
	@Test(description = "Verifying the login API is working forFD User", groups = {"smoke","regression","api"})
	public void loginAPITest() throws IOException {
		
		//Rest Assured code
			
		given()
	        .spec(requestSpec(userCredentials))
		.when()
			.post("login")
		.then()
		  	.spec(responseSpec_OK())
		  	.and()
		  	.body("message", equalTo("Success"))
		  	.and()
			.body(matchesJsonSchemaInClasspath("response-schema/LoginResponseSchema.json"));
		
		
	}

}
