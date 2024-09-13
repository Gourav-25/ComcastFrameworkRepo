package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webDriverutility.JavaUtility;
import com.comcast.crm.generic.webDriverutility.WebDriverUtility;
import com.comcast.crm.objectRepositoryUtility.ContactInfoPage;
import com.comcast.crm.objectRepositoryUtility.ContactPage;
import com.comcast.crm.objectRepositoryUtility.CreateNewContactsPage;
import com.comcast.crm.objectRepositoryUtility.CreateNewOrganisation;
import com.comcast.crm.objectRepositoryUtility.HomePage;
import com.comcast.crm.objectRepositoryUtility.LoginPage;
import com.comcast.crm.objectRepositoryUtility.OrganisationPage;
import com.comcast.generic.fileutility.ExcelUtility;
import com.comcast.generic.fileutility.FileUtility;
/**
 * 
 * @author Aman
 * 
 */
public class CreateContactTest extends BaseClass {

	@Test(groups="smokeTest")
	public void createContact() throws Throwable {
        /* Read data from Excel*/
		int randomnumer = ju.getRandomNumber();

		String lastname = eu.getDataFromExcel("Sheet2", 1, 2) + randomnumer;

		HomePage hp = new HomePage(driver);
		hp.getContLink().click();

		ContactPage cp = new ContactPage(driver);
		cp.getCreateCon().click();

		CreateNewContactsPage ccp = new CreateNewContactsPage(driver);
		ccp.createContact(lastname);
          
		// Verify Weather lastname is same as created one
		ContactInfoPage cip = new ContactInfoPage(driver);
		String sn = cip.getSurname().getText();
		Assert.assertEquals(lastname, sn);
	}
	@Test(groups="regressionTest")
	public void createContactWithSupportDateTest() throws Throwable {
		int randomnumer = ju.getRandomNumber();

		String lastname = eu.getDataFromExcel("Sheet2", 1, 2) + randomnumer;

		String currentdate = ju.getSystemDateYYYYDDMM();
		String enddate = ju.getRequiredDateYYYYDDMM(30);

		HomePage hp = new HomePage(driver);
		hp.getContLink().click();

		ContactPage cp = new ContactPage(driver);
		cp.getCreateCon().click();

		CreateNewContactsPage ccp = new CreateNewContactsPage(driver);
		ccp.createContactWithSupportDate(lastname, currentdate, enddate);

		// Verify Weather lastname is same as created one
		
		SoftAssert asrtobj=new SoftAssert();
		ContactInfoPage cip = new ContactInfoPage(driver);
		String sn = cip.getSurname().getText();
		asrtobj.assertEquals(sn,lastname);
		// Verify Weather Support date is expected
		String ssd=cip.getSuptStartdt().getText();
		asrtobj.assertEquals(currentdate,ssd);
		String sed=cip.getSuptEnddt().getText();
        asrtobj.assertEquals(enddate,sed);	
        asrtobj.assertAll();
	}

	@Test(groups="regressionTest")
	public void createContactWithOrgTest() throws Throwable {

		int no = ju.getRandomNumber();

		String org = eu.getDataFromExcel("Sheet1", 1, 2) + no;
		

		String lastname = eu.getDataFromExcel("Sheet2", 1, 2) + no;

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OrganisationPage op = new OrganisationPage(driver);
		op.getCreateNewOrgBtn().click();

		CreateNewOrganisation cno = new CreateNewOrganisation(driver);
		cno.createOrg(org);

		Thread.sleep(5000);

		hp.getContLink().click();

		ContactPage cp = new ContactPage(driver);
		cp.getCreateCon().click(); 

		CreateNewContactsPage ccp = new CreateNewContactsPage(driver);
		ccp.createContactwithOrg(lastname, org);
		driver.findElement(By.xpath("//a[text()='" + org + "']")).click();
		wu.switchToParentWindow(driver);
		ccp.getSvbtn().click();

		String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerinfo.contains(lastname)) {
			System.out.println(lastname + " is created");
		} else {
			System.out.println(lastname + " is not created");
		}
		// Verify header orgname info expected result
		String orgname = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		System.out.println(orgname);
		if (orgname.trim().equals(org)) {
			System.out.println(org + " is created");
		} else {
			System.out.println(org + " is not created");
		}
	}
}
