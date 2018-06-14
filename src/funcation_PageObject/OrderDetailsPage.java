package funcation_PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;

public class OrderDetailsPage extends ApplicationKeyword{
    
	public static void VerifyOrder()
    {
		waitForElementToDisplay(OR.Order_Myorder_txt, 60);
    	verifyElementText(OR.Order_Myorder_txt, "MY ORDERS");
    	verifyElementText(OR.Order_Vendor_txt, "Vendor:");
    	verifyElement(OR.Order_Vendor_dropdown);
    	verifyElementText(OR.Order_status_txt, "Status:");
    	verifyElement(OR.Order_status_dropdown);
    	verifyElementText(OR.Order_type_txt, "Type:");
    	verifyElement(OR.Order_type_dropdown);
    	verifyElementText(OR.Order_facility_txt, "Facility:");
    	verifyElement(OR.Order_facility_dropdown);
    	verifyElementText(OR.Order_creater_txt, "Created By:");
    	verifyElement(OR.Order_creater_dropdown);
    }
	
	public static void viewNotesForPO()
	{
		getText(OR.Order_PO_Header);
		waitForElementToDisplay(OR.Order_PO_Notes_Icon, 60);
		clickOn(OR.Order_PO_Notes_Icon);
		getText(OR.Order_PO_Notes_HeaderTxt);
		verifyElement(OR.Order_PO_Notes_AddIcon_btn);
	}


	
	public static void LogPo()
	{
		getText(OR.Order_PO_PoLogHead);
		
	}
	
	   public static void PrintPo()
	   {
		   waitForElementToDisplayWithoutFail(OR.OrderDetails_PO_Dropdown, 10);
			clickOn(OR.OrderDetails_PO_Dropdown);
			waitForElement(OR.Order_PO_first_printPo);
			clickOn(OR.Order_PO_first_printPo);
			waitForElementToDisplayWithoutFail(OR.Order_PrintPOText, 10);		
			verifyElementText(OR.Order_PrintPOText, " Print PO");
			//clickOn(OR.OrderDetails_PrintItems_download);
			clickOn(OR.Dep_Edit_Close);
			if(driver.getCurrentUrl().contains("#/orders"))
			{
				testLogPass("Page is not redirected to login page. it is in Order page");
			}
			
	   }
	   
	   public static void PrintLog()
	   {
		   waitForElement(OR.OrderDetails_PO_Dropdown);
		   clickOn(OR.OrderDetails_PO_Dropdown);
			waitForElementToDisplayWithoutFail(OR.Order_PO_first_PoLog, 10);
			clickOn(OR.Order_PO_first_PoLog);
			waitForElementToDisplayWithoutFail(OR.Order_PO_first_PoLog, 10);
			getTextchild("(//*[@class='pagehead ng-binding'])[1]");
			if(getTextchild("(//*[@class='pagehead ng-binding'])[1]").contains("PO AUDIT LOGS FOR PO #"))
			{
				testLogPass("PO Autit Page");
			}
			verifyElementText(OR.Order_PO_headerText, "PO AUDIT LOGS FOR PO #");
			verifyPagination();
			clickOn(OR.OrderDetails_close);
	   }
	   
	 		public static void pageLinkandwait()
		{
			clickOn(OR.Order);
			waitForElementToDisplayWithoutFail(OR.Order_wait, 10);
		}

		public static void AddNotes()
		{
			   waitForElement(OR.OrderDetails_PO_Dropdown);
			   clickOn(OR.OrderDetails_PO_Dropdown);

				waitForElementToDisplayWithoutFail(OR.Receive_PODetailNotesLinkDrillDown, 10);
				clickOn(OR.Receive_PODetailNotesLinkDrillDown);
			String Notes ="test"+randomAlphaNumeric(6);
			clickOn(OR.Order_PO_Notes_AddIcon_btn);
			getText(OR.Order_PO_Notes_HeaderTxt);
			verifyElement(OR.Order_PO_Notes_Search);
			verifyElement(OR.Order_PO_Notes_AddBtn);
			verifyElement(OR.Order_PO_Notes_CloseBtn);
			getText(OR.Order_PO_Notes_Add_HeaderTxt);
			typeIn(OR.Order_PO_Notes_Input,Notes);
			clickOn(OR.Order_PO_Notes_CloseBtn);
			waitForElement(OR.Order_PO_Notes_AddIcon_btn);
			clickOn(OR.Order_PO_Notes_AddIcon_btn);
			getText(OR.Order_PO_Notes_HeaderTxt);
			verifyElement(OR.Order_PO_Notes_AddBtn);
			verifyElement(OR.Order_PO_Notes_CloseBtn);
			getText(OR.Order_PO_Notes_Add_HeaderTxt);
			typeIn(OR.Order_PO_Notes_Input,Notes);
			clickOn(OR.Order_PO_Notes_AddBtn);
			EditNotes(Notes);
			Delete();
			clickOn(OR.HeaderClose);
		}
		
		public static void EditNotes(String Search)
		{
			verifyElement(OR.Order_PO_Notes_Search);
			typeIn(OR.Order_PO_Notes_Search, Search);
			clickOn(OR.pattern_editButton);
			clickOn(OR.InvoicePaymentTerm_Edit_Update);
		}
		
		public static void Delete()
		{
			clickOn(OR.Order_PO_Notes_DeleteBtn);
			verifyElementText(OR.Order_PO_Notes_Deletevalidation,"Are you sure you want to delete this note?");
			clickOn(OR.Order_PO_Notes_Delete_yes);
			
		}
		
		   public static void PrintItem()
		   {
			   waitUntilPageReady();
			   waitForElementToDisplayWithoutFail(OR.OrderDetails_PO_Dropdown, 30);
				clickOn(OR.OrderDetails_PO_Dropdown);
				waitForElement(OR.OrderDetails_PrintItems);
				clickOn(OR.OrderDetails_PrintItems);
				waitForElementToDisplayWithoutFail(OR.Receive_printPOText, 10);		
				getText(OR.Receive_printPOText);
				//verifyElement(OR.OrderDetails_PrintItems_qrcode);
				verifyElement(OR.OrderDetails_PrintItems_qucikCode);
				verifyElement(OR.OrderDetails_PrintItems_Sku1);
				verifyElement(OR.OrderDetails_PrintItems_Barcode);
				//verifyElement(OR.OrderDetails_PrintItems_cross_walk_id);
				//verifyElement(OR.OrderDetails_PrintItems_mfr);
				
				String Itemname = driver.findElement(By.xpath("//*[@id='populate_items_pdf']/tr/td[1]")).getText();
				testLogPass("Item name of the item is "+Itemname);
				String Sku = driver.findElement(By.xpath("//*[@id='populate_items_pdf']/tr/td[2]/div/p")).getText();
				testLogPass("Price of the item is "+Sku);
				String Price = driver.findElement(By.xpath("//*[@id='populate_items_pdf']/tr/td[2]/div/p[2]")).getText();
				testLogPass("Price of the item is "+Price);
				clickOn(OR.MyCart_PrintCloseclose);
		   }
		   
		   
		   public static void viewDocumentForPO()
			{
			   waitForElement(OR.OrderDetails_PO_Dropdown);
			   clickOn(OR.OrderDetails_PO_Dropdown);
			   waitForElement(OR.Receive_PODocsDrillDown);
			   clickOn(OR.Receive_PODocsDrillDown);
			   waitForElement(OR.Order_PO_Doc_CloseBtn);
			   clickOn(OR.Order_PO_Doc_CloseBtn);
			   waitForElement(OR.OrderDetails_PO_Dropdown);
			   clickOn(OR.OrderDetails_PO_Dropdown);
			   waitForElement(OR.Receive_PODocsDrillDown);
			 clickOn(OR.Receive_PODocsDrillDown);
				getText(OR.Order_PO_Doc_HeaderTxt);
				verifyElement(OR.Order_PO_Doc_UploadFile);
				verifyElement(OR.Order_PO_Doc_CloseBtn);
				WebElement elem=driver.findElement(By.xpath("//*[@type='file']"));
				String projectPath = System.getProperty("user.dir");
				System.out.println("Project path --- " + projectPath);
				elem.sendKeys(projectPath + "/assets/1.jpeg");
				
				clickOn(OR.Procedure_DeleteButton);
				verifyElementText(OR.Order_PO_Doc_Deletevalidation, "Are you sure, You want to remove this document ?");
				clickOn(OR.Dep_Delete_Yes);
				clickOn(OR.Invoice_DocPopUPText);
				clickOn(OR.Order_CloseButton);

			}
		   
		   public static void AddInvoiceInvoice()
			{
				waitForElement(OR.OrderDetails_PO_Dropdown);
				 clickOn(OR.OrderDetails_PO_Dropdown);
			 waitForElement(OR.Order_PO_first_invoice);
			 mouseOver(OR.Order_PO_first_invoice);
			 verifyElement(OR.Order_PO_first_Addinvoice1);
			 verifyElement(OR.Order_PO_first_Allinvoice);
			 clickOn(OR.Order_PO_first_Addinvoice1);
			 waitForAngularLoad();
			 getTextchild("//*[@class='pagehead']");
			 clickOn(OR.Template_CloseBtn);
			 waitForAngularLoad();
			 waitTime(2);
			 clickOn(OR.Order_InvoiceCloseButton);
			 
			 
				 	 
			}
			
			public static void VielAllInvoiceInvoice()
			{
				waitForElement(OR.OrderDetails_PO_Dropdown);
				 clickOn(OR.OrderDetails_PO_Dropdown);
			 waitForElement(OR.Order_PO_first_invoice);
			 mouseOver(OR.Order_PO_first_invoice);

			 clickOn(OR.Order_PO_first_Allinvoice);
			 waitForAngularLoad();
			 getTextchild("//*[@class='pagehead']");
			 clickOn(OR.Order_InvoiceCloseButton);
			}
			
			
			public static void Refresh()
			{
				waitForElement(OR.OrderDetails_PO_Dropdown);
				 clickOn(OR.OrderDetails_PO_Dropdown);
				clickOn(OR.Notification_Btn_Refresh);
			}
			
			
}

