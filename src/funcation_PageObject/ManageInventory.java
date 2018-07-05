package funcation_PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;
import pageObject.ManageInventoryPOpage;
//contains javascript function
public class ManageInventory extends ApplicationKeyword
{
	public static void PageLinkAndWait(String pagepartialTitle, String fullLink)
    {
		JavascriptExecutor je = (JavascriptExecutor) driver;		
		WebElement element = driver.findElement(By.xpath("//a[@href='#/"+pagepartialTitle+"']"));
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		clickOn(fullLink);
		//waitForElementToDisplay(OR.manageInv_firstItemDesc, 10);
	}
	

	public static void NavigateManageInvetory()
	{	 
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//a[@href='#/inventory']"));
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		clickOn(OR.manageInvenLink);
		getTextchild("//*[@class='pagehead']");
		testLogPass("Default selected facility is "+getText(OR.Patient_getfacilityName));
	}
	public static String getDefaultFac()
    {
		clickOn(OR.User);
		clickOn(OR.User_Profile);
		String fac=getText(OR.Profile_defaultFacility);
		setProperty("userdefaultFac", fac);
		return fac;
		
    }
//	public static void checkDef_Fac()
//    {		
//	String fac=getDefaultFac();
//	String actualFac=getText(OR.manageInv_selectedFac);
//	System.out.println(actualFac);	
//	if(!fac.equals(actualFac))
//	{
//		clickOn(OR.manageInv_selectedFac);
//		int one = driver.findElements(By.xpath("//table[@class='table table-responsive table-striped table-bordered']//td[@class='ng-binding']")).size();
//		System.out.println(one);
//		String xpath;
//		String selectedFacility;
//		for(int i=1; i<=one; i++)
//		{
//			xpath="(//table[@class='table table-responsive table-striped table-bordered']/tbody/tr["+i+"]";
//			selectedFacility=driver.findElement(By.xpath(xpath+"/td)")).getText();               
//			System.out.println(selectedFacility);
//			if(selectedFacility.equals(fac))
//			{  
//				clickOn(OR.manageInv_selectedButton);
//				waitTime(4);
//				testLogInfo("Changed the facility to Default one in the DropDown");
//			}
//			else
//			{
//				testLogFail("Could not find the Default facility in the DropDown");
//			}
//		}
//	}
//	else
//	{
//		testLogInfo("Default facility of user is already selected on this page");
//	}
//	
//    }
	
	public static void checkDef_Fac(String facLocator, String pageLink, String pagepartialTitle, String fullLink)
	{		
		String fac=getDefaultFac();
		System.out.println("FAC---"+fac);
		PageLinkAndWait(pagepartialTitle, fullLink);
		//PageLinkAndWait("inventory", OR.manageInv_pageLink);
		waitTime(3);
		String actualFac=getText(facLocator);	
		System.out.println("ACTUAL----"+actualFac);	
		if(!fac.equalsIgnoreCase(actualFac))
		{
			testLogFail("Default facility for this user is not selected.");
		}
		else
		{
			testLogPass("Default facility of user is already selected on this page");
		}

	}
		
	public static void addItemInInventory()
	{
		ManageInventory.checkDef_Fac(OR.manageInv_actaulFac, OR.manageInv_pageLink, "inventory", OR.manageInv_pageLink);
		String itemDesc=getProperty("ItemDesc");
		typeIn(OR.manageInv_searchTextBox, itemDesc);
		clickOn(OR.manageInv_searchButton);
		waitForElementToDisplayWithoutFail(OR.manageInv_editItem, 10);
		clickOn(OR.manageInv_editItem);
		//clickOn(OR.ItemCatalog_VendorsTab);
		//clearEditBox(OR.ItemCatalog_gpo);
		//typeIn(OR.ItemCatalog_gpo, "3");
		clickOn(OR.manageInv_InventoryTab);
		List<WebElement> checkBoxes=driver.findElements(By.xpath("//*[contains(@id,'tbl_add_vendor')]/tbody[2]//input[@type='checkbox']"));		
		System.out.println("CHK SIZE----"+checkBoxes.size());
		for(WebElement chk:checkBoxes)
		{
			chk.click();
			waitTime(2);
			int i=ApplicationKeyword.generateRandomInt(10);
			String s=String.valueOf(i);
			chk.findElement(By.xpath("../..//input[@ng-model='inventory.qoh']")).clear();
			chk.findElement(By.xpath("../..//input[@ng-model='inventory.qoh']")).sendKeys(s);
			waitTime(2);
		}
		clickOn(OR.manageInv_SaveButton);
		waitTime(2);
	}
	
	public static void selectFacility()
	{
		waitForElement(OR.Patient_getfacilityName);
		clickOn(OR.Patient_getfacilityName);
		verifyElementText(OR.Shop_SHopfor_Shopfaclity, "Select Facility");
		verifyElement(OR.prefCard_searchTextBox);
		typeIn(OR.prefCard_searchTextBox, getProperty("UserAddfailityName"));

		if(driver.findElements(By.xpath("//button[text()='Selected']")).size()!=0)
		{
			testLogPass("Facility is in selected mode");
		}
		else
		{
			testLogFail("Facility is not found");
		}
		verifyElement(OR.ItemcaCategory_CreateCategory_btn_Close);
		verifyElement(OR.Approvalflow_MangeFlow_AddLevel_Close);
		if(driver.findElements(By.xpath("//*[text()='"+getProperty("ItemDesc")+"']")).size()!=0)
		{
			testLogPass("Item is present as per the facility");
		}
		verifyElementText(OR.Barcode_SearchItemByTxt, "Search Item By");
		verifyElement(OR.Shop_VendorSelect);
		verifyElement(OR.Users_InventoryDropDownAddUSer);
	}
	
	public static void Inventory()
	{
		int sze = driver.findElements(By.xpath("//*[@id='inventory']/option")).size();
		for(int i =1 ;i<=sze;i++)
		{
			String one = driver.findElement(By.xpath("(//*[@id='inventory']/option)["+i+"]")).getText();
			if(one.contains(getProperty("InvetoryCreate")))
			{
				testLogPass(" Inventory drop down according to Facility access to the user..");
			}
			else
			{
				continue;
			}
		}
	}
	
	public static void Status()
	{
		int sze = driver.findElements(By.xpath("//*[@id='status']/option")).size();
		for(int i =1 ;i<=sze;i++)
		{
			String one = driver.findElement(By.xpath("(//*[@id='status']/option)["+i+"]")).getText();
			if(one.contains("Active"))
			{
				testLogPass("Active is present");
			}
			else if(one.contains("InActive"))
			{
				testLogPass("InActive is present");
			}
			else if(one.contains("All"))
			{
				testLogPass("All is present");
			}
		}
	}
	
	public static void type()
	{
		int sze = driver.findElements(By.xpath("//*[@id='type']/option")).size();
		for(int i =1 ;i<=sze;i++)
		{
			String one = driver.findElement(By.xpath("(//*[@id='type']/option)["+i+"]")).getText();
			if(one.contains("Both"))
			{
				testLogPass("Both is present");
			}
			else if(one.contains("Inventory Item"))
			{
				testLogPass("Inventory Item is present");
			}
			else if(one.contains("Non-Inventory Item"))
			{
				testLogPass("Non-Inventory Item is present");
			}
		}
		Select s =  new Select(driver.findElement(By.xpath("//*[@id='type']")));
		WebElement option = s.getOptions().get(1);
		String defaultItem = option.getText();
		testLogPass("By default selected type is "+defaultItem);
	}
	public static void Search()
	{
		ManageInventoryPOpage.PageLinkAndWait("inventory", OR.manageInv_pageLink);
		String itemDesc=getProperty("ItemDesc");
		typeIn(OR.manageInv_searchTextBox, itemDesc);
		clickOn(OR.manageInv_searchButton);
		//waitForElementToDisplayWithoutFail(OR.manageInv_firstItemDesc, 20);
		waitForElementToDisplayWithoutFail("firstItemDesc#xpath=(//*[@class='item-description']/span[text()='"+itemDesc+"'])[1]", 10);
		String ItemName=getText(OR.manageInv_firstItemDesc);
		if(ItemName.equalsIgnoreCase(itemDesc))
		{
			testLogPass("Item is searched with " + ItemName);
		}
		else
		{
			testLogFail("Item is not searched with " + ItemName);			
		}
		clearEditBox(OR.manageInv_searchTextBox);
		waitForElementToDisplayWithoutFail(OR.manageInv_wait2, 20);
		String Sku=getProperty("Sku");
		typeIn(OR.manageInv_searchTextBox,Sku);
		clickOn(OR.manageInv_searchButton);
		waitForElementToDisplayWithoutFail(OR.manageInv_firstItemSku, 20);
		String getskuName=getText(OR.manageInv_firstItemSku);
		System.out.println(getskuName);
		waitForElementToDisplayWithoutFail(OR.manageInv_firstItemSku, 15);
		if(getskuName.equalsIgnoreCase(Sku))
		{
			testLogPass("Item is searched with " + Sku);
			if(driver.findElements(By.xpath("//*[text()='"+Sku+"']")).size()!=0)
			{
				driver.findElement(By.xpath("//*[text()='"+Sku+"']")).click();
				verifyElementText(OR.PriceChangeDetails_text, "Price Change Details");
				if(driver.findElements(By.xpath("//*[text()='There is no price change for this product yet.']")).size()!=0)
				{
					testLogPass("There is not price change details applicable");
				}
				else
				{
					verifyElement(OR.glCode_CloseButton);
					testLogPass("current prce is "+getTextchild("//*[text()='Current Price']"));
					int sizeoftable = driver.findElements(By.xpath("//table/thead/tr/th")).size();
					for(int i=1;i<=sizeoftable;i++)
					{
						String Header = driver.findElement(By.xpath("(//table/thead/tr/th)["+i+"]")).getText();
						String Value = driver.findElement(By.xpath("(//*[@class='table table-striped']//td)["+i+"]")).getText();
						testLogPass(Header + " - "+Value);
					}
					clickOn(OR.PrintBarcodes_PDF_PrintClose);
					waitForElement(OR.manageInv_Stockitem);
					clickOn(OR.manageInv_Stockitem);
					getText(OR.manageInv_Stockitem_Inventory);
				}
			}
		}
		else
		{
			testLogFail("Item is not searched with " + Sku);			
		}	
		clearEditBox(OR.manageInv_searchTextBox);
		waitForElementToDisplayWithoutFail(OR.manageInv_wait2, 15);
		String mfr=getProperty("ItemMfr");
		typeIn(OR.manageInv_searchTextBox,mfr);
		clickOn(OR.manageInv_searchButton);
		waitForElementToDisplayWithoutFail(OR.manageInv_firstItemDesc, 15);
		if(ItemName.equalsIgnoreCase(itemDesc))
		{
			testLogPass("Item is searched with " + mfr);
		}
		else
		{
			testLogFail("Item is not searched with " + mfr);			
		}	
		clearEditBox(OR.manageInv_searchTextBox);
		waitForElementToDisplayWithoutFail(OR.manageInv_wait2, 15);
		String alias=getProperty("alias");
		typeIn(OR.manageInv_searchTextBox,alias);
		clickOn(OR.manageInv_searchButton);
		waitForElementToDisplayWithoutFail(OR.manageInv_firstItemDesc, 15);
		if(ItemName.equalsIgnoreCase(itemDesc))
		{
			testLogPass("Item is searched with " + alias);
		}
		else
		{
			testLogFail("Item is not searched with " + alias);			
		}
		verifyElement(OR.Pattern_Delete);
		verifyElement(OR.manageInven_Print);
		verifyElement(OR.manageInven_Transfer);
		verifyElement(OR.Facilities_Edit_First);
		typeIn(OR.manageInv_searchTextBox,"oooooooooooooooooooooooooooooooooooooooo");
		clickOn(OR.manageInv_searchButton);
		if(isElementDisplayed(OR.Itemcatalog_Noitemfound))
		{
			testLogPass(" \"No item found\" appears  system does not find any matching results.");
		}
	}
	
	public static void EditInventory()
	{
		String itemDesc=getProperty("ItemDesc");
		typeIn(OR.manageInv_searchTextBox, itemDesc);
		clickOn(OR.manageInv_searchButton);
		waitForElementToDisplayWithoutFail(OR.manageInv_editItem, 10);
		clickOn(OR.manageInv_editItem);
		String GPOPrive = "240";
		clickOn(OR.ItemCatalog_VendorsTab);
		verifyElement(OR.ItemCatalog_Add_VendorsSkuName);
		verifyElement(OR.ItemCatalog_Add_VendorsMinOrderQty);
		waitForElement(OR.manageInv_EditItem_GPoContractPrice);
		typeIn(OR.manageInv_EditItem_GPoContractPrice, GPOPrive);
		ddValues();
		clickOn(OR.glCode_saveButton);
		ToastmesssageSucess();
	}
	
	public static void ddValues()
	{
		waitForElement(OR.ItemCatalog_downbutton);
		clickOn(OR.ItemCatalog_downbutton);
		int size = driver.findElements(By.xpath("//*[@class='dropdown-menu dropdown-menu-right']//a")).size();
		for(int i =1 ;i<=size;i++)
		{
			WebElement Ele = driver.findElement(By.xpath("(//*[@class='dropdown-menu dropdown-menu-right']//a)["+i+"]"));
			String values = Ele.getText();
			if(values.contains("Add Quick Code"))
			{
				testLogPass("Dropdown value is "+values);
				Ele.click();
				verifyElement(OR.ItemCatalog_additem_Vendors_QuickCode);
				clickOn(OR.ItemCatalog_downbutton);
			}else if(values.contains("Add CWID"))
			{
				testLogPass("Dropdown value is "+values);
				Ele.click();
				verifyElement(OR.ItemCatalog_additem_Vendors_CWIIDD);
				clickOn(OR.ItemCatalog_downbutton);
			}
			else if(values.contains("Manage Images"))
			{
				testLogPass("Dropdown value is "+values);
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
			}
			else if(values.trim().contains("Vendor Update"))
			{
				testLogPass("Dropdown value is "+values);
				Ele.click();
				int sise1 = driver.findElements(By.xpath("//label[text()='Price']/following-sibling::div")).size();
				for(int m=1;m<=sise1;m++)
				{
					String k = driver.findElement(By.xpath("(//label[text()='Price']/following-sibling::div)["+m+"]")).getText();
					testLogPass("Price is "+k);
				}
				verifyElement(OR.ItemCat_vendorUpdate_Userbtn);
				verifyElement(OR.InvLoc_Add_CancelBtn);
				clickOn(OR.InvLoc_Add_CancelBtn);
			}
		}
	}
	
	public static void Print()
	{
		waitForElement(OR.manageInven_Print);
		clickOn(OR.manageInven_Print);
		testLogPass("Total number is "+getText(OR.manageInven_PrintPriview));
		clickOn(OR.manageInven_PrintPriview);
		verifyElementText(OR.manageInven_PrintPriview_printsheet, "Print sheet With :");
		verifyElementText(OR.Request_PrintItems_sku, "SKU");
		verifyElementText(OR.Request_PrintItems_MFRNumber, "Mfr Number");
		verifyElementText(OR.Request_PrintItems_Quickcode, "Quick Code");
		verifyElementText(OR.manageInven_PrintPriview_CWID, "CWID");
		testLogPass("Item Name is "+getTextchild("(//*[@ng-repeat='item in items']//*[@class='ng-binding'])[1]"));
		String Print = "Sku#xpath=(//p[1])[1]";
		String Print1 = "Skuvalue#xpath=(//p[1])[2]";
		String Print2 = "Sku#xpath=(//p[2])[1]";
		String Print3 = "Skuvalue#xpath=(//p[2])[2]";
		if(driver.findElements(By.xpath("//p[1]")).size()!=0)
		{
			testLogPass(getText(Print) + "-"+ getText(Print1) +getText(Print2) +" - " +getText(Print3));
		}
		clickOn(OR.OrderDetails_PrintItems_mfr);
		if(driver.findElements(By.xpath("//p[1]")).size()!=0)
		{
			testLogPass(getText(Print) + "-"+ getText(Print1) +getText(Print2) +" - " +getText(Print3));
		}
		clickOn(OR.OrderDetails_PrintItems_qucikCode);
		if(driver.findElements(By.xpath("//p[1]")).size()!=0)
		{
			testLogPass(getText(Print) + "-"+ getText(Print1) +getText(Print2) +" - " +getText(Print3));
		}
		clickOn(OR.OrderDetails_PrintItems_cross_walk_id);
		if(driver.findElements(By.xpath("//p[1]")).size()!=0)
		{
			testLogPass(getText(Print) + "-"+ getText(Print1) +getText(Print2) +" - " +getText(Print3));
		}
		clickOn(OR.Orderdetails_Delete);
		verifyElement(OR.Template_CloseBtn);
		GeneratePDF();
		
		
		clickOn(OR.Template_CloseBtn);
	}
	
	public static void GeneratePDF()
	{
		verifyElement(OR.Approvalflow_PrintItem_GeneratePO);
		clickOn(OR.Approvalflow_PrintItem_GeneratePO);
		verifyElement(OR.Approvalflow_PrintItem_Barcode);
		verifyElement(OR.Approvalflow_PrintItem_QRCODE);
		clickOn(OR.Approvalflow_PrintItem_Barcode);
		waitForElement(OR.PrintBarcodes_PDF_Print);
		verifyElementText(OR.PrintBarcodes_PDF_Print, "Preview PDF");
		clickOn(OR.manage_PDF_close);
		clickOn(OR.Approvalflow_PrintItem_GeneratePO);
		verifyElement(OR.Approvalflow_PrintItem_Barcode);
		verifyElement(OR.Approvalflow_PrintItem_QRCODE);
		clickOn(OR.Approvalflow_PrintItem_QRCODE);
		verifyElement(OR.PrintBarcodes_PDF_Print);
		clickOn(OR.manage_PDF_close);
	}
	
	public static void Tracsfer()
	{
		verifyElement(OR.manageInven_Transfer);
		clickOn(OR.manageInven_Transfer);
		verifyElement(OR.manageInven_Transfer_Header);
		verifyElementText(OR.manageInven_Transfer_Header, "Transfer Inventory");
		verifyElementText(OR.manageInven_Transfer_InventoryLabel, "Transfer From Inventory*");
		clickOn(OR.manageInven_Transfer_Inventory);
		String inventory ="Inventory#xpath=//*[text()='"+getProperty("UserAddInvetoryName")+"']";
		clickOn(inventory);
		verifyElement(OR.Order_FacilityDropDown);
		verifyElement(OR.manageInven_Transfer_QuantityInventory);
		testLogPass("Stock info "+getText(OR.manageInven_Transfer_Stock));
		typeIn(OR.ItemCatalog_AddItem_ItemDetails_Description, "123456");
		verifyElement(OR.ItemCatalog_Mapfacility_Cancel);
		clickOn(OR.ItemCatalog_Mapfacility_Cancel);
	}
}
