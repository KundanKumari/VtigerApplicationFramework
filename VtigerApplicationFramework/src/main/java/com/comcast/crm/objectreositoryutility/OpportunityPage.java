package com.comcast.crm.objectreositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OpportunityPage {

	WebDriver driver;
	public OpportunityPage(WebDriver driver) {
		this.driver=driver;
	 PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Create Opportunity...']")
	private WebElement CreateOppBtn;
	
	@FindBy(name="search_text")
	private WebElement searchEdt;

	@FindBy(name="search_field")
	private WebElement searchDD;
	
	@FindBy(name="submit")
	private WebElement searchButton;
	
	@FindBy(linkText="edit")
	private WebElement editLink;
	
	public WebElement getEditLink() {
		return editLink;
	}
	public WebElement getCreateOppBtn() {
		return CreateOppBtn;
	}
	
	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}
	public WebElement getsearchButton() {
		return searchButton;
	}
	public WebElement getTypeDD() {
		return searchDD ;
	}
	public void oppotunity(int index) throws Exception {
		
	     Select select=new Select(searchDD);
	     select.selectByIndex(index);
	}
	
}
