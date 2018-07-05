package funcation_PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.python.bouncycastle.crypto.tls.ClientCertificateType;
import org.testng.reporters.jq.TestPanel;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;
import pageObject.MycartPage;

public class Template extends ApplicationKeyword
{

	public static void NavigateTemplate()
	{
		waitTime(2);
		waitForElement(OR.Templateslink, 30);
		clickOn(OR.Templateslink);
	}
	
	public static void verifyPage()
	{
		verifyElementText(OR.Templates_MyTemplate, "MY TEMPLATES");
		verifyElementText(OR.Templates_SearchTemplate_Txt, "Search Template By:");
		verifyElement(OR.Template_SearchBtn);
		verifyElement(OR.Templates_AddTemplatetxt);
		verifyElement(OR.ApprovePO_facilityDropdown);
		verifyElementText(OR.Templates_Header_TemplateName,"Template Name");
		verifyElementText(OR.Templates_Header_CreatedBy, "Created By");
		verifyElementText(OR.Templates_Header_LastUpdate, "Last Updated at");
		verifyPagination();
	}
	
	public static void AddDeleteScheduleTemplate()
	{
		//Add Template
		waitForElementToDisplayWithoutFail(OR.Templates_AddBtn, 60);
		clickOn(OR.Templates_AddBtn);
		verifyElementText(OR.Templates_AddTemplatetxt, "Add Template");
		//verifyElement(OR.Templates_Cancel);
		String TemplateName="Test"+randomAlphaNumeric(5);
		setProperty("TemplateName", TemplateName);
		typeIn(OR.Templates_Name, TemplateName);
		clickOn(OR.Templates_CreateTemplate);	
		waitForElementToDisplayWithoutFail(OR.Template_VerifytempName, 10);
		String tempName_Saved=getText(OR.Template_VerifytempName);
		System.out.println(tempName_Saved);
		if(tempName_Saved.equalsIgnoreCase(TemplateName))
		{
			testLogPass("Template is added");
		}
		else
		{
			testLogFail("Template is not added");
		}
		waitForElementToDisplayWithoutFail(OR.Template_Uncheck_groupBYVendor, 5);
		clickOn(OR.Template_Uncheck_groupBYVendor);	
		//Search Item
		MycartPage.searchItem();
		String ItemDescription=getProperty("ItemDesc");
		clearEditBox(OR.MyCart_searchInCart);
		waitForElementToDisplayWithoutFail(OR.MyCart_searchInCart, 15);
		String alias=getProperty("alias");
		typeIn(OR.MyCart_searchInCart,alias);
		waitForElementToDisplayWithoutFail(OR.MyCart_searchInCart, 15);
		String ItemName=getText(OR.MyCart_firstItemName);
		if(ItemName.equalsIgnoreCase(ItemDescription))
		{
			testLogPass("Item is searched with AliasName-" + alias);
		}
		else
		{
			testLogFail("Item is not searched with AliasName-" + alias);			
		}	
		addItemInTemplate();
		AddEditDeleteScehdule();
		//			//Delete Schedule
		//			deleteSchedule();
		//			clickOn(OR.Template_SAveTemplate);
		//			waitTime(2);		
		//			clickOn(OR.Template_closeButton);
		//			waitForElementToDisplayWithoutFail(OR.Template_HeaderText, 10);
		//			verifyElementText(OR.Template_HeaderText, "My Templates");

	}

	//		//String TemplateName ="Test";
	//		typeIn(OR.Templates_SearchScan,TemplateName);
	//		clickOn(OR.Template_Add_First);
	//		getAttributeValue(OR.Template_Color, "background-color");
	//		clickOn(OR.Template_Schedule);
	//		clickOn(OR.Template_AddSchedule);
	//		//String one = getAttributeValue(OR.Template_Schedule_Every, "selected");
	//		waitForElement(OR.Template_Schedule_Savebtn, 60);
	//		clickOn(OR.Template_Schedule_Savebtn);
	//		waitTime(5);
	//		clickOn(OR.Template_Schedule_Deletebtn);
	//		verifyElementText(OR.Template__Deletevalidation, "Are you sure?");
	//		verifyElementText(OR.Template__Deletevalidation1, "Are you sure you want to delete this schedule ?");
	//		clickOn(OR.Template_Yes);
	//		System.out.println("test");
	//		waitTime(15);
	//		clickOn(OR.Template_Yes);
	//		}
	//		catch(Exception e)
	//		{
	//			if(isElementDisplayed(OR.Template_Yes))
	//			{
	//				clickOn(OR.Template_Yes);
	//			}
	//			NavigateUrl(DashBoardURL);
	//		}
	//	}
	//	
	//	public static void AddTemplate()
	//	{
	//		try
	//		{
	//		waitForElement(OR.Templates_AddBtn, 60);
	//		clickOn(OR.Templates_AddBtn);
	//		verifyElementText(OR.Templates_AddTemplatetxt, "Add Template");
	//		verifyElement(OR.Templates_Cancel);
	//		typeIn(OR.Templates_Name, CreateTemplateName);
	//		clickOn(OR.Templates_CreateTemplate);
	//		}
	//		catch(Exception e)
	//		{
	//			if(isElementDisplayed(OR.Template_Yes))
	//			{
	//				clickOn(OR.Template_Yes);
	//			}
	//			NavigateUrl(DashBoardURL);
	//		}
	//}

	public static void AddEditDeleteScehdule()
	{				
		clickOn(OR.Template_Schedule);
		waitForElementToDisplayWithoutFail(OR.Template_AddSchedule, 10);
		clickOn(OR.Template_AddSchedule);
		//String one = getAttributeValue(OR.Template_Schedule_Every, "selected");
		waitForElementToDisplayWithoutFail(OR.Template_Schedule_Savebtn, 10);
		clickOn(OR.Template_Schedule_Savebtn);		
		if(isElementDisplayed(OR.Template_Schedule_EditButton))
		{
			testLogPass("Schedule is added");
		}
		else
		{
			testLogFail("Schedule is not added");
		}		
		clickOn(OR.Template_Schedule_EditButton);
		waitForElementToDisplayWithoutFail(OR.Template_selectHourValue, 3);
		WebElement elem=driver.findElement(By.xpath("//*[@class='form-group']//*[@class='form-inline']"));
		WebElement elem2=elem.findElement(By.xpath("//*[@class='select-options']//select[1]"));
		elem2.click();
		WebElement elem3=elem2.findElement(By.xpath("//option[@label='Sunday']"));
		elem3.click();
		//selectFromDropdown(elem2, "Sunday");
		clickOn(OR.Template_Schedule_Savebtn);
		waitForElementToDisplayWithoutFail(OR.Template_Schedule_EditButton, 3);
		waitTime(4);
		String changedText=getText(OR.Template_changeHour);
		if(changedText.contains("Every week on Sunday at 12:00"))
		{
			testLogPass("Schedule is edited");
		}
		else
		{
			testLogFail("Schedule is not edited");
		}		
		deleteSchedule();

		//		WebElement elem4=driver.findElement(By.xpath("//*[@class='table ng-scope']//tbody//tr[1]"));
		//		WebElement elem5=elem4.findElement(By.xpath("/td[2]/*[@class='pull-right']/div[1]"));
		//		String className=elem5.getAttribute("class");
		//		System.out.println(elem5.getTagName());
		//		System.out.println(className);
		//		//Toggle
		//		if(className.contains("-switch-animate bootstrap-switch-on"))
		//		{
		//			testLogPass("Toggle is Active");			
		//			WebElement elem6=elem4.findElement(By.xpath("//td[2]//span[1]"));
		//			elem6.click();
		//			if(className.contains("-switch-animate bootstrap-switch-off"))
		//			{
		//				testLogPass("Toggle is Inactive");
		//			}
		//			else
		//			{
		//				testLogFail("Toggle is Active when it should be InACTIVE");
		//			}
		//
		//		}
		//		else
		//		{
		//			testLogFail("Toggle is InActive when it should be ACTIVE");
		//		}

		//clickOn(OR.Template_SAveTemplate);
		//waitTime(4);
	}

	public static void deleteSchedule()
	{
		waitForElementToDisplayWithoutFail(OR.Template_deleteSchedule, 10);
		clickOn(OR.Template_deleteSchedule);
		waitForElementToDisplayWithoutFail(OR.Template_confirmButton, 10);
		clickOn(OR.Template_confirmButton);
		waitForElementToDisplayWithoutFail(OR.Template_Noschedule, 10);
		if(!isElementDisplayed(OR.Template_deleteSchedule))
		{
			testLogPass("Schedule is deleted");
		}
		else
		{
			testLogPass("Schedule is not deleted");
		}
		
	}



	public static void searchTemplate()
	{
		String tempName=getProperty("TemplateName");
		typeIn(OR.Template_Search_Input, tempName);
		clickOn(OR.Template_SearchBtn);
	}

	public static void addItemInTemplate()
	{
		String ItemDescription=getProperty("ItemDesc");
		typeIn(OR.MyCart_searchInCart, ItemDescription );
		waitForElementToDisplayWithoutFail(OR.MyCart_firstItemName, 15);
		String ItemName=getText(OR.MyCart_firstItemName);
		System.out.println(ItemName);
		waitForElementToDisplayWithoutFail(OR.MyCart_firstItemName, 15);
		clickOn(OR.Template_addItemInCart);
		waitForElementToDisplayWithoutFail(OR.Template_SAveTemplate, 10);
		clickOn(OR.Template_SAveTemplate);
	}
	
	public static void AddTemplate()
	{
		waitForElementToDisplayWithoutFail(OR.Templates_AddBtn, 60);
		clickOn(OR.Templates_AddBtn);
		verifyElementText(OR.Templates_AddTemplatetxt, "Add Template");
		verifyElement(OR.Template_closeButton);
		verifyElementText(OR.Templates_Name_txt, "Name");
		verifyElement(OR.Templates_Cancel);
		verifyElement(OR.Templates_CreateTemplate);
		
		String TemplateName="Test"+randomAlphaNumeric(5);
		setProperty("TemplateName", TemplateName);
		typeIn(OR.Templates_Name, TemplateName);
		clickOn(OR.Templates_CreateTemplate);	
		ToastmesssageSucess();
		waitForElementToDisplayWithoutFail(OR.Template_VerifytempName, 10);
		String tempName_Saved=getText(OR.Template_VerifytempName);
		System.out.println(tempName_Saved);
		if(tempName_Saved.equalsIgnoreCase(TemplateName))
		{
			testLogPass("Template is added");
		}
		else
		{
			testLogFail("Template is not added");
		}
		verifyElement(OR.Barcode_ItemNameTxt);
		verifyElement(OR.Barcode_SKUTxt);
	}
	
	public static void EditTemplate()
	{
		waitForElement(OR.Template_Edit);
		clickOn(OR.Template_Edit);
		waitForElementToDisplayWithoutFail(OR.Template_Schedule_Savebtn, 10);
		verifyElement(OR.Barcode_SKUTxt);
		verifyElement(OR.Barcode_UOMTxt);
		verifyElement(OR.Barcode_PriceTxt);
		verifyElement(OR.Template_Qty);
		SearchItem();
		testLogPass("color is belong to "+getAttributeValue(OR.Template_Color, "uib-tooltip"));
		String AddItem = driver.findElement(By.xpath("//*[@class='item-qty-editable-label ng-binding']")).getText();
		clickOn(OR.Template_Plus);
		String AfterIncrease = driver.findElement(By.xpath("//*[@class='item-qty-editable-label ng-binding']")).getText();
		if(AddItem.contains(AfterIncrease))
		{
			testLogError("Item count is increased. It should not increase");
		}
		else
		{
			testLogPass("Item count is increased");
		}
		clickOn(OR.InvLoc_Add_MinusBtn);
		String AfterDecrease = driver.findElement(By.xpath("//*[@class='item-qty-editable-label ng-binding']")).getText();
		if(AddItem.contains(AfterDecrease))
		{
			testLogPass("Item count is Decreased.");
		}
		clickOn(OR.Template_Schedule_Savebtn);
		ToastmesssageSucess();
		verifyElement(OR.Templates_VendorGroup);
		clickOn(OR.Template_QTYBOX);
		verifyElement(OR.Shop_Qty_Close);
		verifyElement(OR.Shop_Qty_Close);
		typeIn(OR.Shop_SHopfor_Search_Addtocart_InputQty, "0");
		clickOn(OR.Templates_EditSubmit);
		if(driver.findElements(By.xpath("(//hyb-highlight/span)[1]")).size()!=0)
		{
			testLogFail("Item is not removed");
		}
		else
		{
			testLogPass("Item is removed removed");
		}
		typeIn(OR.MyCart_searchInCart,getProperty("ItemtestID"));
		waitTime(2);
		if(driver.findElements(By.xpath("//*[@id='suggestions']//strong[@class='ng-binding']")).size()!=0)
		{
			verifyElement(OR.MyCart_addItemInCart);
			clickOn(OR.MyCart_addItemInCart);
		}
		verifyElement(OR.OrderDetails_SpecialInstruction);
	}
	
	public static void SearchItem()
	{
		typeIn(OR.MyCart_searchInCart,"Tes");
		waitTime(2);
		if(driver.findElements(By.xpath("//*[@id='suggestions']//strong[@class='ng-binding']")).size()!=0)
		{
			testLogPass("Item Name is searched");
		}
		typeIn(OR.MyCart_searchInCart,"dsdsdsddssdsdsdsdsdsdsd");
		waitTime(2);
		if(isElementDisplayed(OR.MyCart_cartFor_NoElementFound))
		{
			testLogPass(getText(OR.MyCart_cartFor_NoElementFound));
		}
		typeIn(OR.MyCart_searchInCart,getProperty("ItemtestID"));
		waitTime(2);
		if(driver.findElements(By.xpath("//*[@id='suggestions']//strong[@class='ng-binding']")).size()!=0)
		{
			verifyElement(OR.MyCart_addItemInCart);
			clickOn(OR.MyCart_addItemInCart);
			String AddItem = driver.findElement(By.xpath("//*[@ng-show='$ctrl.editQty']/big")).getText();
			clickOn(OR.MyCart_InputQty_InputQtyIncrease);
			String AfterIncrease = driver.findElement(By.xpath("//*[@ng-show='$ctrl.editQty']/big")).getText();
			if(AddItem.contains(AfterIncrease))
			{
				testLogError("Item count is increased. It should not increase");
			}
			else
			{
				testLogPass("Item count is increased");
			}
			clickOn(OR.MyCart_InputQty_InputQtyDecrease);
			String AfterDecrease = driver.findElement(By.xpath("//*[@ng-show='$ctrl.editQty']/big")).getText();
			if(AddItem.contains(AfterDecrease))
			{
				testLogPass("Item count is Decreased.");
			}
			clickOn(OR.MyCart_InputQty_InputQtyIncrease);
		}
		typeIn(OR.MyCart_searchInCart,"");
		waitTime(2);
		if(driver.findElements(By.xpath("//*[@id='suggestions']")).size()!=0)
		{
			testLogFail("search field is not cleared");
		}else
		{
			testLogPass("search field is cleared");
		}		
		if(driver.findElements(By.xpath("//hyb-highlight/span")).size()==0)
		{
			testLogPass("item is added by user appear on page.");
		}		
		verifyElement(OR.Templates_VendorGroup);
		verifyElement(OR.Templates_VendorGroupCheckbox);
		verifyElement(OR.Templates_Receiveonly);
		verifyElement(OR.Templates_isConsignment);
		verifyElement(OR.ApprovalFlow_Refreshbtn);
	}
	
	public static void Refresh()
	{
		clickOn(OR.ApprovalFlow_Refreshbtn);
		waitTime(2);
		if(driver.findElements(By.xpath("//button[@class='confirm']")).size()!=0)
		{
			waitForElement(OR.Templates_refreshValidation);
			verifyElement(OR.manageInv_cancelPopUP);
			clickOn(OR.MyCart_confirmButton);
			ToastmesssageSucess();
		}
	}
	
	public static void SearchTemplate()
	{
		String Itemame;
		waitForElement(OR.Template_Search_Input);
		typeIn(OR.Template_Search_Input, getProperty("TemplateName"));
		clickOn(OR.Template_SearchBtn);
		 Itemame ="ItemName#xpath=//*[text()='"+getProperty("TemplateName")+"']";
		if(driver.findElements(By.xpath("//*[text()='"+getProperty("TemplateName")+"']")).size()!=0)
		{
			waitForElement(OR.Template_Edit);
			clickOn(OR.Template_Edit);
			
		}
		else
		{
			AddTemplate();
			NavigateTemplate();
			waitForElement(OR.Template_Search_Input);
			typeIn(OR.Template_Search_Input, getProperty("TemplateName"));
			clickOn(OR.Templates_CreateTemplate);
			clickOn(OR.Template_SearchBtn);
			Itemame ="ItemName#xpath=//*[text()='"+getProperty("TemplateName")+"']";
			if(driver.findElements(By.xpath("//*[text()='"+getProperty("TemplateName")+"']")).size()!=0)
			{
				waitForElement(OR.Template_Edit);
				clickOn(OR.Template_Edit);
				
			}
		}
		verifyElement(OR.Template_MinQty);
	}
	
	
	public static void Schedule() 
	{
		verifyElementText(OR.Template_Schedule, "Schedule");
		clickOn(OR.Template_Schedule);
		verifyElementText(OR.Template_Schedule_No, "No schedule for the template");
	}
	
	public static void AddSchedule()
	{
		clickOn(OR.Template_Schedule);
		waitForElementToDisplayWithoutFail(OR.Template_AddSchedule, 10);
		clickOn(OR.Template_AddSchedule);
		verifyElementText(OR.Template_Schedule_Header, "Schedule Template");
		verifyElement(OR.Receive_departmentDropdown);
		
		int sixe = driver.findElements(By.xpath("//*[@ng-model='myFrequency.base']/option")).size();
		for(int i=1;i<=sixe;i++)
		{
			String one = driver.findElement(By.xpath("(//*[@ng-model='myFrequency.base']/option)["+i+"]")).getText();
			testLogPass("Every dropdown value "+one);
		}
		
		int sixe1 = driver.findElements(By.xpath("//*[@ng-model='myFrequency.dayValue']/option")).size();
		for(int i=1;i<=sixe1;i++)
		{
			String one = driver.findElement(By.xpath("(//*[@ng-model='myFrequency.dayValue']/option)["+i+"]")).getText();
			testLogPass("on  dropdown value "+one);
		}
		verifyElement(OR.Template_Schedule_Hour);
		verifyElement(OR.Template_Schedule_minuteValue);
		
		//String one = getAttributeValue(OR.Template_Schedule_Every, "selected");
		waitForElementToDisplayWithoutFail(OR.Template_Schedule_Savebtn, 10);
		verifyElement(OR.InvoicePaymentTerm_AddPayment_CancelButtton);
		clickOn(OR.Template_Schedule_Savebtn);		
		if(isElementDisplayed(OR.Template_Schedule_EditButton))
		{
			testLogPass("Schedule is added");
		}
		else
		{
			testLogFail("Schedule is not added");
		}
		testLogPass("Schedule details "+getText(OR.Template_Schedule_ScheduleDetails));
	}
	
	public static void EditSchedule()
	{
		clickOn(OR.Template_Schedule_EditButton);
		waitForElementToDisplayWithoutFail(OR.Template_selectHourValue, 3);
		WebElement elem=driver.findElement(By.xpath("//*[@class='form-group']//*[@class='form-inline']"));
		WebElement elem2=elem.findElement(By.xpath("//*[@class='select-options']//select[1]"));
		elem2.click();
		WebElement elem3=elem2.findElement(By.xpath("//option[@label='Sunday']"));
		elem3.click();
		//selectFromDropdown(elem2, "Sunday");
		clickOn(OR.Template_Schedule_Savebtn);
		waitForElementToDisplayWithoutFail(OR.Template_Schedule_EditButton, 3);
		waitTime(4);
		String changedText=getText(OR.Template_changeHour);
		if(changedText.contains("Every week on Sunday at 12:00"))
		{
			testLogPass("Schedule is edited");
		}
		else
		{
			testLogFail("Schedule is not edited");
		}		
		testLogPass("Schedule details "+getText(OR.Template_Schedule_ScheduleDetails));
	}

	public static void VendorGroup()
	{
		String one = getAttributeValue(OR.Template_Uncheck_groupBYVendor, "class");
		if(one.contains("ng-not-empty"))
		{
			testLogPass("Vendor Group is checked ");
			clickOn(OR.Template_Uncheck_groupBYVendor);
			verifyElement(OR.Template_POSettings);
			clickOn(OR.Template_POSettings);
			waitForElement(OR.Template_HeaderPOSettings);
			verifyElementText(OR.Template_HeaderPOSettings, "Template PO Settings");
			getText(OR.Template_AlertWindow);
			if(driver.findElements(By.xpath("//*[@ng-repeat='vendor in Ctrl.templateItems']")).size()!=0)
			{
				verifyElement(OR.MyCart_Receiveonly);
				verifyElement(OR.MyCart_Consignment);
				verifyElement(OR.OrderDetails_SpecialInstruction);
			}
			clickOn(OR.Vendor_Customersupport_Custom_Close);
		}
		else
		{
			testLogPass("Vendor Group is not checked checked ");
			verifyElement(OR.Template_POSettings);
			clickOn(OR.Template_POSettings);
			waitForElement(OR.Template_HeaderPOSettings);
			verifyElementText(OR.Template_HeaderPOSettings, "Template PO Settings");
			getText(OR.Template_AlertWindow);
			if(driver.findElements(By.xpath("//*[@ng-repeat='vendor in Ctrl.templateItems']")).size()!=0)
			{
				verifyElement(OR.MyCart_Receiveonly);
				verifyElement(OR.MyCart_Consignment);
				verifyElement(OR.OrderDetails_SpecialInstruction);
			}
			clickOn(OR.Vendor_Customersupport_Custom_Close);
		}
	}
	
	public static void Reorder()
	{
		verifyElement(OR.preferenceCard_Reorder);
		clickOn(OR.preferenceCard_Reorder);
		waitTime(3);
		if(driver.findElements(By.xpath("//*[contains(text(),'Re-order Template Items')]")).size()!=0)
		{
			verifyElementText(OR.Template_ReorderHeader1, "Re-order Template Items");
		}else if(driver.findElements(By.xpath("//*[contains(text(),'Template Items Re-order')]")).size()!=0)
		{
			verifyElementText(OR.Template_ReorderHeader, "Template Items Re-order");
		}
			
		verifyElement(OR.Vendor_Customersupport_Custom_Close);
		clickOn(OR.Vendor_Customersupport_Custom_Close);
	}
	
	public static void Use()
	{
		waitForElement(OR.Template_UseTemplate);
		verifyElement(OR.Template_UseTemplate);
		getText(OR.Template_CutoffTime);
		getText(OR.Template_payment_term);
		clickOn(OR.Template_UseTemplate);
		testLogPass(getText(OR.Order_depts_txt));
		verifyElementText(OR.Template_Use_AddItem_Label, "ADD ITEM:");
		verifyElement(OR.Templates_SearchScan);
		typeIn(OR.Template_Search_Input, getProperty("ItemDesc"));
		waitTime(3);
		if(driver.findElements(By.xpath("(//*[@class='pull-right']//button[@id='btnAdd'])[1]")).size()!=0)
		{
			clickOn(OR.Template_addItemInCart);
			if(driver.findElements(By.xpath("//*[contains(text(),'Save')]")).size()!=0)
			{
				clickOn(OR.MyCart_Save);
			}
		}
	}
	
	public static void AttachDepart()
	{
		verifyElement(OR.Template_AttachDepartment);
		clickOn(OR.Template_AttachDepartment);
		verifyElementText(OR.VendorAccSetup_Departments, "Departments");
		verifyElement(OR.Shop_SHopfor_SearchBox);
		
		if(driver.findElements(By.xpath("/*[text()='No data available']")).size()!=0)
		{
			verifyElementText(OR.ItemCat_NoDataAvailable, "No data available");
		}
		clickOn(OR.Request_x);
	}
	
	public static void SearchTemplate1()
	{
		waitForElement(OR.Template_Search_Input);
		typeIn(OR.Template_Search_Input, getProperty("TemplateName"));
		clickOn(OR.Template_SearchBtn);
	}
	
	public static void PriceHistory()
	{
		waitForElement(OR.Shop_ItemNameDropDown_First);
		clickOn(OR.Shop_ItemNameDropDown_First);
		 
		 int size = driver.findElements(By.xpath("//*[@class='dropdown-menu' and contains(@style,'display: block;')]//a")).size();
		 for(int i =1;i<=size;i++)
		 {
			 WebElement o = driver.findElement(By.xpath("(//*[@class='dropdown-menu' and contains(@style,'display: block;')]//a)["+i+"]"));
			 testLogPass(o.getText());
		 } clickOn(OR.Shop_ItemNameDropDown_First);
		 
	}
	
	public static void ddEdit()
	{
		waitForElement(OR.Shop_ItemNameDropDown_First);
		clickOn(OR.Shop_ItemNameDropDown_First);
		waitForElement(OR.Template_dd_Edit);
		clickOn(OR.Template_dd_Edit);
		verifyElementText(OR.EditItem_text, "Edit Item");
		clickOn(OR.HeaderClose);
	}
	
	public static void ddPriceChangeHistory()
	{
		waitForElement(OR.Shop_ItemNameDropDown_First);
		clickOn(OR.Shop_ItemNameDropDown_First);
		waitForElement(OR.Template_dd_PriceChangeDetails);
		clickOn(OR.Template_dd_PriceChangeDetails);
		verifyElementText(OR.PriceChangeDetails_text, "Price Change Details");
		 int size = driver.findElements(By.xpath("//table/thead/tr/th")).size();
		 for(int i =1;i<=size;i++)
		 {
			 String o = driver.findElement(By.xpath("(//table/thead/tr/th)["+i+"]")).getText();
			 if(o.isEmpty())
			 {
				 
			 }else
			 {
			 testLogPass("Header is "+o);
			 }
		 }
		clickOn(OR.Order_PO_Notes_CloseBtn);
	}
	
	public static void ddPurchaseHistory()
	{
		clickOn(OR.Shop_ItemNameDropDown_First);
		waitForElement(OR.Template_dd_PurchaseHistoryt);
		clickOn(OR.Template_dd_PurchaseHistoryt);
		verifyElementText(OR.purchaseHistory_itemPurchace_text, "Item Purchase History");
		getTextchild("(//*[@class='ng-binding'])[1]");
		 int size = driver.findElements(By.xpath("//table/thead/tr/th")).size();
		 for(int i =1;i<=size;i++)
		 {
			 String o = driver.findElement(By.xpath("(//table/thead/tr/th)["+i+"]")).getText();
			 if(o.isEmpty())
			 {
				 
			 }else
			 {
			 testLogPass("Header is "+o);
			 }
		 }
		 
		clickOn(OR.Order_PO_Notes_CloseBtn);
		
	}
	
	public static void Basic()
	{
		verifyElement(OR.MyCart_Consignment);
		verifyElement(OR.Templates_isConsignment);
		testLogPass("QTY of elemet is"+ getText(OR.Template_QTYBOX));
		String Before =  getText(OR.Template_QTYBOX);
		clickOn(OR.InvLoc_Add_PlusBtn);
		String After =  getText(OR.Template_QTYBOX);
		testLogPass("Before Increasing "+Before +" After "+After);
		clickOn(OR.Template_QTYBOX);
		verifyElement(OR.Templates_EditSubmit);
		verifyElement(OR.Shop_Qty_Close);
		clickOn(OR.Shop_Qty_Close);
		String Before1 =  getText(OR.Template_QTYBOX);
		if(Before1.contains(Before))
		{
			testLogPass("changes are not applied");
		}
		verifyElement(OR.MyCart_SpecialInstruction);
		clickOn(OR.MyCart_SpecialInstruction);
		
	}
	
	
	}

