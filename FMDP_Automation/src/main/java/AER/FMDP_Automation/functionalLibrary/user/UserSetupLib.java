package AER.FMDP_Automation.functionalLibrary.user;

import org.openqa.selenium.WebDriver;

import AER.FMDP_Automation.pageObjects.common.CommonPO;
import AER.FMDP_Automation.pageObjects.user.UserSetupPO;
import utilities.SeleniumHelpers;

public class UserSetupLib 
{
	WebDriver driver;
	SeleniumHelpers selenium;
	UserSetupPO usermanagementadd;
	CommonPO help ;
	
	
	public UserSetupLib(WebDriver driver)
	{	 
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);
        usermanagementadd = new UserSetupPO(driver);
        help = new CommonPO(driver);
	}
	
	/**
	 * Setup new tax category by providing information in all the fields.
	 * Update tax information from added tax category.
	 *  
	 * @param name			Name of tax	category	e.g. AT_Tax_20171228_143354
	 * @param status		Status of tax category	e.g. Active, Inactive
	 * @param purchase		Tax Applies to purchases	e.g. Yes, No
	 * @param sale			Tax Applies to sales	e.g. Yes, No
	 * @param service		Tax applicable to Services	e.g. Yes, No
	 * @param product		Tax applicable to Products	e.g. Yes, No
	 * @param sundry		Tax applicable to Sundries	e.g. Yes, No
	 * @param expense		Tax applicable to Expenses	e.g. Yes, No
	 * @param date			Tax effective from date		e.g. 28 Dec 2017
	 * @param ratename		Tax rate category name	e.g. AT_rate
	 * @param ratepercent	Tax rate percentage		e.g. 15.00% 
	 * @throws InterruptedException 
	 * 
	 */
	public void userManagement_Add(String firstname, String lastname, String contactno, String emailid, String username, String passwordvalue, String confirmpassword, String descriptionvalue, String featureaccess) throws InterruptedException
	{
		usermanagementadd.enterFirstName(firstname);
		usermanagementadd.enterLastName(lastname);
		usermanagementadd.enterContactNumber(contactno);
		usermanagementadd.enterEmailId(emailid);
		usermanagementadd.enterUserName(username);
		usermanagementadd.enterPassword(passwordvalue);
		usermanagementadd.enterConfirmPassword(confirmpassword);
		usermanagementadd.enterDescription(descriptionvalue);
		
		if (featureaccess.contains("true"))
		{
			usermanagementadd.selectFeatureAccess();
		}
		else
		{
			usermanagementadd.unSelectFeatureAccess();
		}
		
		help.btn_ClickOnSave();
	}
	
	
	public void clickOnCreateNewUserBtn()
	{
		usermanagementadd.clickOnCreateNewUserBtn();
	}
		
	
/*
	//Search : SMTP Configuration section
		*//**
		 * Read SMTP Configuration section data row wise including labels
		 * @param row
		 * @return data for given row
		 *//*
		public String getSmtpConfigurationSectionData(int row)
		{
			return generalsettingadd.getSmtpConfigurationSectionData(row);
		}
		
	//Search : General Details section
		*//**
		 * Read General Details section data row wise including labels
		 * @param row
		 * @return data for given row
		 *//*
		public String getGeneralDetailsSectionData(int row)
		{
			return generalsettingadd.getGeneralDetailsSectionData(row);
		}
		
		*/
}
