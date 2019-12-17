package AER.FMDP_Automation.functionalLibrary.distribution;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import AER.FMDP_Automation.pageObjects.common.CommonPO;
import AER.FMDP_Automation.pageObjects.common.ItemListPO;
import AER.FMDP_Automation.pageObjects.distribution.DistributionRequestSearchPO;
import utilities.Constants;
import utilities.JavaHelpers;
import utilities.SeleniumHelpers;

public class DistributionRequestSearchLib 
{
	WebDriver driver;
	SeleniumHelpers selenium;
	CommonPO help;
	DistributionRequestSearchPO searchpo;
	JavaHelpers java;
	ItemListPO itemlist;
	
	
	public DistributionRequestSearchLib(WebDriver driver)
	{	 
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);
        help = new CommonPO(driver);
        java = new JavaHelpers();
        searchpo = new DistributionRequestSearchPO(driver);
        itemlist = new ItemListPO(driver);
        
	}
	
	
	
	//Search section
	
	
/*		public void search_GetLastDistributionRequest()
		{
			List<WebElement> activeColumns = driver.findElements(By.xpath("//td[text()='ACTIVE']"));
			activeColumns.get(activeColumns.size()-1).click();
		}
		*/
	
	
	
	
	
	
	
	
	
	
		/**
		 * Search User by username or userid and click.
		 * 
		 * @param searchwith				Search With Information	e.g. username, id
		 * @param searchvalue				Search With Value	e.g. UN_20181115_185704, 21
		 * @throws InterruptedException
		 */
/*		public void search_SearchDistributionRequestAndClick(String searchwith, String searchvalue) throws InterruptedException
		{
			int i=0;
			boolean isfirstitem = false;
			
			do {
				if (searchwith == "DistributionRequestname")
				{
					searchpo.search_enterDistributionRequestName(searchvalue);
					help.btn_ClickOnSearch();
					
					if (itemlist.search_IsFirstSearchedItemDisplayedDistributionRequestOrDistribution()) 
					{
						itemlist.search_ClickOnFirstSearchedItemDistributionRequestOrDistribution();
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
					searchpo.search_enterDistributionRequestID(searchvalue);
					help.btn_ClickOnSearch();
					
					if (itemlist.search_IsFirstSearchedItemDisplayedDistributionRequestOrDistribution()) 
					{
						itemlist.search_ClickOnFirstSearchedItemDistributionRequestOrDistribution();
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
				Assert.fail("FAIL : On DistributionRequest search, no search result appeared!");
			}
		}
	
		
		
		*//**
		 * Only Search user by user id without verifying the first record
		 * @param id User ID
		 *//*
		public void search_DistributionRequestWithDistributionRequestId(String id)
		{
			searchpo.search_deselectCheckboxActiveDistributionRequest();
			searchpo.search_deselectCheckboxInactiveDistributionRequest();
			searchpo.search_enterDistributionRequestName(id);
			help.btn_ClickOnSearch();
		}
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		*//**
		 * Search User by username and verify first record in grid.
		 * 
		 * @param searchvalue			Search value	e.g. UN_20181115_185704
		 * @throws InterruptedException
		 *//*
		public void search_SearchActiveDistributionRequestWithDistributionRequestNameAndFareType(String searchvalue, String faretype) throws InterruptedException
		{
			searchpo.search_selectCheckboxActiveDistributionRequest();
			searchpo.search_deselectCheckboxInactiveDistributionRequest();
			
			int i=0;
			boolean isfirstitem = false;
			
			do {
				searchpo.search_enterDistributionRequestName(searchvalue);
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
				
				if (itemlist.search_IsFirstSearchedItemDisplayedDistributionRequestOrDistribution()) 
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
				Assert.fail("FAIL : On DistributionRequest search, no search result appeared!");
			}
		}
		*/
		
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
	/*	public String getDistributionRequestGridData(int row, int column)
		{
			return searchpo.getDistributionRequestGridData(row, column);
		}
			*/
}
