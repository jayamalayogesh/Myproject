package com.qa.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.Testbase.Testbase;

public class Utilities extends Testbase {

	
	public Utilities()
	{
		super();
	}
	
	public static long PAGE_LOAD_TIMEOUT=40;
	public static long IMPLICIT_WAIT__TIMEOUT=40;
	
	public static String path="C:\\Users\\Jayamala\\eclipse-workspace\\Webapplication_Test\\src\\main\\java\\com\\qa\\Testdata\\testdatanew.xlsx";
	static Workbook book;
	static org.apache.poi.ss.usermodel.Sheet sheet;
	public static Object[][] getdata(String sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream file=null;
		try
		{
			file=new FileInputStream(path);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try
		{
			book=WorkbookFactory.create(file);
		}catch(InvalidFormatException e)
		{
			e.printStackTrace();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		sheet=book.getSheet(sheetname);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
			{
				data[i][k]=sheet.getRow(i+1).getCell(k).toString();
				
			}
		}
		return data;
	
	}
	
}
