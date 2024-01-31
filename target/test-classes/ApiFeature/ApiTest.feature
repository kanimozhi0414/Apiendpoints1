Feature: Api Request methods validation

Scenario: Api Get Request for Query param
Given  User should enter the base uri "https://reqres.in" and create requestObject for Get Request Query param
When  User should add the Headers and Query param for Get Request Query param
And User should get the requestObject for request method "GET" Get Request Query param
Then User should validate response code 200 for Get Request Query param

Scenario: Api Get Request for path param
Given  User should enter the base uri "https://reqres.in" and create requestObject for Get Request path param
When  User should add the Headers and Path param for Get Request path param
And User should get the requestObject for request method "GET" Get Request path param
Then User should validate response code 200 for Get Request path param


Scenario: Api Post Request
Given  User should enter the base uri "https://reqres.in" and create requestObject for Post Request
When  User should add the Headers for Post Request 
And User should get the requestObject for request method "POST" Post Request 
Then User should validate response code 201 for Post Request 

Scenario: Api Put Request
Given  User should enter the base uri "https://reqres.in" and create requestObject for Put Request
When  User should add the Headers and path param for Put Request 
And User should get the requestObject for request method "PUT" Put Request 
Then User should validate response code 200 for Put Request 

Scenario: Api Delete Request
Given  User should enter the base uri "https://reqres.in" and create requestObject for Delete Request
When  User should add the Headers and Query param for Delete Request 
And User should get the requestObject for request method "DELETE" Delete Request 
Then User should validate response code 204 for Delete Request 
