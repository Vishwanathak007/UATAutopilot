package com.autopilot.TestCases;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.autopilot.ObjectRepository.LoginPage;
import com.autopilot.base.BaseClass;

public class TestScrollHoriz extends BaseClass {

	public static void main(String[] args) throws InterruptedException {	
		
		
		BaseClass baseClass=new BaseClass();
		baseClass.initialization();
		
		LoginPage loginPage=new LoginPage();
		loginPage.login("vrkpadmin", "Superman");
		
		Thread.sleep(3000);
		driver.navigate().to("http://uatautopilot.vrkp.in/reports/report/5b308167ced6c91ebb5420f6/3");
		
        JavascriptExecutor jse=(JavascriptExecutor) driver;		
        jse.executeScript("window.scrollBy(0,1000)");
        
        Thread.sleep(3000);
        WebElement element=driver.findElement(By.xpath(".//*[@id='main']/div/div/div[2]/mdt-table/md-content/md-content/ng-include/table/thead/tr/th[21]/div/div/span/span"));
        jse.executeScript("arguments[0].scrollIntoView();", element);
        
        Thread.sleep(5000);
        driver.quit();
        
	}

}