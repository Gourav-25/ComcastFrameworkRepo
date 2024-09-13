package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webDriverutility.WebDriverUtility;

public class CreateNewContactsPage {
	WebDriver driver;

	public CreateNewContactsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "lastname")
	private WebElement lastname;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement svbtn;

	@FindBy(name = "support_start_date")
	private WebElement ssd;

	@FindBy(name = "support_end_date")
	private WebElement sed;

	@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement addorg;

	@FindBy(xpath = "(//input[@type='text'])[1]")
	private WebElement orgsearch;

	@FindBy(xpath = "//input[@type='button']")
	private WebElement orgbtn;

	public WebElement getLastName() {
		return lastname;
	}

	public WebElement getSvbtn() {
		return svbtn;
	}

	public WebElement getssd() {
		return ssd;
	}

	public WebElement getsed() {
		return sed;
	}

	public WebElement getAddOrg() {
		return addorg;
	}

	public WebElement getOrgSearch() {
		return orgsearch;
	}

	public WebElement getorgbtn() {
		return orgbtn;
	}

	public void createContact(String ltname) {
		lastname.sendKeys(ltname);
		svbtn.click();
	}

	public void createContactWithSupportDate(String ltname, String startdt, String enddt) {
		lastname.sendKeys(ltname);
		ssd.clear();
		ssd.sendKeys(startdt);
		sed.clear();
		sed.sendKeys(enddt);
		svbtn.click();
	}

	public void createContactwithOrg(String ltname, String orgname) {
		lastname.sendKeys(ltname);
		addorg.click();
		WebDriverUtility wu = new WebDriverUtility();
		wu.storeParentWindow(driver);
		wu.switchNewrBowserTab(driver);
		orgsearch.sendKeys(orgname);
		orgbtn.click();
	}
}
