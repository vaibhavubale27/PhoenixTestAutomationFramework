package com.api.tests;

import static io.restassured.RestAssured.*;
import java.io.IOException;
import org.testng.annotations.Test;
import static com.api.constants.Role.*;
import static com.api.utils.SpecUtil.*;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class UserDetailsAPITest {
	
	@Test(description = "Verify if the Userdetails API response is shown correctly", groups = {"api","smoke","regression"})
	public void UserDetailsAPITest() throws IOException  {
		
		given()
		 	 .spec(requestSpecWithAuthinticationToken(FD))
		.when()
			.get("userdetails")
		.then()
			.spec(responseSpec_OK())
			.body(matchesJsonSchemaInClasspath("response-schema/UserDetailsResponseSchema.json"));
			
		
		
	}

}
