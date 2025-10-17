package com.comcast.crm.generic.webdriverutility;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public void waitforpagetoload(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	}
	public void Waitforelementpresent(WebDriver driver , WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void switchtotabonurl(WebDriver driver,String partialurl) {
		Set<String>	 set =	driver.getWindowHandles();
		Iterator<String>it = set.iterator();
		while(it.hasNext()) {
			String windowid = it.next();//caputure
			driver.switchTo().window(windowid);//switch to window
			 String url =driver.getCurrentUrl();
			 
			 if(url.contains(partialurl)) {
				 break;
			 }
		}
	}
	public void switchtotabontitle(WebDriver driver,String partialtitle) {
		Set<String>	 set =	driver.getWindowHandles();
		Iterator<String>it = set.iterator();
		while(it.hasNext()) {
			String windowid = it.next();//caputure
			driver.switchTo().window(windowid);//switch to window
			 String url =driver.getCurrentUrl();
			 
			 if(url.contains(partialtitle)) {
				 break;
			 }
		}
	}
	public void switchtoframre(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	public void switchtoframre(WebDriver driver,String name) {
		driver.switchTo().frame(name);
	}
	public void switchtoframre(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void switchtoalertandaccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void switchtoalertanddismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void select(WebElement element,String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	public void select(WebElement element,int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	public void mousemoveonelement(WebDriver driver,WebElement element) {
		Actions ac = new Actions(driver);
		ac.moveToElement(element).perform();
	}
	public void doubleclick(WebDriver driver,WebElement element) {
		Actions ac = new Actions(driver);
		ac.doubleClick(element).perform();
	}
}
