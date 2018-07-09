package testCases;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import pageObject.Loginpage;
import pageObject.MycartPage;
import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;
import AutomationFramework.Generickeywords;

public class CartPage extends ApplicationKeyword{

	public static String facility_Name;
	public static String vendor_Name;	
	public static String firstCategory;
	public static String ItemDescription ;
	public static String ItemMfrNumber;
	public static String ItemTestID ;
	public static String SkuName;
	public static String aliasName;


	@Parameters({"siteName", "siteUrl"})
	@BeforeTest
	public void startReport(String siteName, String siteUrl) {
		try {
			Loginpage.URL=siteUrl + "#/login/";
			Generickeywords.DashBoardURL=siteUrl + "#/dashboard";
			String folderPath=OutputDirectory + "/" + siteName;

			File directory = new File(folderPath);
			if (! directory.exists()){
				directory.mkdir();
				// If you require it to make the entire directory path including parents,
				// use directory.mkdirs(); here instead.
			}

			extent = new ExtentReports(folderPath+"/cart.html", true);
			// extent.addSystemInfo("Environment","Environment Name")
			extent.addSystemInfo("User Name", "Ravneet");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) {
			System.out.println("--Start REPORT-Cart-Error---" + e.toString());
			//testLogFail("unable to generate the pass report " + e.toString());
		}
	}

	@Test
	public void Tc_Cart_01()
	{
		testStarts("Tc_Cart_1 and Tc_Cart_2()" , "Verify that �Select Facility� popup appears when user clicks on facility name with �Cart for� label."
				+ " Verify that selected� button appears as disabled for the facility which is displayed on Shop page.");
		System.out.println("Tc_Cart_1_2");		
		Loginpage.OpenBrowserAndLogin();		
		String fac=MycartPage.getFac();		
		System.out.println(fac);
		clickOn(OR.MyCart);
		MycartPage.matchFac(fac);

	}

	@Test
	public void Tc_Cart_03()
	{
		testStarts("Tc_Cart_03" ," Verify that user can search/scan with �Item Name, SKU, MFR� in the Add Item search field..");
		System.out.println("Tc_Cart_03");
		NavigateUrl(DashBoardURL);
		//Loginpage.OpenBrowserAndLogin();		
		addNewItem();
		clickOn(OR.MyCart);
		MycartPage.searchItem();

	}

	@Test
	public void Tc_Cart_05() throws InterruptedException
	{
		testStarts("Tc_Cart_05" ," Verify that user can change the quantity of item by clicking (+) and (-) button respectively or by entering the value and pressing tick or cancel button..");
		System.out.println("Tc_Cart_05");
		NavigateUrl(DashBoardURL);
		//Loginpage.OpenBrowserAndLogin();	
		waitForElement(OR.MyCart);
		clickOn(OR.MyCart);
		MycartPage.checkIfCartIsEmpty();
		String ItemDescription=getProperty("ItemDesc");
		System.out.println(ItemDescription);
		typeIn(OR.MyCart_searchInCart,ItemDescription);	
		waitForElement(OR.MyCart_addItemInCart);
		clickOn(OR.MyCart_addItemInCart);
		waitForElement(OR.MyCart_warningPopup);
		if(isElementDisplayedwithoutFail(OR.MyCart_warningPopup, 10))
		{ 
			System.out.println("Second if");
			clickOn(OR.MyCart_continueButton);     
		}
		waitForElement(OR.MyCart_drillDownVendor);
		typeIn(OR.MyCart_searchInCart,ItemDescription);
		waitForElement(OR.MyCart_plusIcon, 20);
		String qtyBeforeIncrease=getText(OR.MyCart_qtyOfItemBeforeAfter);
		System.out.println(qtyBeforeIncrease);
		clickOn(OR.MyCart_plusIcon);
		String qtyAfterIncrease=getText(OR.MyCart_qtyOfItemBeforeAfter);	
		int beforeplus_Items=Integer.parseInt(qtyBeforeIncrease);  
		int after_plus=Integer.parseInt(qtyAfterIncrease);
		int final_Items=beforeplus_Items+1;
		if(after_plus==final_Items)
		{
			testLogPass("Item Qty is increased after clicking on + icon");
		}
		else
		{
			testLogFail("Item Qty is not increased after clicking on + icon");
		}
		clickOn(OR.MyCart_minusIcon);
		waitForElement(OR.MyCart_qtyOfItemBeforeAfter, 10);
		String qtyAfterdecrese=getText(OR.MyCart_qtyOfItemBeforeAfter);
		int intqtyafterDecrese=Integer.parseInt(qtyAfterdecrese);  
		if(intqtyafterDecrese==1)
		{
			testLogPass("Item Qty is decreased after clicking on - icon");  		
		}
		else
		{
			testLogFail("Item Qty is not decreased after clicking on + icon");		
		}
		waitForElement(OR.MyCart_editItemQty, 10);
		clickOn(OR.MyCart_editItemQty);
		clearEditBox(OR.MyCart_editItemQtyTextBox);
		typeIn(OR.MyCart_editItemQtyTextBox, "10");
		clickOn(OR.MyCart_submitQty);		
		typeIn(OR.MyCart_searchInCart,ItemDescription);
		String qtyAftertypedQty=getText(OR.MyCart_qtyOfItemBeforeAfter);
		int afterQtyTypedIn=Integer.parseInt(qtyAftertypedQty); 
		if(afterQtyTypedIn==10)
		{
			testLogPass("Item Qty is changed after entering QTY manually in text box"); 		
		}
		else
		{
			testLogFail("Item Qty is not changed after entering QTY manually in text box"); 		
		}

	}

	@Test
	public void Tc_Cart_06()
	{
		testStarts("Tc_Cart_06" ,"Verify that user is able to add �Special Instructions for each vendor.");
		System.out.println("Tc_Cart_06");
		NavigateUrl(DashBoardURL);
		waitForElement(OR.MyCart,10);
		clickOn(OR.MyCart);
		String ItemDescription=getProperty("ItemDesc");
		if(isElementDisplayedwithoutFail(OR.MyCart_drillDownDiv, 10))
		if(MycartPage.cartEmpty())
		{
			typeIn(OR.MyCart_searchInCart,ItemDescription);	
			clickOn(OR.MyCart_addItemInCart);
			//clickOn(OR.MyCart_addItemInCart);
			//waitTime(2);
			
			if(isElementDisplayedwithoutFail(OR.MyCart_warningPopup, 10))
			{      
				clickOn(OR.MyCart_continueButton);     
				//typeIn(OR.MyCart_searchInCart,ItemDescription);
			}
		}
		waitForElement(OR.MyCart_drillDownVendor, 30);
		if(isElementDisplayedwithoutFail(OR.MyCart_SiTextBox, 10))
		{
			String typeTextManually="SI for Test";
			typeIn(OR.MyCart_SiTextBox, typeTextManually);
			String returnedValue=getAttributeValue(OR.MyCart_SiTextBox, "value");
			if(returnedValue.equals(typeTextManually))
			{
				testLogPass("SI added in the text Box");
			}
			else
			{
				testLogFail("SI is not added in the text Box");				
			}			
		}
		else
		{
			testLogFail("SI Text Box is not present");			
		}

	}

	@Test
	public void Tc_Cart_07()
	{
		testStarts("Tc_Cart_07" ,"Verify that user can manually add PO number by selecting Use PO# checkbox.");
		System.out.println("Tc_Cart_07");
		NavigateUrl(DashBoardURL);
		waitForElement(OR.MyCart,10);
		clickOn(OR.MyCart);	
		String ItemDescription=getProperty("ItemDesc");
		if(MycartPage.cartEmpty())
		{

			typeIn(OR.MyCart_searchInCart,ItemDescription);	
			clickOn(OR.MyCart_addItemInCart);
			//clickOn(OR.MyCart_addItemInCart);
			//waitTime(2);
			if(isElementDisplayedwithoutFail(OR.MyCart_warningPopup, 10))
			{       
				clickOn(OR.MyCart_continueButton);     
				//waitTime(3);
				
			}
		}
		waitForElement(OR.MyCart_drillDownVendor, 30);
		if(isElementDisplayedwithoutFail(OR.MyCart_useMYPO, 30))
		{
			clickOn(OR.MyCart_useMYPO);
			String POMAnually="PO#1234";
			typeIn(OR.MyCart_typePONumber, POMAnually);			
			String returnedValue=getAttributeValue(OR.MyCart_typePONumber, "value");
			if(returnedValue.equals(POMAnually))
			{
				testLogPass("PO number added in the text Box");
			}
			else
			{
				testLogFail("PO number is not added in PO box");				
			}			
		}
		else
		{
			testLogFail("PO field is not Active from Organization settings");			
		}

	}

	@Test
	public void Tc_Cart_08()
	{
		testStarts("Tc_Cart_08" ,"Verify that vendor gets removed from cart when user clicks on Remove Vendor from cart� option in dropdown with vendor name.");
		System.out.println("Tc_Cart_08");
		NavigateUrl(DashBoardURL);
		waitForElement(OR.MyCart);;
		clickOn(OR.MyCart);
		String ItemDescription=getProperty("ItemDesc");
		if(MycartPage.cartEmpty())
		{

			typeIn(OR.MyCart_searchInCart,ItemDescription);	
			clickOn(OR.MyCart_addItemInCart);
			//clickOn(OR.MyCart_addItemInCart);
			//waitTime(2);
			//waitForElement(OR.MyCart_warningPopup, 5);
			if(isElementDisplayedwithoutFail(OR.MyCart_warningPopup, 5))
			{      
				clickOn(OR.MyCart_continueButton);     
				//typeIn(OR.MyCart_searchInCart,ItemDescription);
			}
		}
		waitforPaageload();
		waitTime(2);
		if(isElementDisplayed(OR.MyCart_drillDownVendor))
		{
			waitForElement(OR.MyCart_drillDownVendor, 30);
			clickOn(OR.MyCart_drillDownVendor);
			waitForElementToDisplay(OR.MyCart_removeVendor, 10);
			clickOn(OR.MyCart_removeVendor);
			waitForElementToDisplay(OR.MyCart_confirmButton, 10);
			clickOn(OR.MyCart_confirmButton);
			waitForElement(OR.MyCart_emptycartText);
			verifyElementText(OR.MyCart_emptycartText, "Your cart is Empty");
		}

	}
	@Test
	public void Tc_Cart_09()
	{
		testStarts("Tc_Cart_09" ," �Verify that users gets redirected to �Vendors Account Setup� on clicking � Account Setup. ");
		System.out.println("Tc_Cart_09");
		NavigateUrl(DashBoardURL);
		waitForElement(OR.MyCart,10);
		clickOn(OR.MyCart);
		String ItemDescription=getProperty("ItemDesc");
		if(MycartPage.cartEmpty())
		{
			typeIn(OR.MyCart_searchInCart,ItemDescription);	
			clickOn(OR.MyCart_addItemInCart);
			//clickOn(OR.MyCart_addItemInCart);
			//waitTime(2);
			waitForElement(OR.MyCart_warningPopup, 5);
			if(isElementDisplayedwithoutFail(OR.MyCart_warningPopup, 5))
			{     
				clickOn(OR.MyCart_continueButton);     
				waitTime(3);
				//typeIn(OR.MyCart_searchInCart,ItemDescription);
			}
		}
		waitForElement(OR.MyCart_drillDownVendor, 5);
		clickOn(OR.MyCart_drillDownVendor);
		clickOn(OR.MyCart_accountSetUp); 
		waitForElement(OR.MyCart_vendorAccountSetUp, 10);
		verifyPageTitle("Vendors Account Setup");		

	}

	@Test
	public void Tc_Cart_10()
	{
		testStarts("Tc_Cart_10" ,"Verify that 'Departments' pop up appears when user clicks on Attach  department hyperlink.");
		System.out.println("Tc_Cart_10");
		//Loginpage.OpenBrowserAndLogin();
		NavigateUrl(DashBoardURL);
		waitForElement(OR.MyCart,10);
		clickOn(OR.MyCart);		
		String ItemDescription=getProperty("ItemDesc");
		if(MycartPage.cartEmpty())
		{
			typeIn(OR.MyCart_searchInCart,ItemDescription);	
			clickOn(OR.MyCart_addItemInCart);
			if(isElementDisplayed(OR.MyCart_warningPopup))
			{      
				clickOn(OR.MyCart_continueButton);     
				waitTime(3);
				//typeIn(OR.MyCart_searchInCart,ItemDescription);
			}
		}
		waitForElement(OR.MyCart_AddDepartmenthyperLink, 5);
		if(isElementDisplayedwithoutFail(OR.MyCart_AddDepartmenthyperLink, 5))
		{
			clickOn(OR.MyCart_AddDepartmenthyperLink);
			waitForElement(OR.MyCart_AddDepartmentText, 10);
			verifyElementText(OR.MyCart_AddDepartmentText, "Departments");
			clickOn(OR.MyCart_AddDepartmentPopUPcancel);
		}
		else
		{
			testLogFail("Department Link is not enabled from organisation settings");
		}


	}
	@Test
	public void Tc_Cart_12()
	{
		testStarts("Tc_Cart_12" ,"Verify that 'Physicians' pop up appears when user clicks on �Attach Physician� hyperlink.");
		System.out.println("Tc_Cart_12");
		NavigateUrl(DashBoardURL);
		waitForElement(OR.MyCart,10);
		clickOn(OR.MyCart);
		//	MycartPage.checkIfCartIsEmpty();
		if(MycartPage.cartEmpty())
		{
			String ItemDescription=getProperty("ItemDesc");
			typeIn(OR.MyCart_searchInCart,ItemDescription);	
			clickOn(OR.MyCart_addItemInCart);
			//clickOn(OR.MyCart_addItemInCart);
			//waitTime(2);
			//waitForElement(OR.MyCart_warningPopup, 10);
			if(isElementDisplayedwithoutFail(OR.MyCart_warningPopup, 5))
			{      
				clickOn(OR.MyCart_continueButton);     
				waitTime(3);
				//typeIn(OR.MyCart_searchInCart,ItemDescription);
			}
		}
		waitForElement(OR.MyCart_AddPhysicianhyperLink, 10);
		if(isElementDisplayedwithoutFail(OR.MyCart_AddPhysicianhyperLink,10))
		{ 
			clickOn(OR.MyCart_AddPhysicianhyperLink);
			waitForElement(OR.MyCart_AddPhysicianText, 10);
			verifyElementText(OR.MyCart_AddPhysicianText, "Physicians");
			clickOn(OR.MyCart_AddDepartmentPopUPcancel);
		}
		else
		{
			testLogFail("Physician link is not enabled from the Organisation settings page");
		}
		//waitTime(3);

	}

	@Test
	public void Tc_Cart_11()
	{
		testStarts("Tc_Cart_11" ,"Verify that Print window appears when user clicks print items.");
		System.out.println("Tc_Cart_11");
		NavigateUrl(DashBoardURL);
		waitForElement(OR.MyCart,10);
		clickOn(OR.MyCart);
		
		if(MycartPage.cartEmpty())
		{
			String ItemDescription=getProperty("ItemDesc");
			typeIn(OR.MyCart_searchInCart,ItemDescription);	
			clickOn(OR.MyCart_addItemInCart);
			
			if(isElementDisplayedwithoutFail(OR.MyCart_warningPopup, 5))
			{      
				clickOn(OR.MyCart_continueButton);
			}
		}
		if(isElementDisplayed(OR.MyCart_drillDownDiv))
		{
		waitForElement(OR.MyCart_drillDownDiv, 10);
		clickOn(OR.MyCart_drillDownDiv);
		waitForElement(OR.MyCart_PrintPO);
		clickOn(OR.MyCart_PrintPO);
		waitForElement(OR.MyCart_PrintPOPopUpText, 10);
		verifyElementText(OR.MyCart_PrintPOPopUpText, "Cart Items");
		clickOn(OR.MyCart_PrintCloseclose);	
		}

	}



//	@Test
//	public void Tc_Cart_13()
//	{
//		testStarts("Tc_Cart_13" ,"Verify that when user clicks on �Clear Current cart�, items added in current facility gets cleared.");
//		System.out.println("Tc_Cart_13");
//		NavigateUrl(DashBoardURL);
//		waitForElement(OR.MyCart,10);
//		clickOn(OR.MyCart);
//		if(MycartPage.cartEmpty())
//		{
//			String ItemDescription=getProperty("ItemDesc");
//			typeIn(OR.MyCart_searchInCart,ItemDescription);	
//			clickOn(OR.MyCart_addItemInCart);
//			//clickOn(OR.MyCart_addItemInCart);
//			//waitTime(2);
//			//waitForElement(OR.MyCart_warningPopup, 10);
//			if(isElementDisplayedwithoutFail(OR.MyCart_warningPopup, 5))
//			{      
//				clickOn(OR.MyCart_continueButton);     
//				waitTime(3);
//				//typeIn(OR.MyCart_searchInCart,ItemDescription);
//			}
//		}
//		waitForElement(OR.MyCart_drillDownDiv, 10);
//		if(isElementDisplayed(OR.MyCart_drillDownDiv))
//		{
//		clickOn(OR.MyCart_drillDownDiv);
//		clickOn(OR.MyCart_clearCurrentCart);
//		clickOn(OR.MyCart_yesInPopup);
//		clickOn(OR.MyCart_OKInPopup);
//		waitForElement(OR.MyCart_emptycartText, 10);
//		verifyElementText(OR.MyCart_emptycartText, "Your cart is Empty");
//		}
//
//
//	}

	@Test
	public void Tc_Cart_14()
	{
		testStarts("Tc_Cart_14" ,"Verify that when user clicks on �Clear all Cart�, items added in all facilities gets cleared..");
		System.out.println("Tc_Cart_14");
		//Loginpage.OpenBrowserAndLogin();
		NavigateUrl(DashBoardURL);
		clickOn(OR.Shop_Menu);
		waitForElement(OR.Shop_SHopfor_getfacilityName,10);
		String facility_Name=getText(OR.Shop_SHopfor_getfacilityName);
		clickOn(OR.MyCart);
		waitForElement(OR.Shop_SHopfor_getfacilityName,10);
		MycartPage.checkIfCartIsEmpty();	
		waitForElement(OR.MyCart_cartIconNumber, 10);
		String s1=getText(OR.MyCart_cartIconNumber);
		int qtyInCartbefore=Integer.parseInt(s1);
		//typeIn(OR.MyCart_searchInCart,"ItemDesc");
		String ItemDescription=getProperty("ItemDesc");
		typeIn(OR.MyCart_searchInCart,ItemDescription);
		clickOn(OR.MyCart_addItemInCart);
		//waitTime(2);
		waitForElement(OR.MyCart_warningPopup, 3);
		if(isElementDisplayedwithoutFail(OR.MyCart_warningPopup, 5))
		{      
			clickOn(OR.MyCart_continueButton);     
			waitTime(3);
			//typeIn(OR.MyCart_searchInCart,ItemDescription);
		}
		waitForElement(OR.MyCart_cartIconNumber, 10);
		String s2=getText(OR.MyCart_cartIconNumber);
		int qtyInCartAfter=Integer.parseInt(s2);
		if(qtyInCartAfter==(qtyInCartbefore+1))
		{
			testLogPass("One item is added to cart");
		}
		else
		{
			testLogPass("Item qty is not increased");
		}
		waitForElement(OR.Shop_SHopfor_ShopfaclitySelect,10);
		clickOn(OR.Shop_SHopfor_ShopfaclitySelect);
		waitForElement(OR.Shop_SHopfor_Shopfaclity, 60);
		verifyElementText(OR.Shop_SHopfor_Shopfaclity, "Select Facility");
		typeIn(OR.Invoice_SearchInInvoiceTextBox, facility_Name);	
		int one = driver.findElements(By.xpath("(//*[starts-with(@class, 'table table-responsive')]//tbody//td[1])")).size();
		
		String selectedFacility;
		String itemCountText;
		for(int i=1; i<=one; i++)
		{
			selectedFacility=driver.findElement(By.xpath("(//*[@class='table table-responsive table-striped table-bordered']//tbody//td)["+i+"]")).getText();
			itemCountText=driver.findElement(By.xpath("((//*[starts-with(@class, 'table table-responsive')])//following-sibling::td//span)["+i+"]")).getText();
			System.out.println(itemCountText);
			String temp=itemCountText.substring(1,2);
			int qtyInFac=Integer.parseInt(temp);	
			System.out.println(qtyInFac);

			if(qtyInFac != 0)
			{  
				testLogPass(selectedFacility + " has " + qtyInFac + " items");
				break;
			}					
		}

		if(facility_Name==null)
		{
			testLogFail("Could not Got the text '"+facility_Name+ "' Matches with selected Facility" );
		}

		clickOn(OR.Shop_SHopfor_cancelButtonPopup);

	}



	@Test
	public void Tc_Cart_15()
	{
		testStarts("Tc_Cart_15" ,"Verify that show tour pops appear when user clicks on show tour option in dropdown next to refresh button.");
		System.out.println("Tc_Cart_15");
		NavigateUrl(DashBoardURL);
		//Loginpage.OpenBrowserAndLogin();	
		clickOn(OR.MyCart);
		if(MycartPage.cartEmpty())
		{
			String ItemDescription=getProperty("ItemDesc");
			typeIn(OR.MyCart_searchInCart,ItemDescription);	
			clickOn(OR.MyCart_addItemInCart);
			if(isElementDisplayedwithoutFail(OR.MyCart_warningPopup,5))
			{      
				clickOn(OR.MyCart_continueButton);     
				waitTime(3);
			}
		}
		MycartPage.showTourPopUP();
		verifyElementText(OR.MyCart_showtourtextONPOPUP, "Cart: List of Items");
		WebElement searchParent = Generickeywords.webElement.findElement(By.xpath(".."));
		List<WebElement> btns = searchParent.findElements(By.tagName("button"));

		if(btns == null || btns.size() == 0)
		{
			testLogFail("No buttons found in tour popup.");
		}
		else
		{
			String nextBtnText=btns.get(0).getText();
			if(nextBtnText.contains("Next"))
			{
				testLogPass("Successfully Matched the Text 'Next' with button '" + nextBtnText + "'");
			}
			else
			{
				testLogFail("Could not match Text 'Next' with button '" + nextBtnText + "'");
			}

			String endBtnText=btns.get(1).getText();
			if(endBtnText.contains("End tour"))
			{
				testLogPass("Successfully Matched the Text 'End tour' with button '" + endBtnText + "'");
				btns.get(1).click();
				testLogPass("Click on :End tour");
			}
			else
			{
				testLogFail("Could not match Text 'End tour' with button '" + endBtnText + "'");
			}		

		}
		btns.get(1).click();
	}

	public static void addNewItem()
	{
		waitForElementToDisplay(OR.Shop_Menu, 10);
		//adding new item
		ItemDescription = "TestItemDes"+ApplicationKeyword.randomAlphaNumeric(4);	
		setProperty("ItemDesc",ItemDescription);
		ItemMfrNumber = "TestItmMfrNmbr"+ApplicationKeyword.randomAlphaNumeric(4);
		setProperty("ItemMfr",ItemMfrNumber);
		ItemTestID = "TestItemID"+ApplicationKeyword.randomAlphaNumeric(4);
		setProperty("ItemtestID",ItemTestID);	
		SkuName = "sku"+ApplicationKeyword.randomAlphaNumeric(4);
		setProperty("Sku",SkuName);	
		aliasName="alias"+ApplicationKeyword.randomAlphaNumeric(2);
		setProperty("alias",aliasName);	
		clickOn(OR.DashBoard_AdminDropdown);
		clickOn(OR.Admin_ItemCatalog);
		waitForElement(OR.ItemCatalog_AddItem, 10);
		clickOn(OR.ItemCatalog_AddItem);
		typeIn(OR.ItemCatalog_AddItem_ItemDetails_Description, ItemDescription);
		MycartPage.chkMan_level("ItemMfr");
		if(isElementDisplayed(OR.ItemCatalog_AddItme_TestId, 10))
		{
			typeIn(OR.ItemCatalog_AddItme_TestId, ItemTestID);
		}
		int countOfCategories=driver.findElements(By.xpath("//select[@ng-model='item.category_id']/option")).size();		
		if(countOfCategories>=2)
		{
			firstCategory = getDropDownText(OR.ItemCatalog_itemCategory,1);
			setProperty("firstCat", firstCategory);
		}
		typeIn(OR.ItemCatalog_itemalias, aliasName);
		clickOn(OR.ItemCatalog_VendorsTab);
		waitForElement(OR.ItemCatalog_AddVendors);
		clickOn(OR.ItemCatalog_AddVendors);
		waitForElement(OR.ItemCatalog_Add_Vendorsname);
		clickOn(OR.ItemCatalog_Add_Vendorsname);
		waitForElementToDisplay(OR.ItemCatalog_AddItem_VendorSelect_First, 10);
		vendor_Name=getText(OR.ItemCatalog_firstvendor);
		setProperty("vendorName", vendor_Name);
		clickOn(OR.ItemCatalog_AddItem_VendorSelect_First);
		waitForElement(OR.ItemCatalog_Add_VendorsSkuName);
		typeIn(OR.ItemCatalog_Add_VendorsSkuName, SkuName);
		typeIn(OR.ItemCatalog_Add_VendorsMinOrderQty, "1");
		MycartPage.chkMan_level("ItemMfr");
		clickOn(OR.ItemCatalog_AddItem_Man_Save);
		waitForElement(OR.ItemCatalog_AddItem_MapValidation, 10);
		verifyElementText(OR.ItemCatalog_AddItem_MapValidation, "Do you want to map this item to your various facilities?");
		clickOn(OR.ItemCatalog_AddItem_MapValidation_yes);
		getText(OR.ItemCatalog_AddItem_Map_Header);
		verifyElementText(OR.ItemCatalog_AddItem_Map_SearchFacility_Text, "Search Facility");
		clickOn(OR.ItemCatalog_mapallbuttontopright);
		waitForElement(OR.ItemCatalog_mapwithalltopright);
		clickOn(OR.ItemCatalog_mapwithalltopright);	
		waitForElement(OR.ItemCatalog_verifytextpopup,10);
		verifyElementText(OR.ItemCatalog_verifytextpopup, "Map with all facilities");
		typeIn(OR.ItemCatalog_purchaseprice, "60");
		clickOn(OR.ItemCatalog_mapallbutton);
		waitForElement(OR.ItemCatalog_AddItem_Map_Closepage, 10);	
		clickOn(OR.ItemCatalog_AddItem_Map_Closepage);		
	}
	@AfterTest
	public void endReport(){
		closeBrowser();
		extent.flush();
	}
}


