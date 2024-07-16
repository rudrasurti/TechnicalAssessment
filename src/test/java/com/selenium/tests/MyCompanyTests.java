/**
 * @author 
 */

/***************************************************/

package com.selenium.tests;

import java.lang.reflect.Method;

import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appium.annotations.FrameworkAnnotation;
import com.appium.enums.AuthorType;
import com.appium.enums.CategoryType;
import com.driver.utils.TestUtils;
import com.selenium.base.BaseTestWeb;
import com.selenium.pages.MyCompanyPage;

public class MyCompanyTests extends BaseTestWeb {

	
	MyCompanyPage myComapnyPage;

	JSONObject loginUsers;

	@AfterClass
	public void afterClass() {
		// closeApp();
		// launchApp();
	}

	@BeforeMethod
	public void beforeMethod(Method method) {

		TestUtils.log().debug("---------------------------------------------------");
		TestUtils.log().debug("******************* Test started: " + method.getName() + "*******************");

		
		myComapnyPage = new MyCompanyPage();
	}

	@AfterMethod
	public void afterMethod(Method method) {
		TestUtils.log().debug("******************* Test ended: " + method.getName() + "*******************");
		TestUtils.log().debug("---------------------------------------------------");
		// closeApp();
		// launchApp();

	}

	@FrameworkAnnotation(author = { AuthorType.RAHUL }, category = { CategoryType.SANITY, CategoryType.BVT,
			CategoryType.REGRESSION })
	@Test(groups = { "SANITY", "BVT", "REGRESSION" })
	public void checkBrokerInfo() throws InterruptedException {
		myComapnyPage.openCompanySettings();
		Thread.sleep(2000);
	}
}
