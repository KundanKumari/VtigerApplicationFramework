package com.comcast.crm.objectreositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DocumentPage {
	WebDriver driver;

	 public DocumentPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
	@FindBy(xpath="//img[@alt=\"Create Document...\"]")
	private WebElement CreateDocBtn;
	
	@FindBy(linkText="Documents")
	private WebElement verifyDocLinkTab;
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement creatingNewDoc;
	
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headertext;
	
	
	@FindBy(name="search_text")
	private WebElement searchEdt;

	@FindBy(name="search_field")
	private WebElement searchDD;
	
	@FindBy(name="submit")
	private WebElement searchButton;
	
	@FindBy(linkText = "del")
	private WebElement delLink;

	public WebElement getDelLink() {
		return delLink;
	}
	public WebElement getHeadertext() {
		return headertext;
	}
	public WebElement getVerifyDocLinkTab() {
		return verifyDocLinkTab;
	}
		
	public WebElement getCreateDocBtn() {
		return CreateDocBtn;
	}
	public WebElement getSearchEdt() {
		return searchEdt;
	}
	public WebElement getCreatingNewDoc() {
		return creatingNewDoc;
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
	public void Document(int index) throws Exception {
		
	     Select select=new Select(searchDD);
	     select.selectByIndex(index);
	}
	public void Document() {
		delLink.click();
		driver.switchTo().alert().accept();
	

}}
