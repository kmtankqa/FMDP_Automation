package AER.FMDP_Automation.pageObjects.distribution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import AER.FMDP_Automation.pageObjects.common.CommonPO;
import utilities.Constants;
import utilities.JavaHelpers;
import utilities.SeleniumHelpers; 

public class DistributionRequestSetupPO 
{
	WebDriver driver;
	SeleniumHelpers selenium;
	CommonPO help;
	JavaHelpers java;
	
	public DistributionRequestSetupPO(WebDriver driver)
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
	
	//Distribution Request - Summary Page :
	
		@FindBy(css=".user-options2 > input[value='Create New Distribution Request']")
		private WebElement createNewDistributionRequest;
		
		@FindBy(css=".user-options2 > input[value='Copy From Existing']")
		private WebElement copyFromExisting;
		
		@FindBy(css="#griddata table tr:nth-of-type(2) td:nth-of-type(1)")
		private WebElement selectFirstDistributionRequestRadio;
		
		
	//Distribution Request Details Page :
		
	//General Details section
		@FindBy(id="ddlRecepients")
		private WebElement recipient;
		
		@FindBy(id="ddlRequestHrs")
		private WebElement executionOnHour;
		
		@FindBy(id="ddlRequestMins")
		private WebElement executionOnMinute;	
		
		@FindBy(id="chkExportFormat_0")
		private WebElement exportFormatEDF;
		
		@FindBy(id="chkExportFormat_1")
		private WebElement exportFormatLongsell;
		
		@FindBy(id="rdbtnFlightType_0")
		private WebElement oneWayFlightType;
		
		@FindBy(id="rdbtnFlightType_1")
		private WebElement roundTripFlightType;
		
		@FindBy(id="txtImportedInLast")
		private WebElement useDataImportedInLast;
		
		@FindBy(id="MainContent_txtfileName")
		private WebElement fileName;
		
		@FindBy(id="chkExcludeSuffix")
		private WebElement excludeSuffix;
		
		@FindBy(id="rdblstFareTypes_0")
		private WebElement netFareType;
		
		@FindBy(id="rdblstFareTypes_1")
		private WebElement touropFareType;
		
		@FindBy(id="rdblstFareTypes_2")
		private WebElement negoFareType;
		
		@FindBy(id="rdblstFareTypes_3")
		private WebElement publishedFareType;
		
		@FindBy(id="txtSource")
		private WebElement source;
		
		@FindBy(id="txtOfficeId")
		private WebElement officeId;
		
		@FindBy(id="txtCorporateCode")
		private WebElement corporateCode;
	
	//Flight Details section
		@FindBy(id="txtAirlines")
		private WebElement airlines;
		
		@FindBy(id="chkAirlineExclude")
		private WebElement airlineExclude;
		
		@FindBy(id="txtFareMax")
		private WebElement maximumFare;
		
		@FindBy(id="txtFareMin")
		private WebElement minimumFare;
		
		@FindBy(id="txtLayoverMax")
		private WebElement maximumLayover;
		
		@FindBy(id="txtLayoverMin")
		private WebElement minimumLayover;
		
		@FindBy(id="chkBoxIsIncludeADTFaresAtCHDAndINF")
		private WebElement chkBoxIsIncludeADTFaresAtCHDAndINF;
		
	//FTP Details section
		@FindBy(id="rdblstUploadProtocolForRequest_0")
		private WebElement ftpRadio;
		
		@FindBy(id="rdblstUploadProtocolForRequest_1")
		private WebElement sftpRadio;
		
		@FindBy(id="txtFTPLocation")
		private WebElement ftpServerName;
		
		@FindBy(id="chkBoxDistributionDetailsSSL")
		private WebElement sslEncryption;
		
		@FindBy(id="chkBoxDistributionDetailsPassive")
		private WebElement passiveMode;
		
		@FindBy(id="txtFTPUserName")
		private WebElement ftpUserName;
		
		@FindBy(id="txtFTPPassword")
		private WebElement ftpPassword;
		
		@FindBy(id="chkboxisKeyAuthenticationRequired")
		private WebElement keyAuthentication;

		@FindBy(id="btnTestFTPConnection")
		private WebElement testFtpConnectionBtn;
	
		
	//Distribution Request summary grid
		@FindBy(css="#MainContent_Repeater1_trData_0:nth-of-type(2) > td input[src='../Images/icon-active.png']")
		public WebElement active;
		
		@FindBy(css="#MainContent_Repeater1_trData_0:nth-of-type(2) > td input[src='../Images/icon-inactive.png']")
		public WebElement inactive;
			
		@FindBy(css="#MainContent_Repeater1_trData_0:nth-of-type(2) > td input[src='../Images/icon-delete.png']")
		public WebElement delete;
		
	
		
	// Distribution Request - Summary :
	
		public void clickOnCreateNewDistributionRequestBtn()
		{
			createNewDistributionRequest.click();
		}
		
		public void clickOnCopyFromExistingBtn()
		{
			copyFromExisting.click();
		}
		
		public void setDistributionRequestStatus(String statusvalue)
		{		
			help.setToggleStaus(active, inactive, statusvalue);
		}
		
		public void deleteDistributionRequestRecord()
		{
			delete.click();
		}
		
		public void selectDistributionRequestRecordRadio()
		{
			if(!selectFirstDistributionRequestRadio.isSelected())
			{
				selectFirstDistributionRequestRadio.click();
			}
		}
	
		
	// Distribution Request Details :
				
		public void selectRecipientName(int recipientindex)
		{
			selenium.selectDropdownValueByIndex(recipient, recipientindex);
		}
		
		public void selectExecutedOnHour(int executehourindex)
		{
			selenium.selectDropdownValueByIndex(executionOnHour, executehourindex);
		}
		
		public void selectExecutedOnMinute(int executeminuteindex)
		{
			selenium.selectDropdownValueByIndex(executionOnMinute, executeminuteindex);
		}
		
		public void selectEDFExportFormat()
		{
			if(!exportFormatEDF.isSelected())
			{
				exportFormatEDF.click();
			}
		}
		
		public void selectLongsellExportFormat()
		{
			if(!exportFormatLongsell.isSelected())
			{
				exportFormatLongsell.click();
			}
		}
		
		public void selectOnewayFlightType()
		{
			if (!oneWayFlightType.isSelected())
			{
				oneWayFlightType.click();
			}
		}
		
		public void selectRoundtripFlightType()
		{
			if (!roundTripFlightType.isSelected())
			{
				roundTripFlightType.click();
			}
		}
		
		public void enterUseDataImportedInLast(String hours)
		{
			useDataImportedInLast.clear();
			useDataImportedInLast.sendKeys(hours);
		}

		public void enterFileName(String filename)
		{
			fileName.clear();
			fileName.sendKeys(filename);
		}
		
		public void selectExcludeSuffix()
		{
			if(!excludeSuffix.isSelected())
			{
				excludeSuffix.click();
			}
		}
		
		public void selectNetFareType()
		{
			if (!netFareType.isSelected())
			{
				netFareType.click();
			}
		}
		
		public void selectTouropFareType()
		{
			if (!touropFareType.isSelected())
			{
				touropFareType.click();
			}
		}
		
		public void selectNegoFareType()
		{
			if (!negoFareType.isSelected())
			{
				negoFareType.click();
			}
		}
		
		public void selectPublishedFareType()
		{
			if (!publishedFareType.isSelected())
			{
				publishedFareType.click();
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
		
		public void enterAirlines(String airline)
		{
			airlines.clear();
			airlines.sendKeys(airline);
		}
		
		public void selectAirlineExclude()
		{
			if (!airlineExclude.isSelected())
			{
				airlineExclude.click();
			}
		}
		
		public void enterMaximumFare(String maxfare)
		{
			maximumFare.clear();
			maximumFare.sendKeys(maxfare);
		}
		
		public void enterMinimumFare(String minfare)
		{
			minimumFare.clear();
			minimumFare.sendKeys(minfare);
		}
		
		public void enterMaximumLayover(String maxlayover)
		{
			maximumLayover.clear();
			maximumLayover.sendKeys(maxlayover);
		}
		
		public void enterMinimumLayover(String minlayover)
		{
			minimumLayover.clear();
			minimumLayover.sendKeys(minlayover);
		}
		
		public void selectUseADTFareForCHDAndINF()
		{
			if (!useDataImportedInLast.isSelected())
			{
				useDataImportedInLast.click();
			}
		}

		public void selectFtpRadio()
		{
			ftpRadio.click();
		}
		
		public void selectSftpRadio()
		{
			sftpRadio.click();
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
		
		public void clickOnTestFTPConnection()
		{
			testFtpConnectionBtn.click();
		}
	
		
}
