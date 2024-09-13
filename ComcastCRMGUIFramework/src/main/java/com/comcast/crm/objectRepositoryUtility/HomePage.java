package com.comcast.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	 WebDriver driver;
        public  HomePage(WebDriver driver) {
        	this.driver=driver;
        	PageFactory.initElements(driver,this);
        }
        
        @FindBy(linkText="Products")
        private WebElement productlink;
        
        @FindBy(linkText="Email")
        private WebElement emaillink;
        
        @FindBy(linkText="Leads")
        private WebElement leadlink;
        
        @FindBy(linkText="Organizations")
         private WebElement  orglink;
        
        @FindBy(linkText="Contacts")
        private WebElement contlink;  
              
        
        @FindBy(linkText="Campaigns")
        private WebElement campaignlink;
        
        @FindBy(linkText="More")
        private WebElement morelink;
        
        @FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
        private WebElement administartion;
        
        @FindBy(linkText="Sign Out")
        private WebElement signout;
       
        
        public WebElement getOrgLink() {
        	return orglink;
        }
        public WebElement getContLink() {
        	return contlink;
        }
        
        public WebElement getLeadLink() {
        	return leadlink;
        }
        public WebElement getCampaignlink() {
        	return campaignlink;
        }
        
        public WebElement getMorelink() {
        	return morelink;
        }
         public WebElement getAdministration() {
        	 return administartion;
         }
         
         public WebElement getProductlink() {
        	 return productlink;
         }
         
         public WebElement getEmailLink() {
        	 return emaillink;
         }
             
         public void logout() {
        	 Actions act=new Actions(driver);
        	 act.moveToElement(administartion).perform();
        	 signout.click();
         }
         
        public void navigateToCampaignPage() {
        	Actions act=new Actions(driver);
        	act.moveToElement(morelink).perform();
        	campaignlink.click();
        }       
        
}
