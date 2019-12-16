package AER.FMDP_Automation.functionalLibrary.settings.mnSetting;

import org.openqa.selenium.WebDriver;

import AER.FMDP_Automation.pageObjects.common.CommonPO;
import AER.FMDP_Automation.pageObjects.settings.mnSetting.MNSettingsSetupPO;
import utilities.SeleniumHelpers;

public class MNSettingsSetupLib 
{
	WebDriver driver;
	SeleniumHelpers selenium;
	MNSettingsSetupPO mnsettingadd;
	CommonPO help ;
	
	
	public MNSettingsSetupLib(WebDriver driver)
	{	 
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);
        mnsettingadd = new MNSettingsSetupPO(driver);
        help = new CommonPO(driver);
	}
	
	
	/**
	 * Configure Monitoring & Notification settings by providing information in all the fields.
	 * Update Monitoring & Notification settings information from configured details.
	 * 
	 * @param requestemail						Email ID of Request notification	e.g kalpesht@dayrep.com
	 * @param requestnooftimesattempt			No of Attempts on Request failure	e.g. 3, 5, 9
	 * @param requesttimetetweenattempt			Wait time between Attempts	e.g. 5, 15, 30
	 * @param importemail						Email ID of Import notification	e.g kalpesht@dayrep.com
	 * @param importnooftimesattempt			No of Attempts on Import failure	e.g. 3, 5, 9
	 * @param importtimebetweenattempt			Wait time between Attempts	e.g. 5, 15, 30
	 * @param distributionemail					Email ID of Distribution notification	e.g kalpesht@dayrep.com
	 * @param distributionnooftimesattempt		No of Attempts on Distribution failure	e.g. 3, 5, 9
	 * @param distributiontimebetweenattempt	Wait time between Attempts	e.g. 5, 15, 30
	 * @param notify							Notify check-box	e.g. Success, Failure					
	 */
	public void mnSetting_Add(String requestemail, String requestnooftimesattempt, String requesttimetetweenattempt, String importemail, String importnooftimesattempt, String importtimebetweenattempt, String distributionemail, String distributionnooftimesattempt, String distributiontimebetweenattempt, String notify)
	{
		mnsettingadd.enterRequestEmail(requestemail);
		mnsettingadd.enterRequestNoOfTimesAttempt(requestnooftimesattempt);
		mnsettingadd.enterRequestTimeBetweenAttempt(requesttimetetweenattempt);
		
		if (notify.contains("true"))
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
		
		if (notify.contains("true"))
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
		
		if (notify.contains("true"))
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
	
}






