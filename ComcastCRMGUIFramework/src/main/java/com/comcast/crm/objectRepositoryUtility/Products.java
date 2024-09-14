package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Products {
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement pdaddbtn;
	
	@FindBy(id="bas_searchfield")
	private WebElement productdd;
	
	public WebElement getPdAddBtn() {
		return pdaddbtn;
		
	}	
	public WebElement getProductDd() {
		return productdd;		
	}
}
