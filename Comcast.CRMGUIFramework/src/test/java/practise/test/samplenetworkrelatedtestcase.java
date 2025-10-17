package practise.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.baseTest.BaseClass;

public class samplenetworkrelatedtestcase extends BaseClass {

	@Test(retryAnalyzer = com.comcast.crm.listenerutility.RetryListenerimp.class)
	public void activateTest() {
		System.out.println("execute activateTest");

		
	//	Assert.assertEquals("", "login");
			System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");
		System.out.println("step4");


	}
}
