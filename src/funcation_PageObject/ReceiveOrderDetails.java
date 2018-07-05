package funcation_PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.reporters.jq.TestPanel;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;

public class ReceiveOrderDetails extends ApplicationKeyword
{
	public static void NavigateToApprovalflow()
	{
		waitForElement(OR.Receive_pageLink);
		clickOn(OR.Receive_pageLink);
		getTextchild("//*[@class='pagehead ng-binding']");
		verifyElementText(OR.Order_Vendor_txt,"Vendor:");
		verifyElementText(OR.Order_status_txt,"Status:");
		verifyElement(OR.ApprovePO_Menu_PO);
		verifyElement(OR.ApprovePO_Menu_VendorName);
		verifyElement(OR.ApprovePO_Menu_Status);
		verifyElement(OR.ApprovePO_Menu_RequestedCost);
		verifyElement(OR.ApprovePO_Menu_ReceivedCost);
		verifyElement(OR.ApprovePO_Menu_CreatedAt);
		verifyElement(OR.ApprovePO_Menu_Buyer);
		clickOn(OR.Receive_statusDropdown);
		waitUntilPageReady();
		int size = driver.findElements(By.xpath("//*[@class='ui-select-choices-row-inner']/span")).size();
		for(int i=1;i<=size;i++)
		{
			testLogPass("Drop Down values are "+driver.findElement(By.xpath("(//*[@class='ui-select-choices-row-inner']/span)["+i+"]")).getText());
		}
		clickOn(OR.Receive_facilityDropdown);
		waitTime(1);
		int size1 = driver.findElements(By.xpath("//*[@class='ui-select-choices-row-inner']/span")).size();
		for(int i=1;i<=size1;i++)
		{
			testLogPass("Drop Down values are "+driver.findElement(By.xpath("(//*[@class='ui-select-choices-row-inner']/span)["+i+"]")).getText());
		}
//		testLogPass("user name of the created by user is "+getText(OR.Receive_selectedUserInDropDown));
//		if(getProperty("created_NeUser").contains(getText(OR.Receive_selectedUserInDropDown)))
//		{
//			testLogPass("user in the dropdown are same");
//		}
	}
	
	public static void Search(String Input)
	{
		waitForElement(OR.Receive_SearchTextBox);
		typeIn(OR.Receive_SearchTextBox, Input);
		clickOn(OR.OP_searchButton);
		
		String InputSelect ="InputElment#xpath=(//a[text()='"+Input+"'])[1]";
		waitForElement(InputSelect);
		if(driver.findElements(By.xpath("(//a[text()='"+Input+"'])[1]")).size()!=0)
		{
			driver.findElement(By.xpath("(//a[text()='"+Input+"'])[1]")).click();;
			String head =getTextchild("//*[@class='pagehead ng-binding']");
			if(head.contains(Input));
			{
				testLogPass("PO number appears on top '" +Input);
			}
		}
		else
		{
			testLogFail("The item  not find "+Input);
		}
		
	}
	
	public static void Facilityverify()
	{
		String Fac = getText(OR.Patient_facDropDown);
		String Dept = getText(OR.Receive_departmentDropdown);
		if(getProperty("UserAddfailityName").contains(Fac)) {
			testLogPass("Facility are same ");
		}
		if(getProperty("UserAddDeptName").contains(Dept)) {
			testLogPass("Dept are same ");
		}
	}
	
	   public static void PrintLog()
	   {
		   waitForElement(OR.OrderDetails_PO_Dropdown);
		   clickOn(OR.OrderDetails_PO_Dropdown);
			waitForElementToDisplayWithoutFail(OR.Order_PO_first_PoLog, 10);
			clickOn(OR.Order_PO_first_PoLog);
			getTextchild("(//*[@class='pagehead ng-binding'])[1]");
			if(getTextchild("(//*[@class='pagehead ng-binding'])[1]").contains("PO AUDIT LOGS FOR PO #"))
			{
				testLogPass("PO Autit Page");
			}
			verifyElementText(OR.Order_PO_headerText, "PO AUDIT LOGS FOR PO #");
			verifyPagination();
			clickOn(OR.OrderDetails_close);
	   }
	   public static void AddNotes()
		{
		   waitForElement(OR.OrderDetails_PO_Dropdown);
		   clickOn(OR.OrderDetails_PO_Dropdown);
		   waitForElementToDisplayWithoutFail(OR.Receive_PODetailNotesLinkDrillDown, 10);
			clickOn(OR.Receive_PODetailNotesLinkDrillDown);
			getText(OR.Planner_popUpText);
			String Notes ="test"+randomAlphaNumeric(6);
			clickOn(OR.Order_PO_Notes_AddIcon_btn);
			getText(OR.Order_PO_Notes_HeaderTxt);
			verifyElement(OR.Order_PO_Notes_Search1);
			verifyElement(OR.Order_PO_Notes_AddIcon_btn);
			verifyElement(OR.Order_PO_Notes_CloseBtn);
			getText(OR.Order_PO_Notes_Add_HeaderTxt);
			typeIn(OR.Order_PO_Notes_Input,Notes);
			clickOn(OR.Order_PO_Notes_CloseBtn);
			waitForElement(OR.Order_PO_Notes_AddIcon_btn);
			clickOn(OR.Order_PO_Notes_AddIcon_btn);
			getText(OR.Order_PO_Notes_HeaderTxt);
			verifyElement(OR.Order_PO_Notes_AddIcon_btn);
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
			verifyElement(OR.Order_PO_Notes_Search1);
			typeIn(OR.Order_PO_Notes_Search1, Search);
			clickOn(OR.pattern_editButton);
			clickOn(OR.InvoicePaymentTerm_Edit_Update);
		}
		
		public static void Delete()
		{
			clickOn(OR.Order_PO_Notes_DeleteBtn);
			verifyElementText(OR.Order_PO_Notes_Deletevalidation,"Are you sure you want to delete this note?");
			clickOn(OR.Order_PO_Notes_Delete_yes);
			
		}
	   public static void viewDocumentForPO()
				{
				   waitForElement(OR.OrderDetails_PO_Dropdown);
				   clickOn(OR.OrderDetails_PO_Dropdown);
				   waitForElement(OR.Receive_PODocsDrillDown);
				   clickOn(OR.Receive_PODocsDrillDown);
				   testLogPass(driver.findElement(By.className("headtext")).getText());
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
					waitUntilPageReady();
				}
	   public static void PrintItem()
	   {
		   waitUntilPageReady();
		   waitForElementToDisplayWithoutFail(OR.OrderDetails_PO_Dropdown, 30);
			clickOn(OR.OrderDetails_PO_Dropdown);
			waitForElement(OR.OrderDetails_PrintItems);
			clickOn(OR.OrderDetails_PrintItems);
			verifyElementText(OR.OrderDetails_OrderItems, "Order Items");
			waitForElementToDisplayWithoutFail(OR.Receive_printPOText, 10);		
			getText(OR.Receive_printPOText);
			//verifyElement(OR.OrderDetails_PrintItems_qrcode);
			verifyElement(OR.OrderDetails_PrintItems_qucikCode);
			verifyElement(OR.OrderDetails_PrintItems_Sku1);
			clickOn(OR.Approvalflow_PrintItem_GeneratePO);
			verifyElementText(OR.Approvalflow_PrintItem_Barcode, "Barcode");
			verifyElementText(OR.Approvalflow_PrintItem_QRCODE, "QR code");
			if(isElementDisplayed(OR.Orderdetails_Delete1))
			{
				clickOn(OR.Orderdetails_Delete1);
			}
			clickOn(OR.MyCart_PrintCloseclose);
	   }
	   
	   public static void PrintPo()
	   {
		   waitTime(3);
		   waitUntilPageReady();
		   waitForElementToDisplayWithoutFail(OR.OrderDetails_PO_Dropdown, 30);
			clickOn(OR.OrderDetails_PO_Dropdown);
			 waitForElementToDisplayWithoutFail(OR.Order_PO_first_printPo, 30);
			clickOn(OR.Order_PO_first_printPo);
			getText(OR.Order_PO_printPo_PDF);
			waitUntilPageReady();
			clickOn(OR.OrderDetails_PrintItems_download);
			waitForElement(OR.Approvalflow_Add_croxxx);
			clickOn(OR.Approvalflow_Add_croxxx);
	   }
	   
	   public static void drillAdditems()
	   {
		   waitForElement(OR.OrderDetails_PO_Dropdown);
		   clickOn(OR.OrderDetails_PO_Dropdown);
		   waitForElement(OR.OrderDetails_AdditemsToCart);
		   clickOn(OR.OrderDetails_AdditemsToCart);
		   if(driver.findElements(By.className("toast-title")).size()!=0)
		   {
			  // ToastmesssageSucess();
		   }
		   if(driver.findElements(By.xpath("//*[text()='All the items of order already added in the cart.']")).size()!=0)
		   {
			   getText(OR.OrderDetails_AddItem_validation);
			   clickOn(OR.Confirmionok);
		   }
	   }
	   
	   public static void refresh()
	   {
		   waitForElement(OR.OrderDetails_PO_Dropdown);
		   clickOn(OR.OrderDetails_PO_Dropdown);
		   waitForElement(OR.ApprovalFlow_Refreshbtn);
		   clickOn(OR.ApprovalFlow_Refreshbtn);
	   }
	   
	   public static void verifyReceive()
	   {
		   waitForElement(OR.ReceiveOrderDetails_Close);
		   clickOn(OR.ReceiveOrderDetails_Close);
		   getTextchild("//*[@class='pagehead ng-binding']");
	   }
	   
	   public static void Invoice()
	   {
		   waitForElement(OR.OrderDetails_PO_Dropdown);
		   clickOn(OR.OrderDetails_PO_Dropdown);
		   waitForElement(OR.Order_PO_first_invoice);
		   mouseOver(OR.Order_PO_first_invoice);
		   verifyElement(OR.Order_PO_first_Addinvoice);
		   verifyElement(OR.Order_PO_first_AllInvoice);
		   clickOn(OR.Order_PO_first_Addinvoice);
	   }
	   
	   public static void PO()
	   {
		   waitForElement(OR.OrderDetails_PO_Dropdown);
		   clickOn(OR.OrderDetails_PO_Dropdown);
		   waitForElement(OR.Order_PO_first_printPo);
		   clickOn(OR.Order_PO_first_printPo);
		   int size = driver.findElements(By.xpath("//*[@id='viewer']/div/div[2]/div")).size();
		   for(int i=1;i<=size;i++)
		   {
			   testLogPass(driver.findElement(By.xpath("(//*[@id='viewer']/div/div[2]/div)["+i+"]")).getText());
		   }
		   clickOn(OR.Order_PrintPReviewclose);
		   
	   }
	   
	   public static void Invoideverify() 
	   {
		   waitForElement(OR.OrderDetails_PO_Dropdown);
		   clickOn(OR.OrderDetails_PO_Dropdown);
		   mouseOver(OR.Order_PO_first_invoice);
		   clickOn(OR.Order_PO_first_Allinvoice);
		   getTextchild("//*[@class='pagehead']");
		   String Header1 = driver.findElement(By.xpath("(//*[@class='panel-body']/div)[1]")).getText();
		   testLogPass(Header1);
		   String Header = driver.findElement(By.xpath("(//*[@class='panel-body']/div)[2]")).getText();
		   testLogPass(Header);
		   
		   int s = driver.findElements(By.xpath("(//table/thead/tr/th)")).size();
		   for(int i =1 ;i<=s;i++)
		   {
			   String HeaderValue=driver.findElement(By.xpath("(//table/thead/tr/th)["+i+"]")).getText();
			   if(HeaderValue.isEmpty())
			   {
				continue;   
			   }else
			   {
			   testLogPass(HeaderValue);
			   }
		   }
	   }
	   
	   public static void AddInvoiceVerify()
	   {
		   verifyElement(OR.OrderDetails_AddInvoice);
		   clickOn(OR.OrderDetails_AddInvoice);
		   testLogPass( getText(OR.Invoice_vendorDropDownLabels)+ getText(OR.Shop_SHopfor_SelectfirstItemvendorName));
		   mouseOver(OR.Shop_SHopfor_SelectfirstItemvendorName);
		   getText(OR.OrderDetails_infos);
		   verifyElement(OR.Invoice_POFor);
		   verifyElement(OR.Invoice_POFor_Number);
		   verifyElement(OR.OrderDetails_FacilityName);
		   verifyElement(OR.OrderDetails__FacilityName);
		   verifyElement(OR.OrderDetails__DeptName);
		   verifyElement(OR.OrderDetails_DeptName);
		   verifyElement(OR.Invoice_Date_label);
		   verifyElement(OR.Invoice_Date);
		   verifyElement(OR.OrderDetails_ShippingAddress);
		   verifyElement(OR.Request_calander);
		   verifyElement(OR.Invoice_DueDate_label);
		   verifyElement(OR.Invoice_DueDate);
		   verifyElement(OR.Invoice_POTotalcost_label);
		   verifyElement(OR.Invoice_POTotalcost);
		   verifyElement(OR.Invoice_Totalcost_label);
		   verifyElement(OR.Invoice_Totalcost);
		   verifyElement(OR.Invoice_TotalState_TaxLabel);
		   verifyElement(OR.Invoice_TotalState);
		   verifyElement(OR.Invoice_FreightAmount_TaxLabel);
		   verifyElement(OR.Invoice_Freight_Amount);
		   verifyElement(OR.Invoice_DiscountAmount_TaxLabel);
		   verifyElement(OR.Invoice_Discount_Amount);
		   verifyElement(OR.Invoice_InvoiceLabel);
		   verifyElement(OR.Invoice_InvoiceDesc);
		   verifyElement(OR.Invoice_BatchLabel);
		   verifyElement(OR.Invoice_Batch_Input);
		   
		   testLogPass( getText(OR.Invoice_POFor)+ getText(OR.Invoice_POFor_Number));
		   testLogPass( getText(OR.OrderDetails_FacilityName)+ getText(OR.OrderDetails__FacilityName));
		   testLogPass( getText(OR.OrderDetails__DeptName)+ getText(OR.OrderDetails_DeptName));
		   testLogPass( getText(OR.Invoice_Date_label)+ getText(OR.Invoice_Date));
		   testLogPass( "Shipping Address "+getText(OR.OrderDetails_ShippingAddress));
		   verifyElement(OR.Request_calander);
		   testLogPass( getText(OR.Invoice_DueDate_label)+ getText(OR.Invoice_DueDate));
		   testLogPass( getText(OR.Invoice_POTotalcost_label)+ getText(OR.Invoice_POTotalcost));
		   testLogPass( getText(OR.Invoice_Totalcost_label)+ getText(OR.Invoice_Totalcost).contains("item"));
		   testLogPass( getText(OR.Invoice_TotalState_TaxLabel)+ getText(OR.Invoice_TotalState));
		   testLogPass( getText(OR.Invoice_FreightAmount_TaxLabel)+ getText(OR.Invoice_Freight_Amount));
		   testLogPass( getText(OR.Invoice_DiscountAmount_TaxLabel)+ getText(OR.Invoice_Discount_Amount));
		   testLogPass( getText(OR.Invoice_InvoiceLabel)+ getText(OR.Invoice_InvoiceDesc));
		   testLogPass( getText(OR.Invoice_BatchLabel)+ getText(OR.Invoice_Batch_Input));
		   clickOn(OR.Request_calander_SelectDate);
		   getText(OR.Request_calander_Value);
		   clickOn(OR.Request_calander);
	   }
	   
	   
	   public static void AddPaymentTerm()
	   {
		   verifyElement(OR.Receive_PODetailAddInvoice);
		   clickOn(OR.Receive_PODetailAddInvoice);
		   verifyElementText(OR.InvoicePaymentTerm_AddPayment_Header, "Add Payment Term");
			verifyElementText(OR.InvoicePaymentTerm_AddPayment_Description_Label, "Description :");
			verifyElementText(OR.InvoicePaymentTerm_AddPayment_Type_Label, "Type :");
			verifyElementText(OR.InvoicePaymentTerm_AddPayment_Day_Label, "Day(s) :");
			verifyElementText(OR.InvoicePaymentTerm_AddPayment_Percent_Label, "Percent (%) :");
			verifyElementText(OR.InvoicePaymentTerm_AddPayment_APIntegratiot_Label, "AP Integration ID :");
			verifyElement(OR.InvoicePaymentTerm_AddPayment_CancelButtton);
			verifyElement(OR.InvoicePaymentTerm_AddPayment_addButtton);
			String Desc = "TestDEs"+randomAlphaNumeric(7);
			int size = driver.findElements(By.xpath("//*[@id='paymentTermType']/option")).size();
					for(int i=1;i<=size;i++)
					{
						String one = driver.findElement(By.xpath("(//*[@id='paymentTermType']/option)["+i+"]")).getText();
						testLogPass("Payement options are "+one);
						selectFromDropdown(OR.InvoicePaymentTerm_AddPayment_paymentTermType_Selectdropdown, one);
					}
					typeIn(OR.Pterms_addDesc, Desc);
					typeIn(OR.InvoicePaymentTerm_AddPayment_Day_Input, "2");
					typeIn(OR.InvoicePaymentTerm_AddPayment_Percent, "103");
					typeIn(OR.InvoicePaymentTerm_AddPayment_APIntegratiot, "text");
					clickOn(OR.InvoicePaymentTerm_AddPayment_CancelButtton);
					waitForElement(OR.Receive_PODetailAddInvoice, 40);
					clickOn(OR.Receive_PODetailAddInvoice);
					typeIn(OR.Pterms_addDesc, "12");
					typeIn(OR.InvoicePaymentTerm_AddPayment_Day_Input, "2");
					typeIn(OR.InvoicePaymentTerm_AddPayment_Percent, "2");
					typeIn(OR.InvoicePaymentTerm_AddPayment_APIntegratiot, "text");
					clickOn(OR.InvoicePaymentTerm_AddPayment_addButtton);
					ToastmesssageSucess();
					typeIn(OR.Pterms_addDesc,Desc);
					clickOn(OR.InvoicePaymentTerm_AddPayment_addButtton);
					ToastmesssageSucess();
	   }
}
