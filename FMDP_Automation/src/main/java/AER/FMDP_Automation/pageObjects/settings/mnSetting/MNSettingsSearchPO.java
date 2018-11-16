package AER.FMDP_Automation.pageObjects.settings.mnSetting;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import AER.FMDP_Automation.pageObjects.common.CommonPO;
import utilities.Constants;
import utilities.JavaHelpers;
import utilities.SeleniumHelpers;

public class MNSettingsSearchPO 
{
	WebDriver driver;
	SeleniumHelpers selenium;
	CommonPO help;
	JavaHelpers java;
	
	
	public MNSettingsSearchPO(WebDriver driver)
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
	

	//Search M & N Settings details
	
		//Request section :
		public String getRequestEmailData()
		{
			String cssSelector = ".basic-info-box.form-box > table:nth-of-type(1) > tbody > tr td > input";
			return selenium.waitTillElementIsVisible(By.cssSelector(cssSelector)).getAttribute("value");
		}
		
		public String getRequestAttemptsAndWaitTimeData(int row, int column)
		{
			String cssSelector = ".basic-info-box.form-box > table:nth-of-type(2) > tbody > tr:nth-of-type(" + row + ") > td:nth-of-type(" + column + ") > input";
			return selenium.waitTillElementIsVisible(By.cssSelector(cssSelector)).getAttribute("value");
		}
		
		public boolean getRequestNotifyData(int checkbox_no)
		{
			String cssSelector = ".basic-info-box.form-box > table:nth-of-type(2) > tbody > tr:nth-of-type(2) > td:nth-of-type(2) > input:nth-of-type(" + checkbox_no + ")";
			return selenium.waitTillElementIsVisible(By.cssSelector(cssSelector)).isSelected();
		}
	
		//Request section :
		public String getImportEmailData()
		{
			String cssSelector = "div[class='travell-box form-box']:nth-of-type(4) > table:nth-of-type(1) > tbody > tr td > input";
			return selenium.waitTillElementIsVisible(By.cssSelector(cssSelector)).getAttribute("value");
		}
		
		public String getImportAttemptsAndWaitTimeData(int row, int column)
		{
			String cssSelector = "div[class='travell-box form-box']:nth-of-type(4) > table:nth-of-type(2) > tbody > tr:nth-of-type(" + row + ") > td:nth-of-type(" + column + ") > input";
			return selenium.waitTillElementIsVisible(By.cssSelector(cssSelector)).getAttribute("value");
		}
		
		public boolean getImportNotifyData(int checkbox_no)
		{
			String cssSelector = "div[class='travell-box form-box']:nth-of-type(4) > table:nth-of-type(3) > tbody > tr:nth-of-type(1) > td:nth-of-type(2) > input:nth-of-type(" + checkbox_no + ")";
			return selenium.waitTillElementIsVisible(By.cssSelector(cssSelector)).isSelected();
		}
	
		
		//Request section :
		public String getDistributionEmailData()
		{
			String cssSelector = "div[class='travell-box form-box']:nth-of-type(6) > table:nth-of-type(1) > tbody > tr td > input";
			return selenium.waitTillElementIsVisible(By.cssSelector(cssSelector)).getAttribute("value");
		}
		
		//row : 1, column: 2 & 4
		public String getDistributionAttemptsAndWaitTimeData(int row, int column)
		{
			String cssSelector = "div[class='travell-box form-box']:nth-of-type(4) > table:nth-of-type(2) > tbody > tr:nth-of-type(" + row + ") > td:nth-of-type(" + column + ") > input";
			return selenium.waitTillElementIsVisible(By.cssSelector(cssSelector)).getAttribute("value");
		}
		
		//checkbox_no: 1 & 2
		public boolean getDistributionNotifyData(int checkbox_no)
		{
			String cssSelector = "div[class='travell-box form-box']:nth-of-type(6) > table:nth-of-type(2) > tbody > tr:nth-of-type(2) > td:nth-of-type(2) > input:nth-of-type(" + checkbox_no + ")";
			return selenium.waitTillElementIsVisible(By.cssSelector(cssSelector)).isSelected();
		}
		
			
				
}
