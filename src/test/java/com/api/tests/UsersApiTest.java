package com.api.tests;

import org.testng.annotations.Test;

import com.api.ApiTestBase;
import com.appium.annotations.FrameworkAnnotation;
import com.appium.enums.AuthorType;
import com.appium.enums.CategoryType;
import com.extent.reports.ExtentLogger;

import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;

public class UsersApiTest extends ApiTestBase {

	@Test(groups = { "SANITY", "BVT", "REGRESSION" })
	@FrameworkAnnotation(author = { AuthorType.RAHUL }, category = { CategoryType.SANITY, CategoryType.BVT,
			CategoryType.REGRESSION })
	public void testGetUser() {
		ExtentLogger.info("Testing Get User API");

		TodosEndpoint usersEndpoint = new TodosEndpoint();

		int userId = 1;
		Response response = usersEndpoint.getTodo(userId);

		response.then().statusCode(200).body("id", equalTo(userId)).body("name", equalTo("John Doe"));

		ExtentLogger.info("Get user API passed");
	}
}
