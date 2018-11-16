package AER.FMDP_Automation.functionalLibrary.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import AER.FMDP_Automation.pageObjects.common.CommonPO;
import AER.FMDP_Automation.pageObjects.common.ItemListPO;
import AER.FMDP_Automation.pageObjects.user.UserSearchPO;
import utilities.Constants;
import utilities.JavaHelpers;
import utilities.SeleniumHelpers;

public class UserSearchLib 
{
	WebDriver driver;
	SeleniumHelpers selenium;
	CommonPO help;
	UserSearchPO searchpo;
	JavaHelpers java;
	ItemListPO itemlist;
	
	
	public UserSearchLib(WebDriver driver)
	{	 
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);
        help = new CommonPO(driver);
        java = new JavaHelpers();
        searchpo = new UserSearchPO(driver);
        itemlist = new ItemListPO(driver);
        
	}
	
		//Search section
		
			/**
			 * Search Supplier by name and click
			 * @param name supplier name
			 * @throws InterruptedException
			 */
			public void search_SearchUserAndClick(String searchwith, String searchvalue) throws InterruptedException
			{
				int i=0;
				boolean isfirstitem = false;
				
				do {
					if (searchwith == "username")
					{
						searchpo.search_enterUserName(searchvalue);
						help.btn_ClickOnSearch();
						
						if (itemlist.search_IsFirstSearchedItemDisplayed()) 
						{
							itemlist.search_ClickOnFirstSearchedItem();
							isfirstitem = true;
							break;
						}
						else 
						{
							i++;
							selenium.refreshPage();
						}	
					} 
					else
					{
						searchpo.search_enterUserID(searchvalue);
						help.btn_ClickOnSearch();
						
						if (itemlist.search_IsFirstSearchedItemDisplayed()) 
						{
							itemlist.search_ClickOnFirstSearchedItem();
							isfirstitem = true;
							break;
						}
						else 
						{
							i++;
							selenium.refreshPage();
						}	
					}
					
				} while (i < Constants.MaxAttemptForLocatingElement);
				
				//if search result not found then failing test with message 
				if(!isfirstitem)
				{
					Assert.fail("FAIL : On Supplier search, no search result appeared!");
				}
			}
		
			
			public void search_SearchUserWithUserNameAndClick(String searchvalue) throws InterruptedException
			{
				int i=0;
				boolean isfirstitem = false;
				
				do {
					searchpo.search_enterUserName(searchvalue);
					help.btn_ClickOnSearch();
					
					if (itemlist.search_IsFirstSearchedItemDisplayed()) 
					{
						itemlist.search_ClickOnFirstSearchedItem();
						isfirstitem = true;
						break;
					}
					else 
					{
						i++;
						selenium.refreshPage();
					}	
					
				} while (i < Constants.MaxAttemptForLocatingElement);
				
				//if search result not found then failing test with message 
				if(!isfirstitem)
				{
					Assert.fail("FAIL : On Supplier search, no search result appeared!");
				}
			}
			
			
			public void search_SearchUserWithUserIdAndClick(String searchvalue) throws InterruptedException
			{
				int i=0;
				boolean isfirstitem = false;
				
				do {
					searchpo.search_enterUserID(searchvalue);
					help.btn_ClickOnSearch();
					
					if (itemlist.search_IsFirstSearchedItemDisplayed()) 
					{
						itemlist.search_ClickOnFirstSearchedItem();
						isfirstitem = true;
						break;
					}
					else 
					{
						i++;
						selenium.refreshPage();
					}	
					
				} while (i < Constants.MaxAttemptForLocatingElement);
				
				//if search result not found then failing test with message 
				if(!isfirstitem)
				{
					Assert.fail("FAIL : On Supplier search, no search result appeared!");
				}
			}
			
			/**
			 * Get no record text
			 * @return no record text
			 */
			public String search_GetNoRecordMsgText()
			{
				return itemlist.search_GetNoRecordMsgText();
			}
			
			
		
		//Basic Details section
				
			/**
			 * Read Details section data row wise including labels
			 * @param row
			 * @return data for given row
			 */
			public String getBasicDetailsSectionData(int row, int column)
			{
				return searchpo.getBasicDetailsSectionData(row, column);
			}
			
			/**
			 * Read description data
			 * @return data for description
			 */
			public String getDescriptionData()
			{
				return searchpo.getDescriptionData();
			}
			
			
		//Feature Details section
			/**
			 * Read Contact section data row wise including labels
			 * @param row
			 * @return data for given row
			 */
			public boolean getFeatureAccessData(int row)
			{
				return searchpo.getFeatureAccessData(row);
			}
			
		
						
}
