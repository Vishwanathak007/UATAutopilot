package com.autopilot.TestCases;



import org.openqa.selenium.By;

import com.autopilot.ObjectRepository.LoginPage;
import com.autopilot.ObjectRepository.ProcessDefPage;
import com.autopilot.base.BaseClass;

public class TestAutopilot extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
		
       BaseClass baseClass=new BaseClass();
       baseClass.initialization();
       
       LoginPage loginPage=new LoginPage();
       loginPage.login("vrkpadmin", "Superman");
       
       ProcessDefPage processDefPage=new ProcessDefPage();
       processDefPage.goToCreateProcessPage();
       
       driver.findElement(By.xpath(".//*[@id='startFromDate']")).click();
       
       Thread.sleep(3000);
       driver.findElement(By.xpath(".//*[@id='startFromDate_table']/tbody/tr[5]/td[6]/div")).click();
       Thread.sleep(3000); 
       driver.findElement(By.xpath(".//*[@id='startFromDate_root']/div/div/div/div/div[3]/button[3]")).click(); 
       Thread.sleep(5000);
       driver.quit();
       
       }

}
