package apiRestAssured;
import org.json.simple.JSONObject;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.logging.Logger;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.*;

public class ApiTest {
	public static RequestSpecification hhtpRequest;
	public static Response response;
	public Logger logger;
	
	
	@BeforeClass
	public void setUp() throws InterruptedException {
		logger=Logger.getLogger("UserRestAPI");
		RestAssured.baseURI="https://6143a99bc5b553001717d06a.mockapi.io/testapi/v1/";
		hhtpRequest=RestAssured.given();
		response = hhtpRequest.request(Method.GET,"/Users");
		String responseBody=response.getBody().asString();
		System.out.println(responseBody);
		Thread.sleep(50000);
	}
	
	
	@Test 
	void checkStatusCode() {

		int statusCode=response.getStatusCode();
		System.out.println("Status Code : "+statusCode);
		Assert.assertEquals(statusCode, 200);
		
	}
	
	@Test 
	void checkContentType() {
		String contentType =response.header("Content-type");
		Assert.assertEquals(contentType, "application/json");

	}
	
	
	
	@Test 
	void getDetails() {
		JSONObject request = new JSONObject();
		JSONObject resp = new JSONObject();
		//Response response = RestAssured.get();
		String res= given().
			get("https://6143a99bc5b553001717d06a.mockapi.io/testapi/v1//Users").asString();
		System.out.println(res);
		//then().
		   // statusCode(200);
		   // body();
		    
		//resp = 
			String ss=	given().
		when().
	    	get("https://6143a99bc5b553001717d06a.mockapi.io/testapi/v1//Users").
	    then().
	    	log().body().toString();
			System.out.println(ss);
			
			RestAssured.baseURI="https://6143a99bc5b553001717d06a.mockapi.io/testapi/v1//Users";
			RequestSpecification httpRequest=RestAssured.given();
			Response respp = httpRequest.request(Method.GET);
			String responseBody=respp.getBody().asString();
			System.out.println(responseBody);
		
	}
	
	@Test 
	void getDetails1() {
		JSONObject request = new JSONObject();
		JSONObject resp = new JSONObject();
		//Response response = RestAssured.get();
		
			
			RestAssured.baseURI="https://6143a99bc5b553001717d06a.mockapi.io/testapi/v1/";
			RequestSpecification httpRequest=RestAssured.given();
			Response respp = httpRequest.request(Method.GET,"/Users");
			String responseBody=respp.getBody().asString();
			System.out.println(responseBody);
			
			int statusCode=respp.getStatusCode();
			System.out.println("Status Code : "+statusCode);
			
		//Assert.assertTrue(statusCode.matches("200"), "Respone not matched");
		Assert.assertEquals(statusCode, 200);
		
	}
	
	
	
	@Test 
	void postDetails() {
		JSONObject request = new JSONObject();
		
		request.put("", "");
		
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
		    post("").
		then().
		    statusCode(200);
		
		
	}
	

}
