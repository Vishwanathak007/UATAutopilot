package com.autopilot.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.autopilot.ObjectRepository.LoginPage;
import com.autopilot.base.BaseClass;

//LoginPageTest
public class LoginPageTest extends BaseClass {
	
	LoginPage loginPage;
	
	public LoginPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
		loginPage=new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "VRKP : Auto Pilot Project");
	}
	
	
	@Test(priority=2)
	public void loginTest() throws InterruptedException
	{
		loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
