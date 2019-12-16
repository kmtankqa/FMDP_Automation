package AER.FMDP_Automation.pageObjects.settings.generalSetting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import AER.FMDP_Automation.pageObjects.common.CommonPO;
import utilities.Constants;
import utilities.SeleniumHelpers; 

public class GeneralSettingSetupPO 
{
	WebDriver driver;
	SeleniumHelpers selenium;
	CommonPO help;
	
	public GeneralSettingSetupPO(WebDriver driver)
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
	
	//SMTP Configuration section :
	
		@FindBy(id="txtServer")
		private WebElement smtpServer;
	
		@FindBy(id="txtUserName")
		private WebElement smtpUsername;
		
		@FindBy(id="txtPassword")
		private WebElement smtpPassword;
		
		@FindBy(id="txtPort")
		private WebElement smtpPort;
		
		
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

			
		public void enterSmtpServer(String smtpserver)
		{
			smtpServer.clear();
			smtpServer.sendKeys(smtpserver);
		}
		
		public void enterSmtpUsername(String smtpusername)
		{
			smtpUsername.clear();
			smtpUsername.sendKeys(smtpusername);
		}
		
		public void enterSmtpPassword(String smtppassword)
		{
			smtpPassword.clear();
			smtpPassword.sendKeys(smtppassword);
		}
		
		public void enterSmtpPort(String smtpport)
		{
			smtpPort.clear();
			smtpPort.sendKeys(smtpport);
		}
		
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
