package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webDriverutility.WebDriverUtility;
/**
 * 
 * @author Aman
 * Contains LoginPageElement and businessLib like login()
 * 
 */
public class LoginPage extends WebDriverUtility  {
	WebDriver driver;
	
    public LoginPage(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver,this);
    }
	@FindBy(name="user_name")
	private WebElement usernameedit;
	
	@FindBy(name="user_password")
	private WebElement passwordedit;
	
	@FindAll({@FindBy(id="submitButton"), @FindBy(xpath="//input[@type='submit']")})
	private WebElement loginbtn;
	
	//ObjectEncapsulation
	
   public WebElement getUsernameedit() {
		return usernameedit;
	}

	public WebElement getPasswordedit() {
		return passwordedit;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
/**
 * 	login to application based on username,password,url,arguments
 * @param url
 * @param username
 * @param password
 */	
	
	public void loginToapp(String url,String username,String password) {
		driver.get(url);
		driver.manage().window().maximize();
		waitForPageToLoad(driver);
		usernameedit.sendKeys(username);
		passwordedit.sendKeys(password);
		loginbtn.click();
	}
}
