package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	WebDriver driver;
	public ContactInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="dtlview_Last Name")
	private WebElement surname;
	
	@FindBy(id="dtlview_Support Start Date")
	private WebElement suptstartdt;
	
	@FindBy(id="dtlview_Support End Date")
	private WebElement suptenddt;
	
	public WebElement getSurname() {
		return surname;		
	}	
	public WebElement getSuptStartdt() {
		return suptstartdt;
	}
	public WebElement getSuptEnddt() {
		return suptenddt;
	}		
  }
