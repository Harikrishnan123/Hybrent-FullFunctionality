package funcation_PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;
import AutomationFramework._OR;

public class Department extends ApplicationKeyword{

	 public static void NavigateHometoDepartment()
	 {
		 clickOn(_OR.DashBoard_Admin);
		 clickOn(_OR.DashBoard_Admin_department);
		
	 }
	 
	 public static void verifyDepartmentPage()
	 {
		 String one =getTextchild("//*[@class='pagehead']");
		 if(one.contains("MANAGE DEPARTMENTS"))
		 {
			testLogPass("MANAGE DEPARTMENTS header is present");
		 }
		 verifyElement(OR.Department_Search);
		 verifyElement(OR.Department_Facility);
	 }
	 
	 public static void searchDept()
	 {
		 typeIn(OR.Dep_SearchTextBox,getProperty("AddDeptName"));
		 clickOn(OR.manage_searchButton);
	 }
	 
	 public static void EditDept()
	 {
		 clickOn(OR.Dep_EditFirst);
		 verifyElement(OR.Dep_Edit_title);
		 clickOn(OR.Dep_Edit_Close);
	 }
	 
	 public static void DeleteDept()
	 {
		 clickOn(OR.Dep_Delete_First);
		 verifyElementText(OR.Dep_Delete_validation, "Are you sure you want to delete this department ?");
		 clickOn(OR.Dep_Delete_Cancel);
		 waitForElementToDisplay(OR.Dep_Delete_First, 60);
		 clickOn(OR.Dep_Delete_First);
		 verifyElementText(OR.Dep_Delete_validation, "Are you sure you want to delete this department ?");
		 clickOn(OR.Dep_Delete_Yes);
		 typeIn(OR.Dep_SearchTextBox,getProperty("AddDeptName"));
		 clickOn(OR.manage_searchButton);
		 
	 }
	 public static void addDepartment()
	 {
		 String Mnemonic = "Test";
		 String DeptName =  "Dept"+randomAlphaNumeric(5);
		 clickOn(OR.Department_AddDeptBtn);
		 verifyElementText(_OR.user_addUser_DepartmentTitle, "Add Department");
		 selectFromDropdown(_OR.user_addUser_addDepartment_facilityselect, getProperty("UserAddfailityName"));
		 typeIn(_OR.user_addUser_addDepartment_Mnemonic, Mnemonic);
		 typeIn(_OR.user_addUser_addDepartment_name,DeptName);
		 clickOn(_OR.user_addUser_addDepartment_save);
		 setProperty("AddDeptName", DeptName);
	 }
	 
	 
}
