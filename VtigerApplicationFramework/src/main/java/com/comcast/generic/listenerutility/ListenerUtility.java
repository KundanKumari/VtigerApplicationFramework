package com.comcast.generic.listenerutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.baseclass.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

public class ListenerUtility implements ITestListener, ISuiteListener{
	
	private static  ExtentReports report;
	private static ExtentSparkReporter spark;

	//onStart method is same as a before suite
	public void onStart(ISuite suite) {
		// report config of the extent report
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		
		spark = new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		report = new ExtentReports();
		report.attachReporter(spark);
		
		spark.config().setDocumentTitle("CRM test suite results");
		spark.config().setReportName("CRM Reports");
		spark.config().setTheme(Theme.DARK);

		// add Env information & create test
		
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");
	}
	public void onFinish(ISuite suite) {
		System.out.println("Report backup");
		//backup of the report
		report.flush();
	}
//onTestStart:- onTestStart method will get execute automatically before executing each test case in the class
	public void onTestStart(ITestResult result) {
		
		//System.out.println("R:"+report);
		System.out.println("======= ======>" + result.getMethod().getMethodName() + ">======START======>");
		ExtentTest test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName()+"====> STARTED <=======");

	}
	public void onTestSucess(ITestResult result) {
		System.out.println("======= ======>"+result.getMethod().getMethodName()+">=======>END=====");
		UtilityClassObject.getTest().log(Status.PASS, result.getMethod().getMethodName()+"====> COMPLETED <=======");

	}
	public void onTestFailure(ITestResult result) {
		ExtentTest test=UtilityClassObject.getTest();
		String testName = result.getMethod().getMethodName();
		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
		String filepath = ts.getScreenshotAs(OutputType.BASE64);

		// here capture the time stamp using a java
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(filepath, testName+"_"+time);
		test.log(Status.FAIL, result.getMethod().getMethodName()+"====> FAILED <=======");

		}

}
