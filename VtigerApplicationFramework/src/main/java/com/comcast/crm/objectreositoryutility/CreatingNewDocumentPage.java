package com.comcast.crm.objectreositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewDocumentPage {

	WebDriver driver;
	public CreatingNewDocumentPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	@FindBy(name="notes_title")
	private WebElement titleText_Field;
	
	@FindBy(name="button")
	private WebElement saveBtn;
	
	public WebElement getTitleText_Field() {
		return titleText_Field;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public void documents(String docName) {
	titleText_Field.sendKeys(docName);
	saveBtn.click();
	}
	
}

