package funcation_PageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;

public class Scanout extends ApplicationKeyword
{
	public static void navigateScannedoutItem()
	{
		waitForElement(OR.Scanout);
		scanned();
		waitForElement(OR.Scanout_Scanout);
		verifyElement(OR.Scanout_Scanout);
		verifyElement(OR.Scanout_scannedoutItem);
		scanned_out_items();
		waitUntilPageReady();
		getTextchild("//*[@class='pagehead']");
		verifyElement(OR.Invoice_FromDate);
		verifyElement(OR.Invoice_ToDate);
		verifyElement(OR.Order_FacilityDropDown);
		verifyElement(OR.Scanout_Inventory);
	}
	
	public static void navigateScanout()
	{
		waitForElement(OR.Scanout);
		scanned();
		waitForElement(OR.Scanout_scannedoutItem);
		verifyElement(OR.Scanout_scannedoutItem);
		verifyElement(OR.Scanout_Scanout);
		scanned_out();
		waitUntilPageReady();
		getTextchild("//*[@class='pagehead']");
		verifyElement(OR.ApprovalFlow_Refreshbtn);
	}
	
	public static void Pageverify()
	{
		verifyElement(OR.Scanout_SearchSku);
		verifyElement(OR.Scanout_Inventory);
		verifyElement(OR.Shop_Item_First);
		
	}
	
	public static void HeaderVerify()
	{
		verifyElement(OR.Barcode_ItemNameTxt);
		verifyElement(OR.Barcode_VendorTxt);
		verifyElement(OR.Barcode_SKUTxt);
	}
	
	public static void ScannedItem()
	{
		if(driver.findElements(By.xpath("//hyb-highlight/span")).size()!=0)
		{
			testLogPass("Item is present");
			testLogPass(" "+getAttributeValue(OR.Template_Color, "uib-tooltip"));
			if(isElementDisplayed(OR.Shop_ItemNameDropDown_First))
			{
				clickOn(OR.Shop_ItemNameDropDown_First);
				waitForElement(OR.DD_Edit);
				verifyElementText(OR.DD_Edit, "Edit");
				verifyElementText(OR.DD_PriceChangeHistory, "Price Change History");
				verifyElementText(OR.DD_PurchaseHistory, "Purchase History");
				clickOn(OR.Shop_ItemNameDropDown_First);
			}
		}
		else
		{
			testLogFail("Item is not present");
		}
	}
	
	
	public static void DDEdit()
	{
		waitForElement(OR.Shop_ItemNameDropDown_First, 20);
		clickOn(OR.Shop_ItemNameDropDown_First);
		verifyElementText(OR.DD_Edit, "Edit");
		clickOn(OR.DD_Edit);
		waitForElement(OR.EditItem_text);
		verifyElementText(OR.EditItem_text, "Edit Item");
		clickOn(OR.Invoice_closeButton);
	}
	
	public static void DD_PriceChangeHistory()
	{
		
		waitForElement(OR.Shop_ItemNameDropDown_First, 20);
		clickOn(OR.Shop_ItemNameDropDown_First);
		verifyElementText(OR.DD_PriceChangeHistory, "Price Change History");
		clickOn(OR.DD_PriceChangeHistory);
		waitForElement(OR.PriceChangeDetails_current_text);
		verifyElementText(OR.PriceChangeDetails_current_text, "Current Price");
		int Size = driver.findElements(By.xpath("//table[@class='table table-striped']/thead/tr/th")).size();
		for(int i=1;i<=Size;i++)
		{
			String one = driver.findElement(By.xpath("(//table[@class='table table-striped']/thead/tr/th)["+i+"]")).getText();
			testLogPass("Column name is "+one);
		}
		clickOn(OR.PriceChangeDetails_Close);
	}
	
	public static void DD_PurchaseHistory()
	{
		waitUntilPageReady();
		waitForElement(OR.Shop_ItemNameDropDown_First, 20);
		clickOn(OR.Shop_ItemNameDropDown_First);
		verifyElementText(OR.DD_PurchaseHistory, "Purchase History");
		clickOn(OR.DD_PurchaseHistory);
		getTextchild("//*[@class='modal-title']");
		int Size = driver.findElements(By.xpath("//table[@class='table table-hover customtable']/thead/tr/th")).size();
		for(int i=1;i<=Size;i++)
		{
			String one = driver.findElement(By.xpath("(//table[@class='table table-hover customtable']/thead/tr/th)["+i+"]")).getText();
			String one1 = driver.findElement(By.xpath("(//*[@id='populate_items_pdf']/tr/td)["+i+"]")).getText();
			testLogPass("Column name is "+one+" and the value is "+one1);
		}
		clickOn(OR.PriceChangeDetails_Close);
	}
	
	
	public static void funcScanout_btn() 
	{
		waitUntilPageReady();
		typeIn(OR.ItemcaCategory_EditCategory_Input_Search, "07983-02");
		clickOn(OR.Scanout_Searchbtn);
		
		if(driver.findElements(By.xpath("//*[@id='btnAdd' and contains(text(),'Scanout')]")).size()!=0)
		{
			clickOn(OR.Scanout_btn);	
			if(driver.findElements(By.xpath("//*[contains(text(),'Warning')]")).size()!=0)
			{
				clickOn(OR.Login_okay);
			}
		}

		
			verifyElement(OR.Scanout_Scanoutitem);
			String one = driver.findElement(By.xpath("(//nobr/span)[1]")).getText();
			clickOn(OR.Paintet_First);
			waitUntilPageReady();
			String two = driver.findElement(By.xpath("(//nobr/span)[1]")).getText();
			if(one.contains(two))
			{
				testLogFail("Item is Not increassed");
			}
			else
			{
				testLogPass("Item is increassed");
			}
			
			clickOn(OR.Scanout_Minus);
			waitUntilPageReady();
			String two1 = driver.findElement(By.xpath("(//nobr/span)[1]")).getText();
			if(one.contains(two1))
			{
				testLogPass("Item is decreased");
			}
			else
			{
				testLogFail("Item is increassed");
			}
			
			clickOn(OR.Scanout_Qty);
			waitForElement(OR.ItemCatalog_SaveButton);
			typeIn(OR.Scanout_Input_Qty, "-1");
			clickOn(OR.ItemCatalog_SaveButton);
			waitForElement(OR.Scanout_Input_validation);
			verifyElementText(OR.Scanout_Input_validation,"Unit can not be less than Zero.");
			clickOn(OR.Login_okay);
			waitForElement(OR.Scanout_Qty);
			clickOn(OR.Scanout_Qty);
			typeIn(OR.Scanout_Input_Qty, "0");
			waitForElement(OR.MyCart_cancelQty);
			clickOn(OR.ItemCatalog_SaveButton);
			waitUntilPageReady();
			typeIn(OR.ItemcaCategory_EditCategory_Input_Search, "07983-02");
			clickOn(OR.Scanout_Searchbtn);
			waitUntilPageReady();
			if(driver.findElements(By.xpath("//*[@id='btnAdd' and contains(text(),'Scanout')]")).size()!=0)
			{
				clickOn(OR.Scanout_btn);	
				if(driver.findElements(By.xpath("//*[contains(text(),'Warning')]")).size()!=0)
				{
					clickOn(OR.Login_okay);
				}
			}
	}
	
	public static void ScanOutdetails()
	{
		waitForElement(OR.Scanout_Scanoutitem);
		clickOn(OR.Scanout_Scanoutitem);
		waitUntilPageReady();
		getTextchild("//*[@class='pagehead']");
		typeIn(OR.Scanout_SearchComment, "test");
		verifyElement(OR.Scanout_Complete);
		verifyElement(OR.Scanout_Close);
		clickOn(OR.Scanout_Complete);
	}
	
	public static void scanned_out_items()
	{	 
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//*[@href='#/inventory/scanned-out-items']"));
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		clickOn(OR.Scanout_scannedoutItem);
	}
	
	public static void scanned_out()
	{	 
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//*[@href='#/inventory/scan-out']"));
		je.executeScript("arguments[0].scrollIntoView(true);",element);
	clickOn(OR.Scanout_Scanout);
	}
	
	public static void scanned()
	{	 
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Scan out')]"));
		je.executeScript("arguments[0].scrollIntoView(true);",element);
	clickOn(OR.Scanout);
	}
}
	
	
