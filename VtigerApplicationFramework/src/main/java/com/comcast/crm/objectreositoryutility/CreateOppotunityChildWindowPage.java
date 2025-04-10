package com.comcast.crm.objectreositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOppotunityChildWindowPage {
	
	WebDriver driver;
	public CreateOppotunityChildWindowPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	@FindBy(id="search_txt")
	private WebElement search_text;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	public WebElement getSearch_text() {
		return search_text;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
}
