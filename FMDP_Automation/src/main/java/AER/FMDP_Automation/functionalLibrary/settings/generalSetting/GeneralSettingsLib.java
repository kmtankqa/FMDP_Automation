package AER.FMDP_Automation.functionalLibrary.settings.generalSetting;

import org.openqa.selenium.WebDriver;

import AER.FMDP_Automation.pageObjects.common.CommonPO;
import AER.FMDP_Automation.pageObjects.settings.generalSetting.GeneralSettingPO;
import utilities.SeleniumHelpers;

public class GeneralSettingsLib 
{
	WebDriver driver;
	SeleniumHelpers selenium;
	GeneralSettingPO generalsettingadd;
	CommonPO help ;
	
	
	public GeneralSettingsLib(WebDriver driver)
	{	 
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);
        generalsettingadd = new GeneralSettingPO(driver);
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
	public void generalSetting_Add(String smtpserver, String smtpusername, String smtppassword, String smtpport, String fromemail, String toemail, String generatededfpath, String dataretentionday, String sftpkeypath, String confirmationmessage)
	{
		generalsettingadd.enterSmtpServer(smtpserver);
		generalsettingadd.enterSmtpUsername(smtpusername);
		generalsettingadd.enterSmtpPassword(smtppassword);
		generalsettingadd.enterSmtpPort(smtpport);
		generalsettingadd.enterFromEmail(fromemail);
		generalsettingadd.enterToEmail(toemail);
		generalsettingadd.enterGeneratedEdfPath(generatededfpath);
		generalsettingadd.enterDataRetentionDays(dataretentionday);
		generalsettingadd.uploadSftpKey(sftpkeypath, confirmationmessage);
		help.btn_ClickOnSave();
	}
	
	

	//Search : SMTP Configuration section
		/**
		 * Read SMTP Configuration section data row wise including labels
		 * @param row
		 * @return data for given row
		 */
		public String getSmtpConfigurationSectionData(int row)
		{
			return generalsettingadd.getSmtpConfigurationSectionData(row);
		}
		
	//Search : General Details section
		/**
		 * Read General Details section data row wise including labels
		 * @param row
		 * @return data for given row
		 */
		public String getGeneralDetailsSectionData(int row)
		{
			return generalsettingadd.getGeneralDetailsSectionData(row);
		}
		
		
}
