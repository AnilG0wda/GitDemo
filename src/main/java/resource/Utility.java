package resource;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;

public class Utility {
	
	RequestSpecification request;
	ResponseSpecification responseSpec;

	public RequestSpecification requestSpecification() throws FileNotFoundException {
		PrintStream log = new PrintStream(new FileOutputStream("log.txt"));
		request = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addQueryParam("key", "qaclick123").setAccept(ContentType.JSON)
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log)).build();
		return request;
	}
	
	public ResponseSpecification responseSpecification() {
		responseSpec = new ResponseSpecBuilder().expectStatusCode(200).build();
		return responseSpec;
	}
}
