package com.crm.orgTest;


import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.comcast.crm.objectrepositoryUtility.createneworganisationpage;
import com.comcast.crm.objectrepositoryUtility.homepage;
import com.comcast.crm.objectrepositoryUtility.organisationpage;
import com.crm.baseTest.BaseClass;

public class createorgTest extends BaseClass {
	
	@Test(groups="ST")
	public void createorg() throws IOException {
		System.out.println("execute createorg  and verify");
		
	String orgname = eu.getDataFromExcel("org", 1, 2)+ju.getRandomNumber()	;
	
	homepage hp = new homepage(driver);
	hp.getOrglink().click();

	//click on create organisation
	organisationpage op = new organisationpage(driver);
	op.getCreateneworg().click();

	//enter all the details
	createneworganisationpage cno = new createneworganisationpage(driver);
	cno.createorg(orgname);
	
	//verify the 
		
	String headerinfo =driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	if(headerinfo.contains(orgname)) {
		
		
		System.out.println(orgname+"is created ===pass");
	}
	else {
		System.out.println(orgname+"is not created ===fail");
	}
	
	}
	@Test(groups="RT")
	public void createorgwithpn() throws IOException {
	
		
		String orgname = eu.getDataFromExcel("org", 7, 2)+ju.getRandomNumber()	;
	
		String phonenumber = eu.getDataFromExcel("org", 7, 3);
		
		//
		
		homepage hp = new homepage(driver);
		hp.getOrglink().click();

		//click on create organisation
		organisationpage op = new organisationpage(driver);
		op.getCreateneworg().click();

		//enter all the details
		createneworganisationpage cno = new createneworganisationpage(driver);
		cno.createorgwithp(orgname, phonenumber);

		
		//
		String phonenumber1 =driver.findElement(By.id("dtlview_Phone")).getText();
		if(phonenumber1.equals(phonenumber)) {
			
			System.out.println(phonenumber+"is created ===pass");
			
		}
		else {
			System.out.println(phonenumber+"is not created ===fail");

		}
		
	}
		
		
	
	@Test(groups="RT")
	public void createorgwithindustry() throws IOException {
		System.out.println("execute createorgwithindustry  and verify ");
		
		String orgname = eu.getDataFromExcel("org", 4, 2)+ju.getRandomNumber()	;

		String industry =eu.getDataFromExcel("org", 4, 3) ;
		String type = eu.getDataFromExcel("org", 4, 4);
		
		homepage hp = new homepage(driver);
		hp.getOrglink().click();

		//click on create organisation
		organisationpage op = new organisationpage(driver);
		op.getCreateneworg().click();

		//enter all the details
		createneworganisationpage cno = new createneworganisationpage(driver);
		
		cno.createorg(orgname, industry, type);
		//
		
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
		
	}
	
}
