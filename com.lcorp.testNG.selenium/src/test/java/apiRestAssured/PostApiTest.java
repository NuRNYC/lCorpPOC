package apiRestAssured;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.hc.core5.http.ContentType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostApiTest {
	public static RequestSpecification httpRequest;
	public static Response response;
	public static JSONObject requestParam;
	public Logger logger;
	String emp_firtName="TestData12345";
	public static HashMap map=new HashMap();
	public static HashMap map1=new HashMap();
	
	
	@SuppressWarnings("unchecked")
	@Test 
	void checkStatusCode() {
		RestAssured.baseURI="https://6143a99bc5b553001717d06a.mockapi.io/testapi/v1/";
		httpRequest=RestAssured.given();
		
		requestParam = new JSONObject();
		requestParam.put("createdAt" , "1631825833");
		requestParam.put("employee_firstname", "TestData12345");
		requestParam.put("employee_lastname", "TestData12345");
		requestParam.put("employee_phonenumbe", "264-783-9453");
		requestParam.put("employee_emaildress", "employee_emaildress 1");
		requestParam.put("citemployee_addressy", "citemployee_addressy 1");
		requestParam.put("stateemployee_dev_level", "stateemployee_dev_level 1");
		requestParam.put("employee_gender", "employee_gender 1");
		requestParam.put("employee_hire_date", "2025-10-31T16:35:45.426Z");
		requestParam.put("employee_onleave", "true");
		//requestParam.put("tech_stack", "[]");
		//requestParam.put("project", "[]");
		
		JSONArray list1= new JSONArray();
		JSONArray list2= new JSONArray();
		
		requestParam.put("tech_stack", list1);
		requestParam.put("project", list2);
		
		//httpRequest.header("Content-type", "application/jason");
		httpRequest.header("Accept-Encoding", "gzip, deflate, br");
		httpRequest.header("accept", "application/json");

		httpRequest.body(requestParam.toJSONString());
		//httpRequest.body(emp_firtName, null)
		//formParams
		response = httpRequest.request(Method.POST,"/Users");
		
		//response = given().contentType(ContentType.APPLICATION_JSON).log().all().body().post();
		String responseBody=response.getBody().asString();
		System.out.println(responseBody);
		//Thread.sleep(5000);

		int statusCode=response.getStatusCode();
		System.out.println("Status Code : "+statusCode);
		Assert.assertEquals(statusCode, 201);
		
	}
	
	@SuppressWarnings("unchecked")
	@Test 
	 void checkStatusCode1() {
		
		 map.put("createdAt", "1631825833");
		 map.put("employee_firstname", "TestData12345");
		 map.put("employee_lastname", "TestData12345");
		 map.put("employee_emaildress", "employee_emaildress 1");
		 map.put("citemployee_addressy", "citemployee_addressy 1");
		 map.put("stateemployee_dev_level", "stateemployee_dev_level 1");
		 map.put("employee_gender", "employee_gender 1");
		 map.put("employee_hire_date", "2025-10-31T16:35:45.426Z");
		 map.put("employee_onleave", "true");
		 JSONArray list1= new JSONArray();
		 JSONArray list2= new JSONArray();
		 map.put("tech_stack", list1);
		 map.put("project", list2);
		    
		RestAssured.baseURI="https://6143a99bc5b553001717d06a.mockapi.io/testapi/v1/";   
		RestAssured.basePath="/Users";
		given()
			.header("Accept-Encoding", "gzip, deflate, br")
			.contentType("application/json")
			.body(map)
		.when()
			.post()
		.then()
			.statusCode(201)
			.log().all();
		
		
	}

}
