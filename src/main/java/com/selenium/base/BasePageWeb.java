/**
 * @author  */

/***************************************************/

package com.selenium.base;

import static com.appium.constants.FrameworkConstants.EXPLICIT_WAIT;
import static com.appium.constants.FrameworkConstants.LABEL;
import static com.appium.constants.FrameworkConstants.PLATFORM_ANDROID;
import static com.appium.constants.FrameworkConstants.PLATFORM_iOS;
import static com.appium.constants.FrameworkConstants.TEXT;
import static com.appium.constants.FrameworkConstants.WAIT;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.appium.manager.DriverManager;
import com.appium.manager.PlatformManager;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.driver.utils.ScreenshotUtils;
import com.driver.utils.TestUtils;
import com.driver.utils.VerificationUtils;
import com.extent.reports.ExtentLogger;
import com.extent.reports.ExtentManager;
import com.google.common.util.concurrent.Uninterruptibles;

public class BasePageWeb {
//	private AppiumDriver<?> driver;
//	TestUtils utils = new TestUtils();

	public BasePageWeb() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	public void waitForVisibility(WebElement WebElement) {
		WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), EXPLICIT_WAIT);
		wait.until(ExpectedConditions.visibilityOf(WebElement));
	}

	public void click(WebElement WebElement) {
		waitForVisibility(WebElement);
		TestUtils.log().info(WebElement.getText() + " is clicked");
		ExtentLogger.info("<b>" + WebElement.getText() + "</b> is clicked");
		WebElement.click();
	}

	public void click(WebElement WebElement, String elementName) {
		waitForVisibility(WebElement);
		TestUtils.log().info(elementName + " is clicked");
		ExtentLogger.info("<b>" + elementName + "</b> is clicked");
		WebElement.click();
	}

	public void clear(WebElement WebElement, String elementName) {
		waitForVisibility(WebElement);
		TestUtils.log().info("Clearing: " + elementName);
		WebElement.clear();
	}

	public void sendKeys(WebElement WebElement, String txt) {
		waitForVisibility(WebElement);
		TestUtils.log().info("Filling " + txt + " in " + WebElement.getText());
		ExtentLogger.info("Filling <b>" + txt + "</b> in <b>" + WebElement.getText() + "</b>");
		// WebElement.clear();
		clear(WebElement, txt);
		WebElement.sendKeys(txt);

	}

	public void sendKeys(WebElement WebElement, String txt, String elementName) {
		waitForVisibility(WebElement);
		TestUtils.log().info("Filling " + txt + " in " + elementName);
		ExtentLogger.info("Filling <b>" + txt + "</b> in <b>" + elementName + "</b>");
		// WebElement.clear();
		clear(WebElement, elementName);
		WebElement.sendKeys(txt);

	}

	public String getAttribute(WebElement WebElement, String attribute) {
		waitForVisibility(WebElement);
		TestUtils.log().info("Attribute: " + attribute + " value for " + WebElement.getText() + " is - "
				+ WebElement.getAttribute(attribute));
		/*
		 * ExtentLogger.info("Attribute: <b>" + attribute + "</b> value for <b>" +
		 * WebElement.getText() + "</b> is - <b>" +
		 * WebElement.getAttribute(attribute) + "</b>");
		 */return WebElement.getAttribute(attribute);
	}

	/**
	 * Attribute
	 * 
	 * Android -> text
	 * 
	 * iOS -> label
	 * 
	 */
	public String getElementText(WebElement WebElement) {
		waitForVisibility(WebElement);

		String platformName = PlatformManager.getPlatform();
		if (platformName.equalsIgnoreCase(PLATFORM_ANDROID)) {
			TestUtils.log().info("Attribute: text - value for " + WebElement.getText() + " is - "
					+ WebElement.getAttribute(TEXT));
			return WebElement.getAttribute(TEXT);

		} else if (platformName.equalsIgnoreCase(PLATFORM_iOS)) {
			TestUtils.log().info("Attribute: label - value for " + WebElement.getText() + " is - "
					+ WebElement.getAttribute(LABEL));
			return WebElement.getAttribute(LABEL);
		}
		return null;

	}

	protected void captureScreenshot() {
		ExtentManager.getExtentTest().info("Capturing Screenshot",
				MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
	}

	protected void waitForSomeTime() {
		Uninterruptibles.sleepUninterruptibly(WAIT, TimeUnit.SECONDS);
	}

	protected void waitForGivenTime(long time) {
		Uninterruptibles.sleepUninterruptibly(time, TimeUnit.SECONDS);
	}

	protected void webElementPresent(WebElement WebElement, String elementName) {
		VerificationUtils.validate(isDisplayed(WebElement), true, elementName + " presence");
	}

	protected void webElementAbsent(WebElement WebElement, String elementName) {
		VerificationUtils.validate(isDisplayed(WebElement), false, elementName + " absence");
	}

	private boolean isDisplayed(WebElement element) {
		try {
			waitForVisibility(element);
			return element.isDisplayed();
		} catch (NoSuchElementException | TimeoutException exception) {
			ExtentLogger.fail("Element is not present");
			return false;
		}
	}

}
