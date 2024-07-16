/**
 * @author 
 */

/***************************************************/

package com.appium.pages;

import com.appium.base.BasePageMobile;
import com.appium.components.MenuPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

//public class ProductsPage extends MenuPage {
public class HomePage extends BasePageMobile {

	@AndroidFindBy(xpath = "(//android.widget.TextView)[1]")
	// @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"PRODUCTS\"]")
	private MobileElement HomeTitle;

	private MenuPage menuPage;

	public String getTitle() {
		return HomeTitle.getText();
	}
	
	

}
