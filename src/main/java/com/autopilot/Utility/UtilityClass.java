package com.autopilot.Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class UtilityClass {
	
	public static void implicitWait(WebDriver driver, int waitTime)
	{
		driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
	}
	
	public static void threadSleep(int sleepTime) throws InterruptedException
	{
		Thread.sleep(sleepTime);
	}

}
