package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrganisation {
	WebDriver driver;
	public CreateNewOrganisation(WebDriver driver) {
            this.driver=driver;
            PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@type='text' and @name='accountname']")
	private WebElement orgname;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	@FindBy(xpath="//select[@name='industry' and @class='small']")
	private WebElement industrydd;
	
	@FindBy(name="accounttype")
	private WebElement typedd;
	
	@FindBy(id="phone")
	private WebElement phoneno;
	
	@FindBy(id="fax")
	private WebElement fax;
	
	public WebElement getTypedd() {
		return typedd;
	}
	
	public WebElement getOrgname() {
		return orgname;
	}
	
	public WebElement getFax() {
		return fax;
	}
	public WebElement getIndustrydd() {
		return industrydd;
	}
	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public WebElement getPhoneno() {
		return phoneno;
	}
		
	public void createOrg(String name)  {
		orgname.sendKeys(name);
		savebtn.click();
	}
	public void createOrgWithInd(String name,String industry,String type) {
	   orgname.sendKeys(name);
	Select sel=new Select(industrydd);
	sel.selectByVisibleText(industry);
	Select sel1=new Select(typedd);
	sel1.selectByVisibleText(type);
	savebtn.click();	
	}	
	
	public void createOrgWithPhoneNumber(String nameorg,String pno) {	
		orgname.sendKeys(nameorg);
		phoneno.sendKeys(pno);
		savebtn.click();		
	}
}
