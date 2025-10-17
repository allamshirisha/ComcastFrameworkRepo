package samplepractise;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class getproductinfoTest2 {
@Test(dataProvider = "getdata")
public void getproductinfoTest(String brandname,String productname) {
	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://amazon.in");
	
//	//search product
//	driver.findElement(By.id("nav-bb-search")).sendKeys("iphone",Keys.ENTER);
//	//capture product info
//String x = "//span[text()='Apple iphone 12 (128GB) - Black']/../../../../div[3]/div[1]/div/div[1]/div[1]/a/span/span[2]/span[2]";
//String price =driver.findElement(By.xpath(x)).getText();
//System.out.println(price);
//}
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandname,Keys.ENTER);
	
	
	//CAPTURE THE PRODUCT INFO
	
	String x="//span[text()='"+productname+"']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='a-price-whole']";

	String price=driver.findElement(By.xpath(x)).getText();
	System.out.println(price);
}
	@DataProvider
	public Object[][] getdata() throws IOException{
		ExcelUtility eu = new ExcelUtility();
	
		int rowcount = eu.getRowcount("product");
		
		Object[][] obja = new Object[rowcount][2];
	for(int i=0;i<rowcount;i++)	{
//		obja[0][0] = "iphone";
//		obja[0][1] = "Apple iPhone 15 (128 GB) - Black";
// 
//		obja[1][0] = "iphone";
//		obja[1][1] = "Apple iPhone 13 (128 GB) - Black";
//
//		obja[2][0] = "iphone";
//		obja[2][1] = "Apple iPhone 16 (128 GB) - Black";
		obja[i][0] =	eu.getDataFromExcel("product", i+1, 0);
		obja[i][1] = eu.getDataFromExcel("product", i+1, 1);
		
	}
	return obja;
	
	}
}
