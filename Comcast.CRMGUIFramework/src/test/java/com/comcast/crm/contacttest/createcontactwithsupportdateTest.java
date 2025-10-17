package com.comcast.crm.contacttest;



		import java.io.FileInputStream;
		import java.io.FileNotFoundException;
		import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
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

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
		public class createcontactwithsupportdateTest {

			public static void main(String[] args) throws IOException {
				// TODO Auto-generated method stub
				
		
//				//read common data from propertiesfile
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
				/*create objec * */
				FileUtility fu = new FileUtility();
				
				ExcelUtility eu = new ExcelUtility();

				
				
				// steps : get the value based on key
		String BROWSER =	fu.getdataFromPropertiesFile("browser")	;
		String URL	=	fu.getdataFromPropertiesFile("URL");

		String USERNAME =	fu.getdataFromPropertiesFile("username")	;
		String PASSWORD =	fu.getdataFromPropertiesFile("password")	;


		//generate random number
		JavaUtility ju = new JavaUtility();
WebDriverUtility wu = new WebDriverUtility();
		//read data from excel file

//			FileInputStream fis1 = new FileInputStream("./resources/org.xlsx");
//			
//			Workbook book = WorkbookFactory.create(fis1)	;
//			
//		Sheet sh =	book.getSheet("contact");
//		Row row =	sh.getRow(4);
//			
//			String lastname = row.getCell(2).toString() + ju.getRandomNumber();
//			book.close();
//			
//			System.out.println(lastname);
	String lastname = eu.getDataFromExcel("contact", 4, 2)  + ju.getRandomNumber();

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


		//click to contact
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		//click on create contact
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		//enter the contact name and select the Assigned To
		
//		Date dateobj = new Date();
//		//	System.out.println(dateobj.toString());
//			
//			
//			SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
//		String startdate =	sim.format(dateobj);
//		System.out.println(startdate);
//		
//	Calendar  cal = sim.getCalendar();
//		cal.add(Calendar.DAY_OF_MONTH,30);
//	String enddate =	sim.format(cal.getTime());
		
//		System.out.println(enddate);
		
	String startdate =	ju.gettSystemDateYYYYMMDD();
	String enddate = ju.getRequiredDateYYYYDDMM(30);
	
	
	
	
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);

		driver.findElement(By.xpath("(//input[@type=\"radio\"])[1]")).click();
		
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(startdate);
		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(enddate);


		
		
		//save the contact
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();

				
			//verify the header msg expected results

		String headerinfo =driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerinfo.contains(lastname)) {
			
			
			System.out.println(lastname+"is created ===pass");
		}
		else {
			System.out.println(lastname+"is not created ===fail");
		}


		//verify the header org name info   expected results 

		String actorgname =driver.findElement(By.id("dtlview_Last Name")).getText();
		if(actorgname.equals(actorgname)) {
			
			System.out.println(actorgname+"is  created ===pass");
			
		}
		else {
			System.out.println(actorgname+"is not created ===fail");

		}
		String start =driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if(start.equals(startdate)) {
			
			System.out.println(startdate+"is  created ===pass");
			
		}
		else {
			System.out.println(startdate+"is not created ===fail");

		}
		String end =driver.findElement(By.id("dtlview_Support End Date")).getText();
		if(end.equals(enddate)) {
			
			System.out.println(enddate+"is  created ===pass");
			
		}
		else {
			System.out.println(enddate+"is not created ===fail");

		}


		//logout
				
				
			driver.quit();	
				
				
				
			}

		}

	