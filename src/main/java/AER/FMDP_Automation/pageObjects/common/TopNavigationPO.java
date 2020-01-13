package AER.FMDP_Automation.pageObjects.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utilities.Constants;
import utilities.JavaHelpers;
import utilities.SeleniumHelpers;

public class TopNavigationPO 
{
	WebDriver driver;
	SeleniumHelpers selenium;
	CommonPO common;
	JavaHelpers java;
	Actions action;

	
	public TopNavigationPO(WebDriver driver)
	{	 
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);
        common = new CommonPO(driver);
        java = new JavaHelpers();
        action = new Actions(driver);
        //This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, Constants.PAGEFACTORY_WAIT_DURATION), this);
	}
	
	
	/*
	 * All WebElements are identified by @FindBy annotation
	 * @FindBy can accept tagName, partialLinkText, name, linkText, id, css, className, xpath as attributes.
	 */ 	
	
	//Menu Items
	
		@FindBy(css=".topnav> ul > li:nth-of-type(1) > a")
		public WebElement settings;
	
		@FindBy(css=".topnav> ul > li:nth-of-type(1) > ul > li:nth-of-type(1) > a")
		public WebElement generalSettingMenu;
	
		@FindBy(css=".topnav> ul > li:nth-of-type(1) > ul > li:nth-of-type(2) > a")
		public WebElement mnSettingsMenu;
	
		@FindBy(css=".topnav> ul > li:nth-of-type(5) > a")
		public WebElement userManagementMenu;
		
		@FindBy(css=".topnav> ul > li:nth-of-type(7) > a")
		public WebElement recipientManagementMenu;
		
		@FindBy(css=".topnav> ul > li:nth-of-type(6) > a")
		public WebElement supplierManagementMenu;
		
		@FindBy(css=".topnav> ul > li:nth-of-type(3) > a")
		public WebElement distribution;
		
		@FindBy(css=".topnav> ul > li:nth-of-type(3) > ul > li:nth-of-type(1) > a")
		public WebElement distributionSummaryMenu;
		
	//Home Page banner images
		@FindBy(id="MainContent_imgbtnSettings")
		public WebElement settingsBannerImage;
		
	
	//Profile Badge	
		@FindBy(id="lblUser")
	    public WebElement loggedInUserName;
		
		@FindBy(css="a.topBarUser")
	    public WebElement profileBadge;
		
		@FindBy(linkText="Home")
	    public WebElement home;
		
		@FindBy(linkText="Change Password")
	    public WebElement changePassword;
		
			//Change Password
			@FindBy(id="txtCurrentPassword")
		    public WebElement currentPassword;
			
			@FindBy(id="txtPassword")
		    public WebElement newPassword;
			
			@FindBy(id="txtPasswordC")
		    public WebElement reenternewPassword;
			
		@FindBy(id="btnChangePassword")
		public WebElement changePasswordBtn;
			
		@FindBy(id="lnkbtnLogout")
	    public WebElement logout;
			

            
	//Profile Badge
		public String getLoggedInUserName()
		{
			selenium.waitTillElementIsClickable(loggedInUserName);
			return loggedInUserName.getText().trim();
		}
		
		public boolean isProfileBadgeDisplayed()
		{
			try 
			{
				return profileBadge.isDisplayed();
			} 
			catch (Exception e) 
			{
				return false;
			}
		}
		
		public void clickOnProfileBadge()
		{
			profileBadge.click();
		}
		
		public void clickOnHome()
		{
			home.click();
			selenium.waitTillElementIsVisible(settingsBannerImage);
		}
		
		public void clickOnChangePassword()
		{
			changePassword.click();
			common.waitTillPageLoaded();
		}
		
			//Change your password sidebar
			public void enterValueForCurrentPassword(String password)
			{
				currentPassword.clear();
				currentPassword.sendKeys(password);
			}
			
			public void enterValueForNewPassword(String password)
			{
				newPassword.clear();
				newPassword.sendKeys(password);
			}
			
			public void enterValueForReenterPassword(String password)
			{
				reenternewPassword.clear();
				reenternewPassword.sendKeys(password);
			}
			
			public void clickOnChangePasswordBtn()
			{
				changePasswordBtn.click();
			}
		
		public void clickOnLogout()
		{
			logout.click();
		}
		
		

	//Settings
		
		//Click On General Settings
		public void menu_ClickOnGeneralSetting()
		{
	        action.moveToElement(settings).build().perform();
			generalSettingMenu.click();
		}
		
		//Click on M & N Settings
		public void menu_ClickOnMnSetting()
		{
			action.moveToElement(settings).build().perform();
			mnSettingsMenu.click();
		}
		
		
	//User Management
		
		//Click on User Management
		public void menu_ClickOnUserManagement()
		{
			userManagementMenu.click();
		}
		
		
	//Recipient Management
		
		//Click on Recipient Management
		public void menu_ClickOnRecipientManagement()
		{
			recipientManagementMenu.click();
		}
	
	//Supplier Management
	
		//Click on Supplier Management
		public void menu_ClickOnSupplierManagement()
		{
			supplierManagementMenu.click();
		}
		
	//Distribution Management
		
		//Click on Distribution Summary
		public void menu_ClickOnDistributionSummary()
		{
			action.moveToElement(distribution).build().perform();
			distributionSummaryMenu.click();
		}
		

		
	
}
		

