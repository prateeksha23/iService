package com.iservice.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginScreenActions {

	WebDriver driver;
	
	public LoginScreenActions(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(id="com.truelife.mobile.android.trueiservice:id/login_langauge")
	WebElement toggle_language;
	
	@FindBy(id="com.truelife.mobile.android.trueiservice:id/imageView2")
	WebElement icon_iservice;
	
	@FindBy(id="com.truelife.mobile.android.trueiservice:id/login_layout_edittext_user")
	WebElement inp_trueId;
	
	@FindBy(id="com.truelife.mobile.android.trueiservice:id/login_layout_edt_password")
	WebElement inp_password;
	
	@FindBy(id="com.truelife.mobile.android.trueiservice:id/login_btn")
	WebElement btn_login;
	
	@FindBy(id="android:id/message")
	WebElement errorMessage;
	
	@FindBy(id="android:id/button1")
	WebElement btn_ok;
	
	public void enterTrueId(String trueId){
		inp_trueId.sendKeys(trueId);
		Reporter.log("User entered "+trueId+" as trueId"+true);
	}
	
	public void enterPassword(String password){
		inp_password.sendKeys(password);
		Reporter.log("User entered "+password+" as password", true);
	}
	
	public void clickOnLoginButton(){
		btn_login.click();
		Reporter.log("Clicked on Login button", true);
	}
	
	public void loginToTheApplication(String id, String password){
		enterTrueId(id);
		enterPassword(password);
		clickOnLoginButton();
	}
	
	public void verifyLoginScreenElements(){
		Assert.assertTrue(icon_iservice.isDisplayed(), "Assertion Failed : iService icon is not displayed");
		Reporter.log("Assertion Passed : iService icon is displayed", true);
		Assert.assertTrue(toggle_language.isDisplayed(), "Assertion Failed : Language toggle is not displayed");
		Reporter.log("Assertion Passed : Language toggle is displayed", true);
		//more elements visibility can be checked here
	}
	
	public void verifyErrorMessage(){
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(btn_ok));
		Assert.assertEquals(errorMessage.getText(), "Connection failed.\nPlease try again later.", "Assertion Failed: Error message is not correct");
		Reporter.log("Assertion Passed: Error message is correct", true);
	}
}
