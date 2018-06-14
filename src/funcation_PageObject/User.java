package funcation_PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.paulhammant.ngwebdriver.ByAngular;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;
import AutomationFramework._OR;

public class User extends ApplicationKeyword{
	public static String UserName = "admin";
	public static String Password = "goouser";
	public static String URL = "https://qa4.test.hybrent.com/b/#/login/";
	
	 public static void adminAndUserPage()
     {	
		 	clickOn(_OR.DashBoard_Admin);
			clickOn(_OR.users_page);
			verifyElement(_OR.users_SearchByText);
			
     }
	 public static void searchAndUserWait()
     {	
		 clickOn(OR.Users_SearchButton);
		 waitForElementToDisplay(OR.Users_EditFirstUser, 10);
     }
	 
	 public static void verifyUserpage()
	 {
		 verifyElement(_OR.users_First_Changepassword);
		 verifyElement(_OR.users_First_EditChangepassword);
		 verifyElement(_OR.users_changepassword_Pagination);
		 verifyElement(_OR.user_dropdown_status);
		 verifyElement(_OR.user_dropdown_searchFacility);
		 verifyElementText(_OR.user_label_searchby, "Search by");
		 verifyElementText(_OR.user_label_Facility, "Facilities");
		 verifyElementText(_OR.user_label_status, "Status");
		 verifyElement(_OR.user_Addbutton);
	 }
	 
	 public static void verify_Dropdown_status()
	 {
		 int statusSize = driver.findElements(By.xpath("//*[@id='search-status']/option")).size();
		 for(int i=1 ;i<=statusSize;i++)
		 {
			String statusList = driver.findElement(By.xpath("(//*[@id='search-status']/option)["+i+"]")).getText();
			if(statusList.contains("All"))
			{
				testLogPass("Status option '"+statusList+" ' is present");
			}
			if(statusList.contains("Active"))
			{
				testLogPass("Status option Active is present");
			}
			if(statusList.contains("In active"))
			{
				testLogPass("Status option In active is present");
			}
		 }
	 }

	 
	 public static void createUser()
	 {
		 String username = "Ankur"+randomAlphaNumeric(6);
		 int employeenumberbefore = generateRandomInt(6);
		 String EmpNo = Integer.toString(employeenumberbefore);
		 String nickName = username;
		 String Emai = "ankur.leekha@hybrent.com";
		 String Password = "goouser";
		 clickOn(_OR.user_Addbutton);
		 waitForElementToDisplay(_OR.user_addUser_header, 21);
		 verifyElementText(_OR.user_addUser_header, "Add User");
		 verifyElementText(_OR.user_addUser_User_LabelName, "Name*");
		 verifyElementText(_OR.user_addUser_User_LabelEmpno, "Employee Number*");
		 verifyElementText(_OR.user_addUser_User_Labelnickname, "Nickname*");
		 verifyElementText(_OR.user_addUser_User_Labelemail, "Email*");
		 verifyElementText(_OR.user_addUser_User_Labelphone, "Phone");
		 verifyElementText(_OR.user_addUser_User_Labelpassword, "Password*");
		 verifyElementText(_OR.user_addUser_User_Labelcon_password, "Confirm password*");
		 verifyElementText(_OR.user_addUser_User_Labelfacility, "Facility*");
		 verifyElementText(_OR.user_addUser_User_Labelinventory, "Inventory*");
		 verifyElementText(_OR.user_addUser_User_Labeldepartment, "Department*");
		 verifyElementText(_OR.user_addUser_User_Labeljoining_date, "Joining Date");
		 verifyElementText(_OR.user_addUser_User_Labelstatus, "Status");
		 typeIn(_OR.user_addUser_User_inputName, username);
		 setProperty("created_NeUser",username);
		 setProperty("created_NewPassword",Password);
		 typeIn(_OR.user_addUser_User_inputemployee_no, EmpNo);
		 typeIn(_OR.user_addUser_User_inputnickname, nickName);
		 typeIn(_OR.user_addUser_User_inputemail, Emai);
		 typeIn(_OR.user_addUser_User_inputpassword, Password);
		 typeIn(_OR.user_addUser_User_inputconfirmPass, Password);
	 }
	 
	 
	 public static void userAddFacility()
	 {
		 String  FacilityName = "TestName"+randomAlphaNumeric(5);
		 String DeptName  = "Test-Dept"+generateRandomInt(6);
		 String InvetoryName = "Inventory"+randomAlphaNumeric(5);
		 setProperty("UserAddInvetoryName",InvetoryName);
		 setProperty("UserAddDeptName",DeptName);
		 setProperty("UserAddfailityName",FacilityName);
		 String Mnemonic = "Mn"+randomAlphaNumeric(8);
		 int Licensebefore = generateRandomInt(6);
		 String License = Integer.toString(Licensebefore);
		 clickOn(_OR.user_addUser_User_Addfacility);
		 verifyElementText(_OR.user_addUser_Facility, "Add Facility");
		 verifyElementText(_OR.user_addUser_Facilitydetail_Organization, "Organization*");
		 verifyElementText(_OR.user_addUser_Facilitydetail_Mneonic, "Mnemonic*");
		 verifyElementText(_OR.user_addUser_Facilitydetail_name, "Name*");
		 verifyElementText(_OR.user_addUser_Facilitydetail_licence, "License Count*");
		 typeIn(_OR.user_addUser_Facilitydetail_input_Mneonic, Mnemonic);
		 typeIn(_OR.user_addUser_Facilitydetail_input_name, FacilityName);
		 typeIn(_OR.user_addUser_Facilitydetail_input_license_count, License);
		 addFacilityAddress();
		 addFacilityInvoiceAddress();
		 clickOn(_OR.user_addUser_Facilitydetail_save);
		 selectFromDropdown(_OR.user_addUser_Facilitydetail_input_Facilityselect, FacilityName);
		 addDepartment();
		 selectFromDropdown(_OR.user_addUser_Facilitydetail_input_department_idselect, getProperty("UserAddDeptName"));
		 addInventory();
		 waitForElement(_OR.user_addUser_Facilitydetail_selec_inventory, 20);
		 selectFromDropdown(_OR.user_addUser_Facilitydetail_selec_inventory, getProperty("UserAddInvetoryName"));
	 }
	 
	 public static void addFacilityAddress()
	 {
		 
		 String Address1 = "Address1"+randomAlphaNumeric(5);
		 String Address2  = "Address2"+randomAlphaNumeric(5);
		 String city  = "city"+randomAlphaNumeric(5);
		 String County  = "County"+randomAlphaNumeric(5);
		 String state  = "state"+randomAlphaNumeric(5);
		 String country  = "County"+randomAlphaNumeric(5);
		 int pincodebefore = generateRandomInt(6);
		 String pincode = Integer.toString(pincodebefore);
		 clickOn(_OR.user_addUser_ShippingAddress);
		 typeIn(_OR.user_addUser_ShippingAddress_input_Address1, Address1);
		 typeIn(_OR.user_addUser_ShippingAddress_input_Address2, Address2);
		 typeIn(_OR.user_addUser_ShippingAddress_input_city, city);
		 typeIn(_OR.user_addUser_ShippingAddress_input_state, state);
		 typeIn(_OR.user_addUser_ShippingAddress_input_county, County);
		 typeIn(_OR.user_addUser_ShippingAddress_input_postal_code, pincode);
		 typeIn(_OR.user_addUser_ShippingAddress_input_country, country);
		 
	 }
	 
	 public static void addFacilityInvoiceAddress()
	 {
		 String Address1 = "Address1"+randomAlphaNumeric(5);
		 String Address2  = "Address2"+randomAlphaNumeric(5);
		 String city  = "city"+randomAlphaNumeric(5);
		 String County  = "County"+randomAlphaNumeric(5);
		 String country  = "County"+randomAlphaNumeric(5);
		 String state  = "state"+randomAlphaNumeric(5);
		 int pincodebefore = generateRandomInt(6);
		 String pincode = Integer.toString(pincodebefore);
		 clickOn(_OR.user_addUser_InvoiceAddress);
		 typeIn(_OR.user_addUser_InvoiceAddress_input_Address1, Address1);
		 typeIn(_OR.user_addUser_InvoiceAddress_input_Address2, Address2);
		 typeIn(_OR.user_addUser_InvoiceAddress_input_city, city);
		 typeIn(_OR.user_addUser_InvoiceAddress_input_county, County);
		 typeIn(_OR.user_addUser_InvoiceAddress_input_state, state);
		 typeIn(_OR.user_addUser_InvoiceAddress_input_postal_code, pincode);
		 typeIn(_OR.user_addUser_InvoiceAddress_input_country, country);
		 
	 }
	 
	 public static void addDepartment()
	 {
		 String Mnemonic = "Test";
		 
		 clickOn(_OR.user_addUser_AddDepartment);
		 verifyElementText(_OR.user_addUser_DepartmentTitle, "Add Department");
		 selectFromDropdown(_OR.user_addUser_addDepartment_facilityselect, getProperty("UserAddfailityName"));
		 typeIn(_OR.user_addUser_addDepartment_Mnemonic, Mnemonic);
		 typeIn(_OR.user_addUser_addDepartment_name, getProperty("UserAddDeptName"));
		 clickOn(_OR.user_addUser_addDepartment_save);
	 }
	 
	 public static void addInventory()
	 {
		 clickOn(_OR.user_addUser_addinventorybtn);
		 waitForElement(_OR.user_addUser_addinventory_title, 30);
		 verifyElementText(_OR.user_addUser_addinventory_title, "Add Inventory Location");
		 typeIn(_OR.user_addUser_addinventory_Name, getProperty("UserAddInvetoryName"));
		 selectFromDropdown(_OR.user_addUser_addinventory_facilityselect, getProperty("UserAddfailityName"));
		 clickOn(_OR.user_addUser_addinventory_facilitysave);
	 }
	 
	 public static void userAccessTab()
	 {
		 clickOn(_OR.user_addUser_tab);
		 String accessON = getAttributeValue(_OR.user_addUser_input_accesscustomer, "class");
		 if(accessON.contains("bootstrap-switch-off"))
		 {
			 clickOn(_OR.user_addUser_input_accesscustomer);
		 }
		 String Preferedcard = getAttributeValue(_OR.user_addUser_input_pref_card_manager, "class");
		 if(Preferedcard.contains("bootstrap-switch-off"))
		 {
			 clickOn(_OR.user_addUser_input_pref_card_manager);
		 }
		 String CreatePreferedcard = getAttributeValue(_OR.user_addUser_input_Createpref_card_manager, "class");
		 if(CreatePreferedcard.contains("bootstrap-switch-off"))
		 {
			 clickOn(_OR.user_addUser_input_Createpref_card_manager);
		 }
		 String EditPreferedcard = getAttributeValue(_OR.user_addUser_input_Editpref_card_manager, "class");
		 if(EditPreferedcard.contains("bootstrap-switch-off"))
		 {
			 clickOn(_OR.user_addUser_input_Editpref_card_manager);
		 }
		 String DeletePreferedcard = getAttributeValue(_OR.user_addUser_input_Deletepref_card_manager, "class");
		 if(DeletePreferedcard.contains("bootstrap-switch-off"))
		 {
			 clickOn(_OR.user_addUser_input_Deletepref_card_manager);
		 }
		 String createprocedure = getAttributeValue(_OR.user_addUser_input_createprocedure, "class");
		 if(createprocedure.contains("bootstrap-switch-off"))
		 {
			 clickOn(_OR.user_addUser_input_createprocedure);
		 }
		 String EditProcedure = getAttributeValue(_OR.user_addUser_input_Editprocedure, "class");
		 if(EditProcedure.contains("bootstrap-switch-off"))
		 {
			 clickOn(_OR.user_addUser_input_Editprocedure);
		 }
		 String Deleteprocedure = getAttributeValue(_OR.user_addUser_input_Deleteprocedure, "class");
		 if(Deleteprocedure.contains("bootstrap-switch-off"))
		 {
			 clickOn(_OR.user_addUser_input_Deleteprocedure);
		 }
//		 String vendor = getAttributeValue(_OR.user_addUser_input_vendor_representative, "class");
//		 if(vendor.contains("bootstrap-switch-off"))
//		 {
//			 clickOn(_OR.user_addUser_input_vendor_representative);
//		 }
		 String bill_only = getAttributeValue(_OR.user_addUser_input_approveBillonly, "class");
		 if(bill_only.contains("bootstrap-switch-off"))
		 {
			 clickOn(_OR.user_addUser_input_approveBillonly);
		 }
//		 String besell = getAttributeValue(_OR.user_addUser_input_is_reseller, "class");
//		 if(besell.contains("bootstrap-switch-off"))
//		 {
//			 clickOn(_OR.user_addUser_input_is_reseller);
//		 }
	 }
	 
	 public static void Itemcatalogacesstab()
	 {
		 clickOn(_OR.user_addUser_itemcatalogacess);
		 String user_addUser_input_Additem = getAttributeValue(_OR.user_addUser_input_Additem, "class");
		 if(user_addUser_input_Additem.equals("bootstrap-switch-off bootstrap-switch-small bootstrap-switch-id-can_add_item bootstrap-switch bootstrap-switch-wrapper bootstrap-switch-animate"))
		 {
			 clickOn(_OR.user_addUser_input_Additem);
		 }
		 String user_addUser_input_Edititem = getAttributeValue(_OR.user_addUser_input_Edititem, "class");
		 if(user_addUser_input_Edititem.equals("bootstrap-switch-off bootstrap-switch-small bootstrap-switch-id-can_edit_item bootstrap-switch bootstrap-switch-wrapper bootstrap-switch-animate"))
		 {
			 clickOn(_OR.user_addUser_input_Edititem);
		 }
		 String user_addUser_input_Deleteitem = getAttributeValue(_OR.user_addUser_input_Deleteitem, "class");
		 if(user_addUser_input_Deleteitem.equals("bootstrap-switch-off bootstrap-switch-small bootstrap-switch-id-can_delete_item bootstrap-switch bootstrap-switch-wrapper bootstrap-switch-animate"))
		 {
			 clickOn(_OR.user_addUser_input_Deleteitem);
		 }
	 }
	 
	 public static void selectFacility()
	 {
		 clickOn(_OR.user_addUser_FacilityAccess);
		 selectFromDropdown(_OR.user_addUser_failityaccess_Select, getProperty("UserAddfailityName"));
		 if(isElementDisplayed(_OR.user_addUser_failityaccess_facilityadd))
		 {
			 clickOn(_OR.user_addUser_failityaccess_facilityadd);
			 if(isElementDisplayed(_OR.user_addUser_failityaccess_SelectAll))
			 {
				 clickOn(_OR.user_addUser_failityaccess_SelectAll);
			 }
		 }
	 }
	 
	 public static void Addvendor()
	 {
		 clickOn(_OR.user_addUser_vendoraccess);
		 verifyElementText(_OR.user_addUser_vendoraccess_selectventorlabel, "Select Vendors");
		 clickOn(_OR.user_addUser_Addvendor);
//		 typeIn(_OR.user_addUser_Addvendor_input, "AAA WHOLESALE");
//		 if(isElementDisplayed(_OR.user_addUser_Addvendor_add))
//		 {
//			 clickOn(_OR.user_addUser_Addvendor_add);
//		 }
		 typeIn(_OR.user_addUser_Addvendor_input, "Medline");
		 if(driver.findElements(By.xpath("(//*[@ng-click='selectItem(item.name,item.id)'])[1]")).size()!=0)
		 {
			 clickOn(_OR.user_addUser_Addvendor_add);
		 }
//		 typeIn(_OR.user_addUser_Addvendor_input, "Medline Industries");
//		 if(isElementDisplayed(_OR.user_addUser_Addvendor_add))
//		 {
//			 clickOn(_OR.user_addUser_Addvendor_add);
//		 }
//		 typeIn(_OR.user_addUser_Addvendor_input, "MCKESSON");
//		 if(isElementDisplayed(_OR.user_addUser_Addvendor_add))
//		 {
//			 clickOn(_OR.user_addUser_Addvendor_add);
//		 }
		 typeIn(_OR.user_addUser_Addvendor_input, "McKesson");
		 if(driver.findElements(By.xpath("(//*[@ng-click='selectItem(item.name,item.id)'])[1]")).size()!=0)
		 {
			 clickOn(_OR.user_addUser_Addvendor_add);
		 }
		 typeIn(_OR.user_addUser_Addvendor_input, "HENRY SCHEIN");
		 if(driver.findElements(By.xpath("(//*[@ng-click='selectItem(item.name,item.id)'])[1]")).size()!=0)
		 {
			 clickOn(_OR.user_addUser_Addvendor_add);
		 }
		 typeIn(_OR.user_addUser_Addvendor_input, "ALCON LABORATORIES INC");
		 if(driver.findElements(By.xpath("(//*[@ng-click='selectItem(item.name,item.id)'])[1]")).size()!=0)
		 {
			 clickOn(_OR.user_addUser_Addvendor_add);
		 }
	 }
	 
	 public static void Terms()
	 {
		 verifyElementText(_OR.user_Terms, "Terms");
		 verifyElement(_OR.user_Agree);
			WebElement element = driver.findElement(By.xpath("//button[@ng-click='termCtrl.agree(true)']"));
			Actions actions = new Actions(driver);
			actions.moveToElement(element);
			clickOn(_OR.user_Agree);
			waitForElement(_OR.user_PrivacyPolicy, 10);
			actions.moveToElement(element);
			clickOn(_OR.user_Agree);
			waitForElement(_OR.user_TearmsService, 10);
			verifyElementText(_OR.user_TearmsService, "HYBRENT TERMS OF SERVICE");
			waitForElement(_OR.user_Agree);
			actions.moveToElement(element);
			waitForElement(_OR.user_Agree);
			clickOn(_OR.user_Agree);
			waitTime(3);
			actions.moveToElement(element);
			clickOn(_OR.user_Agree);
			waitForElement(_OR.user_OpenSourceApplication, 10);
			actions.moveToElement(element);
			clickOn(_OR.user_Agree);
			waitTime(3);
			actions.moveToElement(element);
			clickOn(_OR.user_Agree);
			//waitForElementToDisplay(_OR.user_readnotes_GeneralImprovement, 20);
			waitTime(3);
			if(driver.findElements(By.xpath("//b[text()='Terms']")).size()!=0)
			{
				actions.moveToElement(element);
				clickOn(_OR.user_Agree);
			}
			
			WebElement element2 = driver.findElement(By.xpath("//button[@ng-click='readNote()']"));
			actions.moveToElement(element2);
			if(driver.findElements(By.xpath("//*[@id='toast-container']/div/div/button")).size()!=0)
			{
				driver.findElement(By.xpath("//*[@id='toast-container']/div/div/button")).click();
			}
			waitTime(3);
			waitForElementToDisplay(_OR.user_readnotes_ok, 10);
			clickOn(_OR.user_readnotes_ok);
	 }
	 
}