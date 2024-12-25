package com.guru99.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import com.guru99.utilities.ReadConfigFile;

public class BaseClass {

	public WebDriver driver;
	ReadConfigFile readconfigfiledata;
	
	@BeforeMethod(alwaysRun = true)
	public void SetUp(ITestContext context) throws IOException {
		
		
		readconfigfiledata=new ReadConfigFile();
		String url=readconfigfiledata.getUrl();
		
		driver=new ChromeDriver();
		context.setAttribute("driver", driver);
		driver.get(url);
		driver.manage().window().maximize();
		//Base Test
	}
	
	
	
	@AfterMethod(alwaysRun = true)
	public void TearDown(ITestResult result) throws IOException {		
		driver.quit();
	}
}
