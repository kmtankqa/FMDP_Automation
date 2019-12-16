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
	 * Setup new user record by providing information in all the fields.
	 * Update user information from added user record.
	 * 
	 * @param firstname				First Name of user	e.g. FMDP, John
	 * @param lastname				Last Name of user	e.g. Automation, Carter
	 * @param contactno				Contact Number of user	e.g. 6136994792
	 * @param emailid				Email Id of user	e.g. Email_20181120_195254@dayrep.com
	 * @param username				Username of user	e.g. user_20181120_195254
	 * @param passwordvalue			Password of given username	e.g. passw0rd
	 * @param confirmpassword		Confirm password	e.g. passw0rd
	 * @param descriptionvalue		Description of user	e.g. This is automated description for new user creation
	 * @param featureaccess			Feature access information	e.g. true or false
	 * @throws InterruptedException
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
			usermanagementadd.deselectFeatureAccess();
		}
		
		help.btn_ClickOnSave();
	}
	
	
	/**
	 * Click on Create New User button to add new user record.
	 */
	public void clickOnCreateNewUserBtn()
	{
		usermanagementadd.clickOnCreateNewUserBtn();
	}
		
	
	/**
	 * Set user's status
	 * @param statusvalue	status value of supplier i.e. Active or Inactive
	 * 
	 */
	public void user_changeStatus(String statusvalue)
	{
		usermanagementadd.setUserStatus(statusvalue);
	}
	
	
	/**
	 * Delete Active or Inactive user record.
	 */
	public void user_deleteRecord()
	{
		usermanagementadd.deleteUserRecord();
		help.popup_ClickOnConfirmationYes();
	}
	
	
}
