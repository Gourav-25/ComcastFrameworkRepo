package Ninja;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.comcast.generic.fileutility.ExcelUtility;

public class HrmDetails2 {

	@Test
	public void projectDetails() throws SQLException, EncryptedDocumentException, IOException {
		int j = 0;
		boolean flag = false;
		Connection conn = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects", "root@%", "root");
		Statement stat = conn.createStatement();
		int res = stat.executeUpdate("insert into Project values('TY_PROJ_98085','AGG','23-8-2024','Tektest','created',5)");
		conn.close();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://106.51.90.215:8084");
		driver.findElement(By.id("username")).sendKeys("rmgYantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
		driver.findElement(By.linkText("Projects")).click();	    
		FileInputStream fis = new FileInputStream("C:\\Users\\user\\Documents\\ProjectData2.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.createSheet("projectdetails1");
		Row rw = sh.createRow(0);                        //for  creating sheet or creating cell or creating row or setcellvalue we should use below three steps
		FileOutputStream fos = new FileOutputStream("C:\\Users\\user\\Documents\\ProjectData2.xlsx"); //1
		wb.write(fos);                    //2
		wb.close();//3
		                                    
		 while(true) {	
			 try {
				List<WebElement> projectid = driver.findElements(By.xpath("//tbody/tr/a/td"));
				for (WebElement id : projectid) {
					if (id.getText().equals("TY_PROJ_98085")) {
						flag = true;
						String pgno=driver.findElement(By.xpath("//div[@class='container-fluid']/descendant::a[@href='/dashboard/modules/"+id.getText()+"']/ancestor::div[@class='container-fluid']/descendant::ul/descendant::li[@class='page-item active']/a")).getText();
						System.out.println(id.getText() + ": is found in page"+pgno );
						String pid = id.getText();
						System.out.println(pid);
						List<WebElement> projectdata = driver.findElements(By.xpath("//a[@href='/dashboard/modules/"+pid+"']/ancestor::tr/a/../descendant::td[not(a)]"));
						for (WebElement alldata : projectdata) {
							String data = alldata.getText();
							System.out.println(data);
							fis = new FileInputStream("C:\\Users\\user\\Documents\\ProjectData2.xlsx");
							wb = WorkbookFactory.create(fis);
							sh = wb.getSheet("projectdetails1");
							rw = sh.getRow(0);
							Cell cel = rw.createCell(j++);
							cel.setCellType(CellType.STRING);
							cel.setCellValue(data);
							fos = new FileOutputStream("C:\\Users\\user\\Documents\\ProjectData2.xlsx");
							wb.write(fos);
							wb.close();							
						} 
						if(flag==true)
						break;
					}
				}
				if(flag==true)
					break;
				WebElement nxtpgbutton=driver.findElement(By.xpath("//a[@aria-label='Go to next page']/.."));
				String text=nxtpgbutton.getAttribute("class");
				 if(text.contains("disabled")) { 
					 break;
				 }				 
				 driver.findElement(By.xpath("//a[@aria-label='Go to next page']")).click();
			 }
		 
		       catch(StaleElementReferenceException e) {		    	 				       
						List<WebElement> projectid = driver.findElements(By.xpath("//tbody/tr/a/td"));
						for (WebElement id : projectid) {
							if (id.getText().equals("TY_PROJ_98085")) {
								flag = true;
								String pgno=driver.findElement(By.xpath("//div[@class='container-fluid']/descendant::a[@href='/dashboard/modules/"+id.getText()+"']/ancestor::div[@class='container-fluid']/descendant::ul/descendant::li[@class='page-item active']/a")).getText();
								System.out.println(id.getText() + ": is found in page"+pgno );
								String pid = id.getText();
								System.out.println(pid);
								List<WebElement> projectdata = driver.findElements(By.xpath("//a[@href='/dashboard/modules/"+pid+"']/ancestor::tr/a/../descendant::td[not(a)]"));
								for (WebElement alldata : projectdata) {
									String data = alldata.getText();
									System.out.println(data);
									fis = new FileInputStream("C:\\Users\\user\\Documents\\ProjectData2.xlsx");
									wb = WorkbookFactory.create(fis);
									sh = wb.getSheet("projectdetails1");
									rw = sh.getRow(0);
									Cell cel = rw.createCell(j++);
									cel.setCellType(CellType.STRING);
									cel.setCellValue(data);
									fos = new FileOutputStream("C:\\Users\\user\\Documents\\ProjectData2.xlsx");
									wb.write(fos);
									wb.close();									
								}
							     if(flag==true)
									break;
							}							
				         }
						if(flag==true)
							break;
						WebElement nxtpgbutton=driver.findElement(By.xpath("//a[@aria-label='Go to next page']/.."));
						String text=nxtpgbutton.getAttribute("class");
						 if(text.contains("disabled")) { 
							 break;
						 }	
						 driver.findElement(By.xpath("//a[@aria-label='Go to next page']")).click();
						  }				             
		    	 		}				 
		            }						         
                }


