package AER.FMDP_Automation.tests.recipient;

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
import AER.FMDP_Automation.functionalLibrary.recipient.RecipientSearchLib;
import AER.FMDP_Automation.functionalLibrary.recipient.RecipientSetupLib;
import utilities.Constants;
import utilities.ExceptionHandler;
import utilities.JavaHelpers;
import utilities.SeleniumHelpers;
import utilities.WebDriverManager;

public class RecipientTests
{
	private WebDriver driver;
	private WebDriverManager drivermanager;
	private LoginLib loginlib;
	private TopNavigationLib navigationlib;
	private CommonLib common;
	private JavaHelpers javahelp;
	private SeleniumHelpers selenium;
	private RecipientSetupLib recipientsetupadd;
	private RecipientSearchLib recipientsearch;
	private SoftAssert sfassert;
	private String expected;
	private String actual;
	private ExceptionHandler ex;

	// Test Data
	private String timeStamp;
	private String propertyFile = "test-input/recipientmanagement.properties";
	private String recipientname_add = JavaHelpers.getPropertyValue(propertyFile, "recipientname_add");
	private String recipientname;
	private String priority_add = JavaHelpers.getPropertyValue(propertyFile, "priority_add");
	private String contactno_add = JavaHelpers.getPropertyValue(propertyFile, "contactno_add");
	private String emailid_add = JavaHelpers.getPropertyValue(propertyFile, "emailid_add");
	private String email;
	private String address1_add = JavaHelpers.getPropertyValue(propertyFile, "address1_add");
	private String address2_add = JavaHelpers.getPropertyValue(propertyFile, "address2_add");
	private String city_add = JavaHelpers.getPropertyValue(propertyFile, "city_add");
	private String country_add = JavaHelpers.getPropertyValue(propertyFile, "country_add");
	private String state_add = JavaHelpers.getPropertyValue(propertyFile, "state_add");
	private String filename_add = JavaHelpers.getPropertyValue(propertyFile, "filename_add");
	private String ftplocation_add = JavaHelpers.getPropertyValue(propertyFile, "ftplocation_add");
	private String ftpusername_add = JavaHelpers.getPropertyValue(propertyFile, "ftpusername_add");
	private String ftppassword_add = JavaHelpers.getPropertyValue(propertyFile, "ftppassword_add");
	private String ismergelongsell_add = JavaHelpers.getPropertyValue(propertyFile, "ismergelongsell_add");
	private String includeFareInLongsell_add = JavaHelpers.getPropertyValue(propertyFile, "includeFareInLongsell_add");
	
	private String priority_update = JavaHelpers.getPropertyValue(propertyFile, "priority_update");
	private String contactno_update = JavaHelpers.getPropertyValue(propertyFile, "contactno_update");
	private String address1_update = JavaHelpers.getPropertyValue(propertyFile, "address1_update");
	private String address2_update = JavaHelpers.getPropertyValue(propertyFile, "address2_update");
	private String city_update = JavaHelpers.getPropertyValue(propertyFile, "city_update");
	private String country_update = JavaHelpers.getPropertyValue(propertyFile, "country_update");
	private String state_update = JavaHelpers.getPropertyValue(propertyFile, "state_update");
	private String ismergelongsell_update = JavaHelpers.getPropertyValue(propertyFile, "ismergelongsell_update");
	private String includeFareInLongsell_update = JavaHelpers.getPropertyValue(propertyFile, "includeFareInLongsell_update");
	private String sftplocation_update = JavaHelpers.getPropertyValue(propertyFile, "sftplocation_update");
	private String sftpusername_update = JavaHelpers.getPropertyValue(propertyFile, "sftpusername_update");
	private String sftppassword_update = JavaHelpers.getPropertyValue(propertyFile, "sftppassword_update");
	
	private String ftptype;
	
	private String norecord_msg = JavaHelpers.getPropertyValue(propertyFile, "norecord_msg");
	
	
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
		recipientsetupadd = new RecipientSetupLib(driver);
		recipientsearch = new RecipientSearchLib(driver);
	}

	@BeforeMethod
	public void beforeMethod() {
		sfassert = new SoftAssert();
		timeStamp = javahelp.timeStamp();
		ex = new ExceptionHandler(driver);
	}

	
	/* Test 1 : Verify that user can add new Recipient record successfully */
	@Test(priority = 1)
	public void recipient_Add() throws IOException {
		try {
			// Step 1 = Navigating and Logging in to Live Application
			Reporter.log("Step 1 = Login to application at : " + Constants.LIVE_URL + " and loging in with correct credentails");
			loginlib.loginToApplication(Constants.LIVE_URL, Constants.LIVE_USERNAME, Constants.LIVE_PASSWORD);

			// Step 2 = Opening Menu & Navigating to Recipient Management and Open Create New Recipient screen
			Reporter.log("Step 2 = Opening Menu & Navigating to Recipient Management and Open Create New Recipient screen");
			navigationlib.menu_ClickOnRecipientManagement();
			recipientsetupadd.clickOnCreateNewRecipientBtn();

			// Step 3 = On Create New Recipient page, adding details, click on Save button
			Reporter.log("Step 3 = On Create New Recipient page, adding details, click on Save button");
			recipientname = recipientname_add + timeStamp;
			email = emailid_add + timeStamp + "@dayrep.com";
			ftptype = "ftp";
			recipientsetupadd.recipientManagement_Add(recipientname, priority_add, contactno_add, email, address1_add, address2_add, city_add, country_add, state_add, filename_add, ismergelongsell_add, includeFareInLongsell_add, ftptype, ftplocation_add, ftpusername_add, ftppassword_add);
			common.popup_ClickOnSuccessOk();

			// Step 4 = Searching for added Recipient record and verifying that it has correct details
			Reporter.log("Step 4 = Searching for added Recipient record and verifying that it has correct details");
			navigationlib.menu_ClickOnRecipientManagement();
			recipientsearch.search_SearchActiveRecipientWithRecipientNameAndClick(recipientname);
			
			//General Details section :

				//Verifying Recipient Name
				expected = recipientname;
				actual = recipientsearch.getGeneralDetailsSectionData(1, 2);
				sfassert.assertEquals(actual, expected);
				
				//Verifying Priority				
				expected = priority_add;
				actual = recipientsearch.getBasicDetailsPriorityData();
				sfassert.assertEquals(actual, expected);
				
				//Verifying Contact Number
				expected = contactno_add;
				actual = recipientsearch.getGeneralDetailsSectionData(2, 2);
				sfassert.assertEquals(actual, expected);
				
				//Verifying Email
				expected = email;
				actual = recipientsearch.getGeneralDetailsSectionData(2, 4);
				sfassert.assertEquals(actual, expected);
				
				//Verifying Address1
				expected = address1_add;
				actual = recipientsearch.getGeneralDetailsSectionData(3, 2);
				sfassert.assertEquals(actual, expected);
				
				//Verifying Address2
				expected = address2_add;
				actual = recipientsearch.getGeneralDetailsSectionData(3, 4);
				sfassert.assertEquals(actual, expected);
				
				//Verifying City
				expected = city_add;
				actual = recipientsearch.getGeneralDetailsSectionData(4, 2);
				sfassert.assertEquals(actual, expected);
				
				//Verifying Country
				expected = country_add;
				actual = recipientsearch.getGeneralDetailsSectionData(5, 2);
				sfassert.assertEquals(actual, expected);
				
				//Verifying State
				expected = state_add;
				actual = recipientsearch.getGeneralDetailsSectionData(6, 2);
				sfassert.assertEquals(actual, expected);
				
				//Verifying Merge Longsell
				expected = ismergelongsell_add;
				boolean actual_merge = recipientsearch.getGeneralDetailsCheckboxData(4, 4, 1);
				actual = String.valueOf(actual_merge);
				sfassert.assertEquals(actual, expected);
				
				//Verifying File Name
				expected = filename_add;
				actual = recipientsearch.getGeneralDetailsSectionData(5, 4);
				sfassert.assertEquals(actual, expected);
		
				//Verifying Remove Prefix
				expected = "true";
				boolean actual_prefix = recipientsearch.getGeneralDetailsCheckboxData(5, 4, 1);
				actual = String.valueOf(actual_prefix);
				sfassert.assertEquals(actual, expected);
				
				//Verifying Include Fares in Longsell CHD
				boolean actual_chdfare = recipientsearch.getGeneralDetailsCheckboxData(6, 4, 1);
				actual = String.valueOf(actual_chdfare);
				sfassert.assertEquals(actual, expected);
				
				//Verifying Include Fares in Longsell INF
				boolean actual_inffare = recipientsearch.getGeneralDetailsCheckboxData(6, 4, 2);
				actual = String.valueOf(actual_inffare);
				sfassert.assertEquals(actual, expected);
				
			
			//Feature Details section :
				
				//Verifying FTP Location
				expected = ftplocation_add;
				actual = recipientsearch.getFTPDetailsSectionData(1, 2);
				sfassert.assertEquals(actual, expected);
				
				//Verifying Use SSL/TLS Encryption
				expected = "true";
				boolean actual_ssl = recipientsearch.getFTPDetailsSectionData(2, 2, 1);
				actual = String.valueOf(actual_ssl);
				sfassert.assertEquals(actual, expected);
				
				//Verifying Passive Transfer Mode
				expected = "true";
				boolean actual_mode = recipientsearch.getFTPDetailsSectionData(2, 2, 3);
				actual = String.valueOf(actual_mode);
				sfassert.assertEquals(actual, expected);
				
				//Verifying FTP UserName
				expected = ftpusername_add;
				actual = recipientsearch.getFTPDetailsSectionData(3, 2);
				sfassert.assertEquals(actual, expected);
				
				//Verifying FTP Password
				expected = ftppassword_add;
				actual = recipientsearch.getFTPDetailsSectionData(4, 2);
				sfassert.assertEquals(actual, expected);
				
				
			// soft assert
			sfassert.assertAll();
			
		}
		catch (AssertionError | Exception e)
		{
			ex.TakeScreenshotAndLogException(e.getMessage());
		}

	}

	/*Test 2 : Verify that user can edit Recipient details successfully*/   
	@Test(priority = 2, dependsOnMethods = { "recipient_Add" })
	public void recipient_Update() throws IOException {
		try {
			// Step 1 = Editing details of added Recipient record, click on Save button
			Reporter.log("Step 1 = Editing details of added User record, click on Save button");
			selenium.refreshPage();			
			recipientname = recipientname_add + timeStamp;
			email = emailid_add + timeStamp + "@dayrep.com";
			ftptype = "sftp";
			recipientsetupadd.recipientManagement_Add(recipientname, priority_update, contactno_update, email, address1_update, address2_update, city_update, country_update, state_update, "", ismergelongsell_update, includeFareInLongsell_update, ftptype, sftplocation_update, sftpusername_update, sftppassword_update);
			common.popup_ClickOnSuccessOk();
			
			// Step 2 = Searching for edited Recipient record and verifying that it has correct details
			Reporter.log("Step 4 = Searching for added Recipient record and verifying that it has correct details");
			navigationlib.menu_ClickOnRecipientManagement();
			recipientsearch.search_SearchActiveRecipientWithRecipientNameAndClick(recipientname);
			
			
			//General Details section :

				//Verifying Recipient Name
				expected = recipientname;
				actual = recipientsearch.getGeneralDetailsSectionData(1, 2);
				sfassert.assertEquals(actual, expected);
				
				//Verifying Priority				
				expected = priority_update;
				actual = recipientsearch.getBasicDetailsPriorityData();
				sfassert.assertEquals(actual, expected);
				
				//Verifying Contact Number
				expected = contactno_update;
				actual = recipientsearch.getGeneralDetailsSectionData(2, 2);
				sfassert.assertEquals(actual, expected);
				
				//Verifying Email
				expected = email;
				actual = recipientsearch.getGeneralDetailsSectionData(2, 4);
				sfassert.assertEquals(actual, expected);
				
				//Verifying Address1
				expected = address1_update;
				actual = recipientsearch.getGeneralDetailsSectionData(3, 2);
				sfassert.assertEquals(actual, expected);
				
				//Verifying Address2
				expected = address2_update;
				actual = recipientsearch.getGeneralDetailsSectionData(3, 4);
				sfassert.assertEquals(actual, expected);
				
				//Verifying City
				expected = city_update;
				actual = recipientsearch.getGeneralDetailsSectionData(4, 2);
				sfassert.assertEquals(actual, expected);
				
				//Verifying Country
				expected = country_update;
				actual = recipientsearch.getGeneralDetailsSectionData(5, 2);
				sfassert.assertEquals(actual, expected);
				
				//Verifying State
				expected = state_update;
				actual = recipientsearch.getGeneralDetailsSectionData(6, 2);
				sfassert.assertEquals(actual, expected);
				
				//Verifying Merge Longsell
				expected = ismergelongsell_update;
				boolean actual_merge = recipientsearch.getGeneralDetailsCheckboxData(4, 4, 1);
				actual = String.valueOf(actual_merge);
				sfassert.assertEquals(actual, expected);
				
				//Verifying FileName Textbox
				expected = "false";
				boolean actual_filenamefield = recipientsearch.getFileNameTextboxStatus();
				actual = String.valueOf(actual_filenamefield);
				sfassert.assertEquals(actual, expected);
				
				//Verifying Remove Prefix Checkbox
				boolean actual_removeprefix = recipientsearch.getRemovePrefixCheckboxStatus();
				actual = String.valueOf(actual_removeprefix);
				sfassert.assertEquals(actual, expected);

				//Verifying Include Fares in Longsell CHD
				boolean actual_chdfare = recipientsearch.getGeneralDetailsCheckboxData(6, 4, 1);
				actual = String.valueOf(actual_chdfare);
				sfassert.assertEquals(actual, expected);
				
				//Verifying Include Fares in Longsell INF
				boolean actual_inffare = recipientsearch.getGeneralDetailsCheckboxData(6, 4, 2);
				actual = String.valueOf(actual_inffare);
				sfassert.assertEquals(actual, expected);
			
		
			//Feature Details section :
			
				//Verifying FTP Location
				expected = sftplocation_update;
				actual = recipientsearch.getFTPDetailsSectionData(1, 2);
				sfassert.assertEquals(actual, expected);
				
				//Verifying FTP UserName
				expected = sftpusername_update;
				actual = recipientsearch.getFTPDetailsSectionData(3, 2);
				sfassert.assertEquals(actual, expected);
				
				//Verifying FTP Password
				expected = sftppassword_update;
				actual = recipientsearch.getFTPDetailsSectionData(4, 2);
				sfassert.assertEquals(actual, expected);
				

			// soft assert
			sfassert.assertAll();
		}
		catch (AssertionError | Exception e)
		{
			ex.TakeScreenshotAndLogException(e.getMessage());
		}
	}

	
	/* Test 3 : Verify that user can Inactive User record successfully */   
	@Test(priority = 3, dependsOnMethods = { "recipient_Update" })
	public void recipient_Inactive() throws IOException {
		try {
			// Step 1 = Searching for added recipient and inactivating recipient
			Reporter.log("Step 1 = Searching for added recipient and inactivating recipient");
			navigationlib.menu_ClickOnRecipientManagement();
			recipientsearch.search_SearchActiveRecipientWithRecipientName(recipientname);
			
			String status = "Inactive";
			recipientsetupadd.recipient_changeStatus(status);
			navigationlib.logout();	
			
			// Step 2 = Verify the inactive recipient is showing in Inactive recipient list
			Reporter.log("Step 2 = Verify the inactive recipient is showing in Inactive recipient list");
			loginlib.loginToApplication(Constants.LIVE_URL, Constants.LIVE_USERNAME, Constants.LIVE_PASSWORD);
			navigationlib.menu_ClickOnRecipientManagement();
			recipientsearch.search_SearchInactiveRecipientWithRecipientName(recipientname);
				
			//Grid data :
			
				//Verifying Recipient Name
				expected = recipientname;
				actual = recipientsearch.getRecipientGridData(2, 4);
				sfassert.assertEquals(actual, expected);
			
				//Verifying FTP Path
				expected = sftplocation_update;
				actual = recipientsearch.getRecipientGridData(2, 5);
				sfassert.assertEquals(actual, expected);
			
				//Verifying Email
				expected = email;
				actual = recipientsearch.getRecipientGridData(2, 6);
				sfassert.assertEquals(actual, expected);
				
				//Verifying Priority
				expected = priority_update;
				actual = recipientsearch.getRecipientGridData(2, 7);
				sfassert.assertEquals(actual, expected);
				
				
			// soft assert
			sfassert.assertAll();
		}
		catch (AssertionError | Exception e)
		{
			ex.TakeScreenshotAndLogException(e.getMessage());
		}
	}
	
	
	/* Test 4 : Verify that user Delete recipient record successfully */    
	@Test(priority = 4, dependsOnMethods = { "recipient_Inactive" })
	public void recipient_Delete() throws IOException {
		try {
			// Step 1 = Searching for added & inactivated recipient and Deleting it
			Reporter.log("Step 1 = Searching for added & inactivated recipient and Deleting it");
			navigationlib.menu_ClickOnRecipientManagement();
			recipientsearch.search_SearchAllRecipientWithRecipientName(recipientname);
			recipientsetupadd.recipient_deleteRecord();

			// Step 2 = Verify the deleted recipient record is not present, it display on screen after select 'Include deleted records' option
			Reporter.log("Step 2 = Verify the deleted recipient record is not present, it display on screen after select 'Include deleted records' option");
			navigationlib.menu_ClickOnRecipientManagement();
			recipientsearch.search_userWithUserName(recipientname);

				//Verifying No Record Message
				expected = norecord_msg;
				actual = recipientsearch.search_GetNoRecordMsgText();
				sfassert.assertEquals(actual, expected);
			
			common.checkbox_includeDeleteRecord();
			
			//Grid data :
			
				//Verifying Recipient Name
				expected = recipientname;
				actual = recipientsearch.getRecipientGridData(2, 4);
				sfassert.assertEquals(actual, expected);
			
				//Verifying FTP Path
				expected = sftplocation_update;
				actual = recipientsearch.getRecipientGridData(2, 5);
				sfassert.assertEquals(actual, expected);
			
				//Verifying Email
				expected = email;
				actual = recipientsearch.getRecipientGridData(2, 6);
				sfassert.assertEquals(actual, expected);
				
				//Verifying Priority
				expected = priority_update;
				actual = recipientsearch.getRecipientGridData(2, 7);
				sfassert.assertEquals(actual, expected);
				
			
			// Step 3 = Verify the deleted recipient record is not present, after uncheck 'Include deleted records' option"
			Reporter.log("Step 3 = Verify the deleted recipient record is not present, after uncheck 'Include deleted records' option");
			common.checkbox_includeDeleteRecord();
			
				//Verifying No Record Message
				expected = norecord_msg;
				actual = recipientsearch.search_GetNoRecordMsgText();
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