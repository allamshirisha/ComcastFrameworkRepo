package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactpage {
@FindBy(xpath = "//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
private WebElement createcontact;

@FindBy(className="dvHeaderText")
private WebElement header;
public contactpage(WebDriver driver) {
	//this.driver= driver;

	
	PageFactory.initElements(driver,this);
}
public WebElement getCreatecontact() {
	return createcontact;
}
public WebElement getHeader() {
	return header;
}

}
