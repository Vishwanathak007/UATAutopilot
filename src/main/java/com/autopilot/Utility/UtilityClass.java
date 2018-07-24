package com.autopilot.Utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.autopilot.base.BaseClass;

public class UtilityClass extends BaseClass{
	
	public static void implicitWait(WebDriver driver, int waitTime)
	{
		driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
	}
	
	public static void threadSleep(int sleepTime) throws InterruptedException
	{
		Thread.sleep(sleepTime);
	}
	
	//Take Screenshot
	public static void takeSnapShot(String fileWithPath) throws Exception{

        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)driver);

        //Call getScreenshotAs method to create image file
                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination
                File DestFile=new File(fileWithPath);

                //Copy file at destination
                FileUtils.copyFile(SrcFile, DestFile);

    }

	//Current DateTime
	public static String currentDateTime()
	{
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		 
		 //get current date time with Date()
		 Date date = new Date();
		 
		 // Now format the date
		 String date1= dateFormat.format(date);
		return date1;
	}
}
