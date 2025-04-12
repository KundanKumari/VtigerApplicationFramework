package com.comcast.producttest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.baseclass.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectreositoryutility.CreatingNewProductPage;
import com.comcast.crm.objectreositoryutility.HomePage;
import com.comcast.crm.objectreositoryutility.ProductPage;

@Listeners(com.comcast.generic.listenerutility.ListenerUtility.class)
public class CreateProductTest extends BaseClass {
	@Test(groups = "RegressionTest")
	public void CreateProductsTest() throws Throwable {

		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
		String productName = ex.getDataFromExcel("product", 1, 1) + java.getrandomNumber();

		UtilityClassObject.getTest().log(Status.INFO, "navigate to Product page");
		HomePage hp = new HomePage(driver);
		hp.getProductsLink().click();
		;

		UtilityClassObject.getTest().log(Status.INFO, "navigate to create product page");
		ProductPage pp = new ProductPage(driver);
		pp.getAddIconBtn().click();

		UtilityClassObject.getTest().log(Status.INFO, "create a new product page");
		CreatingNewProductPage cp = new CreatingNewProductPage(driver);
		cp.productPage(productName);
		UtilityClassObject.getTest().log(Status.PASS, productName + "==========>create a new product page");

		String actHeader=pp.getProductHeader().getText();
		hp.getProductsLink().click();

		pp.getSearchText_field().sendKeys(productName);
		pp.productPage();
		pp.getSearchBtn().click();

		driver.findElement(By.xpath("//a[contains(.,'" + productName + "')]/parent::td/following-sibling::td/a[text()='del']")).click();
		driver.switchTo().alert().accept();
         
		boolean status=actHeader.contains(productName);
		Assert.assertEquals(status, true);
	}

}
