package com.comcast.crm.objectreositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class HomePage extends WebDriverUtility {

	   WebDriver driver;
	   public HomePage(WebDriver driver) {
		   this.driver=driver;
		   PageFactory.initElements(driver, this);
	   } 
	   
		@FindBy(linkText="Documents")
		private WebElement docLink;
		
		@FindBy(linkText="Products")
		private WebElement ProductsLink;
		
		@FindBy(linkText="Opportunities")
		private WebElement oppLink;

		@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
		private WebElement adminImg;

		@FindBy(linkText ="Sign Out")
		private WebElement signoutLink;
		
		public WebElement getDocLink() {
			return docLink;
		}
		public WebElement getProductsLink() {
			return ProductsLink;
		}

		public WebElement getOppLink() {
			return oppLink;
		}
		
		
		public WebElement getAdminImg() {
			return adminImg;
		}
		public WebElement getSignout() {
			return signoutLink;
		}
		
		public void logout() throws InterruptedException {
			mouseMoveToElement(driver,adminImg);
			signoutLink.click();
		
		}
		
		
}
