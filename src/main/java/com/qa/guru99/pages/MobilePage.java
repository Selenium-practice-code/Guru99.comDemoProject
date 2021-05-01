package com.qa.guru99.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.guru99.base.TestBase;

public class MobilePage extends TestBase {

	// Locators
	@FindBy(xpath = "//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/select[1]")
	private WebElement sortByDropDown;

	@FindBy(xpath = "//span[contains(text(),'$100.00')]")
	private WebElement sonyXperiaPrice;

	@FindBy(xpath = "//a[contains(text(),'Sony Xperia')]")
	private WebElement sonyXperia;

	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/ul[1]/li[1]/div[1]/div[3]/button[1]/span[1]/span[1]")
	private WebElement addcart;

	@FindBy(xpath = "//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/ul/li[2]/a")
	private WebElement sonyXperiaCompLink;

	@FindBy(xpath = "//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/ul/li[2]/a")
	private WebElement iphoneCompLink;

	@FindBy(xpath = "//button[@title='Compare']//span//span[contains(text(),'Compare')]")
	private WebElement compareBtn;

	public MobilePage() {

		PageFactory.initElements(driver, this);
	}

	public String verifyMobilePageTitle() {

		return driver.getTitle();

	}

	public void clickOnSortbyDropDwon() {

		Select select = new Select(sortByDropDown);
		select.selectByVisibleText("Name");
	}

	public void verifyProductSortedByName() throws IOException {

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String png = (System.getProperty("user.dir") + "/src/test/resources/screenShots/"
				+ "ProductsInSortedOrderByName" + ".png");
		FileUtils.copyFile(srcFile, new File(png));

	}

	public String verifXpriaPrice() {

		return sonyXperiaPrice.getText();
	}

	public SonyXperiaDetailsPage clickOnSonyXperia() {

		sonyXperia.click();

		return new SonyXperiaDetailsPage();

	}

	public ShoppingCartPage addToCart() {

		addcart.click();

		return new ShoppingCartPage();
	}

	public void clickOnXperiaCompLink() {

		sonyXperiaCompLink.click();
	}

	public void iphoneCompLink() {

		iphoneCompLink.click();
	}

	public MobileCompPopUpWindowPage clickOnComapre() {
		 
		 compareBtn.click();
		 
		 return new MobileCompPopUpWindowPage();
	 }
}
