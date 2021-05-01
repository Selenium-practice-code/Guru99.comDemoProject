package com.qa.guru99.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.guru99.base.TestBase;

public class MobileCompPopUpWindowPage extends TestBase {

	// Locators
	@FindBy(xpath = "//*[@id=\"top\"]/body/div/div[1]/h1")
	private WebElement compareProductsHeader;

	@FindBy(xpath = "//*[@id=\"product_comparison\"]/tbody[1]/tr[1]/td[1]/h2/a")
	private WebElement displaySonyXperia;

	@FindBy(xpath = "//*[@id=\"product_comparison\"]/tbody[1]/tr[1]/td[2]/h2/a")
	private WebElement displayIphone;

	@FindBy(xpath = "//button[@title='Close Window']")
	private WebElement closeWindowBtn;

	// Constructor
	public MobileCompPopUpWindowPage() {

		PageFactory.initElements(driver, this);
	}

	// Methods
	public String popUpHeaderTitle() {

		return compareProductsHeader.getText();

	}

	public String displayXperiaProd() {

		return displaySonyXperia.getText();

	}

	public String displayIphoneProd() {

		return displayIphone.getText();

	}
	
	public void clickOnCloseWindow() {
		
		closeWindowBtn.click();
	}

}
