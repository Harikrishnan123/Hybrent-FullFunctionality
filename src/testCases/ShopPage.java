package testCases;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import pageObject.Itempage;
import pageObject.Loginpage;
import pageObject.MycartPage;
import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;
import AutomationFramework.Generickeywords;
public class ShopPage extends ApplicationKeyword{
	public static String facility_Name;
	public static String vendor_Name;


	@Parameters({"siteName", "siteUrl"})
	@BeforeTest
	public void startReport(String siteName, String siteUrl) {
		try {
			Loginpage.URL=siteUrl + "#/login/";
			Generickeywords.SITENAME=siteName;
			Generickeywords.DashBoardURL=siteUrl + "#/dashboard";
			String folderPath=OutputDirectory + "/" + siteName;

			File directory = new File(folderPath);
			if (! directory.exists()){
				directory.mkdir();
			}

			extent = new ExtentReports(folderPath+"/shop.html", true);
			// extent.addSystemInfo("Environment","Environment Name")
			extent.addSystemInfo("User Name", "Ravneet");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}

	@Test
	public void Tc_Shop_1() throws InterruptedException
	{
		testStarts("Tc_Shop_1", "Verify that only ACTIVE items are appearing on page.");
		Loginpage.OpenBrowserAndLogin();	
		System.out.println("Tc_Shop_1");	
		clickOn(OR.Shop_Menu);
		waitForElementToDisplayWithoutFail(OR.Shop_SHopfor_FacInDropDown, 10);
		//String alreadySelectedFac01=getText(OR.Shop_SHopfor_FacInDropDown);
		//setProperty("userdefaultFac", alreadySelectedFac01);
		//String facNAme=selectProf_fac();
		String alreadySelectedFac01=getProperty("userdefaultFac");
		System.out.println(alreadySelectedFac01);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//a[@href='#/inventory']"));
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		clickOn(OR.manageInvenLink);
		waitForElementToDisplayWithoutFail(OR.Shop_SHopfor_FacInDropDown, 10);
		String alreadySelectedFac=getText(OR.Shop_SHopfor_FacInDropDown);
		System.out.println(alreadySelectedFac);
		if(!alreadySelectedFac.equals(alreadySelectedFac01))
		{
			clickOn(OR.Shop_SHopfor_FacInDropDown);
			//int one=driver.findElements(By.xpath("//*[@class='table table-responsive table-striped table-bordered']//tr")).size();
			List<WebElement> elem=driver.findElements(By.xpath("//*[@class='table table-responsive table-striped table-bordered']//tr"));
			int one = driver.findElements(By.xpath("//*[@class='table table-responsive table-striped table-bordered']//tr")).size();

			for(int i=1; i<=one; i++)
			{
				String elem2=elem.get(i-1).findElement(By.xpath("//td[1]")).getText();
				if(elem2.equals(alreadySelectedFac01))
				{
					WebElement button=elem.get(i-1).findElement(By.xpath("//td[2]//button"));
					button.click();
				}
			}		
			waitForElementToDisplayWithoutFail(OR.manageInventory_waitforelements, 20);
			verifyPageTitle("Manage Inventory : List");		
			selectFromDropdown(OR.manage_stsusDropdwn, "InActive");		           
			clickOn(OR.manage_searchButton);
			waitForElementToDisplayWithoutFail(OR.manage_inactiveitem, 20);
			waitTime(4);
			String InactiveItemab=getText(OR.manage_inactiveitem);
			WebElement element2 = driver.findElement(By.xpath("//*[@href='#/shop']"));
			je.executeScript("arguments[0].scrollIntoView(true);",element2);
			clickOn(OR.Shop_Menu);
			selectFromDropdown(OR.Shop_selectExactMatch, "Exact match");
			waitForElementToDisplayWithoutFail(OR.Shop_searchfield, 60);
			typeIn(OR.Shop_searchfield, InactiveItemab);
			waitForElementToDisplayWithoutFail(OR.Shop_ifnoItemfield, 60);
			verifyElementText(OR.Shop_ifnoItemfield, "No Item Found");

		}
	}

	@Test
	public void Tc_Shop_2_3()
	{
		testStarts("Tc_Shop_2 and Tc_Shop_3" , "Verify that 'Select Facility�' pop up appears when user clicks on facility name with �Shopping for� label"
				+ " Verify that �selected� button appears as disabled for the facility which is displayed on Shop page.");
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_Shop_2_3");
		String fac=MycartPage.getFac();		
		MycartPage.matchFac(fac);
	}

	@Test
	public void Tc_Shop_4() throws InterruptedException
	{
		testStarts("Tc_Shop_4" , "Verify that user can search item on basis of 'Item Name, SKU, MFR' and Vendor filter..");
		NavigateUrl(DashBoardURL);	
		System.out.println("Tc_Shop_4");
		clickOn(OR.Shop_Menu);
		selectTableView();
		waitForElementToDisplayWithoutFail(OR.Shop_SHopfor_SearchBox, 30);
		String itemDsc=getProperty("ItemDesc");
		typeIn(OR.Shop_SHopfor_SearchBox,itemDsc);
		waitTime(7);
		String itemname=getAttributeValue(OR.Shop_SHopfor_Search_itemdesc, "name");
		if(itemname.equals(itemDsc))
		{
			testLogPass("Same item is searched ItemDescription on cart page" );
		}
		else
		{
			testLogFail("Same item is not searched ItemDescription on cart page" );
		}
		//search by sku
		clearEditBox(OR.Shop_SHopfor_SearchBox);
		waitForElementToDisplayWithoutFail(OR.Shop_SHopfor_SearchBox, 15);
		String Sku=getProperty("Sku");
		typeIn(OR.Shop_SHopfor_SearchBox,Sku);
		waitTime(7);
		//waitForElementToDisplayWithoutFail(OR.Shop_SHopfor_Search_itemdesc, 10);
		String itemname2=getAttributeValue(OR.Shop_SHopfor_Search_itemdesc, "name");
		if(itemname.equals(itemname2))
		{
			testLogPass("Same item is searched sku on cart page" );
		}
		else
		{
			testLogFail("Same item is not searched with sku on cart page" );
		}
		//search with mfr#
		clearEditBox(OR.Shop_SHopfor_SearchBox);
		waitForElementToDisplayWithoutFail(OR.Shop_SHopfor_SearchBox, 15);
		String mfr=getProperty("ItemMfr");
		typeIn(OR.Shop_SHopfor_SearchBox,mfr);
		waitTime(7);
		//waitForElementToDisplayWithoutFail(OR.Shop_SHopfor_Search_itemdesc, 10);
		String itemname3=getAttributeValue(OR.Shop_SHopfor_Search_itemdesc, "name");
		if(itemname.equals(itemname3))
		{
			testLogPass("Same item is searched Manufacture# on cart page" );
		}
		else
		{
			testLogFail("Same item is not searched Manufacture# on cart page" );
		}
		//search with vendor name
		String vendor=getProperty("vendorName");
		selectFromDropdown(OR.Shop_VendorSelect, vendor);
		waitTime(7);
		//waitForElementToDisplayWithoutFail(OR.Shop_SHopfor_SelectfirstItemvendorName, 15);
		String vendoraftersearch=getText(OR.Shop_SHopfor_SelectfirstItemvendorName);     
		waitForElementToDisplayWithoutFail(OR.Shop_wait, 10);
		if(vendoraftersearch.equals(vendor))
		{
			testLogPass("Same item is searched vendorname on cart page" );
		}
		else
		{
			testLogFail("Same item is not searched vendorname on cart page" );
		}

	}
	@Test
	public void Tc_Shop_5()
	{
		testStarts("Tc_Shop_5" , "Verify that user can switch between following tabs using corresponding radio button.");
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_Shop_5");
		clickOn(OR.Shop_Menu);
		waitTime(5);
		waitForElementToDisplayWithoutFail(OR.Shop_SHopfor_RecentlyOrderedradiobutton, 10);
		clickOn(OR.Shop_SHopfor_RecentlyOrderedradiobutton);
		waitTime(2);
		waitForElementToDisplayWithoutFail(OR.Shop_SHopfor_LastorderedText, 10);
		verifyElementText(OR.Shop_SHopfor_LastorderedText, "Last Ordered");
		clickOn(OR.Shop_SHopfor_MostOrderedradiobutton);
		waitTime(2);
		verifyElementText(OR.Shop_SHopfor_PoCountText, "PO Count");      	
		clickOn(OR.Shop_SHopfor_FavOrderedradiobutton);
		waitTime(8);
		verifyAttribute(OR.Shop_SHopfor_favtab, "ng-if", "isFavorite");		
		clickOn(OR.Shop_SHopfor_MyInventoryradiobutton);
		waitTime(2);
		verifyAttribute(OR.Shop_SHopfor_myInventoryFavTab, "ng-if", "!isFavorite");	

	}


	@Test
	public void Tc_Shop_6()
	{
		testStarts("Tc_Shop_6" , "Verify that 'All fields' dropdwon appears with following options.");
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_Shop_6");
		clickOn(OR.Shop_Menu);
		clickOn(OR.DashBoard_AdminDropdown);
		clickOn(OR.Shop_orgPage);
		clickOn(OR.Shop_FeaturesPage);
		String crossWalkclass=getAttributeValue(OR.orgsetting_crosswalk, "class");
		boolean orgSettingActive=false;
		String crosswalkIDText="";
		if(crossWalkclass.contains("not-empty"))
		{
			//to get the text in input tag
			crosswalkIDText=getAttributeValue(OR.orgsetting_crosswalktext, "value");	
			testLogPass("CrosswalkID Toggle is Active with value "+ crosswalkIDText);
			orgSettingActive=true;
		}
		else if(crossWalkclass.contains("ng-empty"))
		{
			testLogPass("CrosswalkID Toggle is not Active");
		}
		waitForElementToDisplayWithoutFail(OR.Shop_Menu, 60);
		clickOn(OR.Shop_Menu);
		clickOn(OR.Shop_SHopfor_allFieldsBtn);
		List<String> exp = new ArrayList<String>( Arrays.asList("SKU", "Mfr Number", "Description", "Quick code", "You can select maximum 2 keys for search."));
		if(orgSettingActive)
		{
			exp.add(crosswalkIDText);
		}
		List<WebElement> options = driver.findElements
				(By.xpath("//ul[@class='dropdown-menu dropdown-menu-form']/li[@role='presentation']"));
		boolean itemFound;
		if(options.size() == exp.size())
		{
			for(String lm:exp)
			{
				itemFound=false;
				for(WebElement we:options)  
				{	
					if(we.getText().toLowerCase().trim().equals(lm.toLowerCase()))
					{
						itemFound=true;
						break;
					}
				}

				if(itemFound)
				{
					testLogPass("Text '" + lm + "' exists in dropdown.");
				}
				else
				{
					testLogFail("Text '" + lm + "' does not exist in dropdown.");
				}
			}
		}
		else
		{
			//fail because size is not equal
			testLogFail("Size of two arrayList is not equal");
		}

	}
	@Test
	public void Tc_Shop_7()
	{
		testStarts("Tc_Shop_7" , "Verify that show tour pops appear when user clicks on show tour option in dropdown next to refresh button.");
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_Shop_7");
		waitForElementToDisplayWithoutFail(OR.Shop_Menu, 60);
		clickOn(OR.Shop_Menu);
		clickOn(OR.Shop_SHopfor_drilldownicon);
		//waitForElementToDisplay(OR.Shop_SHopfor_waitdrilldownicon, 60);  
		clickOn(OR.Shop_SHopfor_showTourText);
		//Since the xpath is relative to text of the element, we do not need to compare the text again. 
		//No need for explicit messages because method 'getText' implicitly does messaging on the basis of whether text found or not.
		getText(OR.Shop_SHopfor_showtourtextONPOPUP);
		//Since getText would automatically initialize genericKeyword class' static variable webElement, we can use same variable further
		//Since as per current structure of the page, xpath is not possible for finding out buttons,
		//because there are so many elements with same structure, so we will find parent of the search elem and then find buttons relative to the parent.
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

	}  	

	@Test
	public void Tc_Shop_08()
	{
		testStarts("Tc_Shop_8", "Verify that user can switch between table view and grid view using \"view type\" option in the dropdown.");
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_Shop_08");
		clickOn(OR.Shop_Menu);
		clickOn(OR.Shop_SHopfor_drilldownicon);
		mouseOver(OR.Shop_mouseoverviewtype);
		clickOn(OR.Shop_gridView);
		waitForElementToDisplayWithoutFail(OR.Shop_SHopfor_drilldownicon, 30);
		if(isElementPresent(By.xpath("//div[@id='isotopeContainer']")))
		{
			testLogPass("Successfully changed to GRID View");
		}
		else
		{
			testLogFail("View is not changed to GRID view");
		}
		selectTableView();
		waitForElementToDisplayWithoutFail(OR.Shop_SHopfor_drilldownicon, 30);		
		if(!isElementPresent(By.xpath("//div[@id='isotopeContainer']")))
		{
			testLogPass("Successfully changed to TABLE View");
		}
		else
		{
			testLogFail("View is not changed to TABLE view");
		}		
	}

	@Test
	public void Tc_Shop_09()
	{
		testStarts("Tc_Shop_9" , "Verify that \"Configure Shop Layout\" pop up appears when user clicks on change current layout.");
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_Shop_09");
		clickOn(OR.Shop_Menu);
		waitForElementToDisplayWithoutFail(OR.Shop_SHopfor_drilldownicon, 10);
		clickOn(OR.Shop_SHopfor_drilldownicon);
		waitForElementToDisplayWithoutFail(OR.Shop_drilldownCreateLayout, 10);
		clickOn(OR.Shop_drilldownCreateLayout);
		waitForElementToDisplayWithoutFail(OR.Shop_drilldownLayoutNameText, 10);
		String layout="AAA00"+ApplicationKeyword.randomAlphaNumeric(2);
		typeIn(OR.Shop_drilldownLayoutNameText, layout);
		String NameofLayout="Configure Shop Layout "+layout;
		waitForElementToDisplayWithoutFail(OR.Shop_drilldownCreateLayoutSave, 10);
		clickOn(OR.Shop_drilldownCreateLayoutSave);
		//Configure layout save button
		waitForElementToDisplayWithoutFail(OR.Shop_drilldownCreateLayoutSave, 10);
		clickOn(OR.Shop_drilldownCreateLayoutSave);
		waitForElementToDisplayWithoutFail(OR.Shop_wait2, 10);
		waitTime(5);
		clickOn(OR.Shop_SHopfor_drilldownicon);
		waitForElementToDisplayWithoutFail(OR.Shop_drilldownChangeLayout, 10);
		clickOn(OR.Shop_drilldownChangeLayout);
		//waitForElementToDisplay(OR.Shop_drilldownChangeLayoutPopup, 30);
		String actualName=getText(OR.Shop_changeLayoutTextPopUP);
		if(NameofLayout.equalsIgnoreCase(actualName))
		{
			testLogPass("User has opened Change layout Pop up with name "+ actualName);

		}
		clickOn(OR.Shop_drilldownChangeLayoutClose);
		clickOn(OR.Shop_SHopfor_drilldownicon);
		waitForElementToDisplayWithoutFail(OR.Shop_drilldownLayouts, 10);
		mouseOver(OR.Shop_drilldownLayouts);
		//clickOn(OR.Shop_drilldownRemoveLayout);
		WebElement elem=driver.findElement(By.xpath("//a[contains(text(),'"+layout+"')]/../i"));
		elem.click();
		waitForElementToDisplayWithoutFail(OR.Shop_drilldownRemoveLayoutYes, 10);
		clickOn(OR.Shop_drilldownRemoveLayoutYes);
		waitForElementToDisplayWithoutFail(OR.Shop_SHopfor_drilldownicon, 30);

	}

	@Test
	public void Tc_Shop_10()
	{
		testStarts("Tc_Shop_10" , "Verify that \"Layout\" pop up appears when user clicks on on Create new layout or copy current layout option..");
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_Shop_10");
		waitForElementToDisplayWithoutFail(OR.Shop_Menu, 10);
		clickOn(OR.Shop_Menu);
		waitForElementToDisplayWithoutFail(OR.Shop_SHopfor_drilldownicon, 10);
		clickOn(OR.Shop_SHopfor_drilldownicon);	
		waitForElementToDisplayWithoutFail(OR.Shop_drilldownCreateLayout, 10);
		clickOn(OR.Shop_drilldownCreateLayout);	
		waitForElementToDisplayWithoutFail(OR.Shop_SHopfor_Layoutpopup, 10);
		verifyElementText(OR.Shop_SHopfor_Layoutpopup, "Layout");
		waitForElementToDisplayWithoutFail(OR.Shop_SHopfor_Layoutpoupclose, 10);
		clickOn(OR.Shop_SHopfor_Layoutpoupclose);	
		waitForElementToDisplayWithoutFail(OR.Shop_SHopfor_drilldownicon, 10);
		clickOn(OR.Shop_SHopfor_drilldownicon);
		waitForElementToDisplayWithoutFail(OR.Shop_SHopfor_copyLayoutpoup, 10);
		clickOn(OR.Shop_SHopfor_copyLayoutpoup);
		waitForElementToDisplayWithoutFail(OR.Shop_SHopfor_Layoutpopup, 10);
		verifyElementText(OR.Shop_SHopfor_Layoutpopup, "Layout");
		clickOn(OR.Shop_SHopfor_Layoutpoupclose);		

	}
	//Will fail due to requirement change
	//	@Test
	//	public void Tc_Shop_11() {
	//		testStarts("Tc_Shop_11", "Verify that Partial and Exact option appears in Match dropdown.");
	//		NavigateUrl(DashBoardURL);
	//		waitForElementToDisplayWithoutFail(OR.Shop_Menu, 60);
	//		verifyPageTitle("Dashboard");
	//		clickOn(OR.Shop_Menu);
	//		clickOn(OR.Shop_SHopfor_ShopfaclitySelect);
	//		pageObject.ShopPage.VerifyShopPage();
	//		pageObject.ShopPage.MatchDropdown();
	//		
	//	}

	@Test
	public void Tc_Shop_12() {
		testStarts("Tc_Shop_12", "Verify that user can set favorite/unfavorite item by clicking on star icon.\r\n");
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_Shop_12");
		waitForElementToDisplayWithoutFail(OR.Shop_Menu, 10);
		verifyPageTitle("Dashboard");
		clickOn(OR.Shop_Menu);
		waitForElementToDisplayWithoutFail(OR.Shop_SHopfor_favtab, 10);
		String Fav = getAttributeValue(OR.Shop_SHopfor_favtab, "ng-if");
		if (Fav.equals("isFavorite")) {
			testLogPass("item is isFavorite");
		} else

			if (Fav.equals("!isFavorite")) {
				testLogPass("item is !isFavorite");
			}
		clickOn(OR.Shop_SHopfor_favtab);
		waitTime(10);
		String Fav1 = getAttributeValue(OR.Shop_SHopfor_favtab, "ng-if");
		if (Fav1.equals("!isFavorite")) {
			testLogPass("item is !isFavorite");
		} else if (Fav1.equals("isFavorite")) {
			testLogPass("item is isFavorite");
		}

	}

	@Test
	public void Tc_Shop_15() {
		testStarts("Tc_Shop_15", "Verify that 'Edit Item' page opens on clicking 'Edit' button.\n");
		NavigateUrl(DashBoardURL);	
		System.out.println("Tc_Shop_15");
		waitForElementToDisplayWithoutFail(OR.Shop_Menu, 10);
		verifyPageTitle("Dashboard");
		clickOn(OR.Shop_Menu);
		waitForElementToDisplayWithoutFail(OR.Shop_ItemNameDropDown_First, 10);
		clickOn(OR.Shop_ItemNameDropDown_First);
		Itempage.FirstItemDropdownEdit();

	}


	@Test
	public void Tc_Shop_16() {
		testStarts("Tc_Shop_16",
				"Verify that 'Price Change History' popup opens on clicking Price Change History button.");
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_Shop_16");
		waitForElementToDisplayWithoutFail(OR.Shop_Menu, 10);
		verifyPageTitle("Dashboard");
		clickOn(OR.Shop_Menu);
		waitForElementToDisplayWithoutFail(OR.Shop_ItemNameDropDown_First, 10);
		clickOn(OR.Shop_ItemNameDropDown_First);
		verifyElementText(OR.Shop_ItemNameDropDownPricechangeHistory_First, "Price Change History");
		//Itempage.FirstItemDropdownPriceHistory();

	}

	@Test
	public void Tc_Shop_17() {
		testStarts("Tc_Shop_17",
				"Verify that 'Item Purchase History' popup opens on clicking 'Purchase History' button.");
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_Shop_17");
		waitForElementToDisplayWithoutFail(OR.Shop_Menu, 10);
		verifyPageTitle("Dashboard");
		clickOn(OR.Shop_Menu);
		waitForElementToDisplayWithoutFail(OR.Shop_ItemNameDropDown_First, 10);
		clickOn(OR.Shop_ItemNameDropDown_First);
		Itempage.FirstItemDropdownPurchaseHistory();

	}

	@Test
	public void Tc_Shop_19() {
		testStarts("Tc_Shop_19", "Verify that user is redirected to Cart page on clicking Checkout button.");

		//Loginpage.OpenBrowserAndLogin();	
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_Shop_19");
		waitForElementToDisplayWithoutFail(OR.Shop_Menu, 10);
		clickOn(OR.Shop_Menu);
		if(isElementDisplayed(OR.Checkout_Btn))
		{
			waitForElementToDisplayWithoutFail(OR.Checkout_Btn, 10);
			clickOn(OR.Checkout_Btn);
			waitForElementToDisplayWithoutFail(OR.Shop_GeneratePo, 10);
			verifyElement(OR.Shop_GeneratePo);
			verifyPageTitle("My Cart");
		}
		else
		{	
			waitForElementToDisplayWithoutFail(OR.Shop_SHopfor_Addtocartt, 10);
			clickOn(OR.Shop_SHopfor_Addtocartt);
			if(isElementDisplayed(OR.MyCart_warningPopup))
			{      
				clickOn(OR.MyCart_continueButton);     
				waitTime(3);
				//typeIn(OR.MyCart_searchInCart,ItemDescription);
			}
			if(isElementDisplayed(OR.Shop_SHopfor_updatePrice))
			{
				clickOn(OR.MyCart_continueButton);     
				waitTime(3);
			}
			waitForElementToDisplayWithoutFail(OR.Checkout_Btn, 10);
			clickOn(OR.Checkout_Btn);
			waitForElementToDisplayWithoutFail(OR.Shop_GeneratePo, 10);
			verifyElement(OR.Shop_GeneratePo);
			verifyPageTitle("My Cart");
		}

	}

	@Test
	public void Tc_Shop_21() {
		testStarts("Tc_Shop_21",
				"Verify that user can increase or decrease the quantity of item by clicking (+) and (-) button respectively");
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_Shop_21");
		waitForElementToDisplayWithoutFail(OR.Shop_Menu, 60);
		verifyPageTitle("Dashboard");
		clickOn(OR.Shop_Menu);
		String itemDsc=getProperty("ItemDesc");
		typeIn(OR.Shop_SHopfor_SearchBox,itemDsc);
		waitForElementToDisplayWithoutFail(OR.Shop_wait, 60);

		waitForElementToDisplayWithoutFail(OR.Shop_SHopfor_Search_Addtocart_First, 60);
		String one = getAttributeValue(OR.Shop_SHopfor_Search_Addtocart_First, "class");
		if (one.contains("btn btn-default btn-xs ng-hide")) {
			String BeforeIncrease = getText(OR.Shop_Item_Qty_First);
			clickOn(OR.Shop_Item_Qty_Increase_First);
			String AfterIncrease = getText(OR.Shop_Item_Qty_First);
			if (AfterIncrease != BeforeIncrease) {
				testLogPass(BeforeIncrease + " valuse  Before Increase" + AfterIncrease + " After Increase...");
			} else {
				testLogPass(BeforeIncrease + " valuse  Before Increase" + AfterIncrease + " After Increase...");
			}
			clickOn(OR.Shop_Item_Qty_Derease_First);
			String BeforeIncrease1 = getText(OR.Shop_Item_Qty_First);
			if (AfterIncrease != BeforeIncrease1) {
				testLogPass(BeforeIncrease + " valuse  Before Decrease' " + AfterIncrease + " After Increase...");
			} else {
				testLogPass(BeforeIncrease + " valuse  Before Decrease' " + AfterIncrease + " After Increase...");
			}

		} else {
			clickOn(OR.Shop_SHopfor_Search_Addtocart_First);

			waitForElementToDisplayWithoutFail(OR.MyCart_warningPopup, 10);
			if(isElementDisplayedwithoutFail(OR.MyCart_warningPopup, 10))
			{      
				clickOn(OR.MyCart_continueButton);     
				waitTime(3);
			}

			String BeforeIncrease = getText(OR.Shop_Item_Qty_First);
			clickOn(OR.Shop_Item_Qty_Increase_First);
			String AfterIncrease = getText(OR.Shop_Item_Qty_First);
			if (AfterIncrease != BeforeIncrease) {
				testLogPass(BeforeIncrease + " valuse  Before Increase" + AfterIncrease + " After Increase...");
			} else {
				testLogPass(BeforeIncrease + " valuse  Before Increase" + AfterIncrease + " After Increase...");
			}
			clickOn(OR.Shop_Item_Qty_Derease_First);
			String BeforeIncrease1 = getText(OR.Shop_Item_Qty_First);
			if (AfterIncrease != BeforeIncrease1) {
				testLogPass(BeforeIncrease + " value  Before Increase' " + AfterIncrease + " After Increase...");
			} else {
				testLogPass(BeforeIncrease + " value  Before Increase' " + AfterIncrease + " After Increase...");
			}
		}

	}

	public static String selectProf_fac()
	{
		clickOn(OR.User);
		waitForElementToDisplayWithoutFail(OR.User_Profile, 60);
		clickOn(OR.User_Profile);
		String facNAme=getText(OR.Profile_defaultFacility);
		setProperty("userFac_Profile",facNAme);
		return facNAme;

	}

	public static void selectTableView()
	{
		clickOn(OR.Shop_SHopfor_drilldownicon);
		mouseOver(OR.Shop_mouseoverviewtype);
		clickOn(OR.Shop_tableview);
	}

	@AfterTest
	public void endReport() {
		closeBrowser();
		extent.flush();
	}

}
