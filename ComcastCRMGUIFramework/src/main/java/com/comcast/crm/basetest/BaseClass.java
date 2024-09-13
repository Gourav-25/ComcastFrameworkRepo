package com.comcast.crm.basetest;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.database.DatabaseUtility;
import com.comcast.crm.generic.webDriverutility.JavaUtility;
import com.comcast.crm.generic.webDriverutility.UtilityClassObject;
import com.comcast.crm.generic.webDriverutility.WebDriverUtility;
import com.comcast.crm.objectRepositoryUtility.HomePage;
import com.comcast.crm.objectRepositoryUtility.LoginPage;
import com.comcast.generic.fileutility.ExcelUtility;
import com.comcast.generic.fileutility.FileUtility;

public class BaseClass {
	public DatabaseUtility du = new DatabaseUtility();
	public FileUtility fu = new FileUtility();
	public ExcelUtility eu = new ExcelUtility();
	public JavaUtility ju = new JavaUtility();
	public WebDriverUtility wu = new WebDriverUtility();
	public WebDriver driver = null;	
    public static WebDriver sdriver=null;
   
	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void ConfigBS() throws SQLException {
		System.out.println("Connect To Db,Report Config");
		du.getDbConnection();
		
	}
     // @Parameters("BROWSER")
	@BeforeClass(groups={"smokeTest","regressionTest"})
	//public void configBC(String browser) throws Throwable {
	public void conigBC() throws Throwable {
		System.out.println("Launch the Browser");
		//String Data=browser;
		String Data = fu.getDataFromPropertiesFile("browser");

		if (Data.equals("chrome"))
			driver = new ChromeDriver();
		else if (Data.equals("firefox"))
			driver = new FirefoxDriver();
		else if (Data.equals("edge"))
			driver = new EdgeDriver();
		else {
			driver = new ChromeDriver();
		}
		sdriver=driver;
		UtilityClassObject.setDriver(driver);
	}
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void configBM() throws Throwable {
		System.out.println("Login");
		LoginPage lp = new LoginPage(driver);
		String Data1 = fu.getDataFromPropertiesFile("url");
		String Data2 = fu.getDataFromPropertiesFile("username");
		String Data3 = fu.getDataFromPropertiesFile("password");
		lp.loginToapp(Data1, Data2, Data3);
	}

	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void configAM() {
		System.out.println("Logout");
		HomePage hp = new HomePage(driver);
		hp.logout();  
	}

	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void configAC() {
		System.out.println("Close the Browser");
		driver.quit();
	}

	@AfterSuite(groups={"smokeTest","regressionTest"})
	public void ConfigAS() throws SQLException {
		System.out.println("Close DB,Report BackUP");
		du.closeDbConnection();		
	}    
}
