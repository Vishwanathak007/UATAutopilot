package com.autopilot.TestCases;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.autopilot.ObjectRepository.LoginPage;
import com.autopilot.ObjectRepository.ProcessDefPage;
import com.autopilot.Utility.ExcelUtilClass;
import com.autopilot.Utility.UtilityClass;
import com.autopilot.base.BaseClass;

//ProcessPageTest
public class ProcessDefPageTest extends BaseClass{
	
LoginPage loginPage;
ProcessDefPage processdefpage;
String sheetName="test-data";
	
	public ProcessDefPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception
	{
		initialization();
		loginPage=new LoginPage();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		processdefpage=new ProcessDefPage();
		processdefpage.goToCreateProcessPage();
		UtilityClass.takeSnapShot("C:/Workspace/UATAutopilot1/Screenshots/"+new SimpleDateFormat("dd-MM-yyyyHHmmss").format(new Date())+".png");
	}
	
	@Test(dataProvider="getProcessDefBasicTestData")
	public void CreateProcessBasicDetailsTest(String title,String how,String why,String duration) throws Exception
	{
		processdefpage.createProcessBasic(title,how,why,duration);
	}
	
	
	@DataProvider
	public Object[][] getProcessDefBasicTestData()
	{
		Object[][] processDefBasicData=ExcelUtilClass.getTestData(sheetName);
		return processDefBasicData;
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

	
}
