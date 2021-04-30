package com.qa.guru99.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.guru99.base.TestBase;
import com.qa.guru99.pages.HomePage;
import com.qa.guru99.pages.MobilePage;
import com.qa.guru99.pages.ShoppingCartPage;

/**
 * Test Case Automated author : Sumit Agnihotri
 * 
 * 1.Go to http://live.demoguru99.com/index.php/ 2.Click on "Mobile" Menu 3.in
 * the list of all mobile, click on add to card for SonyXperia mobile 4.Change
 * quantity value 1000 and click on Update button 5.verify the error message
 * 6.Then click on empty card link in the footer of the list of all Mobile
 * 7.verify the cart is empty.
 */

public class ErrorVrificatonTest extends TestBase {

	HomePage homePage;
	MobilePage mobilePage;
	ShoppingCartPage shoppingCartPage;

	@BeforeMethod
	public void setUp() {

		initialization();
		homePage = new HomePage();
		mobilePage = new MobilePage();
		shoppingCartPage = new ShoppingCartPage();
		mobilePage = homePage.ClickOnMobileMenu();

	}

	@Test
	public void addtoCartTest() {

		shoppingCartPage = mobilePage.addToCart();
		shoppingCartPage.addQtyOfitems("1000");
		shoppingCartPage.clickOnUpdate();

		String errorMsg = shoppingCartPage.getErrorMsg();
		Assert.assertEquals(errorMsg, "* The maximum quantity allowed for purchase is 500.", "get the error msg");

		shoppingCartPage.clickOnEmptyCart();
		String emptyCartMsg = shoppingCartPage.getEmptyCartMsg();
		Assert.assertEquals(emptyCartMsg, "SHOPPING CART IS EMPTY", "verify card is Empty");

	}

	@AfterMethod
	public void tearDown() {

		quitBrowsers();
	}

}
