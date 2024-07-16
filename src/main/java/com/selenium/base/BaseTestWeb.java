/**
 * @author  */

/***************************************************/

package com.selenium.base;

import static com.appium.constants.FrameworkConstants.EXPECTED_DATA_XML_FILE;
import static com.appium.constants.FrameworkConstants.LOGS;
import static com.appium.constants.FrameworkConstants.ROUTINGKEY;
import static com.appium.constants.FrameworkConstants.SERVER_LOGS;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.appium.manager.DateTimeManager;
import com.appium.manager.DriverManager;
import com.appium.manager.PlatformManager;
import com.appium.manager.StringsManager;
import com.driver.utils.AppiumServerUtils;
import com.driver.utils.ConfigLoader;
import com.driver.utils.TestUtils;
import com.driver.utils.VideoRecordUtils;

import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestWeb {

	private static AppiumDriverLocalService server;

	@BeforeMethod
	public void beforeMethod() {
//		VideoRecordUtils.startRecording();
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
//		VideoRecordUtils.stopRecording(result);
	}

	/* Executes before any of the test method class is executed */
	@Parameters({ "browser" })
	@BeforeTest
	public void beforeTest(@Optional("browser") String browser) throws Exception {
		
		String platformName = "Web";

		/*
		 * @Optional("androidOnly") -> means we are setting the default value as
		 * androidOnly and it is Optional
		 */
		URL url;
		InputStream stringsIS;
		RemoteWebDriver driver;
		PlatformManager.setPlatform(platformName);
		String xmlFileName = EXPECTED_DATA_XML_FILE;
		stringsIS = getClass().getClassLoader().getResourceAsStream(xmlFileName);
		DateTimeManager.setDateTime(TestUtils.dateTime());
		StringsManager.setStrings(TestUtils.parseStringXML(stringsIS));
		url = new URL(ConfigLoader.getInstance().getWebURL());

		String strFile = LOGS + File.separator + platformName;
		File logFile = new File(strFile);
		if (!logFile.exists()) {
			logFile.mkdirs();
		}
		// Route logs to separate file for each thread
		ThreadContext.put(ROUTINGKEY, strFile);
		TestUtils.log().debug("Log file path: " + strFile);

		try {
			switch (browser.toLowerCase()) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			default:
				throw new IllegalArgumentException("Invalid browser" + browser);

			}

			DriverManager.setDriver(driver);
			driver.get(url.toString());
			String sessionId = driver.getSessionId().toString();
			TestUtils.log().debug("sessionId: " + sessionId);
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			if (stringsIS != null) {
				stringsIS.close();
			}
		}
	}

	@AfterTest
	public void afterTest() {
		DriverManager.getDriver().quit();
	}

	public void closeApp() {
		((InteractsWithApps) DriverManager.getDriver()).closeApp();
	}

	public void launchApp() {
		((InteractsWithApps) DriverManager.getDriver()).launchApp();
	}

	@AfterSuite
	public void afterSuite() {
		server.stop();
		TestUtils.log().debug("Appium Server stopped.............");
	}

}
