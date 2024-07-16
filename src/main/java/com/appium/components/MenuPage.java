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

public class MenuPage extends BasePageMobile {

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Menu']")
	// @iOSXCUITFindBy(xpath =
	// "//XCUIElementTypeOther[@name=\"test-Menu\"]/XCUIElementTypeOther")
	private MobileElement menuBtn;
	private String menuBtnTxt = "Menu button";
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Company Settings\"]")
	// @iOSXCUITFindBy(xpath =  "//XCUIElementTypeOther[@name=\"test-Menu\"]/XCUIElementTypeOther")
	private MobileElement companySettings;
	private String CompanySettingsText = "Company Settings";
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='My Company']")
	// @iOSXCUITFindBy(xpath =  "//XCUIElementTypeOther[@name=\"test-Menu\"]/XCUIElementTypeOther")
	private MobileElement myCompany;
	private String MyCompanyText = "My Company";

	public void openMenuBtn() {
		click(menuBtn, menuBtnTxt);
	}
	
	public void clickonCompanySettings() {
		click(companySettings, CompanySettingsText);
	}

	
	public void clickonMyCompany() {
		click(myCompany, MyCompanyText);
	}

}
