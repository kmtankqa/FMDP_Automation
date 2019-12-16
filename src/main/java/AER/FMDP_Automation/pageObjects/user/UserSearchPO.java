package AER.FMDP_Automation.pageObjects.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import AER.FMDP_Automation.pageObjects.common.CommonPO;
import AER.FMDP_Automation.pageObjects.common.ItemListPO;
import utilities.Constants;
import utilities.JavaHelpers;
import utilities.SeleniumHelpers;

public class UserSearchPO 
{
	WebDriver driver;
	SeleniumHelpers selenium;
	CommonPO help;
	ItemListPO list;
	JavaHelpers java;
	
	public UserSearchPO(WebDriver driver)
	{	 
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);
        help = new CommonPO(driver);
        list = new ItemListPO(driver);
        java = new JavaHelpers();

        //This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, Constants.PAGEFACTORY_WAIT_DURATION), this);
	}
	
	
	/*
	 * All WebElements are identified by @FindBy annotation
	 * @FindBy can accept tagName, partialLinkText, name, linkText, id, css, className, xpath as attributes.
	 */ 
	
		
		//Search Criteria Section :	
		
			@FindBy(id="txtUserId")
			private WebElement userId;
			
			@FindBy(id="txtUserName")
			private WebElement userName;
		
			@FindBy(id="chkboxActiveUsers")
			private WebElement checkboxActiveUsers;
		
			@FindBy(id="chkboxInActiveUsers")
			private WebElement checkboxInActiveUsers;
		
			
		//User Details Page :
			
			@FindBy(css=".user-details-box.form-box > table > tbody > tr:nth-of-type(5) > td > textarea")
			private WebElement description;
			
			
		//Search Criteria :
			
			public void search_enterUserID(String userid)
			{
				userId.clear();
				userId.sendKeys(userid);
			}
		
			public void search_enterUserName(String username)
			{
				userName.clear();
				userName.sendKeys(username);
			}
			
			public void search_selectCheckboxActiveUser()
			{
				if(!checkboxActiveUsers.isSelected())
				{
					checkboxActiveUsers.click();
				}
			}
			
			public void search_unSelectCheckboxActiveUser()
			{
				if(checkboxActiveUsers.isSelected())
				{
					checkboxActiveUsers.click();
				}
			}
			
			public void search_selectCheckboxInactiveUser()
			{
				if(!checkboxInActiveUsers.isSelected())
				{
					checkboxInActiveUsers.click();
				}
			}
			
			public void search_unSelectCheckboxInactiveUser()
			{
				if(checkboxInActiveUsers.isSelected())
				{
					checkboxInActiveUsers.click();
				}
			}
			
			
			
	//Search :
			
		//Basic Details section
			
			//First & last name, contact no, email, user name, password, confirm password
			public String getBasicDetailsSectionData(int row, int column)
			{
				String cssSelector = ".user-details-box.form-box table tbody tr:nth-of-type(" + row + ") td:nth-of-type(" + column + ") > input";
				return selenium.waitTillElementIsVisible(By.cssSelector(cssSelector)).getAttribute("value").trim();
			}
			
			//Description
			public String getDescriptionData()
			{
				return description.getText().trim();
			}
			
			
		//Feature Details section
			public boolean getFeatureAccessData(int row)
			{	
				String cssSelector = "ol[id='chklstAccessibleFeatures'] li:nth-of-type(" + row + ") > input";
				return selenium.waitTillElementIsVisible(By.cssSelector(cssSelector)).isSelected();
			}

			
		//User Summary
			
			//Grid data: get username, first name, last name
			public String getUserGridData(int row, int column)
			{
				String cssSelector = "[id='griddata'] table tbody tr:nth-of-type(" + row + ") td:nth-of-type(" + column + ")";
				return selenium.waitTillElementIsVisible(By.cssSelector(cssSelector)).getText().trim();
			}
			
			
}

