/**
 * @author 
 */

/***************************************************/

package com.selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium.base.BasePageWeb;
import com.selenium.components.MenuPage;

public class CompanySettingsPage extends BasePageWeb {

	@FindBy(xpath = "//input[@id='brokerName']")
	private WebElement brokerName;
	private String brokerNameText = "Broker Name";

	@FindBy(xpath = "//input[@id='brokerLicense']")
	private WebElement brokerLicense;
	private String brokerLicenseText = "Broker License";

	@FindBy(xpath = "//input[@id='brokerAddress']")
	private WebElement brokerAddress;
	private String brokerAddressText = "Broker Address";

	@FindBy(xpath = "//span[text()='Save']/..")
	private WebElement saveBtn;
	private String saveBtnText = "Save";

	private MenuPage menu = new MenuPage();
	

	public CompanySettingsPage openCompanySettings() {
		menu.clickonCompanySettings();
		return this;
	}

	public CompanySettingsPage enterBrokerName(String brokerName) {
		sendKeys(this.brokerName, brokerName, brokerNameText);
		return this;
	}

	public CompanySettingsPage enterBrokerLicense(String brokerLicense) {
		sendKeys(this.brokerLicense, brokerLicense, brokerLicenseText);
		return this;
	}

	public CompanySettingsPage enterBrokerAddress(String brokerAddress) {
		sendKeys(this.brokerAddress, brokerAddress, brokerAddressText);
		return this;
	}

	public CompanySettingsPage clickOnsave() throws InterruptedException {
		Thread.sleep(2000);
		click(saveBtn, saveBtnText);
		return this;
	}

}
