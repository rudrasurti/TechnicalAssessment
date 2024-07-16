package com.api;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Set;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.extent.reports.ExtentLogger;
import com.extent.reports.ExtentReport;

import io.restassured.RestAssured;
import io.restassured.filter.FilterContext;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.internal.print.RequestPrinter;
import io.restassured.internal.print.ResponsePrinter;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class ApiTestBase {

	protected static ExtentReports extent;
	protected static ThreadLocal<ExtentTest> testThreadLocal = new ThreadLocal<>();

	@BeforeSuite
	public static void setUp() {
		RestAssured.filters(new ExtentRequestFilter());
		ApiConfig.setUp();
	}

	@AfterSuite
	public static void tearDown() {
		ExtentReport.flushReports();
	}

	public static class ExtentRequestFilter extends RequestLoggingFilter {
		@Override
		public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
				FilterContext ctx) {
			ByteArrayOutputStream baos;
			final String utf8 = StandardCharsets.UTF_8.name();
			PrintStream ps;
			String requestString = "";
			String responseString = "";

			try {
				baos = new ByteArrayOutputStream();
				ps = new PrintStream(baos, true, utf8);
				RequestPrinter.print(requestSpec, requestSpec.getMethod(), requestSpec.getURI(), LogDetail.ALL,
						Set.of(), ps, true);
				String data = baos.toString(utf8);
				requestString = data;
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e);
			}

			Response r = null;
			try {
				ps = new PrintStream(baos, true, utf8);
				baos = new ByteArrayOutputStream();
				ps = new PrintStream(baos, true, utf8);
				r = ctx.next(requestSpec, responseSpec);
				ResponsePrinter.print(r, r, ps, LogDetail.ALL, true, Set.of());
				String data = baos.toString(utf8);
				responseString = data;
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e);
			}
			ExtentLogger.info("Request: \n" + requestString + "\nResponse: \n" + responseString);
			return r;
		}
	}
}