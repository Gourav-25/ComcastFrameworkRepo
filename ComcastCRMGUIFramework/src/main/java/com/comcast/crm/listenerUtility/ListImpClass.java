package com.comcast.crm.listenerUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webDriverutility.UtilityClassObject;


public class ListImpClass implements ITestListener,ISuiteListener{

	public  static ExtentReports report;
	public  ExtentSparkReporter spark;
	public static ExtentTest test;
@Override
	public void onStart(ISuite suite) {
		System.out.println("Report Configuration");
		String time=new Date().toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		  spark.config().setDocumentTitle("CRM Test Suite Result");
		  spark.config().setReportName("CRM Report");
		  spark.config().setTheme(Theme.DARK);
		  //add Env information and create Test
		  report=new ExtentReports();
		  report.attachReporter(spark);
		  report.setSystemInfo("OS","Windows10");
		  report.setSystemInfo("BROWSER","CHROME-100");
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("ReportBackup");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(result.getMethod().getMethodName()+"START");
		 test=report.createTest(result.getMethod().getMethodName());
		 UtilityClassObject.setTest(test); 
		 test.log(Status.INFO,result.getMethod().getMethodName()+"Started");
	}
	@Override
	public void onTestSuccess(ITestResult result) {
	System.out.println(result.getMethod().getMethodName()+"ENDED");
	test.log(Status.INFO,result.getMethod().getMethodName()+"ENDED");
	}

	@Override
	public void onTestFailure(ITestResult result) {
	 	// TODO Auto-generated method stub
		String testName=result.getMethod().getMethodName();
		//Downcast the driver reference from WebDriver type to TakesScreenshot Type
				TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
				//use getScreenshotAs method and store it temprorarily		
				String filepath=ts.getScreenshotAs(OutputType.BASE64);
				//Create perm location to store file by creating an object for file class
				String time=new Date().toString().replace(" ", "_").replace(":", "_");
			   //	File perm=new File("./screenshot/"+testName+"+"+time+".png");
				//Copy from  temp and store it in perm location				
					/*try {
						FileHandler.copy(temp, perm);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}*/
				//Capturing the Screenshot
				test.addScreenCaptureFromBase64String(filepath,testName+"_"+time);
				test.log(Status.INFO,result.getMethod().getMethodName()+"FAILED");
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	
		
	}

	@Override
	public void onStart(ITestContext context) {

		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
}
