package com.api.tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.io.IOException;
import org.testng.annotations.Test;
import static com.api.constants.Role.*;
import com.api.utils.SpecUtil;

import io.restassured.module.jsv.JsonSchemaValidator;

public class UserDetailsAPITest {
	
	@Test
	public void UserDetailsAPITest() throws IOException  {
		
		given()
		 	 .spec(SpecUtil.requestSpecWithAuthinticationToken(FD))
		.when()
			.get("userdetails")
		.then()
			.spec(SpecUtil.responseSpec_OK())
			.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("response-schema/UserDetailsResponseSchema.json"));
			
		
		
	}

}
