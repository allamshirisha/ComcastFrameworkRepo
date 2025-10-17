package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class createcontactwithorg {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//read common data from propertiesfile
//				FileInputStream fis = new FileInputStream("./ConfigAppData/cmdata.properties");
//				//steps : using properties class,load all the keys
//				
//				Properties pobj = new Properties();
//				pobj.load(fis);
//				
//				
//				
//				// steps : get the value based on key
//		String BROWSER =		pobj.getProperty("browser");
//		String URL	=	pobj.getProperty("URL");
//		String USERNAME =		pobj.getProperty("username");
//		String PASSWORD =		pobj.getProperty("password");
//
		/*create objec * */
		FileUtility fu = new FileUtility();
		
		ExcelUtility eu = new ExcelUtility();

		
		
		// steps : get the value based on key
String BROWSER =	fu.getdataFromPropertiesFile("browser")	;
String URL	=	fu.getdataFromPropertiesFile("URL");

String USERNAME =	fu.getdataFromPropertiesFile("username")	;
String PASSWORD =	fu.getdataFromPropertiesFile("password")	;


		//generate random number
//		Random random = new Random();
//		int randomInt    =     random.nextInt(1000);
//		System.out.println(randomInt);

JavaUtility ju = new JavaUtility();
WebDriverUtility wu = new WebDriverUtility();
		//read data from excel file

//			FileInputStream fis1 = new FileInputStream("./resources/org.xlsx");
//			
//			Workbook book = WorkbookFactory.create(fis1)	;
//			
//		Sheet sh =	book.getSheet("contact");
//		Row row =	sh.getRow(7);
//			
//			String orgname = row.getCell(2).toString() + randomInt;
//			String contactlastname = row.getCell(3).toString();
//
//			book.close();
//			
//			System.out.println(contactlastname);
		
		String orgname = eu.getDataFromExcel("contact", 7, 2) + ju.getRandomNumber();
	String contactlastname = eu.getDataFromExcel("contact", 7, 3);

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

		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wu.waitforpagetoload(driver);
		driver.get(URL);
		driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		//click to organisation
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		//click on create organisation
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
		//enter the organisation name and select the Assigned To
		driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(orgname);

		driver.findElement(By.xpath("(//input[@type=\"radio\"])[1]")).click();
		//save the organisation
		driver.findElement(By.xpath("(//input[@name=\"button\"])[1]")).click();
		//verify the header msg expected results

		String headerinfo =driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerinfo.contains(orgname)) {
			
			
			System.out.println(orgname+"is created ===pass");
		}
		else {
			System.out.println(orgname+"is not created ===fail");
		}


		
		//click to contact
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		//click on create contact
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		//enter the contact name and select the Assigned To
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(contactlastname);

		driver.findElement(By.xpath("(//input[@type=\"radio\"])[1]")).click();
		
		driver.findElement(By.xpath("//input[@name='account_name']//following-sibling::img")).click();
		
		//switch to child window
		
//Set<String>	 set =	driver.getWindowHandles();
//Iterator<String>it = set.iterator();
//while(it.hasNext()) {
//	String windowid = it.next();//caputure
//	driver.switchTo().window(windowid);//switch to window
//	 String url =driver.getCurrentUrl();
//	 
//	 if(url.contains("module=Accounts")) {
//		 break;
//	 }
//}
	wu.switchtotabonurl(driver,"module=Accounts" );	
		driver.findElement(By.name("search_text")).sendKeys(orgname);
		
		driver.findElement(By.name("search")).click();
		
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		
		//switch to parent window
//		Set<String>	 set1 =	driver.getWindowHandles();
//		Iterator<String>it1 = set1.iterator();
//		while(it1.hasNext()) {
//			String windowid = it1.next();//caputure
//			driver.switchTo().window(windowid);//switch to window
//			 String url =driver.getCurrentUrl();
//			 
//			 if(url.contains("Contacts&action")) {
//				 break;
//			 }
//		}
		wu.switchtotabonurl(driver,"Contacts&action" );	
		
		//save the contact
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();

				
			//verify the header msg expected results

		String headerinfo1 =driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerinfo1.contains(contactlastname)) {
			
			
			System.out.println(contactlastname+"is created ===pass");
		}
		else {
			System.out.println(contactlastname+"is not created ===fail");
		}


		//verify the header org name info   expected results 

		String actorgname =driver.findElement(By.id("mouseArea_Organization Name")).getText();
		System.out.println(actorgname);
		if(actorgname.trim().equals(orgname)) {
			
			System.out.println(orgname+"is  created ===pass");
			
		}
		else {
			System.out.println(orgname+"is not created ===fail");

		}


		//logout
				
				
		 driver.quit();	
	}

}
