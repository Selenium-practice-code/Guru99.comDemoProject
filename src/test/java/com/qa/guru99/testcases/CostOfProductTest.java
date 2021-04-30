package com.qa.guru99.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.guru99.base.TestBase;
import com.qa.guru99.pages.HomePage;
import com.qa.guru99.pages.MobilePage;
import com.qa.guru99.pages.SonyXperiaDetailsPage;

/**
 * Test Case : Verify that cost of Product page and details page are equal
 * author : Sumit Agnihotri
 * 
 * 1.Go to http://live.demoguru99.com/index.php/ 
 * 2.Click on "Mobile" Menu 
 * 3.In the list of all mobile read the cost of SonyXperia and note the value
 * 4.Click on SonyXperia Mobile  
 * 5.Read the SonyXperia Mobile from details page
 * 6.compare value of Step 3 and Step 5
 */
public class CostOfProductTest extends TestBase {

	private String xperiaPrice;
	private String detailsPagePrice;

	HomePage homePage;
	MobilePage mobilePage;
	SonyXperiaDetailsPage sonyXperiaDetailsPage;

	@BeforeMethod
	public void setUp() {

		initialization();
		homePage = new HomePage();
		mobilePage = new MobilePage();
		sonyXperiaDetailsPage = new SonyXperiaDetailsPage();
		mobilePage = homePage.ClickOnMobileMenu();

	}

	@Test(priority = 1)
	public void sonyXperiaPriceTest() {

		xperiaPrice = mobilePage.verifXpriaPrice();

	}

	@Test(priority = 2)
	public void xpreriaDetailsPagePriceTest() {

		mobilePage.clickOnSonyXperia();
		detailsPagePrice = sonyXperiaDetailsPage.sonyXperiaDetailsPrice();

	}

	@Test(priority = 3)
	public void compareTheXperiaPriceTest() {

		Assert.assertEquals(detailsPagePrice, xperiaPrice, "SonyXperia price and Details price are same.");

	}

	@AfterMethod
	public void tearDown() {

		quitBrowsers();

	}

}
