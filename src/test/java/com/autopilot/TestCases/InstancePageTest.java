package com.autopilot.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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
	
	@Test
	public void submitFormTest() throws Exception
	{
      instPage=new InstancePage();
      driver.navigate().to("http://uatautopilot.vrkp.in/pinstances/forms/5bb2f44804d6731cb2acf7bb/stepform/1");
      Thread.sleep(3000);
      instPage.submit();   

      WebElement MsgContainer=driver.findElement(By.xpath(".//*[@id='toast-container']/div"));
      Assert.assertEquals(MsgContainer.getText(), "Data Saved Successfully");
	}	

   @AfterMethod
   public void tearDown() {
	   //driver.close();
   }

}
