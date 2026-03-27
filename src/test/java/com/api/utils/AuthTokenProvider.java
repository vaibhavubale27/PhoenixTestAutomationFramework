package com.api.utils;

import static io.restassured.RestAssured.*;

import static com.api.utils.ConfigManager.*;

import java.io.IOException;

import static org.hamcrest.Matchers.*;

import static com.api.constants.Role.*;

import com.api.constants.Role;
import com.api.pojo.UserCredentials;

import static io.restassured.http.ContentType.*;

public class AuthTokenProvider {
	
	private AuthTokenProvider() {
		
	}
	
	public static String tokenProvider(Role role) throws IOException {
		// I want to make the request for the login API and we want to extract the token and print in the console
		String token;
		
		UserCredentials userCredentials = null;
		
		if(role == FD) {
			userCredentials=new UserCredentials("iamfd","password");
		}
		else if(role == SUP) {
			userCredentials=new UserCredentials("iamsup","password");
		}
		else if(role == ENG) {
			userCredentials=new UserCredentials("iameng","password");
		}
		else if(role == QC) {
			userCredentials=new UserCredentials("iamqc","password");
		}
		
  token = given()
			.baseUri(getProperty("BASE_URI"))
			.contentType(JSON)
			.accept(ANY)
			.body(userCredentials)
		.when()
			.post("login")
		.then()
			.statusCode(200)
			.body("message", equalTo("Success"))
			.log().ifValidationFails()
			.extract()
			.body()
			.jsonPath()
			.getString("data.token");
        
        return token;
  
  
		
		
	}

}
