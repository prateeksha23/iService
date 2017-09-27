package com.iservice.tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.iservice.session.TestInitiator;

public class LoginTest {

	TestInitiator test;
	
	@BeforeClass
	public void setUp(){
		test = new TestInitiator();
	}
	
	@Test
	public void Step01_VerifyLoginScreenElements(){
		test.loginScreen.verifyLoginScreenElements();
	}
	
	@Test(dependsOnMethods="Step01_VerifyLoginScreenElements")
	public void Step02_LoginToTheApplication(){
		test.loginScreen.loginToTheApplication("akshayakrsh@gmail.com", "Pass@word1");		
	}
	
	@Test(dependsOnMethods="Step02_LoginToTheApplication")
	public void Step03_VerifyErrorMessage(){
		test.loginScreen.verifyErrorMessage();
	}
	
	@AfterMethod
	public void take_screenshot_on_failure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.takeScreenShotOnException();
		}
	}
	
	@AfterClass
	public void tearDown(){
		test.closeSession();
	}
}
