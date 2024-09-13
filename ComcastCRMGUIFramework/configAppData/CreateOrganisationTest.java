package com.comcast.crm.orgTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webDriverutility.JavaUtility;
import com.comcast.crm.generic.webDriverutility.WebDriverUtility;
import com.comcast.crm.objectRepositoryUtility.HomePage;
import com.comcast.crm.objectRepositoryUtility.LoginPage;
import com.comcast.crm.objectRepositoryUtility.OrganisationInfoPage;
import com.comcast.crm.objectRepositoryUtility.CreateNewOrganisation;
import com.comcast.crm.objectRepositoryUtility.OrganisationPage;
import com.comcast.generic.fileutility.ExcelUtility;
import com.comcast.generic.fileutility.FileUtility;

public class CreateOrganisationTest extends BaseClass {

	@Test(groups="smokeTest")
	public void createOrganisation() throws Throwable {

		int no = ju.getRandomNumber();
		String org = eu.getDataFromExcel("Sheet1", 1, 2) + no;

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OrganisationPage op = new OrganisationPage(driver);
		op.getCreateNewOrgBtn().click();

		CreateNewOrganisation cno = new CreateNewOrganisation(driver);
		cno.createOrg(org);

		// verify Header msg Expected result
		OrganisationInfoPage oip = new OrganisationInfoPage(driver);
		String msg = oip.getHdrmsg().getText();
		String msg1 = oip.getNameOfOrg().getText();
		if (msg.contains(org)) {
			System.out.println(org + "is present");
		} else
			System.out.println(org + "is not present");

		// Verify header orgname info expected result
		if (msg1.equals(org)) {
			System.out.println(org + "is present");
		} else {
			System.out.println(org + "is not present");
		}
	}

	@Test(groups="regressionTest")
	public void createOrganisationWithPhoneNumberTest() throws Throwable {

		int no = ju.getRandomNumber();
		String org = eu.getDataFromExcel("Sheet1", 1, 2) + no;
		String phoneno = eu.getDataFromExcel("Sheet1", 7, 3);

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OrganisationPage op = new OrganisationPage(driver);
		op.getCreateNewOrgBtn().click();

		CreateNewOrganisation cno = new CreateNewOrganisation(driver);
		cno.createOrgWithPhoneNumber(org, phoneno);

		// verify Header msg Expected result
		String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (headerinfo.contains(org)) {
			System.out.println(org + " is created");
		} else {
			System.out.println(org + " is not created");
		}
		// Verify header orgname info expected result
		String orgname = driver.findElement(By.id("dtlview_Organization Name")).getText();
		if (org.equals(orgname)) {
			System.out.println(org + " is created");
		} else {
			System.out.println(org + " is not created");
		}
		// Verify Phone no Expected result
		String number = driver.findElement(By.xpath("//span[@id='dtlview_Phone']")).getText();
		if (number.equals(phoneno)) {
			System.out.println(phoneno + " is created");
		} else {
			System.out.println(phoneno + " is not created");
		}
	}

	@Test(groups="regressionTest")
	public void createOrganisationWithIndustriesTest() throws Throwable {

		int no = ju.getRandomNumber();
		String org = eu.getDataFromExcel("Sheet1", 1, 2) + no;
		String indtype = eu.getDataFromExcel("Sheet1", 4, 3);
		String type1 = eu.getDataFromExcel("Sheet1", 4, 4);

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OrganisationPage op = new OrganisationPage(driver);
		op.getCreateNewOrgBtn().click();

		CreateNewOrganisation cno = new CreateNewOrganisation(driver);
		cno.createOrgWithInd(org, indtype, type1);

		// Verify IndustryExpected result
		String typeofind = driver.findElement(By.id("dtlview_Industry")).getText();
		if (typeofind.equals(indtype)) {
			System.out.println(indtype + " is created");
		} else {
			System.out.println(indtype + " is not created");
		}
		// Verify Type Expected result
		String typein = driver.findElement(By.id("dtlview_Type")).getText();
		if (typein.equals(type1)) {
			System.out.println(type1 + " is created");
		} else {
			System.out.println(type1 + " is not created");
		}
	}
}