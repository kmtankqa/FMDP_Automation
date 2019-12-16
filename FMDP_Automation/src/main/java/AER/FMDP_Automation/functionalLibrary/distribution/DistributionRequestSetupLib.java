package AER.FMDP_Automation.functionalLibrary.distribution;

import org.openqa.selenium.WebDriver;

import AER.FMDP_Automation.pageObjects.common.CommonPO;
import AER.FMDP_Automation.pageObjects.distribution.DistributionRequestSetupPO;
import utilities.SeleniumHelpers;

public class DistributionRequestSetupLib 
{
	WebDriver driver;
	SeleniumHelpers selenium;
	DistributionRequestSetupPO distributionrequestadd;
	CommonPO help ;
	
	
	public DistributionRequestSetupLib(WebDriver driver)
	{	 
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);
        distributionrequestadd = new DistributionRequestSetupPO(driver);
        help = new CommonPO(driver);
	}
	


	public void distributionRequest_GeneraDetails_Add(int recipientindex, int executehourindex, int executeminuteindex, String exportformat, String flighttype, String usedataimportedhour, String filename, String faretype, String source, String officeid, String corporatecode) throws InterruptedException
	{
		distributionrequestadd.selectRecipientName(recipientindex);
		distributionrequestadd.selectExecutedOnHour(executehourindex);
		distributionrequestadd.selectExecutedOnMinute(executeminuteindex);
		
		if (exportformat.contentEquals("EDF"))
		{
			distributionrequestadd.selectEDFExportFormat();
		} else
		{
			distributionrequestadd.selectLongsellExportFormat();
		}
		
		if (flighttype.contentEquals("One Way"))
		{
			distributionrequestadd.selectOnewayFlightType();
		} else
		{
			distributionrequestadd.selectRoundtripFlightType();
		}
		
		distributionrequestadd.enterUseDataImportedInLast(usedataimportedhour);
		distributionrequestadd.enterFileName(filename);
				
		if (faretype.contentEquals("Tourop"))
		{
			distributionrequestadd.selectTouropFareType();
		} else if (faretype.contentEquals("Net"))
		{
			distributionrequestadd.selectNetFareType();
		} else if (faretype.contentEquals("Nego"))
		{
			distributionrequestadd.selectNegoFareType();
		} else
		{
			distributionrequestadd.selectPublishedFareType();
		}
		
		distributionrequestadd.enterSource(source);
		distributionrequestadd.enterOfficeID(officeid);
		distributionrequestadd.enterCorporateCode(corporatecode);
		
	}
	
	public void distributionRequest_FlightDetails_Add(String airline, String airlineexclude, String maxfare, String minfare, String maxlayover, String minlayover, String exportformat, String flighttype) throws InterruptedException
	{
		distributionrequestadd.enterAirlines(airline);
		if (airlineexclude.contentEquals("true"))
		{
			distributionrequestadd.selectAirlineExclude();
		}
		
		distributionrequestadd.enterMaximumFare(maxfare);
		distributionrequestadd.enterMinimumFare(minfare);
		distributionrequestadd.enterMaximumLayover(maxlayover);
		distributionrequestadd.enterMinimumLayover(minlayover);
		
		if (exportformat.contentEquals("EDF") && flighttype.contentEquals("Round Trip"))
		{
			distributionrequestadd.selectUseADTFareForCHDAndINF();
		}
		
	}
		
	public void distributionRequest_FTPAndEDFPathDetails_Add(String ftptype, String ftpservername, String ftpusername, String ftppassword) throws InterruptedException
	{	
		
		if (ftptype.contentEquals("ftp"))
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
		distributionrequestadd.selectFtpRadio();
		distributionrequestadd.enterFtpServerName(ftpservername);
		distributionrequestadd.selectSslEncryption();
		distributionrequestadd.selectPassiveMode();
		distributionrequestadd.enterFtpUserName(ftpusername);
		distributionrequestadd.enterFtpPassword(ftppassword);
	}
	
	
	/**
	 * 
	 * @param ftpservername
	 * @param ftpusername
	 * @param ftppassword
	 */
	public void setSftpDetailsAndTestConnection(String ftpservername, String ftpusername, String ftppassword)
	{
		distributionrequestadd.selectSftpRadio();
		distributionrequestadd.enterFtpServerName(ftpservername);
		distributionrequestadd.enterFtpUserName(ftpusername);
		distributionrequestadd.enterFtpPassword(ftppassword);
	}
	
	
	/**
	 * Click on Create New Recipient button to add new Recipient record.
	 */
	public void clickOnCreateNewDistributionRequestBtn()
	{
		distributionrequestadd.clickOnCreateNewDistributionRequestBtn();
	}
		
	
	/**
	 * Set Recipient's status
	 * @param statusvalue	status value of supplier i.e. Active or Inactive
	 * 
	 */
	public void distributionRequest_changeStatus(String statusvalue)
	{
		distributionrequestadd.setDistributionRequestStatus(statusvalue);
	}
	
	
	/**
	 * Delete Active or Inactive Recipient record.
	 */
	public void distributionRequest_deleteRecord()
	{
		distributionrequestadd.deleteDistributionRequestRecord();
		help.popup_ClickOnConfirmationYes();
	}
	
	
	public void distributionRequest_copyRecord()
	{
		distributionrequestadd.selectDistributionRequestRecordRadio();
		distributionrequestadd.clickOnCopyFromExistingBtn();
	}
	
	
}
