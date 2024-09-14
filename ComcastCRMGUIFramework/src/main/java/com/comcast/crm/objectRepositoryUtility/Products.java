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

	@FindBy(id="bas_searchfield")
	private WebElement productdd;
	
	@FindBy(xpath="//img[@alt='Products Settings']")
	private WebElement pdsettings;

	
	public WebElement getPdAddBtn() {

		return pdaddbtn;		
		
	}	
	public WebElement getProductDd() {
		return productdd;		

	}
	
	public WebElement getSearchBtn() {
		return searchbtn;
	}
	
	public WebElement getEle2() {
		return ele2;

	public WebElement getPdSettings() {
		return pdsettings;
		

	}
}
