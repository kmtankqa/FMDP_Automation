package AER.FMDP_Automation.pageObjects.settings.generalSetting;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import AER.FMDP_Automation.pageObjects.common.CommonPO;
import utilities.Constants;
import utilities.JavaHelpers;
import utilities.SeleniumHelpers;

public class GeneralSettingSearchPO 
{
	WebDriver driver;
	SeleniumHelpers selenium;
	CommonPO help;
	JavaHelpers java;
	
	
	public GeneralSettingSearchPO(WebDriver driver)
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
	
			
			
	//Search General Setting details
		
		//SMTP Configuration section :
		public String getSmtpConfigurationSectionData(int row)
		{
			String cssSelector = ".right-col > div > table:nth-of-type(1) > tbody > tr:nth-of-type(" + row + ") > td > input";
			return selenium.waitTillElementIsVisible(By.cssSelector(cssSelector)).getAttribute("value");
		}
		
		//General Details section :
		public String getGeneralDetailsSectionData(int row)
		{
			String cssSelector = ".right-col > div > table:nth-of-type(2) > tbody > tr:nth-of-type(" + row + ") > td > input";
			return selenium.waitTillElementIsVisible(By.cssSelector(cssSelector)).getAttribute("value");
		}
			
			
			
				
}
