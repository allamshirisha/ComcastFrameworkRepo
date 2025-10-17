package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getDataFromExcel(String sheetName,int rowNum, int CelNum) throws IOException {
		FileInputStream fis = new FileInputStream("./testdata/org.xlsx");
		
		Workbook book = WorkbookFactory.create(fis);
	String data =	book.getSheet(sheetName).getRow(rowNum).getCell(CelNum).toString();
	book.close();
		return data;
	}
	
	public int getRowcount(String sheetName) throws IOException {
		
		
	FileInputStream fis = new FileInputStream("./testdata/org.xlsx");

		
		Workbook book = WorkbookFactory.create(fis);
		
	int rowcount =	book.getSheet(sheetName).getLastRowNum();
	book.close();
	return rowcount;
		}
	
	public void setDataIntoExcel(String sheetName,int rowNum, int CelNum,String data) throws IOException {
		
	FileInputStream fis = new FileInputStream("./testdata/org.xlsx");
		
		Workbook book = WorkbookFactory.create(fis);
		book.getSheet(sheetName).getRow(rowNum).createCell(CelNum);
		FileOutputStream fos = new FileOutputStream("./testdata/org.xlsx");
		
		book.write(fos);
		book.close();
	}
	
	
	
	
	
	
	
}
