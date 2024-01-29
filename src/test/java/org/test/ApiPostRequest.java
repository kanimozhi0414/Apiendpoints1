package org.test;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class ApiPostRequest
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

		//4. to add JSON content or payload
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "kani");
		jsonObject.put("job", "it");
		jsonObject.put("status", "active");
		requestSpecification.body(jsonObject.toString());
		
		//5.to mention the request type and get response
		Response response = requestSpecification.request(Method.POST,"/api/users");
		
		//6. to get the response / json content
		String responseBody = response.getBody().asPrettyString();
		System.out.println(responseBody);
		
		//7. to get the response code 
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		
		//8. for verification or validation
		Assert.assertEquals(201, statusCode);
		System.out.println("Assertion completed for given request"+" " + "response code : " +statusCode);
		
	}
}
