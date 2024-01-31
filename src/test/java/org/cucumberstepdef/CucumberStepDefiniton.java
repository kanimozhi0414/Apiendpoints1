package org.cucumberstepdef;

import org.apibaseclass.ApiBaseClass;
import org.json.simple.JSONObject;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class CucumberStepDefiniton extends ApiBaseClass
{
	Response response;
	// Get Request Query param
	@Given("User should enter the base uri {string} and create requestObject for Get Request Query param")
	public void user_should_enter_the_base_uri_and_create_request_object_for_get_request_query_param(String uri) 
	{
		requestObject(uri);
	}
	
	@When("User should add the Headers and Query param for Get Request Query param")
	public void user_should_add_the_headers_and_query_param_for_get_request_query_param() 
	{
	   addHeader("Content-Type", "application/json");
	   addQueryParam("page", "2");
	}
	
	@When("User should get the requestObject for request method {string} Get Request Query param")
	public void user_should_get_the_request_object_for_request_method_get_request_query_param(String reqType) 
	{
		 response = responseObject(reqType, "/api/users");
	}
	
	@Then("User should validate response code {int} for Get Request Query param")
	public void user_should_validate_response_code_for_get_request_query_param(Integer expected)
	{
	  responseBody(response);
	  validationWithAssert(response, expected);
	}

	//Get Request Path param
	
	@Given("User should enter the base uri {string} and create requestObject for Get Request path param")
	public void user_should_enter_the_base_uri_and_create_request_object_for_get_request_path_param(String uri)
	{
	  requestObject(uri);
	}
	
	@When("User should add the Headers and Path param for Get Request path param")
	public void user_should_add_the_headers_and_path_param_for_get_request_path_param() 
	{
		addHeader("Content-Type", "application/json");
		addPathParam("page", "2");
	}
	
	@When("User should get the requestObject for request method {string} Get Request path param")
	public void user_should_get_the_request_object_for_request_method_get_request_path_param(String reqType)
	{
		response = responseObject(reqType, "/api/users/{page}");
	}
	
	@Then("User should validate response code {int} for Get Request path param")
	public void user_should_validate_response_code_for_get_request_path_param(Integer expected)
	{
		responseBody(response);
		validationWithAssert(response, expected);   
	}

	//Post Request 
	
	@Given("User should enter the base uri {string} and create requestObject for Post Request")
	public void user_should_enter_the_base_uri_and_create_request_object_for_post_request(String uri) 
	{
		requestObject(uri);
	}
	
	@When("User should add the Headers for Post Request")
	public void user_should_add_the_headers_for_post_request()
	{
		addHeader("Content-Type", "application/json");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "kani");
		jsonObject.put("job", "it");
		jsonObject.put("status", "active");
		requestSpecification.body(jsonObject.toString());
	}
	
	@When("User should get the requestObject for request method {string} Post Request")
	public void user_should_get_the_request_object_for_request_method_post_request(String reqType)
	{
		response = responseObject(reqType, "/api/users");
	}
	
	@Then("User should validate response code {int} for Post Request")
	public void user_should_validate_response_code_for_post_request(Integer expected) 
	{
		responseBody(response);
		validationWithAssert(response, expected);   
	}

	// Put Request 

	@Given("User should enter the base uri {string} and create requestObject for Put Request")
	public void user_should_enter_the_base_uri_and_create_request_object_for_put_request(String uri)
	{
		requestObject(uri); 
	}
	
	@When("User should add the Headers and path param for Put Request")
	public void user_should_add_the_headers_and_path_param_for_put_request() 
	{
		addHeader("Content-Type", "application/json");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", "kani");
		jsonObject.put("job", "it");
		jsonObject.put("status", "active");
		requestSpecification.body(jsonObject.toString());
		requestSpecification.pathParam("page", "2");
	}
	
	@When("User should get the requestObject for request method {string} Put Request")
	public void user_should_get_the_request_object_for_request_method_put_request(String reqType)
	{
		response = responseObject(reqType, "/api/users/{page}");
	}
	
	@Then("User should validate response code {int} for Put Request")
	public void user_should_validate_response_code_for_put_request(Integer expected)
	{
		responseBody(response);
		validationWithAssert(response, expected); 
	}

	//Delete Request
	
	@Given("User should enter the base uri {string} and create requestObject for Delete Request")
	public void user_should_enter_the_base_uri_and_create_request_object_for_delete_request(String uri) 
	{
		requestObject(uri);
	}
	
	@When("User should add the Headers and Query param for Delete Request")
	public void user_should_add_the_headers_and_query_param_for_delete_request() 
	{
		addHeader("Content-Type", "application/json");
		addQueryParam("page", "2");
	}
	
	@When("User should get the requestObject for request method {string} Delete Request")
	public void user_should_get_the_request_object_for_request_method_delete_request(String reqType) 
	{
	  response = responseObject(reqType, "/api/users");
	}
	
	@Then("User should validate response code {int} for Delete Request")
	public void user_should_validate_response_code_for_delete_request(Integer expected) 
	{
		responseBody(response);
		validationWithAssert(response, expected); 
	}










}
