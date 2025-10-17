package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
/**
 * @author saial
 * 
 * contains loginpage elements and bussiness library like login()
 */


public class loginpage extends WebDriverUtility {
WebDriver driver;
	@FindBy(name="user_name")
	private WebElement usernmae;
	
	@FindBy(name="user_password")
	private WebElement passworde;
	
	@FindBy(id="submitButton")
	private WebElement loginbutton;

	public loginpage(WebDriver driver) {
	this.driver= driver;
PageFactory.initElements(driver,this);
	
	}
	
	
	public WebElement getUsernmae() {
		return usernmae;
	}

	public WebElement getPassword() {
		return passworde;
	}

	public WebElement getLoginbutton() {
		return loginbutton;
	}
	
	/**
	 * login into application based on username, password,url arguments
	 * @param URL
	 * @param username
	 * @param password
	 */

	public void logintoapp(String URL,String username,String password) {
		waitforpagetoload(driver);
	driver.get(URL);
		
		usernmae.sendKeys(username);
		passworde.sendKeys(password);
		loginbutton.click();
	}
	
	
	
	}

