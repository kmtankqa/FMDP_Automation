package AER.FMDP_Automation.pageObjects.searchdata;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import AER.FMDP_Automation.pageObjects.common.CommonPO;
import utilities.Constants;
import utilities.SeleniumHelpers; 

public class AggregateSearchPO 
{
	WebDriver driver;
	SeleniumHelpers selenium;
	CommonPO help;
	
	public AggregateSearchPO(WebDriver driver)
	{	 
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);
        help = new CommonPO(driver);

        //This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, Constants.PAGEFACTORY_WAIT_DURATION), this);
	}
	
	
	/*
	 * All WebElements are identified by @FindBy annotation
	 * @FindBy can accept tagName, partialLinkText, name, linkText, id, css, className, xpath as attributes.
	 */ 	
	
	//Aggregate Search :
	
		@FindBy(id="rdbtnSearchType_0")
		private WebElement aggregateSearchRadio;
	
		@FindBy(id="txtDestination")
		private WebElement destination;
		
		@FindBy(id="txtOrigins")
		private WebElement origin;
		
		@FindBy(id="txtAirlines")
		private WebElement airlines;
		
		@FindBy(id="txtDepartureDate")
		private WebElement departuredate;
		
		@FindBy(id="txtReturnDate")
		private WebElement txtReturnDate;
		
		
	//General Details section :
		
		@FindBy(id="txtMailFrom")
		private WebElement fromEmail;
		
		@FindBy(id="txtMailTo")
		private WebElement toEmail;
		
		@FindBy(id="txtEDFUploadPath")
		private WebElement generatedEdfPath;
		
		@FindBy(id="txtRetentionDays")
		private WebElement dataRetention;

		@FindBy(id="MainContent_KeyUpload")
		private WebElement chooseSftpKeyFile;
		
		@FindBy(id="MainContent_btnUpload")
		private WebElement keyUploadBtn;

			
		
		public void enterFromEmail(String fromemail)
		{
			fromEmail.clear();
			fromEmail.sendKeys(fromemail);
		}
		
		public void enterToEmail(String toemail)
		{
			toEmail.clear();
			toEmail.sendKeys(toemail);
		}
		
		public void enterGeneratedEdfPath(String generatededfpath)
		{
			generatedEdfPath.clear();
			generatedEdfPath.sendKeys(generatededfpath);
		}
		
		public void enterDataRetentionDays(String dataretentionday)
		{
			dataRetention.clear();
			dataRetention.sendKeys(dataretentionday);
		}
		
		public void uploadSftpKey(String sftpkeypath, String confirmationmessage)
		{
			chooseSftpKeyFile.sendKeys(sftpkeypath);
			keyUploadBtn.click();
			selenium.waitTillElementIsVisible(help.successConfirmationMsg);
			help.successConfirmationMsg.getText().contains(confirmationmessage);
			help.successOkBtn.click();
			selenium.waitTillElementIsNOTVisible(help.successConfirmationMsg);
		}
		
		
		
	
}
