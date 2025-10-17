package com.crm.contactTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.webdriverutility.utilityclass;
import com.comcast.crm.listenerutility.listenerimpclass;
import com.comcast.crm.objectrepositoryUtility.contactpage;
import com.comcast.crm.objectrepositoryUtility.createnewcontactpage;
import com.comcast.crm.objectrepositoryUtility.createneworganisationpage;
import com.comcast.crm.objectrepositoryUtility.homepage;
import com.comcast.crm.objectrepositoryUtility.organisationpage;
import com.crm.baseTest.BaseClass;
@Listeners(com.comcast.crm.listenerutility.listenerimpclass.class)
public class createcontactTest extends BaseClass {

	@Test(groups="ST")
	public void createcontact() throws IOException {
		
	//	listenerimpclass.test.log(Status.INFO, "read data from excel");
		utilityclass.getTest().log(Status.INFO, "read data from excel");

		String lastname = eu.getDataFromExcel("contact", 1, 2) + ju.getRandomNumber();

		System.out.println("execute createcontact and verify");

		// step2 navigate to application
		utilityclass.getTest().log(Status.INFO, "navigate to contact page");
		utilityclass.getTest().log(Status.INFO, "click on contact");
		homepage hp = new homepage(driver);
		

		hp.getContactlink().click();

		// step 3 click on contact module
		utilityclass.getTest().log(Status.INFO, "createcontact");

		contactpage cp = new contactpage(driver);
		cp.getCreatecontact().click();

		// enter all the details and create new contact
		createnewcontactpage cnp = new createnewcontactpage(driver);
		cnp.getLastname().sendKeys(lastname);
		
		cnp.getSavebutton().click();
		utilityclass.getTest().log(Status.INFO, lastname+"====created====");

		// verify the header msg expected results
String actheader = driver.findElement(By.className("dvHeaderText")).getText();
		//String actheader= cp.getHeader().getText();
boolean status =actheader.contains(lastname);
Assert.assertEquals(status, true);


		String actlastname = driver.findElement(By.id("dtlview_Last Name")).getText();
		
	//	Assert.assertEquals(actlastname, lastname);
		SoftAssert obj = new SoftAssert();
		obj.assertEquals(actlastname, lastname);
//		if (actlastname.equals(lastname)) {
//
//			System.out.println(lastname + "is created ===pass");
//		} else {
//			System.out.println(lastname + "is not created ===fail");
//		}

	}

	@Test(groups="RT")
	public void createcontactdate() throws IOException {
		System.out.println("execute createcontactdate and verify ");

		String lastname = eu.getDataFromExcel("contact", 4, 2) + ju.getRandomNumber();

		// step2 navigate to application
		homepage hp = new homepage(driver);
		hp.getContactlink().click();

		// step 3 click on contact module
		contactpage cp = new contactpage(driver);
		cp.getCreatecontact().click();

		// enter all the details and create new contact
		String startdate = ju.gettSystemDateYYYYMMDD();
		String enddate = ju.getRequiredDateYYYYDDMM(30);

		createnewcontactpage cnp = new createnewcontactpage(driver);
		cnp.getLastname().sendKeys(lastname);
		cnp.getStartdate().sendKeys(startdate);
		cnp.getEnddate().sendKeys(enddate);
		cnp.getSavebutton().click();
		// verify the start date
		String start = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if (start.equals(startdate)) {

			System.out.println(startdate + "is  created ===pass");

		} else {
			System.out.println(startdate + "is not created ===fail");

		}
		// verify the end date
		String end = driver.findElement(By.id("dtlview_Support End Date")).getText();
		if (end.equals(enddate)) {

			System.out.println(enddate + "is  created ===pass");

		} else {
			System.out.println(enddate + "is not created ===fail");

		}
	}

	@Test(groups="RT")
	public void createcontactwithorg() throws IOException {

		String orgname = eu.getDataFromExcel("contact", 7, 2) + ju.getRandomNumber();
		String contactlastname = eu.getDataFromExcel("contact", 7, 3);
		homepage hp = new homepage(driver);
		hp.getOrglink().click();

		//
		organisationpage op = new organisationpage(driver);
		op.getCreateneworg().click();

		// create organisatio link
		createneworganisationpage cno = new createneworganisationpage(driver);
		cno.createorg(orgname);

		//
		String actorgname = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		System.out.println(actorgname);
		if (actorgname.trim().equals(orgname)) {

			System.out.println(orgname + "is  created ===pass");

		} else {
			System.out.println(orgname + "is not created ===fail");

		}

		// navigate to contact module
		hp.getContactlink().click();

		// click on create new contact
		contactpage cp = new contactpage(driver);
		cp.getCreatecontact().click();
//enter all the details
		createnewcontactpage cnp = new createnewcontactpage(driver);
		cnp.getLastname().sendKeys(contactlastname);
		createneworganisationpage cno1 = new createneworganisationpage(driver);
	
	cno1.searchAndSelectOrganization(driver, orgname);
		
		cnp.getSavebutton().click();
		

		String actorgname1 = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		System.out.println(actorgname1);
		if (actorgname1.trim().equals(orgname)) {

			System.out.println(orgname + "is  created ===pass");

		} else {
			System.out.println(orgname + "is not created ===fail");

		}
	}

}
