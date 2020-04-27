package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resource.TestData;
import resource.Utility;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;


public class ValidatePlace extends Utility {

	TestData data = new TestData();
	RequestSpecification request;
	Response response;
	
	@Given("{string} pay load")
	public void pay_load(String string) throws FileNotFoundException {
	    request = given().spec(requestSpecification()).body(data.addPlacePayload());		
		
	}

	@When("Users make {string} call")
	public void users_make_call(String string) {
	    response = request.when().post("/maps/place/add/json");
	}

	@Then("Verify whether status code is {int}")
	public void verify_whether_status_code_is(Integer expectedCode) {
		response =response.then().spec(responseSpecification()).extract().response();
		assertEquals(response.getStatusCode(),expectedCode);
	}

	@Then("Verify whether {string} in response body is {string}")
	public void verify_whether_in_response_body_is(String key, String expectedValue) {
	    String addPlaceResponse = response.then().extract().asString();
	    JsonPath js = new JsonPath(addPlaceResponse);
	    String actualStatus = js.get("status");
	    assertEquals(actualStatus,expectedValue);
	}

	

}
