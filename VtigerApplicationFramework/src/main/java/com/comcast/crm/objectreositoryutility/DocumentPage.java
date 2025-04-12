package com.comcast.crm.objectreositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class DocumentPage extends WebDriverUtility{
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
	public void Document() throws Exception {
	     select(searchDD, 1);	
	     }
	public void Document1() {
		delLink.click();
		switchToAlertAndAccept(driver);
	

}}
