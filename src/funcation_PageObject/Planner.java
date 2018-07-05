package funcation_PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;

public class Planner extends ApplicationKeyword {	
	public static void pageLinkandwait()
	{

		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//a[@href='#/preference-card/operating-rooms']"));
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		clickOn(OR.OP_ORoomPageLink);
		waitForElementToDisplay(OR.OP_wait, 10);

	}
	public static void patientsPageLinkandwait()
	{	 
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//a[@href='#/preference-card/patients']"));
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		clickOn(OR.Patient_PatientsPageLink);
		waitForElementToDisplay(OR.OP_wait2, 10);
		
	}

	public static void VerifyPaitentPage()
	{
		getTextchild("//*[@class='pagehead']");	
	}
	
	public static void casesPageLinkandwait()
	{
		try
		{
			JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement element = driver.findElement(By.xpath("//a[@href='#/preference-card/cases']"));
			je.executeScript("arguments[0].scrollIntoView(true);",element);
			clickOn(OR.Cases_CasesPageLink);
			pageLinkExists=true;
		}
		catch(Exception e)
		{
			testLogError("Page link does not exist.");
			pageLinkExists=false;
		}
		//cannot put wait on table elements bcoz no elemenet is present on page by default
		//waitForElementToDisplay(OR.Case_firstCase, 10);

	}
	public static void procedurePageLinkandwait()
	{	 
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//*[@href='#/preference-card/procedures']"));
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		clickOn(OR.Procedure_PageLink);
		//waitForElementToDisplay(OR.Procedure_wait, 10);

	}
	public static void plannerPageLinkandwait()
	{	 
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//*[@href='#/preference-card/planner']"));
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		clickOn(OR.Planner_PageLink);
		
	}
	
	public static void EditPaitent()
	{
		testLogPass(" Tootl Tip is Edit paitent is "+getAttributeValue(OR.Patient_EditPAtient, "uib-tooltip"));
		clickOn(OR.Patient_EditPAtient);
		verifyElementText(OR.Patient_EditPAtientPopUp, "Edit Patient ");
		clickOn(OR.Patient_EditPAtientPopUpCancel);
	}
	
	public static void tablevalues()
	{
		int sizeheader = driver.findElements(By.xpath("//table//th")).size();
		for(int i =1 ;i<=sizeheader;i++)
		{
			String value = driver.findElement(By.xpath("(//table//th)["+i+"]")).getText();
			testLogPass("Header is "+value);
		}
		verifyPagination();
	}
	
	public static void Delete()
	{
		waitForElement(OR.Pattern_Delete);
		verifyElement(OR.Pattern_Delete);
		testLogPass(" Tootl Tip is Delete paitent is "+getAttributeValue(OR.Pattern_Delete, "uib-tooltip"));
		clickOn(OR.Pattern_Delete);
		if(driver.findElements(By.xpath("//*[text()='Are you sure?']")).size()!=0)
		{
		verifyElementText(OR.Template__Deletevalidation, "Are you sure?");
		verifyElement(OR.Pattern_Delete);
		verifyElement(OR.MyCart_confirmButton);
		clickOn(OR.manageInv_cancelPopUP);
		waitForElement(OR.Pattern_Delete);
		
		clickOn(OR.Pattern_Delete);
		waitForElement(OR.MyCart_confirmButton);
		clickOn(OR.MyCart_confirmButton);
		ToastmesssageSucess();
		}
		
		
	}
	
	public static void Movepaitent()
	{
		verifyElement(OR.Patient_MovePatient);
		clickOn(OR.Patient_MovePatient);
		waitTime(2);
		int sizeheader = driver.findElements(By.xpath("//*[@ class='tab-content']/*[@class='form-group']")).size();
		for(int i =1 ;i<=sizeheader;i++)
		{
			String value = driver.findElement(By.xpath("(//*[@ class='tab-content']/*[@class='form-group'])["+i+"]")).getText();
			testLogPass("Move Paitent is "+value);
		}
		verifyElement(OR.glCode_saveButton);
		verifyElement(OR.HeaderClose);
		clickOn(OR.HeaderClose);
	}
	
	public static void verifyPage()
	{
		getTextchild("//*[@class='pagehead']");
		verifyElement(OR.Planner_FilterByPhysician);
		verifyElement(OR.Patient_getfacilityName);
		getText(OR.manageInv_actaulFac);
	}
	
	public static void addPaitent()
	{
		String facility_Name=getText(OR.Patient_getfacilityName);
		waitForElement(OR.Patient_AddPatient);
		clickOn(OR.Patient_AddPatient);
		waitForElement(OR.Patient_disabledSaveButton);
		if(getAttributeValue(OR.Patient_disabledSaveButton, "disabled") != null)
		{
			testLogPass("Save button is disabled");
		}
		else
		{
			testLogFail("Save button is not isabled");
		}
		String firstName="Test"+randomAlphaNumeric(6);
		String lastName="Patient";		
		String AccNo ="465000";
		String MrnNumbe =  "00001";
		typeIn(OR.Patient_firstName, firstName);
		//typeIn(OR.Patient_middleName, "Pat");
		typeIn(OR.Patient_lastName, lastName);
		typeIn(OR.Patient_mrnNumber, MrnNumbe);
		typeIn(OR.Patient_accNumber, AccNo);
		typeIn(OR.Patient_dob, "11112007");
		clickOn(OR.Patient_facDropDown);
		WebElement elem=driver.findElement(By.xpath("//li[@class='ui-select-choices-group']//span[text()='"+facility_Name+"']"));
		elem.click();
		if(!isElementDisplayed(OR.Patient_enabledSaveButton,10))
		{
			testLogPass("SAVE button is enabled only when all mandatory fields are filled");
		}
		else
		{
			testLogFail("SAVE button is not enabled when all mandatory fields are filled");				
		}
		clickOn(OR.glCode_CloseButton);
		waitForElement(OR.Patient_AddPatient);
		clickOn(OR.Patient_AddPatient);
		waitForElement(OR.Patient_disabledSaveButton);
		if(getAttributeValue(OR.Patient_disabledSaveButton, "disabled") != null)
		{
			testLogPass("Save button is disabled");
		}
		else
		{
			testLogFail("Save button is not isabled");
		}
		
		typeIn(OR.Patient_firstName, firstName);
		//typeIn(OR.Patient_middleName, "Pat");
		typeIn(OR.Patient_lastName, lastName);
		typeIn(OR.Patient_mrnNumber, MrnNumbe);
		typeIn(OR.Patient_accNumber, AccNo);
		typeIn(OR.Patient_dob, "11112007");
		clickOn(OR.Patient_facDropDown);
		WebElement elem1=driver.findElement(By.xpath("//*[@id='facility']//*[text()='"+facility_Name+"']"));
		elem1.click();
		clickOn(OR.glCode_saveButton);
		ToastmesssageSucess();
		waitForElementToDisplayWithoutFail(OR.Patient_firstPatient, 10);
		typeIn(OR.Patient_searchTextBox, firstName+" "+lastName);
		clickOn(OR.Patient_searchbutton);
		waitForElementToDisplayWithoutFail(OR.Patient_firstPatient, 10);
		String patientName=getText(OR.Patient_firstPatient);
		String finalName=patientName.substring(2).trim();
		if(finalName.equals(firstName+" "+lastName))
		{
			testLogPass("New Patient is added");
		}
		else
		{
			testLogFail("New Patient is not added");
		}									
	}
	
	public static void selectFacility()
	{
		waitForElement(OR.Patient_FacilitySelect);
		clickOn(OR.Patient_FacilitySelect);
		verifyElement(OR.PrintBarcodes_SelectFac_title);
		clickOn(OR.HeaderClose);
	}
	
	public static void prefCardPagePageLinkandwait()
	{	 
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//*[@href='#/preference-card/cards']"));
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		clickOn(OR.prefCard_PageLink);
		waitForElementToDisplay(OR.prefCard_AddPrefCard, 10);

	}
	public static void addStageAndItem()
	{

		Planner.prefCardPagePageLinkandwait();
		waitForElementToDisplay(OR.prefCard_AddPrefCard, 10);
		clickOn(OR.prefCard_AddPrefCard);
		clickOn(OR.prefCard_addStage);
		String sName=getProperty("Prefcard_StageName");
		typeIn(OR.prefCard_addStageName, sName);
		clickOn(OR.prefCard_addStageButton);
		String itemDesc=getProperty("ItemDesc");
		typeIn(OR.prefCard_searchInCart,itemDesc);
		waitForElementToDisplay(OR.prefCard_addItemInCart, 10);
		clickOn(OR.prefCard_addItemInCart);
	}

}
