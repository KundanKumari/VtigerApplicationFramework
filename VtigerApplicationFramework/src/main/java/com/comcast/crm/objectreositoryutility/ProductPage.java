package com.comcast.crm.objectreositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class ProductPage extends WebDriverUtility {

	WebDriver driver;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement addIconBtn;

	@FindBy(name = "search_text")
	private WebElement searchText_field;

	@FindBy(name = "search_field")
	private WebElement searchDD;

	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement productHeader;
	
	@FindBy(name = "submit")
	private WebElement searchBtn;

	public WebElement getProductHeader() {
		return productHeader;
	}

	public WebElement getAddIconBtn() {
		return addIconBtn;
	}

	public WebElement getSearchText_field() {
		return searchText_field;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public void productPage() {
		select(searchDD, "Product Name");
	}
		

}
