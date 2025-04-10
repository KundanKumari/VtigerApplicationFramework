package com.comcast.crm.baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.comcast.crm.generic.databaseutility.DatabaseUtility;
import com.comcast.crm.generic.fileutility.ExcelFile;
import com.comcast.crm.generic.fileutility.PropertyFile;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectreositoryutility.HomePage;
import com.comcast.crm.objectreositoryutility.LoginPage;

public class BaseClass {
	public PropertyFile file = new PropertyFile();
	public JavaUtility java = new JavaUtility();
	public WebDriverUtility web = new WebDriverUtility();
	public DatabaseUtility db = new DatabaseUtility();
	public ExcelFile ex = new ExcelFile();
	// global variable
	public WebDriver driver = null;
	public static WebDriver sdriver = null;

	@BeforeSuite(groups = { "SmokeTest", "regression" })
	public void configBS() throws Throwable {
		System.out.println("Open the DBconnection");
		db.getDbconnection();
	}
    @Parameters("BROWSER")
	@BeforeClass(groups = { "SmokeTest", "regression" })
	public void configBC(@Optional("chrome") String browser) throws Throwable {
		System.out.println("Open the browser");
		String Browser =browser;
		if (Browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (Browser.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		sdriver = driver;
		web.waitForPageToLoad(driver);
		UtilityClassObject.setDriver(driver);
	}

	@BeforeMethod(groups = { "SmokeTest", "regression" })
	public void configBM() throws Throwable {
		System.out.println("Login to application");
		String url=file.getPropertyFileUtility("url");
		String Username=file.getPropertyFileUtility("username");
		String Password=file.getPropertyFileUtility("password");
        LoginPage lp=new LoginPage(driver);
        lp.LoginToapp(Username, Password, url);
		
	}

	@AfterMethod(groups = { "SmokeTest", "regression" })
	public void configAM() {
		System.out.println("log out to the application");
		HomePage hp= new HomePage(driver);
		hp.logout();
	}

	@AfterClass(groups = { "SmokeTest", "regression" })
	public void configAC() {
		System.out.println("close the browser");
		driver.quit();
	}

	@AfterSuite(groups = { "SmokeTest", "regression" })
	public void congigAS() {
		System.out.println("close the connetion of DB");
		db.closeDBConnection();
	}
}
