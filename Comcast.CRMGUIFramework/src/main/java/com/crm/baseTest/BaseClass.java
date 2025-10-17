package com.crm.baseTest;

import java.io.IOException;
import java.sql.SQLException;

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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DatabaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.generic.webdriverutility.utilityclass;
import com.comcast.crm.objectrepositoryUtility.homepage;
import com.comcast.crm.objectrepositoryUtility.loginpage;

public class BaseClass {
	public FileUtility fu = new FileUtility();
	public ExcelUtility eu = new ExcelUtility();
	public JavaUtility ju = new JavaUtility();
	public WebDriverUtility wb = new WebDriverUtility();
	public DatabaseUtility bd = new DatabaseUtility();
	public utilityclass s = new utilityclass();
	public WebDriver driver;
	  ExtentTest extentTest;
	public static WebDriver sdriver;
	@BeforeSuite(groups={"ST","RT"})
	public void configbs() throws SQLException {
		System.out.println("===connect to db ,report config===");
		
		bd.getDbconnection();
		
		
	}
	//@Parameters("BROWSER")
	@BeforeClass(groups={"ST","RT"})
	public void configbc() throws Exception {
		System.out.println("===launch browser==== ");
		String BROWSER = fu.getdataFromPropertiesFile("browser");
	//String BROWSER = browser;
		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		sdriver = driver;
		
		utilityclass.setdriver(driver);
	}
@BeforeMethod(groups={"ST","RT"})
public void configbm() throws IOException {
	System.out.println("======login===== ");
	wb.waitforpagetoload(driver);
	String URL	=	fu.getdataFromPropertiesFile("URL");

	String USERNAME =	fu.getdataFromPropertiesFile("username")	;
	String PASSWORD =	fu.getdataFromPropertiesFile("password")	;

	loginpage lp= new loginpage(driver);
	lp.logintoapp(URL, USERNAME, PASSWORD);
	
	utilityclass.setTest(extentTest); 
}
@AfterMethod(groups={"ST","RT"})
public void configam() {
	System.out.println("======logout====== ");
	homepage hp = new homepage(driver);
	hp.logout();

}
@AfterClass(groups={"ST","RT"})
public void configac() {
	System.out.println("=====close the browser===== ");
	driver.quit();
}
@AfterSuite(groups={"ST","RT"})
public void configas() throws SQLException {
	System.out.println("====close the db,report backup==== ");
	bd.closeDbconnection();
}
}

