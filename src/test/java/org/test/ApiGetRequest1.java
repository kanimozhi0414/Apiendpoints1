package org.test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class ApiGetRequest1
{
	public static void main(String[] args) 
	{
		// 1. to mention the base URI for the request
		RestAssured.baseURI = "https://reqres.in";
		
		// 2. to get the request specification interface
		RequestSpecification requestSpecification = RestAssured.given();
		
		// 3. to mention the content type
		// requestSpecification.contentType("application/json");
		requestSpecification.header("Content-Type","application/json");

		//4. to mention the path/Query parameter
		requestSpecification.pathParam("page", "2");
		
		//5.to mention the request type and get response
		Response response = requestSpecification.request(Method.GET,"/api/users/{page}");
		
		//6. to get the response / json content
		String responseBody = response.getBody().asPrettyString();
		System.out.println(responseBody);
		
		//7. to get the response code 
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		
		//8. for verification or validation
		Assert.assertEquals(200, statusCode);
		System.out.println("Assertion completed for given request"+" " + "response code : " +statusCode);
		
	}
}
