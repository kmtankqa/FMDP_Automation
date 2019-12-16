package AER.FMDP_Automation.pageObjects.settings.mnSetting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import AER.FMDP_Automation.pageObjects.common.CommonPO;
import utilities.Constants;
import utilities.SeleniumHelpers; 

public class MNSettingsSetupPO 
{
	WebDriver driver;
	SeleniumHelpers selenium;
	CommonPO help;
	
	public MNSettingsSetupPO(WebDriver driver)
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
	
	//Request section :
	
		@FindBy(id="txtRequestEmailId")
		private WebElement requestEmailId;
	
		@FindBy(id="txtRequestNoOfTimesToRetry")
		private WebElement requestNoOfTimesAttempt;
		
		@FindBy(id="txtRequestTimeBetweenRetry")
		private WebElement requestTimeBetweenAttempt;
		
		@FindBy(id="chkBoxRequestNotifySuccess")
		private WebElement requestNotifySuccess;
		
		@FindBy(id="chkBoxRequestNotifyFailure")
		private WebElement requestNotifyFailure;
		

	//Import section :
		
		@FindBy(id="MainContent_txtImportEmailId")
		private WebElement importEmailId;
	
		@FindBy(id="txtImportNoOfTimesToRetry")
		private WebElement importNoOfTimesAttempt;
		
		@FindBy(id="txtImportTimeBetweenRetry")
		private WebElement importTimeBetweenAttempt;
		
		@FindBy(id="chkBoxImportProcessNotifySuccess")
		private WebElement importNotifySuccess;
		
		@FindBy(id="chkBoxImportProcessNotifyFailure")
		private WebElement importNotifyFailure;

		
	//Distribution section :
		
		@FindBy(id="MainContent_txtDistributionEmailId")
		private WebElement distributionEmailId;
	
		@FindBy(id="txtDistributionNoOfTimesToRetry")
		private WebElement distributionNoOfTimesAttempt;
		
		@FindBy(id="txtDistributionTimeBetweenRetry")
		private WebElement distributionTimeBetweenAttempt;
		
		@FindBy(id="chkBoxDistributionDataUploadNotifySuccess")
		private WebElement distributionNotifySuccess;
		
		@FindBy(id="chkBoxIDistributionDataUploadNotifyFailure")
		private WebElement distributionNotifyFailure;

	
				
		public void enterRequestEmail(String requestemail)
		{
			requestEmailId.clear();
			requestEmailId.sendKeys(requestemail);
		}
		
		public void enterRequestNoOfTimesAttempt(String requestnooftimesattempt)
		{
			requestNoOfTimesAttempt.clear();
			requestNoOfTimesAttempt.sendKeys(requestnooftimesattempt);
		}
		
		public void enterRequestTimeBetweenAttempt(String requesttimetetweenattempt)
		{
			requestTimeBetweenAttempt.clear();
			requestTimeBetweenAttempt.sendKeys(requesttimetetweenattempt);
		}
		
		public void selectRequestNotifySuccess()
		{
			if(!requestNotifySuccess.isSelected())
			{
				requestNotifySuccess.click();
			}
		}
		
		public void selectRequestNotifyFailure()
		{
			if(!requestNotifyFailure.isSelected())
			{
				requestNotifyFailure.click();	
			}
		}
		
		public void unselectRequestNotifySuccess()
		{
			if(requestNotifySuccess.isSelected())
			{
				requestNotifySuccess.click();
			}
		}
		
		public void unselectRequestNotifyFailure()
		{
			if(requestNotifyFailure.isSelected())
			{
				requestNotifyFailure.click();
			}
		}
		
		public void enterImportEmail(String importemail)
		{
			importEmailId.clear();
			importEmailId.sendKeys(importemail);
		}
		
		public void enterImportNoOfTimesAttempt(String importnooftimesattempt)
		{
			importNoOfTimesAttempt.clear();
			importNoOfTimesAttempt.sendKeys(importnooftimesattempt);
		}
		
		public void enterImportTimeBetweenAttempt(String importtimebetweenattempt)
		{
			importTimeBetweenAttempt.clear();
			importTimeBetweenAttempt.sendKeys(importtimebetweenattempt);
		}
		
		public void selectImportNotifySuccess()
		{
			if(!importNotifySuccess.isSelected())
			{
				importNotifySuccess.click();
			}	
		}
		
		public void selectImportNotifyFailure()
		{
			if(!importNotifyFailure.isSelected())
			{
				importNotifyFailure.click();	
			}
		}
		
		public void unselectImportNotifySuccess()
		{
			if(importNotifySuccess.isSelected())
			{
				importNotifySuccess.click();
			}	
		}
		
		public void unselectImportNotifyFailure()
		{
			if(importNotifyFailure.isSelected())
			{
				importNotifyFailure.click();	
			}
		}
		
		public void enterDistributionEmail(String distributionemail)
		{
			distributionEmailId.clear();
			distributionEmailId.sendKeys(distributionemail);
		}
		
		public void enterDistributionNoOfTimesAttempt(String distributionnooftimesattempt)
		{
			distributionNoOfTimesAttempt.clear();
			distributionNoOfTimesAttempt.sendKeys(distributionnooftimesattempt);
		}
		
		public void enterDistributionTimeBetweenAttempt(String distributiontimebetweenattempt)
		{
			distributionTimeBetweenAttempt.clear();
			distributionTimeBetweenAttempt.sendKeys(distributiontimebetweenattempt);
		}
		
		public void selectDistributionNotifySuccess()
		{
			if(!distributionNotifySuccess.isSelected())
			{
				distributionNotifySuccess.click();
			}	
		}
		
		public void selectDistributionNotifyFailure()
		{
			if(!distributionNotifyFailure.isSelected())
			{
				distributionNotifyFailure.click();	
			}
		}
		
		public void unselectDistributionNotifySuccess()
		{
			if(distributionNotifySuccess.isSelected())
			{
				distributionNotifySuccess.click();
			}	
		}
		
		public void unselectDistributionNotifyFailure()
		{
			if(distributionNotifyFailure.isSelected())
			{
				distributionNotifyFailure.click();	
			}
		}

		
}
