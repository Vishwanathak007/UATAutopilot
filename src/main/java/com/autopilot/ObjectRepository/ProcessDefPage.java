package com.autopilot.ObjectRepository;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.autopilot.Utility.UtilityClass;
import com.autopilot.base.BaseClass;
import org.openqa.selenium.support.ui.Select;
public class ProcessDefPage extends BaseClass{
	
	//PageFactory - Page Objects
	@FindBy(xpath="//div[@class='nav-wrapper']/ul/li[2]/a")
	WebElement processMenu;
	
	@FindBy(xpath=".//ul[@id='process_menu2']/li[1]/a")
	WebElement processDefSubMenu;
	
	@FindBy(xpath=".//div[@class='row']/a/i")
	WebElement createProcessBtn;
	
	@FindBy(xpath=".//input[@id='input_9']")
	WebElement processTitle_txt;
	
	@FindBy(xpath=".//textarea[@id='input_10']")
	WebElement how_txt;
	
	@FindBy(xpath=".//textarea[@id='input_11']")
	WebElement why_txt;
	
	@FindBy(xpath=".//*[@id='select_16']")
	WebElement priority_select;	
	
	@FindBy(xpath=".//*[@id='select_21']")
	WebElement accessLevel_select;		
	
	@FindBy(xpath=".//*[@id='startFromDate']")
	WebElement processStartDateField;	
		
	@FindBy(xpath=".//*[@id='startFromDate_root']/div/div/div/div/div[3]/button[3]")
	WebElement calenderOKBtn_select;
	
	@FindBy(xpath=".//*[@id='input_23']")
	WebElement duration_txt;
	
	@FindBy(xpath=".//*[@id='startTime']")
	WebElement processStartTimeField;
	
		
	public ProcessDefPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void goToCreateProcessPage() throws InterruptedException
	{
		processMenu.click();
		UtilityClass.threadSleep(5000);
		processDefSubMenu.click();
		UtilityClass.threadSleep(5000);
		createProcessBtn.click();
		UtilityClass.threadSleep(5000);		
	}

	public void createProcessBasic(String pTitle,String pHow,String pWhy, String pDuration) throws InterruptedException
	{
		processTitle_txt.clear();
		processTitle_txt.sendKeys(pTitle);
		UtilityClass.threadSleep(3000);
		
		how_txt.clear();
		how_txt.sendKeys(pHow);
		UtilityClass.threadSleep(3000);
		
		why_txt.clear();
		why_txt.sendKeys(pWhy);
		UtilityClass.threadSleep(3000);
		
		priority_select.click();
		UtilityClass.threadSleep(3000);
		driver.findElement(By.xpath(".//*[@id='select_option_14']/div[1]")).click();
		UtilityClass.threadSleep(3000);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        
		accessLevel_select.click();
		UtilityClass.threadSleep(3000);
        driver.findElement(By.xpath(".//*[@id='select_option_19']/div[1]")).click();	
        UtilityClass.threadSleep(3000);
        
        pickDate("30");
        UtilityClass.threadSleep(5000);       
        
        pickTime("10","15");
        UtilityClass.threadSleep(3000);
		
        duration_txt.sendKeys(pDuration);
        UtilityClass.threadSleep(3000);
	}
	
	public void pickDate(String pdate)
	{		
		processStartDateField.click();
		
	   //String currentWindow= driver.getWindowHandle();
	   //driver.switchTo().window(currentWindow);
		
		List<WebElement> allDates=driver.findElements(By.xpath(".//table[@id='startFromDate_table']/td"));
		
		for(WebElement ele:allDates)
		{			
			String date=ele.getText();
			
			if(date.equalsIgnoreCase(pdate))
			{
				ele.click();
				calenderOKBtn_select.click();
				break;
			}			
		}
	}
	
	public void pickTime(String phour,String pmin)
	{		
		//processStartTimeField.click();                           
		//processStartTimeField.clear(); 
		
		String currentWindow= driver.getWindowHandle();
		driver.switchTo().window(currentWindow);
		
		List<WebElement> allHours=driver.findElements(By.xpath(".//*[@id='ui-timepicker-hours']/td"));
		List<WebElement> allMins=driver.findElements(By.xpath(".//*[@id='ui-timepicker-minutes']/td"));
		
		
		for(WebElement ele:allHours)
		{			
			String hour=ele.getText();
			
			if(hour.equalsIgnoreCase(phour))
			{
				ele.click();				
				break;
			}			
		}
		
		for(WebElement ele:allMins)
		{			
			String min=ele.getText();
			
			if(min.equalsIgnoreCase(pmin))
			{
				ele.click();				
				break;
			}			
		}
	}
}
