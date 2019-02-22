package AER.FMDP_Automation.functionalLibrary.recipient;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import AER.FMDP_Automation.pageObjects.common.CommonPO;
import AER.FMDP_Automation.pageObjects.common.ItemListPO;
import AER.FMDP_Automation.pageObjects.recipient.RecipientSearchPO;
import utilities.Constants;
import utilities.JavaHelpers;
import utilities.SeleniumHelpers;

public class RecipientSearchLib 
{
	WebDriver driver;
	SeleniumHelpers selenium;
	CommonPO help;
	RecipientSearchPO searchpo;
	JavaHelpers java;
	ItemListPO itemlist;
	
	
	public RecipientSearchLib(WebDriver driver)
	{	 
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);
        help = new CommonPO(driver);
        java = new JavaHelpers();
        searchpo = new RecipientSearchPO(driver);
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
					searchpo.search_enterRecipientName(searchvalue);
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
					searchpo.search_enterRecipientID(searchvalue);
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
	
		
		/**
		 * Only Search user by username without verifying the first record
		 * @param username Username of user
		 */
		public void search_userWithUserName(String username)
		{
			searchpo.search_deselectCheckboxActiveRecipient();
			searchpo.search_deselectCheckboxInactiveRecipient();
			searchpo.search_enterRecipientName(username);
			help.btn_ClickOnSearch();
		}
		
		
		/**
		 * Only Search user by user id without verifying the first record
		 * @param id User ID
		 */
		public void search_userWithUserId(String id)
		{
			searchpo.search_deselectCheckboxActiveRecipient();
			searchpo.search_deselectCheckboxInactiveRecipient();
			searchpo.search_enterRecipientName(id);
			help.btn_ClickOnSearch();
		}
		
		
		/**
		 * Search User by username and verify first record in grid.
		 * 
		 * @param searchvalue			Search value	e.g. UN_20181115_185704
		 * @throws InterruptedException
		 */
		public void search_SearchAllRecipientWithRecipientName(String searchvalue) throws InterruptedException
		{
			searchpo.search_deselectCheckboxActiveRecipient();
			searchpo.search_deselectCheckboxInactiveRecipient();
			
			int i=0;
			boolean isfirstitem = false;
			
			do {
				searchpo.search_enterRecipientName(searchvalue);
				help.btn_ClickOnSearch();
				
				if (itemlist.search_IsFirstSearchedItemDisplayed()) 
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
				Assert.fail("FAIL : On Recipient search, no search result appeared!");
			}
		}
		
		
		/**
		 * Search User by username and verify first record in grid.
		 * 
		 * @param searchvalue			Search value	e.g. UN_20181115_185704
		 * @throws InterruptedException
		 */
		public void search_SearchActiveRecipientWithRecipientName(String searchvalue) throws InterruptedException
		{
			searchpo.search_selectCheckboxActiveRecipient();
			searchpo.search_deselectCheckboxInactiveRecipient();
			
			int i=0;
			boolean isfirstitem = false;
			
			do {
				searchpo.search_enterRecipientName(searchvalue);
				help.btn_ClickOnSearch();
				
				if (itemlist.search_IsFirstSearchedItemDisplayed()) 
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
				Assert.fail("FAIL : On Recipient search, no search result appeared!");
			}
		}
		
		
		/**
		 * Search User by username and verify first record in grid.
		 * 
		 * @param searchvalue			Search value	e.g. UN_20181115_185704
		 * @throws InterruptedException
		 */
		public void search_SearchInactiveRecipientWithRecipientName(String searchvalue) throws InterruptedException
		{
			searchpo.search_deselectCheckboxActiveRecipient();
			searchpo.search_selectCheckboxInactiveRecipient();
			
			int i=0;
			boolean isfirstitem = false;
			
			do {
				searchpo.search_enterRecipientName(searchvalue);
				help.btn_ClickOnSearch();
				
				if (itemlist.search_IsFirstSearchedItemDisplayed()) 
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
				Assert.fail("FAIL : On Recipient search, no search result appeared!");
			}
		}
		
		
		/**
		 * Search User by username and click.
		 * 
		 * @param searchvalue				Search With Value	e.g. UN_20181115_185704
		 * @throws InterruptedException
		 */
		public void search_SearchActiveRecipientWithRecipientNameAndClick(String searchvalue) throws InterruptedException
		{
			searchpo.search_selectCheckboxActiveRecipient();
			searchpo.search_deselectCheckboxInactiveRecipient();
			
			int i=0;
			boolean isfirstitem = false;
			
			do {
				searchpo.search_enterRecipientName(searchvalue);
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
				Assert.fail("FAIL : On Recipient search, no search result appeared!");
			}
		}
		
		
		/**
		 * Search User by username and click.
		 * 
		 * @param searchvalue				Search With Value	e.g. UN_20181115_185704
		 * @throws InterruptedException
		 */
		public void search_SearchInactiveRecipientWithRecipientNameAndClick(String searchvalue) throws InterruptedException
		{
			searchpo.search_deselectCheckboxActiveRecipient();
			searchpo.search_selectCheckboxInactiveRecipient();
			
			int i=0;
			boolean isfirstitem = false;
			
			do {
				searchpo.search_enterRecipientName(searchvalue);
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
				Assert.fail("FAIL : On Recipient search, no search result appeared!");
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
		public String getGeneralDetailsSectionData(int row, int column)
		{
			return searchpo.getGeneralDetailsSectionData(row, column);
		}
		
		public String getBasicDetailsPriorityData()
		{
			return searchpo.getGeneralDetailsPriorityData();
		}
		
		public boolean getGeneralDetailsCheckboxData(int row, int column, int subrow)
		{
			return searchpo.getGeneralDetailsCheckboxData(row, column, subrow);
		}
		
		public boolean getFileNameTextboxStatus()
		{
			return searchpo.getFileNameTextboxStatus();
		}
		
		public boolean getRemovePrefixCheckboxStatus()
		{
			return searchpo.getRemovePrefixCheckboxStatus();
		}
		
		public String getFTPDetailsSectionData(int row, int column)
		{
			return searchpo.getFTPDetailsSectionData(row, column);
		}
		
		public boolean getFTPDetailsSectionData(int row, int column, int input)
		{
			return searchpo.getFTPDetailsSectionData(row, column, input);
		}
		
	//User summary grid data
		/**
		 * Read details from user summary grid row and column wise
		 * @param row
		 * @param column
		 * @return	data for given row and column
		 */
		public String getRecipientGridData(int row, int column)
		{
			return searchpo.getRecipientGridData(row, column);
		}
			
}
