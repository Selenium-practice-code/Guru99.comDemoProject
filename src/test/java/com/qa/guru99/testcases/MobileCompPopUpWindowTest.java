package com.qa.guru99.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test Case Automated author : Sumit Agnihotri
 * 
 * 1.Go to http://live.demoguru99.com/index.php/ 
 * 2.Click on "Mobile" Menu 
 * 3.Click to "add to compare" for two mobiles
 * 4.click on compare button
 * 5.verify the popUp window and check that the products are reflected in it
 * 6.close the popUp window
 */

import com.qa.guru99.base.TestBase;
import com.qa.guru99.pages.HomePage;
import com.qa.guru99.pages.MobileCompPopUpWindowPage;
import com.qa.guru99.pages.MobilePage;

public class MobileCompPopUpWindowTest extends TestBase {

	HomePage homePage;
	MobilePage mobilePage;
	MobileCompPopUpWindowPage mobileCompPopUpWindowPage;

	@BeforeMethod
	public void setUp() {

		initialization();
		homePage = new HomePage();
		mobilePage = new MobilePage();
		mobileCompPopUpWindowPage = new MobileCompPopUpWindowPage();
		mobilePage = homePage.ClickOnMobileMenu();
	}

	@Test
	public void xperiaAddToCompareTest() {

		mobilePage.clickOnXperiaCompLink();
		mobilePage.iphoneCompLink();
		mobileCompPopUpWindowPage = mobilePage.clickOnComapre();

		switchWindows();

		String Headertitle = mobileCompPopUpWindowPage.popUpHeaderTitle();
		Assert.assertEquals(Headertitle, "COMPARE PRODUCTS");

		String sonyXperia = mobileCompPopUpWindowPage.displayXperiaProd();
		Assert.assertEquals(sonyXperia, "SONY XPERIA");

		String iphone = mobileCompPopUpWindowPage.displayIphoneProd();
		Assert.assertEquals(iphone, "IPHONE");

		mobileCompPopUpWindowPage.clickOnCloseWindow();

	}

	@AfterMethod
	public void tearDown() {

		quitBrowsers();
	}
}
