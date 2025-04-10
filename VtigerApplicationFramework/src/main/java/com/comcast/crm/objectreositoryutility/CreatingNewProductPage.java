package com.comcast.crm.objectreositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewProductPage {

	WebDriver driver;
	public CreatingNewProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="productname")
	private WebElement prodNameText_field;
	
	@FindBy(name="button")
	private WebElement saveBtn;
	
	public WebElement getProdNameText_field() {
		return prodNameText_field;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public void productPage(String productName) {
		prodNameText_field.sendKeys(productName);
		saveBtn.click();
		
	}
}
