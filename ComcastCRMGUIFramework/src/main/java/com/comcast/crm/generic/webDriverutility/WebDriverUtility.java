package com.comcast.crm.generic.webDriverutility;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	String pwid="";
      public void waitForPageToLoad(WebDriver driver) {
    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
      }
      public void waitForElement(WebDriver driver,WebElement element) {
    	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
    	  wait.until(ExpectedConditions.visibilityOf(element));
      }
      public void storeParentWindow(WebDriver driver) {
    	 pwid=driver.getWindowHandle();   	 
      }
      public  void switchNewrBowserTab(WebDriver driver) {   	 
     		Set<String> allwid=driver.getWindowHandles();
     		for(String wid:allwid) {
     			if(!wid.equals(pwid))
     			driver.switchTo().window(wid);     			
      }   		
}
      public void switchToParentWindow(WebDriver driver) {
    	  driver.switchTo().window(pwid);
        }     
      public void switchtoFrame(WebDriver driver,String nameID) {
    	  driver.switchTo().frame(nameID);
      }
      public void switchToFrame(WebDriver driver,WebElement element) {
    	  driver.switchTo().frame(element);
      }
      public void switchToAlert(WebDriver driver) {
    	  driver.switchTo().alert().accept();
      }
      public void switchToAlertAndCanel(WebDriver driver) {
    	  driver.switchTo().alert().dismiss();
             }
      public void selectByVisibleText(WebElement element ,String text) {
    	  Select sel=new Select(element);
    	  sel.selectByVisibleText(text);
      }
      public void selectByIndex(WebElement element,int index) {
    	  Select sel=new Select(element);
    	  sel.selectByIndex(index);
      }
      public void mousemovement(WebDriver driver,WebElement element) {
    	  Actions act=new Actions(driver);
    	  act.moveToElement(element).perform();
      }
      public void doubleClick(WebDriver driver,WebElement element) {
    	  Actions act=new Actions(driver);
    	  act.doubleClick(element).perform();
      }
      //one generic method to perform dragand drop and mouseover
      public void dragDropAndMouseOver(WebDriver driver,WebElement sourceelement,WebElement targetelement,WebElement mouseover) {
    	  Actions act=new Actions(driver);
              if(sourceelement!=null && targetelement!=null)
            	  act.dragAndDrop(sourceelement, targetelement).perform();
              else
            	  act.moveToElement(mouseover).perform();
      }
      //or if mouseoverelement and sourceelement is same
      public void dragnDropAndMouseOver(WebDriver driver,WebElement sourceelement,WebElement targetelement) {
    	  Actions act=new Actions(driver);
    	  if(targetelement!=null)
    	  act.dragAndDrop(sourceelement,targetelement).perform();
    	  else
    		  act.moveToElement(sourceelement);
      }
      //Create a generic method to handle both static  and dynamic dropdown 
      
      public void dropDownOption(WebDriver driver,WebElement dropdownelement,By optionlocator,String optiontext) {
    	  if(dropdownelement.getTagName().equals("select")) 
    		  handleStaticDropdown(dropdownelement,optiontext);  		  
    	  else
    		  handleDynamicDropdown(driver,dropdownelement,optionlocator,optiontext);		  
    		  } 
      public void handleStaticDropdown(WebElement dropdownelement,String optiontext) {
    	  Select sel=new Select(dropdownelement);
    	  sel.deselectByVisibleText(optiontext);
      }
      public void handleDynamicDropdown(WebDriver driver ,WebElement dropdownelement,By optionlocator,String optiontext) {
    	  dropdownelement.click();
    	  List<WebElement> alloption=driver.findElements(optionlocator);
    	  for(WebElement option:alloption) {
    		  if(option.getText().equals(optiontext))
    			  option.click();    		  
    	  }
      } 
      
    //For calling  generic method to handle both static  and dynamic dropdown we are using in the above program
     //For calling static dropdown 
     /* WebElement staticDropdownElement = driver.findElement(By.id("staticDropdownId"));
      dropdownHandler.dropDownOption(driver,staticDropdownElement, null, "Option 1");

     //for calling generic dropdown
      WebElement dynamicDropdownElement = driver.findElement(By.id("dynamicDropdownId"));
      By dynamicOptionLocator = By.xpath("//ul[@class='dropdown-menu']/li");
      dropdownHandler.dropDownOption(driver,dynamicDropdownElement, dynamicOptionLocator, "Option 2");*/
}