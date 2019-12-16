package AER.FMDP_Automation.functionalLibrary.settings.generalSetting;

import org.openqa.selenium.WebDriver;

import AER.FMDP_Automation.pageObjects.common.CommonPO;
import AER.FMDP_Automation.pageObjects.settings.generalSetting.GeneralSettingSetupPO;
import utilities.SeleniumHelpers;

public class GeneralSettingsSetupLib 
{
	WebDriver driver;
	SeleniumHelpers selenium;
	GeneralSettingSetupPO generalsettingadd;
	CommonPO help ;
	
	
	public GeneralSettingsSetupLib(WebDriver driver)
	{	 
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);
        generalsettingadd = new GeneralSettingSetupPO(driver);
        help = new CommonPO(driver);
	}
	
	
	/**
	 * Configure general settings by providing information in all the fields.
	 * Update general settings information from configured details.
	 * 
	 * @param smtpserver			SMTP server IP or Address	e.g. 172.27.150.150
	 * @param smtpusername			SMTP server username	e.g. kalpesht
	 * @param smtppassword			SMTP server password	e.g. Admin#123
	 * @param smtpport				SMTP port number	e.g. 22
	 * @param fromemail				FROM Email address	e.g. kalpesht@evolvingsols.com
	 * @param toemail				TO Email address	e.g. kalpesht@evolvingsols.com
	 * @param generatededfpath		Generated EDF physical location e.g. \\172.25.50.55\Local_Export\FilesQA
	 * @param dataretentionday		Data retention days	e.g. 5, 10, 50
	 * @param sftpkeypath			SFTP Key located path where key is located  
	 * @param confirmationmessage	Confirmation message of SFTP key upload
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
	
		
}
