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
		 * Search User by username or userid and click.
		 * 
		 * @param searchwith				Search With Information	e.g. username, id
		 * @param searchvalue				Search With Value	e.g. UN_20181115_185704, 21
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
					
					if (itemlist.search_IsFirstSearchedItemDisplayedRecipientOrUser()) 
					{
						itemlist.search_ClickOnFirstSearchedItemRecipientOrUser();
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
					
					if (itemlist.search_IsFirstSearchedItemDisplayedRecipientOrUser()) 
					{
						itemlist.search_ClickOnFirstSearchedItemRecipientOrUser();
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
	
		
		/**
		 * Only Search user by username without verifying the first record
		 * @param username Username of user
		 */
		public void search_userWithUserName(String username)
		{
			searchpo.search_unSelectCheckboxActiveUser();
			searchpo.search_unSelectCheckboxInactiveUser();
			searchpo.search_enterUserName(username);
			help.btn_ClickOnSearch();
		}
		
		
		/**
		 * Only Search user by user id without verifying the first record
		 * @param id User ID
		 */
		public void search_userWithUserId(String id)
		{
			searchpo.search_unSelectCheckboxActiveUser();
			searchpo.search_unSelectCheckboxInactiveUser();
			searchpo.search_enterUserName(id);
			help.btn_ClickOnSearch();
		}
		
		
		/**
		 * Search User by username and verify first record in grid.
		 * 
		 * @param searchvalue			Search value	e.g. UN_20181115_185704
		 * @throws InterruptedException
		 */
		public void search_SearchUserWithUserName(String searchvalue) throws InterruptedException
		{
			searchpo.search_unSelectCheckboxActiveUser();
			searchpo.search_unSelectCheckboxInactiveUser();
			
			int i=0;
			boolean isfirstitem = false;
			
			do {
				searchpo.search_enterUserName(searchvalue);
				help.btn_ClickOnSearch();
				
				if (itemlist.search_IsFirstSearchedItemDisplayedRecipientOrUser()) 
				{
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
		 * Search User by userid and verify first record in grid.
		 * 
		 * @param searchvalue			Search value	e.g. 20, 25
		 * @throws InterruptedException
		 */
		public void search_SearchUserWithUserId(String searchvalue) throws InterruptedException
		{
			searchpo.search_unSelectCheckboxActiveUser();
			searchpo.search_unSelectCheckboxInactiveUser();
			
			int i=0;
			boolean isfirstitem = false;
			
			do {
				searchpo.search_enterUserID(searchvalue);
				help.btn_ClickOnSearch();
				
				if (itemlist.search_IsFirstSearchedItemDisplayedRecipientOrUser()) 
				{
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
		 * Search User by username and click.
		 * 
		 * @param searchvalue				Search With Value	e.g. UN_20181115_185704
		 * @throws InterruptedException
		 */
		public void search_SearchUserWithUserNameAndClick(String searchvalue) throws InterruptedException
		{
			searchpo.search_unSelectCheckboxActiveUser();
			searchpo.search_unSelectCheckboxInactiveUser();
			
			int i=0;
			boolean isfirstitem = false;
			
			do {
				searchpo.search_enterUserName(searchvalue);
				help.btn_ClickOnSearch();
				
				if (itemlist.search_IsFirstSearchedItemDisplayedRecipientOrUser()) 
				{
					itemlist.search_ClickOnFirstSearchedItemRecipientOrUser();
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
		 * Search User by userid and click.
		 * 
		 * @param searchvalue				Search With Value	e.g. 20, 25
		 * @throws InterruptedException
		 */
		public void search_SearchUserWithUserIdAndClick(String searchvalue) throws InterruptedException
		{
			searchpo.search_unSelectCheckboxActiveUser();
			searchpo.search_unSelectCheckboxInactiveUser();
			
			int i=0;
			boolean isfirstitem = false;
			
			do {
				searchpo.search_enterUserID(searchvalue);
				help.btn_ClickOnSearch();
				
				if (itemlist.search_IsFirstSearchedItemDisplayedRecipientOrUser()) 
				{
					itemlist.search_ClickOnFirstSearchedItemRecipientOrUser();
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
		 * Read Basic Details section data row and column wise
		 * 
		 * @param row
		 * @param column
		 * @return data for given row and column
		 */
		public String getBasicDetailsSectionData(int row, int column)
		{
			return searchpo.getBasicDetailsSectionData(row, column);
		}
		
		
		/**
		 * Read description data from basis details section
		 * 
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
		
		
	//User summary grid data
		/**
		 * Read details from user summary grid row and column wise
		 * @param row
		 * @param column
		 * @return	data for given row and column
		 */
		public String getUserGridData(int row, int column)
		{
			return searchpo.getUserGridData(row, column);
		}
			
}
