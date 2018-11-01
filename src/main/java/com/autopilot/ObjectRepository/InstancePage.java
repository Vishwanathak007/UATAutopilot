package com.autopilot.ObjectRepository;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.autopilot.base.BaseClass;

public class InstancePage extends BaseClass{
	
	Workbook book;
	Sheet sheet;
	FileInputStream fis;
    public static String FILE_PATH = "C:\\Workspace\\UATAutopilot1\\src\\main\\java\\com\\autopilot\\datafiles\\TestData.xlsx";
	
   //Page Factory Objects//
	@FindBy(xpath=".//*[@id='fileuploader1']//input")
	WebElement browseBtn;
	
	@FindBy(xpath=".//*[@id='input_7']")
	WebElement coalRate;
	
	@FindBy(xpath=".//*[@id='input_8']")
	WebElement palletRate;
	
	@FindBy(xpath=".//*[@id='input_9']")
	WebElement DRIRate;
	
	@FindBy(xpath=".//*[@id='input_10']")
	WebElement billetRate;
	
	@FindBy(xpath=".//*[@id='input_11']")
	WebElement tmt;
	
	@FindBy(xpath=".//*[@id='input_12']")
	WebElement silicoRate;
	
	@FindBy(xpath=".//*[contains(text(),'Save')]")
	WebElement saveBtn;
	
	@FindBy(xpath=".//*[contains(text(),'Submit')]")
	WebElement submitBtn;
	
	@FindBy(xpath=".//*[@id='toast-container']/div")
	WebElement MsgContainer;
	
	public InstancePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void submit() throws Exception
	{
		initExcel();
		//browseBtn.clear();
		browseBtn.sendKeys("C:\\ERP Testing\\Power Plant\\SOP 1.xlsx");
		Thread.sleep(3000);
		
		coalRate.clear();
		coalRate.sendKeys("1100");
		Thread.sleep(3000);
		
		palletRate.clear();
		palletRate.sendKeys(sheet.getRow(2).getCell(2).toString());
		Thread.sleep(3000);
		
		DRIRate.clear();
		DRIRate.sendKeys("3000");
		Thread.sleep(3000);
		
		billetRate.clear();
		billetRate.sendKeys("4000");
		Thread.sleep(3000);
		
		tmt.clear();
		tmt.sendKeys("5000");
		Thread.sleep(3000);
		
		silicoRate.clear();
		silicoRate.sendKeys("6000");
		Thread.sleep(3000);

        submitBtn.click();
        Thread.sleep(3000); 
	}
	
	public void initExcel() throws Exception, InvalidFormatException, IOException
	{
		fis=new FileInputStream(FILE_PATH);
		book=WorkbookFactory.create(fis);
		sheet =book.getSheet("instance-data");
	}
	
	
}
  
