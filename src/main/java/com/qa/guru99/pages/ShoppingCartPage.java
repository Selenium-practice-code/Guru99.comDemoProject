package com.qa.guru99.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.guru99.base.TestBase;

public class ShoppingCartPage extends TestBase {

	// Locators
	@FindBy(xpath = "//input[@class='input-text qty']")
	private WebElement itemQty;

	@FindBy(xpath = "//button[@title='Update']")
	private WebElement updateProd;

	@FindBy(xpath = "//p[contains(text(),'* The maximum quantity allowed for purchase is 500')]")
	private WebElement errorMessage;

	@FindBy(xpath = "//span[contains(text(),'Empty Cart')]")
	private WebElement emptyCart;

	@FindBy(xpath = "//h1[contains(text(),'Shopping Cart is Empty')]")
	private WebElement emptyCartMsg;

	// Constructor for Page Element
	public ShoppingCartPage() {

		PageFactory.initElements(driver, this);
	}

	// Methods
	public void addQtyOfitems(String qty) {

		itemQty.sendKeys(qty);
	}

	public void clickOnUpdate() {

		updateProd.click();

	}

	public String getErrorMsg() {

		return errorMessage.getText();
	}

	public void clickOnEmptyCart() {

		emptyCart.click();
	}

	public String getEmptyCartMsg() {

		return emptyCartMsg.getText();

	}

}
