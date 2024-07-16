package com.api.tests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TodosEndpoint {

	public Response getTodo(int todoId) {
		return given().pathParam("todoId", todoId).when().get("/todos/{todoId}");
	}

	public Response createTodo(int todoId) {
		return given().pathParam("todoId", todoId).when().post("/todos/{todoId}");
	}
}