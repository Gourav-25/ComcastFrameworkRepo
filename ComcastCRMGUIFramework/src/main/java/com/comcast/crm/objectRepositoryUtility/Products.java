package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Products {
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement pdaddbtn;
	
	@FindBy(name="search_text")
	private WebElement searchbtn;
	
	@FindBy(xpath="//input[@class='crmbutton small edit']")
	private WebElement ele2;
	
	public WebElement getPdAddBtn() {
		return pdaddbtn;		
	}
	
	public WebElement getSearchBtn() {
		return searchbtn;
	}
	
	public WebElement getEle2() {
		return ele2;
	}
}
