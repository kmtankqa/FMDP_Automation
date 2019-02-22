package AER.FMDP_Automation.pageObjects.recipient;

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

public class RecipientSearchPO 
{
	WebDriver driver;
	SeleniumHelpers selenium;
	CommonPO help;
	ItemListPO list;
	JavaHelpers java;
	
	public RecipientSearchPO(WebDriver driver)
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
		
			@FindBy(id="txtRecipientId")
			private WebElement recipientId;
			
			@FindBy(id="txtRecipientName")
			private WebElement recipientName;
		
			@FindBy(id="chkboxActiveRecipients")
			private WebElement checkboxActiveRecipients;
		
			@FindBy(id="chkboxInActiveRecipients")
			private WebElement checkboxInActiveRecipients;
		
			//File Name
			@FindBy(id="txtfileName")
			private WebElement fileName;
			
			//Remove Prefix
			@FindBy(id="chkRemovePrefix")
			private WebElement checkboxRemovePrefix;
			
			//Priority
			@FindBy(id="MainContent_ddlPriority")
			private WebElement priority;
			
			//Merge Longsell
			@FindBy(id="chkMergeLongsell")
			private WebElement chekMergeLongsell;
			
		//Search Criteria :
			
			public void search_enterRecipientID(String userid)
			{
				recipientId.clear();
				recipientId.sendKeys(userid);
			}
		
			public void search_enterRecipientName(String username)
			{
				recipientName.clear();
				recipientName.sendKeys(username);
			}
			
			public void search_selectCheckboxActiveRecipient()
			{
				if(!checkboxActiveRecipients.isSelected())
				{
					checkboxActiveRecipients.click();
				}
			}
			
			public void search_deselectCheckboxActiveRecipient()
			{
				if(checkboxActiveRecipients.isSelected())
				{
					checkboxActiveRecipients.click();
				}
			}
			
			public void search_selectCheckboxInactiveRecipient()
			{
				if(!checkboxInActiveRecipients.isSelected())
				{
					checkboxInActiveRecipients.click();
				}
			}
			
			public void search_deselectCheckboxInactiveRecipient()
			{
				if(checkboxInActiveRecipients.isSelected())
				{
					checkboxInActiveRecipients.click();
				}
			}
			
			
			
	//Search :
			
		//General Details section
			
			//Name, contact no, email, address1, address2, city, country, state, file name 
			public String getGeneralDetailsSectionData(int row, int column)
			{
				String cssSelector = ".recipient-details-box.form-box table tbody tr:nth-of-type(" + row + ") td:nth-of-type(" + column + ") > input";
				return selenium.waitTillElementIsVisible(By.cssSelector(cssSelector)).getAttribute("value").trim();
			}
		
			//Priority
			public String getGeneralDetailsPriorityData()
			{
				return selenium.getSelectedDropdownValue(priority);
			}
			
			//Check-box : Merge Longsell, Remove Prefix, CHD Fare, INF Fare
			public boolean getGeneralDetailsCheckboxData(int row, int column, int subrow)
			{
				String cssSelector = ".recipient-details-box.form-box table tbody tr:nth-of-type(" + row + ") td:nth-of-type(" + column + ") span input:nth-of-type(" + subrow + ")";
				return selenium.waitTillElementIsVisible(By.cssSelector(cssSelector)).isSelected();
			}
			

			//File Name
			public boolean getFileNameTextboxStatus()
			{
				return selenium.getElementStatus(fileName);
			}

			//Remove Prefix
			public boolean getRemovePrefixCheckboxStatus()
			{
				return selenium.getElementStatus(checkboxRemovePrefix);
			}
			
			
		//FTP Details
			
			//
			public String getFTPDetailsSectionData(int row, int column)
			{
				String cssSelector = ".ftp-details > table tbody tr:nth-of-type(" + row + ") td:nth-of-type(" + column + ") input";
				return selenium.waitTillElementIsVisible(By.cssSelector(cssSelector)).getAttribute("value").trim();
			}
			
			public boolean getFTPDetailsSectionData(int row, int column, int input)
			{
				String cssSelector = ".ftp-details > table tbody tr:nth-of-type(" + row + ") td:nth-of-type(" + column + ") span:nth-of-type(" + input + ") input";
				return selenium.waitTillElementIsVisible(By.cssSelector(cssSelector)).isSelected();
			}
			
			//
			public String getRecipientGridData(int row, int column)
			{
				String cssSelector = "[id='griddata'] table tbody tr:nth-of-type(" + row + ") td:nth-of-type(" + column + ")";
				return selenium.waitTillElementIsVisible(By.cssSelector(cssSelector)).getText().trim();
			}
			
	
			
}

