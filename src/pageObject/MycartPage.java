package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;
import AutomationFramework.Generickeywords;


public class MycartPage extends ApplicationKeyword{

	public static void verificationMycartPage()
	{
		clickOn(OR.MyCart);
		getText(OR.MyCart_cartFor);
		getText(OR.MyCart_cartFor_Details);
		verifyPageTitle("My Cart");
	}


	public static boolean boolcheckCartIsEmpty()
	{

		if(isElementDisplayed(OR.MyCart_drillDown))
		{
			return false;
		}

		return true;

	}

	public static void checkIfCartIsEmpty()
	{	waitForElement(OR.MyCart_drillDownDiv);
		if(isElementDisplayedwithoutFail(OR.MyCart_drillDownDiv, 10))
		{
			System.out.println("________Drill down is present");
			clickOn(OR.MyCart_drillDownDiv);
			waitForElement(OR.MyCart_clearAllCarts2);
			clickOn(OR.MyCart_clearAllCarts2);
			waitForElement(OR.MyCart_yesInPopup);
			clickOn(OR.MyCart_yesInPopup);
			waitForElement(OR.MyCart_OKInPopup);
			clickOn(OR.MyCart_OKInPopup);
		}
		else
		{
			testLogPass("NO item is present in Any cart");	
		}
	}

	public static boolean cartEmpty()
	{	
		if(isElementDisplayedwithoutFail(OR.MyCart_drillDownDiv, 10))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	
	public static void searchItem()
	{	
		String ItemDescription=getProperty("ItemDesc");
		typeIn(OR.MyCart_searchInCart, ItemDescription );
		waitForElementToDisplayWithoutFail(OR.MyCart_firstItemName, 10);
		String ItemName=getText(OR.MyCart_firstItemName);
		System.out.println(ItemName);
		waitForElementToDisplayWithoutFail(OR.MyCart_firstItemName, 10);
		if(ItemName.equalsIgnoreCase(ItemDescription))
		{
			testLogPass("Item is searched with " + ItemName);
		}
		else
		{
			testLogFail("Item is not searched with " + ItemName);			
		}
		clearEditBox(OR.MyCart_searchInCart);
		waitForElementToDisplay(OR.MyCart_searchInCart, 15);
		String SkuName=getProperty("Sku");
		typeIn(OR.MyCart_searchInCart,SkuName);
		waitForElementToDisplayWithoutFail(OR.MyCart_searchInCart, 15);
		String getskuName=getText(OR.MyCart_firstItemSkuName);
		System.out.println(getskuName);
		waitForElementToDisplayWithoutFail(OR.MyCart_firstItemName, 15);
		if(getskuName.equalsIgnoreCase(SkuName))
		{
			testLogPass("Item is searched with " + SkuName);
		}
		else
		{
			testLogFail("Item is not searched with " + SkuName);			
		}	
		clearEditBox(OR.MyCart_searchInCart);
		waitForElementToDisplayWithoutFail(OR.MyCart_searchInCart, 15);
		String ItemMfrNumber=getProperty("ItemMfr");
		typeIn(OR.MyCart_searchInCart,ItemMfrNumber);
		waitForElementToDisplayWithoutFail(OR.MyCart_searchInCart, 15);
		if(ItemName.equalsIgnoreCase(ItemDescription))
		{
			testLogPass("Item is searched with " + ItemMfrNumber);
		}
		else
		{
			testLogFail("Item is not searched with " + ItemMfrNumber);			
		}		

	}

	public static void showTourPopUP()
	{
		waitForElement(OR.MyCart_drillDownDiv);

		clickOn(OR.MyCart_drillDownDiv);
		clickOn(OR.Receive_ShowTour);
		String s=getText(OR.MyCart_showtourtextONPOPUP);	
	}

	public static void chkMan_level(String mfrToreterive)
	{	
		if(isElementDisplayed(OR.ItemCatalog_AddItem_ItemDetails_MfrDetails, 10))
		{
			String mfr=getProperty(mfrToreterive);
			typeIn(OR.ItemCatalog_AddItem_ItemDetails_MfrDetails, mfr);
			clickOn(OR.ItemCatalog_AddItem_ItemDetails_MfrDetailsDropdown);
			waitForElementToDisplayWithoutFail(OR.ItemCatalog_AddItem_Man_Select, 30);
			clickOn(OR.ItemCatalog_AddItem_Man_Select);
		}
	}

	public static String getFac()
	{
		waitForElement(OR.Shop_Menu);
		clickOn(OR.Shop_Menu);		
		waitForElementToDisplayWithoutFail(OR.Shop_wait, 10);
		String facility_Name=getText(OR.Shop_SHopfor_getfacilityName);
		setProperty("userdefaultFac", facility_Name);
		return facility_Name;
		
		
	}
	
	public static void matchFac(String facName)
	{	
	clickOn(OR.Shop_SHopfor_ShopfaclitySelect);
	waitForElementToDisplayWithoutFail(OR.Shop_SHopfor_Shopfaclity, 10);
	verifyElementText(OR.Shop_SHopfor_Shopfaclity, "Select Facility");
	typeIn(OR.Invoice_SearchInInvoiceTextBox, facName);	
	int one = driver.findElements(By.xpath("(//*[@class='table table-responsive table-striped table-bordered']//tbody//td[1])")).size();
	boolean facFound=false;
	String selectedFacility;
	WebElement btn;
	for(int i=1; i<=one; i++)
	{
		selectedFacility=driver.findElement(By.xpath("(//*[@class='table table-responsive table-striped table-bordered']//tbody//td[1])["+i+"]")).getText();
		//System.out.println(selectedFacility);
		if(selectedFacility.equals(facName))
		{  
			facFound=true;
			btn= driver.findElement(By.xpath("(//*[starts-with(@class, 'table table-responsive')]//tbody//td[1])/following-sibling::td//button"));
			if(btn.getAttribute("disabled")!=null)
			{
				testLogPass("Go the text '"+selectedFacility+ "' Matches with selected Facility" );
			}
			else
			{
				testLogFail("'" + facName + "' is not selected in popup." );
			}
			break;
		}
	}
	if(!facFound)
	{
		testLogFail("Could not Got the text '"+facName+ "' Matches with selected Facility" );
	}
	clickOn(OR.Shop_SHopfor_cancelButtonPopup);
	}
}
