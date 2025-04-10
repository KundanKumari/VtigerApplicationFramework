package com.comcast.documenttest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.comcast.crm.baseclass.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectreositoryutility.CreatingNewDocumentPage;
import com.comcast.crm.objectreositoryutility.DocumentPage;
import com.comcast.crm.objectreositoryutility.HomePage;

@Listeners(com.comcast.generic.listenerutility.ListenerUtility.class)
public class CreateDocumentWithFourTestCase extends BaseClass {
	@Test(groups = "SmokeTest")
	public void CreateDocumentsTest() throws Throwable {

		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
		String docName = ex.getDataFromExcel("Documents", 1, 0) + java.getrandomNumber();

		UtilityClassObject.getTest().log(Status.INFO, "navigate to Documents page");
		HomePage hp = new HomePage(driver);
		hp.getDocLink().click();

		UtilityClassObject.getTest().log(Status.INFO, "navigate to create a new Documents page");
		DocumentPage dp = new DocumentPage(driver);
		dp.getCreateDocBtn().click();

		UtilityClassObject.getTest().log(Status.INFO, "create a new Documents page");
		CreatingNewDocumentPage cdp = new CreatingNewDocumentPage(driver);
		cdp.documents(docName);
		UtilityClassObject.getTest().log(Status.PASS, docName + "==========>create a new Documents page");

		String actDocHeader = dp.getHeadertext().getText();

		hp.getDocLink().click();

		UtilityClassObject.getTest().log(Status.INFO, "Edit created docName in Documents page");
		dp.getSearchEdt().sendKeys(docName);
		dp.Document(1);
		dp.getsearchButton().click();
		Thread.sleep(2000);

		boolean status = actDocHeader.contains(docName);
		Assert.assertEquals(status, true);
	}

	@Test(groups = "SmokeTest")
	public void CheckDocumentLinkTest() {
		UtilityClassObject.getTest().log(Status.INFO, "navigate to Documents page");
		HomePage hp = new HomePage(driver);
		hp.getDocLink().click();
		
		DocumentPage dp=new DocumentPage(driver);
		
		Assert.assertEquals(dp.getVerifyDocLinkTab().getText(), "Documents");
	}

	@Test(groups = "SmokeTest")
	public void DocumentAddIconTest() {

		UtilityClassObject.getTest().log(Status.INFO, "navigate to Documents page");
		HomePage hp = new HomePage(driver);
		hp.getDocLink().click();

		UtilityClassObject.getTest().log(Status.INFO, "navigate to create a new Documents page");
		DocumentPage dp = new DocumentPage(driver);
		dp.getCreateDocBtn().click();
		Assert.assertEquals(dp.getCreatingNewDoc().getText(), "Creating New Document");
		
	}

	@Test(groups = "RegressionTest")
	public void DeleteCreatedDocumentsTest() throws Throwable {
		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
		String docName = ex.getDataFromExcel("Documents", 1, 0) + java.getrandomNumber();

		UtilityClassObject.getTest().log(Status.INFO, "navigate to Documents page");
		HomePage hp = new HomePage(driver);
		hp.getDocLink().click();

		UtilityClassObject.getTest().log(Status.INFO, "navigate to create a new Documents page");
		DocumentPage dp = new DocumentPage(driver);
		dp.getCreateDocBtn().click();

		UtilityClassObject.getTest().log(Status.INFO, "create a new Documents page");
		CreatingNewDocumentPage cdp = new CreatingNewDocumentPage(driver);
		cdp.documents(docName);
		UtilityClassObject.getTest().log(Status.PASS, "create a new Documents page");

		String actDocHeader = dp.getHeadertext().getText();

		hp.getDocLink().click();

		UtilityClassObject.getTest().log(Status.INFO, "search created docName in Documents page");
		dp.getSearchEdt().sendKeys(docName);
		dp.Document(1);
		dp.getsearchButton().click();
		Thread.sleep(2000);
		UtilityClassObject.getTest().log(Status.INFO, "Delete created docName in Documents page");
		dp.Document();
		UtilityClassObject.getTest().log(Status.PASS, "Delete created docName in Documents page");

		Thread.sleep(2000);
		System.out.println(actDocHeader);

		boolean status = actDocHeader.contains(docName);
		Assert.assertEquals(status, true);

	}
}
