package com.comcast.crm.objectreositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOpportunityPage {

		WebDriver driver;

	 public CreatingNewOpportunityPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

		@FindBy(name = "potentialname")
		private WebElement OppNametextfield;


		@FindBy(xpath = "(//img[@alt=\"Select\"])[1]")
		private WebElement selectBtn;

		@FindBy(xpath = "//input[@name='button']")
		private WebElement CreateOppsavebtn;
		

		public WebElement getOppNametextfield() {
			return OppNametextfield;
		}

		public WebElement getSelectBtn() {
			return selectBtn;
		}

		public WebElement getCreateOppsavebtn() {
			return CreateOppsavebtn;
		}

		public void opportunity(String OpportunityName) {
			OppNametextfield.sendKeys(OpportunityName);
			
			}
		
		

}
