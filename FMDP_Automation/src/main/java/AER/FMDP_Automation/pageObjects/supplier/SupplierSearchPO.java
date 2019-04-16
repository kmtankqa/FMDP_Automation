package AER.FMDP_Automation.pageObjects.supplier;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import AER.FMDP_Automation.pageObjects.common.CommonPO;
import AER.FMDP_Automation.pageObjects.common.ItemListPO;
import utilities.Constants;
import utilities.JavaHelpers;
import utilities.SeleniumHelpers;

public class SupplierSearchPO 
{
	WebDriver driver;
	SeleniumHelpers selenium;
	CommonPO help;
	ItemListPO list;
	JavaHelpers java;
	
	public SupplierSearchPO(WebDriver driver)
	{	 
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);
        help = new CommonPO(driver);
        list = new ItemListPO(driver);
        java = new JavaHelpers();

        //This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, Constants.PAGEFACTORY_WAIT_DURATION), this);
	}
	
	
	/*
	 * All WebElements are identified by @FindBy annotation
	 * @FindBy can accept tagName, partialLinkText, name, linkText, id, css, className, xpath as attributes.
	 */ 
	
		
		//Search Criteria Section :	
		
			@FindBy(id="txtSupplierId")
			private WebElement supplierId;
			
			@FindBy(id="txtSupplierName")
			private WebElement supplierName;
		
			@FindBy(id="chkboxActiveSuppliers")
			private WebElement checkboxActiveSuppliers;
		
			@FindBy(id="chkboxInActiveSuppliers")
			private WebElement checkboxInActiveSuppliers;
			
			@FindBy(id="chkboxLstFareTypes_0")
			private WebElement checkboxNetFareType;
			
			@FindBy(id="chkboxLstFareTypes_1")
			private WebElement checkboxTouropFareType;
			
			@FindBy(id="chkboxLstFareTypes_2")
			private WebElement checkboxNegoFareType;
			
			@FindBy(id="chkboxLstFareTypes_3")
			private WebElement checkboxPublishedFareType;
		

			@FindBy(id="ddlImportHrs")
			private WebElement importhours;
			
			@FindBy(id="ddlImportMin")
			private WebElement importminutes;
			
			@FindBy(id="ddlThresholdHours")
			private WebElement thresholdhours;
						
			
			//File Location
			@FindBy(id="txtImportTargetLocation")
			private WebElement fileLocation;
		
			
		//Search Criteria :
			
			public void search_enterSupplierID(String supplierid)
			{
				supplierId.clear();
				supplierId.sendKeys(supplierid);
			}
		
			public void search_enterSupplierName(String suppliername)
			{
				supplierName.clear();
				supplierName.sendKeys(suppliername);
			}
			
			public void search_selectCheckboxActiveSupplier()
			{
				if(!checkboxActiveSuppliers.isSelected())
				{
					checkboxActiveSuppliers.click();
				}
			}
			
			public void search_deselectCheckboxActiveSupplier()
			{
				if(checkboxActiveSuppliers.isSelected())
				{
					checkboxActiveSuppliers.click();
				}
			}
			
			public void search_selectCheckboxInactiveSupplier()
			{
				if(!checkboxInActiveSuppliers.isSelected())
				{
					checkboxInActiveSuppliers.click();
				}
			}
			
			public void search_deselectCheckboxInactiveSupplier()
			{
				if(checkboxInActiveSuppliers.isSelected())
				{
					checkboxInActiveSuppliers.click();
				}
			}
			
			public void search_selectCheckboxNetFareType()
			{
				if(!checkboxNetFareType.isSelected())
				{
					checkboxNetFareType.click();
				}
			}
			
			public void search_selectCheckboxTouropFareType()
			{
				if(!checkboxTouropFareType.isSelected())
				{
					checkboxTouropFareType.click();
				}
			}
			
			public void search_selectCheckboxNegoFareType()
			{
				if(!checkboxNegoFareType.isSelected())
				{
					checkboxNegoFareType.click();
				}
			}
			
			public void search_selectCheckboxPublishedFareType()
			{
				if(!checkboxPublishedFareType.isSelected())
				{
					checkboxPublishedFareType.click();
				}
			}
			
			
	//Search :
			
		//General Details section
			
			//Name, contact no, email, address1, address2, city, country, state, file name 
			public String getGeneralDetailsSectionData(int row, int column)
			{
				String cssSelector = ".basic-info-box.form-box table tbody tr:nth-of-type(" + row + ") td:nth-of-type(" + column + ") > input";
				return selenium.waitTillElementIsVisible(By.cssSelector(cssSelector)).getAttribute("value").trim();
			}
			
			public boolean getGeneralDetailsFareTypesAndGDSData(int row, int column, int list)
			{
				String cssSelector = ".basic-info-box.form-box table tbody tr:nth-of-type(" + row + ") td:nth-of-type(" + column + ") li:nth-of-type(" + list + ") input";
				return selenium.waitTillElementIsVisible(By.cssSelector(cssSelector)).isSelected();
			}
			
			public boolean getGeneralDetailsFlightTypeAndFilterNoBagFareData(int row, int column, int list)
			{
				String cssSelector = ".basic-info-box.form-box table tbody tr:nth-of-type(" + row + ") td:nth-of-type(" + column + ") input:nth-of-type(" + list + ")";
				return selenium.waitTillElementIsVisible(By.cssSelector(cssSelector)).isSelected();
			}
	
		
		//EDF Import Details section
			
			public boolean getEDFImportDetailsSectionData(int row, int column, int list)
			{
				String cssSelector = ".travell-box.form-box > .noPadding tbody tr:nth-of-type(" + row + ") td:nth-of-type(" + column + ") input:nth-of-type(" + list + ")";
				return selenium.waitTillElementIsVisible(By.cssSelector(cssSelector)).isSelected();
			}
			
			public String getEDFImportDetailsSectionPercentageAndDaysFieldData(int row, int column, int list)
			{
				String cssSelector = ".travell-box.form-box > .noPadding tbody tr:nth-of-type(" + row + ") td:nth-of-type(" + column + ") input:nth-of-type(" + list + ")";
				return selenium.waitTillElementIsVisible(By.cssSelector(cssSelector)).getAttribute("value").trim();
			}

			public String getSelectedHourDropdownValue()
			{
				return selenium.getSelectedDropdownValue(importhours);
			}
			
			public String getSelectedMinuteDropdownValue()
			{
				return selenium.getSelectedDropdownValue(importminutes);
			}
			
			public String getSelectedThresholdHoursDropdownValue()
			{
				return selenium.getSelectedDropdownValue(thresholdhours);
			}
						
			
		//FTP Details
			
			public String getFTPDetailsSectionData(int row, int column)
			{
				String cssSelector = ".ftpDetail > table tbody tr:nth-of-type(" + row + ") td:nth-of-type(" + column + ") input";
				return selenium.waitTillElementIsVisible(By.cssSelector(cssSelector)).getAttribute("value").trim();
			}
			
			public boolean getFTPDetailsSectionData(int row, int column, int input)
			{
				String cssSelector = ".ftpDetail > table tbody tr:nth-of-type(" + row + ") td:nth-of-type(" + column + ") span:nth-of-type(" + input + ") input";
				return selenium.waitTillElementIsVisible(By.cssSelector(cssSelector)).isSelected();
			}
			
			public String getEDFPathDetails()
			{
				return fileLocation.getAttribute("value").trim();
			}
			
		
		//Grid Data
			
			public String getSupplierGridData(int row, int column)
			{
				String cssSelector = "[id='griddata'] table tbody tr:nth-of-type(" + row + ") td:nth-of-type(" + column + ")";
				return selenium.waitTillElementIsVisible(By.cssSelector(cssSelector)).getText().trim();
			}
			
			
}

