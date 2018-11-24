package com.autopilot.TestCases;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestData {	
	
    public static String FILE_PATH = "C:\\Workspace\\UATAutopilot1\\src\\main\\java\\com\\autopilot\\datafiles\\TestData.xlsx";

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {

		FileInputStream fis=new FileInputStream(FILE_PATH);
		Workbook book=WorkbookFactory.create(fis);
		Sheet sheet =book.getSheet("instance-data");
		System.out.println(sheet.getLastRowNum());
		System.out.println(sheet.getRow(0).getLastCellNum());
		Object[][] testdata=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		try
		{
			for(int i=0;i<sheet.getLastRowNum();i++)
			{
				for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
				{
					testdata[i][j]=sheet.getRow(i+1).getCell(j).toString();
					System.out.println(testdata[i][j]);
				}
			}
			
		  }
		catch (NullPointerException e)
		{
			System.out.println("Null Pointer Exception ....Please check the Code");
		}
		
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Array Index Out of Bounds Exception ....Please check the Code");
		}
	
		System.out.println(testdata);
	}

}
