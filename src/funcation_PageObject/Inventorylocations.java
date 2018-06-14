package funcation_PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework._OR;
import AutomationFramework.OR;

public class Inventorylocations extends ApplicationKeyword{

	public static void NavigateHometoLocation()
	 {
		 clickOn(_OR.DashBoard_Admin);
		 clickOn(OR.InvLoc_PageLink);
		 verifyElement(OR.InvLoc_Header);
		 getTextchild("//*[@class='pagehead']");
	 }
	
	public static void verifyPage()
	{
		verifyElement(OR.InvLoc_searchTextBox);
		verifyElement(OR.InvLoc_Name);
		verifyElement(OR.InvLoc_row);
		verifyElement(OR.InvLoc_AddINvLOc);
		verifyElement(OR.InvLoc_Add_PlusFacilityName);
	}
	
	public static void AddInvntory()
	{
		String InvetoryCreate = "Inventory"+randomAlphaNumeric(10);
		setProperty("InvetoryCreate", InvetoryCreate);
		clickOn(OR.InvLoc_AddINvLOc);
		verifyElement(OR.InvLoc_Add_LabelName);
		typeIn(OR.InvLoc_addName, InvetoryCreate);
		verifyElement(OR.InvLoc_addFacility);
		verifyElement(OR.InvLoc_Add_LabelFacilityName);
		verifyElement(OR.InvLoc_Add_CancelBtn);
		verifyElement(OR.InvLoc_Add_CreateBtn);
		String one = getProperty("UserAddfailityName");	
		selectFromDropdown(OR.InvLoc_Add_Facility_Dropdown, getProperty("UserAddfailityName"));
		waitForElement(OR.InvLoc_Add_CreateBtn);
		clickOn(OR.InvLoc_Add_CreateBtn);
		ToastmesssageSucess();
		
	}
	
	public static void DeleteInvntory()
	{
		String InvetoryCreate = "Inventory"+randomAlphaNumeric(10);
		clickOn(OR.InvLoc_AddINvLOc);
		typeIn(OR.InvLoc_addName, InvetoryCreate);
		selectFromDropdown(OR.InvLoc_Add_Facility_Dropdown, getProperty("UserAddfailityName"));
		clickOn(OR.InvLoc_Add_CreateBtn);
		ToastmesssageSucess();
		typeIn(OR.InvLoc_searchTextBox, InvetoryCreate);
		clickOn(OR.InvLoc_Add_PlusBtn);
		if(driver.findElements(By.xpath("//button[text()='-']")).size()!=0)
		{
			testLogPass("expanded  state");
		}
		clickOn(OR.InvLoc_DeleteFacIcon);
		clickOn(OR.InvLoc_Delete_Confirmationcancel);
		clickOn(OR.InvLoc_DeleteFacIcon);
		clickOn(OR.InvLoc_Delete_ConfirmationYes);
		ToastmesssageSucess();
		verifyPagination();
	}
	
	
}
