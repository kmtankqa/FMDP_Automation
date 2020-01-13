package AER.FMDP_Automation.functionalLibrary.common;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import AER.FMDP_Automation.pageObjects.common.CommonPO;
import AER.FMDP_Automation.pageObjects.common.TopNavigationPO;
import io.qameta.allure.Step;
import utilities.Constants;
import utilities.JavaHelpers;
import utilities.SeleniumHelpers;

public class TopNavigationLib 
{
	WebDriver driver;
	SeleniumHelpers selenium;
	CommonPO common;
	JavaHelpers java;
	TopNavigationPO topnavigation;
	
	public TopNavigationLib(WebDriver driver)
	{	 
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);
        common = new CommonPO(driver);
        java = new JavaHelpers(); 
        topnavigation = new TopNavigationPO(driver);
	}
	
	
	/**
	 * Profile Badge - get logged in user's name
	 * @return text
	 */
	@Step("Get the logged in user's name.")
	public String getLoggedInUserName()
	{
		return topnavigation.getLoggedInUserName();
	}
	
	
	/**
	 * Click on Profile badge
	 * @throws InterruptedException
	 */
	public void clickOnProfileBadge() throws InterruptedException
	{
		int i=0;
		boolean isclicked = false;

		do {
			if(topnavigation.isProfileBadgeDisplayed()) 
			{
				topnavigation.clickOnProfileBadge();
				isclicked = true;
				break;
			}
			else 
			{
				i++;
				selenium.refreshPage();
				common.waitTillPageLoaded();
			}

		} while (i < Constants.MaxAttemptForLocatingElement);
		
		//if search result not found then failing test with message 
		if(!isclicked)
		{
			Assert.fail("FAIL : Profile badge can't be clicked successfully");
		}
	}
	
	
	/**
	 * Fill & submit Change Password form
	 * @param currentpassword current password
	 * @param newpassword new password
	 * @throws InterruptedException
	 */
	@Step("Fill and submit change password form. currentpassword: {0}, newpassword: {1}")
	public void changePassword_FillDetailsAndDone(String currentpassword,String newpassword) throws InterruptedException
	{
		topnavigation.clickOnChangePassword();
		topnavigation.enterValueForCurrentPassword(currentpassword);
		topnavigation.enterValueForNewPassword(newpassword);
		topnavigation.enterValueForReenterPassword(newpassword);
		topnavigation.clickOnChangePasswordBtn();
		common.waitTillPageLoaded();
	}

	
	/**
	 * Click on Logout link
	 * @throws InterruptedException
	 */
	@Step("Logout from the application.")
	public void logout() throws InterruptedException
	{
		topnavigation.clickOnLogout();
		java.sleep(2);
	}
	
	
	//Top Navigation Links
	
	/**
	 * Click on Home link
	 */
	@Step("Open 'Home' page of the application.")
	public void link_ClickOnHome()
	{
		topnavigation.clickOnHome();
	}
	
	
	//Settings
	
	/**
	 * Click On General Settings Menu
	 */
	@Step("Open 'General Setting' page of the application.")
	public void menu_ClickOnGeneralSetting()
	{
		topnavigation.menu_ClickOnGeneralSetting();
	}
	
	
	/**
	 * Click On M & N Settings Menu
	 */
	@Step("Open 'M & N Setting' page of the application.")
	public void menu_ClickOnMnSetting()
	{
		topnavigation.menu_ClickOnMnSetting();
	}
	
	
	//User Management
	
	/**
	 * Click on User Management Menu
	 */
	@Step("Open 'User Management' page of the application.")
	public void menu_ClickOnUserManagement()
	{
		topnavigation.menu_ClickOnUserManagement();
	}
	
	
	//User Management
	
	/**
	 * Click on Recipient Management Menu
	 */
	@Step("Open 'Recipient Management' page of the application.")
	public void menu_ClickOnRecipientManagement()
	{
		topnavigation.menu_ClickOnRecipientManagement();
	}
	
	
	//Supplier Management
	
	/**
	 * Click on Supplier Management Menu
	 */
	@Step("Open 'Supplier Management' page of the application.")
	public void menu_ClickOnSupplierManagement()
	{
		topnavigation.menu_ClickOnSupplierManagement();
	}
	

	//Distribution Summary
	
	/**
	 * Click on Distribution Summary Menu
	 */
	@Step("Open 'Distribution Summary' page of the application.")
	public void menu_ClickOnDistributionSummary()
	{
		topnavigation.menu_ClickOnDistributionSummary();
	}
	
	
}
