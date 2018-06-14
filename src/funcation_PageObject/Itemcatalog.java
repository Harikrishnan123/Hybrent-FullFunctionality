package funcation_PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.reporters.jq.TestPanel;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;
import pageObject.MycartPage;

public class Itemcatalog extends ApplicationKeyword{
	
	
	public static void NavigatetoItemcatalog()
	{
		clickOn(OR.DashBoard_AdminDropdown);
		clickOn(OR.Admin_ItemCatalog);
	}
	
	public static void verifyPage()
	{
		String Text = getTextchild("//*[@class='pagehead']");
		verifyElementText(Text, "Items Catalog");
		verifyElement(OR.Itemcatalog_btn_AddItem);
		verifyElementText(OR.Itemcatalog_SearchBy, "Search by:");
		verifyElement(OR.Receive_vendorDropdown);
		verifyElementText(OR.Itemcatalog_label_Status, "Status:");
		verifyElementText(OR.Itemcatalog_label_vendorName, "Vendor Name:");
		verifyElement(OR.ItemCatalog_AddItem_ItemDetails_Description);
		verifyElement(OR.Itemcatalog_input_Type);
		verifyElementText(OR.Itemcatalog_label_Type, "Type:");
		verifyElement(OR.Itemcatalog_input_category);
		verifyElementText(OR.Itemcatalog_label_Category, "Category:");
		verifyElement(OR.ItemCatalog_searchbutton);
	}
	
    public static void VerifyAlert()
    {
    	waitForElementToDisplay(OR.Alert_txt_userAlert, 60);
    	verifyElementText(OR.Alert_txt_userAlert, "USER ALERT");
        verifyElement(OR.Alert_Btn_cancel);
        verifyElement(OR.Alert_Btn_Update);
    }
    
    public static void addNewItem()
	{
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
		waitForElementToDisplayWithoutFail(OR.ItemCatalog_AddItem, 10);
		verifyElementText(OR.ItemCatalog_AddPage_AddItemText, "Add Item");
		clickOn(OR.ItemCatalog_AddItem);
		verifyElementText(OR.ItemCatalog_AddItem_ItemDetails_label_Description,"Description*");
		verifyElementText(OR.ItemCatalog_AddItem_ItemDetails_Label_alias,"Alias");
		verifyElementText(OR.ItemCatalog_AddItem_ItemDetails_Label_Manufacture,"Manufacturer*");
		verifyElementText(OR.ItemCatalog_AddPage_ItemDetails,"Item Detail");
		verifyElementText(OR.ItemCatalog_txt_Billonly,"Bill Only");
		verifyElement(OR.ItemCatalog_txt_Addmanufacture_Notes);
		verifyElement(OR.ItemCatalog_QualityinStock);
		verifyElement(OR.ItemCatalog_txt_Addmanufacture_LotTracking);
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
		waitForElement(OR.ItemCatalog_itemalias, 30);
		typeIn(OR.ItemCatalog_itemalias, aliasName);
		LotEnabletoogle();
		//ActiveEnabletoogle();
		ExpirationEnabletoogle();
		BillOnlyEnabletoogle();
		ImplantEnabletoogle();
		verifyElement(OR.ItemCatalog_additem_Is_Service_toogle);
		//Is_ServiceEnabletoogle();
		verifyElement(OR.ItemCatalog_additem_GLcode_dropdown);
		verifyElement(OR.ItemCatalog_additem_Categories_dropdown);
		verifyElement(OR.ItemCatalog_additem_CPTCOde_Input);
		verifyElement(OR.ItemCatalog_additem_CPTCOde_Input);
		verifyElement(OR.ItemCatalog_additem_hspcs_Input);
		AddVentor();
		 verifyElementText(OR.ItemCatalog_AddItem_Map_SearchFacility_Text, "Search Facility");
			verifyElement(OR.ItemCatalog_AddItem_Map_SearchFacility);
			verifyElement(OR.ItemCatalog_Mapfacility_Facility);
			verifyElement(OR.ItemCatalog_Mapfacility_PurchasePrice);
			verifyElement(OR.ItemCatalog_Mapfacility_Facility);
			verifyElement(OR.ItemCatalog_Mapfacility_GpocontactPrice);
			verifyElement(OR.ItemCatalog_Mapfacility_Discountprice);
			verifyElement(OR.ItemCatalog_Mapfacility_AddtoFacility_first);
			verifyElement(OR.ItemCatalog_Mapfacility_Preferred_first);
			verifyElement(OR.ItemCatalog_Mapfacility_Distributed_first);
			verifyElement(OR.ItemCatalog_Mapfacility_OnContract_first);
			clickOn(OR.ItemCatalog_Mapfacility_AddtoFacility_first);
			verifyElement(OR.ItemCatalog_Mapfacility_iSActive);
			verifyElement(OR.ItemCatalog_Mapfacility_Cancel);
			verifyElement(OR.ItemCatalog_Mapfacility_Save);
			int ele = driver.findElements(By.xpath("(//select[@name='stock_status'])[1]//option")).size();
			for(int i=1;i<=ele;i++)
			{
				String one = driver.findElement(By.xpath("(//*[@name='stock_status']//option)["+i+"]")).getText();
				testLogPass("stock drop down value is '"+one);
			}
			DiscountPriceInMap();
			waitForElementToDisplayWithoutFail(OR.ItemCatalog_mapallbuttontopright,10);
		clickOn(OR.ItemCatalog_mapallbuttontopright);
		//verifyElement(OR.ItemCatalog_Map_changeForMoreFacility);
		waitForElementToDisplayWithoutFail(OR.ItemCatalog_mapwithalltopright,10);
		clickOn(OR.ItemCatalog_mapwithalltopright);	
		waitForElementToDisplayWithoutFail(OR.ItemCatalog_verifytextpopup,10);
		Map();
		verifyElement(OR.ItemCatalog_Mapfacility_Deletebtn);
		verifyElement(OR.ItemCatalog_Mapfacility_Editbtn);
		verifyElement(OR.ItemCatalog_VendorUpdate);
		String Tooltip = getAttributeValue(OR.ItemCat_vendorUpdatebtn, "uib-tooltip");
		if(Tooltip.contains("Get latest price and availability status from vendor site."))
		{
			clickOn(OR.ItemCatalog_VendorUpdate);
		verifyElementText(OR.ItemCat_vendorUpdateHeader, "Vendor Update");
		verifyElement(OR.ItemCat_vendorUpdate_Stockprice1);
		verifyElement(OR.ItemCat_vendorUpdate_Stockprice2);
		verifyElement(OR.ItemCat_vendor_currentPrice);
		verifyElement(OR.ItemCat_vendorUpdate_Price);
		verifyElement(OR.ItemCat_vendorUpdate_Userbtn);
		verifyElement(OR.ItemCat_vendorUpdate_Cancelbtn);
		clickOn(OR.ItemCat_vendorUpdate_Cancelbtn);
		}
		
		verifyPagination();
		waitForElementToDisplayWithoutFail(OR.ItemCatalog_AddItem_Map_Closepage, 10);	
		clickOn(OR.ItemCatalog_AddItem_Map_Closepage);		
	}
    
 
    public static void DownBtn()
    {
    	verifyElement(OR.ItemCatalog_downbutton);
    	clickOn(OR.ItemCatalog_downbutton);
    	clickOn(OR.ItemCatalog_additem_Vendors_QuickCodedropdown);
		verifyElementText(OR.ItemCatalog_additem_Vendors_QuickCode_label, "Quick Code");
		clickOn(OR.ItemCatalog_downbutton);
		clickOn(OR.ItemCatalog_additem_Vendors_CWIIDDdropdown);
		verifyElementText(OR.ItemCatalog_additem_Vendors_CWIIDD_label, "CWIIDD");
    }
    
    public static void AddVentor()
    {
    	clickOn(OR.ItemCatalog_VendorsTab);
    	verifyElement(OR.ItemCatalog_Vendort_IsActive);
    	verifyElement(OR.ItemCatalog_Vendort_VendorName);
    	verifyElement(OR.ItemCatalog_Vendort_SKU);
    	verifyElement(OR.ItemCatalog_Vendort_UOM);
    	verifyElement(OR.ItemCatalog_Vendort_QTYUOM);
    	verifyElement(OR.ItemCatalog_Vendort_MinORder);
		clickOn(OR.ItemCatalog_AddVendors);
		DeleteVendor();
		waitForElement(OR.ItemCatalog_Add_Vendorsname, 60);
		clickOn(OR.ItemCatalog_Add_Vendorsname);
		
				int size = driver.findElements(By.xpath("//*[@class='ui-select-choices-row-inner']")).size();
				for(int i=1;i<=size;i++)
				{
					WebElement e = driver.findElement(By.xpath("(//*[@class='ui-select-choices-row-inner'])["+i+"]"));
					waitTime(1);
					if(e.getText().toLowerCase().contains("medline"))
					{
						e.click();
					}
				}
		//waitForElement(OR.ItemCatalog_AddItem_VendorSelect_First, 60);
		//clickOn(OR.ItemCatalog_AddItem_VendorSelect_First);
		typeIn(OR.ItemCatalog_Add_VendorsSkuName, SkuName);
		typeIn(OR.ItemCatalog_Add_VendorsMinOrderQty, "1");
		DownBtn();
		vendor_Name=getText(OR.ItemCatalog_firstvendor);
		setProperty("vendorName", vendor_Name);
		MycartPage.chkMan_level("ItemMfr");
		clickOn(OR.ItemCatalog_AddItem_Man_Save);
		waitForElementToDisplayWithoutFail(OR.ItemCatalog_AddItem_MapValidation, 10);
		verifyElementText(OR.ItemCatalog_AddItem_MapValidation, "Do you want to map this item to your various facilities?");
		clickOn(OR.ItemCatalog_AddItem_MapValidation_yes);
		getText(OR.ItemCatalog_AddItem_Map_Header);
    }
    
    public static void DeleteVendor()
    {
    	clickOn(OR.ItemCatalog_additem_Delete_vendor);
    	verifyElement(OR.ItemCatalog_additem_Deletevalidation);
    	clickOn(OR.Template_Warningok);
    }
    
    public static void verifyStatusDropdown()
    {
    	
    	int size = driver.findElements(By.xpath("//*[@id='status']/option")).size();
    	Select select = new Select(driver.findElement(By.xpath("//*[@id='status']")));
    	WebElement option = select.getFirstSelectedOption();
    	String defaultItem = option.getText();
    	testLogPass("Default value selected int the Drop down of status is "+defaultItem );
    	for(int i=1;i<=size ; i++)
    	{
    		String getText = driver.findElement(By.xpath("//*[@id='status']/option["+i+"]")).getText();
    		testLogPass("Status Drop down values is "+getText);
    	}
    		
    }
    
    public static void verifytypeDropdown()
    {
    	
    	int size = driver.findElements(By.xpath("//*[@id='type']/option")).size();
    	Select select = new Select(driver.findElement(By.xpath("//*[@id='type']")));
    	WebElement option = select.getFirstSelectedOption();
    	String defaultItem = option.getText();
    	testLogPass("Default value selected int the Drop down of type is "+defaultItem );
    	    	for(int i=1;i<=size ; i++)
    	{
    		String getText = driver.findElement(By.xpath("//*[@id='type']/option["+i+"]")).getText();
    		testLogPass("Type Drop down values is "+getText);
    	}		
    }
    
    public static void verifyNoItemfound(String Input)
    {
    	typeIn(OR.ItemCatalog_searchTextBox,Input);
    	clickOn(OR.ItemCatalog_searchbutton);
    	verifyElementText(OR.Itemcatalog_Noitemfound, "No item found.");
    	
    }
    
    
    public static void LotEnabletoogle()
    {
    	String Attributevalue = getAttributeValue(OR.ItemCatalog_additem_LotTracking_toogle, "class");
    	if(Attributevalue.contains("bootstrap-switch-off"))
    	{
    		clickOn(OR.ItemCatalog_additem_LotTracking_toogle);
    	}
    }
    
    public static void ActiveEnabletoogle()
    {
    	String Attributevalue = getAttributeValue(OR.ItemCatalog_additem_Active_toogle, "class");
    	if(Attributevalue.contains("bootstrap-switch-off"))
    	{
    		clickOn(OR.ItemCatalog_additem_Active_toogle);
    	}
    }
    
    public static void ExpirationEnabletoogle()
    {
    	String Attributevalue = getAttributeValue(OR.ItemCatalog_additem_Expiration_toogle, "class");
    	if(Attributevalue.contains("bootstrap-switch-off"))
    	{
    		clickOn(OR.ItemCatalog_additem_Expiration_toogle);
    	}
    }
    
    public static void BillOnlyEnabletoogle()
    {
    	String Attributevalue = getAttributeValue(OR.ItemCatalog_additem_Bill_Only_toogle, "class");
    	if(Attributevalue.contains("bootstrap-switch-off"))
    	{
    		clickOn(OR.ItemCatalog_additem_Bill_Only_toogle);
    	}
    }
    
    public static void ImplantEnabletoogle()
    {
    	String Attributevalue = getAttributeValue(OR.ItemCatalog_additem_Implant_toogle, "class");
    	if(Attributevalue.contains("bootstrap-switch-off"))
    	{
    		clickOn(OR.ItemCatalog_additem_Implant_toogle);
    	}
    }
    
    public static void Is_ServiceEnabletoogle()
    {
    	String Attributevalue = getAttributeValue(OR.ItemCatalog_additem_Is_Service_toogle, "class");
    	if(Attributevalue.contains("bootstrap-switch-off"))
    	{
    		clickOn(OR.ItemCatalog_additem_Is_Service_toogle);
    	}
    }
    
    public static void EditItem()
   	{
    	
    	typeIn(OR.ItemCatalog_searchTextBox, getProperty("Sku"));
    	clickOn(OR.ItemCatalog_searchButtoncommon);
    	clickOn(OR.ItemCatalog_firstEDitButton);
    	verifyElementText(OR.EditItem_text,"Edit Item");
    	if(isElementDisplayed(OR.ItemCatalog_AddItme_TestId, 10))
   		{
   			if(isElementDisplayed(OR.ItemCatalog_AddItme_TestId))
   			{
   				String one = getAttributeValue(OR.ItemCatalog_AddItme_TestId, "value");
   				if(one.contains(""))
   				{
   					testLogPass("testid field is empty");
   				}
   			}	
   		}
    	
    	clickOn(OR.ItemCatalog_VendorsTab);

    	String Editvendorname = getText(OR.ItemCatalog_Add_Vendorsname);
    	String EditSkuName = getAttributeValue(OR.ItemCatalog_Add_VendorsSkuName, "value");
    	String UOM = driver.findElement(By.xpath("//input[@ng-model='v.UOM_quantity']")).getAttribute("value");
    	
    	if(!Editvendorname.isEmpty() )
    	{
    		testLogPass("vendorname contains value '"+Editvendorname);
    	}
    	else
    	{
       		testLogFail("vendorname is empty '");
       	}
    	if(!EditSkuName.isEmpty() )
    	{
    		testLogPass("Sku contains value '"+EditSkuName);
    	}
    	else
    	{
       		testLogFail("Sku is empty '");
       	}
    	
    	if(UOM!=null )
    	{
    		testLogPass("UOM contains value '"+UOM);
    	}
    	else
    	{
    		testLogFail("UOM not contains any value '"+UOM);
    	}
    	clickOn(OR.ItemCatalog_downbutton);
    	clickOn(OR.ItemCatalog_additem_Vendors_ManageImagedropdown);
    	verifyElement(OR.ItemCatalog_FileUpload_Remove_First);
    	verifyElement(OR.ItemCatalog_FileUpload_CloseBtn);
    	String MbFile =System.getProperty("user.dir")+"/assets/3Mb.jpg";
    	String AttributeDisable =getAttributeValue(OR.ItemCatalog_FileUpload_Remove_First, "disabled");
    	if(AttributeDisable.contains("null"))
    	{
    		testLogFail("Remove button is in disable condition");
    	}
    	else if(AttributeDisable.contains("true"))
    	{
    		testLogPass("Remove button is in Enable disable condition");
    	}
    	//driver.findElement(By.xpath("(//*[@type='file'])[1]")).sendKeys(MbFile);
    	//ToastmesssageSucess();
    	
    	String file =System.getProperty("user.dir")+"/assets/1.jpeg";
    	driver.findElement(By.xpath("(//*[@type='file'])[1]")).sendKeys(file);
    	ToastmesssageSucess();
    	String Attributeimg =getAttributeValue(OR.ItemCatalog_FileUpload_FirstImg, "src");
    	if(Attributeimg.contains("amazonaws.com"))
    	{
    		testLogPass("File is uploaded");
    	}
    	else
    	{
    		testLogFail("File is not uploaded");
    	}
    	driver.findElement(By.xpath("(//*[@type='file'])[2]")).sendKeys(file);
    	ToastmesssageSucess();
    	driver.findElement(By.xpath("(//*[@type='file'])[3]")).sendKeys(file);
    	ToastmesssageSucess();
    	driver.findElement(By.xpath("(//*[@type='file'])[4]")).sendKeys(file);
    	ToastmesssageSucess();
    	driver.findElement(By.xpath("(//*[@type='file'])[5]")).sendKeys(file);
    	ToastmesssageSucess();
    	clickOn(OR.ItemCatalog_FileUpload_CloseBtn);
    	waitTime(6);
    	verifyElementText(OR.EditItem_text,"Edit Item");
    	clickOn(OR.ItemcaCategory_CreateCategory_btn_Save);
   	}
    
    public static void  MapFacility() 
    {
    	clickOn(OR.ItemcaCategory_ManageFacilityUpdateprive);
    	getText(OR.ItemCatalog_headTextEDit_Update);
    }
    
    public static void DeleteFacility()
    {
    		clickOn(OR.ItemCatalog_Mapfacility_Deletebtn);
    		ToastmesssageSucess();
    }
       
    public static void Mapfacility()
    {
    	typeIn(OR.ItemCatalog_searchTextBox, getProperty("Sku"));
    	clickOn(OR.ItemCatalog_searchButtoncommon);
    }
    
    public static void EditMapFacility()
    {
    	typeIn(OR.ItemCatalog_searchTextBox, "test desccccc");
    	clickOn(OR.ItemCatalog_searchButtoncommon);
    	clickOn(OR.ItemcaCategory_ManageFacilityUpdateprive);
    	clickOn(OR.ItemCatalog_mapallbuttontopright);
		//verifyElement(OR.ItemCatalog_Map_changeForMoreFacility);
		waitForElementToDisplayWithoutFail(OR.ItemCatalog_mapwithalltopright,10);
		verifyElement(OR.ItemCatalog_Map_changeForMoreFacility);
		clickOn(OR.ItemCatalog_Map_changeForMoreFacility);
    }
    
    
    public static void Map()
    {
    	verifyElementText(OR.ItemCatalog_verifytextpopup, "Map with all facilities");
		verifyElement(OR.ItemCatalog_Map_PurchasePrice);
		verifyElement(OR.ItemCatalog_Map_StockPrice);
		verifyElement(OR.ItemCatalog_Map_DiscountType);
		int StockStatusSize = driver.findElements(By.xpath("//*[text()='Stock Status']/following-sibling::div//option")).size();
		for(int i=1;i<=StockStatusSize;i++)
		{
			String one = driver.findElement(By.xpath("//*[text()='Stock Status']/following-sibling::div//option["+StockStatusSize+"]")).getText();
			testLogPass("Stock status drop down value is '"+one);
		}
		int DiscountTypeSize = driver.findElements(By.xpath("//*[text()='Discount type']/following-sibling::div//option")).size();
		for(int i=1;i<=DiscountTypeSize;i++)
		{
			String one = driver.findElement(By.xpath("//*[text()='Discount type']/following-sibling::div//option["+i+"]")).getText();
			testLogPass("Discount Type drop down value is '"+one);
		}
		verifyElement(OR.ItemCat_vendorUpdate_Cancelbtn);
		typeIn(OR.ItemCatalog_purchaseprice, "60");
		clickOn(OR.ItemCatalog_mapallbutton);
		ToastmesssageSucess();
    }
    
    public static void DiscountPriceInMap()
    {
    	typeIn(OR.ItemCatalog_AddItem_Map_PurchagePrice, "2");
		selectFromDropdown(OR.ItemCatalog_DiscountType_Dropdown, "Percentage");
		verifyElementText(OR.ItemCatalog_DiscountPercentage, "Discount(%)");
		typeIn(OR.ItemCatalog_DiscountPercentage_Input, "3");
		clickOn(OR.ItemCatalog_Mapfacility_Save);
		ToastmesssageSucess();
    }
    
    public static void CLoseMap()
    {
    	typeIn(OR.ItemCatalog_searchTextBox, getProperty("Sku"));
    	clickOn(OR.ItemCatalog_searchButtoncommon);
    	clickOn(OR.ItemcaCategory_ManageFacilityUpdateprive);
    	waitForElementToDisplayWithoutFail(OR.ItemCatalog_mapallbuttontopright,10);
    	clickOn(OR.ItemCatalog_mapallbuttontopright);
		//verifyElement(OR.ItemCatalog_Map_changeForMoreFacility);
		waitForElementToDisplayWithoutFail(OR.ItemCatalog_Map_changeForMoreFacility,10);
		verifyElement(OR.ItemCatalog_Map_changeForMoreFacility);
		clickOn(OR.ItemCatalog_Map_changeForMoreFacility);
		verifyElementText(OR.ItemCatalog_verifytextpopup, "Map with all facilities");
		clickOn(OR.ItemCat_vendorUpdate_Cancelbtn);
		String Title = getText(OR.ItemCatalog_AddItem_Map_Header);
		if(Title.contains("Map Facility for"))
		{
			testLogPass("Cancelling came back to page");
		}
		waitForElementToDisplayWithoutFail(OR.ItemCatalog_Map_changeForMoreFacility,10);
		clickOn(OR.ItemCatalog_mapallbuttontopright);
		//verifyElement(OR.ItemCatalog_Map_changeForMoreFacility);
		waitForElementToDisplayWithoutFail(OR.ItemCatalog_mapwithalltopright,10);
		verifyElement(OR.ItemCatalog_mapwithalltopright);
		clickOn(OR.ItemCatalog_Map_changeForMoreFacility);
		verifyElementText(OR.ItemCatalog_verifytextpopup, "Map with all facilities");
		clickOn(OR.ItemCat_vendorUpdate_Cancelbtn);
		String Title1 = getText(OR.ItemCatalog_AddItem_Map_Header);
		if(Title1.contains("Map Facility for"))
		{
			testLogPass("Cancelling came back to page");
		}
    }
}
