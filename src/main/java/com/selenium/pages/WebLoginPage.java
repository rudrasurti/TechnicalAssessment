/**
 * @author 
 */

/***************************************************/

package com.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.appium.base.BasePageMobile;
import com.appium.manager.DriverManager;
import com.selenium.base.BasePageWeb;

public class WebLoginPage extends BasePageWeb {

	@FindBy(xpath = "//input[@placeholder=\"yours@example.com\"]")
	private WebElement webTxtFldUsername;
	private String webTxtFldUsernameTxt = "Username Textbox";

	@FindBy(xpath = "//input[@type='password']")
	private WebElement webTxtFldPassword;
	private String webbTxtFldPasswordTxt = "Password Textbox";

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement webBtnLogin;
	private String webBtnLoginTxt = "Login button";

	@FindBy(xpath = "//*[text()='Skip these for now, I want to finish these tasks later.']")
	private WebElement skipQuickProcess;
	private String skipQuickProcessText = "Skip Quick Process";
	
	public WebLoginPage enterUsername(String userName) {
		sendKeys(webTxtFldUsername, userName, webTxtFldUsernameTxt);
		return this;
	}

	public WebLoginPage enterPassword(String password) {
		sendKeys(webTxtFldPassword, password, webbTxtFldPasswordTxt);
		return this;
	}

	public HomePage pressLoginBtn() {
		click(webBtnLogin, webBtnLoginTxt);
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
