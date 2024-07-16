package com.api.tests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthEndpoint {

	public void auth() {
		Response r = given().auth().basic("rudra", "pass").post();
		String token = r.jsonPath().getString("apiToken");
	}
}