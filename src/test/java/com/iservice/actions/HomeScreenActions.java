package com.iservice.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeScreenActions {
		
	WebDriver driver;
	
	public HomeScreenActions(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	@FindBy(name="iService")
	WebElement iServiceMenu;
}
