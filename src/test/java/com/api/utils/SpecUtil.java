package com.api.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static com.api.utils.AuthTokenProvider.*;
import static io.restassured.http.ContentType.*;

import java.io.IOException;

import static org.hamcrest.Matchers.*;

import com.api.constants.Role;
import com.api.pojo.UserCredentials;

import static com.api.utils.ConfigManager.*;

public class SpecUtil {
	
	//This will work for GET DEL http method
	public static RequestSpecification requestSpec() throws IOException {
		 RequestSpecification requestSpecification = new RequestSpecBuilder()
		.setBaseUri(getProperty("BASE_URI"))
		.and()
		.setContentType(JSON)
		.and()
		.setAccept(JSON)
		.and()
		.log(LogDetail.URI)
		.log(LogDetail.HEADERS)
		.log(LogDetail.METHOD)
		.build();
		return requestSpecification;	
	}
	
	//This will work for POST PUT PATCH
	public static RequestSpecification requestSpec(Object userCreds) throws IOException {
		 RequestSpecification requestSpecification = new RequestSpecBuilder()
		.setBaseUri(getProperty("BASE_URI"))
		.and()
		.setContentType(JSON)
		.and()
		.setAccept(JSON)
		.and()
		.setBody(userCreds)
		.and()
		.log(LogDetail.URI)
		.log(LogDetail.HEADERS)
		.log(LogDetail.METHOD)
		.build();
		return requestSpecification;	
	}
	
	public static RequestSpecification requestSpecWithAuthinticationToken(Role role, Object payload) throws IOException {
		 RequestSpecification requestSpecification = new RequestSpecBuilder()
		.setBaseUri(getProperty("BASE_URI"))
		.and()
		.addHeader("Authorization" ,tokenProvider(role))
		.setBody(payload)
		.setContentType(JSON)
		.and()
		.setAccept(JSON)
		.and()
		.log(LogDetail.URI)
		.log(LogDetail.HEADERS)
		.log(LogDetail.METHOD)
		.build();
		return requestSpecification;	
	}
	
	public static RequestSpecification requestSpecWithAuthinticationToken(Role role) throws IOException {
		 RequestSpecification requestSpecification = new RequestSpecBuilder()
		.setBaseUri(getProperty("BASE_URI"))
		.and()
		.addHeader("Authorization" ,tokenProvider(role))
		.setContentType(JSON)
		.and()
		.setAccept(JSON)
		.and()
		.log(LogDetail.URI)
		.log(LogDetail.HEADERS)
		.log(LogDetail.METHOD)
		.build();
		return requestSpecification;	
	}
	
	public static ResponseSpecification responseSpec_OK() {
		ResponseSpecification responseSpecification = new ResponseSpecBuilder()
		.expectContentType(JSON)
		.expectStatusCode(200)
		.expectResponseTime(lessThan(1000L))
		.log(LogDetail.ALL)
		.build();
		
		return responseSpecification;
		}
	
	public static ResponseSpecification responseSpec_JSON(int statusCode) {
		ResponseSpecification responseSpecification = new ResponseSpecBuilder()
		.expectStatusCode(statusCode)
		.expectContentType(JSON)
		.expectResponseTime(lessThan(1000L))
		.log(LogDetail.ALL)
		.build();
		
		return responseSpecification;
		}
	
	public static ResponseSpecification responseSpec_Text(int statusCode) {
		ResponseSpecification responseSpecification = new ResponseSpecBuilder()
		.expectStatusCode(statusCode)
		.expectContentType(HTML)
		.expectResponseTime(lessThan(1000L))
		.log(LogDetail.ALL)
		.build();
		
		return responseSpecification;
		}

}
