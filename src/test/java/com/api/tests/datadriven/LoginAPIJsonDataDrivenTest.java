package com.api.tests.datadriven;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.request.model.UserCredentials;
import com.dataproviders.api.bean.UserBean;

import static com.api.utils.SpecUtil.*;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class LoginAPIJsonDataDrivenTest {
	
	

	@Test(description = "Verifying the login API is working for FD User", groups = {"smoke","regression","api"},
			dataProviderClass = com.dataproviders.DataProviderUtils.class,
			dataProvider = "LoginAPIJsonDataProvider"
			)
	public void loginAPITest(UserCredentials userCredentials) throws IOException {
		
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
