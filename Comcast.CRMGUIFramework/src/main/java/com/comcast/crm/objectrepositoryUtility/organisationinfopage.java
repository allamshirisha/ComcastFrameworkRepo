package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class organisationinfopage {

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headermsg;

	public organisationinfopage(WebDriver driver) {
		//this.driver= driver;
	PageFactory.initElements(driver,this);
		
		}

	public WebElement getHeadermsg() {
		return headermsg;
	}
	
}
