package com.comcast.opportunittest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.baseclass.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectreositoryutility.CreateOppotunityChildWindowPage;
import com.comcast.crm.objectreositoryutility.CreatingNewOpportunityPage;
import com.comcast.crm.objectreositoryutility.EditingOpportunityInfoPage;
import com.comcast.crm.objectreositoryutility.HomePage;
import com.comcast.crm.objectreositoryutility.OpportunityInformationPage;
import com.comcast.crm.objectreositoryutility.OpportunityPage;

@Listeners(com.comcast.generic.listenerutility.ListenerUtility.class)
public class CreateOpportunityWithThreeTestcase extends BaseClass {
	@Test(groups = "SmokeTest")
	public void opportunityTest() throws Throwable {

		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
		String OppName = ex.getDataFromExcel("Opportunity", 1, 0) + java.getrandomNumber();

		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Opportunity page");
		HomePage hp = new HomePage(driver);
		hp.getOppLink().click();

		UtilityClassObject.getTest().log(Status.INFO, "Navigate to create Opportunity page");
		OpportunityPage op = new OpportunityPage(driver);
		op.getCreateOppBtn().click();

		UtilityClassObject.getTest().log(Status.INFO, "create a new Opportunity page");
		CreatingNewOpportunityPage cop = new CreatingNewOpportunityPage(driver);
		cop.opportunity(OppName);
		UtilityClassObject.getTest().log(Status.PASS, "created a new Opportunity page");

		cop.getSelectBtn().click();

		web.switchToTabOnURL(driver, "module=Accounts&action");

		CreateOppotunityChildWindowPage win = new CreateOppotunityChildWindowPage(driver);
		win.getSearch_text().sendKeys("RINL_579");
		win.getSearchBtn().click();

		driver.findElement(By.linkText("RINL_579")).click();

		web.swicthToTabOnTitle(driver, "DetailView&parenttab");

		cop.getCreateOppsavebtn().click();

		OpportunityInformationPage oip = new OpportunityInformationPage(driver);
		String actoppName = oip.getHeaderMsg().getText();

		hp.getOppLink().click();
		op.getSearchEdt().sendKeys(OppName);
		op.oppotunity(1);
		op.getsearchButton().click();

		boolean status = actoppName.contains(OppName);
		Assert.assertEquals(status, true);
		System.out.println(OppName + " name is verified == PASS");
	}

	@Test(groups = "RegressionTest")
	public void DeleteCreatedopportunityTest() throws Throwable {

		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
		String OppName = ex.getDataFromExcel("Opportunity", 1, 0) + java.getrandomNumber();

		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Opportunity page");
		HomePage hp = new HomePage(driver);
		hp.getOppLink().click();

		UtilityClassObject.getTest().log(Status.INFO, "Navigate to create Opportunity page");
		OpportunityPage op = new OpportunityPage(driver);
		op.getCreateOppBtn().click();

		UtilityClassObject.getTest().log(Status.INFO, "create new Opportunity page");
		CreatingNewOpportunityPage cop = new CreatingNewOpportunityPage(driver);
		cop.opportunity(OppName);
		UtilityClassObject.getTest().log(Status.PASS, "create new Opportunity page");

		cop.getSelectBtn().click();

		web.switchToTabOnURL(driver, "module=Accounts&action");

		CreateOppotunityChildWindowPage win = new CreateOppotunityChildWindowPage(driver);
		win.getSearch_text().sendKeys("RINL_579");
		win.getSearchBtn().click();

		driver.findElement(By.linkText("RINL_579")).click();

		web.swicthToTabOnTitle(driver, "DetailView&parenttab");

		cop.getCreateOppsavebtn().click();

		OpportunityInformationPage oip = new OpportunityInformationPage(driver);
		String actoppName = oip.getHeaderMsg().getText();

		UtilityClassObject.getTest().log(Status.INFO, "search created OppName from Opportunity page");
		hp.getOppLink().click();
		op.getSearchEdt().sendKeys(OppName);
		op.oppotunity(1);
		op.getsearchButton().click();

		UtilityClassObject.getTest().log(Status.INFO, "delete created OppName from Opportunity page");
		driver.findElement(
				By.xpath("//a[contains(.,'" + OppName + "')]/parent::td/following-sibling::td/a[text()='del']"))
				.click();
		driver.switchTo().alert().accept();

		boolean status = actoppName.contains(OppName);
		Assert.assertEquals(status, true);

	}

	@Test(groups = "RegressionTest")
	public void editCreatedOpportunityTest() throws Throwable {

		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
		String OppName = ex.getDataFromExcel("Opportunity", 1, 0) + java.getrandomNumber();

		HomePage hp = new HomePage(driver);
		hp.getOppLink().click();

		OpportunityPage op = new OpportunityPage(driver);
		op.getCreateOppBtn().click();

		CreatingNewOpportunityPage cop = new CreatingNewOpportunityPage(driver);
		cop.opportunity(OppName);
		cop.getSelectBtn().click();

		web.switchToTabOnURL(driver, "module=Accounts&action");

		CreateOppotunityChildWindowPage win = new CreateOppotunityChildWindowPage(driver);
		win.getSearch_text().sendKeys("RINL_579");
		win.getSearchBtn().click();

		driver.findElement(By.linkText("RINL_579")).click();

		web.swicthToTabOnTitle(driver, "DetailView&parenttab");

		cop.getCreateOppsavebtn().click();

		OpportunityInformationPage oip = new OpportunityInformationPage(driver);
		String actHeaderMsg = oip.getHeaderMsg().getText();

		UtilityClassObject.getTest().log(Status.INFO, "search created OppName from Opportunity page");
		hp.getOppLink().click();
		op.getSearchEdt().sendKeys(OppName);
		op.oppotunity(1);
		op.getsearchButton().click();
		op.getEditLink().click();

		UtilityClassObject.getTest().log(Status.INFO, "Edit created OppName from the Opportunity page");
		EditingOpportunityInfoPage eo = new EditingOpportunityInfoPage(driver);
		eo.editOpportunity(OppName);
		UtilityClassObject.getTest().log(Status.PASS, "Edit  OppName from the Opportunity page");

		Thread.sleep(2000);

		boolean status = actHeaderMsg.contains(OppName);
		Assert.assertEquals(status, true);

	}
}
