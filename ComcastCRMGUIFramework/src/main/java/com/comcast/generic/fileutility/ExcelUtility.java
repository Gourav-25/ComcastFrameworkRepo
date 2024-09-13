package com.comcast.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String getDataFromExcel(String sheetname,int rowno,int cellno) throws Throwable {
		
		FileInputStream fis=new FileInputStream("./TestData/Book2.xlsx");
		//Open the workbook in read mode
		Workbook wb=WorkbookFactory.create(fis);
		//get Sheet Control
		Sheet sh=wb.getSheet(sheetname);
		//get Row Control
		Row rw=sh.getRow(rowno);
		//Read the Value
		DataFormatter df=new DataFormatter();
		String data=df.formatCellValue(rw.getCell(cellno));	
		wb.close();
		return data;	
	}
	public int getRowCount(String sheetname) throws Throwable {
		FileInputStream fis=new FileInputStream("./TestData/Book2.xlsx");
		//Open the workbook in read mode
		Workbook wb=WorkbookFactory.create(fis);
		//get Sheet Control
		Sheet sh=wb.getSheet(sheetname);
		int rowcount=sh.getLastRowNum();
		wb.close();
		return rowcount;		
	}
	public void setDataIntoExcel(String sheetname,int rowno,int cellno ,String data) throws Throwable {
		FileInputStream fis=new FileInputStream("./TestData/Book2.xlsx");
		//Open the workbook in read mode
		Workbook wb=WorkbookFactory.create(fis);
		//get Sheet Control
		Sheet sh=wb.getSheet(sheetname);
		//get Row Control
		Row rw=sh.getRow(rowno);
		//create Cell
		Cell cell=rw.createCell(cellno);
		cell.setCellValue(data);
		FileOutputStream fos=new FileOutputStream("./TestData/Book2.xlsx");
		wb.write(fos);
		wb.close();
	}
	public void setDataIntoExcelBycrSheet(String Sheetname,int rowno,int cellno,String data) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("‪C:\\Users\\user\\Documents\\ProjectData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.createSheet(Sheetname);
		Row rw=sh.createRow(rowno);
		Cell cel=rw.createCell(cellno);
		cel.setCellType(CellType.STRING);
		cel.setCellValue(data);
		FileOutputStream fos=new FileOutputStream("C:\\Users\\user\\Documents\\ProjectData.xlsx");
		wb.write(fos);	
		wb.close();	
	}
}
