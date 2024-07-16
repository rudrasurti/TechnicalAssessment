/**
 * @author 
 */

/***************************************************/

package com.appium.components;

import com.appium.base.BasePageMobile;
import com.appium.pages.CompanySettingsPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class QuickActionPage extends BasePageMobile {

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Logout']")
	// @iOSXCUITFindBy(xpath =  "//XCUIElementTypeOther[@name=\"test-Menu\"]/XCUIElementTypeOther")
	private MobileElement logOutBtn;
	private String LogOutBtnTxt = "LogOut button";

	public void logoutApplication() {
		click(logOutBtn, LogOutBtnTxt);
	}

}
