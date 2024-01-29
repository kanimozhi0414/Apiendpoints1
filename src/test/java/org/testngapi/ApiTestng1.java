package org.testngapi;

import org.apibaseclass.ApiBaseClass;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ApiTestng1 extends ApiBaseClass
{
	@Test
	private void case1_GetQueryParam()
	{
		requestObject("https://reqres.in");
		addHeader("Content-Type", "application/json");
		addQueryParam("page","2");
		Response response = responseObject("GET", "/api/users");
		responseBody(response);
		validationWithAssert(response, 200);
		System.out.println("API Testing Completed for GET Query Paramater ***** Case 1 ******");
	}
	
	@Test
	private void case2_GetPathParam() 
	{
		requestObject("https://reqres.in");
		addHeader("Content-Type", "application/json");
		addPathParam("page","2");
		Response response = responseObject("GET", "/api/users/{page}");
		responseBody(response);
		validationWithAssert(response, 200);
		System.out.println("API Testing Completed for GET Path Paramater ***** Case 2 ******");
	}
	
	@Test
	private void case3_PostRequest()
	{
		requestObject("https://reqres.in");
		addHeader("Content-Type", "application/json");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "kani");
		jsonObject.put("job", "it");
		jsonObject.put("status", "active");
		requestSpecification.body(jsonObject.toString());
		Response response = responseObject("POST", "/api/users");
		responseBody(response);
		validationWithAssert(response, 201);
		System.out.println("API Testing Completed for POST Request  ***** Case 3 ******");
	}
	
	@Test
	private void case4_PutRequest() 
	{
		requestObject("https://reqres.in");
		addHeader("Content-Type", "application/json");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "kani");
		jsonObject.put("job", "it");
		jsonObject.put("status", "active");
		requestSpecification.body(jsonObject.toString());
		requestSpecification.pathParam("page", "2");
		Response response = responseObject("PUT", "/api/users/{page}");
		responseBody(response);
		validationWithAssert(response, 200);
		System.out.println("API Testing Completed for PUT Request ***** Case 4 ******");
	}
	
	@Test
	private void case5_DeleteRequest() 
	{
		requestObject("https://reqres.in");
		addHeader("Content-Type", "application/json");
		addPathParam("page","2");
		Response response = responseObject("DELETE", "/api/users/{page}");
		responseBody(response);
		validationWithAssert(response, 204);
		System.out.println("API Testing Completed for DELETE Request  ***** Case 5 ******");


	}
	
}
