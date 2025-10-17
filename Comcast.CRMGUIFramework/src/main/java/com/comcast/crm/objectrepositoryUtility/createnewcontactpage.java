package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createnewcontactpage {
@FindBy(name = "lastname")
private WebElement lastname;

@FindBy(name = "button")
private WebElement savebutton;

@FindBy(id ="jscal_field_support_start_date")
private WebElement startdate;
@FindBy(id ="jscal_field_support_end_date")
private WebElement enddate;

@FindBy(xpath="//input[@name='account_name']//following-sibling::img")
private WebElement org;
public createnewcontactpage(WebDriver driver) {
	//this.driver= driver;

	PageFactory.initElements(driver,this);
}

public WebElement getSavebutton() {
	return savebutton;
}

public WebElement getLastname() {
	return lastname;
}

public WebElement getStartdate() {
	return startdate;
}

public WebElement getEnddate() {
	return enddate;
}

public WebElement getOrg() {
	return org;
}

public void createwith(String lastname,String startdate,String enddate) {
	
}
}
