package practise.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.baseTest.BaseClass;

public class invoiceTest extends BaseClass {
	@Test
	public void createinvoiceTest() {
		System.out.println("execute createinvoiceTest");

		String var = driver.getTitle();
		Assert.assertEquals(var, "login");
		System.out.println(var);
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
		System.out.println("step4");


	}

	@Test
	public void createinvoicewithcontactTest() {
		System.out.println("execute createinvoicewithcontactTest");
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
		System.out.println("step4");


	}

}
