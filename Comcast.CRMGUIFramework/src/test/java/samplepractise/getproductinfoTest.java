package samplepractise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class getproductinfoTest {
@Test
public void getproductinfoTest() {
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
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone",Keys.ENTER);
	
	
	//CAPTURE THE PRODUCT INFO
	
	String x="//span[text()='Apple iPhone 15 (128 GB) - Black']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='a-price-whole']";

	String price=driver.findElement(By.xpath(x)).getText();
	System.out.println(price);
	
	driver.close();
	
}
}
