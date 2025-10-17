package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homepage {
WebDriver driver;
	@FindBy(linkText ="Organizations")
	private WebElement orglink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactlink;
	
	@FindBy(linkText = "Products")
	private WebElement Productslink;
	
	public WebElement getContactlink() {
		return contactlink;
	}

	@FindBy(linkText ="More")
	private WebElement morelink;

	@FindBy(linkText ="Campaigns")
	private WebElement campaignlink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminimg;
	@FindBy(linkText ="Sign Out")
	private WebElement signoutlink;

	public homepage(WebDriver driver) {
		this.driver= driver;

		PageFactory.initElements(driver,this);
	}
	
	public WebElement getMorelink() {
		return morelink;
	}

	public WebElement getCampaignlink() {
		return campaignlink;
	}

	public WebElement getOrglink() {
		return orglink;
	}
	
	public WebElement getAdminimg() {
		return adminimg;
	}

	public WebElement getSignoutlink() {
		return signoutlink;
	}

	public void navigatetocamp() {
		
		Actions act = new Actions(driver);
	act.moveToElement(morelink).perform();
	campaignlink.click();	
	}
	
	public void logout() {
		Actions act = new Actions(driver);
		act.moveToElement(adminimg).perform();
		signoutlink.click();
	}
}
