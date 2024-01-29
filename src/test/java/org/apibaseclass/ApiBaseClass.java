package org.apibaseclass;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class ApiBaseClass
{
	public static RequestSpecification requestSpecification;
	public static void requestObject(String uri) 
	{
		RestAssured.baseURI = uri;
		requestSpecification = RestAssured.given();
	}
	
	public static void addHeader(String headerName, String headerValue)
	{
		requestSpecification=requestSpecification.header(headerName, headerValue);
	}
	
	public static void addPathParam(String pathparaName, String pathparaValue)
	{
		requestSpecification = requestSpecification.pathParam(pathparaName, pathparaValue);
	}
	
	public static void addQueryParam(String queryparaName, String queryparaValue)
	{
		requestSpecification = requestSpecification.queryParam(queryparaName, queryparaValue);
	}
	
	public static Response responseObject(String requestType, String resource) 
	{
		switch (requestType) 
		{
		case  "GET":    {return requestSpecification.request(Method.GET,resource);}
		case  "PUT":    {return requestSpecification.request(Method.PUT,resource);}
		case "POST":    {return requestSpecification.request(Method.POST,resource);}	
		    default:    {return requestSpecification.request(Method.DELETE,resource);}
		}
	}
	
	public static void responseBody(Response response) 
	{
		String asPrettyString = response.getBody().asPrettyString();
		System.out.println("asPrettyString");
	}
	
	public static void validationWithAssert(Response response,int expected) 
	{
		int statusCode = response.getStatusCode();
		Assert.assertEquals(expected, statusCode);
		System.out.println("Assertion completed for given request"+" " + "response code : " +statusCode);
		
	}
}
