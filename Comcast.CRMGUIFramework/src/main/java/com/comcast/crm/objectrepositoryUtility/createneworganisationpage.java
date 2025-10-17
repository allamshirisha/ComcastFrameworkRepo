package com.comcast.crm.objectrepositoryUtility;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class createneworganisationpage {

	@FindBy(name="accountname")
private WebElement orgnamee;
	
	@FindBy(id="phone")
	private WebElement phonenumb;
	
	 @FindBy(xpath = "//input[@name='account_name']//following-sibling::img")
	    private WebElement organizationLookupImg;

		
	@FindBy(name="industry")
	private WebElement indus;
@FindBy(name="accounttype")
private WebElement typesel;
	
	@FindBy(name="button")
	private WebElement savebutton;

	public createneworganisationpage(WebDriver driver) {
		//this.driver= driver;

		PageFactory.initElements(driver,this);
	}

	public WebElement getOrgname() {
		return orgnamee;
	}

	public WebElement getPhonenumber() {
		return phonenumb;
	}

	
	public WebElement getOrganizationLookupImg() {
		return organizationLookupImg;
	}


	@FindBy(name = "search_text")
    private WebElement orgSearchTxt;

    @FindBy(xpath= "//input[@type='button']")
    private WebElement orgSearchBtn;

	public WebElement getIndus() {
		return indus;
	}

	public WebElement getSavebutton() {
		return savebutton;
	}
	public void createorg(String orgname ) {
		orgnamee.sendKeys(orgname);
	
		savebutton.click();
		
	}
	public void createorgwithp(String orgname ,String phonenumber) {
		orgnamee.sendKeys(orgname);
		phonenumb.sendKeys(phonenumber);
		savebutton.click();
		
	}
	public void createorg(String orgname , String industry,String type) {
		orgnamee.sendKeys(orgname);	
		Select sel = new Select(indus);
		sel.selectByVisibleText(industry);
		
		Select se = new Select(typesel);
		se.selectByVisibleText(type);

		
		
		savebutton.click();
		
	}
	 public void searchAndSelectOrganization(WebDriver driver, String orgName) {
	    //   wu.switchToTabOnUrl(driver, "module=Accounts");
		 organizationLookupImg.click();
			String parent = driver.getWindowHandle();

		 driver.switchTo().window(parent);
		 Set<String> child = driver.getWindowHandles();
		 for(String word : child) {
			 driver.switchTo().window(word);
		 }
		 
	        orgSearchTxt.sendKeys(orgName);
	        orgSearchBtn.click();
	        
	        driver.findElement(org.openqa.selenium.By.xpath("//a[text()='" + orgName + "']")).click();

	       
	       driver.switchTo().window(parent);
	       // wu.switchToTabOnUrl(driver, "Contacts&action");
	    }
}
