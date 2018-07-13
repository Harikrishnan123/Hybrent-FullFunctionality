package funcation_PageObject;

import java.util.Calendar;

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
		waitUntilPageReady();
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
			waitForElement(OR.Cases_CasesPageLink);
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
		waitUntilPageReady();
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
	
	public static void paitent_ApplyPrefcard()
	{
		waitForElement(OR.Paintet_ApplyPrefCard);
		clickOn(OR.Paintet_ApplyPrefCard);
		String Name = getProperty("PaitentFirstName")+" "+getProperty("PaitentLastName");
		verifyElementText(OR.Paintet_HeaderPrefCard, "Apply Preference Card To ("+Name+")");
		verifyElement(OR.Paintet_Inventory);
		verifyElement(OR.Paintet_Prefcard);
		verifyElement(OR.Paintet_physician);
		verifyElement(OR.Paintet_procedure);
		verifyElement(OR.Paintet_operating_room);
		verifyElement(OR.Paintet_procedureDate);
		verifyElement(OR.Paintet_procedureTime_hours);
		verifyElement(OR.Paintet_procedureTime_minutes);
		verifyElement(OR.Paintet_gloves_size);
		verifyElement(OR.Paintet_surgeon_notes);
		verifyElement(OR.Paintet_surgeon_interruptions);
		verifyElement(OR.Paintet_preparation_notes);
		
		testLogPass("Procedure Time *"+getText(OR.Paintet_procedureTime_hours)+"-"+getText(OR.Paintet_procedureTime_minutes));
		
		String inventory = getProperty("UserAddInvetoryName");
		String PrefCard = getProperty("PreferenceCards");
		String Physician  = getProperty("firstPhysician");
		String Procedure  = getProperty("ProcedureName_pro");
		String operating_room  = getProperty("OPerationRoom");
		
		clickOn(OR.Paintet_calander);
		
		waitUntilPageReady();
		int sieofday = driver.findElements(By.xpath("//*[@role='gridcell']/button")).size();
		for(int i=1;i<=sieofday;i++)
		{
			WebElement calalandarActive = driver.findElement(By.xpath("(//*[@role='gridcell']/button)["+i+"]"));
			if(calalandarActive.getAttribute("class").contains("active"))
			{
				//String datte = calalandarActive.getText();
				calalandarActive.click();
				break;
			}
		
		}
		
		selectFromDropdown(OR.Paintet_Inventory, inventory);
		selectFromDropdown(OR.Paintet_physician, Physician);
		selectFromDropdown(OR.Paintet_Prefcard, PrefCard);
		selectFromDropdown(OR.Paintet_procedure, 1);
		selectFromDropdown(OR.Paintet_operating_room, operating_room);
		
		String prefBtn= getAttributeValue(OR.Paintet_AddPrefernceCard, "disabled");
		if(prefBtn==null)
		{
			clickOn(OR.Paintet_AddPrefernceCard);
			
		}else if(prefBtn.equals(false))
		{
		testLogFail("Mandatory field are not filled");	
		}
		clickOn(OR.Request_cancelPopUP);
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
		setProperty("PaitentFirstName", firstName);
		setProperty("PaitentLastName", lastName);
		typeIn(OR.Patient_firstName, firstName);
		//typeIn(OR.Patient_middleName, "Pat");
		typeIn(OR.Patient_lastName, lastName);
		typeIn(OR.Patient_mrnNumber, MrnNumbe);
		typeIn(OR.Patient_accNumber, AccNo);
		typeIn(OR.Patient_dob, "11112007");
		clickOn(OR.Patient_facDropDown);
		waitTime(2);
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
		waitUntilPageReady();
		waitForElement(OR.Patient_AddPatient);
		clickOn(OR.Patient_AddPatient);
		waitForElement(OR.Patient_disabledSaveButton);
		if(getAttributeValue(OR.Patient_disabledSaveButton, "disabled") != null)
		{
			testLogPass("Save button is disabled");
		}
		else
		{
			testLogFail("Save button is not enabled");
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
	
	
	public static void addPaitentwithoutClose()
	{
		String facility_Name=getText(OR.Patient_getfacilityName);
		waitForElement(OR.Patient_AddPatient);
		clickOn(OR.Patient_AddPatient);
		waitForElement(OR.Patient_disabledSaveButton);

		String firstName="Test"+randomAlphaNumeric(6);
		String lastName="Patient";		
		String AccNo ="465000";
		String MrnNumbe =  "00001";
		setProperty("PaitentName", firstName);
		typeIn(OR.Patient_firstName, firstName);
		//typeIn(OR.Patient_middleName, "Pat");
		typeIn(OR.Patient_lastName, lastName);
		typeIn(OR.Patient_mrnNumber, MrnNumbe);
		typeIn(OR.Patient_accNumber, AccNo);
		typeIn(OR.Patient_dob, "11112007");
		clickOn(OR.Patient_facDropDown);
		WebElement elem=driver.findElement(By.xpath("//li[@class='ui-select-choices-group']//span[text()='"+facility_Name+"']"));
		elem.click();
		
		clickOn(OR.glCode_CloseButton);
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
	
	public static void Selectcases()
	{
		
		String phy = getProperty("firstPhysician");
		String pocedurename = getProperty("ProcedureName_pro");
		String one = "Cases#xpath=(//*[contains(text(),'"+phy+" ("+pocedurename+")')])[1]";
		if(driver.findElements(By.xpath("(//*[contains(text(),'"+phy+" ("+pocedurename+")')])[1]")).size()!=0)
		{
		
		waitForElement(one);
		clickOn(one);
		testLogPass("Prefcard : "+getText(OR.prefCard_cases_Prefcard));
		testLogPass("Procedure : "+getText(OR.prefCard_cases_Procedure));
		testLogPass("Facility : "+getText(OR.prefCard_cases_Facility));
		testLogPass("CPT : "+getText(OR.prefCard_cases_CPT));
		
		int size = driver.findElements(By.xpath("//*[text()='Patient Details']/following-sibling::div")).size();
		for(int i=1;i<=size;i++)
		{
			String one1 = driver.findElement(By.xpath("(//*[text()='Patient Details']/following-sibling::div)["+i+"]")).getText();
			testLogPass(one1);
		}
		
		int Itemdes = driver.findElements(By.xpath("//*[contains(text(),'"+getProperty("ItemDesc")+"')]")).size();
		if(Itemdes!=0)
		{
			testLogPass("Item is same");
		}
		else
		{
			testLogFail("Item is not same");
		}
		verifyElement(OR.Templates_SearchScan);
		typeIn(OR.Templates_SearchScan, getProperty("ItemDesc"));
		int Itemdes1 = driver.findElements(By.xpath("//*[@class=\"tab-pane ng-scope active\"]//*[@id='suggestions']//strong")).size();
		if(Itemdes1!=0)
		{
			testLogPass("Item is in suggestion box");
		}
		else
		{
			testLogFail("Item is in suggestion not box");
		}
		
		}
		else
		{
			testLogFail("created case is not present");
		}
	}
	
	public static void PaitentHeader()
	{
		clickOn(OR.Scanout_plus);
		waitUntilPageReady();
		int sizeHeader = driver.findElements(By.xpath("//*[starts-with(@class,'table')]//th")).size();
		for(int i =1; i<=sizeHeader; i++)
		{
			String HeaderValue = driver.findElement(By.xpath("(//*[starts-with(@class,'table')]//th)["+i+"]")).getText();
			if(HeaderValue.isEmpty() && HeaderValue==null)
			{
							
			}
			else
			{
				testLogPass("paitent Header value is "+HeaderValue);
			}
		}
	}
	
	public static void PaitentMousover()
	{
		MouseOverToolTip(OR.Paintet_Edit);
		MouseOverToolTip(OR.Paintet_Delete);
		MouseOverToolTip(OR.Paintet_print);
	}
	
	public static void VerifyPreferendCard()
	{
		if(getText(OR.Paintet_prefCardName).equals(getProperty("PreferenceCards")))
		{
			testLogPass("Prefered card is same");
		}
		else
		{
			testLogFail("Prefered card is not same");
		}
	}
	
	public static void Edit()
	{
		waitForElement(OR.Paintet_Edit);
		clickOn(OR.Paintet_Edit);
		//clickOn(OR.//*[starts-with(@class,'pagehead')]);
		getTextchild("//*[starts-with(@class,'pagehead')]");
		waitForElement(OR.Vendor_Customersupport_Custom_Close);
		clickOn(OR.Vendor_Customersupport_Custom_Close);
	}
	
	public static void CreatePlanner()
	{
		String facility_Name=getText(OR.Patient_getfacilityName);
		clickOn(OR.Planner_createPatient);		
		//verifyElementText(OR.Planner_popUpText, "Create Patient ");
		String firstName="Test1"+randomAlphaNumeric(5);
		setProperty("PlannerFirstName", firstName);
		String lastName="Patient1";		
		typeIn(OR.Patient_firstName, firstName);
		//typeIn(OR.Patient_middleName, "Pat");
		typeIn(OR.Patient_lastName, lastName);
		typeIn(OR.Patient_mrnNumber, "00001");
		typeIn(OR.Patient_accNumber, "465000");
		typeIn(OR.Patient_dob, "11112017");
		clickOn(OR.Patient_facDropDown);
		WebElement elem=driver.findElement(By.xpath("//li[@class='ui-select-choices-group']//span[text()='"+facility_Name+"']"));
		elem.click();
		clickOn(OR.Planner_AddPatient);
		ToastmesssageSucess();
		
		WebElement element = driver.findElement(By.xpath("//*[starts-with(@data-time,'10:00')]//*[@class='fc-widget-content']"));
		executor.executeScript("arguments[0].click();", element);
		if(driver.findElements(By.xpath("//*[@title='Patient']//*[@ng-click='selectItem();']")).size()!=0)
		{
		waitForElement(OR.Planner_selectpaitent);
		clickOn(OR.Planner_selectpaitent);
		
		waitUntilPageReady();
		String PlannerName = getProperty("PlannerFirstName");
		typeIn(OR.prefCard_searchTextBox, PlannerName);
		waitUntilPageReady();
		String one = "Select#xpath=((//*[starts-with(@ng-repeat,'item ')]/td[1])/following-sibling::td//*[text()='Select'])[1]";
		clickOn(one);
		
		selectFromDropdown(OR.Planner_inventory_id, 1);
		selectFromDropdown(OR.Planner_physician_id, 1);
		selectFromDropdown(OR.Planner_pref_card_id, 1);
		selectFromDropdown(OR.Planner_procedure_id, 1);
		selectFromDropdown(OR.Planner_pref_card_id, 1);
		selectFromDropdown(OR.Planner_operating_room_id, 1);
		clickOn(OR.Planner_ScheduleCase);
		
		}
		
		Planner.patientsPageLinkandwait();
		typeIn(OR.Patient_searchTextBox, firstName+" "+lastName);
		clickOn(OR.Patient_searchbutton);
		waitForElementToDisplayWithoutFail(OR.Patient_firstPatient, 20);
		verifyElement(OR.Patient_firstPatient);
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
}

