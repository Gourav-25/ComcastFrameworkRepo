package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {
   WebDriver driver;
	public  OrganisationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement  createneworgbtn;
	
	@FindBy(xpath="//input[ @name='search_text']")
	private WebElement searchbox;
	
	@FindBy(id="bas_searchfield")
	private WebElement searchdd;
	
	@FindBy(name="submit")
	private WebElement svbtn;
		
	public WebElement getCreateNewOrgBtn() {
		return createneworgbtn;		
	}	
	
	public WebElement getSearchbox() {
		return searchbox;
	}	
	
	public WebElement getSearchdd() {
		return searchdd;
	}
	
	public WebElement getSvbtn() {
		return svbtn;
		
	}
}
