package com.guru99.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListner implements ITestListener {
	
	ExtentSparkReporter htmlreport;
	ExtentReports report;
	ExtentTest test;
	
	public static ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<ExtentTest>();
	
	public void ConfigureReport() {
		
		String timestamp=new SimpleDateFormat("YYYY_MM_DD_hh_mm_ss").format(new Date());
		String reportname="SummaryReport.html";
		
		htmlreport=new ExtentSparkReporter("./Reports/"+reportname);
		
		
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		
		report.setSystemInfo("Machine:", "testpc1");
		report.setSystemInfo("OS:", "Windows11");
		report.setSystemInfo("browser:", "Chrome");
		report.setSystemInfo("User name:", "Sateesh");	
		
		htmlreport.config().setDocumentTitle("Summary Repprt");
		htmlreport.config().setTheme(Theme.DARK);
		
		
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Case " + result.getName() + " Started");

        // Create the test for reporting
        ExtentTest test = report.createTest(result.getName());
        extentTestThreadLocal.set(test); // Store the test in the current thread
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentTest test= extentTestThreadLocal.get();
		test.log(Status.PASS, MarkupHelper.createLabel( result.getName()+" "+" is passed", ExtentColor.GREEN));
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentTest test= extentTestThreadLocal.get();
		String failureMessage = result.getThrowable() != null ? result.getThrowable().getMessage() : "Unknown error occurred";
		test.fail(failureMessage);
		test.log(Status.FAIL, MarkupHelper.createLabel( result.getName()+" "+"is failed", ExtentColor.RED));
		 WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");  
		 byte[] screenshotInBytes= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		String screenshot=Base64.getEncoder().encodeToString(screenshotInBytes);
		test.addScreenCaptureFromBase64String(screenshot);
		//test.fail("Captured Screenshot is below:" + test.addScreenCaptureFromBase64String(screenshot));
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ConfigureReport();
		System.out.println("report started and OnStart is also started executing");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		report.flush();
	}
	
//	public ExtentTest createTest(String testname) {
//		System.out.println("Create Test Name Started running");
//		test=report.createTest(testname);
//		extentTestThreadLocal.set(test);
//		return test;
//	}
	
//    public static void setExtentTest(ExtentTest test) {
//        extentTestThreadLocal.set(test);
//    }
//
//    // Method to remove the ExtentTest from the ThreadLocal when the test is finished
//    public static void removeExtentTest() {
//        extentTestThreadLocal.remove();
//    }

}
