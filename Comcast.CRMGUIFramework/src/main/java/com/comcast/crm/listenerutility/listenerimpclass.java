package com.comcast.crm.listenerutility;

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
import com.comcast.crm.generic.webdriverutility.utilityclass;
import com.crm.baseTest.BaseClass;


public class listenerimpclass implements ITestListener,ISuiteListener {
//public static WebDriver sdriver;
	public   ExtentReports report;
	public static ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onStart(suite);
		System.out.println("Report configuration");
		//spark report config
		String time = new Date().toString().replace(" ", "_").replace(":", "_");

		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("Crm test suite results");
		spark.config().setReportName("crm reports");
		
		spark.config().setTheme(Theme.DARK);
		//add environment information and create test
		
		 report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");

	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		ISuiteListener.super.onFinish(suite);
		
		System.out.println("Report backup");
		report.flush();

	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
		System.out.println("===="+result.getMethod().getMethodName()+"========start======");
		test.log(Status.INFO,result.getMethod().getMethodName()+"========start======");
		  ExtentTest extentTest;
utilityclass.setTest(test);
		  test = report.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		System.out.println("===="+result.getMethod().getMethodName()+"========end======");
		test.log(Status.PASS,result.getMethod().getMethodName()+"========completed======");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		
		String testname = result.getMethod().getMethodName();
		
		 TakesScreenshot ts = (TakesScreenshot)BaseClass.sdriver;
			
			String filepath= ts.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		//test.addScreenCaptureFromBase64String(filepath,testname+"_"+time);
		 if (test == null) { // prevent NPE
		        test = report.createTest(testname);
		    }

		    test.addScreenCaptureFromBase64String(filepath, testname + "[" + time + "]");
		    test.log(Status.FAIL, testname + " ======== failed =======");
		

		test.log(Status.FAIL,result.getMethod().getMethodName()+"========failed======");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
		//test.log(Status.INFO,result.getMethod().getMethodName()+"========skipped======");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

	
}
