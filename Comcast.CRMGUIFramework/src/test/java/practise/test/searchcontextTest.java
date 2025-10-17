package practise.test;
/**
 * test class for contact module
 * @author saial
 */

import org.testng.annotations.Test;

import com.comcast.crm.objectrepositoryUtility.loginpage;
import com.crm.baseTest.BaseClass;

public class searchcontextTest  extends BaseClass{
/**
 * scenario : login() ====>navigate to contact====>create contact ===> verify
 */
	@Test
	public void searchcontextTest() {
		
		/*step-1 : login to app */
		loginpage lp = new loginpage(driver);
		lp.logintoapp("url", "username", "password");
	}
}
