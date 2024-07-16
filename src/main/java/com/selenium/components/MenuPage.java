/**
 * @author 
 */

/***************************************************/

package com.selenium.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium.base.BasePageWeb;

public class MenuPage extends BasePageWeb {

	@FindBy(xpath = "//android.widget.Button[@text='Menu']")
	private WebElement menuBtn;
	private String menuBtnTxt = "Menu button";
	

	@FindBy(xpath = "//span[text()='Company Settings']")
	private WebElement CompanySettingsLink;
	private String companySettingsTxt = "Company Settings";
	

	@FindBy(xpath = "//span[text()='My Company']")
	private WebElement MyCompanyLink;
	private String MyCompanyTxt = "My Company";

	public void openMenuBtn() {
		click(menuBtn, menuBtnTxt);
	}
	
	public void clickonCompanySettings() {
		click(CompanySettingsLink, companySettingsTxt);
	}
	
	public void clickOnMyCompany() {
		click(MyCompanyLink, MyCompanyTxt);
	}

}
