/**
 * @author 
 */

/***************************************************/

package com.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium.base.BasePageWeb;
import com.selenium.components.MenuPage;

public class MyCompanyPage extends BasePageWeb {

	@FindBy(xpath = "//input[@id='brokerName']")
	private WebElement brokerName;
	private String brokerNameText = "Broker Name";

	private MenuPage menu = new MenuPage();
	

	public MyCompanyPage openCompanySettings() {
		menu.clickOnMyCompany();
		return this;
	}

}
