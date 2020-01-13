package AER.FMDP_Automation.tests.distribution;

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
import AER.FMDP_Automation.functionalLibrary.distribution.DistributionRequestSetupLib;
import AER.FMDP_Automation.functionalLibrary.login.LoginLib;
import AER.FMDP_Automation.functionalLibrary.supplier.SupplierSearchLib;
import utilities.Constants;
import utilities.ExceptionHandler;
import utilities.JavaHelpers;
import utilities.SeleniumHelpers;
import utilities.WebDriverManager;

public class DistributionRequestTests {
	private WebDriver driver;
	private WebDriverManager drivermanager;
	private LoginLib loginlib;
	private TopNavigationLib navigationlib;
	private CommonLib common;
	private JavaHelpers javahelp;
	private SeleniumHelpers selenium;
	private DistributionRequestSetupLib distributionrequestsetupadd;
	private SupplierSearchLib suppliersearch;
	private SoftAssert sfassert;
	private String expected;
	private String actual;
	private ExceptionHandler ex;

	// Test Data
	private String timeStamp;
	private String propertyFile = "test-input/distributionrequest.properties";

	private int recipient_create = Integer.parseInt(JavaHelpers.getPropertyValue(propertyFile, "recipient_create"));
	private int executeonhour_create = Integer
			.parseInt(JavaHelpers.getPropertyValue(propertyFile, "executeonhour_create"));
	private int executeonminute_create = Integer
			.parseInt(JavaHelpers.getPropertyValue(propertyFile, "executeonminute_create"));
	private String exportformat_create = JavaHelpers.getPropertyValue(propertyFile, "exportformat_create");
	private String flighttype_create = JavaHelpers.getPropertyValue(propertyFile, "flighttype_create");
	private String usedataimportedhour_create = JavaHelpers.getPropertyValue(propertyFile,
			"usedataimportedhour_create");
	private String filename_create = JavaHelpers.getPropertyValue(propertyFile, "filename_create");
	private String filename;
	private String excludesuffix_create = JavaHelpers.getPropertyValue(propertyFile, "excludesuffix_create");
	private String faretype_create = JavaHelpers.getPropertyValue(propertyFile, "faretype_create");
	private String source_create = JavaHelpers.getPropertyValue(propertyFile, "source_create");
	private String officeid_create = JavaHelpers.getPropertyValue(propertyFile, "officeid_create");
	private String corporatecode_create = JavaHelpers.getPropertyValue(propertyFile, "corporatecode_create");
	private String airlines_create = JavaHelpers.getPropertyValue(propertyFile, "airlines_create");
	private String excludeairline_create = JavaHelpers.getPropertyValue(propertyFile, "excludeairline_create");
	private String maxfare_create = JavaHelpers.getPropertyValue(propertyFile, "maxfare_create");
	private String minfare_create = JavaHelpers.getPropertyValue(propertyFile, "minfare_create");
	private String maxlayover_create = JavaHelpers.getPropertyValue(propertyFile, "maxlayover_create");
	private String minlayover_create = JavaHelpers.getPropertyValue(propertyFile, "minlayover_create");
	private String ftplocation_create = JavaHelpers.getPropertyValue(propertyFile, "ftplocation_create");
	private String ftpusername_create = JavaHelpers.getPropertyValue(propertyFile, "ftpusername_create");
	private String ftppassword_create = JavaHelpers.getPropertyValue(propertyFile, "ftppassword_create");

	private String ftptype;
	private String norecord_msg = JavaHelpers.getPropertyValue(propertyFile, "norecord_msg");

	@BeforeClass
	@Parameters({ "node", "browser", "headless" })
	public void setUp(@Optional("local") String node, @Optional("chrome") String browser,
			@Optional("true") boolean headless) throws Exception {
		drivermanager = new WebDriverManager();
		driver = drivermanager.setUp(node, browser, headless);
		loginlib = new LoginLib(driver);
		navigationlib = new TopNavigationLib(driver);
		common = new CommonLib(driver);
		javahelp = new JavaHelpers();
		selenium = new SeleniumHelpers(driver);
		distributionrequestsetupadd = new DistributionRequestSetupLib(driver);
		suppliersearch = new SupplierSearchLib(driver);
	}

	@BeforeMethod
	public void beforeMethod() {
		sfassert = new SoftAssert();
		timeStamp = javahelp.timeStamp();
		ex = new ExceptionHandler(driver);
	}

	/* Test 1 : Verify that user can add new Recipient record successfully */
	@Test(priority = 1)
	public void distribution_Add() throws IOException {
		try {

			// Step 1 = Navigating and Logging in to Live Application
			Reporter.log("Step 1 = Login to application at : " + Constants.LIVE_URL
					+ " and loging in with correct credentails");
			loginlib.loginToApplication(Constants.LIVE_URL, Constants.LIVE_USERNAME, Constants.LIVE_PASSWORD);

			// Step 2 = Opening Menu & Navigating to Recipient Management and Open Create
			// New Recipient screen
			Reporter.log("Step 2 = Opening Menu & Navigating to Recipient Management and Open Create New Recipient screen");
			navigationlib.menu_ClickOnDistributionSummary();
			distributionrequestsetupadd.clickOnCreateNewDistributionRequestBtn();
			
			// Step 3 = On Create New Recipient page, adding details, click on Save button
			Reporter.log("Step 3 = On Create New Recipient page, adding details, click on Save button");
			filename = filename_create + timeStamp;
			ftptype = "ftp";
			distributionrequestsetupadd.distributionRequest_GeneraDetails_Add(recipient_create, executeonhour_create,
					executeonminute_create, exportformat_create, flighttype_create, usedataimportedhour_create,
					filename, faretype_create, source_create, officeid_create, corporatecode_create);
			distributionrequestsetupadd.distributionRequest_FlightDetails_Add(airlines_create, excludeairline_create,
					maxfare_create, minfare_create, maxlayover_create, minlayover_create, exportformat_create,
					flighttype_create);
			distributionrequestsetupadd.distributionRequest_FTPAndEDFPathDetails_Add(ftptype, ftplocation_create,
					ftpusername_create, ftppassword_create);
			common.popup_ClickOnSuccessOk();
			

			// Step 2 = Searching for edited Recipient record and verifying that it has
			// correct details
			Reporter.log("Step 4 = Searching for added Recipient record and verifying that it has correct details");
			/*
			 * navigationlib.menu_ClickOnDistributionSummary();
			 * suppliersearch.search_SearchActiveSupplierWithSupplierNameAndFareType(
			 * suppliername, faretype_create);
			 * 
			 * //Grid data :
			 * 
			 * //Verifying Recipient Name expected = suppliername; actual =
			 * suppliersearch.getSupplierGridData(2, 6); sfassert.assertEquals(actual,
			 * expected);
			 * 
			 * //Verifying FTP Path expected = ftplocation_create; actual =
			 * suppliersearch.getSupplierGridData(2, 7); sfassert.assertEquals(actual,
			 * expected);
			 * 
			 * // Step 4 = Searching for added Recipient record and verifying that it has
			 * correct details Reporter.
			 * log("Step 4 = Searching for added Recipient record and verifying that it has correct details"
			 * ); navigationlib.menu_ClickOnSupplierManagement();
			 * suppliersearch.search_SearchActiveSupplierWithSupplierNameAndClick(
			 * suppliername);
			 * 
			 * //General Details section :
			 * 
			 * //Verifying Supplier Name expected = suppliername; actual =
			 * suppliersearch.getGeneralDetailsSectionData(1, 2);
			 * sfassert.assertEquals(actual, expected);
			 * 
			 * //Verifying Fare Type expected = "true"; boolean actual_faretype =
			 * suppliersearch.getGeneralDetailsFareTypesAndGDSData(2, 2, 2); actual =
			 * String.valueOf(actual_faretype); sfassert.assertEquals(actual, expected);
			 * 
			 * //Verifying Source expected = source_create; actual =
			 * suppliersearch.getGeneralDetailsSectionData(4, 2);
			 * sfassert.assertEquals(actual, expected);
			 * 
			 * //Verifying Office ID expected = officeid_create; actual =
			 * suppliersearch.getGeneralDetailsSectionData(6, 2);
			 * sfassert.assertEquals(actual, expected);
			 * 
			 * //Verifying Corporate Code expected = corporatecode_create; actual =
			 * suppliersearch.getGeneralDetailsSectionData(7, 2);
			 * sfassert.assertEquals(actual, expected);
			 * 
			 * //Verifying GDS expected = "true"; boolean actual_gds =
			 * suppliersearch.getGeneralDetailsFareTypesAndGDSData(8, 2, 3); actual =
			 * String.valueOf(actual_gds); sfassert.assertEquals(actual, expected);
			 * 
			 * //Verifying Flight Type boolean actual_flighttype =
			 * suppliersearch.getGeneralDetailsFlightTypeAndFilterNoBagFareData(9, 2, 2);
			 * actual = String.valueOf(actual_flighttype); sfassert.assertEquals(actual,
			 * expected);
			 * 
			 * //Verifying Filter No Bag Fare boolean actual_filternobagfare =
			 * suppliersearch.getGeneralDetailsFlightTypeAndFilterNoBagFareData(10, 2, 1);
			 * actual = String.valueOf(actual_filternobagfare);
			 * sfassert.assertEquals(actual, expected);
			 * 
			 * //EDF Import Details section :
			 * 
			 * //Verifying Frequency expected = frequency_create; boolean actual_frequency =
			 * suppliersearch.getEDFImportDetailsSectionData(1, 2, 1); actual =
			 * String.valueOf(actual_frequency); sfassert.assertEquals(actual, expected);
			 * 
			 * //Verifying Delete File Checkbox expected = "true"; boolean
			 * actual_chkdeletefile = suppliersearch.getEDFImportDetailsSectionData(2, 2,
			 * 1); actual = String.valueOf(actual_chkdeletefile);
			 * sfassert.assertEquals(actual, expected);
			 * 
			 * //Verifying Notify Administrator Checkbox for Size Vary boolean
			 * actual_chksizevarynotify = suppliersearch.getEDFImportDetailsSectionData(3,
			 * 2, 1); actual = String.valueOf(actual_chksizevarynotify);
			 * sfassert.assertEquals(actual, expected);
			 * 
			 * //Verifying Percentage expected = sizevarypercentage_create; actual =
			 * suppliersearch.getEDFImportDetailsSectionPercentageAndDaysFieldData(3, 2, 2);
			 * sfassert.assertEquals(actual, expected);
			 * 
			 * //Verifying Notify Administrator Checkbox for File Not Received boolean
			 * actual_chkfilenotreceivenotify =
			 * suppliersearch.getEDFImportDetailsSectionData(4, 2, 1); actual =
			 * String.valueOf(actual_chkfilenotreceivenotify); sfassert.assertEquals(actual,
			 * expected);
			 * 
			 * //Verifying Days expected = filenotreceiveddays_create; actual =
			 * suppliersearch.getEDFImportDetailsSectionPercentageAndDaysFieldData(4, 2, 2);
			 * sfassert.assertEquals(actual, expected);
			 * 
			 * //Verifying Data Retention expected = dataretention_create; actual =
			 * suppliersearch.getEDFImportDetailsSectionPercentageAndDaysFieldData(5, 2, 1);
			 * sfassert.assertEquals(actual, expected);
			 * 
			 * //Verifying Hours expected = hours_create; actual =
			 * suppliersearch.getSelectedHourDropdownValue(); sfassert.assertEquals(actual,
			 * expected);
			 * 
			 * //Verifying Retain Old Data expected = thresoldhour_create; actual =
			 * suppliersearch.getSelectedThresholdHoursDropdownValue();
			 * sfassert.assertEquals(actual, expected);
			 * 
			 * //FTP and EDF Path Details section :
			 * 
			 * //Verifying FTP Location expected = ftplocation_create; actual =
			 * suppliersearch.getFTPDetailsSectionData(1, 2); sfassert.assertEquals(actual,
			 * expected);
			 * 
			 * //Verifying Use SSL/TLS Encryption expected = "true"; boolean actual_ssl =
			 * suppliersearch.getFTPDetailsSectionData(2, 2, 1); actual =
			 * String.valueOf(actual_ssl); sfassert.assertEquals(actual, expected);
			 * 
			 * //Verifying Passive Transfer Mode expected = "true"; boolean actual_mode =
			 * suppliersearch.getFTPDetailsSectionData(2, 2, 3); actual =
			 * String.valueOf(actual_mode); sfassert.assertEquals(actual, expected);
			 * 
			 * //Verifying FTP UserName expected = ftpusername_create; actual =
			 * suppliersearch.getFTPDetailsSectionData(3, 2); sfassert.assertEquals(actual,
			 * expected);
			 * 
			 * //Verifying FTP Password expected = ftppassword_create; actual =
			 * suppliersearch.getFTPDetailsSectionData(4, 2); sfassert.assertEquals(actual,
			 * expected);
			 * 
			 * //Verifying File Pattern expected = filepattern; actual =
			 * suppliersearch.getFTPDetailsSectionData(1, 4); sfassert.assertEquals(actual,
			 * expected);
			 * 
			 * //Verifying File Location expected = filelocation_create; actual =
			 * suppliersearch.getEDFPathDetails(); sfassert.assertEquals(actual, expected);
			 * 
			 */
			// soft assert
			sfassert.assertAll();

			System.out.println("QA two");

		} catch (AssertionError | Exception e) {
			ex.TakeScreenshotAndLogException(e.getMessage());
		}

	}

	/*
	 * Test 2 : Verify that user can edit Recipient details successfully
	 * 
	 * @Test(priority = 2, dependsOnMethods = { "supplier_Add" }) public void
	 * supplier_Update() throws IOException { try { // Step 1 = Editing details of
	 * added Recipient record, click on Save button Reporter.
	 * log("Step 1 = Editing details of added User record, click on Save button");
	 * selenium.refreshPage(); suppliername = suppliername_create + timeStamp;
	 * filepattern = filepattern_update + "-" + officeid_update + "-" +
	 * corporatecode_update + "-*"; ftptype = "sftp";
	 * 
	 * suppliersetupadd.supplierManagement_GeneraDetails_Add(suppliername,
	 * faretype_update, source_update, officeid_update, corporatecode_update,
	 * gds_update, flighttype_update);
	 * suppliersetupadd.supplierManagement_EDFImportDetails_Add(frequency_update,
	 * sizevarypercentage_update, filenotreceiveddays_update, hours_update,
	 * minutes_update, "", dataretention_update);
	 * suppliersetupadd.supplierManagement_FTPAndEDFPathDetails_Add(ftptype,
	 * sftplocation_update, sftpusername_update, sftppassword_update, filepattern,
	 * filelocation_update);
	 * 
	 * common.popup_ClickOnSuccessOk();
	 * 
	 * // Step 2 = Searching for edited Recipient record and verifying that it has
	 * correct details Reporter.
	 * log("Step 4 = Searching for added Recipient record and verifying that it has correct details"
	 * ); navigationlib.menu_ClickOnSupplierManagement();
	 * suppliersearch.search_SearchActiveSupplierWithSupplierNameAndFareType(
	 * suppliername, faretype_update);
	 * 
	 * //Grid data :
	 * 
	 * //Verifying Recipient Name expected = suppliername; actual =
	 * suppliersearch.getSupplierGridData(2, 6); sfassert.assertEquals(actual,
	 * expected);
	 * 
	 * //Verifying FTP Path expected = sftplocation_update; actual =
	 * suppliersearch.getSupplierGridData(2, 7); sfassert.assertEquals(actual,
	 * expected);
	 * 
	 * // Step 2 = Searching for edited Recipient record and verifying that it has
	 * correct details Reporter.
	 * log("Step 4 = Searching for added Recipient record and verifying that it has correct details"
	 * ); navigationlib.menu_ClickOnSupplierManagement();
	 * suppliersearch.search_SearchActiveSupplierWithSupplierNameAndClick(
	 * suppliername);
	 * 
	 * //General Details section :
	 * 
	 * //Verifying Supplier Name expected = suppliername; actual =
	 * suppliersearch.getGeneralDetailsSectionData(1, 2);
	 * sfassert.assertEquals(actual, expected);
	 * 
	 * //Verifying Fare Type expected = "true"; boolean actual_faretype =
	 * suppliersearch.getGeneralDetailsFareTypesAndGDSData(2, 2, 4); actual =
	 * String.valueOf(actual_faretype); sfassert.assertEquals(actual, expected);
	 * 
	 * //Verifying Source expected = source_update; actual =
	 * suppliersearch.getGeneralDetailsSectionData(4, 2);
	 * sfassert.assertEquals(actual, expected);
	 * 
	 * //Verifying Office ID expected = officeid_update; actual =
	 * suppliersearch.getGeneralDetailsSectionData(6, 2);
	 * sfassert.assertEquals(actual, expected);
	 * 
	 * //Verifying Corporate Code expected = corporatecode_update; actual =
	 * suppliersearch.getGeneralDetailsSectionData(7, 2);
	 * sfassert.assertEquals(actual, expected);
	 * 
	 * //Verifying GDS expected = "true"; boolean actual_gds =
	 * suppliersearch.getGeneralDetailsFareTypesAndGDSData(8, 2, 2); actual =
	 * String.valueOf(actual_gds); sfassert.assertEquals(actual, expected);
	 * 
	 * //Verifying Flight Type boolean actual_flighttype =
	 * suppliersearch.getGeneralDetailsFlightTypeAndFilterNoBagFareData(9, 2, 1);
	 * actual = String.valueOf(actual_flighttype); sfassert.assertEquals(actual,
	 * expected);
	 * 
	 * //Verifying Filter No Bag Fare expected = "false"; boolean
	 * actual_filternobagfare =
	 * suppliersearch.getGeneralDetailsFlightTypeAndFilterNoBagFareData(10, 2, 1);
	 * actual = String.valueOf(actual_filternobagfare);
	 * sfassert.assertEquals(actual, expected);
	 * 
	 * //EDF Import Details section :
	 * 
	 * //Verifying Frequency expected = "true"; boolean actual_frequency =
	 * suppliersearch.getEDFImportDetailsSectionData(1, 2, 2); actual =
	 * String.valueOf(actual_frequency); sfassert.assertEquals(actual, expected);
	 * 
	 * //Verifying Delete File Checkbox boolean actual_chkdeletefile =
	 * suppliersearch.getEDFImportDetailsSectionData(2, 2, 1); actual =
	 * String.valueOf(actual_chkdeletefile); sfassert.assertEquals(actual,
	 * expected);
	 * 
	 * //Verifying Notify Administrator Checkbox for Size Vary boolean
	 * actual_chksizevarynotify = suppliersearch.getEDFImportDetailsSectionData(3,
	 * 2, 1); actual = String.valueOf(actual_chksizevarynotify);
	 * sfassert.assertEquals(actual, expected);
	 * 
	 * //Verifying Percentage expected = sizevarypercentage_create; actual =
	 * suppliersearch.getEDFImportDetailsSectionPercentageAndDaysFieldData(3, 2, 2);
	 * sfassert.assertEquals(actual, expected);
	 * 
	 * //Verifying Notify Administrator Checkbox for File Not Received expected =
	 * "true"; boolean actual_chkfilenotreceivenotify =
	 * suppliersearch.getEDFImportDetailsSectionData(4, 2, 1); actual =
	 * String.valueOf(actual_chkfilenotreceivenotify); sfassert.assertEquals(actual,
	 * expected);
	 * 
	 * //Verifying Days expected = filenotreceiveddays_create; actual =
	 * suppliersearch.getEDFImportDetailsSectionPercentageAndDaysFieldData(4, 2, 2);
	 * sfassert.assertEquals(actual, expected);
	 * 
	 * //Verifying Data Retention expected = dataretention_create; actual =
	 * suppliersearch.getEDFImportDetailsSectionPercentageAndDaysFieldData(5, 2, 1);
	 * sfassert.assertEquals(actual, expected);
	 * 
	 * //Verifying Hours expected = hours_create; actual =
	 * suppliersearch.getSelectedHourDropdownValue(); sfassert.assertEquals(actual,
	 * expected);
	 * 
	 * //Verifying Minutes expected = minutes_update; actual =
	 * suppliersearch.getSelectedMinuteDropdownValue();
	 * sfassert.assertEquals(actual, expected);
	 * 
	 * //FTP and EDF Path Details section :
	 * 
	 * //Verifying FTP Location expected = sftplocation_update; actual =
	 * suppliersearch.getFTPDetailsSectionData(1, 2); sfassert.assertEquals(actual,
	 * expected);
	 * 
	 * //Verifying FTP UserName expected = sftpusername_update; actual =
	 * suppliersearch.getFTPDetailsSectionData(3, 2); sfassert.assertEquals(actual,
	 * expected);
	 * 
	 * //Verifying FTP Password expected = sftppassword_update; actual =
	 * suppliersearch.getFTPDetailsSectionData(4, 2); sfassert.assertEquals(actual,
	 * expected);
	 * 
	 * //Verifying File Pattern expected = filepattern; actual =
	 * suppliersearch.getFTPDetailsSectionData(1, 4); sfassert.assertEquals(actual,
	 * expected);
	 * 
	 * //Verifying File Location expected = filelocation_update; actual =
	 * suppliersearch.getEDFPathDetails(); sfassert.assertEquals(actual, expected);
	 * 
	 * 
	 * // soft assert sfassert.assertAll(); } catch (AssertionError | Exception e) {
	 * ex.TakeScreenshotAndLogException(e.getMessage()); } }
	 * 
	 * 
	 * Test 3 : Verify that user can copy existing Recipient record successfully
	 * 
	 * @Test(priority = 3, dependsOnMethods = { "supplier_Update" }) public void
	 * supplier_Copy() throws IOException { try { // Step 1 = Search existing record
	 * and Copy supplier, click on Save button Reporter.
	 * log("Step 1 = Search existing record and Copy supplier, click on Save button"
	 * ); navigationlib.menu_ClickOnSupplierManagement();
	 * suppliersearch.search_SearchActiveSupplierWithSupplierName(suppliername);
	 * suppliersetupadd.supplier_copyRecord(); suppliername_copy =
	 * suppliername_create + timeStamp;
	 * suppliersetupadd.enterSupplierName(suppliername_copy);
	 * common.popup_ClickOnSuccessOk();
	 * 
	 * // Step 2 = Searching for Copied Recipient record and verifying that it is
	 * added successfully Reporter.
	 * log("Step 2 = Searching for Copied Recipient record and verifying that it is added successfully"
	 * ); navigationlib.menu_ClickOnSupplierManagement();
	 * suppliersearch.search_SearchActiveSupplierWithSupplierName(suppliername_copy)
	 * ;
	 * 
	 * //Grid data :
	 * 
	 * //Verifying Recipient Name expected = suppliername_copy; actual =
	 * suppliersearch.getSupplierGridData(2, 6); sfassert.assertEquals(actual,
	 * expected);
	 * 
	 * //Verifying FTP Path expected = sftplocation_update; actual =
	 * suppliersearch.getSupplierGridData(2, 7); sfassert.assertEquals(actual,
	 * expected);
	 * 
	 * // Step 3 = Searching for Copied Recipient record and verifying that it has
	 * correct details Reporter.
	 * log("Step 3 = Searching for Copied Recipient record and verifying that it has correct details"
	 * ); navigationlib.menu_ClickOnSupplierManagement();
	 * suppliersearch.search_SearchActiveSupplierWithSupplierNameAndClick(
	 * suppliername_copy);
	 * 
	 * //General Details section :
	 * 
	 * //Verifying Supplier Name expected = suppliername_copy; actual =
	 * suppliersearch.getGeneralDetailsSectionData(1, 2);
	 * sfassert.assertEquals(actual, expected);
	 * 
	 * //Verifying Fare Type expected = "true"; boolean actual_faretype =
	 * suppliersearch.getGeneralDetailsFareTypesAndGDSData(2, 2, 4); actual =
	 * String.valueOf(actual_faretype); sfassert.assertEquals(actual, expected);
	 * 
	 * //Verifying Source expected = source_update; actual =
	 * suppliersearch.getGeneralDetailsSectionData(4, 2);
	 * sfassert.assertEquals(actual, expected);
	 * 
	 * //Verifying Office ID expected = officeid_update; actual =
	 * suppliersearch.getGeneralDetailsSectionData(6, 2);
	 * sfassert.assertEquals(actual, expected);
	 * 
	 * //Verifying Corporate Code expected = corporatecode_update; actual =
	 * suppliersearch.getGeneralDetailsSectionData(7, 2);
	 * sfassert.assertEquals(actual, expected);
	 * 
	 * //Verifying GDS expected = "true"; boolean actual_gds =
	 * suppliersearch.getGeneralDetailsFareTypesAndGDSData(8, 2, 2); actual =
	 * String.valueOf(actual_gds); sfassert.assertEquals(actual, expected);
	 * 
	 * //Verifying Flight Type boolean actual_flighttype =
	 * suppliersearch.getGeneralDetailsFlightTypeAndFilterNoBagFareData(9, 2, 1);
	 * actual = String.valueOf(actual_flighttype); sfassert.assertEquals(actual,
	 * expected);
	 * 
	 * //Verifying Filter No Bag Fare expected = "false"; boolean
	 * actual_filternobagfare =
	 * suppliersearch.getGeneralDetailsFlightTypeAndFilterNoBagFareData(10, 2, 1);
	 * actual = String.valueOf(actual_filternobagfare);
	 * sfassert.assertEquals(actual, expected);
	 * 
	 * //EDF Import Details section :
	 * 
	 * //Verifying Frequency expected = "true"; boolean actual_frequency =
	 * suppliersearch.getEDFImportDetailsSectionData(1, 2, 2); actual =
	 * String.valueOf(actual_frequency); sfassert.assertEquals(actual, expected);
	 * 
	 * //Verifying Delete File Checkbox boolean actual_chkdeletefile =
	 * suppliersearch.getEDFImportDetailsSectionData(2, 2, 1); actual =
	 * String.valueOf(actual_chkdeletefile); sfassert.assertEquals(actual,
	 * expected);
	 * 
	 * //Verifying Notify Administrator Checkbox for Size Vary boolean
	 * actual_chksizevarynotify = suppliersearch.getEDFImportDetailsSectionData(3,
	 * 2, 1); actual = String.valueOf(actual_chksizevarynotify);
	 * sfassert.assertEquals(actual, expected);
	 * 
	 * //Verifying Percentage expected = sizevarypercentage_create; actual =
	 * suppliersearch.getEDFImportDetailsSectionPercentageAndDaysFieldData(3, 2, 2);
	 * sfassert.assertEquals(actual, expected);
	 * 
	 * //Verifying Notify Administrator Checkbox for File Not Received expected =
	 * "true"; boolean actual_chkfilenotreceivenotify =
	 * suppliersearch.getEDFImportDetailsSectionData(4, 2, 1); actual =
	 * String.valueOf(actual_chkfilenotreceivenotify); sfassert.assertEquals(actual,
	 * expected);
	 * 
	 * //Verifying Days expected = filenotreceiveddays_create; actual =
	 * suppliersearch.getEDFImportDetailsSectionPercentageAndDaysFieldData(4, 2, 2);
	 * sfassert.assertEquals(actual, expected);
	 * 
	 * //Verifying Data Retention expected = dataretention_create; actual =
	 * suppliersearch.getEDFImportDetailsSectionPercentageAndDaysFieldData(5, 2, 1);
	 * sfassert.assertEquals(actual, expected);
	 * 
	 * //Verifying Hours expected = hours_create; actual =
	 * suppliersearch.getSelectedHourDropdownValue(); sfassert.assertEquals(actual,
	 * expected);
	 * 
	 * //Verifying Minutes expected = minutes_update; actual =
	 * suppliersearch.getSelectedMinuteDropdownValue();
	 * sfassert.assertEquals(actual, expected);
	 * 
	 * //FTP and EDF Path Details section :
	 * 
	 * //Verifying FTP Location expected = sftplocation_update; actual =
	 * suppliersearch.getFTPDetailsSectionData(1, 2); sfassert.assertEquals(actual,
	 * expected);
	 * 
	 * //Verifying FTP UserName expected = sftpusername_update; actual =
	 * suppliersearch.getFTPDetailsSectionData(3, 2); sfassert.assertEquals(actual,
	 * expected);
	 * 
	 * //Verifying FTP Password expected = sftppassword_update; actual =
	 * suppliersearch.getFTPDetailsSectionData(4, 2); sfassert.assertEquals(actual,
	 * expected);
	 * 
	 * //Verifying File Pattern expected = filepattern; actual =
	 * suppliersearch.getFTPDetailsSectionData(1, 4); sfassert.assertEquals(actual,
	 * expected);
	 * 
	 * //Verifying File Location expected = filelocation_update; actual =
	 * suppliersearch.getEDFPathDetails(); sfassert.assertEquals(actual, expected);
	 * 
	 * 
	 * // soft assert sfassert.assertAll(); } catch (AssertionError | Exception e) {
	 * ex.TakeScreenshotAndLogException(e.getMessage()); } }
	 * 
	 * 
	 * Test 4 : Verify that user can Inactive User record successfully
	 * 
	 * @Test(priority = 4, dependsOnMethods = { "supplier_Update" }) public void
	 * supplier_Inactive() throws IOException { try { // Step 1 = Searching for
	 * added recipient and inactivating recipient Reporter.
	 * log("Step 1 = Searching for added recipient and inactivating recipient");
	 * navigationlib.menu_ClickOnSupplierManagement();
	 * suppliersearch.search_SearchActiveSupplierWithSupplierName(suppliername);
	 * 
	 * String status = "Inactive"; suppliersetupadd.supplier_changeStatus(status);
	 * navigationlib.logout();
	 * 
	 * // Step 2 = Verify the inactive recipient is showing in Inactive recipient
	 * list Reporter.
	 * log("Step 2 = Verify the inactive recipient is showing in Inactive recipient list"
	 * ); loginlib.loginToApplication(Constants.LIVE_URL, Constants.LIVE_USERNAME,
	 * Constants.LIVE_PASSWORD); navigationlib.menu_ClickOnSupplierManagement();
	 * suppliersearch.search_SearchInactiveSupplierWithSupplierName(suppliername);
	 * 
	 * //Grid data :
	 * 
	 * //Verifying Recipient Name expected = suppliername; actual =
	 * suppliersearch.getSupplierGridData(2, 6); sfassert.assertEquals(actual,
	 * expected);
	 * 
	 * //Verifying FTP Path expected = sftplocation_update; actual =
	 * suppliersearch.getSupplierGridData(2, 7); sfassert.assertEquals(actual,
	 * expected);
	 * 
	 * 
	 * // soft assert sfassert.assertAll(); } catch (AssertionError | Exception e) {
	 * ex.TakeScreenshotAndLogException(e.getMessage()); } }
	 * 
	 * 
	 * Test 5 : Verify that user Delete recipient record successfully
	 * 
	 * @Test(priority = 5, dependsOnMethods = { "supplier_Inactive" }) public void
	 * supplier_Delete() throws IOException { try { // Step 1 = Searching for added
	 * & inactivated recipient and Deleting it Reporter.
	 * log("Step 1 = Searching for added & inactivated recipient and Deleting it");
	 * navigationlib.menu_ClickOnSupplierManagement();
	 * suppliersearch.search_SearchAllSupplierWithSupplierName(suppliername);
	 * suppliersetupadd.supplier_deleteRecord();
	 * 
	 * // Step 2 = Verify the deleted recipient record is not present, it display on
	 * screen after select 'Include deleted records' option Reporter.
	 * log("Step 2 = Verify the deleted recipient record is not present, it display on screen after select 'Include deleted records' option"
	 * ); navigationlib.menu_ClickOnSupplierManagement();
	 * suppliersearch.search_userWithSupplierName(suppliername);
	 * 
	 * //Verifying No Record Message expected = norecord_msg; actual =
	 * suppliersearch.search_GetNoRecordMsgText(); sfassert.assertEquals(actual,
	 * expected);
	 * 
	 * common.checkbox_includeDeleteRecord();
	 * 
	 * //Grid data :
	 * 
	 * //Verifying Recipient Name expected = suppliername; actual =
	 * suppliersearch.getSupplierGridData(2, 6); sfassert.assertEquals(actual,
	 * expected);
	 * 
	 * //Verifying FTP Path expected = sftplocation_update; actual =
	 * suppliersearch.getSupplierGridData(2, 7); sfassert.assertEquals(actual,
	 * expected);
	 * 
	 * // Step 3 = Verify the deleted recipient record is not present, after uncheck
	 * 'Include deleted records' option" Reporter.
	 * log("Step 3 = Verify the deleted recipient record is not present, after uncheck 'Include deleted records' option"
	 * ); common.checkbox_includeDeleteRecord();
	 * 
	 * //Verifying No Record Message expected = norecord_msg; actual =
	 * suppliersearch.search_GetNoRecordMsgText(); sfassert.assertEquals(actual,
	 * expected);
	 * 
	 * // soft assert sfassert.assertAll(); } catch (AssertionError | Exception e) {
	 * ex.TakeScreenshotAndLogException(e.getMessage()); } }
	 */

	@AfterClass
	public void tearDown() throws Exception {
		drivermanager.tearDown();
	}

}