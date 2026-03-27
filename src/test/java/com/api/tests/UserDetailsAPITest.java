package com.api.tests;

import static io.restassured.RestAssured.*;

import static io.restassured.http.ContentType.*;

import static org.hamcrest.Matchers.*;

import java.io.IOException;

import org.testng.annotations.Test;

import com.api.constants.Role;

import static com.api.utils.AuthTokenProvider.*;

import static com.api.utils.ConfigManager.*;

import io.restassured.http.Header;
import io.restassured.module.jsv.JsonSchemaValidator;

public class UserDetailsAPITest {
	
	@Test
	public void UserDetailsAPITest() throws IOException {
		
		Header authHeader=new Header("Authorization",tokenProvider(Role.SUP));
		
		given()
			.baseUri(getProperty("BASE_URI"))
			.header(authHeader)
			.contentType(JSON)
			.and()
			.accept(JSON)
		.when()
			.get("userdetails")
		.then()
			.log().all()
			.time(lessThan(1200L))
			.statusCode(200)
			.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("response-schema/UserDetailsResponseSchema.json"));
			
		
		
	}

}
