package practice.Test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

public class ActiveSim extends BaseClass {
 @Test(retryAnalyzer=com.comcast.crm.listenerUtility.RetryListenerImpl.class)
 public void ActivateSim() {
	 System.out.println("execute createInvoiceTest");	
	 String actTitle=driver.getTitle();
	 Assert.assertEquals(actTitle,"Login");
	 System.out.println("Step-1");
	 System.out.println("Step-2");
	 System.out.println("Step-3");
	 System.out.println("Step-4");
    }
}
