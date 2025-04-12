package com.comcast.crm.generic.webdriverutility;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void waitForPageToLoad(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(20));
	}
	public void waitForElementPresent(WebDriver driver, WebElement Element) {
		WebDriverWait wait=new WebDriverWait(driver, java.time.Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(Element));	
	}
    
	public void switchToTabOnURL(WebDriver driver, String partialTitle) {
		Set<String> set=driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		
		while(it.hasNext()) {
		String windowid=it.next();
		driver.switchTo().window(windowid);
		
		String acturl=driver.getCurrentUrl();
		
		if(acturl.contains(partialTitle)) {
			break;
		}
	  }	
	}
	public void swicthToTabOnTitle(WebDriver driver, String partialtitle) {
		Set<String> set=driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		
		while(it.hasNext()) {
			String WindowId = it.next();
			driver.switchTo().window(WindowId);
			
			String acturl=driver.getCurrentUrl();
			if(acturl.contains(partialtitle)) {
				break;
		}
	  }
	}
	public void switchToFrame(WebDriver driver, int indexid) {
		driver.switchTo().frame(indexid);
	}
	public void switchToFrame(WebDriver driver, String name) {
		driver.switchTo().frame(name);
	}
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void switchToAlertAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public void select(WebElement element, int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	public void select(WebElement element, String text) {
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	public void mouseMoveToElement(WebDriver driver, WebElement element) {
		Actions  action = new Actions(driver);
		action.moveToElement(element).perform();
	}
}
