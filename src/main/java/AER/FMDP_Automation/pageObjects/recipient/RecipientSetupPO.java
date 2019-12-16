package AER.FMDP_Automation.pageObjects.recipient;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import AER.FMDP_Automation.pageObjects.common.CommonPO;
import utilities.Constants;
import utilities.JavaHelpers;
import utilities.SeleniumHelpers; 

public class RecipientSetupPO 
{
	WebDriver driver;
	SeleniumHelpers selenium;
	CommonPO help;
	JavaHelpers java;
	
	public RecipientSetupPO(WebDriver driver)
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
	
		@FindBy(css=".user-options2 > input[value='Create New Recipient']")
		private WebElement createNewRecipient;
		
		
	//Recipient Details Page :
		
		//General Details section
		@FindBy(id="txtRecipientName")
		private WebElement recipientName;
		
		@FindBy(id="MainContent_ddlPriority")
		private WebElement priority;
		
		@FindBy(id="txtRecipientContactNo")
		private WebElement contactNo;
		
		@FindBy(id="txtRecipientEmailId")
		private WebElement emailId;
		
		@FindBy(id="txtRecipientAddress1")
		private WebElement address1;
		
		@FindBy(id="txtRecipientAddress2")
		private WebElement address2;
		
		@FindBy(id="txtRecipientCity")
		private WebElement city;
		
		@FindBy(id="txtRecipientCountry")
		private WebElement country;
		
		@FindBy(id="txtRecipientState")
		private WebElement state;
		
		@FindBy(id="chkMergeLongsell")
		private WebElement mergeLongsell;
		
		@FindBy(id="txtfileName")
		private WebElement fileName;
		
		@FindBy(id="chkRemovePrefix")
		private WebElement removePrefix;
		
		@FindBy(id="chklstFareType_0")
		private WebElement chdFare;
		
		@FindBy(id="chklstFareType_1")
		private WebElement infFare;
		
		
		//FTP Details section
		@FindBy(id="rdblstUploadProtocol_0")
		private WebElement ftpRadio;
		
		@FindBy(id="rdblstUploadProtocol_1")
		private WebElement sftpRadio;
		
		@FindBy(id="txtFTPServerName")
		private WebElement ftpServerName;
		
		@FindBy(id="chkBoxSSL")
		private WebElement sslEncryption;
		
		@FindBy(id="chkBoxPassive")
		private WebElement passiveMode;
		
		@FindBy(id="txtFTPUserName")
		private WebElement ftpUserName;
		
		@FindBy(id="txtFTPPassword")
		private WebElement ftpPassword;
		
		@FindBy(id="chkboxisKeyAuthenticationRequired")
		private WebElement keyAuthentication;

		@FindBy(id="btnTestFTPConnection")
		private WebElement testFtpConnectionBtn;
		
		
		
	//Feature Details section
		@FindBy(css=".innerTable tbody ol[id='chklstAccessibleFeatures'] > li > input")
		public List<WebElement> featureAccess;

	//User summary grid
		@FindBy(css=".gridtdHeight:nth-of-type(2) > td input[src='../Images/icon-active.png']")
		public WebElement active;
		
		@FindBy(css=".gridtdHeight:nth-of-type(2) > td input[src='../Images/icon-inactive.png']")
		public WebElement inactive;
		
		@FindBy(css=".gridtdHeight:nth-of-type(2) > td input[src='../Images/icon-delete.png']")
		public WebElement delete;
		
		
	
	// Recipient Details :
		
		public void clickOnCreateNewRecipientBtn()
		{
			createNewRecipient.click();
		}
				
		public void enterRecipientName(String recipientname)
		{
			recipientName.clear();
			recipientName.sendKeys(recipientname);
		}
		
		public void selectPriority(String priorityvalue)
		{
			selenium.selectDropdownValueByText(priority, priorityvalue);
		}
		
		public void enterContactNumber(String contactno)
		{
			contactNo.clear();
			contactNo.sendKeys(contactno);
		}
		
		public void enterEmailId(String emailid)
		{
			emailId.clear();
			emailId.sendKeys(emailid);
		}
		
		public void enterAddress1(String address1value)
		{
			address1.clear();
			address1.sendKeys(address1value);
		}
		
		public void enterAddress2(String address2value)
		{
			address2.clear();
			address2.sendKeys(address2value);
		}
		
		public void enterCity(String cityvalue)
		{
			city.clear();
			city.sendKeys(cityvalue);
		}
		
		public void enterCountry(String countryvalue)
		{
			country.clear();
			country.sendKeys(countryvalue);
		}
		
		public void enterState(String statevalue)
		{
			state.clear();
			state.sendKeys(statevalue);
		}
		
		public void selectMergeLongsell()
		{
			if (!mergeLongsell.isSelected())
			{
				mergeLongsell.click();
			}
		}
		
		public void deselectMergeLongsell()
		{
			if (mergeLongsell.isSelected())
			{
				mergeLongsell.click();
			}
		}
		
		public void enterFileName(String filename)
		{
			if (fileName.isEnabled())
			{
				fileName.clear();
				fileName.sendKeys(filename);
			}
		}
		
		public void selectRemovePrefix()
		{
			if (removePrefix.isEnabled())
			{
				removePrefix.click();
			}
		}
		
		public void selectCHDFare()
		{
			if (!chdFare.isSelected())
			{
				chdFare.click();
			}
		}
		
		public void deselectCHDFare()
		{
			if (chdFare.isSelected())
			{
				chdFare.click();
			}
		}
		
		public void selectINFFare()
		{
			if (!infFare.isSelected())
			{
				infFare.click();
			}
		}
		
		public void deselectINFFare()
		{
			if (infFare.isSelected())
			{
				infFare.click();
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
		
	
		
	// Recipient - Summary :
		
		public void setRecipientStatus(String statusvalue)
		{		
			help.setToggleStaus(active, inactive, statusvalue);
		}
		
		public void deleteRecipientRecord()
		{
			delete.click();
		}
		
}
