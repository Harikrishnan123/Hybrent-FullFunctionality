package funcation_PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.python.icu.text.SelectFormat;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework._OR;
import AutomationFramework.OR;

public class ApprovalFlow extends ApplicationKeyword
{
	public static void NavigateToApprovalflow()
	{
		clickOn(_OR.DashBoard_Admin);
		clickOn(_OR.DashBoard_Admin_approvals);
		getTextchild("//*[@class='pagehead']");
	}
	
	public static void verifyPage()
	{
		Gridview();
		verifyElementText(OR.Itemcatalog_SearchBy, "Search by");
		verifyPagination();
		verifyElement(OR.ApprovalFlow_label_Facility);
		testLogPass("Name is "+getText(OR.ApprovalFlow_First_Name));
		testLogPass("Facility count is "+getText(OR.ApprovalFlow_First_Facilitycount));
		verifyElement(OR.ApprovalFlow_First_ManageFlow);
		verifyElement(OR.ApprovalFlow_First_ManageFacility);
		verifyElement(OR.ApprovalFlow_First_DeleteIcon);
		verifyElement(OR.ApprovalFlow_Addbtn);
		verifyElement(OR.ApprovalFlow_Refreshbtn);
	}
	
	public static void NoSearch()
	{
		typeIn(OR.ApprovalFlow_search, "lJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ");
		clickOn(OR.ApprovalFlow_searchBtn);
		verifyElementText(OR.ApprovalFlow_Searchvalidation, "No data available in table");
	}
	
	public static void AddTemplate(String Facility)
	{
		String Name = "Templa"+randomAlphaNumeric(8);
		setProperty("TemplateName", Name);
		clickOn(OR.ApprovalFlow_Addbtn);
		verifyElementText(OR.ApprovalFlow_Add_Title, "Add Template");
		verifyElement(OR.Approvalflow_txt_Name);
		verifyElement(OR.Approvalflow_txt_Facilities);
		verifyElement(OR.Approvalflow_Input_Name);
		verifyElement(OR.Approvalflow_Input_Facilities);
		verifyElement(OR.Approvalflow_Add_Save);
		verifyElement(OR.Approvalflow_Add_Close);
		typeIn(OR.Approvalflow_Input_Name, Name);
		clickOn(OR.Approvalflow_Click_Facilities);
		typeIn(OR.Approvalflow_Input_Facilities, getProperty("UserAddfailityName"));
		clickOn(OR.Approvalflow_SelectFacility);
		verifyElement(OR.Approvalflow_Add_Minux);
		verifyElement(OR.Approvalflow_Add_croxxx);
		clickOn(OR.Approvalflow_Add_Close);
		waitForElement(OR.ApprovalFlow_Addbtn);
		clickOn(OR.ApprovalFlow_Addbtn);
		typeIn(OR.Approvalflow_Input_Name, Name);
		clickOn(OR.Approvalflow_Click_Facilities);
		typeIn(OR.Approvalflow_Input_Facilities, getProperty("UserAddfailityName"));
		clickOn(OR.Approvalflow_SelectFacility);
		clickOn(OR.Approvalflow_Add_Save);
		ToastmesssageSucess();
	}
	
	public static void NoAddTemplate()
	{
		String Name = "Templa"+randomAlphaNumeric(8);
		setProperty("NOTemplateName", Name);
		waitForElement(OR.ApprovalFlow_Addbtn);
		clickOn(OR.ApprovalFlow_Addbtn);
		typeIn(OR.Approvalflow_Input_Name, Name);
		clickOn(OR.Approvalflow_Add_Save);
		ToastmesssageSucess();
	}
	
	public static void SearchFlow(String Search)
	{
		typeIn(OR.SI_SearchTextBox,  Search);
		clickOn(OR.Phy_SearchButton	);
	}
	
	public static void MangeFlow()
	{
		clickOn(OR.ApprovalFlow_First_ManageFlow);
		String LevelName = "level"+randomAlphaNumeric(6);
		setProperty("ManageFlowLevelName", LevelName);
		testLogPass("Page Head "+getTextchild("//*[@class='pagehead ng-binding']"));
		int size = driver.findElements(By.xpath("//*[@ng-repeat='facility in template.approvalTemplateFacilities']/div")).size();
		for(int i = 1; i<=size; i++)
		{
			String one = driver.findElement(By.xpath("(//*[@ng-repeat='facility in template.approvalTemplateFacilities']/div)["+i+"]")).getText();
			testLogPass("Facilitly under the mange flow "+one);
		}
		verifyElement(OR.Approvalflow_MangeFlow_AddLevel);
		//verifyElement(OR.Approvalflow_Add_Save);
		clickOn(OR.Approvalflow_MangeFlow_AddLevel);
		verifyElementText(OR.Approvalflow_MangeFlow_AddLevel_LevelName, "Level name*");
		typeIn(OR.Approvalflow_MangeFlow_AddLevel_InputLevelName, LevelName);
		clickOn(OR.Approvalflow_Add_Save);
		ToastmesssageSucess();
		if(driver.findElements(By.xpath("//*[text()='"+LevelName+"']")).size()!=0)
		{
			testLogPass("Level name is presnt");
		}
		verifyElementText(OR.Approvalflow_MangeFlow_AddLevel_validation, "Please add atleast one user to this level.");
		verifyElement(OR.manageInv_plusSign);
		getAttributeValue(OR.manageInv_plusSign, "title");
		clickOn(OR.Approvalflow_Add_Downbtn);
		waitForElement(OR.Approvalflow_MangeFlow_DeleteLevel);
		clickOn(OR.Approvalflow_MangeFlow_DeleteLevel);
		verifyElementText(OR.Approvalflow_MangeFlow_Deletelevel_validation, "Are you sure you want to delete this level ?");
		waitForElement(OR.MyCart_confirmButton);
		clickOn(OR.MyCart_confirmButton);
		ToastmesssageSucess();
		clickOn(OR.Approvalflow_MangeFlow_AddLevel);
		typeIn(OR.Approvalflow_MangeFlow_AddLevel_InputLevelName, LevelName);
		clickOn(OR.Approvalflow_Add_Save);
		
		
		ToastmesssageSucess();
		clickOn(OR.manageInv_plusSign);
		waitForElement(OR.Approvalflow_MangeFlow_AddLevel_Close);
		clickOn(OR.Approvalflow_MangeFlow_AddLevel_Close);
		clickOn(OR.manageInv_plusSign);
		verifyElementText(OR.Approvalflow_MangeFlow_AddLevel_Header, "Add Level User");
		verifyElement(OR.Approvalflow_MangeFlow_AddLevel_Label_SelectUser);
		selectFromDropdown(OR.Approvalflow_MangeFlow_AddLevel_SelectUser, getProperty("created_NeUser"));
		
		
		int Facilitysize = driver.findElements(By.xpath("//*[@id='facility-select']/option")).size();
				for(int i =1; i<=Facilitysize; i++)
				{
					String one = driver.findElement(By.xpath("(//*[@id='facility-select']/option)["+i+"]")).getText();
					testLogPass("Facility dropdown list is "+one);
				}
		int Deptsize = driver.findElements(By.xpath("//*[@id='department-select']/option")).size();
				for(int i =1; i<=Deptsize; i++)
				{
					String one = driver.findElement(By.xpath("(//*[@id='department-select']/option)["+i+"]")).getText();
					testLogPass("Dept dropdown list is "+one);
				}
		
		selectFromDropdown(OR.Approvalflow_MangeFlow_AddLevel_SelectFacility, "Specific facility");
		clickOn(OR.Approvalflow_MangeFlow_AddLevel_Facility_spec);
		clickOn(OR.Approvalflow_MangeFlow_AddLevel_Facility_Select);
		//clickOn(OR.Approvalflow_MangeFlow_AddLevel_Facility_spec);
		clickOn(OR.Approvalflow_Add_croxxx);
		selectFromDropdown(OR.Approvalflow_MangeFlow_AddLevel_SelectFacility, "Any facility");
		selectFromDropdown(OR.Approvalflow_MangeFlow_AddLevel_Selectdepartment, "Specific department");
		clickOn(OR.Approvalflow_MangeFlow_AddLevel_Dept_spec);
		clickOn(OR.Approvalflow_MangeFlow_AddLevel_Dept_Select);
		//clickOn(OR.Approvalflow_MangeFlow_AddLevel_Dept_spec);
		clickOn(OR.Approvalflow_Add_croxxx);
		selectFromDropdown(OR.Approvalflow_MangeFlow_AddLevel_Selectdepartment, "Any department");
		verifyElement(OR.Approvalflow_MangeFlow_AddLevel_AutoApproval);
		String one =getAttributeValue(OR.Approvalflow_MangeFlow_AddLevel_AutoApproval, "class");
		if(one.contains("bootstrap-switch-off"))
		{
			testLogPass("Auto approve PO if created by this user toggle button is off");
		}
		if(one.contains("bootstrap-switch-on"))
		{
			testLogPass("Auto approve PO if created by this user toggle button is ON");
		}
		verifyElement(OR.glCode_saveButton);
		verifyElement(OR.glCode_CloseButton);
		clickOn(OR.glCode_CloseButton);
		clickOn(OR.manageInv_plusSign);
		selectFromDropdown(OR.Approvalflow_MangeFlow_AddLevel_SelectUser, 2);
		selectFromDropdown(OR.Approvalflow_MangeFlow_AddLevel_SelectFacility, "Any facility");
		selectFromDropdown(OR.Approvalflow_MangeFlow_AddLevel_Selectdepartment, "Any department");
		clickOn(OR.glCode_saveButton);
		ToastmesssageSucess();
		
	}
	
	public static void EditLevel()
	{
		clickOn(OR.Approvalflow_MangeFlow_Edit);
		getTextchild("//*[@class='headtext']");
		//verifyElement(OR.Approvalflow_MangeFlow_AddLevel_InputLevelName);
		verifyElement(OR.glCode_saveButton);
		verifyElement(OR.glCode_CloseButton);
		clickOn(OR.glCode_saveButton);
		ToastmesssageSucess();
	}
	
	public static void AddRules()
	{
		waitForElement(OR.Approvalflow_MangeFlow_AddLevel);
		clickOn(OR.Approvalflow_MangeFlow_AddLevel);
		verifyElementText(OR.Approvalflow_MangeFlow_AddLevel_LevelName, "Level name*");
		typeIn(OR.Approvalflow_MangeFlow_AddLevel_InputLevelName, "4");
		clickOn(OR.Approvalflow_Add_Save);
		waitForElement(OR.Approvalflow_Add_Downbtn);
		clickOn(OR.Approvalflow_Add_Downbtn);
		waitForElement(OR.Approvalflow_MangeFlow_AddRule, 20);
		clickOn(OR.Approvalflow_MangeFlow_AddRule);
		waitForElement(OR.Approvalflow_MangeFlow_AddRule_Cutofflabel);
		verifyElementText(OR.Approvalflow_MangeFlow_AddRule_Cutofflabel, "Cut off time(Hrs)*");
		verifyElementText(OR.Approvalflow_MangeFlow_AddRule_poAmountlimitlabel, "PO amount limit(USD)*");
		typeIn(OR.Approvalflow_MangeFlow_AddRule_Cutofftime, "-000");
		verifyElement(OR.Approvalflow_MangeFlow_AddRule_Cutofftime_validation);
		typeIn(OR.Approvalflow_MangeFlow_AddRule_poAmountlimit, "-000");
		verifyElement(OR.Approvalflow_MangeFlow_AddRule_poAmountlimit_validation);
		typeIn(OR.Approvalflow_MangeFlow_AddRule_Cutofftime, "1");
		typeIn(OR.Approvalflow_MangeFlow_AddRule_poAmountlimit, "1");
		clickOn(OR.Approvalflow_Add_Save);
		ToastmesssageSucess();
	}
	
	public static void EditRules()
	{
		clickOn(OR.Approvalflow_Add_Downbtn);
		waitForElement(OR.Approvalflow_MangeFlow_EditRule);
		clickOn(OR.Approvalflow_MangeFlow_EditRule);
		verifyElementText(OR.Approvalflow_MangeFlow_AddRule_Cutofflabel, "Cut off time(Hrs)*");
		verifyElementText(OR.Approvalflow_MangeFlow_AddRule_poAmountlimitlabel, "PO amount limit(USD)*");
		clickOn(OR.Approvalflow_Add_Save);
		ToastmesssageSucess();
	}
	
	public static void DeleteRule()
	{
		waitForElement(OR.Approvalflow_Add_Downbtn);
		clickOn(OR.Approvalflow_Add_Downbtn);
		waitForElement(OR.Approvalflow_MangeFlow_DeleteRule);
		clickOn(OR.Approvalflow_MangeFlow_DeleteRule);
		waitForElement(OR.Approvalflow_MangeFlow_DeleteRule_validation);
		verifyElementText(OR.Approvalflow_MangeFlow_DeleteRule_validation, "Are you sure you want to delete this level rule ?");
		waitForElement(OR.MyCart_confirmButton, 20);
		clickOn(OR.MyCart_confirmButton);
		ToastmesssageSucess();
	}
	
	public static void MangeFacility()
	{
		clickOn(OR.ApprovalFlow_First_ManageFacility);
		getTextchild("//*[@class='pagehead']");
		clickOn(OR.Approvalflow_Add_Close);
		waitForElement(OR.ApprovalFlow_First_ManageFacility);
		clickOn(OR.ApprovalFlow_First_ManageFacility);
		clickOn(OR.HeaderClose);
		waitForElement(OR.ApprovalFlow_First_ManageFacility);
		clickOn(OR.ApprovalFlow_First_ManageFacility);
		clickOn(OR.Approvalflow_Add_Save);
		ToastmesssageSucess();
	}
	
	public static void Delete()
	{
		clickOn(OR.ApprovalFlow_First_DeleteIcon);
		verifyElementText(OR.Template__Deletetemplatevalidation, "Are you sure you want to delete this template ?");
		clickOn(OR.ApprovalFlow_First_Deletecancel);
		waitForElement(OR.ApprovalFlow_First_DeleteIcon);
		clickOn(OR.ApprovalFlow_First_DeleteIcon);
		waitForElement(OR.ItemCat_ConfirmButton);
		clickOn(OR.ItemCat_ConfirmButton);
		verifyPagination();
		ToastmesssageSucess();
	}
}
