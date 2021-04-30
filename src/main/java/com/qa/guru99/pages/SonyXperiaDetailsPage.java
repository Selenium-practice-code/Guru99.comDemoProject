package com.qa.guru99.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.guru99.base.TestBase;

public class SonyXperiaDetailsPage extends TestBase {
	
	//Locators
	
	@FindBy(xpath = "//span[contains(text(),'$100.00')]")
	private WebElement XperiaDetailsPrice;
	
	
	//Constructor

	public SonyXperiaDetailsPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	//Methods
	
	public String sonyXperiaDetailsPrice() {
		
		return XperiaDetailsPrice.getText();
	}
	
	

}
