package com.comcast.crm.objectreositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditingOpportunityInfoPage  {

	WebDriver driver;
	public EditingOpportunityInfoPage(WebDriver driver) {
		this.driver=driver;
	 PageFactory.initElements(driver, this);
	}
	@FindBy(name = "potentialname")
	private WebElement editOppName;
	
	public WebElement getEditOppName() {
		return editOppName;
		
	}
	@FindBy(name="button")
	private WebElement saveEditedOppName;
	
	public WebElement getSaveEditedOppName() {
		return saveEditedOppName;
	}
	public void editOpportunity(String oppName) {
		editOppName.clear();
		editOppName.sendKeys(oppName);
		saveEditedOppName.click();
	}
}
