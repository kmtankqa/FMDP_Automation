package AER.FMDP_Automation.pageObjects.user;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import AER.FMDP_Automation.pageObjects.common.CommonPO;
import utilities.Constants;
import utilities.JavaHelpers;
import utilities.SeleniumHelpers; 

public class UserSetupPO 
{
	WebDriver driver;
	SeleniumHelpers selenium;
	CommonPO help;
	JavaHelpers java;
	
	public UserSetupPO(WebDriver driver)
	{	 
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);
        help = new CommonPO(driver);
        java = new JavaHelpers();

        //This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, Constants.PAGEFACTORY_WAIT_DURATION), this);
	}
	
	
	/*
	 * All WebElements are identified by @FindBy annotation
	 * @FindBy can accept tagName, partialLinkText, name, linkText, id, css, className, xpath as attributes.
	 */ 	
	
	//User Summary Page :
	
		@FindBy(css=".user-options2 > input[value='Create New User']")
		private WebElement createNewUser;
		
		
	//User Details Page :
		
		//Basic Details section
		@FindBy(id="txtFirstName")
		private WebElement firstName;
		
		@FindBy(id="txtLastName")
		private WebElement lastName;
		
		@FindBy(id="txtContactNo")
		private WebElement contactNo;
		
		@FindBy(id="txtEmailId")
		private WebElement emailId;
		
		@FindBy(id="txtUserName")
		private WebElement userName;
		
		@FindBy(id="txtPassword")
		private WebElement password;
		
		@FindBy(id="txtPasswordC")
		private WebElement passwordConfirm;
		
		@FindBy(id="MainContent_txtDescription")
		private WebElement description;
		
		//Feature Details section
		@FindBy(css=".innerTable tbody ol[id='chklstAccessibleFeatures'] > li > input")
		public List<WebElement> featureAccess;

		
		public void clickOnCreateNewUserBtn()
		{
			createNewUser.click();
		}
				
		public void enterFirstName(String firstname)
		{
			firstName.clear();
			firstName.sendKeys(firstname);
		}
		
		public void enterLastName(String lastname)
		{
			lastName.clear();
			lastName.sendKeys(lastname);
		}
		
		public void enterContactNumber(String contactno)
		{
			contactNo.clear();
			contactNo.sendKeys(contactno);
		}
		
		public void enterEmailId(String emailid)
		{
			emailId.clear();
			emailId.sendKeys(emailid);
		}
		
		public void enterUserName(String username)
		{
			userName.clear();
			userName.sendKeys(username);
		}
		
		public void enterPassword(String passwordvalue)
		{
			password.clear();
			password.sendKeys(passwordvalue);
		}
		
		public void enterConfirmPassword(String confirmpassword)
		{
			passwordConfirm.clear();
			passwordConfirm.sendKeys(confirmpassword);
		}
		
		public void enterDescription(String descriptionvalue)
		{
			description.clear();
			description.sendKeys(descriptionvalue);
		}
		
		public void selectFeatureAccess() throws InterruptedException
		{
			int size = featureAccess.size();
					
			for (int i=0; i < size; i++)
			{
				if(!featureAccess.get(i).isSelected())
				{
					featureAccess.get(i).click();
				}
			}
		}
		
		public void unSelectFeatureAccess() throws InterruptedException
		{
			int size = featureAccess.size();
					
			for (int i=0; i < size-1; i++)
			{
				if(featureAccess.get(i).isSelected())
				{
					featureAccess.get(i).click();
				}
			}
		}
		
		
		
}
