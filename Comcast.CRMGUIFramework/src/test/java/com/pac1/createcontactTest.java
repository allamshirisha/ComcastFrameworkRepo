package com.pac1;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class createcontactTest {
	@BeforeSuite
	public void configbs() {
		System.out.println("execute configbs");
		
	}
	@BeforeClass
	public void configbc() {
		System.out.println("execute configbc ");
		
	}
@BeforeMethod
public void configbm() {
	System.out.println("execute configbm ");
	
}
	@Test
	public void createcontact() {
		System.out.println("execute createcontact ");
	}
	@Test
	public void createcontactd() {
		System.out.println("execute createcontactd ");
	}
	@AfterMethod
	public void configam() {
		System.out.println("execute configam ");

	}
	@AfterClass
	public void configac() {
		System.out.println("execute configac ");
		
	}
	@AfterSuite
	public void configas() {
		System.out.println("execute configas ");
		
	}
}
