package funcation_PageObject;

import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;
import pageObject.ManageInventoryPOpage;
import testCases.ManageInventory;

public class RequestServicepage extends ApplicationKeyword{
	
	public static void navigateToRequestpage()
	{
		waitForElement(OR.Request_MenuLink);
		clickOn(OR.Request_MenuLink);
	}
	
	public static void PageVerifyication()
	{
		String Header = getTextchild("//*[@class='pagehead']");
		if(Header.contains("CREATE SERVICE PO"))
		{
			testLogPass("CREATE SERVICE PO is presnet");
		}
		verifyElement(OR.Request_ServiceLocation_dropdown);
		verifyElement(OR.Request_ServiceDate_dropdown);
		verifyElement(OR.Order_Vendor_dropdown);
		verifyElement(OR.Request_Hash);
		verifyElement(OR.Request_Item);
		verifyElement(OR.Request_SKU);
		verifyElement(OR.Request_QTY);
		verifyElement(OR.Request_UOM);
		verifyElement(OR.Request_Durationtxt);
		verifyElement(OR.Request_Price);
		verifyElement(OR.Request_DiscountedPrice);
		verifyElement(OR.Request_TotalPrice);
		getAttributeValue(OR.Request_ServiceDate_dropdown, "readonly");
		clickOn(OR.Request_calander);
		String one = driver.findElement(By.className("active")).getText();
		
		Date today = new Date();  
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
		int Dec = dayOfMonth -1;
		int future = dayOfMonth -1;
		
		String DayDecrease ="DayDecrease#xpath=(//*[text()='"+Dec+"'])[1]";
		String currentDay ="DayDecrease#xpath=(//*[text()='"+dayOfMonth+"'])[1]";
		String Future ="DayDecrease#xpath=(//*[text()='"+future+"'])[1]";
		clickOn(DayDecrease);
		clickOn(OR.Request_calander);
		clickOn(currentDay);
	}
	
	public static void DropdownRequestService()
	{

		String Des = "Des"+randomAlphaNumeric(6);
		String Sku = "Sku"+randomAlphaNumeric(6);
		setProperty("requestserviceitem", Des);
		waitForElementToDisplay(OR.Request_drillDown, 20);
		clickOn(OR.Request_drillDown);
		verifyElementText(OR.Request_PrintItems, "Print Items");
		verifyElementText(OR.Request_ClearCart, "Clear Cart");
		clickOn(OR.Request_createNewService);
		verifyElementText(OR.Request_createNewServicePopUpText, "Add Service");
		verifyElement(OR.Request_Description);
		verifyElement(OR.Request_sku);
		verifyElement(OR.Request_purchasePrice);
		clickOn(OR.PriceTire_AddBtn);
		ToastmesssageSucess();
		typeIn(OR.Request_Description, Des);
		clickOn(OR.PriceTire_AddBtn);
		ToastmesssageSucess();
		typeIn(OR.Request_sku, Sku);
		clickOn(OR.PriceTire_AddBtn);
		ToastmesssageSucess();
		String price ="60";
		String Discountprice ="160";
		typeIn(OR.Request_purchasePrice, price);
		typeIn(OR.Request_Discountprice, Discountprice);
		clickOn(OR.PriceTire_AddBtn);
		ToastmesssageSucess();
		typeIn(OR.Request_purchasePrice, "120");
		typeIn(OR.Request_Discountprice, price);
		
		int size = driver.findElements(By.xpath("//select[@ng-model='itemDetail.service_duration']/option")).size();
		for(int i=1;i<=size;i++)
		{
			testLogPass("Duration lis is "+driver.findElement(By.xpath("(//select[@ng-model='itemDetail.service_duration']/option)["+i+"]")).getText());
		}
		waitForElement(OR.PriceTire_AddBtn, 20);
		clickOn(OR.PriceTire_AddBtn);
		
		waitForElement(OR.Request_getQty);
		String one = getText(OR.Request_getQty);
		int QTYBefore = Integer.parseInt(one);
		testLogPass("Before increase the count is "+QTYBefore);
		clickOn(OR.InvLoc_Add_PlusBtn);
		waitTime(2);
		String one1 = getText(OR.Request_getQty);
		int QTYAfter = Integer.parseInt(one1);
		testLogPass("After increase the count is "+QTYAfter);
		clickOn(OR.InvLoc_Add_MinusBtn);
		waitTime(2);
		String one2 = getText(OR.Request_getQty);
		int QTYDecrease = Integer.parseInt(one2);
		testLogPass("After Decrease the count is "+QTYDecrease);

		
		requestService();
		SendPoEmail();
		DeleteTwo(Des);
		}
	
	public static void DeleteTwo(String loca)
	{
		String xpathItem ="ItemName#xpath=//*[text()='"+loca+"']";
		mouseOver(xpathItem);;
		clickOn(OR.Request_Delete);
		verifyElementText(OR.Request_validation, "Are you sure you want to delete this service item ?");
		clickOn(OR.Procedure_ConfirmButton);
	
	}
	
	public static void SpecialInstruction()
	{
		verifyElement(OR.OrderDetails_SpecialInstruction);
		String one =getTextchild("//label[@class='ng-binding']");
		if(one.contains("Use my PO #"))
		{
			testLogPass("Use my PO # is present");
		}			
	}
	
	public static void NotSearchShop(String Search)
	{
		waitForElement(OR.Shop_Menu);
		clickOn(OR.Shop_Menu);
		waitForElement(OR.Shop_SHopfor_SearchBox);
		typeIn(OR.Shop_SHopfor_SearchBox, Search);
		waitForElement(OR.No_Item_Found);
		verifyElementText(OR.No_Item_Found, "No Item Found");
	}
	
	public static void NotSearchManageInventory(String Search)
	{
		mouseOver(OR.manageInv_pageLink);
		waitForElement(OR.manageInv_pageLink);
		clickOn(OR.manageInv_pageLink);
		typeIn(OR.manageInv_searchTextBox, Search);
		clickOn(OR.manageInv_searchButton);
		waitForElement(OR.No_Item_Found);
		verifyElementText(OR.No_Item_Found, "No Item Found");
	}
	
	public static void PriceItesms()
	{
		waitForElementToDisplay(OR.Request_drillDown, 20);
		clickOn(OR.Request_drillDown);
		verifyElementText(OR.Request_PrintItems, "Print Items");
		clickOn(OR.Request_PrintItems);
		waitForElement(OR.Request_PrintItems_sku);
		verifyElementText(OR.Request_PrintItems_sku, "SKU");
		verifyElementText(OR.Request_PrintItems_MFRNumber, "Mfr Number");
		verifyElementText(OR.Request_PrintItems_Quickcode, "Quick Code");
		clickOn(OR.csManufacture_Close);
	}
	
	public static void requestService()
	{
		verifyElement(OR.Request_RequestService);
		clickOn(OR.Request_RequestService);
		waitForElement(OR.Request_PrintItems_GenerateServicePo);
		verifyElement(OR.Request_PrintItems_GenerateServicePo);
		verifyElement(OR.Request_SendpoPDF);
		verifyElement(OR.Request_Printpo);
	}
	
	public static void SendPoEmail()
	{
		clickOn(OR.Request_SendpoPDF);
		waitForElement(OR.Request_Emailfield);
		clickOn(OR.Request_Addemail);
		waitForElement(OR.Request_newemail);
		typeIn(OR.Request_newemail, "ankur@hybrent.com");
		clickOn(OR.Request_addNewEmail);
		verifyElement(OR.Request_x);
		clickOn(OR.Request_x);
		clickOn(OR.Request_Addemail);
		waitForElement(OR.Request_newemail);
		typeIn(OR.Request_newemail, "ankur@hybrent.com");
		clickOn(OR.Request_addNewEmail);
		clickOn(OR.Request_GeneratePo);
		waitUntilPageReady();
		if(driver.findElements(By.xpath("//*[text()='PO Delay']")).size()!=0)
		{
			verifyElementText(OR.Request_PODElay, "PO Delay");
			clickOn(OR.Request_PODElay);
			clickOn(OR.Invoice_ConfirmButton);
			ToastmesssageSucess();
		}
	}
	
	public static void clearCard()
	{
		waitForElementToDisplay(OR.Request_drillDown, 20);
		clickOn(OR.Request_drillDown);
		verifyElementText(OR.Request_ClearCart, "Clear Cart");
		clickOn(OR.Request_ClearCart);
		verifyElementText(OR.Request_ClearCart_validation, "Are you sure you want to clear all items?");
		clickOn(OR.Dep_Delete_Cancel);
		
		waitForElementToDisplay(OR.Request_drillDown, 20);
		clickOn(OR.Request_drillDown);
		waitForElementToDisplay(OR.Request_ClearCart, 20);
		clickOn(OR.Request_ClearCart);
		waitForElementToDisplay(OR.Invoice_ConfirmButton, 20);
		clickOn(OR.Invoice_ConfirmButton);
	}
	
	
	public static void SelectVendor()
	{
		waitForElement(OR.DashBoard_AdminDropdown);
		clickOn(OR.DashBoard_AdminDropdown);
		waitForElement(OR.Admin_vendoraccountsetup);
		clickOn(OR.Admin_vendoraccountsetup);
		selectFromDropdown(OR.VendorAccSetup_VendorDropdown,getProperty("Req_vendorName") );
		int size = driver.findElements(By.xpath("(//*[text()='Account Number*']/following-sibling::div/input )")).size();
		for(int i=1;i<=size;i++)
		{
			WebElement AccType = driver.findElement(By.xpath("(//*[text()='Account Number*']/following-sibling::div/input )["+i+"]"));
			String textInsideInputBox = AccType.getAttribute("value");
			if(textInsideInputBox.isEmpty())
			{
			AccType.clear();
			AccType.sendKeys("12");
			}
		}
		mouseOver(OR.VendorAccSetup_Save);
		WebElement element = driver.findElement(By.xpath("//button[text()='Save']"));
		executor.executeScript("arguments[0].click();", element);	
		ToastmesssageSucess();
	}
}

