package com.autopilot.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

 

public class ExcelUtilClass {
	
	
    //Excel WorkBook
    private static Workbook book;
 
    //Excel Sheet
    private static Sheet sheet;
  
    
   //public static String FILE_PATH = "C:\\\\Workspace\\\\AutopiolotUAT\\\\TestData.xlsx";
    public static String FILE_PATH = "C:\\Workspace\\UATAutopilot1\\src\\main\\java\\com\\autopilot\\datafiles\\TestData.xlsx";
   
   
   //GetData From Excel
 	public static Object[][] getTestData(String sheetName)
 	{
 		FileInputStream fis=null;
 		
 		try {
 		fis=new FileInputStream(FILE_PATH);
 		}
 		catch (FileNotFoundException e) {
 			e.printStackTrace();
 		}
 		
 		try {
 			book=WorkbookFactory.create(fis);
 		} catch (EncryptedDocumentException e) {			
 			e.printStackTrace();
 		} catch (InvalidFormatException e) {
 			e.printStackTrace();
 		} catch (IOException e) {
 			e.printStackTrace();
 		}
 		
 		sheet=book.getSheet(sheetName);
 		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
 		
 		for(int i=0; i<sheet.getLastRowNum();i++)
 		{
 			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
 			{
 				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
 				System.out.println(data);
 			}			
 		}
 		return data; 
  	}
 

}
