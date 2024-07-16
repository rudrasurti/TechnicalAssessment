/**
 * @author 
 */

/***************************************************/

package com.appium.pages;

import com.appium.base.BasePageMobile;
import com.appium.components.QuickActionPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LogoutPage extends BasePageMobile {

	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='about']")
	//@iOSXCUITFindBy(id = "test-LOGOUT")
	private MobileElement about;
	private String aboutTextAera = "about TextAera";
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Save']")
	//@iOSXCUITFindBy(id = "test-LOGOUT")
	private MobileElement saveBtn;
	private String saveBtnText = "Save Button";
	

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Company Settings']")
	//@iOSXCUITFindBy(id = "test-LOGOUT")
	private MobileElement pageTitle;
	private String pageTitleText = "Company Settings";

	private QuickActionPage quickActionPage  = new QuickActionPage();
	
	
	public LogoutPage logoutApplication() {
		quickActionPage.logoutApplication();
		return this ;
	}
	
	
}
