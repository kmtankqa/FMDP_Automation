package AER.FMDP_Automation.pageObjects.supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import AER.FMDP_Automation.pageObjects.common.CommonPO;
import utilities.Constants;
import utilities.JavaHelpers;
import utilities.SeleniumHelpers; 

public class SupplierSetupPO 
{
	WebDriver driver;
	SeleniumHelpers selenium;
	CommonPO help;
	JavaHelpers java;
	
	public SupplierSetupPO(WebDriver driver)
	{	 
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);
        help = new CommonPO(driver);
        java = new JavaHelpers();

        //This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, Constants.PAGEFACTORY_WAIT_DURATION), this);
	}
	
	
	/*
	 * All WebElements are identified by @FindBy annotation
	 * @FindBy can accept tagName, partialLinkText, name, linkText, id, css, className, xpath as attributes.
	 */ 	
	
	//Recipient Summary Page :
	
		@FindBy(css=".user-options2 > input[value='Create New Supplier']")
		private WebElement createNewSupplier;
		
		@FindBy(css=".user-options2 > input[value='Copy From Existing']")
		private WebElement copyFromExisting;
		
		@FindBy(css="#griddata table tr:nth-of-type(2) td:nth-of-type(1)")
		private WebElement selectFirstSupplierRadio;
		
		@FindBy(id="btnCopyFromExisting")
		private WebElement copyExistingSupplier;
		
		
	//Supplier Details Page :
		
	//General Details section
		@FindBy(id="txtSource")
		private WebElement supplierName;
		
		@FindBy(id="rdblstFareTypes_0")
		private WebElement fareTypeNet;
		
		@FindBy(id="rdblstFareTypes_1")
		private WebElement fareTypeTourop;	
		
		@FindBy(id="rdblstFareTypes_2")
		private WebElement fareTypeNego;
		
		@FindBy(id="rdblstFareTypes_3")
		private WebElement fareTypePublished;
		
		@FindBy(id="chkBoxIsFilterInToFare")
		private WebElement checkboxFilterTOFares;
		
		@FindBy(id="txtOfficeIdCorporateCode")
		private WebElement source;
		
		@FindBy(id="txtOfficeId")
		private WebElement officeId;
		
		@FindBy(id="MainContent_txtCorporateCode")
		private WebElement corporateCode;
		
		@FindBy(id="rdblstGDS_0")
		private WebElement nonGDS;
		
		@FindBy(id="rdblstGDS_1")
		private WebElement amadeusGDS;
		
		@FindBy(id="rdblstGDS_2")
		private WebElement galileoGDS;
		
		@FindBy(id="rdblstGDS_3")
		private WebElement sabreGDS;
		
		@FindBy(id="rdblstGDS_4")
		private WebElement worldspanGDS;
		
		@FindBy(id="rdbtnOneWay")
		private WebElement oneway;
		
		@FindBy(id="rdbtnRoundTrip")
		private WebElement roundtrip;
		
		@FindBy(id="chkBoxIsFilterOutNoBagFares")
		private WebElement checkboxFilterNobagFares;
		
		
	//EDF Import Details section
		@FindBy(id="chkBoxImportDetails")
		private WebElement checkboxEDFImportDetails;
		
		@FindBy(id="rdbtnHourly")
		private WebElement hourlyFrequency;
		
		@FindBy(id="rdbtnDaily")
		private WebElement dailyFrequency;
		
		@FindBy(id="chkBoxDeleteFile")
		private WebElement checkboxDeleteFile;
		
		@FindBy(id="chkBoxFileSizeVariesBy")
		private WebElement checkboxFileSizeVaries;
		
		@FindBy(id="chkBoxFileNotReceived")
		private WebElement checkboxFileNotReceived;
		
		@FindBy(id="txtPercentage")
		private WebElement filesizepercentage;
		
		@FindBy(id="txtDays")
		private WebElement filenotreceiveddays;
		
		@FindBy(id="txtRetentionDays")
		private WebElement dataretention;
		
		@FindBy(id="ddlImportHrs")
		private WebElement importhours;
		
		@FindBy(id="ddlImportMin")
		private WebElement importminutes;
		
		@FindBy(id="ddlThresholdHours")
		private WebElement thresholdhours;
		
		
	//FTP Details section
		@FindBy(id="rdblstDownloadProtocol_0")
		private WebElement ftpRadio;
		
		@FindBy(id="rdblstDownloadProtocol_1")
		private WebElement sftpRadio;
		
		@FindBy(id="rdblstDownloadProtocol_2")
		private WebElement httpRadio;
		
		@FindBy(id="txtImportDetailsFTPServerName")
		private WebElement ftpServerName;
		
		@FindBy(id="chkBoxImportDetailsSSL")
		private WebElement sslEncryption;
		
		@FindBy(id="chkBoxImportDetailsPassive")
		private WebElement passiveMode;
		
		@FindBy(id="txtImportDetailsUserName")
		private WebElement ftpUserName;
		
		@FindBy(id="txtImportDetailsPassword")
		private WebElement ftpPassword;
		
		@FindBy(id="chkboxisKeyAuthenticationRequired")
		private WebElement keyAuthentication;

		@FindBy(id="btnTestFTPConnection")
		private WebElement testFtpConnectionBtn;
		
		@FindBy(id="txtHttpUrl")
		private WebElement httpUrl;
		
		@FindBy(id="txtFilePattern")
		private WebElement filePattern;
		
		@FindBy(id="txtImportTargetLocation")
		private WebElement fileLocation;

	//User summary grid
		@FindBy(css=".supplierGridHeight:nth-of-type(2) > td input[src='../Images/icon-active.png']")
		public WebElement active;
		
		@FindBy(css=".supplierGridHeight:nth-of-type(2) > td input[src='../Images/icon-inactive.png']")
		public WebElement inactive;
			
		@FindBy(css=".supplierGridHeight:nth-of-type(2) > td input[src='../Images/icon-delete.png']")
		public WebElement delete;
		
	
		
	// Supplier - Summary :
	
		public void clickOnCreateNewSupplierBtn()
		{
			createNewSupplier.click();
		}
		
		public void clickOnCopyFromExistingBtn()
		{
			copyFromExisting.click();
		}
		
		public void setSupplierStatus(String statusvalue)
		{		
			help.setToggleStaus(active, inactive, statusvalue);
		}
		
		public void deleteSupplierRecord()
		{
			delete.click();
		}
		
		public void selectSupplierRecordRadio()
		{
			if(!selectFirstSupplierRadio.isSelected())
			{
				selectFirstSupplierRadio.click();
			}
		}
	
		
	// Supplier Details :
				
		public void enterSupplierName(String suppliername)
		{
			supplierName.clear();
			supplierName.sendKeys(suppliername);
		}
		
		public void selectNetFareType()
		{
			if (!fareTypeNet.isSelected())
			{
				fareTypeNet.click();
			}
		}
		
		public void selectTouropFareType()
		{
			if (!fareTypeTourop.isSelected())
			{
				fareTypeTourop.click();
			}
		}
		
		public void selectNegoFareType()
		{
			if (!fareTypeNego.isSelected())
			{
				fareTypeNego.click();
			}
		}
		
		public void selectPublishedFareType()
		{
			if (!fareTypePublished.isSelected())
			{
				fareTypePublished.click();
			}
		}
		
		public void selectFilterTOFares()
		{
			if (!checkboxFilterTOFares.isSelected())
			{
				checkboxFilterTOFares.click();
			}
		}
		
		public void enterSource(String sourcevalue)
		{
			source.clear();
			source.sendKeys(sourcevalue);
		}
		
		public void enterOfficeID(String officeidvalue)
		{
			officeId.clear();
			officeId.sendKeys(officeidvalue);
		}
		
		public void enterCorporateCode(String corporatecodevalue)
		{
			corporateCode.clear();
			corporateCode.sendKeys(corporatecodevalue);
		}
		
		public void selectNonGDS()
		{
			if (!nonGDS.isSelected())
			{
				nonGDS.click();
			}
		}
		
		public void selectAmadeusGDS()
		{
			if (!amadeusGDS.isSelected())
			{
				amadeusGDS.click();
			}
		}
		
		public void selectGalileoGDS()
		{
			if (!galileoGDS.isSelected())
			{
				galileoGDS.click();
			}
		}
		
		public void selectSabreGDS()
		{
			if (!sabreGDS.isSelected())
			{
				sabreGDS.click();
			}
		}
		
		public void selectWorldspanGDS()
		{
			if (!worldspanGDS.isSelected())
			{
				worldspanGDS.click();
			}
		}
		
		public void selectOnewayFlight()
		{
			if (!oneway.isSelected())
			{
				oneway.click();
			}
		}
		
		public void selectRoundtripFlight()
		{
			if (!roundtrip.isSelected())
			{
				roundtrip.click();
			}
		}
		
		public void selectFilterNoBagFares()
		{
			if (!checkboxFilterNobagFares.isSelected())
			{
				checkboxFilterNobagFares.click();
			}
		}
		
		public void selectEDFImportDetails()
		{
			if (!checkboxEDFImportDetails.isSelected())
			{
				checkboxEDFImportDetails.click();
			}
		}
		
		public void selectHourlyFrequency()
		{
			if (!hourlyFrequency.isSelected())
			{
				hourlyFrequency.click();
			}
		}
		
		public void selectDailyFrequency()
		{
			if (!dailyFrequency.isSelected())
			{
				dailyFrequency.click();
			}
		}
		
		public void selectDeleteFileFromFTP()
		{
			if (!checkboxDeleteFile.isSelected())
			{
				checkboxDeleteFile.click();
			}
		}
		
		public void selectNotifyFileSizeVaries()
		{
			if (!checkboxFileSizeVaries.isSelected())
			{
				checkboxFileSizeVaries.click();
			}
		}
		
		public void enterFileSizeVariesPercentage(String varyfilesize)
		{
			filesizepercentage.clear();
			filesizepercentage.sendKeys(varyfilesize);
		}
		
		public void selectNotifyFileNotReceived()
		{
			if (!checkboxFileNotReceived.isSelected())
			{
				checkboxFileNotReceived.click();
			}
		}
		
		public void enterFileNotReceivedDays(String filenotreceivedday)
		{
			filenotreceiveddays.clear();
			filenotreceiveddays.sendKeys(filenotreceivedday);
		}
		
		public void enterDataRetention(String dataretentionvalue)
		{
			dataretention.clear();
			dataretention.sendKeys(dataretentionvalue);
		}
		
		public void selectEveryHourly(String hours)
		{
			selenium.selectDropdownValueByText(importhours, hours);
		}
		
		public void selectEveryMinute(String minutes)
		{
			selenium.selectDropdownValueByText(importminutes, minutes);
		}
		
		public void selectRetainOldDataUpto(String thresoldhours)
		{
			selenium.selectDropdownValueByText(thresholdhours, thresoldhours);
		}

		public void selectFtpRadio()
		{
			ftpRadio.click();
		}
		
		public void selectSftpRadio()
		{
			sftpRadio.click();
		}
		
		public void selectHttpRadio()
		{
			httpRadio.click();
		}
		
		public void enterFtpServerName(String ftpservername)
		{
			ftpServerName.clear();
			ftpServerName.sendKeys(ftpservername);
		}
		
		public void selectSslEncryption()
		{
			sslEncryption.click();
		}
		
		public void selectPassiveMode()
		{
			passiveMode.click();
		}
		
		public void enterFtpUserName(String ftpusername)
		{
			ftpUserName.clear();
			ftpUserName.sendKeys(ftpusername);
		}
		
		public void enterFtpPassword(String ftppassword)
		{
			ftpPassword.clear();
			ftpPassword.sendKeys(ftppassword);
		}
		
		public void selectKeyAuthentication()
		{
			keyAuthentication.click();
		}
		
		public void enterHttpUrl(String httpurlvalue)
		{
			httpUrl.clear();
			httpUrl.sendKeys(httpurlvalue);
		}
		
		public void clickOnTestFTPConnection()
		{
			testFtpConnectionBtn.click();
		}
		
		public void enterFilePattern(String filepatternvalue)
		{
			filePattern.clear();
			filePattern.sendKeys(filepatternvalue);
		}
		
		public void enterFileLocation(String filelocationvalue)
		{
			fileLocation.clear();
			fileLocation.sendKeys(filelocationvalue);
		}
	
		
}
