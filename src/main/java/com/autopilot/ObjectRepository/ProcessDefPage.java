package com.autopilot.ObjectRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.autopilot.Utility.UtilityClass;
import com.autopilot.base.BaseClass;
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
	WebElement jobType_select;		
	
	@FindBy(xpath=".//*[@id='startFromDate']")
	WebElement processStartDateField;	
		
	@FindBy(xpath=".//*[@id='startFromDate_root']/div/div/div/div/div[3]/button[3]")
	WebElement calenderOKBtn_select;
	
	@FindBy(xpath=".//*[@id='input_23']")
	WebElement duration_txt;
	
	@FindBy(xpath=".//*[@id='startTime']")
	WebElement processStartTimeField;
	
	@FindBy(xpath=".//*[@id='select_50']")
	WebElement accessLevel_select;
	
	@FindBy(xpath=".//*[@id='input_58']")
	WebElement processOwner_drpdwn;
	
	@FindBy(xpath=".//*[@id='input_59']")
	WebElement processcord_drpdwn;
	
	@FindBy(xpath=".//*[@id='metaSubmit']")
	WebElement btn_save;
	
	
	public ProcessDefPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void goToCreateProcessPage() throws Exception
	{
		processMenu.click();
		UtilityClass.threadSleep(5000);
		processDefSubMenu.click();
		UtilityClass.threadSleep(5000);
		createProcessBtn.click();
		UtilityClass.threadSleep(3000);			
	}

	public void createProcessBasic(String pTitle,String pHow,String pWhy, String pDuration) throws Exception
	{
		processTitle_txt.clear();
		processTitle_txt.sendKeys(pTitle);
		UtilityClass.threadSleep(2000);
		
		how_txt.clear();
		how_txt.sendKeys(pHow);
		UtilityClass.threadSleep(2000);
		
		why_txt.clear();
		why_txt.sendKeys(pWhy);
		UtilityClass.threadSleep(2000);
		
		priority_select.click();
		UtilityClass.threadSleep(2000);
		driver.findElement(By.xpath(".//*[@id='select_option_14']/div[1]")).click();
		UtilityClass.threadSleep(2000);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)", "");
        
		jobType_select.click();
		UtilityClass.threadSleep(2000);
        driver.findElement(By.xpath(".//*[@id='select_option_19']/div[1]")).click();	
        UtilityClass.threadSleep(2000);
        
        //StartTime
        pickDate("30");
        UtilityClass.threadSleep(2000); 
		UtilityClass.takeSnapShot("C:/Workspace/UATAutopilot1/Screenshots/"+new SimpleDateFormat("dd-MM-yyyyHHmmss").format(new Date())+".png");
        
        pickTime("17","15");
        UtilityClass.threadSleep(3000);
		
        //Duration
        duration_txt.sendKeys("10");        
        UtilityClass.threadSleep(2000);
        
        jse.executeScript("window.scrollBy(0,250)", "");
        
        //Access Level
        accessLevel_select.click();
        UtilityClass.threadSleep(2000); 
        driver.findElement(By.xpath(".//*[@id='select_option_47']/div[1]")).click();
        
        //Process Owner
        processOwner_drpdwn.click();
        UtilityClass.threadSleep(2000);
        driver.findElement(By.xpath(".//*[@placeholder='Pick a role']")).click();
        UtilityClass.threadSleep(2000);
        driver.findElement(By.xpath(".//span[text()=' Managing Director ']")).click();
        driver.findElement(By.xpath(".//md-dialog-actions/button[1]")).click();
        UtilityClass.threadSleep(2000);
        
      //Process Coordinator
        processcord_drpdwn.click();
        UtilityClass.threadSleep(2000);
        driver.findElement(By.xpath(".//*[@placeholder='Pick a role']")).click();
        UtilityClass.threadSleep(2000);
        driver.findElement(By.xpath(".//span[text()=' GM ADMINISTRATOR ']")).click();
        driver.findElement(By.xpath(".//md-dialog-actions/button[1]")).click();
        UtilityClass.threadSleep(2000);
        
        jse.executeScript("window.scrollBy(0,250)", "");
        
        //Save Button
        btn_save.click();
        UtilityClass.threadSleep(3000);
        
	}
	
	public void pickDate(String pdate)
	{		
		processStartDateField.click();
			
		List<WebElement> allDates=driver.findElements(By.xpath(".//*[@id='startFromDate_table']/tbody/tr/td"));
		System.out.println("select Date");
		for(WebElement ele:allDates)
		{			
			String date=ele.getText();
			
			if(date.contains(pdate))
			{
				ele.click();
				calenderOKBtn_select.click();
				System.out.println("Date is selected...");
				break;
			}			
		}
	}
	
	public void pickTime(String phour,String pmin) throws InterruptedException
	{		
		processStartTimeField.click();                           
				
	    System.out.println("Select Time...");
		List<WebElement> allHours=driver.findElements(By.xpath(".//*[@id='ui-timepicker-div']//td[@class='ui-timepicker-hours']//td"));
		List<WebElement> allMins=driver.findElements(By.xpath(".//*[@id='ui-timepicker-div']//td[@class='ui-timepicker-minutes']//td"));		
		Actions action = new Actions(driver);
		
		for(WebElement ele:allHours)
		{			
			String days=ele.getText();
			
			if(days.contains(phour))
			{				
			   action.doubleClick(ele).build().perform();
			   System.out.println("Hour is selected..."+days);
				break;
			}			
		}
		
		
		/*for(WebElement ele:allMins)
		{			
			String min=ele.getText();
			
			if(min.contains(pmin))
			{
				ele.click();
				System.out.println("Min is selected...");
				break;
			}			
		}*/
	}
	
	
	
}
