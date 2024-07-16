/**
 * @author 
 */

/***************************************************/

package com.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium.base.BasePageWeb;
import com.selenium.components.TopMenuPage;

public class LogoutPage extends BasePageWeb {

	@FindBy(xpath = "//input[@id='brokerName']")
	private WebElement brokerName;
	private String brokerNameText = "Broker Name";


	private TopMenuPage topMenu = new TopMenuPage();
	

	public LogoutPage logout() throws InterruptedException {
		Thread.sleep(3000);
		topMenu.logoutWebApplication();
		return this;
	}

}
