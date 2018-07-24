package com.autopilot.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autopilot.Utility.UtilityClass;
import com.autopilot.base.BaseClass;

public class LoginPage extends BaseClass {
	
	//PageFactory - Page Objects
	@FindBy(xpath=".//*[@id='username']")
	WebElement username;
	
	@FindBy(xpath=".//*[@id='password']")
	WebElement password;
	
	@FindBy(id="loginBtn")
	WebElement loginBtn;
	
	public LoginPage()
	{
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	public String validateLoginPageTitle()
	{
	  return driver.getTitle();
	}
	
	public void login(String UN,String PWD) throws InterruptedException
	{
		username.sendKeys(UN);
		password.sendKeys(PWD);
		UtilityClass.threadSleep(3000);
		loginBtn.click();
	
	}
}

