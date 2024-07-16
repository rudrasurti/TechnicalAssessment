/**
 * @author 
 */

/***************************************************/

package com.appium.tests;

import static com.appium.constants.FrameworkConstants.EXPECTED_DATA_KEY_HOME_TITLE;
import static com.appium.constants.FrameworkConstants.TEST_DATA_JSON_FILE;
import static com.appium.constants.FrameworkConstants.TEST_DATA_JSON_PASSWORD;
import static com.appium.constants.FrameworkConstants.TEST_DATA_JSON_USERNAME;
import static com.appium.constants.FrameworkConstants.TEST_DATA_JSON_VALID_USER;

import java.lang.reflect.Method;

import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appium.annotations.FrameworkAnnotation;
import com.appium.base.BaseTestMobile;
import com.appium.enums.AuthorType;
import com.appium.enums.CategoryType;
import com.appium.manager.StringsManager;
import com.appium.pages.HomePage;
import com.appium.pages.LoginPage;
import com.driver.utils.JSONUtils;
import com.driver.utils.TestUtils;
import com.driver.utils.VerificationUtils;

public class LoginTests extends BaseTestMobile {

	LoginPage loginPage;
	HomePage homePage;

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

		loginPage = new LoginPage();
		// productsPage = new ProductsPage();
	}

	@AfterMethod
	public void afterMethod(Method method) {
		TestUtils.log().debug("******************* Test ended: " + method.getName() + "*******************");
		TestUtils.log().debug("---------------------------------------------------");
		// closeApp();
		// launchApp();

	}

	@FrameworkAnnotation(author = { AuthorType.RAHUL }, category = { CategoryType.SANITY, CategoryType.BVT, CategoryType.REGRESSION })
	@Test(groups = { "SANITY", "BVT", "REGRESSION" })
	public void successfulLogin() throws InterruptedException {

		JSONObject jsonObject_InvalidUser = new JSONUtils().getJSONObject(TEST_DATA_JSON_FILE).getJSONObject(TEST_DATA_JSON_VALID_USER);

		String username = jsonObject_InvalidUser.getString(TEST_DATA_JSON_USERNAME).toString();
		String password = jsonObject_InvalidUser.getString(TEST_DATA_JSON_PASSWORD).toString();

		homePage = loginPage.enterUsername(username).enterPassword(password).pressLoginBtn();

		loginPage.clickOnSkipQuickProcess();

		String actualHomeTitle = homePage.getTitle();
		String expectedHomeTitle = StringsManager.getStrings().get(EXPECTED_DATA_KEY_HOME_TITLE);

		VerificationUtils.validate(actualHomeTitle, expectedHomeTitle, "Home Title");

	}

}
