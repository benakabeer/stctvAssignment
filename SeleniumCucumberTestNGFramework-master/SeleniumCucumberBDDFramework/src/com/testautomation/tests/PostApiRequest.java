package com.testautomation.tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class PostApiRequest {
	
	@SuppressWarnings("unchecked")
	@Test
	public void createBooking(){
		
		//prepare request body
		JSONObject device = new JSONObject();
		JSONObject deviceDates = new JSONObject();
		
		device.put("name", "Apple Max Pro 1TB");
		device.put("deviceDates", deviceDates);
		deviceDates.put("year", "2023");
		deviceDates.put("price", "7999.99");
		deviceDates.put("CPU model", "Apple ARM A7");
		deviceDates.put("Hard disk size", "1 TB");
		
		
		Response response =
		RestAssured
				.given()
					.contentType(ContentType.JSON)
					.body(device.toString())
					.baseUri("https://api.restful-api.dev/objects")
				.when()
					.post()
				.then()
					.assertThat()
					.statusCode(200)
				    .extract()
					.response();
		
		int deviceId = response.path("id");
		
		RestAssured
				.given()
					.contentType(ContentType.JSON)
					.pathParam("id", deviceId)
					.baseUri("https://api.restful-api.dev/objects")
				.when()
					.get("{id}")
				.then()
					.assertThat()
					.statusCode(200)
					.body("id", Matchers.notNullValue())
					.body("createdAt", Matchers.notNullValue())
					.body("name", Matchers.equalTo("Apple Max Pro 1TB"))
					.body("createdAt", Matchers.equalTo("2021-06-05T13:36:56.161+00:00"))
					.body("data.year", Matchers.equalTo("2023"))
					.body("data.price", Matchers.equalTo("7999.99"))
					.body("data.CPU model", Matchers.equalTo("Apple ARM A"))
					.body("data.Hard disk size", Matchers.equalTo("1 TB"));
	}

}

