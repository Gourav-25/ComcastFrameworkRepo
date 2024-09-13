package practceTask;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class readData {

   @Test
   public void Data() throws IOException {
	   int i=0;
	   int l=0;	   
	   FileInputStream fis=new FileInputStream("C:\\Users\\user\\Documents\\dataprop.xlsx");
	   Workbook wb=WorkbookFactory.create(fis);
	   Sheet sh=wb.createSheet("Sheet2");
	   Row rw=sh.createRow(0);
	    rw=sh.createRow(1);
	    rw=sh.createRow(2);
	    rw=sh.createRow(3);       
	   FileOutputStream fos=new FileOutputStream("C:\\Users\\user\\Documents\\dataprop.xlsx");
	   wb.write(fos);
	  fis=new FileInputStream("C:\\Users\\user\\Documents\\dataprop.xlsx");
	   wb=WorkbookFactory.create(fis);
	    sh=wb.createSheet("Sheet2");
	   rw=sh.createRow(0);
	    rw=sh.createRow(1);
	    rw=sh.createRow(2);
	    rw=sh.createRow(3);       
	    fos=new FileOutputStream("C:\\Users\\user\\Documents\\dataprop.xlsx");
	   wb.write(fos);
	   
	   fis=new FileInputStream("C:\\Users\\user\\Documents\\dataprop.xlsx");
	    wb=WorkbookFactory.create(fis);
	    sh=wb.createSheet("Sheet4");
	     rw=sh.createRow(0);
	    rw=sh.createRow(1);
	    rw=sh.createRow(2);
	    rw=sh.createRow(3);
	    rw=sh.createRow(4);
	    rw=sh.createRow(5);
	    rw=sh.createRow(6);
	    rw=sh.createRow(7);
	    fos=new FileOutputStream("C:\\Users\\user\\Documents\\dataprop.xlsx");
	     wb.write(fos);
	     wb.close(); 
	for(char x='A';x<='D';x++) {
		String p=Character.toString(x);
	   FileInputStream fis1=new FileInputStream("C:\\Users\\user\\Documents\\impdata.properties");
	   Properties prop=new Properties();
	   prop.load(fis1);
	   String d1=prop.getProperty(p);
	  fis=new FileInputStream("C:\\Users\\user\\Documents\\dataprop.xlsx");
	    wb=WorkbookFactory.create(fis);
	    sh=wb.getSheet("Sheet2");
	    rw=sh.getRow(l++);
	   Cell cel=rw.createCell(i);
	   cel.setCellValue(d1);	
	    fos=new FileOutputStream("C:\\Users\\user\\Documents\\dataprop.xlsx");
	   wb.write(fos);
	    wb.close();
	}
	for(char x='E';x<='H';x++) {
		String p=Character.toString(x);
		   FileInputStream fis1=new FileInputStream("C:\\Users\\user\\Documents\\impdata.properties");
		   Properties prop=new Properties();
		   prop.load(fis1);
		   String d1=prop.getProperty(p);
		  fis=new FileInputStream("C:\\Users\\user\\Documents\\dataprop.xlsx");
		    wb=WorkbookFactory.create(fis);
		    sh=wb.getSheet("Sheet3");
		    rw=sh.getRow(l++);
		   Cell cel=rw.createCell(i);
		   cel.setCellValue(d1);	
		    fos=new FileOutputStream("C:\\Users\\user\\Documents\\dataprop.xlsx");
		    wb.write(fos);
		    wb.close();		
	}
	/*for(int k=0;k<=4;k++) {
		    fis=new FileInputStream("C:\\Users\\user\\Documents\\dataprop.xlsx");
		   wb=WorkbookFactory.create(fis);
		   sh=wb.getSheet("Sheet2");
		   rw=sh.getRow(k);
		   DataFormatter df=new DataFormatter();
		   String data=df.formatCellValue(rw.getCell(k));		   
		   fis=new FileInputStream("C:\\Users\\user\\Documents\\dataprop.xlsx");
		   wb=WorkbookFactory.create(fis);
		   wb.getSheet("Sheet4");
		   sh.getRow(i);
		   rw.createCell(k).setCellValue(data);		    	
		   fos=new FileOutputStream("C:\\Users\\user\\Documents\\dataprop.xlsx");
		    wb.write(fos);
		    wb.close();	*/
	}
   }
