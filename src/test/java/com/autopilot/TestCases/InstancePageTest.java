package com.autopilot.TestCases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.autopilot.ObjectRepository.InstancePage;
import com.autopilot.ObjectRepository.LoginPage;
import com.autopilot.base.BaseClass;

public class InstancePageTest extends BaseClass {
	
	LoginPage loginPage;
	InstancePage instPage;

	@BeforeMethod	 
	public void preTestcondition() throws InterruptedException
	{
		initialization();
	    loginPage=new LoginPage();
	    instPage=new InstancePage();
		loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(dataProvider="instTestDataProvider")
	public void submitFormTest(String repPath, String coalRate, String palletRate, String driRate, String billetRate, String tmt, String silicoRate) throws Exception
	{
      instPage=new InstancePage();
      driver.navigate().to("http://uatautopilot.vrkp.in/pinstances/forms/5bb2f44804d6731cb2acf7bb/stepform/1");
      Thread.sleep(3000);
      instPage.submit(repPath, coalRate, palletRate, driRate, billetRate, tmt, silicoRate);   

      WebElement MsgContainer=driver.findElement(By.xpath(".//*[@id='toast-container']/div"));
      Assert.assertEquals(MsgContainer.getText(), "Data Saved Successfully");
	}	
	
	@DataProvider
	public Object[][] instTestDataProvider() throws InvalidFormatException, IOException, Exception
	{
		Object[][] instTestData=instPage.getTestData();
		return instTestData;
	}

   @AfterMethod
   public void tearDown() {
	   //driver.close();
   }

}
