package AER.FMDP_Automation.functionalLibrary.common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import AER.FMDP_Automation.pageObjects.common.CommonPO;
import utilities.JavaHelpers;
import utilities.SeleniumHelpers;

public class CommonLib 
{
	WebDriver driver;
	SeleniumHelpers selenium;
	JavaHelpers java;
	CommonPO common;
	
	public CommonLib(WebDriver driver)
	{	 
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);
        java = new JavaHelpers(); 
        common = new CommonPO(driver);
	}
	
	/**
	 * Wait after login
	 */
	public void waitAfterLogin()
	{
		common.waitAfterLogin();
	}
	
	/**
	 * Wait till page loaded after doing any action on page
	 */
	public void waitTillPageLoaded()
	{
		common.waitTillPageLoaded();
	}
	
	
	/**
	 * Footer - Click on New button
	 */
	public void footer_ClickOnNewButton()
	{
		common.footer_ClickOnNewButton();
	}
	
	/**
	 * Footer - Click on Done button
	 */
	public void footer_ClickOnDone()
	{
		common.footer_ClickOnDone();
	}
	
	/**
	 * Footer - Click on Back button
	 */
	public void footer_ClickOnBack()
	{
		common.footer_ClickOnBack();
	}
	
	/**
	 * Footer - Click on Next button
	 */
	public void footer_ClickOnNext()
	{
		common.footer_ClickOnNext();
	}
	
	/**
	 * Footer - Click on Previous button
	 */
	public void footer_ClickOnPrevious()
	{
		common.footer_ClickOnPrevious();
	}
	
	/**
	 * Footer - Click on Task button
	 */
	public void footer_ClickOnTask()
	{
		common.footer_ClickOnTask();
	}
	
	/**
	 * Footer - Click on Break button
	 */
	public void footer_ClickOnBreak()
	{
		common.footer_ClickOnBreak();
	}
	
	/**
	 * Popup - Click on Error popup Ok button
	 */
	public void popup_ClickOnErrorOk()
	{
		common.popup_ClickOnErrorOk();
	}
	
	/**
	 * Popup - Click on Success popup Ok button
	 */
	public void popup_ClickOnSuccessOk()
	{
		common.popup_ClickOnSuccessOk();
	}
	
	/**
	 * Click on Save button
	 */
	public void btn_ClickOnSave()
	{
		common.btn_ClickOnSave();
	}
	
	/**
	 * Click on Cancel button
	 */
	public void btn_ClickOnCancel()
	{
		common.btn_ClickOnCancel();
	}
	
	/**
	 * Click on Search button
	 */
	public void btn_ClickOnSearch()
	{
		common.btn_ClickOnSearch();
	}
	
	/**
	 * Click on Reset button
	 */
	public void btn_ClickOnReset()
	{
		common.btn_ClickOnReset();
	}
	
	/**
	 * Click on Include Delete Record checkbox
	 */
	public void checkbox_includeDeleteRecord()
	{
		common.checkbox_includeDeleteRecord();
	}
	
	
	
	
	/**
	 * Get text from bottom right pop up
	 * @return text
	 */
	public String getValidationTextFromBottomRightPopUp()
	{
		return common.getValidationTextFromBottomRightPopUp();
	}
	
	/**
	 * Click on OK button on bottom right pop up
	 */
	public void validationBottomRightPopUp_ClickOnOk()
	{
		common.validationBottomRightPopUp_ClickOnOk();
	}
	
	/**
	 * Click on Yes button on bottom right pop up
	 */
	public void validationBottomRightPopUp_ClickOnYes() 
	{
		common.validationBottomRightPopUp_ClickOnYes();
	}
	
	
	/**
	 * Set toggle value
	 * @param toggle - WebElement of toggle
	 * @param isactive - WebElement to check whether toggle selected
	 * @param value - new toggle value
	 */
	public void setToggleValue(WebElement toggle, WebElement isactive, String value)
	{
		common.setToggleValue(toggle, isactive, value);
	}
	
}
