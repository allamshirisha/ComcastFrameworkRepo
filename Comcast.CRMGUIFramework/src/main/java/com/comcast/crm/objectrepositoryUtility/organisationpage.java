package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class organisationpage {
	WebDriver driver;
@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createneworg;
	
@FindBy(name="search_text")
private WebElement searchbox;

@FindBy(name="search_field")
private WebElement searchdropdown;

@FindBy(name="submit")
private WebElement searchbutton;


	public organisationpage(WebDriver driver) {
		this.driver= driver;
	PageFactory.initElements(driver,this);
		
		}

	public WebElement getSearchbox() {
		return searchbox;
	}

	public WebElement getSearchdropdown() {
		return searchdropdown;
	}

	public WebElement getSearchbutton() {
		return searchbutton;
	}

	public WebElement getCreateneworg() {
		return createneworg;
	}
}
