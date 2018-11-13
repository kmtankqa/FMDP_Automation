package AER.FMDP_Automation.functionalLibrary.settings.mnSetting;

import org.openqa.selenium.WebDriver;

import AER.FMDP_Automation.pageObjects.common.CommonPO;
import AER.FMDP_Automation.pageObjects.settings.mnSetting.MNSettingPO;
import utilities.SeleniumHelpers;

public class MNSettingsLib 
{
	WebDriver driver;
	SeleniumHelpers selenium;
	MNSettingPO mnsettingadd;
	CommonPO help ;
	
	
	public MNSettingsLib(WebDriver driver)
	{	 
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);
        mnsettingadd = new MNSettingPO(driver);
        help = new CommonPO(driver);
	}
	
	/**
	 * Setup new tax category by providing information in all the fields.
	 * Update tax information from added tax category.
	 *  
	 * @param name			Name of tax	category	e.g. AT_Tax_20171228_143354
	 * @param status		Status of tax category	e.g. Active, Inactive
	 * @param purchase		Tax Applies to purchases	e.g. Yes, No
	 * @param sale			Tax Applies to sales	e.g. Yes, No
	 * @param service		Tax applicable to Services	e.g. Yes, No
	 * @param product		Tax applicable to Products	e.g. Yes, No
	 * @param sundry		Tax applicable to Sundries	e.g. Yes, No
	 * @param expense		Tax applicable to Expenses	e.g. Yes, No
	 * @param date			Tax effective from date		e.g. 28 Dec 2017
	 * @param ratename		Tax rate category name	e.g. AT_rate
	 * @param ratepercent	Tax rate percentage		e.g. 15.00% 
	 * 
	 */
	public void mnSetting_Add(String requestemail, String requestnooftimesattempt, String requesttimetetweenattempt, String importemail, String importnooftimesattempt, String importtimebetweenattempt, String distributionemail, String distributionnooftimesattempt, String distributiontimebetweenattempt, String checkbox_select)
	{
		mnsettingadd.enterRequestEmail(requestemail);
		mnsettingadd.enterRequestNoOfTimesAttempt(requestnooftimesattempt);
		mnsettingadd.enterRequestTimeBetweenAttempt(requesttimetetweenattempt);
		
		if (checkbox_select.contains("true"))
		{
			mnsettingadd.selectRequestNotifySuccess();
			mnsettingadd.selectRequestNotifyFailure();
		}
		else
		{
			mnsettingadd.unselectRequestNotifySuccess();
			mnsettingadd.unselectRequestNotifyFailure();
		}		
		
		mnsettingadd.enterImportEmail(importemail);
		mnsettingadd.enterImportNoOfTimesAttempt(importnooftimesattempt);
		mnsettingadd.enterImportTimeBetweenAttempt(importtimebetweenattempt);
		
		if (checkbox_select.contains("true"))
		{
			mnsettingadd.selectImportNotifySuccess();
			mnsettingadd.selectImportNotifyFailure();
		}
		else
		{
			mnsettingadd.unselectImportNotifySuccess();
			mnsettingadd.unselectImportNotifyFailure();
		}	
		
		mnsettingadd.enterDistributionEmail(distributionemail);
		mnsettingadd.enterDistributionNoOfTimesAttempt(distributionnooftimesattempt);
		mnsettingadd.enterDistributionTimeBetweenAttempt(distributiontimebetweenattempt);
		
		if (checkbox_select.contains("true"))
		{
			mnsettingadd.selectDistributionNotifySuccess();
			mnsettingadd.selectDistributionNotifyFailure();
		}
		else
		{
			mnsettingadd.unselectDistributionNotifySuccess();
			mnsettingadd.unselectDistributionNotifyFailure();
		}	
		
		help.btn_ClickOnSave();
	}
	
	


	//Search : Request section
		/**
		 * Read Request Email data
		 * @param row
		 * @return data for given row
		 */
		public String getRequestEmailData()
		{
			return mnsettingadd.getRequestEmailData();
		}
		
		/**
		 * Read Request Attempts and Wait duration data
		 * @param row
		 * @param column
		 * @return data for given row and column
		 */
		public String getRequestAttemptsAndWaitTimeData(int row, int column)
		{
			return mnsettingadd.getRequestAttemptsAndWaitTimeData(row, column);
		}
		
		/**
		 * Read Request Notify data
		 * @param checkbox_no
		 * @return data for given checkbox number
		 */
		public boolean getRequestNotifyData(int checkbox_no)
		{
			return mnsettingadd.getRequestNotifyData(checkbox_no);
		}
		
		
	//Search : Import section
		/**
		 * Read Import Email data
		 * @param row
		 * @return data for given row
		 */
		public String getImportEmailData()
		{
			return mnsettingadd.getImportEmailData();
		}
		
		/**
		 * Read Import Attempts and Wait duration data
		 * @param row
		 * @param column
		 * @return data for given row and column
		 */
		public String getImportAttemptsAndWaitTimeData(int row, int column)
		{
			return mnsettingadd.getImportAttemptsAndWaitTimeData(row, column);
		}
		
		/**
		 * Read Import Notify data
		 * @param checkbox_no
		 * @return data for given checkbox number
		 */
		public boolean getImportNotifyData(int checkbox_no)
		{
			return mnsettingadd.getRequestNotifyData(checkbox_no);
		}
		
		
	//Search : Distribution section
		/**
		 * Read Distribution Email data
		 * @param row
		 * @return data for given row
		 */
		public String getDistributionEmailData()
		{
			return mnsettingadd.getDistributionEmailData();
		}
		
		/**
		 * Read Distribution Attempts and Wait duration data
		 * @param row
		 * @param column
		 * @return data for given row and column
		 */
		public String getDistributionAttemptsAndWaitTimeData(int row, int column)
		{
			return mnsettingadd.getDistributionAttemptsAndWaitTimeData(row, column);
		}
		
		/**
		 * Read Distribution Notify data
		 * @param checkbox_no
		 * @return data for given checkbox number
		 */
		public boolean getDistributionNotifyData(int checkbox_no)
		{
			return mnsettingadd.getRequestNotifyData(checkbox_no);
		}
}






