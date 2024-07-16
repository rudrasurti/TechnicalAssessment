/**
 * @author 
 */

/***************************************************/

package com.appium.pages;

import com.appium.base.BasePageMobile;
import com.appium.components.MenuPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CompanySettingsPage extends BasePageMobile {

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

	private MenuPage menuPage = new MenuPage();
	
	public CompanySettingsPage openMenu() {
		menuPage.openMenuBtn();
		return this ;
	}
	
	public CompanySettingsPage openCompanySettings() {
		menuPage.clickonCompanySettings();
		return this ;
	}
	
	public CompanySettingsPage enterabout(String description) throws InterruptedException {
		waitForVisibility(pageTitle);
		Thread.sleep(5000);
		swipeDown(2);
		sendKeys(about, description, aboutTextAera);
		return this ;
	}
	
	public CompanySettingsPage clickSave() {
		click(saveBtn, saveBtnText);
		return this ;
	}
	
}
