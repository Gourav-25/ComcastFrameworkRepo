package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Products {
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement pdaddbtn;
	
	@FindBy(name="search_text")
	private WebElement searchbtn;
	
	public WebElement getPdAddBtn() {
		return pdaddbtn;		
	}
	
	public WebElement getSearchBtn() {
		return searchbtn;
	}

}
