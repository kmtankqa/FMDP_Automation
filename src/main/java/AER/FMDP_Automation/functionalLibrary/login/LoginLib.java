package AER.FMDP_Automation.functionalLibrary.login;
import org.openqa.selenium.WebDriver;

import AER.FMDP_Automation.functionalLibrary.common.CommonLib;
import AER.FMDP_Automation.pageObjects.login.LoginPO;
import io.qameta.allure.Step;
import utilities.SeleniumHelpers;

public class LoginLib 
{
	WebDriver driver;
	SeleniumHelpers selenium;
	LoginPO loginpo;
	CommonLib common;
	
	public LoginLib(WebDriver driver)
	{	 
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);
        loginpo = new LoginPO(driver);
        common = new CommonLib(driver);
	}
	
	
	/**
	 * Login to application with url, username, and password
	 * @param url login page url
	 * @param username username
	 * @param password password
	 */
	@Step("Login to the application with the url: {0}, username: {1}, password: {2}, for method: {method} step...")
	public void loginToApplication(String url, String username, String password)
	{
		selenium.navigateToPage(url);
		loginpo.enterUsername(username);
		loginpo.enterPassword(password);
		loginpo.clickOnLogin();
	}
	
	/**
	 * Login to application 
	 * @param username username
	 * @param password password
	 */
	@Step("Login with the username: {0}, password: {1}, for method: {method} step...")
	public void loginToApplication(String username, String password)
	{
		loginpo.enterUsername(username);
		loginpo.enterPassword(password);
		loginpo.clickOnLogin();
	}
	
	/**
	 * Get validation message on login page
	 * @return validation text
	 */
	@Step("Get validation message from login page on unsuccessful login attempt.")
	public String getErrorMessage()
	{
		return loginpo.getErrorMessage();
	}
	
	/**
	 * To check whether error message displayed or not
	 * @return true or false
	 */
	@Step("Verifying the error message displayed or not on login page.")
	public boolean isErrorMessageDispalyed()
	{
		boolean b = true;
		
		try
		{
			getErrorMessage();
		}
		catch(Exception e)
		{
			b=false;
		}
		return b;
	}
	
}
