package AER.FMDP_Automation.functionalLibrary.supplier;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import AER.FMDP_Automation.pageObjects.common.CommonPO;
import AER.FMDP_Automation.pageObjects.common.ItemListPO;
import AER.FMDP_Automation.pageObjects.supplier.SupplierSearchPO;
import utilities.Constants;
import utilities.JavaHelpers;
import utilities.SeleniumHelpers;

public class SupplierSearchLib 
{
	WebDriver driver;
	SeleniumHelpers selenium;
	CommonPO help;
	SupplierSearchPO searchpo;
	JavaHelpers java;
	ItemListPO itemlist;
	
	
	public SupplierSearchLib(WebDriver driver)
	{	 
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);
        help = new CommonPO(driver);
        java = new JavaHelpers();
        searchpo = new SupplierSearchPO(driver);
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
		public void search_SearchSupplierAndClick(String searchwith, String searchvalue) throws InterruptedException
		{
			int i=0;
			boolean isfirstitem = false;
			
			do {
				if (searchwith == "suppliername")
				{
					searchpo.search_enterSupplierName(searchvalue);
					help.btn_ClickOnSearch();
					
					if (itemlist.search_IsFirstSearchedItemDisplayedSupplierOrDistribution()) 
					{
						itemlist.search_ClickOnFirstSearchedItemSupplierOrDistribution();
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
					searchpo.search_enterSupplierID(searchvalue);
					help.btn_ClickOnSearch();
					
					if (itemlist.search_IsFirstSearchedItemDisplayedSupplierOrDistribution()) 
					{
						itemlist.search_ClickOnFirstSearchedItemSupplierOrDistribution();
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
		public void search_userWithSupplierName(String suppliername)
		{
			searchpo.search_deselectCheckboxActiveSupplier();
			searchpo.search_deselectCheckboxInactiveSupplier();
			searchpo.search_enterSupplierName(suppliername);
			help.btn_ClickOnSearch();
		}
		
		
		/**
		 * Only Search user by user id without verifying the first record
		 * @param id User ID
		 */
		public void search_supplierWithSupplierId(String id)
		{
			searchpo.search_deselectCheckboxActiveSupplier();
			searchpo.search_deselectCheckboxInactiveSupplier();
			searchpo.search_enterSupplierName(id);
			help.btn_ClickOnSearch();
		}
		
		
		/**
		 * Search User by username and verify first record in grid.
		 * 
		 * @param searchvalue			Search value	e.g. UN_20181115_185704
		 * @throws InterruptedException
		 */
		public void search_SearchAllSupplierWithSupplierName(String searchvalue) throws InterruptedException
		{
			searchpo.search_deselectCheckboxActiveSupplier();
			searchpo.search_deselectCheckboxInactiveSupplier();
			
			int i=0;
			boolean isfirstitem = false;
			
			do {
				searchpo.search_enterSupplierName(searchvalue);
				help.btn_ClickOnSearch();
				
				if (itemlist.search_IsFirstSearchedItemDisplayedSupplierOrDistribution()) 
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
		 * Search User by username and verify first record in grid.
		 * 
		 * @param searchvalue			Search value	e.g. UN_20181115_185704
		 * @throws InterruptedException
		 */
		public void search_SearchActiveSupplierWithSupplierName(String searchvalue) throws InterruptedException
		{
			searchpo.search_selectCheckboxActiveSupplier();
			searchpo.search_deselectCheckboxInactiveSupplier();
			
			int i=0;
			boolean isfirstitem = false;
			
			do {
				searchpo.search_enterSupplierName(searchvalue);
				help.btn_ClickOnSearch();
				
				if (itemlist.search_IsFirstSearchedItemDisplayedSupplierOrDistribution()) 
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
		 * Search User by username and verify first record in grid.
		 * 
		 * @param searchvalue			Search value	e.g. UN_20181115_185704
		 * @throws InterruptedException
		 */
		public void search_SearchInactiveSupplierWithSupplierName(String searchvalue) throws InterruptedException
		{
			searchpo.search_deselectCheckboxActiveSupplier();
			searchpo.search_selectCheckboxInactiveSupplier();
			
			int i=0;
			boolean isfirstitem = false;
			
			do {
				searchpo.search_enterSupplierName(searchvalue);
				help.btn_ClickOnSearch();
				
				if (itemlist.search_IsFirstSearchedItemDisplayedSupplierOrDistribution()) 
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
		public void search_SearchActiveSupplierWithSupplierNameAndClick(String searchvalue) throws InterruptedException
		{
			searchpo.search_selectCheckboxActiveSupplier();
			searchpo.search_deselectCheckboxInactiveSupplier();
			
			int i=0;
			boolean isfirstitem = false;
			
			do {
				searchpo.search_enterSupplierName(searchvalue);
				help.btn_ClickOnSearch();
				
				if (itemlist.search_IsFirstSearchedItemDisplayedSupplierOrDistribution()) 
				{
					itemlist.search_ClickOnFirstSearchedItemSupplierOrDistribution();
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
		public void search_SearchInactiveSupplierWithSupplierNameAndClick(String searchvalue) throws InterruptedException
		{
			searchpo.search_deselectCheckboxActiveSupplier();
			searchpo.search_selectCheckboxInactiveSupplier();
			
			int i=0;
			boolean isfirstitem = false;
			
			do {
				searchpo.search_enterSupplierName(searchvalue);
				help.btn_ClickOnSearch();
				
				if (itemlist.search_IsFirstSearchedItemDisplayedSupplierOrDistribution()) 
				{
					itemlist.search_ClickOnFirstSearchedItemSupplierOrDistribution();
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
		 * Search User by username and verify first record in grid.
		 * 
		 * @param searchvalue			Search value	e.g. UN_20181115_185704
		 * @throws InterruptedException
		 */
		public void search_SearchActiveSupplierWithSupplierNameAndFareType(String searchvalue, String faretype) throws InterruptedException
		{
			searchpo.search_selectCheckboxActiveSupplier();
			searchpo.search_deselectCheckboxInactiveSupplier();
			
			int i=0;
			boolean isfirstitem = false;
			
			do {
				searchpo.search_enterSupplierName(searchvalue);
				if (faretype.contentEquals("Net"))
				{
					searchpo.search_selectCheckboxNetFareType();
				}
				else if (faretype.contentEquals("Tourop"))
				{
					searchpo.search_selectCheckboxTouropFareType();
				}
				else if (faretype.contentEquals("Nego"))
				{
					searchpo.search_selectCheckboxNegoFareType();
				}
				else if (faretype.contentEquals("Published"))
				{
					searchpo.search_selectCheckboxPublishedFareType();
				}
				
				help.btn_ClickOnSearch();
				
				if (itemlist.search_IsFirstSearchedItemDisplayedSupplierOrDistribution()) 
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
		 * Get no record text
		 * @return no record text
		 */
		public String search_GetNoRecordMsgText()
		{
			return itemlist.search_GetNoRecordMsgText();
		}
		
	
	
	//General Details section
			
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
		
		public boolean getGeneralDetailsFareTypesAndGDSData(int row, int column, int list)
		{
			return searchpo.getGeneralDetailsFareTypesAndGDSData(row, column, list);
		}
		
		public boolean getGeneralDetailsFlightTypeAndFilterNoBagFareData(int row, int column, int list)
		{
			return searchpo.getGeneralDetailsFlightTypeAndFilterNoBagFareData(row, column, list);
		}
		
		
	//EDF Import Details Section
		/**
		 * 
		 * @param row
		 * @param column
		 * @param list
		 * @return
		 */
		public boolean getEDFImportDetailsSectionData(int row, int column, int list)
		{
			return searchpo.getEDFImportDetailsSectionData(row, column, list);
		}
		
		/**
		 * 
		 * @param row
		 * @param column
		 * @param list
		 * @return
		 */
		public String getEDFImportDetailsSectionPercentageAndDaysFieldData(int row, int column, int list)
		{
			return searchpo.getEDFImportDetailsSectionPercentageAndDaysFieldData(row, column, list);
		}
		
		
	//FTP Details Section
		
		public String getFTPDetailsSectionData(int row, int column)
		{
			return searchpo.getFTPDetailsSectionData(row, column);
		}
		
		public boolean getFTPDetailsSectionData(int row, int column, int input)
		{
			return searchpo.getFTPDetailsSectionData(row, column, input);
		}
		
		public String getSelectedHourDropdownValue()
		{
			return searchpo.getSelectedHourDropdownValue();
		}
		
		public String getSelectedMinuteDropdownValue()
		{
			return searchpo.getSelectedMinuteDropdownValue();
		}
		
		public String getSelectedThresholdHoursDropdownValue()
		{
			return searchpo.getSelectedMinuteDropdownValue();
		}
		
		public String getEDFPathDetails()
		{
			return searchpo.getEDFPathDetails();
		}
		
	//User summary grid data
		/**
		 * Read details from user summary grid row and column wise
		 * @param row
		 * @param column
		 * @return	data for given row and column
		 */
		public String getSupplierGridData(int row, int column)
		{
			return searchpo.getSupplierGridData(row, column);
		}
			
}
