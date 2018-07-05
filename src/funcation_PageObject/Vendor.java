package funcation_PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;
import AutomationFramework._OR;

public class Vendor extends ApplicationKeyword{
    
	public static void NavigateToVendor()
	{
		 clickOn(_OR.DashBoard_Admin);
		 clickOn(_OR.DashBoard_Admin_vendor);
		 verifyElementText(OR.Vendor_Title,"MANAGE VENDORS");
	}
	
	public static void verifyVendor()
	{
		verifyElement(OR.manufacturer_searchby);
		Select select = new Select(driver.findElement(By.xpath("//*[@id='search-status']")));
		WebElement option = select.getFirstSelectedOption();
		String defaultItem = option.getText();
		testLogPass("Default value selected in the drop down is '"+defaultItem);
		verifyElement(OR.Vendor_EditFirst);
		if(driver.findElements(By.className("grid-item")).size()!=0)
		{
			testLogPass("Vendor are in grid view");
		}
		System.out.println(defaultItem );
		int SIze = driver.findElements(By.xpath("//*[@id='search-status']/option")).size();
		for(int i=1;i<=SIze;i++)
		{
			String one  = driver.findElement(By.xpath("(//*[@id='search-status']/option)["+i+"]")).getText();
			testLogPass("Status drop down value are "+one);
		}
		verifyPagination();
		verifyElement(OR.Vendor_InternalCode);
	}
	
	
	public static void verifyEdit()
	{
		List<WebElement> Name = driver.findElements(By.className("grid-item-name"));
		String NameinVendor = Name.get(1).getText();
		waitForElement(OR.Vendor_EditFirst);
		mouseOver(OR.Vendor_EditFirst);
		clickOn(OR.Vendor_EditFirst);
		String AttributeName = driver.findElement(By.xpath("//*[@id='name']")).getAttribute("value");
		if(NameinVendor.contains(AttributeName))
		{
			testLogPass("Vendor name are same");
		}
		verifyElement(OR.Vendor_txt);
		verifyElement(OR.Vendor_Address);
		verifyElement(OR.Vendor_Interface);
		verifyElement(OR.Vendor_UOM);
		verifyElement(OR.Vendor_Customersupport);
		verifyElement(OR.Vendor_SalesRepresentative);
	}
	
	public static void EditAddressFIeld()
	{
		verifyElement(OR.Vendor_Edit_NameLabel);
		verifyElement(OR.Vendor_Edit_SecondName_Label);
		verifyElement(OR.Vendor_Edit_ThirdName_Label);
		verifyElement(OR.Vendor_Edit_SupportCutoffLabel);
		verifyElement(OR.Vendor_Edit_Logo_Label);
		verifyElement(OR.Vendor_Edit_ConsignmentSupport_Label);
		verifyElement(OR.Vendor_Edit_LimitSupport_Label);
		verifyElement(OR.Vendor_Edit_MinPOAmount_Label);
		verifyElement(OR.Vendor_Edit_PriceUpdate855_Label);
		verifyElement(OR.Vendor_Edit_PriceUpdate810_Label);
		verifyElement(OR.Vendor_Edit_Payment_Term_Label);
		verifyElement(OR.Vendor_Edit_Status_Label);
		if(getAttributeValue(OR.ItemCatalog_txt_Addmanufacture_Name, "disabled").contains("disabled"))
		{
			testLogPass("Name field not able edit");
		}
		if(getAttributeValue(OR.ItemCatalog_txt_Addmanufacture_Name, "disabled").contains("disabled"))
		{
			testLogPass("Name field not able edit");
		}
		typeIn(OR.Vendor_Edit_SecondName_Input, "SecondName");
		typeIn(OR.Vendor_Edit_third_name_Input, "ThirdName");
		clickOn(OR.Vendor_Edit_PunchOutOn);
		clickOn(OR.Vendor_Edit_Priceupdate855);
		clickOn(OR.Vendor_Edit_Priceupdate810);
		clickOn(OR.Vendor_Edit_StatusInput);
		
		String Attribute = driver.findElement(By.xpath("//*[text()='Support Cut Off Time']/following-sibling::div/div")).getAttribute("class");
				if(Attribute.contains("bootstrap-switch-off"))
				{
					testLogPass("Support Cut Off button is in off state");
				}
				else
				{
					testLogPass("Support Cut Off button is in ON state");
				}
	}
	
	public static void ONOFFToggle(String objLocator, String attributeName)
	{
		String Attribute = getAttributeValue(objLocator, attributeName);
		if(Attribute.contains("bootstrap-switch-off"))
		{
			testLogPass("Toggle button is Off");
		}
		else
		{
			testLogPass("Toggle button is ON");
		}
		clickOn(objLocator);
		String Attribute1 = getAttributeValue(objLocator, attributeName);
		if(Attribute1.contains("bootstrap-switch-off"))
		{
			testLogPass("Toggle button is Off");
		}
		else
		{
			testLogPass("Toggle button is ON");
		}
	}
	
	public static void Address()
	{
		clickOn(OR.Vendor_Address);
		verifyElement(OR.Vendor_Address_Addressline1);
		verifyElement(OR.Vendor_Address_Addressline2);
		verifyElement(OR.Vendor_Address_City);
		verifyElement(OR.Vendor_Address_County);
		verifyElement(OR.Vendor_Address_State);
		verifyElement(OR.Vendor_Address_PostalCode);
		verifyElement(OR.Vendor_Address_Country);
		verifyElement(OR.Vendor_Address_Phone1);
		verifyElement(OR.Vendor_Address_Phone2);
		verifyElement(OR.Vendor_Address_Fax1);
		verifyElement(OR.Vendor_Address_Fax2);
		verifyElement(OR.Vendor_Address_Email1);
		verifyElement(OR.Vendor_Address_Email2);
	}
	
	public static void Interface()
	{
		clickOn(OR.Vendor_Interface);
		verifyElement(OR.Vendor_Interface_Internalcode);
		verifyElement(OR.Vendor_Interface_InterfaceType);
		verifyElement(OR.Vendor_Interface_Sendpo);
		verifyElement(OR.Vendor_Interface_SendpoUpdate);
		String one = getAttributeValue(OR.Vendor_Interface_Input_Internalcode,"disabled");
		if(one.contains("disabled"))
		{
			testLogPass("Internal code inputfiled is disabled");
		}
		verifyElement(OR.Vendor_Interface_SendpoUpdate1Des);
		verifyElement(OR.Vendor_Interface_SendpoUpdate2Des);
		int size = driver.findElements(By.xpath(".//*[@id='interface_850_type']/option")).size();
		for(int i =1;i<=size; i++)
		{
			String one2 = driver.findElement(By.xpath("(//*[@id='interface_850_type']/option)["+i+"]")).getText();
			testLogPass("Drop down value is '"+one2);
		}
	}
	
	public static void ActiveVendor()
	{
		waitUntilPageReady();
		String Attribute = getAttributeValue(OR.Vendor_Edit_StatusInput, "class");
		if(Attribute.contains("bootstrap-switch-off"))
		{
			testLogPass("Toggle button is Off");
			clickOn(OR.Vendor_Edit_StatusInput);
		}
		waitUntilPageReady();
		String one = driver.findElement(By.xpath("//*[@id='name']")).getAttribute("value");
		clickOn(OR.PriceChangeDetails_Close);
		waitUntilPageReady();
		if(driver.findElements(By.xpath("//*[contains(text(),'You have some unsaved changes, do you want to save them before leaving the page?')]")).size()!=0)
		{
			clickOn(OR.InvLoc_Add_CancelBtn);
		}
		clickOn(OR.Shop_Menu);
		waitTime(4);
		int size = driver.findElements(By.xpath("//*[@id='vendor']/option")).size();
		for(int i =1;i<=size;i++)
		{
			String one3 = driver.findElement(By.xpath("(//*[@id='vendor']/option)["+i+"]")).getText();
			if(one3.contains(one))
			{
				testLogPass("Vendor is in active mode");
			}
		}
	}
	
	public static void UOM()
	{
		clickOn(OR.Vendor_UOM);
		//verifyElement(OR.Vendor_UOM_UOM1);
	}
	public static void Customersupport()
	{
		clickOn(OR.Vendor_Customersupport);
		verifyElement(OR.Vendor_Customersupport_Name);
		verifyElement(OR.Vendor_Customersupport_Email);
		verifyElement(OR.Vendor_Customersupport_Phone);
		verifyElement(OR.Vendor_Customersupport_Addbtn);
		AddCustom();
		DeleteCustom();
	}
	
	public static void AddCustom()
	{
		clickOn(OR.Vendor_Customersupport_Addbtn);
		verifyElementText(OR.Vendor_Customersupport_Header, "Add Customer Support Info");
		verifyElement(OR.Vendor_Customersupport_Custom_Name);
		verifyElement(OR.Vendor_Customersupport_Custom_Email);
		verifyElement(OR.Vendor_Customersupport_Custom_Phone);
		verifyElement(OR.Vendor_Customersupport_Custom_Name_input);
		verifyElement(OR.Vendor_Customersupport_Custom_Email_input);
		verifyElement(OR.Vendor_Customersupport_Custom_Phone_input);
		typeIn(OR.Vendor_Customersupport_Custom_Name_input, "tes");
		typeIn(OR.Vendor_Customersupport_Custom_Name_input, "");
		typeIn(OR.Vendor_Customersupport_Custom_Email_input, "tes");
		typeIn(OR.Vendor_Customersupport_Custom_Email_input, "");
		typeIn(OR.Vendor_Customersupport_Custom_Phone_input, "tes");
		typeIn(OR.Vendor_Customersupport_Custom_Phone_input, "");
		verifyElementText(OR.Vendor_Customersupport_Custom_NameValidation, "Name cannot be blank.");
		verifyElementText(OR.Vendor_Customersupport_Custom_EmailValidation, "Email is not a valid email address.");
		verifyElementText(OR.Vendor_Customersupport_Custom_PhoneValidation, "Phone cannot be blank.");
		clickOn(OR.Vendor_Customersupport_Custom_Close);
		waitForElement(OR.Vendor_Customersupport_Addbtn);
		clickOn(OR.Vendor_Customersupport_Addbtn);
		String CustomerName ="Ankur"+randomAlphaNumeric(5);
		String CustomerEmail ="ankur.leekha@hybrent.com";
		String CustomerPhone ="1234567890";
		typeIn(OR.Vendor_Customersupport_Custom_Name_input,CustomerName);
		typeIn(OR.Vendor_Customersupport_Custom_Email_input, CustomerEmail);
		typeIn(OR.Vendor_Customersupport_Custom_Phone_input, CustomerPhone);
		clickOn(OR.Template_Schedule_Savebtn);
		//ToastmesssageSucess();
		setProperty("vendor_CustomerName", CustomerName);
		setProperty("vendor_CustomerEmail", CustomerEmail);
		setProperty("vendor_CustomerPhone", CustomerPhone);
	}
	public static void DeleteCustom()
	{
		waitForElement(OR.SI_DeleteButton);
		clickOn(OR.SI_DeleteButton);
		verifyElementText(OR.Vendor_Customersupport_Custom_Deletevalidation, "Are you sure you want to delete selected vendor information?");
		clickOn(OR.Dep_Delete_Cancel);
		waitForElement(OR.SI_DeleteButton);
		clickOn(OR.SI_DeleteButton);
		verifyElementText(OR.Vendor_Customersupport_Custom_Deletevalidation, "Are you sure you want to delete selected vendor information?");
		clickOn(OR.Dep_Delete_Yes);
	}
	
	
	public static void Sales()
	{
		clickOn(OR.Vendor_SalesRepresentative);
		verifyElement(OR.Vendor_Sales_Name);
		verifyElement(OR.Vendor_Sales_Email);
		verifyElement(OR.Vendor_Sales_Phone);
		clickOn(OR.Vendor_Sales_Addbtn);
		typeIn(OR.Vendor_Customersupport_Custom_Name_input, "tes");
		typeIn(OR.Vendor_Customersupport_Custom_Name_input, "");
		typeIn(OR.Vendor_Customersupport_Custom_Email_input, "test");
		typeIn(OR.Vendor_Customersupport_Custom_Email_input, "");
		typeIn(OR.Vendor_Customersupport_Custom_Phone_input, "test");
		typeIn(OR.Vendor_Customersupport_Custom_Phone_input, "");
		verifyElementText(OR.Vendor_Customersupport_Custom_NameValidation, "Name cannot be blank.");
		verifyElementText(OR.Vendor_Customersupport_Custom_EmailValidation, "Email is not a valid email address.");
		verifyElementText(OR.Vendor_Customersupport_Custom_PhoneValidation, "Phone cannot be blank.");
		clickOn(OR.Vendor_Sales_Close);
		mouseOver(OR.Vendor_Sales_Addbtn);
		waitForElement(OR.Vendor_Sales_Addbtn, 30);
		clickOn(OR.Vendor_Sales_Addbtn);
		String SalesName ="SalesAnk"+randomAlphaNumeric(5);
		String SalesEmail ="ankur.leekha@hybrent.com";
		String SalesPhone ="1234567890";
		
		typeIn(OR.Vendor_Customersupport_Custom_Name_input, SalesName);
		typeIn(OR.Vendor_Customersupport_Custom_Email_input, SalesEmail);
		typeIn(OR.Vendor_Customersupport_Custom_Phone_input, SalesPhone);
		clickOn(OR.Template_Schedule_Savebtn);
		setProperty("vendor_SalesName", SalesName);
		setProperty("vendor_SalesEmail", SalesEmail);
		setProperty("vendor_SalesPhone", SalesPhone);
	}
	
	public static void Editsales()
	{
		mouseOver(OR.Vendor_Edit_Sale);
		waitForElement(OR.Vendor_Edit_Sale, 30);
//		List<WebElement> Edit =driver.findElements(By.xpath("//*[@uib-tooltip='Edit']"));
//		Edit.get(1).click();
		clickOn(OR.Vendor_Edit_Sale);
		verifyElementText(OR.Vendor_Edit_Sales_Header, "Edit Sales Representative Info");
		String SalesName ="SalesAnk"+randomAlphaNumeric(5);
		setProperty("vendor_SalesName", SalesName);
		verifyElement(OR.Vendor_Customersupport_Custom_Name);
		verifyElement(OR.Vendor_Customersupport_Custom_Email);
		verifyElement(OR.Vendor_Customersupport_Custom_Phone);
		typeIn(OR.Vendor_Customersupport_Custom_Name_input, SalesName);
		clickOn(OR.Vendor_Sales_Savebtn);
	}
	
	public static void DeleteSales() 
	{
		mouseOver(OR.Vendor_Delete_Sale);
		waitForElement(OR.Vendor_Delete_Sale, 30);
		clickOn(OR.Vendor_Delete_Sale);
		verifyElementText(OR.Vendor_Customersupport_Custom_Deletevalidation, "Are you sure you want to delete selected vendor information?");
		clickOn(OR.Dep_Delete_Cancel);
		mouseOver(OR.Vendor_Delete_Sale);
		waitForElement(OR.Vendor_Delete_Sale, 30);
		clickOn(OR.Vendor_Delete_Sale);
		verifyElementText(OR.Vendor_Customersupport_Custom_Deletevalidation, "Are you sure you want to delete selected vendor information?");
		clickOn(OR.Dep_Delete_Yes);
	}
}

