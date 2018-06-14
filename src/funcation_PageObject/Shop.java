package funcation_PageObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;
import AutomationFramework._OR;

public class Shop extends ApplicationKeyword{
	public static ArrayList<String> User_vendor=new ArrayList();
	public static ArrayList<String> User_vendor1=new ArrayList();
	public static void VerifyShopPage()
    {
		waitForElementToDisplay(OR.Shop_SHopfor_Shopfaclity, 60);
        verifyElementText(OR.Shop_SHopfor_Shopfaclity, "Select Facility");
    }
	
	public static void verifyShop()
	{
		waitForElementToDisplay(OR.Shop_Shopfor, 20);
		verifyElementText(OR.Shop_Shopfor, "SHOPPING FOR");
		verifyElementText(OR.Shop_Shopfor_selectedFacility, getProperty("UserAddfailityName"));
		verifyElement(OR.Shop_SHopfor_MyInventoryradiobutton);
		clickOn(OR.Shop_SHopfor_RecentlyOrderedradiobutton);
		verifyElement(OR.Shop_SHopfor_RecentlyOrderedradiobutton);
		clickOn(OR.Shop_SHopfor_MostOrderedradiobutton);
		verifyElement(OR.Shop_SHopfor_MostOrderedradiobutton);
		clickOn(OR.Shop_SHopfor_FavOrderedradiobutton);
		verifyElement(OR.Shop_SHopfor_FavOrderedradiobutton);
		waitForElement(OR.Shop_SHopfor_MyInventoryradiobutton);
		clickOn(OR.Shop_SHopfor_MyInventoryradiobutton);
		verifyElementText(OR.Shop_SearchItemin, "Search item in");
		Dropdown();
		DropdownMatch();
	}
	
	
	public static void MatchDropdown()
	{
		verifyElementText(OR.Shop_Match_Text, "Match");
		int one = driver.findElements(By.xpath("")).size();
		driver.findElement(By.xpath("//*[@id='matchselect']")).click();
		for(int i=0;i<=one;i++)
		{
			String two = driver.findElement(By.xpath("//*[@id='matchselect']/option["+i+"]")).getText();
			if(two.contains("Partial"))
			{
				testLogPass("Text is presend in the dropdown is "+two);
			}
			else if(two.contains("Exact"))
			{
				testLogPass("Text is presend in the dropdown is "+two);
			}
			else
			{
				testLogFail("text is not present in the dropdown "+two);
			}				
		}
	}	
	
	public static void autosearch()
	{
		typeIn(OR.Shop_SHopfor_SearchBox, "abc");
		if(driver.findElements(By.xpath("(//*[@data-markjs='true'])[1]")).size()!=0)
		{
			testLogPass("Auto Search for shop is present");
		}
		else if(isElementDisplayed(OR.No_Item_Found, 10))
		{
			testLogPass("Auto Search for shop is present");
		}
	}
	
	
	public static void verifyselectedFacdisable()
	{
		String BSelectFacilityName = getText(OR.Shop_Shopfor_selectedFacility);
		clickOn(OR.Shop_Shopfor_selectedFacility);
		verifyElementText(OR.Shop_SHopfor_Shopfaclity, "Select Facility");
		
		int Size = driver.findElements(By.xpath("//table//*[@class='pull-right']//button")).size();
		
		for(int i=1;i<=Size;i++)
		{
			String buttonName = driver.findElement(By.xpath("(//table//*[@class='pull-right']//button)["+i+"]")).getText();
			if(buttonName.contains("Selected"))
			{
				String FacilityName =driver.findElement(By.xpath("//*[@uib-modal-window='modal-window']//tbody/tr["+i+"]/td[1]")).getText().trim();;
				if(FacilityName.contains(BSelectFacilityName)) 
				{
					String Disable = driver.findElement(By.xpath("//tbody/tr["+i+"]/td[2]/div/button")).getText();
					if(Disable.contains("Selected"))
					{
						testLogPass("selected facility appears disabled and with text \"selected\".");
					}
					
							
				}
			}
		}
		
		clickOn(OR.HeaderClose);
		
	}
	
	
	
	public static void Dropdown()
	{
		driver.findElement(By.xpath("//*[@class='multiselect-parent btn-group dropdown-multiselect']")).click();
		int size = driver.findElements(By.xpath("//*[@class='dropdown-menu dropdown-menu-form']//a")).size();
		for(int i =1 ;i<=5;i++)
		{
			String one = driver.findElement(By.xpath("(//*[@class='dropdown-menu dropdown-menu-form']//*[@class='ng-scope']//a)["+i+"]")).getText();
			testLogPass("Dropdown list are "+one);
		}
		
	}
	
	public static void DropdownMatch()
	{
		driver.findElement(By.xpath("//*[@class='multiselect-parent btn-group dropdown-multiselect']")).click();
		int size = driver.findElements(By.xpath("//*[@id='matchselect']/option")).size();
		for(int i =1 ;i<=size;i++)
		{
			selectFromDropdown(OR.Shop_SHopfor_Search_Match, i);
			String one = driver.findElement(By.xpath("(//*[@id='matchselect']/option)["+i+"]")).getText();
			testLogPass("Match list are "+one);
		}
		
	}
	
	public static void Search(String Search)
	{
		typeIn(OR.Shop_searchfield, Search);
		int size = driver.findElements(By.xpath("//*[@value='name']/span")).size();
		if(size!=0)
		{
			String one = driver.findElement(By.xpath("(//*[@value='name']/span)[1]")).getText();
			String Highlight = driver.findElement(By.xpath("(//*[@value='name']/span[1]/mark)[1]")).getText();
			testLogPass("Item is present"+one);
			testLogPass("Highlight value is "+Highlight);
		}
		else
		{
			String Highlight = driver.findElement(By.xpath("(//*[@value='name']/span[1]/mark)[1]")).getText();
			
			testLogPass("Highlight value is "+Highlight);
			testLogPass("item is not present");
		}
	}
	
	public static void Vendorlisverification()
	{
		clickOn(_OR.DashBoard_Admin);
		clickOn(OR.Users_page);
		typeIn(OR.Users_SearchTextBox, getProperty("created_NeUser"));
		clickOn(OR.Users_SearchButton);
		waitForElementToDisplay(OR.Users_EditFirstUser, 10);
		clickOn(OR.Users_EditFirstUser);
		waitForElementToDisplay(OR.Users_vendorAccessTab1, 15);
		clickOn(OR.Users_vendorAccessTab1);
		int size = driver.findElements(By.xpath("//*[@ng-repeat='selectedItem in selecteditems']")).size();
		for(int i =1 ;i<=size;i++)
		{
			String one = driver.findElement(By.xpath("(//*[@ng-repeat='selectedItem in selecteditems'])["+i+"]")).getText();
			testLogPass("vendor list are "+one);
			User_vendor.add(one);
		}
		clickOn(OR.Alert_Btn_cancel);
		waitForElement(OR.Shop_Menu);
		clickOn(OR.Shop_Menu);
		
		int size1 = driver.findElements(By.xpath("//*[@id='vendor']/option")).size();
		for(int i =1 ;i<=size1;i++)
		{
			String one1 = driver.findElement(By.xpath("(//*[@id='vendor']/option)["+i+"]")).getText();
			testLogPass("Shop page vendor list are "+one1);
			User_vendor1.add(one1);
		}
		User_vendor1.remove(2);
		 Collections.sort(User_vendor1);
		 Collections.sort(User_vendor);
		 if(User_vendor1.equals(User_vendor))
		 {
			 testLogPass("Both vendor in shop page and user page are same.");
		 }
		 
	}
	
	public static void Organiationchange()
	{
		clickOn(_OR.DashBoard_Admin);
		waitForElement(_OR.DashBoard_Admin_organization);
		clickOn(_OR.DashBoard_Admin_organization);
		waitForElement(_OR.DashBoard_Admin_organization_Features);
		clickOn(_OR.DashBoard_Admin_organization_Features);
		String attr = driver.findElement(By.xpath("//*[text()='Is Item Receive In Inventory']/following-sibling::div/div")).getAttribute("class");
		if(attr.contains("bootstrap-switch-on"))
		{
			driver.findElement(By.xpath("//*[text()='Is Item Receive In Inventory']/following-sibling::div/div")).click();
			clickOn(OR.Template_SaveBtn);
			if(isElementDisplayed(_OR.Setting_Update_sucess))
			{
				clickOn(OR.Template_Warningok);
				
			}
		}
		
		clickOn(OR.Shop_Menu);
		ArrayList<String> obtainedList = new ArrayList<>(); 
		List<WebElement> elementList= driver.findElements(By.xpath("//*[@id='vendor']/option"));
		for(WebElement we:elementList){
		   obtainedList.add(we.getText());
		}
		ArrayList<String> sortedList = new ArrayList<>();   
		for(String s:obtainedList){
		sortedList.add(s);
		}
		Collections.sort(sortedList);
		testLogPass("vendor list is in sorted ");
		//Assert.assertTrue(sortedList.equals(obtainedList));
	}
	
	public static void Grid()
	{
		clickOn(OR.Shop_SHopfor_drilldownicon);
		int size1 = driver.findElements(By.xpath("//*[@ng-readonly='moveingToPunchOutSite']/li/a")).size();
		for(int i =1 ;i<=size1;i++)
		{
			String one1 = driver.findElement(By.xpath("(//*[@ng-readonly='moveingToPunchOutSite']/li/a)["+i+"]")).getText();
			testLogPass("Action dropdown values '"+one1);
		}
		
		mouseOver(OR.Shop_mouseoverviewtype);
		clickOn(OR.Shop_gridView);
		waitForElementToDisplayWithoutFail(OR.Shop_SHopfor_drilldownicon, 30);
		Gridview();
		selectTableView();
		waitForElementToDisplayWithoutFail(OR.Shop_SHopfor_drilldownicon, 30);		
		if(driver.findElement(By.xpath("//*[@class='panel-body']/div")).getAttribute("class").contains("table-responsive"))
		{
			testLogPass("Successfully changed to TABLE View");
		}
		else
		{
			testLogFail("View is not changed to TABLE view");
		}		
	}
	public static void selectTableView()
	{
		clickOn(OR.Shop_SHopfor_drilldownicon);
		mouseOver(OR.Shop_mouseoverviewtype);
		clickOn(OR.Shop_tableview);
	}
	
	
	public static void MenuList()
	{	
		int size1 = driver.findElements(By.xpath("//thead/tr/th//a")).size();
		for(int i =1 ;i<=size1;i++)
		{
			String one1 = driver.findElement(By.xpath("(//thead/tr/th//a)["+i+"]")).getText();
			testLogPass("Menu title verification "+one1);
		}
		
	}
	public static void pricevalidation()
	{
		waitForElement(OR.Shop_ItemNameDropDown_First);
		clickOn(OR.Shop_ItemNameDropDown_First);
		waitForElement(OR.Shop_ItemNameDropDownEdit_First);
		clickOn(OR.Shop_ItemNameDropDownEdit_First);
		clickOn(OR.ItemTabVendor);
		typeIn(OR.ItemCatalog_purchase_price_Edit, "60");
		typeIn(OR.ItemCatalog_GPo_price_Edit, "10");
		clickOn(OR.PriceTire_Add_Save);
		waitUntilPageReady();
		DecreaseQty();
		if(driver.findElements(By.xpath("(//*[@ng-click='$ctrl.addItemToCart(item)'])[1]")).size()!=0)
		{
			clickOn(OR.Shop_SHopfor_Search_Addtocart_First);
			if(driver.findElements(By.xpath("//*[text()='This item is not under contract or a preference item from your distributor, It may cost more.']")).size()!=0)
			{
				verifyElementText(OR.Shop_Alertvalidation, "This item is not under contract or a preference item from your distributor, It may cost more.");
				if(isElementDisplayed(OR.Shop_Alert_Dontnotadd_checkbox))
				{
					clickOn(OR.Shop_Alert_Dontnotadd_checkbox);
				}
				clickOn(OR.MyCart_warningPopup);
			}
			
			if(driver.findElements(By.xpath("//button[text()='Update Price']")).size()!=0)
			{
				clickOn(OR.ItemCatalog_FileUpload_CloseBtn);
			}
			}
		if(driver.findElements(By.xpath("(//*[@ng-click='$ctrl.addItemToCart(item)'])[1]")).size()!=0)
		{
			clickOn(OR.Shop_SHopfor_Search_Addtocart_First);
			if(driver.findElements(By.xpath("//*[text()='This item is not under contract or a preference item from your distributor, It may cost more.']")).size()!=0)
			{
				verifyElementText(OR.Shop_Alertvalidation, "This item is not under contract or a preference item from your distributor, It may cost more.");
				if(isElementDisplayed(OR.Shop_Alert_Dontnotadd_checkbox))
				{
					clickOn(OR.Shop_Alert_Dontnotadd_checkbox);
				}
				clickOn(OR.MyCart_warningPopup);
			}
			
			if(driver.findElements(By.xpath("//button[text()='Update Price']")).size()!=0)
			{
				String one1 = driver.findElement(By.xpath("//*[@class='modal-body']//h4")).getText();
				testLogPass("validation message is displays for vendor price is greater than contract price "+one1);
				clickOn(OR.Shop_UpdatePrice);
				waitUntilPageReady();
				clickOn(OR.Shop_UpdatePrice1);
			}
			}
			
		}
	
	public static void ContractPrice()
	{
		clickOn(_OR.DashBoard_Admin);
		clickOn(_OR.DashBoard_Admin_organization);
		clickOn(_OR.DashBoard_Admin_organization_Features);
		mouseOver(OR.Shop_Contractpriecradiobtn);
		clickOn(OR.Shop_Contractpriecradiobtn);
		clickOn(OR.glCode_saveButton);
		if(driver.findElements(By.xpath("//*[text('Organization settings updated, hit ok to update']")).size()!=0)
		{
			clickOn(OR.Template_Warningok);
			waitUntilPageReady();
		}
		clickOn(_OR.Dashboard_Submenu_shop);
		typeIn(OR.Shop_SHopfor_SearchBox,getProperty("ItemDesc"));
	}
	
	public static void Discontinued()
	{
		waitUntilPageReady();
		clickOn(OR.Shop_ItemNameDropDown_First);
		waitTime(2);
		clickOn(OR.Shop_ItemNameDropDownEdit_First);
		clickOn(OR.ItemTabVendor);
		selectFromDropdown(OR.Shop_ItemName_StockDropdown, "Discontinued");
		clickOn(OR.PriceTire_Add_Save);
		waitUntilPageReady();
		DecreaseQty();
		if(driver.findElements(By.xpath("(//*[@ng-click='$ctrl.addItemToCart(item)'])[1]")).size()!=0)
		{
			clickOn(OR.Shop_SHopfor_Search_Addtocart_First);
			if(driver.findElements(By.xpath("(//h2//following-sibling::p)[1]")).size()!=0)
			{
				String Disco = driver.findElement(By.xpath("(//h2//following-sibling::p)[1]")).getText();
				testLogPass("Validation message "+Disco);
				testLogPass("Validation message "+Disco);
				if(isElementDisplayed(OR.Shop_Alert_Dontnotadd_checkbox))
				{
					clickOn(OR.Shop_Alert_Dontnotadd_checkbox);
				}
				clickOn(OR.Shop_SHopfor_Search_Addtocart_First);
				if(isElementDisplayed(OR.Shop_Alert_Dontnotadd_checkbox))
				{
					clickOn(OR.Shop_Alert_Dontnotadd_checkbox);
				}
				clickOn(OR.MyCart_warningPopup);
			}
			clickOn(OR.User);
			clickOn(OR.User_alert);
			if(driver.findElement(By.xpath("//*[text()='Show Item Discontinue Warning:']/following-sibling::div/div")).getAttribute("class").contains("bootstrap-switch-off"))
			{
				testLogPass("toggle button is changed to “OFF”");
			}
			
			}
	}
	
	public static void backorder()
	{
		waitTime(2);
		clickOn(OR.Shop_ItemNameDropDown_First);
		waitTime(2);
		clickOn(OR.Shop_ItemNameDropDownEdit_First);
		clickOn(OR.ItemTabVendor);
		selectFromDropdown(OR.Shop_ItemName_StockDropdown, "Back Ordered");
		clickOn(OR.PriceTire_Add_Save);
		waitUntilPageReady();
		DecreaseQty();
		if(driver.findElements(By.xpath("(//*[@ng-click='$ctrl.addItemToCart(item)'])[1]")).size()!=0)
		{
			clickOn(OR.Shop_SHopfor_Search_Addtocart_First);
			if(driver.findElements(By.xpath("(//h2//following-sibling::p)[1]")).size()!=0)
			{
				String Disco = driver.findElement(By.xpath("(//h2//following-sibling::p)[1]")).getText();
				testLogPass("Validation message "+Disco);
				if(isElementDisplayed(OR.Shop_Alert_Dontnotadd_checkbox))
				{
					clickOn(OR.Shop_Alert_Dontnotadd_checkbox);
					isElementDisplayed(OR.Shop_Alert_Dontnotadd_checkbox);
				}
				clickOn(OR.Shop_SHopfor_Search_Addtocart_First);
				waitForElement(OR.MyCart_warningPopup);
				clickOn(OR.MyCart_warningPopup);
			}
			clickOn(OR.User);
			clickOn(OR.User_alert);
			if(driver.findElement(By.xpath("//*[text()='Show Item Backorder Warning:']/following-sibling::div/div")).getAttribute("class").contains("bootstrap-switch-off"))
			{
				testLogPass("toggle button is changed to “OFF”");
			}
			
			}
	}
	
	public static void DecreaseQty()
	{
		String one = driver.findElement(By.xpath("(//*[@editable-text='item.qty']/nobr/span)[1]")).getText();
		if(one!= null && !one.isEmpty())
		{	String BeforeIncrease = getText(OR.Shop_Item_Qty_First);
			int qtyysize = Integer.parseInt(BeforeIncrease);
			for(int i = 1;i<=qtyysize;i++)
			{
				clickOn(OR.Shop_Item_Qty_Derease_First);
				waitUntilPageReady();
			}
		}
	}
	
	public static void SimilarItems()
	{
		Itemcatalog.NavigatetoItemcatalog();
		String one = "Sim"+randomAlphaNumeric(4);
		setProperty("Similarsku", one);
		typeIn(OR.ItemCatalog_searchTextBox, getProperty("Sku"));
    	clickOn(OR.ItemCatalog_searchButtoncommon);
    	waitForElement(OR.EditItem_btn);
    	clickOn(OR.EditItem_btn);
    	waitForElement(OR.ItemCatalog_VendorsTab);
    	clickOn(OR.ItemCatalog_VendorsTab);
    	waitForElement(OR.ItemCatalog_AddVendors);
    	clickOn(OR.ItemCatalog_AddVendors);
    	clickOn(OR.ItemCatalog_Add_Vendorsname1);
		
		int size = driver.findElements(By.xpath("//*[@class='ui-select-choices-row-inner']")).size();
		for(int i=1;i<=size;i++)
		{
			WebElement e = driver.findElement(By.xpath("(//*[@class='ui-select-choices-row-inner'])["+i+"]"));
			waitTime(1);
			if(e.getText().contains("Medline"))
			{
				e.click();
			}
		}
		typeIn(OR.ItemCatalog_Add_VendorsSkuName1, getProperty("Similarsku"));
		typeIn(OR.ItemCatalog_Add_VendorsMinOrderQty1, "1");
		clickOn(OR.ItemcaCategory_CreateCategory_btn_Save);
		ToastmesssageSucess();
		waitForElement(OR.ItemCatalog_MapfacilityButton);
    	clickOn(OR.ItemCatalog_MapfacilityButton);
    	clickOn(OR.ItemCatalog_Mapfacility_AddtoFacility_first);
		int ele = driver.findElements(By.xpath("(//select[@name='stock_status'])[1]//option")).size();
		for(int i=1;i<=ele;i++)
		{
			String one4 = driver.findElement(By.xpath("(//*[@name='stock_status']//option)["+i+"]")).getText();
			testLogPass("stock drop down value is '"+one4);
		}
		Itemcatalog.DiscountPriceInMap();
		waitForElementToDisplayWithoutFail(OR.ItemCatalog_mapallbuttontopright,10);
	clickOn(OR.ItemCatalog_mapallbuttontopright);
	//verifyElement(OR.ItemCatalog_Map_changeForMoreFacility);
	waitForElementToDisplayWithoutFail(OR.ItemCatalog_mapwithalltopright,10);
	clickOn(OR.ItemCatalog_mapwithalltopright);	
	waitForElementToDisplayWithoutFail(OR.ItemCatalog_verifytextpopup,10);
	Itemcatalog.Map();
	clickOn(OR.ItemCatalog_Close);
	
	}

	
}
	

