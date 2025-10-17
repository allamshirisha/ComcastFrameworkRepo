package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class createorganisationwithphonenumberTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//read common data from propertiesfile
				FileInputStream fis = new FileInputStream("./ConfigAppData/cmdata.properties");
				//steps : using properties class,load all the keys
				
				Properties pobj = new Properties();
				pobj.load(fis);
				
				
				
				// steps : get the value based on key
		String BROWSER =		pobj.getProperty("browser");
		String URL	=	pobj.getProperty("URL");
		String USERNAME =		pobj.getProperty("username");
		String PASSWORD =		pobj.getProperty("password");


		//generate random number
		Random random = new Random();
		int randomInt    =     random.nextInt(1000);
		System.out.println(randomInt);
		//read data from excel file

			FileInputStream fis1 = new FileInputStream("./resources/org.xlsx");
			
			Workbook book = WorkbookFactory.create(fis1)	;
			
		Sheet sh =	book.getSheet("org");
		Row row =	sh.getRow(7);
			
			String orgname = row.getCell(2).toString() + randomInt;
			String phonenumber = row.getCell(3).toString();

			book.close();
			
			System.out.println(orgname);
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
		
		driver.findElement(By.id("phone")).sendKeys(phonenumber);
		
		
		
		
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


		//verify the header org name info   expected results 

		String actorgname =driver.findElement(By.id("dtlview_Organization Name")).getText();
		if(actorgname.equals(orgname)) {
			
			System.out.println(orgname+"is  created ===pass");
			
		}
		else {
			System.out.println(orgname+"is not created ===fail");

		}
		
		String phonenumber1 =driver.findElement(By.id("dtlview_Phone")).getText();
		if(phonenumber1.equals(phonenumber)) {
			
			System.out.println(phonenumber+"is created ===pass");
			
		}
		else {
			System.out.println(phonenumber+"is not created ===fail");

		}
		
		


		//logout
				
				
			driver.quit();	
				
				
				
				
	}

}
