package com.comcast.crm.orgtest;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryUtility.createneworganisationpage;
import com.comcast.crm.objectrepositoryUtility.homepage;
import com.comcast.crm.objectrepositoryUtility.loginpage;
import com.comcast.crm.objectrepositoryUtility.organisationinfopage;
import com.comcast.crm.objectrepositoryUtility.organisationpage;

public class pom {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		/*create objec * */
		FileUtility fu = new FileUtility();
		
		ExcelUtility eu = new ExcelUtility();

		
		
		// steps : get the value based on key
String BROWSER =	fu.getdataFromPropertiesFile("browser")	;
String URL	=	fu.getdataFromPropertiesFile("URL");

String USERNAME =	fu.getdataFromPropertiesFile("username")	;
String PASSWORD =	fu.getdataFromPropertiesFile("password")	;


//generate random number
//Random random = new Random();
//int randomInt    =     random.nextInt(1000);
//System.out.println(randomInt);
JavaUtility ju = new JavaUtility();

//read data from excel file

//	FileInputStream fis1 = new FileInputStream("./resources/org.xlsx");
//	
//	Workbook book = WorkbookFactory.create(fis1)	;
//	
//Sheet sh =	book.getSheet("contact");
//Row row =	sh.getRow(1);
//	
//	String lastname = row.getCell(2).toString() + randomInt;
//	book.close();
//	
//	System.out.println(lastname);



String orgnmae = eu.getDataFromExcel("org", 1, 2) + ju.getRandomNumber();
WebDriver driver;
if(BROWSER.equals("chrome")) {
	driver = new ChromeDriver();
}
else if (BROWSER.equals("Firefox")) {
	driver = new FirefoxDriver();
}
else if (BROWSER.equals("edge")) {
	driver = new EdgeDriver();
}
else {
	driver = new ChromeDriver();
}

driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
driver.get(URL);

loginpage lp = new loginpage(driver);
//lp.getUsernmae().sendKeys("admin");
//lp.getPassword().sendKeys("admin");	
//lp.getLoginbutton().click();

lp.logintoapp( URL,USERNAME, PASSWORD);

homepage hp = new homepage(driver);
hp.getOrglink().click();

organisationpage op = new organisationpage(driver);
op.getCreateneworg().click();
createneworganisationpage cp = new createneworganisationpage(driver);
cp.createorg(orgnmae);

	//verify the header msg expected results
organisationinfopage oip = new organisationinfopage(driver);

//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//wait.until(ExpectedConditions.visibilityOf(oip.getHeadermsg()));

String actualorg =oip.getHeadermsg().getText();

if(actualorg.contains(orgnmae)) {
	System.out.println(orgnmae+"is created ===pass");
	}
	else {
	System.out.println(orgnmae+"is not created ===fail");
}	

hp.logout();

driver.quit();



//String headerinfo =driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
//if(headerinfo.contains(lastname)) {
//	
//	
//	System.out.println(lastname+"is created ===pass");
//}
//else {
//	System.out.println(lastname+"is not created ===fail");
//}
//
//
////verify the header org name info   expected results 
//
//String actorgname =driver.findElement(By.id("dtlview_Last Name")).getText();
//if(actorgname.equals(actorgname)) {
//	
//	System.out.println(actorgname+"is  created ===pass");
//	
//}
//else {
//	System.out.println(actorgname+"is not created ===fail");
//
//}
//
//
////logout
//		
//		
//	driver.quit();	
//		
	}	
}
