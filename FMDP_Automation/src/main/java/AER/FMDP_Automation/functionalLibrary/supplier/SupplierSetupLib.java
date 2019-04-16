package AER.FMDP_Automation.functionalLibrary.supplier;

import org.openqa.selenium.WebDriver;

import AER.FMDP_Automation.pageObjects.common.CommonPO;
import AER.FMDP_Automation.pageObjects.supplier.SupplierSetupPO;
import utilities.SeleniumHelpers;

public class SupplierSetupLib 
{
	WebDriver driver;
	SeleniumHelpers selenium;
	SupplierSetupPO suppliermanagementadd;
	CommonPO help ;
	
	
	public SupplierSetupLib(WebDriver driver)
	{	 
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);
        suppliermanagementadd = new SupplierSetupPO(driver);
        help = new CommonPO(driver);
	}
	


	public void supplierManagement_GeneraDetails_Add(String suppliername, String faretype, String source, String officeid, String corporatecode, String gdstype, String flighttype) throws InterruptedException
	{
		suppliermanagementadd.enterSupplierName(suppliername);
		
		if (faretype.contentEquals("Tourop"))
		{
			suppliermanagementadd.selectTouropFareType();
			suppliermanagementadd.selectFilterTOFares();
		} else if (faretype.contentEquals("Net"))
		{
			suppliermanagementadd.selectNetFareType();
		} else if (faretype.contentEquals("Nego"))
		{
			suppliermanagementadd.selectNegoFareType();
		} else
		{
			suppliermanagementadd.selectPublishedFareType();
		}
		
		suppliermanagementadd.enterSource(source);
		suppliermanagementadd.enterOfficeID(officeid);
		suppliermanagementadd.enterCorporateCode(corporatecode);
		
		if (gdstype.contentEquals("Non_GDS"))
		{
			suppliermanagementadd.selectNonGDS();
			suppliermanagementadd.selectFilterNoBagFares();
		} else if (gdstype.contentEquals("Amadeus"))
		{
			suppliermanagementadd.selectAmadeusGDS();
		} else if (gdstype.contentEquals("Galileo"))
		{
			suppliermanagementadd.selectGalileoGDS();
			suppliermanagementadd.selectFilterNoBagFares();
		} else if (gdstype.contentEquals("Sabre"))
		{
			suppliermanagementadd.selectSabreGDS();
			suppliermanagementadd.selectFilterNoBagFares();
		} else
		{
			suppliermanagementadd.selectWorldspanGDS();
			suppliermanagementadd.selectFilterNoBagFares();
		}
		
		if (flighttype.contentEquals("One Way"))
		{
			suppliermanagementadd.selectOnewayFlight();
		} else
		{
			suppliermanagementadd.selectRoundtripFlight();
		}
		
	}
	
	public void supplierManagement_EDFImportDetails_Add(String frequencytype, String sizevarypercentage, String filenotreceiveddays, String hour, String minutes, String thresoldhour, String dataretention) throws InterruptedException
	{
		suppliermanagementadd.selectEDFImportDetails();
		
		if (frequencytype.contentEquals("Hourly"))
		{
			suppliermanagementadd.selectHourlyFrequency();
			suppliermanagementadd.selectEveryHourly(hour);
			suppliermanagementadd.selectRetainOldDataUpto(thresoldhour);	
		}
		else
		{
			suppliermanagementadd.selectDailyFrequency();
			suppliermanagementadd.selectEveryHourly(hour);
			suppliermanagementadd.selectEveryMinute(minutes);
		}
		
		suppliermanagementadd.selectDeleteFileFromFTP();
		suppliermanagementadd.selectNotifyFileSizeVaries();
		suppliermanagementadd.enterFileSizeVariesPercentage(sizevarypercentage);
		suppliermanagementadd.selectNotifyFileNotReceived();
		suppliermanagementadd.enterFileNotReceivedDays(filenotreceiveddays);
		suppliermanagementadd.enterDataRetention(dataretention);
		
	}
		
	public void supplierManagement_FTPAndEDFPathDetails_Add(String ftptype, String ftpservername, String ftpusername, String ftppassword, String filepattern, String filelocation) throws InterruptedException
	{	
		
		if (ftptype.contentEquals("ftp"))
		{
			setFtpDetailsAndTestConnection(ftpservername, ftpusername, ftppassword);
		}
		else
		{
			setSftpDetailsAndTestConnection(ftpservername, ftpusername, ftppassword);
		}
		
		suppliermanagementadd.enterFilePattern(filepattern);
		suppliermanagementadd.enterFileLocation(filelocation);
		
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
		suppliermanagementadd.selectFtpRadio();
		suppliermanagementadd.enterFtpServerName(ftpservername);
		suppliermanagementadd.selectSslEncryption();
		suppliermanagementadd.selectPassiveMode();
		suppliermanagementadd.enterFtpUserName(ftpusername);
		suppliermanagementadd.enterFtpPassword(ftppassword);
	}
	
	
	/**
	 * 
	 * @param ftpservername
	 * @param ftpusername
	 * @param ftppassword
	 */
	public void setSftpDetailsAndTestConnection(String ftpservername, String ftpusername, String ftppassword)
	{
		suppliermanagementadd.selectSftpRadio();
		suppliermanagementadd.enterFtpServerName(ftpservername);
		suppliermanagementadd.enterFtpUserName(ftpusername);
		suppliermanagementadd.enterFtpPassword(ftppassword);
	}
	
	
	/**
	 * Click on Create New Recipient button to add new Recipient record.
	 */
	public void clickOnCreateNewSupplierBtn()
	{
		suppliermanagementadd.clickOnCreateNewSupplierBtn();
	}
		
	
	/**
	 * Set Recipient's status
	 * @param statusvalue	status value of supplier i.e. Active or Inactive
	 * 
	 */
	public void supplier_changeStatus(String statusvalue)
	{
		suppliermanagementadd.setSupplierStatus(statusvalue);
	}
	
	
	/**
	 * Delete Active or Inactive Recipient record.
	 */
	public void supplier_deleteRecord()
	{
		suppliermanagementadd.deleteSupplierRecord();
		help.popup_ClickOnConfirmationYes();
	}
	
	
}
