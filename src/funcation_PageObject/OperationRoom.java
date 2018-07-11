package funcation_PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;

public class OperationRoom extends ApplicationKeyword{
    
	public static void navigateOperationRoom()
	{	 
		WebElement element = driver.findElement(By.xpath("//a[@href='#/preference-card/operating-rooms']"));
		executor.executeScript("arguments[0].scrollIntoView(true);",element);
		clickOn(OR.OP_ORoomPageLink);
		waitForElementToDisplay(OR.OP_wait, 10);

	}
	
	public static void Verifypage()
	{
		getTextchild("//*[@class='pagehead']");
		verifyElement(OR.OP_searchTextBox);
		verifyElement(OR.OP_Name);
		verifyElement(OR.OP_Facility);
		verifyElement(OR.OP_created_at);
	}
	
	
	public static void AddOperationRoom()
	{
		waitForElement(OR.OP_CreatenewOP);
		clickOn(OR.OP_CreatenewOP);
		waitForElement(OR.OP_CreatenewOPText);
		verifyElementText(OR.OP_CreatenewOPText, "Add Operating Room ");
		verifyElementText(OR.Profile_Label_Name, getText(OR.Profile_Label_Name));
		verifyElementText(OR.Order_facility_txt, getText(OR.Order_facility_txt));
		String disabledAttri=getAttributeValue(OR.OP_disabledSaveButton, "disabled");
		if(disabledAttri.equalsIgnoreCase("true"))
		{
			testLogPass("All the fileds are mandatory on this page");
		}
		else
		{
			testLogFail("All the fileds are not mandatory on this page");
		}
		String opRoom="OPeration"+ApplicationKeyword.randomAlphaNumeric(5);
		setProperty("OPerationRoom", opRoom);
		typeIn(OR.OP_OpName, opRoom);
		clickOn(OR.OP_FacilityDropDown);		
		String fact = getProperty("userdefaultFac");
		if(isElementDisplayed(OR.OP_FacilityInput))
		{
			typeIn(OR.OP_FacilityInput, "Seventh November");
		}
		
		verifyElement(OR.csManufacture_Close);
		WebElement elem2=driver.findElement(By.xpath("//*[@class='ui-select-choices-row-inner']//*[text()='Seventh November']"));
		elem2.click();
		if(!isElementDisplayed(OR.OP_enabledSaveButton,10))
		{
			testLogPass("SAVE button is enabled");
		}
		else
		{
			testLogFail("SAVE button is not enabled");				
		}
		clickOn(OR.OP_disabledSaveButton);
		ToastmesssageSucess();
	}
	
	public static void Search(String searchOpearationRoom)
	{
		typeIn(OR.OP_searchTextBox, searchOpearationRoom);
		clickOn(OR.OP_searchButton);
	}
	
	public static void EditOperationRoom(String opearationRoom)
	{
		waitForElementToDisplayWithoutFail(OR.OP_firstOPRoom,10);
		String s2=getText(OR.OP_firstOPRoom);
		if(s2. equalsIgnoreCase(opearationRoom))
		{
			testLogPass("Operating room is created Sucess");
		}
		waitForElement(OR.pattern_editButton);
		clickOn(OR.pattern_editButton);
		verifyElementText(OR.OP_editheader, "Edit Operating Room");
		clickOn(OR.csManufacture_Close);
		waitForElement(OR.pattern_editButton);
		clickOn(OR.pattern_editButton);
		clickOn(OR.OP_disabledSaveButton);
		ToastmesssageSucess();
		
	}
	
	public static void Delete(String search)
	{
		waitForElement(OR.OP_DeleteButton);
		clickOn(OR.OP_DeleteButton);
		waitForElement(OR.OP_confirmButton);
		clickOn(OR.OP_confirmButton);
		typeIn(OR.OP_searchTextBox, search);
		clickOn(OR.OP_searchButton);
		String s4=getText(OR.OP_firstOPRoom);
		if(s4.equalsIgnoreCase("No Operating Rooms Found."))
		{
			testLogPass("Operating room is Deleted successfuly");
		}
		else
		{
			testLogFail("Operating room is not Deleted successfuly");
		}	
	}
	
}

