package com.qa.guru99.testcases;

/** Test Case Automated
 * author : Sumit Agnihotri
 * 
 * 1. Go to http://live.demoguru99.com/index.php/
 * 2. Verify Title of the Page
 * 3.Click on "Mobile" Menu
 * 4.verify the title of the page  
 * 5.In the list of all mobile, Select "SortBy" DropDown as Name
 * 6.Verify all products are sorted by Name
 */
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.Assert;
import com.qa.guru99.base.TestBase;
import com.qa.guru99.pages.HomePage;
import com.qa.guru99.pages.MobilePage;

public class MobileListPageTest extends TestBase {

	HomePage homepage;
	MobilePage mobilePage;

	@BeforeMethod
	public void setUp() {

		initialization();
		homepage = new HomePage();
		mobilePage = new MobilePage();
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {

		String expectedTitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(expectedTitle, "Home page");

	}

	@Test(priority = 2)
	public void clickOnMobileLinkTest() {

		homepage.ClickOnMobileMenu();
	}

	@Test(priority = 3)
	public void verifyMobilePageTitleTest() {

		homepage.ClickOnMobileMenu();
		String exptedTitle = mobilePage.verifyMobilePageTitle();
		Assert.assertEquals(exptedTitle, "Mobile");

	}

	@Test(priority = 4)
	public void sortByDropdownTest() {

		homepage.ClickOnMobileMenu();
		mobilePage.clickOnSortbyDropDwon();

	}

	@Test(priority = 5)
	public void verifyProductsSortTest() {

		homepage.ClickOnMobileMenu();
		mobilePage.clickOnSortbyDropDwon();
		try {
			mobilePage.verifyProductSortedByName();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void tearDown() {

		quitBrowsers();
	}

}
