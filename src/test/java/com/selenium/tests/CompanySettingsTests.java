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
import com.selenium.base.BaseTestWeb;
import com.selenium.pages.CompanySettingsPage;
import com.driver.utils.TestUtils;

public class CompanySettingsTests extends BaseTestWeb {

	CompanySettingsPage companySettingsPage;
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

		companySettingsPage = new CompanySettingsPage();
		// productsPage = new ProductsPage();
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
	public void UpdateBrokerInfo() throws InterruptedException {
		companySettingsPage.openCompanySettings().enterBrokerName("Test Address").enterBrokerLicense("1122256").enterBrokerAddress("well down ").clickOnsave();
	}

}
