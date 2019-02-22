package AER.FMDP_Automation.functionalLibrary.recipient;

import org.openqa.selenium.WebDriver;

import AER.FMDP_Automation.pageObjects.common.CommonPO;
import AER.FMDP_Automation.pageObjects.recipient.RecipientSetupPO;
import utilities.SeleniumHelpers;

public class RecipientSetupLib 
{
	WebDriver driver;
	SeleniumHelpers selenium;
	RecipientSetupPO recipientmanagementadd;
	CommonPO help ;
	
	
	public RecipientSetupLib(WebDriver driver)
	{	 
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);
        recipientmanagementadd = new RecipientSetupPO(driver);
        help = new CommonPO(driver);
	}
	
	
	/**
	 * Setup new Recipient record by providing information in all the fields.
	 * Update Recipient information from added Recipient record.
	 * 
	 * @param firstname				First Name of Recipient	e.g. FMDP, John
	 * @param lastname				Last Name of Recipient	e.g. Automation, Carter
	 * @param contactno				Contact Number of Recipient	e.g. 6136994792
	 * @param emailid				Email Id of Recipient	e.g. Email_20181120_195254@dayrep.com
	 * @param Recipientname				Recipientname of Recipient	e.g. Recipient_20181120_195254
	 * @param passwordvalue			Password of given Recipientname	e.g. passw0rd
	 * @param confirmpassword		Confirm password	e.g. passw0rd
	 * @param descriptionvalue		Description of Recipient	e.g. This is automated description for new Recipient creation
	 * @param featureaccess			Feature access information	e.g. true or false
	 * @throws InterruptedException
	 */
	public void recipientManagement_Add(String recipientname, String priority, String contactno, String email, String address1, String address2, String city, String country, String state, String filename,
										String ismergelongsell, String includeFareInLongsell, String ftptype, String ftpservername, String ftpusername, String ftppassword) throws InterruptedException
	{
		recipientmanagementadd.enterRecipientName(recipientname);
		recipientmanagementadd.selectPriority(priority);
		recipientmanagementadd.enterContactNumber(contactno);
		recipientmanagementadd.enterEmailId(email);
		recipientmanagementadd.enterAddress1(address1);
		recipientmanagementadd.enterAddress2(address2);
		recipientmanagementadd.enterCity(city);
		recipientmanagementadd.enterCountry(country);
		recipientmanagementadd.enterState(state);
		
		if (ismergelongsell.contains("true"))
		{
			recipientmanagementadd.selectMergeLongsell();
			recipientmanagementadd.enterFileName(filename);
			recipientmanagementadd.selectRemovePrefix();
		}
		else
		{
			recipientmanagementadd.deselectMergeLongsell();
		}
		
		if (includeFareInLongsell.contains("true"))
		{
			recipientmanagementadd.selectCHDFare();
			recipientmanagementadd.selectINFFare();
		}
		else
		{
			recipientmanagementadd.deselectCHDFare();
			recipientmanagementadd.deselectINFFare();
		}
		
		if (ftptype == "ftp")
		{
			setFtpDetailsAndTestConnection(ftpservername, ftpusername, ftppassword);
		}
		else
		{
			setSftpDetailsAndTestConnection(ftpservername, ftpusername, ftppassword);
		}
		
		help.btn_ClickOnSave();
	}

	
	/**
	 * 
	 * @param ftpservername
	 * @param ftpusername
	 * @param ftppassword
	 */
	public void setFtpDetailsAndTestConnection(String ftpservername, String ftpusername, String ftppassword)
	{
		recipientmanagementadd.selectFtpRadio();
		recipientmanagementadd.enterFtpServerName(ftpservername);
		recipientmanagementadd.selectSslEncryption();
		recipientmanagementadd.selectPassiveMode();
		recipientmanagementadd.enterFtpUserName(ftpusername);
		recipientmanagementadd.enterFtpPassword(ftppassword);
	}
	
	
	/**
	 * 
	 * @param ftpservername
	 * @param ftpusername
	 * @param ftppassword
	 */
	public void setSftpDetailsAndTestConnection(String ftpservername, String ftpusername, String ftppassword)
	{
		recipientmanagementadd.selectSftpRadio();
		recipientmanagementadd.enterFtpServerName(ftpservername);
		recipientmanagementadd.enterFtpUserName(ftpusername);
		recipientmanagementadd.enterFtpPassword(ftppassword);
	}
	
	
	/**
	 * Click on Create New Recipient button to add new Recipient record.
	 */
	public void clickOnCreateNewRecipientBtn()
	{
		recipientmanagementadd.clickOnCreateNewRecipientBtn();
	}
		
	
	/**
	 * Set Recipient's status
	 * @param statusvalue	status value of supplier i.e. Active or Inactive
	 * 
	 */
	public void recipient_changeStatus(String statusvalue)
	{
		recipientmanagementadd.setRecipientStatus(statusvalue);
	}
	
	
	/**
	 * Delete Active or Inactive Recipient record.
	 */
	public void recipient_deleteRecord()
	{
		recipientmanagementadd.deleteRecipientRecord();
		help.popup_ClickOnConfirmationYes();
	}
	
	
}
