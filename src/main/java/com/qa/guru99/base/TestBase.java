package com.qa.guru99.base;

import java.time.Duration;
import java.util.Date;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.guru99.utilities.ExcelReader;
import com.qa.guru99.utilities.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestBase {

	public static WebDriver driver;
	public static Logger log = Logger.getLogger(TestBase.class);
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "/src/test/resources/excel/testdata.xlsx");
	public static ExtentReports rep = ExtentManager.getInstance();
	public static String browser;
	public static ExtentTest test;
	public static WebDriverWait wait;

	public static void initialization() {

		// Create a Time Stamp for logs
		Date d = new Date();
		System.setProperty("current.date", d.toString().replace(":", "_").replace(" ", "_"));

		// Configure the logger file
		PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");

		// Launching the browsers
		if (Constants.browser.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/src/test/resources/executables/chromedriver");
			driver = new ChromeDriver();
			log.info("Chrome Browser Launched.");

		} else if (Constants.browser.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "/src/test/resources/executables/geckodriver");
			driver = new FirefoxDriver();
			log.info("FireFox Browser Launched.");

		} else if (Constants.browser.equals("safari")) {

			driver = new SafariDriver();
			log.info("Safari Browser Launched.");
		}

		driver.get(Constants.testSiteUrl);
		log.info("Navigated to  :->  " + Constants.testSiteUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIMEOUT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOAD_TIMEOUT));
		wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);

	}
	
	public void switchWindows() {
		
		 for(String handel : driver.getWindowHandles()) {
			 
			 driver.switchTo().window(handel);
		 }
		
		
	}

	public void quitBrowsers() {

		if (driver != null) {

			driver.quit();
		}
		
		log.info("Test executes succssfully !!!");
	}

}
