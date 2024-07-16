package com.api;

import io.restassured.RestAssured;

public class ApiConfig {
	public static final String BASE_URI = "https://jsonplaceholder.typicode.com"; // Replace with your API base URL

	public static void setUp() {
		RestAssured.baseURI = BASE_URI;
		// Set common headers, authentication, etc. if needed
	}
}