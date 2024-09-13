package practice.Test;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectRepositoryUtility.LoginPage;

/**
 * 
 * test Class for ContactModule
 * @author Aman
 * 
 */
public class SearchContactTest extends BaseClass {
	/**
	 * 
	 * Login()===>NavigateToContact===>CreateContact()====>Verify
	 * 
	 */
	@Test
	public void searchContactTest() {
		/*Step1 Login To App*/
		LoginPage lp=new LoginPage(driver);
		lp.loginToapp("url","username","password");
		
	}
}
