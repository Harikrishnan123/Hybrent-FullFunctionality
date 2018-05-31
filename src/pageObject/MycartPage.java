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
	{	
		if(isElementDisplayedwithoutFail(OR.MyCart_drillDownDiv, 10))
		{
			System.out.println("________Drill down is present");
			clickOn(OR.MyCart_drillDown);
			//			//clickOn(OR.MyCart_clearCurrentCart);
			clickOn(OR.MyCart_clearAllCarts2);
			waitForElementToDisplayWithoutFail(OR.MyCart_yesInPopup, 10);
			clickOn(OR.MyCart_yesInPopup);
			waitForElementToDisplayWithoutFail(OR.MyCart_OKInPopup, 10);
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

		clickOn(OR.MyCart_drillDown);
		clickOn(OR.MyCart_showTourButton);
		String s=getText(OR.MyCart_showtourtextONPOPUP);	
	}

	public static void chkMan_level(String mfrToreterive)
	{	
		if(isElementDisplayed(OR.ItemCatalog_AddItem_ItemDetails_MfrDetails, 10))
		{
			String mfr=getProperty(mfrToreterive);
			typeIn(OR.ItemCatalog_AddItem_ItemDetails_MfrDetails, mfr);
			clickOn(OR.ItemCatalog_AddItem_ItemDetails_MfrDetailsDropdown);
			if(isElementDisplayed(OR.ItemCat_SearchTextBox, 60))
			{
				typeIn(OR.ItemCat_SearchTextBox, "didosdjksjdsjdjsdhsdkjsdhshdskdhksdhs");
				verifyElementText(OR.ItemCat_NoDataAvailable, "No data available");
				typeIn(OR.ItemCat_SearchTextBox, "");
				verifyPagination();
				if(isElementDisplayed(OR.ItemCat_Import))
				{
					waitForElementToDisplay(OR.ItemCat_Import, 60);
					mouseOver(OR.ItemCat_Import);
					clickOn(OR.ItemCat_Import);
					verifyElementText(OR.manufacturer_csManufacture, "CS Manufacturers");
					if(driver.findElements(By.xpath("(//button[@class='close'])[1]")).size()!=0)
					{
						driver.findElement(By.xpath("(//button[@class='close'])[1]")).click();
						waitForElementToDisplay(OR.ItemCat_Import, 60);
						mouseOver(OR.ItemCat_Import);
						clickOn(OR.ItemCat_Import);
					}
					waitForElementToDisplay(OR.manufacturer_searchby, 60);
					verifyElementText(OR.manufacturer_searchby, "Search by");
					verifyElement(OR.manufacturer_searchTextBox);
					verifyPagination();
					if(isElementDisplayed(OR.csManufacture_AddNewimport))
					{
						clickOn(OR.csManufacture_AddNewimport);
						verifyElementText(OR.ItemCatalog_txt_Addmanufacture, "Add Manufacturer");
						verifyElementText(OR.ItemCatalog_txt_Addmanufacture_labelName, "Name*");
						String Manufacture = "Manu"+randomAlphaNumeric(10);
						typeIn(OR.ItemCatalog_txt_Addmanufacture_Name, Manufacture);
						clickOn(OR.Template_Schedule_Savebtn);
						setProperty("NewManufacture", Manufacture);
					}
				}
			}
		}
	}

	public static String getFac()
	{
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
	waitForElementToDisplayWithoutFail(OR.Shop_countoffacilities, 10);
	int one = driver.findElements(By.xpath("//*[@style='border-right: none;vertical-align: middle;']")).size();
	boolean facFound=false;
	String xpath;
	String selectedFacility;
	WebElement btn;
	for(int i=1; i<=one; i++)
	{
		xpath="(//table[@class='table table-responsive table-striped table-bordered']/tbody/tr["+i+"]";
		selectedFacility=driver.findElement(By.xpath(xpath+"/td)")).getText();
		//System.out.println(selectedFacility);
		if(selectedFacility.equals(facName))
		{  
			facFound=true;
			btn= driver.findElement(By.xpath(xpath+"/td[2]/div/button)"));
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
