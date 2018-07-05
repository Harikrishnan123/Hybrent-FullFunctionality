package funcation_PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;
import pageObject.ReceivePageObject;

public class Invoices extends ApplicationKeyword{

	public static void NavigateToInvoice()
	{
		waitForElement(OR.Request_InvoicePageLink);
		clickOn(OR.Request_InvoicePageLink);
		waitForElement(OR.Order_Vendor_txt);
		verifyElementText(OR.Order_Vendor_txt, "Vendor:");
		verifyElement(OR.Invoice_VendorDropdown);
		verifyElementText(OR.Invoice_statusDropDownLabel, "Status:");
		verifyElement(OR.Invoice_statusDropdown);
		
		verifyElementText(OR.Invoice_SearchBYDueDateLabel, "Search by Due-Date");
		verifyElementText(OR.Profile_Label_Facility, "Facility");
		verifyElement(OR.Department_Facility);
		verifyElementText(OR.Invoice_OrderedByLabel, "Ordered By:");
		getText(OR.Invoice_OrderedByDropDown);
		verifyElement(OR.Invoice_Download);
		verifyElementText(OR.Order_depts_txt, "Departments");

		StatusDropdown();
		SearchbyDueDate();
		FacilityDropdown();
		getText(OR.Invoice_departmentDropDown);
		String disable = getAttributeValue(OR.Invoice_departmentDropDown, "disabled");
		if(disable.contains("disabled"))
		{
			testLogPass("Department Name is disable");
		}
	}
	
	public static void Print()
	{
		waitForElement(OR.Patient_PrintIcon);
		clickOn(OR.Patient_PrintIcon);
		waitUntilPageReady();
		getTextchild("//*[@class='ng-binding']");
		verifyElementText(OR.Invoice_Print_Invoice, "INVOICE");
		
		int sizeofprint= driver.findElements(By.xpath("//*[@id='viewer']/div/div[2]/div")).size();
		for(int i =1;i<=sizeofprint;i++)
		{
			testLogPass("Details of print pdf is "+driver.findElement(By.xpath("(//*[@id='viewer']/div/div[2]/div)["+i+"]")).getText());
		}
		clickOn(OR.ItemCatalog_Close);
		verifyPagination();
	}
	
	public static void Delete()
	{
		waitForElement(OR.Pattern_Delete);
		clickOn(OR.Pattern_Delete);
		waitUntilPageReady();
		verifyElement(OR.Template__Deletevalidation);
		clickOn(OR.MyCart_confirmButton);
		ToastmesssageSucess();
	}
	public static void SearchbyDueDate()
	{
		clickOn(OR.Invoice_SearchBYDueDateDropDowns);
		int size = driver.findElements(By.xpath("(//*[starts-with(@id,'ui-select-choices-row-')]//*[@class='ng-binding ng-scope'])")).size();
		for(int i=1 ;i<=size;i++)
		{
			WebElement getStatusvalue = driver.findElement(By.xpath("(//*[starts-with(@id,'ui-select-choices-row-')]//*[@class='ng-binding ng-scope'])["+i+"]"));
			testLogPass("Dropdown value for Search by due date is "+getStatusvalue.getText());
			if(getStatusvalue.getText().contains("Custom"))
			{
				getStatusvalue.click();	
				verifyElement(OR.Invoice_ToDate);
				verifyElement(OR.Invoice_FromDate);
				verifyElement(OR.Invoice_ToDate_calander);
				verifyElement(OR.Invoice_FromDate_calander);
			}
			
		}
	}
	
	public static void StatusDropdown()
	{
		clickOn(OR.Invoice_statusDropdown);
		int size = driver.findElements(By.xpath("(//*[starts-with(@id,'ui-select-choices-row-')]//*[@class='ng-binding ng-scope'])")).size();
		for(int i=1 ;i<=size;i++)
		{
			String getStatusvalue = driver.findElement(By.xpath("(//*[starts-with(@id,'ui-select-choices-row-')]//*[@class='ng-binding ng-scope'])["+i+"]")).getText();
			testLogPass("Dropdown value for status is "+getStatusvalue);
		}
	}
	public static void FacilityDropdown()
	{
		clickOn(OR.Department_Facility);
		int size = driver.findElements(By.xpath("(//*[starts-with(@id,'ui-select-choices-row-')])")).size();
		for(int i=1 ;i<=size;i++)
		{
			String getStatusvalue = driver.findElement(By.xpath("(//*[starts-with(@id,'ui-select-choices-row-')])["+i+"]")).getText();
			testLogPass("Dropdown value for Facility is "+getStatusvalue);
		}
	}
	
	public static void org_SettingPage()
	{
		clickOn(OR.DashBoard_AdminDropdown);
		clickOn(OR.Shop_orgpage);
		clickOn(OR.Shop_orgFeatures2Page);

	}

	public static boolean IntactAndQucikBook_Toggle()
	{
		org_SettingPage(); 
		String className=getAttributeValue(OR.orgsetting_IntactSetting, "class");
		System.out.println(className);
		String className2=getAttributeValue(OR.orgsetting_QuickBookIntegrationSetting, "class");
		System.out.println(className2);
		if(className.contains("ng-untouched ng-valid ng-empty")&&className2.contains("ng-untouched ng-valid ng-empty"))
		{
			return false;
		}
		return true;		 
	}
	
	public static void typeAndSearchInvoice()
	{	
		clickOn(OR.Request_InvoicePageLink);
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 10);
		Receive.shopFacility();
		String invoiceName=getProperty("invoiceName");
		//ReceivePageObject.selectByDefaultUser();	
		typeIn(OR.Invoice_SearchInInvoiceTextBox, invoiceName);
		clickOn(OR.Invoice_SearchButton);
	}

	public static void getUserFacility()
	{	
		clickOn(OR.Shop_Menu);
		//String facility_Name=getText(OR.Shop_SHopfor_getfacilityName);
	}
	
	
	public static void Search(String Input)
	{
		waitForElement(OR.Patient_searchTextBox);
		typeIn(OR.Patient_searchTextBox, Input);
		clickOn(OR.OP_searchButton);
		String invoice = Input.toUpperCase();
		String InputSelect ="InputElment#xpath=(//a[text()='"+invoice+"'])[1]";
		waitForElement(InputSelect);
		if(driver.findElements(By.xpath("(//a[text()='"+invoice+"'])[1]")).size()!=0)
		{
			driver.findElement(By.xpath("(//a[text()='"+invoice+"'])[1]")).click();;
			String head =driver.findElement(By.xpath("//*[@class='text-primary ng-binding']")).getText();
			if(head.contains(Input));
			{
				testLogPass("PO number appears on top '" +Input);
			}
		}
		else
		{
			testLogFail("The item  not find "+Input);
		}
		
	}
}
