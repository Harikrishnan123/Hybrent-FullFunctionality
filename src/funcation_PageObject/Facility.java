package funcation_PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;
import AutomationFramework._OR;

public class Facility extends ApplicationKeyword{
 
	 public static void NavigateHometoFacility()
	 {
		 clickOn(_OR.DashBoard_Admin);
		 clickOn(_OR.DashBoard_Admin_facility);
		
	 }
	 
	 public static void verifyFacilityPage()
	 {
		 getTextchild("//*[@class='pagehead']");
		 clickOn(OR.Facilities_Plus_First);
		 verifyElementText(OR.Facilities_FacilityHeader,"Departments Name");
	 }
	 
	 public static void CreateFacility()
	 {
		 clickOn(OR.Facilities_Add_Btn_Facility);
		 String  FacilityName = "TestName"+randomAlphaNumeric(5);
		 String DeptName  = "Test-Dept"+generateRandomInt(6);
		 String InvetoryName = "Inventory"+randomAlphaNumeric(5);
		 setProperty("UserAddInvetoryName",InvetoryName);
		 setProperty("UserAddDeptName",DeptName);
		 setProperty("UserAddfailityName",FacilityName);
		 String Mnemonic = "Mn"+randomAlphaNumeric(8);
		 int Licensebefore = generateRandomInt(6);
		 String License = Integer.toString(Licensebefore);
		 verifyElementText(_OR.user_addUser_Facility, "Add Facility");
		 verifyElementText(_OR.user_addUser_Facilitydetail_Organization, "Organization*");
		 verifyElementText(_OR.user_addUser_Facilitydetail_Mneonic, "Mnemonic*");
		 verifyElementText(_OR.user_addUser_Facilitydetail_name, "Name*");
		 verifyElementText(_OR.user_addUser_Facilitydetail_licence, "License Count*");
		 typeIn(_OR.user_addUser_Facilitydetail_input_Mneonic, Mnemonic);
		 typeIn(_OR.user_addUser_Facilitydetail_input_name, FacilityName);
		 typeIn(_OR.user_addUser_Facilitydetail_input_license_count, License);
		 if(driver.findElements(By.className("bootstrap-switch-handle-off")).size()!=0)
		 {
			 driver.findElement(By.className("bootstrap-switch-handle-off")).click();
			 String oone = System.getProperty("user.dir")+"\\assets\\1.jpeg";
			 driver.findElement(By.xpath("//*[@type='file']")).sendKeys(oone);
		 }
	
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
		 clickOn(OR.Facilities_Save);
	 }
	 
	 public static void verifyFacilityName()
	 {
		 typeIn(OR.Facility_Search,  getProperty("UserAddfailityName"));
		 clickOn(OR.Invoice_SearchButton);
		 waitTime(5);
		 String one = driver.findElement(By.xpath("//*[@id='reqListing']/tbody[1]/tr/td[1]")).getText();
		 if(one.contains(getProperty("UserAddfailityName")))
		 {
			 testLogPass("Created Facility is present");
			 clickOn(OR.Facilities_Edit_First);
			 if(getText(OR.Facility_Edit).contains("Edit Facility"))
			 {
				 testLogPass("Edit Facility is present");
			 }
		 }
		 else
		 {
			 testLogFail("Created Facility is not present");
		 }
	 }
}
