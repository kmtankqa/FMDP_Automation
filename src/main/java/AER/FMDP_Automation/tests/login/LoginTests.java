package AER.FMDP_Automation.tests.login;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import AER.FMDP_Automation.functionalLibrary.common.CommonLib;
import AER.FMDP_Automation.functionalLibrary.common.TopNavigationLib;
import AER.FMDP_Automation.functionalLibrary.login.LoginLib;
import io.qameta.allure.Description;
import utilities.Constants;
import utilities.ExceptionHandler;
import utilities.JavaHelpers;
import utilities.SeleniumHelpers;
import utilities.WebDriverManager;

public class LoginTests 
{
	private WebDriver driver;
	private WebDriverManager drivermanager;
	private LoginLib loginlib;
	private TopNavigationLib navigationlib;
	private CommonLib common ;
	private SeleniumHelpers selenium;
	private SoftAssert sfassert;
	private ExceptionHandler ex;
	
	//Test Data
	private String propertyFile="test-input/login.properties";
	private String username = JavaHelpers.getPropertyValue(propertyFile,"username_" + Constants.Env);
	private String password = JavaHelpers.getPropertyValue(propertyFile,"password1_" + Constants.Env);
	private String newpassword = JavaHelpers.getPropertyValue(propertyFile,"password2_" + Constants.Env);
	private String name = JavaHelpers.getPropertyValue(propertyFile,"name_" + Constants.Env);
	private String errorMessage = JavaHelpers.getPropertyValue(propertyFile,"loginErrorMessage");
	
	
	@BeforeClass
	@Parameters({"node", "browser", "headless"})
	public void setUp(@Optional("local") String node, @Optional("chrome") String browser, @Optional("true") boolean headless) throws Exception
	{
		drivermanager = new WebDriverManager();
		driver = drivermanager.setUp(node,browser,headless); 
		loginlib = new LoginLib(driver);
		navigationlib = new TopNavigationLib(driver);
		common = new CommonLib(driver);
		selenium = new SeleniumHelpers(driver);
	}
	

	@BeforeMethod
	public void beforeMethod()
	{
		sfassert = new SoftAssert();
		ex = new ExceptionHandler(driver);
	}
	
	
	/*Test 1 : Verify that user can't login with incorrect credentials */
	@Test (priority = 1, description="Invalid Login Scenario with wrong username and password.")
	@Description("Test Description: Invalid Login test with wrong username and wrong password.")
	public void login_Failure() throws IOException
	{
		try {
			Reporter.log("Step 1 = Login to application at : " + Constants.LIVE_URL + " and loging in with incorrect credentails");
			selenium.navigateToPage(Constants.LIVE_URL);
			loginlib.loginToApplication("random@mail.com", "password");
			
			Reporter.log("Step 2 = Verify the validation message displayed");
			sfassert.assertEquals(loginlib.getErrorMessage(), errorMessage);
			common.popup_ClickOnErrorOk();
			
			//soft assert
			sfassert.assertAll();
			
		} 
		catch (AssertionError | Exception e) 
		{
			ex.TakeScreenshotAndLogException(e.getMessage());
		}
		
	}
	
	
	/*Test 2 : Verify that user can login/logout/change password successfully*/
	@Test (priority = 2, description="Change password and login with updated password.")
	@Description("Test Description: Change password and login with updated password.")
	public void login_ChangePassword() throws IOException
	{
		try 
		{
			Reporter.log("Step 1 = Login to application");
			loginlib.loginToApplication(username, password);
			
			Reporter.log("Step 2 = Verify that user is logged in or not");
			sfassert.assertEquals(navigationlib.getLoggedInUserName(), name);
			
			Reporter.log("Step 3 = Click on change password link and performing change password");
			navigationlib.changePassword_FillDetailsAndDone(password, newpassword);
			
			Reporter.log("Step 4 = Click on logout, and login as new password");
			navigationlib.logout();			
			loginlib.loginToApplication(Constants.LIVE_URL,username, newpassword);
			
			Reporter.log("Step 6 = Click on change password and reverting to original password");
			navigationlib.changePassword_FillDetailsAndDone(newpassword, password);
			
			Reporter.log("Step 7 = Verify that user is logged in or not");
			sfassert.assertEquals(navigationlib.getLoggedInUserName(), name);
			
			
			//soft assert
			sfassert.assertAll();
		} 
		catch (AssertionError | Exception e) 
		{
			ex.TakeScreenshotAndLogException(e.getMessage());
		}
	}
	
	
	@AfterClass
	public void tearDown() throws Exception
	{
		drivermanager.tearDown();
	}  
	
}
