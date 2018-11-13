package AER.FMDP_Automation.tests.settings.mnSettings;

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
import AER.FMDP_Automation.functionalLibrary.settings.generalSetting.GeneralSettingsLib;
import AER.FMDP_Automation.functionalLibrary.settings.mnSetting.MNSettingsLib;
import utilities.Constants;
import utilities.ExceptionHandler;
import utilities.JavaHelpers;
import utilities.SeleniumHelpers;
import utilities.WebDriverManager;

public class MNSettingsTests {
	private WebDriver driver;
	private WebDriverManager drivermanager;
	private LoginLib loginlib;
	private TopNavigationLib navigationlib;
	private CommonLib common;
	private SeleniumHelpers selenium;
	private MNSettingsLib mnsettingadd;
	private SoftAssert sfassert;
	private String expected;
	private String actual;
	private ExceptionHandler ex;

	// Test Data
	private String propertyFile = "test-input/settings.properties";
	
	private String requestemail_add = JavaHelpers.getPropertyValue(propertyFile, "requestemail_add");
	private String requestnooftimesattempt_add = JavaHelpers.getPropertyValue(propertyFile, "requestnooftimesattempt_add");
	private String requesttimebetweenattempt_add = JavaHelpers.getPropertyValue(propertyFile, "requesttimebetweenattempt_add");
	private String importemail_add = JavaHelpers.getPropertyValue(propertyFile, "importemail_add");
	private String importnooftimesattempt_add = JavaHelpers.getPropertyValue(propertyFile, "importnooftimesattempt_add");
	private String importtimebetweenattempt_add = JavaHelpers.getPropertyValue(propertyFile, "importtimebetweenattempt_add");
	private String distributionemail_add = JavaHelpers.getPropertyValue(propertyFile, "distributionemail_add");
	private String distributionnooftimesattempt_add = JavaHelpers.getPropertyValue(propertyFile, "distributionnooftimesattempt_add");
	private String distributiontimebetweenattempt_add = JavaHelpers.getPropertyValue(propertyFile, "distributiontimebetweenattempt_add");
	private String checkbox_select_add = JavaHelpers.getPropertyValue(propertyFile, "checkbox_select_add");
	
	private String requestemail_update = JavaHelpers.getPropertyValue(propertyFile, "requestemail_update");
	private String requestnooftimesattempt_update = JavaHelpers.getPropertyValue(propertyFile, "requestnooftimesattempt_update");
	private String requesttimebetweenattempt_update = JavaHelpers.getPropertyValue(propertyFile, "requesttimebetweenattempt_update");
	private String importemail_update = JavaHelpers.getPropertyValue(propertyFile, "importemail_update");
	private String importnooftimesattempt_update = JavaHelpers.getPropertyValue(propertyFile, "importnooftimesattempt_update");
	private String importtimebetweenattempt_update = JavaHelpers.getPropertyValue(propertyFile, "importtimebetweenattempt_update");
	private String distributionemail_update = JavaHelpers.getPropertyValue(propertyFile, "distributionemail_update");
	private String distributionnooftimesattempt_update = JavaHelpers.getPropertyValue(propertyFile, "distributionnooftimesattempt_update");
	private String distributiontimebetweenattempt_update = JavaHelpers.getPropertyValue(propertyFile, "distributiontimebetweenattempt_update");
	private String checkbox_select_update = JavaHelpers.getPropertyValue(propertyFile, "checkbox_select_update");
	
	
	@BeforeClass
	@Parameters({ "node", "browser" })
	public void setUp(@Optional("local") String node, @Optional("chrome") String browser) throws Exception {
		drivermanager = new WebDriverManager();
		driver = drivermanager.setUp(node, browser);
		loginlib = new LoginLib(driver);
		navigationlib = new TopNavigationLib(driver);
		common = new CommonLib(driver);
		selenium = new SeleniumHelpers(driver);
		mnsettingadd = new MNSettingsLib(driver);
	}

	@BeforeMethod
	public void beforeMethod() {
		sfassert = new SoftAssert();
		ex = new ExceptionHandler(driver);
	}

	/* Test 1 : Verify that user can add general settings details successfully */
	@Test(priority = 1)
	public void mnSetting_Add() throws IOException {
		try {
			// Step 1 - Navigating and Logging in to Live Application
			Reporter.log("Step 1 = Login to application at : " + Constants.LIVE_URL + " and loging in with correct credentails");
			loginlib.loginToApplication(Constants.LIVE_URL, Constants.LIVE_USERNAME, Constants.LIVE_PASSWORD);

			// Step 2- Opening Menu & Navigating to Settings > General Settings
			Reporter.log("Step 2 = Opening Menu & Navigating to Settings > General Settings");
			//navigationlib.clickOnMenuItem("General settings");
			navigationlib.menu_ClickOnMnSetting();

			// Step 3- On General Settings page, adding details, click on Save button
			Reporter.log("Step 3 = On General Settings page, adding details, click on Save button");
			mnsettingadd.mnSetting_Add(requestemail_add, requestnooftimesattempt_add, requesttimebetweenattempt_add, importemail_add, importnooftimesattempt_add, importtimebetweenattempt_add, distributionemail_add, distributionnooftimesattempt_add, distributiontimebetweenattempt_add, checkbox_select_add);
			common.popup_ClickOnSuccessOk();

			// Step 4 = Searching for added general settings details and verifying that it has correct details
			Reporter.log("Step 4 = Searching for added general settings details and verifying that it has correct details");
			navigationlib.link_ClickOnHome();
			navigationlib.menu_ClickOnMnSetting();		
			
			//Request section :

				// Verifying SMTP server
				expected = requestemail_add;
				actual = mnsettingadd.getRequestEmailData();
				sfassert.assertEquals(actual, expected);
	
				// Verifying SMTP username
				expected = requestnooftimesattempt_add;
				actual = mnsettingadd.getRequestAttemptsAndWaitTimeData(1, 2);
				sfassert.assertEquals(actual, expected);
				
				// Verifying SMTP username
				expected = requesttimebetweenattempt_add;
				actual = mnsettingadd.getRequestAttemptsAndWaitTimeData(1, 4);
				sfassert.assertEquals(actual, expected);
	
				// Verifying SMTP password
				expected = checkbox_select_add;
				boolean actual_success_req = mnsettingadd.getRequestNotifyData(1);
				actual = String.valueOf(actual_success_req);
				sfassert.assertEquals(actual, expected);
	
				// Verifying SMTP port
				expected = checkbox_select_add;
				boolean actual_failure_req = mnsettingadd.getRequestNotifyData(2);
				actual = String.valueOf(actual_failure_req);
				sfassert.assertEquals(actual, expected);
	
			//Import section :

				// Verifying SMTP server
				expected = importemail_add;
				actual = mnsettingadd.getImportEmailData();
				sfassert.assertEquals(actual, expected);
	
				// Verifying SMTP username
				expected = importnooftimesattempt_add;
				actual = mnsettingadd.getImportAttemptsAndWaitTimeData(1, 2);
				sfassert.assertEquals(actual, expected);
				
				// Verifying SMTP username
				expected = importtimebetweenattempt_add;
				actual = mnsettingadd.getImportAttemptsAndWaitTimeData(1, 4);
				sfassert.assertEquals(actual, expected);
	
				// Verifying SMTP password
				expected = checkbox_select_add;
				boolean actual_success_imp = mnsettingadd.getImportNotifyData(1);
				actual = String.valueOf(actual_success_imp);
				sfassert.assertEquals(actual, expected);
	
				// Verifying SMTP port
				expected = checkbox_select_add;
				boolean actual_failure_imp = mnsettingadd.getRequestNotifyData(2);
				actual = String.valueOf(actual_failure_imp);
				sfassert.assertEquals(actual, expected);
				
			//Distribution section :

				// Verifying SMTP server
				expected = distributionemail_add;
				actual = mnsettingadd.getDistributionEmailData();
				sfassert.assertEquals(actual, expected);
	
				// Verifying SMTP username
				expected = distributionnooftimesattempt_add;
				actual = mnsettingadd.getDistributionAttemptsAndWaitTimeData(1, 2);
				sfassert.assertEquals(actual, expected);
				
				// Verifying SMTP username
				expected = distributiontimebetweenattempt_add;
				actual = mnsettingadd.getDistributionAttemptsAndWaitTimeData(1, 4);
				sfassert.assertEquals(actual, expected);
	
				// Verifying SMTP password
				expected = checkbox_select_add;
				boolean actual_success_dist = mnsettingadd.getDistributionNotifyData(1);
				actual = String.valueOf(actual_success_dist);
				sfassert.assertEquals(actual, expected);
	
				// Verifying SMTP port
				expected = checkbox_select_add;
				boolean actual_failure_dist = mnsettingadd.getDistributionNotifyData(2);
				actual = String.valueOf(actual_failure_dist);
				sfassert.assertEquals(actual, expected);
				
				
			// soft assert
			sfassert.assertAll();
			
		}
		catch (AssertionError | Exception e)
		{
			ex.TakeScreenshotAndLogException(e.getMessage());
		}

	}

	
	/*Test 2 : Verify that user can edit tax category successfully*/  
	@Test(priority = 2, dependsOnMethods = { "mnSetting_Add" })
	public void mnSetting_Update() throws IOException {
		try {
			// Step 1 = Editing added generate settings details
			Reporter.log("Step 1 = Editing added generate settings details");
			selenium.refreshPage();
			mnsettingadd.mnSetting_Add(requestemail_update, requestnooftimesattempt_update, requesttimebetweenattempt_update, importemail_update, importnooftimesattempt_update, importtimebetweenattempt_update, distributionemail_update, distributionnooftimesattempt_update, distributiontimebetweenattempt_update, checkbox_select_update);
			common.popup_ClickOnSuccessOk();
			
			// Step 2 = Searching for edited general settings details and verifying that it has correct
			Reporter.log("Step 2 = Searching for edited general settings details and verifying that it has correct");
			navigationlib.link_ClickOnHome();
			navigationlib.menu_ClickOnMnSetting();		
		
			//Request section :

				// Verifying SMTP server
				expected = requestemail_update;
				actual = mnsettingadd.getRequestEmailData();
				sfassert.assertEquals(actual, expected);
		
				// Verifying SMTP username
				expected = requestnooftimesattempt_update;
				actual = mnsettingadd.getRequestAttemptsAndWaitTimeData(1, 2);
				sfassert.assertEquals(actual, expected);
				
				// Verifying SMTP username
				expected = requesttimebetweenattempt_update;
				actual = mnsettingadd.getRequestAttemptsAndWaitTimeData(1, 4);
				sfassert.assertEquals(actual, expected);
		
				// Verifying SMTP password
				expected = checkbox_select_update;
				boolean actual_success_req = mnsettingadd.getRequestNotifyData(1);
				actual = String.valueOf(actual_success_req);
				sfassert.assertEquals(actual, expected);
		
				// Verifying SMTP port
				expected = checkbox_select_update;
				boolean actual_failure_req = mnsettingadd.getRequestNotifyData(2);
				actual = String.valueOf(actual_failure_req);
				sfassert.assertEquals(actual, expected);

			//Import section :

				// Verifying SMTP server
				expected = importemail_update;
				actual = mnsettingadd.getImportEmailData();
				sfassert.assertEquals(actual, expected);
	
				// Verifying SMTP username
				expected = importnooftimesattempt_update;
				actual = mnsettingadd.getImportAttemptsAndWaitTimeData(1, 2);
				sfassert.assertEquals(actual, expected);
				
				// Verifying SMTP username
				expected = importtimebetweenattempt_update;
				actual = mnsettingadd.getImportAttemptsAndWaitTimeData(1, 4);
				sfassert.assertEquals(actual, expected);
	
				// Verifying SMTP password
				expected = checkbox_select_update;
				boolean actual_success_imp = mnsettingadd.getImportNotifyData(1);
				actual = String.valueOf(actual_success_imp);
				sfassert.assertEquals(actual, expected);
	
				// Verifying SMTP port
				expected = checkbox_select_update;
				boolean actual_failure_imp = mnsettingadd.getRequestNotifyData(2);
				actual = String.valueOf(actual_failure_imp);
				sfassert.assertEquals(actual, expected);
			
			//Distribution section :

				// Verifying SMTP server
				expected = distributionemail_update;
				actual = mnsettingadd.getDistributionEmailData();
				sfassert.assertEquals(actual, expected);
	
				// Verifying SMTP username
				expected = distributionnooftimesattempt_update;
				actual = mnsettingadd.getDistributionAttemptsAndWaitTimeData(1, 2);
				sfassert.assertEquals(actual, expected);
				
				// Verifying SMTP username
				expected = distributiontimebetweenattempt_update;
				actual = mnsettingadd.getDistributionAttemptsAndWaitTimeData(1, 4);
				sfassert.assertEquals(actual, expected);
	
				// Verifying SMTP password
				expected = checkbox_select_update;
				boolean actual_success_dist = mnsettingadd.getDistributionNotifyData(1);
				actual = String.valueOf(actual_success_dist);
				sfassert.assertEquals(actual, expected);
	
				// Verifying SMTP port
				expected = checkbox_select_update;
				boolean actual_failure_dist = mnsettingadd.getDistributionNotifyData(2);
				actual = String.valueOf(actual_failure_dist);
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