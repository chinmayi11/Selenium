package com.DataHandlers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public static final String excelFileName="RestaurantSheet.xlsx";
	public static final String currentDirExcel=System.getProperty("user.dir");
	public static String excelPath=null;
	public static XSSFWorkbook excelBook;
	public static XSSFSheet excelSheet;
	public static XSSFCell cell;
	public static XSSFRow row;
	public static int rowNumber;
	public static int columnNumber;
	
	
	
	public void setExcelFileSheet(String sheetName) throws IOException
	{
		excelPath=currentDirExcel+"/src/main/resources/";
		
		FileInputStream ExcelFile=new FileInputStream(excelPath);
		excelBook=new XSSFWorkbook(ExcelFile);
		excelSheet = excelBook.getSheet(sheetName);
	}
	
	//Method to read the test data from the Excel cell.
	
	public String getCellData(int rowNum,int colNum)
	{
		cell = excelSheet.getRow(rowNum).getCell(colNum);
		DataFormatter formatter = new DataFormatter();
		 return formatter.formatCellValue(cell);
		
	}

}
