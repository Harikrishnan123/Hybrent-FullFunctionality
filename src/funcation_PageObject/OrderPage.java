package funcation_PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;

public class OrderPage extends ApplicationKeyword{

	public static void VerifyOrder()
	{
		waitForElementToDisplay(OR.Order_Myorder_txt, 10);
		verifyElementText(OR.Order_Vendor_txt, "Vendor:");
		verifyElement(OR.Order_Vendor_dropdown);
		verifyElementText(OR.Order_status_txt, "Status:");
		verifyElement(OR.Order_status_dropdown);
		verifyElementText(OR.Order_type_txt, "Type:");
		verifyElement(OR.Order_type_dropdown);
		verifyElementText(OR.Order_facility_txt, "Facility:");
		verifyElement(OR.Order_facility_dropdown);
		verifyElementText(OR.Order_depts_txt, "Departments:");
		verifyElement(OR.Order_depts_dropdown);
		verifyElementText(OR.Order_creater_txt, "Created By:");
		verifyElement(OR.Order_creater_dropdown);
	}
	
	public static void StatusDropdown()
	{
		clickOn(OR.Order_status_dropdown);
		int size = driver.findElements(By.xpath("(//*[starts-with(@id,'ui-select-choices-row-')]//*[@class='ng-binding ng-scope'])")).size();
		for(int i=1 ;i<=size;i++)
		{
			String getStatusvalue = driver.findElement(By.xpath("(//*[starts-with(@id,'ui-select-choices-row-')]//*[@class='ng-binding ng-scope'])["+i+"]")).getText();
			testLogPass("Dropdown value for status is "+getStatusvalue);
		}
	}
	
	public static void Header()
	{
		int size = driver.findElements(By.xpath("//*[@class='table']//th")).size();
		for(int i=1 ;i<=size;i++)
		{
			String getStatusvalue = driver.findElement(By.xpath("(//*[@class='table']//th)["+i+"]")).getText();
			testLogPass("Header text is "+getStatusvalue);
		}
	}
	
	public static void TypeDropdown()
	{
		clickOn(OR.Order_type_dropdown);
		int size = driver.findElements(By.xpath("(//*[starts-with(@id,'ui-select-choices-row-')]//*[@class='ng-binding ng-scope'])")).size();
		for(int i=1 ;i<=size;i++)
		{
			String getStatusvalue = driver.findElement(By.xpath("(//*[starts-with(@id,'ui-select-choices-row-')]//*[@class='ng-binding ng-scope'])["+i+"]")).getText();
			testLogPass("Dropdown value for status is "+getStatusvalue);
		}
	}
	public static void viewNotesForPO()
	{
		 waitForElement(OR.Order_PO_first_dropdown);
		   clickOn(OR.Order_PO_first_dropdown);
			waitForElementToDisplayWithoutFail(OR.Receive_PODetailNotesLinkDrillDown, 10);
			clickOn(OR.Receive_PODetailNotesLinkDrillDown);
			waitForElementToDisplayWithoutFail(OR.Order_PO_first_PoLog, 10);
		getText(OR.Order_PO_Header);
		AddNotes();
	}

	public static void pageLinkandwait()
	{
		clickOn(OR.Order);
		waitForElementToDisplayWithoutFail(OR.Order_wait, 10);
	}

	public static void AddNotes()
	{
		String Notes ="test"+randomAlphaNumeric(6);
		clickOn(OR.Order_PO_Notes_AddIcon_btn);
		getText(OR.Order_PO_Notes_HeaderTxt);
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
	
	public static void DeletePo()
	{
		waitForElement(OR.Order_PO_first_dropdown);
		   clickOn(OR.Order_PO_first_dropdown);
					waitForElementToDisplayWithoutFail(OR.OrderDetails_DeletePO, 10);
					clickOn(OR.OrderDetails_DeletePO);
					waitForElement(OR.MyCart_confirmButton);
					verifyElementText(OR.OrderDetails_DeletePOValidation, "Delete PO");
					clickOn(OR.manageInv_cancelPopUP);
//					waitForElement(OR.Order_PO_first_dropdown);
//					   clickOn(OR.Order_PO_first_dropdown);
//								waitForElementToDisplayWithoutFail(OR.OrderDetails_DeletePO, 10);
//								clickOn(OR.OrderDetails_DeletePO);
//								waitForElement(OR.MyCart_confirmButton);
//					clickOn(OR.MyCart_confirmButton);
//					ToastmesssageSucess();
	}
	
	public static void Delete()
	{
		clickOn(OR.Order_PO_Notes_DeleteBtn);
		verifyElementText(OR.Order_PO_Notes_Deletevalidation,"Are you sure you want to delete this note?");
		clickOn(OR.Order_PO_Notes_Delete_yes);
		
	}

	public static void viewDocumentForPO()
	{	
		if(isElementDisplayedwithoutFail(OR.Order_firstPONUm, 5))
		{
			String s=getText(OR.Order_firstPONUm);
			waitForElement(OR.Order_PO_first_dropdown);
			 clickOn(OR.Order_PO_first_dropdown);
		 waitForElement(OR.Receive_PODocsDrillDown);
		 clickOn(OR.Receive_PODocsDrillDown);
		 waitForElement(OR.Order_PO_Doc_CloseBtn);
		 clickOn(OR.Order_PO_Doc_CloseBtn);
		 waitForElement(OR.Order_PO_first_dropdown);
		 clickOn(OR.Order_PO_first_dropdown);
	 waitForElement(OR.Receive_PODocsDrillDown);
	 clickOn(OR.Receive_PODocsDrillDown);
		getText(OR.Order_PO_Doc_HeaderTxt);
		verifyElement(OR.Order_PO_Doc_UploadFile);
		verifyElement(OR.Order_PO_Doc_CloseBtn);
		verifyElementText(OR.Receive_DocsLinkText, "PO # " +s+ " Documents");		
		WebElement elem=driver.findElement(By.xpath("//*[@type='file']"));
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path --- " + projectPath);
		elem.sendKeys(projectPath + "/assets/1.jpeg");
		String nameOfFile_Expected="1.jpeg";
		waitForElementToDisplayWithoutFail(OR.Invoice_UploadDocName, 10);
		String s2=getText(OR.Invoice_UploadDocName).trim();		
		clickOn(OR.Order_CloseButton);
		typeIn(OR.Order_Search_Input, nameOfFile_Expected);
		clickOn(OR.Order_PO_SearchBtn);
		waitForElementToDisplayWithoutFail(OR.Order_dropDownIcon, 10);
		if(getText(OR.Order_firstPONUm).equalsIgnoreCase(s))
		{
			testLogPass("Item is searched with Documents added");
			clickOn(OR.Order_DocsLink);
			waitForElementToDisplayWithoutFail(OR.Order_PO_Doc_UploadFile, 10);
			if(s2.trim().equalsIgnoreCase(nameOfFile_Expected))
			{
				testLogPass("File is uploaded with the same name as expected");
				clickOn(OR.Template_Delete);
				waitForElementToDisplayWithoutFail(OR.Receive_confirmButton, 10);
				clickOn(OR.Receive_confirmButton);
				waitTime(2);
			}
			else
			{			
				testLogFail("File is uploaded with the same name as expected");			
			}
		}
		else
		{
			testLogFail("Item is not searched with Documents added");	
		}
		clickOn(OR.Order_CloseButton);
		}
		

	}

	public static void LogPo()
	{
		getText(OR.Order_PO_PoLogHead);

	}
	public static String getFirstPONum()
	{
		String firstPoNum=getText(OR.Order_firstPONUm);		
		typeIn(OR.Order_Search_Input, firstPoNum);
		waitForElementToDisplayWithoutFail(OR.Order_dropDownIcon, 10);	
		return firstPoNum;		
	}
	
	public static void AddInvoiceInvoice()
	{
		waitForElement(OR.Order_PO_first_dropdown);
		 clickOn(OR.Order_PO_first_dropdown);
	 waitForElement(OR.Order_PO_first_invoice);
	 mouseOver(OR.Order_PO_first_invoice);
	 verifyElement(OR.Order_PO_first_Addinvoice);
	 verifyElement(OR.Order_PO_first_Allinvoice);
	 clickOn(OR.Order_PO_first_Addinvoice);
	 waitForAngularLoad();
	 getTextchild("//*[@class='pagehead']");
	 clickOn(OR.Template_CloseBtn);
	 waitForAngularLoad();
	 waitTime(2);
	 clickOn(OR.Order_InvoiceCloseButton);
	}
	
	public static void VielAllInvoiceInvoice()
	{
		waitForElement(OR.Order_PO_first_dropdown);
		 clickOn(OR.Order_PO_first_dropdown);
	 waitForElement(OR.Order_PO_first_invoice);
	 mouseOver(OR.Order_PO_first_invoice);

	 clickOn(OR.Order_PO_first_Allinvoice);
	 waitForAngularLoad();
	 getTextchild("//*[@class='pagehead']");
	 clickOn(OR.Order_InvoiceCloseButton);
	}
	
	public static void shopFacility_OrderPage()
	{		
		String alreadySelectedFac01=getProperty("userdefaultFac");
		System.out.println(alreadySelectedFac01);
		String alreadySelectedFac=getText(OR.Order_selectDefaultUser);
		System.out.println(alreadySelectedFac);
//		boolean flag=false;
//		boolean flaf_02=false;
		if(!alreadySelectedFac.equals(alreadySelectedFac01))
		{
			clickOn(OR.ApprovePO_facilityDropdown);
			WebElement elem=driver.findElement(By.xpath("//*[text()='"+alreadySelectedFac01+"']"));
			elem.click();
			//flag=true;
		}	
		waitForElementToDisplayWithoutFail(OR.Order_selectCreater, 10);
		String alreadySelectedUser=getText(OR.Order_selectCreater);
		System.out.println(alreadySelectedUser);
		if(!alreadySelectedUser.equals("All"))
		{
			clickOn(OR.Order_UsersDropdown);
			WebElement elem2=driver.findElement(By.xpath("//*[text()='All']"));
			elem2.click();
			//flaf_02=true;
		}
//		if(flag||flaf_02)
//		{
			clickOn(OR.Order_SearrchBtn);
//		}
	} 

	   public static void SearchItem(String Search)
	    {
	    	typeIn(OR.Order_Search_Input, Search);
	    	clickOn(OR.Order_searchButton);
	    }
	   
	   public static void PrintPo()
	   {
			waitForElement(OR.OrderDetails_PO_Dropdown);
			   clickOn(OR.OrderDetails_PO_Dropdown);
				waitForElement(OR.Order_PrintPOLink);
			clickOn(OR.Order_PO_first_printPo);
			waitForElementToDisplayWithoutFail(OR.Order_PrintPOText, 10);		
			verifyElementText(OR.Order_PrintPOText, " Print PO");
			clickOn(OR.OrderDetails_PrintItems_download);
			if(driver.getCurrentUrl().contains("#/orders"))
			{
				testLogPass("Page is not redirected to login page. it is in Order page");
			}
			clickOn(OR.Order_PrintPReviewclose);
			waitForElement(OR.OrderDetails_PO_Dropdown);
	   }
	   
	   public static void PrintItem()
	   {
		   waitForElementToDisplayWithoutFail(OR.Order_dropDownIcon, 10);
			clickOn(OR.Order_dropDownIcon);
			clickOn(OR.OrderDetails_PrintItems);
			waitForElementToDisplayWithoutFail(OR.Receive_printPOText, 10);		
			getText(OR.Receive_printPOText);
			verifyElement(OR.OrderDetails_PrintItems_qrcode);
			verifyElement(OR.OrderDetails_PrintItems_qucikCode);
			verifyElement(OR.OrderDetails_PrintItems_Sku);
			verifyElement(OR.OrderDetails_PrintItems_barcode);
			verifyElement(OR.OrderDetails_PrintItems_cross_walk_id);
			verifyElement(OR.OrderDetails_PrintItems_mfr);
			clickOn(OR.MyCart_PrintCloseclose);
	   }
	   
	   public static void PrintLog()
	   {
		   waitForElement(OR.Order_PO_first_dropdown);
		   clickOn(OR.Order_PO_first_dropdown);
			waitForElementToDisplayWithoutFail(OR.Order_PO_first_PoLog, 10);
			clickOn(OR.Order_PO_first_PoLog);
			waitForElementToDisplayWithoutFail(OR.Order_PO_first_PoLog, 10);
			getTextchild("//*[@class='pagehead ng-binding']");
			if(getTextchild("//*[@class='pagehead ng-binding']").contains("PO AUDIT LOGS FOR PO #"))
			{
				testLogPass("PO Autit Page");
			}
			verifyElementText(OR.Order_PO_headerText, "PO AUDIT LOGS FOR PO #");
			verifyPagination();
			clickOn(OR.PrintBarcodes_PDF_PrintClose);
	   }
	   
	   public static void Notes()
	   {
		   waitForElement(OR.Order_PO_first_dropdown);
		   clickOn(OR.Order_PO_first_dropdown);
			waitForElementToDisplayWithoutFail(OR.Receive_PODetailNotesLinkDrillDown, 10);
			clickOn(OR.Receive_PODetailNotesLinkDrillDown);
			waitForElementToDisplayWithoutFail(OR.Order_PO_first_PoLog, 10);
			getTextchild("//*[@class='pagehead ng-binding']");
			verifyPagination();
			clickOn(OR.PrintBarcodes_PDF_PrintClose);
	   }
	   
}

