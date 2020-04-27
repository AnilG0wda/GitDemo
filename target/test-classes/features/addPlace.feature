Feature: Validate place API 

Scenario: Verify whether new place is added successfully from AddPlaceApi 
	Given "AddPlaceApi" pay load 
	When Users make "POST" call 
	Then  Verify whether status code is 200 
	And  Verify whether "status" in response body is "OK" 
	And  Verify whether "scope" in response body is "APP"