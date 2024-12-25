package com.guru99.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru99.pagesobjetcs.Guru99LoginPageObjects;
import com.guru99.utilities.DataFromExcelAfterRead;

public class Guru99LoginPageTest extends BaseClass{
	Guru99LoginPageObjects loginpage;

	@Test(priority = 1, dataProviderClass = DataFromExcelAfterRead.class,dataProvider = "TC001_TestData", enabled = true)
	public void TC001_LoginPage_LoginWithValidCredentials(String username, String password) throws InterruptedException {
		loginpage=new Guru99LoginPageObjects(driver);
		loginpage.loginWithValidCredentials(username, password);
	}
	
	@Test(priority = 2, enabled = true, dataProviderClass = DataFromExcelAfterRead.class,dataProvider = "TC002_TestData")
	public void TC002_LoginPage_LoginWithInValidCredentials(String wrongusername, String wrongpassword) throws InterruptedException {
		loginpage=new Guru99LoginPageObjects(driver);
		loginpage.loginWithInValidCredentials(wrongusername, wrongpassword);
		
	}
	
	@Test(priority = 3,enabled = true, dataProviderClass = DataFromExcelAfterRead.class, dataProvider = "TC003_TestData")
	public void TC003_LoginPage_LoginWithInValidCredentials(String WrongUsername, String CorrectPassword) throws InterruptedException {
		loginpage=new Guru99LoginPageObjects(driver);
		loginpage.loginWithInValidUsernameValidPassword(WrongUsername, CorrectPassword);
		
	}
	
	@Test(priority = 4,enabled = true, dataProviderClass = DataFromExcelAfterRead.class, dataProvider = "TC004_TestData")
	public void TC004_LoginPage_LoginWithInValidCredentials(String CorrectUsername, String WrongPwd) throws InterruptedException {
		loginpage=new Guru99LoginPageObjects(driver);
		loginpage.loginWithValidUsernameInValidPassword(CorrectUsername, WrongPwd);
		
	}
	
	@Test(priority = 5,enabled = true)
	public void TC005_LoginPage_LoginWithoutCredentials() throws InterruptedException {
		loginpage=new Guru99LoginPageObjects(driver);
		loginpage.loginWithoutCredentials();
		
	}
	
	@Test(priority = 6,enabled = true, dataProviderClass = DataFromExcelAfterRead.class, dataProvider = "TC006_TestData")
	public void TC006_LoginPage_LoginWithValidCredentials(String username, String password) throws InterruptedException {
		loginpage=new Guru99LoginPageObjects(driver);
		loginpage.loginWithValidUsernameValidPasswordWithEnterKey(username, password);
		
	}
	
//	@DataProvider
//	public String[][] TC1Data() {
//		String[][] data=new String[2][2];
//		data[0][0]="mngr26593";
//		data[0][1]="123Abc@";
//		
//		data[1][0]="sateesh@gmail.com";
//		data[1][1]="Sateesh@123";
//		
//		//mngr26593 			123Abc@
//		//sateesh@gmail.com		Sateesh@123
//				
//		
//		return data;
//	}
}
