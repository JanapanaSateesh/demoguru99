package com.guru99.pagesobjetcs;

import org.apache.commons.collections4.functors.CatchAndRethrowClosure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.guru99.utilities.ExtentListner;

public class Guru99LoginPageObjects {

	WebDriver ldriver;
	public final static Logger logger = LogManager.getLogger("rootLogger");
	
	public Guru99LoginPageObjects(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);		
	}
	
	@FindBy(xpath="//input[@name='uid']")  WebElement username;
	//WebElement username= driver.findElement(By.xpath("//input[@name='uid']"))
	
	@FindBy(xpath="//input[@name='password']") WebElement password;
	
	@FindBy(xpath="//input[@name='btnLogin']") WebElement logibutton;
	
	@FindBy(xpath="//input[@name='btnLogin23']") WebElement logibutton1;
	
	
	
	public void enterUsername(String uname) throws InterruptedException {
		try {
			Thread.sleep(2000);
			username.sendKeys(uname);
			logger.info("Enter username");
		}catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
		
	}
	
	public void enterPassword(String pwd) throws InterruptedException {
		Thread.sleep(2000);
		password.sendKeys(pwd);
		logger.info("Enter password");
	}
	
	public void clickOnLoginButton() throws InterruptedException {
		Thread.sleep(2000);
		logibutton.click();
		logger.info("Clicked on login button");
	}
	
	public void HitEnter() throws InterruptedException {
		Thread.sleep(2000);
		password.sendKeys(Keys.ENTER);
		logger.info("Hit enter button");
	}
	
	public void loginWithValidCredentials(String uname, String pwd) throws InterruptedException {
		 ExtentTest test= ExtentListner.extentTestThreadLocal.get();
		 
		enterUsername(uname);
		test.log(Status.PASS, "enter uername");
		enterPassword(pwd);
		test.log(Status.PASS, "enter password");
		clickOnLoginButton();
		test.log(Status.PASS, "clicked on login button");
		//ExtentListner.extentTestThreadLocal.remove();
		
	}
	
	public void loginWithInValidCredentials(String uname, String pwd) throws InterruptedException {
		
		try {
			ExtentTest test= ExtentListner.extentTestThreadLocal.get();
			enterUsername(uname);
			test.log(Status.PASS, "enter uername");
			enterPassword(pwd);
			test.log(Status.PASS, "enter password");
			logibutton1.click();
			test.log(Status.PASS, "clicked on login button");
		}
		catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			Assert.fail(e.getMessage());
		}
		
		//ExtentListner.extentTestThreadLocal.remove();
	}
	
	public void loginWithValidUsernameInValidPassword(String uname, String pwd) throws InterruptedException {
		ExtentTest test= ExtentListner.extentTestThreadLocal.get();
		enterUsername(uname);
		test.log(Status.PASS, "enter uername");
		enterPassword(pwd);
		test.log(Status.PASS, "enter password");
		clickOnLoginButton();
		test.log(Status.PASS, "Clicked on Login Button");
	}
	
	public void loginWithInValidUsernameValidPassword(String uname, String pwd) throws InterruptedException {
		ExtentTest test= ExtentListner.extentTestThreadLocal.get();
		enterUsername(uname);
		test.log(Status.PASS, "enter uername");
		enterPassword(pwd);
		test.log(Status.PASS, "enter password");
		clickOnLoginButton();
		test.log(Status.PASS, "Clicked on Login Button");
	}
	
	public void loginWithoutCredentials() throws InterruptedException {
		ExtentTest test= ExtentListner.extentTestThreadLocal.get();
		clickOnLoginButton();
		test.log(Status.PASS, "Clicked on Login Button without enter credentials");
	}
	
	public void loginWithValidUsernameValidPasswordWithEnterKey(String uname, String pwd) throws InterruptedException {
		ExtentTest test= ExtentListner.extentTestThreadLocal.get();
		enterUsername(uname);
		test.log(Status.PASS, "enter uername");
		enterPassword(pwd);
		test.log(Status.PASS, "enter password");
		HitEnter();
		test.log(Status.PASS, "Hit enter button from the key board");
	}
	
}
