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
import com.qa.guru99.pages.MobilePage;
import com.qa.guru99.pages.PopUpWindowPage;

public class PopUpWindowTest extends TestBase {

	HomePage homePage;
	MobilePage mobilePage;
	PopUpWindowPage popWindowPage;

	@BeforeMethod
	public void setUp() {

		initialization();
		homePage = new HomePage();
		mobilePage = new MobilePage();
		popWindowPage = new PopUpWindowPage();
		mobilePage = homePage.ClickOnMobileMenu();
	}

	@Test
	public void xperiaAddToCompareTest() {

		mobilePage.clickOnXperiaCompLink();
		mobilePage.iphoneCompLink();
		mobilePage.clickOnComapre();

		switchWindows();

		String Headertitle = popWindowPage.popUpHeaderTitle();
		Assert.assertEquals(Headertitle, "COMPARE PRODUCTS");

		String sonyXperia = popWindowPage.displayXperiaProd();
		Assert.assertEquals(sonyXperia, "SONY XPERIA");

		String iphone = popWindowPage.displayIphoneProd();
		Assert.assertEquals(iphone, "IPHONE");

		popWindowPage.clickOnCloseWindow();

	}

	@AfterMethod
	public void tearDown() {

		quitBrowsers();
	}
}
