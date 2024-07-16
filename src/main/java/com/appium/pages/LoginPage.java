/**
 * @author 
 */

/***************************************************/

package com.appium.pages;

import com.appium.base.BasePageMobile;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BasePageMobile {

	// @iOSXCUITFindBy(id = "test-Username") -> This id is actually accessibility ID
	// only (We can get it from Appium Inspector)

	@AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
	//@iOSXCUITFindBy(id = "test-Username")
	private MobileElement txtFldUsername;
	private String txtFldUsernameTxt = "Username Textbox";

	@AndroidFindBy(xpath = "(//android.widget.EditText)[2]")
	//@iOSXCUITFindBy(id = "test-Password")
	private MobileElement txtFldPassword;
	private String txtFldPasswordTxt = "Password Textbox";

	@AndroidFindBy(xpath = "//android.widget.Button[@text='LOG IN']")
	//@iOSXCUITFindBy(id = "test-LOGIN")
	private MobileElement btnLogin; 
	private String btnLoginTxt = "Login button";

	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Skip these for now, I want to finish these tasks later.']")
	//@iOSXCUITFindBy(id = "test-LOGIN")
	private MobileElement skipQuickProcess; 
	private String skipQuickProcessText = "Skip Quick Process";

	

	public LoginPage enterUsername(String userName) {
		// txtFldUsername.sendKeys(userName);
		// sendKeys(txtFldUsername, userName);
		sendKeys(txtFldUsername, userName, txtFldUsernameTxt);
		return this;
	}

	public LoginPage enterPassword(String password) {
		// sendKeys(txtFldPassword, password);
		sendKeys(txtFldPassword, password, txtFldPasswordTxt);
		return this;
	}

	public HomePage pressLoginBtn() {
		// click(btnLogin);
		click(btnLogin, btnLoginTxt);
		return new HomePage();
	}

	public HomePage login(String username, String password) {
		enterUsername(username).enterPassword(password).pressLoginBtn();
		return new HomePage();
	}

	public void clickOnSkipQuickProcess() {
		waitForVisibility(skipQuickProcess);
		click(skipQuickProcess, skipQuickProcessText);
	}
}
