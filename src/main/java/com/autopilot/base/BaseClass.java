package com.autopilot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.autopilot.Utility.UtilityClass;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	
	public BaseClass() 
	{		
		try 
		{
			prop=new Properties();
			FileInputStream fis=new FileInputStream("C:\\Workspace\\UATAutopilot1\\src\\main\\java\\com\\autopilot\\datafiles\\config.properties");
			prop.load(fis);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
			catch (IOException e)
		    {				
				e.printStackTrace();
			}
		
	  }
	
	//Initializing the Webdriver Object
		public  void initialization() throws InterruptedException
		{
			String browserName=prop.getProperty("browser");
			if(browserName.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chromedriver.exe");
				driver=new ChromeDriver();
			}
			else if (browserName.equals("firefox")) 
			{
				System.setProperty("webdriver.gecko.driver", "C:\\Softwares\\geckodriver.exe");
				driver=new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
			UtilityClass.threadSleep(5000);
		}
		
		
}
