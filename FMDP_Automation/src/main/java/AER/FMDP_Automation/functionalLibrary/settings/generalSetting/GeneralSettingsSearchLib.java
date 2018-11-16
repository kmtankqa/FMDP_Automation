package AER.FMDP_Automation.functionalLibrary.settings.generalSetting;

import org.openqa.selenium.WebDriver;

import AER.FMDP_Automation.pageObjects.common.CommonPO;
import AER.FMDP_Automation.pageObjects.common.ItemListPO;
import AER.FMDP_Automation.pageObjects.settings.generalSetting.GeneralSettingSearchPO;
import utilities.JavaHelpers;
import utilities.SeleniumHelpers;

public class GeneralSettingsSearchLib 
{
	WebDriver driver;
	SeleniumHelpers selenium;
	CommonPO help;
	GeneralSettingSearchPO searchpo;
	JavaHelpers java;
	ItemListPO itemlist;
	
	
	public GeneralSettingsSearchLib(WebDriver driver)
	{	 
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);
        help = new CommonPO(driver);
        java = new JavaHelpers();
        searchpo = new GeneralSettingSearchPO(driver);
        itemlist = new ItemListPO(driver);
        
	}
	
	
	
		//Search : SMTP Configuration section
			/**
			 * Read SMTP Configuration section data row wise
			 * @param row
			 * @return data for given row
			 */
			public String getSmtpConfigurationSectionData(int row)
			{
				return searchpo.getSmtpConfigurationSectionData(row);
			}
		
			
		//Search : General Details section
			/**
			 * Read General Details section data row wise
			 * @param row
			 * @return data for given row
			 */
			public String getGeneralDetailsSectionData(int row)
			{	
				return searchpo.getGeneralDetailsSectionData(row);
			}
		
			
}
