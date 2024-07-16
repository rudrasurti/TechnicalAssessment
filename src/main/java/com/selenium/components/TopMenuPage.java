/**
 * @author 
 */

/***************************************************/

package com.selenium.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.selenium.base.BasePageWeb;

public class TopMenuPage extends BasePageWeb {

	@FindBy(xpath = "//button[@title='Logout']")
	private WebElement logOutBtn;
	private String logOutBtnTxt = "Logout";
	

	public void logoutWebApplication() {
		click(logOutBtn, logOutBtnTxt);
	}

}
