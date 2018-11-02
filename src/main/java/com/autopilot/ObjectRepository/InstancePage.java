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
	
	public void submit(String rep_Path, String coal_Rate, String pallet_Rate, String dri_Rate, String billet_Rate, String tmt_Rate, String silico_Rate) throws Exception
	{
		
		//browseBtn.clear();
		browseBtn.sendKeys(rep_Path);
		Thread.sleep(3000);
		
		coalRate.clear();
		coalRate.sendKeys(coal_Rate);
		Thread.sleep(3000);
		
		palletRate.clear();
		palletRate.sendKeys(pallet_Rate);
		Thread.sleep(3000);
		
		DRIRate.clear();
		DRIRate.sendKeys(dri_Rate);
		Thread.sleep(3000);
		
		billetRate.clear();
		billetRate.sendKeys(billet_Rate);
		Thread.sleep(3000);
		
		tmt.clear();
		tmt.sendKeys(tmt_Rate);
		Thread.sleep(3000);
		
		silicoRate.clear();
		silicoRate.sendKeys(silico_Rate);
		Thread.sleep(3000);

        saveBtn.click();
        Thread.sleep(3000); 
	}
	
	public Object[][] getTestData() throws Exception, InvalidFormatException, IOException
	{
		fis=new FileInputStream(FILE_PATH);
		book=WorkbookFactory.create(fis);
		sheet =book.getSheet("instance-data");
		
		Object[][] testdata=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<=sheet.getLastRowNum();i++)
		{
			for(int j=0;j<=sheet.getRow(0).getLastCellNum();j++)
			{
				testdata[i][j]=sheet.getRow(i+2).getCell(j).toString();
				System.out.println(testdata);
			}
		}
		return testdata;
	}
	
	
}
  
