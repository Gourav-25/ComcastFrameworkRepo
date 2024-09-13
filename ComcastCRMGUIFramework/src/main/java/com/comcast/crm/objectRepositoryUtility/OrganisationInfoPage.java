package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationInfoPage {
	WebDriver driver;
        public OrganisationInfoPage(WebDriver driver) {
        	this.driver=driver;
        	PageFactory.initElements(driver,this);
        }
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement hdrmsg;
	
	@FindBy(id="dtlview_Organization Name")
	private WebElement nameoforg;
	
	
	public WebElement getHdrmsg() {
		return hdrmsg;
	}
	  public WebElement getNameOfOrg() {
       return nameoforg;
     }
}