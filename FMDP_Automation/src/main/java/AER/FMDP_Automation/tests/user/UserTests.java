package AER.FMDP_Automation.tests.user;

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
import AER.FMDP_Automation.functionalLibrary.user.UserSearchLib;
import AER.FMDP_Automation.functionalLibrary.user.UserSetupLib;
import utilities.Constants;
import utilities.ExceptionHandler;
import utilities.JavaHelpers;
import utilities.SeleniumHelpers;
import utilities.WebDriverManager;

public class UserTests
{
	private WebDriver driver;
	private WebDriverManager drivermanager;
	private LoginLib loginlib;
	private TopNavigationLib navigationlib;
	private CommonLib common;
	private JavaHelpers javahelp;
	private SeleniumHelpers selenium;
	private UserSetupLib usersetupadd;
	private UserSearchLib usersearch;
	private SoftAssert sfassert;
	private String expected;
	private String actual;
	private ExceptionHandler ex;

	// Test Data
	private String timeStamp;
	private String propertyFile = "test-input/usermanagement.properties";
	private String firstname_add = JavaHelpers.getPropertyValue(propertyFile, "firstname_add");
	private String lastname_add = JavaHelpers.getPropertyValue(propertyFile, "lastname_add");
	private String contactno_add = JavaHelpers.getPropertyValue(propertyFile, "contactno_add");
	private String emailid_add = JavaHelpers.getPropertyValue(propertyFile, "emailid_add");
	private String email;
	private String username_add = JavaHelpers.getPropertyValue(propertyFile, "username_add");
	private String username;
	private String password_add = JavaHelpers.getPropertyValue(propertyFile, "password_add");
	private String confirmpassword_add = JavaHelpers.getPropertyValue(propertyFile, "confirmpassword_add");
	private String description_add = JavaHelpers.getPropertyValue(propertyFile, "description_add");
	private String featureaccess_add = JavaHelpers.getPropertyValue(propertyFile, "featureaccess_add");
	
	private String firstname_update = JavaHelpers.getPropertyValue(propertyFile, "firstname_update");
	private String lastname_update = JavaHelpers.getPropertyValue(propertyFile, "lastname_update");
	private String contactno_update = JavaHelpers.getPropertyValue(propertyFile, "contactno_update");
	private String emailid_update = JavaHelpers.getPropertyValue(propertyFile, "emailid_update");
	private String username_update = JavaHelpers.getPropertyValue(propertyFile, "username_update");
	private String password_update = JavaHelpers.getPropertyValue(propertyFile, "password_update");
	private String confirmpassword_update = JavaHelpers.getPropertyValue(propertyFile, "confirmpassword_update");
	private String description_update = JavaHelpers.getPropertyValue(propertyFile, "description_update");
	private String featureaccess_update = JavaHelpers.getPropertyValue(propertyFile, "featureaccess_update");
	
	
	@BeforeClass
	@Parameters({ "node", "browser" })
	public void setUp(@Optional("local") String node, @Optional("chrome") String browser) throws Exception {
		drivermanager = new WebDriverManager();
		driver = drivermanager.setUp(node, browser);
		loginlib = new LoginLib(driver);
		navigationlib = new TopNavigationLib(driver);
		common = new CommonLib(driver);
		javahelp = new JavaHelpers();
		selenium = new SeleniumHelpers(driver);
		usersetupadd = new UserSetupLib(driver);
		usersearch = new UserSearchLib(driver);
	}

	@BeforeMethod
	public void beforeMethod() {
		sfassert = new SoftAssert();
		timeStamp = javahelp.timeStamp();
		ex = new ExceptionHandler(driver);
	}

	/* Test 1 : Verify that user can add general settings details successfully */
	@Test(priority = 1)
	public void user_Add() throws IOException {
		try {
			// Step 1 - Navigating and Logging in to Live Application
			Reporter.log("Step 1 = Login to application at : " + Constants.LIVE_URL + " and loging in with correct credentails");
			loginlib.loginToApplication(Constants.LIVE_URL, Constants.LIVE_USERNAME, Constants.LIVE_PASSWORD);

			// Step 2- Opening Menu & Navigating to User Management
			Reporter.log("Step 2 = Opening Menu & Navigating to User Management");
			navigationlib.menu_ClickOnUserManagement();

			// Step 3- On Create New User Details page, adding details, click on Save button
			Reporter.log("Step 3 = On Create New User Details page, adding details, click on Save button");
			email = emailid_add + timeStamp + "@dayrep.com";
			username = username_add + timeStamp;
			usersetupadd.clickOnCreateNewUserBtn();
			usersetupadd.userManagement_Add(firstname_add, lastname_add, contactno_add, email, username, password_add, confirmpassword_add, description_add, featureaccess_add);
			common.popup_ClickOnSuccessOk();

			// Step 4 = Searching for added general settings details and verifying that it has correct details
			Reporter.log("Step 4 = Searching for added general settings details and verifying that it has correct details");
			navigationlib.menu_ClickOnUserManagement();
			usersearch.search_SearchUserWithUserNameAndClick(username);
			
			//Basic Details section :

				//Verifying First Name
				expected = firstname_add;
				actual = usersearch.getBasicDetailsSectionData(1, 2);
				sfassert.assertEquals(actual, expected);
				
				//Verifying First Name
				expected = lastname_add;
				actual = usersearch.getBasicDetailsSectionData(1, 4);
				sfassert.assertEquals(actual, expected);
				
				//Verifying First Name
				expected = contactno_add;
				actual = usersearch.getBasicDetailsSectionData(2, 2);
				sfassert.assertEquals(actual, expected);
				
				//Verifying First Name
				expected = email;
				actual = usersearch.getBasicDetailsSectionData(2, 4);
				sfassert.assertEquals(actual, expected);
				
				//Verifying First Name
				expected = username;
				actual = usersearch.getBasicDetailsSectionData(3, 2);
				sfassert.assertEquals(actual, expected);
				
				//Verifying First Name
				expected = password_add;
				actual = usersearch.getBasicDetailsSectionData(4, 2);
				sfassert.assertEquals(actual, expected);
				
				//Verifying First Name
				expected = confirmpassword_add;
				actual = usersearch.getBasicDetailsSectionData(4, 4);
				sfassert.assertEquals(actual, expected);
				
				//Verifying First Name
				expected = description_add;
				actual = usersearch.getDescriptionData();
				sfassert.assertEquals(actual, expected);
		
				
			//Feature Details section :
				
				// Verifying settings check-box
				expected = "true";
				boolean actual_value1 = usersearch.getFeatureAccessData(1);
				actual = String.valueOf(actual_value1);
				sfassert.assertEquals(actual, expected);
				
				// Verifying settings check-box
				boolean actual_value2 = usersearch.getFeatureAccessData(2);
				actual = String.valueOf(actual_value2);
				sfassert.assertEquals(actual, expected);
				
				// Verifying settings check-box
				boolean actual_value3 = usersearch.getFeatureAccessData(3);
				actual = String.valueOf(actual_value3);
				sfassert.assertEquals(actual, expected);
				
				// Verifying settings check-box
				boolean actual_value4 = usersearch.getFeatureAccessData(4);
				actual = String.valueOf(actual_value4);
				sfassert.assertEquals(actual, expected);
				
				// Verifying settings check-box
				boolean actual_value5 = usersearch.getFeatureAccessData(5);
				actual = String.valueOf(actual_value5);
				sfassert.assertEquals(actual, expected);
				
				// Verifying settings check-box
				boolean actual_value6 = usersearch.getFeatureAccessData(6);
				actual = String.valueOf(actual_value6);
				sfassert.assertEquals(actual, expected);
				
				// Verifying settings check-box
				boolean actual_value7 = usersearch.getFeatureAccessData(7);
				actual = String.valueOf(actual_value7);
				sfassert.assertEquals(actual, expected);
				
				boolean actual_value8 = usersearch.getFeatureAccessData(8);
				actual = String.valueOf(actual_value8);
				sfassert.assertEquals(actual, expected);
				
				
			// soft assert
			sfassert.assertAll();
			
		}
		catch (AssertionError | Exception e)
		{
			ex.TakeScreenshotAndLogException(e.getMessage());
		}

	}

	
	/*	Test 2 : Verify that user can edit tax category successfully */  
	@Test(priority = 2, dependsOnMethods = { "user_Add" })
	public void user_Update() throws IOException {
		try {
			// Step 1 = Editing added generate settings details
			Reporter.log("Step 1 = Editing added generate settings details");
			selenium.refreshPage();
			email = emailid_update + timeStamp + "@dayrep.com";
			username = username_update + timeStamp;
			usersetupadd.userManagement_Add(firstname_update, lastname_update, contactno_update, email, username, password_update, confirmpassword_update, description_update, featureaccess_update);
			common.popup_ClickOnSuccessOk();
			
			// Step 2 = Searching for edited general settings details and verifying that it has correct
			Reporter.log("Step 2 = Searching for edited general settings details and verifying that it has correct");
			navigationlib.menu_ClickOnUserManagement();
			usersearch.search_SearchUserWithUserNameAndClick(username);
			
			//Basic Details section :

				//Verifying First Name
				expected = firstname_update;
				actual = usersearch.getBasicDetailsSectionData(1, 2);
				sfassert.assertEquals(actual, expected);
				
				//Verifying First Name
				expected = lastname_update;
				actual = usersearch.getBasicDetailsSectionData(1, 4);
				sfassert.assertEquals(actual, expected);
				
				//Verifying First Name
				expected = contactno_update;
				actual = usersearch.getBasicDetailsSectionData(2, 2);
				sfassert.assertEquals(actual, expected);
				
				//Verifying First Name
				expected = email;
				actual = usersearch.getBasicDetailsSectionData(2, 4);
				sfassert.assertEquals(actual, expected);
				
				//Verifying First Name
				expected = username;
				actual = usersearch.getBasicDetailsSectionData(3, 2);
				sfassert.assertEquals(actual, expected);
				
				//Verifying First Name
				expected = password_update;
				actual = usersearch.getBasicDetailsSectionData(4, 2);
				sfassert.assertEquals(actual, expected);
				
				//Verifying First Name
				expected = confirmpassword_update;
				actual = usersearch.getBasicDetailsSectionData(4, 4);
				sfassert.assertEquals(actual, expected);
				
				//Verifying First Name
				expected = description_update;
				actual = usersearch.getDescriptionData();
				sfassert.assertEquals(actual, expected);
	
			
			//Feature Details section :
				
				// Verifying settings check-box
				expected = "false";
				boolean actual_value1 = usersearch.getFeatureAccessData(1);
				actual = String.valueOf(actual_value1);
				sfassert.assertEquals(actual, expected);
				
				// Verifying settings check-box
				boolean actual_value2 = usersearch.getFeatureAccessData(2);
				actual = String.valueOf(actual_value2);
				sfassert.assertEquals(actual, expected);
				
				// Verifying settings check-box
				boolean actual_value3 = usersearch.getFeatureAccessData(3);
				actual = String.valueOf(actual_value3);
				sfassert.assertEquals(actual, expected);
				
				// Verifying settings check-box
				boolean actual_value4 = usersearch.getFeatureAccessData(4);
				actual = String.valueOf(actual_value4);
				sfassert.assertEquals(actual, expected);
				
				// Verifying settings check-box
				boolean actual_value5 = usersearch.getFeatureAccessData(5);
				actual = String.valueOf(actual_value5);
				sfassert.assertEquals(actual, expected);
				
				// Verifying settings check-box
				boolean actual_value6 = usersearch.getFeatureAccessData(6);
				actual = String.valueOf(actual_value6);
				sfassert.assertEquals(actual, expected);
				
				// Verifying settings check-box
				boolean actual_value7 = usersearch.getFeatureAccessData(7);
				actual = String.valueOf(actual_value7);
				sfassert.assertEquals(actual, expected);
				
				// Verifying settings check-box
				expected = "true";
				boolean actual_value8 = usersearch.getFeatureAccessData(8);
				actual = String.valueOf(actual_value8);
				sfassert.assertEquals(actual, expected);
			

			// soft assert
			sfassert.assertAll();
		}
		catch (AssertionError | Exception e)
		{
			ex.TakeScreenshotAndLogException(e.getMessage());
		}
	}

	@AfterClass
	public void tearDown() throws Exception {
		drivermanager.tearDown();
	}

}