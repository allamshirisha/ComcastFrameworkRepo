package com.comcast.crm.orgtest;

import java.io.FileInputStream;
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class crearteorg_industryTest {

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
		Row row =	sh.getRow(4);
			
			String orgname = row.getCell(2).toString() + randomInt;
			String industry = row.getCell(3).toString();
			String type = row.getCell(4).toString();

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
		
	WebElement wbsel =	driver.findElement(By.name("industry"));
		
	Select sel = new Select(wbsel);
	sel.selectByVisibleText(industry);
		
	WebElement typesel =	driver.findElement(By.name("accounttype"));
	Select se = new Select(typesel);
	se.selectByVisibleText(type);

		
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


		//verify the header org name info   expected results 

		String actorgname =driver.findElement(By.id("dtlview_Organization Name")).getText();
		if(actorgname.equals(orgname)) {
			
			System.out.println(orgname+"is created ===pass");
			
		}
		else {
			System.out.println(orgname+"is not created ===fail");

		}
//verift the dropdown industries and  type info

		String actIndustry =driver.findElement(By.id("dtlview_Industry")).getText();
		if(actIndustry.equals(industry)) {
			
			System.out.println(industry+"information is verified ===pass");
			
		}
		else {
			System.out.println(industry+"information is notverified===fail");

		}

		String actType =driver.findElement(By.id("dtlview_Type")).getText();
		if(actType.equals(type)) {
			
			System.out.println(type+"information is verified ===pass");
			
		}
		else {
			System.out.println(type+"information is notverified===fail");

		}

		//logout
				
				
			driver.quit();	
				
				
	}

}
