package com.qa.guru99.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.guru99.base.TestBase;

public class HomePage extends TestBase {

	// locators
	@FindBy(xpath = "//a[contains(text(),'Mobile')]")
	private WebElement mobileMenu;

	@FindBy(xpath = "//a[contains(text(),'TV')]")
	private WebElement tvMenu;

	// Constructor for PageFactory elements
	public HomePage() {

		PageFactory.initElements(driver, this);
	}

	// Methods
	public String verifyHomePageTitle() {

		return driver.getTitle();

	}

	public MobilePage ClickOnMobileMenu() {

		mobileMenu.click();

		return new MobilePage();

	}
}
