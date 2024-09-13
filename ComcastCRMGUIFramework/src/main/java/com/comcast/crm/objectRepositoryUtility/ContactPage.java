package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	WebDriver driver;
	public ContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}  
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	 private WebElement createCon;
	
	
	public WebElement getCreateCon() {
	return createCon;
	}	
}
