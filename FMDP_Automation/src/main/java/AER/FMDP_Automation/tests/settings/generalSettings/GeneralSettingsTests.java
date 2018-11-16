package AER.FMDP_Automation.tests.settings.generalSettings;

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
import AER.FMDP_Automation.functionalLibrary.settings.generalSetting.GeneralSettingsSearchLib;
import AER.FMDP_Automation.functionalLibrary.settings.generalSetting.GeneralSettingsSetupLib;
import utilities.Constants;
import utilities.ExceptionHandler;
import utilities.JavaHelpers;
import utilities.SeleniumHelpers;
import utilities.WebDriverManager;

public class GeneralSettingsTests {
	private WebDriver driver;
	private WebDriverManager drivermanager;
	private LoginLib loginlib;
	private TopNavigationLib navigationlib;
	private CommonLib common;
	private SeleniumHelpers selenium;
	private GeneralSettingsSetupLib generalsettingadd;
	private GeneralSettingsSearchLib generalsettingsearch;
	private SoftAssert sfassert;
	private String expected;
	private String actual;
	private ExceptionHandler ex;

	// Test Data
	private String propertyFile = "test-input/settings.properties";
	private String sftpKeyPath = Constants.currentDir + Constants.uploadFilePath;
	private String sftpFileName = JavaHelpers.getPropertyValue(propertyFile, "sftpFileName");
	private String smtpserver_add = JavaHelpers.getPropertyValue(propertyFile, "smtpserver_add");
	private String smtpusername_add = JavaHelpers.getPropertyValue(propertyFile, "smtpusername_add");
	private String smtppassword_add = JavaHelpers.getPropertyValue(propertyFile, "smtppassword_add");
	private String smtpport_add = JavaHelpers.getPropertyValue(propertyFile, "smtpport_add");
	
	private String smtpserver_update = JavaHelpers.getPropertyValue(propertyFile, "smtpserver_update");
	private String smtpusername_update = JavaHelpers.getPropertyValue(propertyFile, "smtpusername_update");
	private String smtppassword_update = JavaHelpers.getPropertyValue(propertyFile, "smtppassword_update");
	private String smtpport_update = JavaHelpers.getPropertyValue(propertyFile, "smtpport_update");
	
	private String fromemail_add = JavaHelpers.getPropertyValue(propertyFile, "fromemail_add");
	private String toemail_add = JavaHelpers.getPropertyValue(propertyFile, "toemail_add");
	private String generatededfpath_add = JavaHelpers.getPropertyValue(propertyFile, "generatededfpath_add");
	private String dataretentionday_add = JavaHelpers.getPropertyValue(propertyFile, "dataretentionday_add");
	private String confirmationmessage = JavaHelpers.getPropertyValue(propertyFile, "confirmationmessage");
	
	private String fromemail_update = JavaHelpers.getPropertyValue(propertyFile, "fromemail_update");
	private String toemail_update = JavaHelpers.getPropertyValue(propertyFile, "toemail_update");
	private String generatededfpath_update = JavaHelpers.getPropertyValue(propertyFile, "generatededfpath_update");
	private String dataretentionday_update = JavaHelpers.getPropertyValue(propertyFile, "dataretentionday_update");
	
	
	@BeforeClass
	@Parameters({ "node", "browser" })
	public void setUp(@Optional("local") String node, @Optional("chrome") String browser) throws Exception {
		drivermanager = new WebDriverManager();
		driver = drivermanager.setUp(node, browser);
		loginlib = new LoginLib(driver);
		navigationlib = new TopNavigationLib(driver);
		common = new CommonLib(driver);
		selenium = new SeleniumHelpers(driver);
		generalsettingadd = new GeneralSettingsSetupLib(driver);
		generalsettingsearch = new GeneralSettingsSearchLib(driver);
	}

	@BeforeMethod
	public void beforeMethod() {
		sfassert = new SoftAssert();
		ex = new ExceptionHandler(driver);
	}

	/* Test 1 : Verify that user can add general settings details successfully */
	@Test(priority = 1)
	public void generalSetting_Add() throws IOException {
		try {
			// Step 1 = Navigating and Logging in to Live Application
			Reporter.log("Step 1 = Login to application at : " + Constants.LIVE_URL + " and loging in with correct credentails");
			loginlib.loginToApplication(Constants.LIVE_URL, Constants.LIVE_USERNAME, Constants.LIVE_PASSWORD);

			// Step 2 = Opening Menu & Navigating to Settings > General Settings
			Reporter.log("Step 2 = Opening Menu & Navigating to Settings > General Settings");
			navigationlib.menu_ClickOnGeneralSetting();

			// Step 3 = On General Settings page, adding details, uploading SFTP key and click on Save button
			Reporter.log("Step 3 = On General Settings page, adding details, uploading SFTP key and click on Save button");
			generalsettingadd.generalSetting_Add(smtpserver_add, smtpusername_add, smtppassword_add, smtpport_add, fromemail_add, toemail_add, generatededfpath_add, dataretentionday_add, sftpKeyPath + sftpFileName, confirmationmessage);
			common.popup_ClickOnSuccessOk();

			// Step 4 = Searching for added general settings details and verifying that it has correct details
			Reporter.log("Step 4 = Searching for added general settings details and verifying that it has correct details");
			navigationlib.link_ClickOnHome();
			navigationlib.menu_ClickOnGeneralSetting();		
			
			//SMTP Configuration section :

				// Verifying SMTP server
				expected = smtpserver_add;
				actual = generalsettingsearch.getSmtpConfigurationSectionData(1);
				sfassert.assertEquals(actual, expected);
	
				// Verifying SMTP username
				expected = smtpusername_add;
				actual = generalsettingsearch.getSmtpConfigurationSectionData(2);
				sfassert.assertEquals(actual, expected);
	
				// Verifying SMTP password
				expected = smtppassword_add;
				actual = generalsettingsearch.getSmtpConfigurationSectionData(3);
				sfassert.assertEquals(actual, expected);
	
				// Verifying SMTP port
				expected = smtpport_add;
				actual = generalsettingsearch.getSmtpConfigurationSectionData(4);
				sfassert.assertEquals(actual, expected);

			//General Details section :

				// Verifying From Email
				expected = fromemail_add;
				actual = generalsettingsearch.getGeneralDetailsSectionData(2);
				sfassert.assertEquals(actual, expected);
	
				// Verifying To Email
				expected = toemail_add;
				actual = generalsettingsearch.getGeneralDetailsSectionData(3);
				sfassert.assertEquals(actual, expected);
	
				// Verifying Generated EDF Path
				expected = generatededfpath_add;
				actual = generalsettingsearch.getGeneralDetailsSectionData(4);
				sfassert.assertEquals(actual, expected);
	
				// Verifying Data Retention Days
				expected = dataretentionday_add;
				actual = generalsettingsearch.getGeneralDetailsSectionData(5);
				sfassert.assertEquals(actual, expected);
				
				
			// soft assert
			sfassert.assertAll();
			
		}
		catch (AssertionError | Exception e)
		{
			ex.TakeScreenshotAndLogException(e.getMessage());
		}

	}

	
	/*	Test 2 : Verify that user can edit general settings information successfully */ 
	@Test(priority = 2, dependsOnMethods = { "generalSetting_Add" })
	public void generalSetting_Update() throws IOException {
		try {
			// Step 1 = Editing added generate settings details
			Reporter.log("Step 1 = Editing added generate settings details");
			selenium.refreshPage();
			generalsettingadd.generalSetting_Add(smtpserver_update, smtpusername_update, smtppassword_update, smtpport_update, fromemail_update, toemail_update, generatededfpath_update, dataretentionday_update, sftpKeyPath + sftpFileName, confirmationmessage);
			common.popup_ClickOnSuccessOk();
			
			// Step 2 = Searching for configured general settings and verifying that it has correct details
			Reporter.log("Step 2 = Searching for configured general settings and verifying that it has correct details");
			navigationlib.link_ClickOnHome();
			navigationlib.menu_ClickOnGeneralSetting();		
			
			//SMTP Configuration section :

				// Verifying SMTP server
				expected = smtpserver_update;
				actual = generalsettingsearch.getSmtpConfigurationSectionData(1);
				sfassert.assertEquals(actual, expected);
	
				// Verifying SMTP username
				expected = smtpusername_update;
				actual = generalsettingsearch.getSmtpConfigurationSectionData(2);
				sfassert.assertEquals(actual, expected);
	
				// Verifying SMTP password
				expected = smtppassword_update;
				actual = generalsettingsearch.getSmtpConfigurationSectionData(3);
				sfassert.assertEquals(actual, expected);
	
				// Verifying SMTP port
				expected = smtpport_update;
				actual = generalsettingsearch.getSmtpConfigurationSectionData(4);
				sfassert.assertEquals(actual, expected);

			//General Details section :

				// Verifying From Email
				expected = fromemail_update;
				actual = generalsettingsearch.getGeneralDetailsSectionData(2);
				sfassert.assertEquals(actual, expected);
	
				// Verifying To Email
				expected = toemail_update;
				actual = generalsettingsearch.getGeneralDetailsSectionData(3);
				sfassert.assertEquals(actual, expected);
	
				// Verifying Generated EDF Path
				expected = generatededfpath_update;
				actual = generalsettingsearch.getGeneralDetailsSectionData(4);
				sfassert.assertEquals(actual, expected);
	
				// Verifying Data Retention Days
				expected = dataretentionday_update;
				actual = generalsettingsearch.getGeneralDetailsSectionData(5);
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