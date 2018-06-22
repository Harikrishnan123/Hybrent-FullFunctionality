package funcation_PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;

public class Receive extends ApplicationKeyword
{
	public static void NavigateToApprovalflow()
	{
		waitForElement(OR.Receive_pageLink);
		clickOn(OR.Receive_pageLink);
		getTextchild("//*[@class='pagehead ng-binding']");
		
//		testLogPass("user name of the created by user is "+getText(OR.Receive_selectedUserInDropDown));
//		if(getProperty("created_NeUser").contains(getText(OR.Receive_selectedUserInDropDown)))
//		{
//			testLogPass("user in the dropdown are same");
//		}
	}
	
	public static void Verify()
	{
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
	}
	
	public static void Search(String Input)
	{
		waitForElement(OR.Receive_SearchTextBox);
		typeIn(OR.Receive_SearchTextBox, Input);
		clickOn(OR.OP_searchButton);
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
		   waitUntilPageReady();
		   waitForElement(OR.Order_PO_first_dropdown);
		   clickOn(OR.Order_PO_first_dropdown);
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
			   waitForElement(OR.Order_PO_first_dropdown);
			   clickOn(OR.Order_PO_first_dropdown);

				waitForElementToDisplayWithoutFail(OR.Receive_PODetailNotesLinkDrillDown, 10);
				clickOn(OR.Receive_PODetailNotesLinkDrillDown);
				getText(OR.Planner_popUpText);
			String Notes ="test"+randomAlphaNumeric(6);
			clickOn(OR.Order_PO_Notes_AddIcon_btn);
			getText(OR.Order_PO_Notes_HeaderTxt);
			verifyElement(OR.Order_PO_Notes_Search);
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
	   public static void viewDocumentForPO()
				{
				   waitForElement(OR.Order_PO_first_dropdown);
				   clickOn(OR.Order_PO_first_dropdown);
				   waitForElement(OR.Receive_PODocsDrillDown);
				   clickOn(OR.Receive_PODocsDrillDown);
				   testLogPass(driver.findElement(By.className("headtext")).getText());
				   
				   waitForElement(OR.Order_PO_Doc_CloseBtn);
				   clickOn(OR.Order_PO_Doc_CloseBtn);
				   waitForElement(OR.Order_PO_first_dropdown);
				   clickOn(OR.Order_PO_first_dropdown);
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
	   public static void PrintItem()
	   {
		   waitUntilPageReady();
		   waitForElementToDisplayWithoutFail(OR.Order_PO_first_dropdown, 30);
			clickOn(OR.Order_PO_first_dropdown);
			waitForElement(OR.OrderDetails_PrintItems);
			clickOn(OR.OrderDetails_PrintItems);
			waitForElementToDisplayWithoutFail(OR.Receive_printPOText, 10);		
			getText(OR.Receive_printPOText);
			//verifyElement(OR.OrderDetails_PrintItems_qrcode);
			verifyElement(OR.OrderDetails_PrintItems_qucikCode);
			verifyElement(OR.OrderDetails_PrintItems_Sku);
			clickOn(OR.MyCart_PrintCloseclose);
	   }
	   
	   public static void PrintPo()
	   {
		   waitTime(3);
		   waitUntilPageReady();
		   waitForElementToDisplayWithoutFail(OR.Order_PO_first_dropdown, 30);
			clickOn(OR.Order_PO_first_dropdown);
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
		   waitForElement(OR.Order_PO_first_dropdown);
		   clickOn(OR.Order_PO_first_dropdown);
		   waitForElement(OR.OrderDetails_AdditemsToCart);
		   clickOn(OR.OrderDetails_AdditemsToCart);
		   if(driver.findElements(By.xpath("//*[text()='All the items of order already added in the cart.']")).size()!=0)
		   {
			   getText(OR.OrderDetails_AddItem_validation);
			   clickOn(OR.Confirmionok);
		   }
		  
	   }
}
