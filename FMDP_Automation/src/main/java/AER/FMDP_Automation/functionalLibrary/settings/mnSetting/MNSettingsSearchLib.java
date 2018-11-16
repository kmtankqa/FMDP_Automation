package AER.FMDP_Automation.functionalLibrary.settings.mnSetting;

import org.openqa.selenium.WebDriver;

import AER.FMDP_Automation.pageObjects.common.CommonPO;
import AER.FMDP_Automation.pageObjects.common.ItemListPO;
import AER.FMDP_Automation.pageObjects.settings.mnSetting.MNSettingsSearchPO;
import utilities.JavaHelpers;
import utilities.SeleniumHelpers;

public class MNSettingsSearchLib 
{
	WebDriver driver;
	SeleniumHelpers selenium;
	CommonPO help;
	MNSettingsSearchPO searchpo;
	JavaHelpers java;
	ItemListPO itemlist;
	
	
	public MNSettingsSearchLib(WebDriver driver)
	{	 
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);
        help = new CommonPO(driver);
        java = new JavaHelpers();
        searchpo = new MNSettingsSearchPO(driver);
        itemlist = new ItemListPO(driver);
        
	}
	
		

		//Search : Request section
			/**
			 * Read Request Email data
			 * @param row
			 * @return data for given row
			 */
			public String getRequestEmailData()
			{
				return searchpo.getRequestEmailData();
			}
			
			/**
			 * Read Request Attempts and Wait duration data
			 * @param row
			 * @param column
			 * @return data for given row and column
			 */
			public String getRequestAttemptsAndWaitTimeData(int row, int column)
			{
				return searchpo.getRequestAttemptsAndWaitTimeData(row, column);
			}
			
			/**
			 * Read Request Notify data
			 * @param checkbox
			 * @return data for given checkbox number
			 */
			public boolean getRequestNotifyData(int checkbox)
			{
				return searchpo.getRequestNotifyData(checkbox);
			}
			
			
		//Search : Import section
			/**
			 * Read Import Email data
			 * @param row
			 * @return data for given row
			 */
			public String getImportEmailData()
			{
				return searchpo.getImportEmailData();
			}
			
			/**
			 * Read Import Attempts and Wait duration data
			 * @param row
			 * @param column
			 * @return data for given row and column
			 */
			public String getImportAttemptsAndWaitTimeData(int row, int column)
			{
				return searchpo.getImportAttemptsAndWaitTimeData(row, column);
			}
			
			/**
			 * Read Import Notify data
			 * @param checkbox
			 * @return data for given checkbox number
			 */
			public boolean getImportNotifyData(int checkbox)
			{
				return searchpo.getRequestNotifyData(checkbox);
			}
			
			
		//Search : Distribution section
			/**
			 * Read Distribution Email data
			 * @param row
			 * @return data for given row
			 */
			public String getDistributionEmailData()
			{
				return searchpo.getDistributionEmailData();
			}
			
			/**
			 * Read Distribution Attempts and Wait duration data
			 * @param row
			 * @param column
			 * @return data for given row and column
			 */
			public String getDistributionAttemptsAndWaitTimeData(int row, int column)
			{
				return searchpo.getDistributionAttemptsAndWaitTimeData(row, column);
			}
			
			/**
			 * Read Distribution Notify data
			 * @param checkbox
			 * @return data for given checkbox number
			 */
			public boolean getDistributionNotifyData(int checkbox)
			{
				return searchpo.getRequestNotifyData(checkbox);
			}
			
			
}
