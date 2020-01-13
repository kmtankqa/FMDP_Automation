package AER.FMDP_Automation.pageObjects.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import io.qameta.allure.Step;
import utilities.Constants;
import utilities.JavaHelpers;
import utilities.SeleniumHelpers;

public class CommonPO 
{
	WebDriver driver;
	SeleniumHelpers selenium;
	JavaHelpers java;
	
	public CommonPO(WebDriver driver)
	{	 
        this.driver = driver;
        selenium = new SeleniumHelpers(driver);
        java = new JavaHelpers();
        //This initElements method will create all WebElements
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, Constants.PAGEFACTORY_WAIT_DURATION), this);
	}
	
	/*
	 * All WebElements are identified by @FindBy annotation
	 * @FindBy can accept tagName, partialLinkText, name, linkText, id, css, className, xpath as attributes.
	 */ 	
	
		//Common buttons
	
		//+New button
		@FindBy(id="add")
	    public WebElement newBtn;
		
		//Back button
		@FindBy(id="back")
	    public WebElement backBtn;
		
		//Done button
		@FindBy(id="submit")
	    public WebElement doneBtn;
		
		//Next button
		@FindBy(id="next")
		public WebElement nextBtn;
		
		//Previous button
		@FindBy(id="prev")
		public WebElement prevBtn;
		
		//Break button
		@FindBy(id="break")
		public WebElement breakBtn;
		
		//Task button
		@FindBy(id="task")
		public WebElement taskBtn;
		
		
		//Include deleted records checkbox
		@FindBy(id="MainContent_chkIncludeDeletedAsWell")
		private WebElement chkboxIncludeDeleteRecord;
		
		//Success confirmation message
		@FindBy(css=".successbox > span")
		public WebElement successConfirmationMsg;
		
		//Ok button on error popup
		@FindBy(css=".errorbox div input[type='button']")
		public WebElement errorOkBtn;
		
		//Ok button on success popup
		@FindBy(css=".successbox div input[type='button']")
		public WebElement successOkBtn;
		
		//Save button
		@FindBy(id="btnSave")
		public WebElement saveBtn;
		
		//Cancel button
		@FindBy(css="input[value='Cancel']")
		public WebElement cancelBtn;
		
		//Search button
		@FindBy(id="btnSearch")
		public WebElement searchBtn;
		
		//Reset button
		@FindBy(id="btnReset")
		public WebElement resetBtn;
		
		
		//Yes button on Confirmation popup
		@FindBy(css=".alertBoxBtn input[value='Yes']")
		public WebElement yesBtn;

		//No button on Confirmation popup
		@FindBy(css=".alertBoxBtn input[value='No']")
		public WebElement noBtn;		
		
		
		//Progress bar after login
		By progressBar= By.id("progressBar");
		
		//Sliding indicator after any action on page
		By slider= By.cssSelector("div.slide");
		
		
		//Date Picker window after any action on date textbox
		By datapicker = By.id("ui-datepicker-div");
		
		
		//Common validation pop up
		
		By validationTextFromBottomRightPopUp = By.cssSelector("div.ctrl-slidePrompt > div");
		By okButtonOnBottomRightPopUp= By.name("ok");
		By yesButtonOnBottomRightPopUp= By.name("yes");
		
		
		//Date Picker
		
	
		
		//Common Buttons
		@Step("Click on the New button.")
		public void footer_ClickOnNewButton()
		{
			selenium.waitTillElementIsVisible(newBtn);
			selenium.pageScrollInView(newBtn);
			newBtn.click();
			waitTillPageLoaded();
		}
		
		@Step("Click on the Done button.")
		public void footer_ClickOnDone()
		{
			selenium.waitTillElementIsClickable(doneBtn);
			selenium.pageScrollInView(doneBtn);
			doneBtn.click();
			waitTillPageLoaded();
		}
		
		@Step("Click on the Back button.")
		public void footer_ClickOnBack()
		{
			selenium.waitTillElementIsVisible(backBtn);
			selenium.waitTillElementIsClickable(backBtn);
			selenium.pageScrollInView(backBtn);
			backBtn.click();
			waitTillPageLoaded();
		}
		
		@Step("Click on the Next button.")
		public void footer_ClickOnNext()
		{
			selenium.waitTillElementIsVisible(nextBtn);
			selenium.waitTillElementIsClickable(nextBtn);
			selenium.pageScrollInView(nextBtn);
			nextBtn.click();
			waitTillPageLoaded();
		}

		@Step("Click on the Previous button.")
		public void footer_ClickOnPrevious()
		{
			selenium.waitTillElementIsVisible(prevBtn);
			selenium.waitTillElementIsClickable(prevBtn);
			selenium.pageScrollInView(prevBtn);
			prevBtn.click();
			waitTillPageLoaded();
		}
		
		@Step("Click on the Task button.")
		public void footer_ClickOnTask()
		{
			selenium.waitTillElementIsVisible(taskBtn);
			selenium.waitTillElementIsClickable(taskBtn);
			selenium.pageScrollInView(taskBtn);
			taskBtn.click();
			waitTillPageLoaded();
		}
		
		@Step("Click on the Break button.")
		public void footer_ClickOnBreak()
		{
			selenium.waitTillElementIsVisible(breakBtn);
			selenium.waitTillElementIsClickable(breakBtn);
			selenium.pageScrollInView(breakBtn);
			breakBtn.click();
			waitTillPageLoaded();
		}
		
		@Step("Click on the OK button on Error message popup.")
		public void popup_ClickOnErrorOk()
		{
			selenium.waitTillElementIsVisible(errorOkBtn);
			selenium.waitTillElementIsClickable(errorOkBtn);
			selenium.pageScrollInView(errorOkBtn);
			errorOkBtn.click();
		}
		
		@Step("Click on the OK button on Success message popup.")
		public void popup_ClickOnSuccessOk()
		{
			selenium.waitTillElementIsVisible(successOkBtn);
			selenium.waitTillElementIsClickable(successOkBtn);
			selenium.pageScrollInView(successOkBtn);
			successOkBtn.click();
			selenium.waitTillElementIsNOTVisible(successOkBtn);

		}
		
		@Step("Click on the Save button.")
		public void btn_ClickOnSave()
		{
			selenium.waitTillElementIsVisible(saveBtn);
			selenium.waitTillElementIsClickable(saveBtn);
			selenium.pageScrollInView(saveBtn);
			saveBtn.click();
		}
		
		@Step("Click on the Cancel button.")
		public void btn_ClickOnCancel()
		{
			selenium.waitTillElementIsVisible(cancelBtn);
			selenium.waitTillElementIsClickable(cancelBtn);
			selenium.pageScrollInView(cancelBtn);
			cancelBtn.click();
		}
		
		@Step("Click on the Search button.")
		public void btn_ClickOnSearch()
		{
			selenium.waitTillElementIsVisible(searchBtn);
			selenium.waitTillElementIsClickable(searchBtn);
			selenium.pageScrollInView(searchBtn);
			searchBtn.click();
		}

		@Step("Click on the Reset button")
		public void btn_ClickOnReset()
		{
			selenium.waitTillElementIsVisible(resetBtn);
			selenium.waitTillElementIsClickable(resetBtn);
			selenium.pageScrollInView(resetBtn);
			resetBtn.click();
		}
		
		@Step("Click on the YES Button on confirmation message popup.")
		public void popup_ClickOnConfirmationYes()
		{
			selenium.waitTillElementIsVisible(yesBtn);
			selenium.waitTillElementIsClickable(yesBtn);
			selenium.pageScrollInView(yesBtn);
			yesBtn.click();
		}
		
		@Step("Click on the NO Button on confirmation message popup.")
		public void popup_ClickOnConfirmationNo()
		{
			selenium.waitTillElementIsVisible(noBtn);
			selenium.waitTillElementIsClickable(noBtn);
			selenium.pageScrollInView(noBtn);
			noBtn.click();
		}
		
		@Step("Select the Include Delete Record checkbox.")
		public void checkbox_includeDeleteRecord()
		{
			selenium.waitTillElementIsVisible(chkboxIncludeDeleteRecord);
			selenium.waitTillElementIsClickable(chkboxIncludeDeleteRecord);
			selenium.pageScrollInView(chkboxIncludeDeleteRecord);
			chkboxIncludeDeleteRecord.click();
		}
		
		
		
		//Wait till page loaded completely after login
		public void waitAfterLogin()
		{
			selenium.waitTillElementIsPresent(progressBar);
		}
	
		//wait till page loaded completely
		public void waitTillPageLoaded()
		{
			selenium.waitTillElementIsNOTVisible(slider);	
		}
	
		//wait till Date Picker loaded completely
		public void waitTillDatePickerLoaded()
		{
			selenium.waitTillElementIsNOTVisible(datapicker);
		}
		
		//Global validation pop up on bottom right
		
		public String getValidationTextFromBottomRightPopUp()
		{
			String text = selenium.waitTillElementIsClickable(validationTextFromBottomRightPopUp).getText().trim();
			selenium.waitTillElementIsClickable(okButtonOnBottomRightPopUp).click();
			return text;
		}
		
		public void validationBottomRightPopUp_ClickOnOk()
		{
			selenium.waitTillElementIsClickable(okButtonOnBottomRightPopUp).click();
			waitTillPageLoaded();
		}
		
		public void validationBottomRightPopUp_ClickOnYes()
		{
			selenium.waitTillElementIsClickable(yesButtonOnBottomRightPopUp).click();
			waitTillPageLoaded();
		}
		
		
		//Toggles
		public void setToggleValue(WebElement toggle, WebElement isactive, String value)
		{
			String selectedvalue="yes";
			String currentstatus = isactive.getAttribute("checked");			
			if(currentstatus == null)
			{
				selectedvalue = "no";
			}
			
			if(value.equalsIgnoreCase("active"))
			{
				value = "yes";
			}
			else if(value.equalsIgnoreCase("inactive"))  
			{
				value = "no";
			}
			
			if(!value.equalsIgnoreCase(selectedvalue))
			{
				selenium.pageScrollInView(toggle);
				toggle.click();
			}
		}
		
		
		//Toggle status
		@Step("Set job status vlaue to {3}")
		public void setToggleStaus(WebElement active, WebElement inactive, String statusvalue)
		{
			if (statusvalue.contains("Active"))
			{
				inactive.click();
			}
			else if(statusvalue.contains("Inactive"))  
			{
				active.click();
			}
		}
		
		
		public void datapicker_selectDae()
		{
			
		}
		
}
