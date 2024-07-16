/**
 * @author 
 */

/***************************************************/

package com.selenium.pages;


import com.selenium.base.BasePageWeb;

import static com.appium.constants.FrameworkConstants.TEXT;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


//public class ProductsPage extends MenuPage {
public class HomePage extends BasePageWeb {

	@FindBy(xpath = "//div[@class='py-2 text-xl mb-2']/p")
	private WebElement HomeTitle;


	public String getTitle() {
		return HomeTitle.getText();
	}
	
	

}
