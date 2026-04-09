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

public class LoginAPIDataDrivenTest {
	
	

	@Test(description = "Verifying the login API is working forFD User", groups = {"smoke","regression","api"},
			dataProviderClass = com.dataproviders.DataProviderUtils.class,
			dataProvider = "LoginAPIDataProvider"
			)
	public void loginAPITest(UserBean userbean) throws IOException {
		
		//Rest Assured code
			
		given()
	        .spec(requestSpec(userbean))
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
