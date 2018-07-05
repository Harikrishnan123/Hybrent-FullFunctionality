package funcation_PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;

public class ApproveItem extends ApplicationKeyword{

	public static void scanned_out_items()
	{	 
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//*[@href='#/bill-only-items']"));
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		clickOn(OR.ApproveItem);
	}
	
	public static void verifyPage()
	{
		verifyElement(OR.Scanout_SearchSku);
		verifyElement(OR.Barcode_SearchItemByTxt);
	}

	public static void navigateApprvedItem()
	{
		scanned_out_items();
		getTextchild("//*[@class='pagehead']");
	}
	
	public static void Verifydetails()
    {
		waitForElementToDisplay(OR.OrderDetails_Change_Facility_Department, 60);
		testLogPass(getTextchild("//*[@class='pagehead ng-binding']"));
		verifyElement(OR.OrderDetails_Change_Facility_Department);
		verifyElement(OR.Approvalflow_Reject);
		verifyElement(OR.Approvalflow_Approve);
		
    }
	
	public static void ChangeFacilityDepart()
	{
		waitForElement(OR.OrderDetails_Change_Facility_Department);
		clickOn(OR.OrderDetails_Change_Facility_Department);
		verifyElementText(OR.OrderDetails_Alert, "Changing the ship to location would put the PO again in approval flow of new facility.");
		
		Select Facility =  new Select(driver.findElement(By.xpath("//*[@id='facility']")));
		WebElement option = Facility.getOptions().get(0);
		String DefaultFacility = option.getText();
		testLogPass("Facility selected is "+DefaultFacility);
		if(DefaultFacility.contains(getProperty("UserAddfailityName")))
		{
			testLogPass("Access for the facilty in the dropdown is same");
		}
		
		Select Department =  new Select(driver.findElement(By.xpath("//*[@id='department']")));
		Department.selectByIndex(1);
		WebElement option1 = Department.getOptions().get(0);
		String Departmenttext = option1.getText();
		testLogPass("Department selected is "+Departmenttext);
		if(Departmenttext.contains(getProperty("UserAddDeptName")))
		{
			testLogPass("Access for the Departments in the dropdown is same");
		}
		clickOn(OR.Pattern_Add_Close);
		waitForElement(OR.OrderDetails_Change_Facility_Department);
		clickOn(OR.OrderDetails_Change_Facility_Department);
		waitForElement(OR.InvoicePaymentTerm_Edit_Update);
		clickOn(OR.InvoicePaymentTerm_Edit_Update);
		ToastmesssageSucess();
	}

	   
	   public static void PONumberSelection()
	   {
		   waitUntilPageReady();
		   String PONumberselect ="PONumberSelect#xpath=//*[text()='"+getProperty("ApprovePONumber")+"']";
		   if(driver.findElements(By.xpath("//*[text()='"+getProperty("ApprovePONumber")+"']")).size()!=0)
			{
				clickOn(PONumberselect);
			}
		   else
		   {
			   testLogPass("PO Number is not present ");
		   }
	   }
	   
	   public static void AddItem()
		{
			clickOn(OR.MyCart);
			waitForElement(OR.MyCart_searchInCart);
			typeIn(OR.MyCart_searchInCart, getProperty("ItemMfr"));
			waitForElement(OR.MyCart_addItemInCart);
			if(isElementDisplayed(OR.MyCart_addItemInCart))
			{
				clickOn(OR.MyCart_addItemInCart);
				
				if(driver.findElements(By.xpath("//button[text()='Continue']")).size()!=0)
				{
					clickOn(OR.MyCart_warningPopup);
				}
				
				String one = getText(OR.Shop_SHopfor_SelectfirstItemvendorName);
				setProperty("VendorNameShop", one);
				waitForElement(OR.MyCart_drillDownVendor);
				clickOn(OR.MyCart_drillDownVendor);
				waitForElement(OR.MyCart_accountSetUp);
				clickOn(OR.MyCart_accountSetUp);
				waitUntilPageReady();
				int size = driver.findElements(By.xpath("(//*[text()='Account Number*']/following-sibling::div/input )")).size();
				for(int i=1;i<=size;i++)
				{
					WebElement AccType = driver.findElement(By.xpath("(//*[text()='Account Number*']/following-sibling::div/input )["+i+"]"));
					String textInsideInputBox = AccType.getAttribute("value");
					if(textInsideInputBox.isEmpty())
					{
					AccType.clear();
					AccType.sendKeys("12");
					}
				}
				mouseOver(OR.VendorAccSetup_Save);
				WebElement element = driver.findElement(By.xpath("//button[text()='Save']"));
				executor.executeScript("arguments[0].click();", element);	
				ToastmesssageSucess();
				WebElement element1 = driver.findElement(By.xpath("//button[text()='Close']"));
				executor.executeScript("arguments[0].click();", element1);
			}
			clickOn(OR.MyCart_usePo);
			String PONumber = "PON-"+randomAlphaNumeric(6);
			setProperty("ApprovePODetailsNumber", PONumber);
			typeIn(OR.MyCart_usePo_value, getProperty("ApprovePODetailsNumber"));
			clickOn(OR.MyCart_GeneratePo);
			ToastmesssageSucess();
		}
		
	   public static void PODetailsNumberSelection()
	   {
		   waitUntilPageReady();
		   String PONumberselect ="PONumberSelect#xpath=//*[text()='"+getProperty("ApprovePODetailsNumber")+"']";
		   if(isElementDisplayed(PONumberselect))
			{
				clickOn(PONumberselect);
			}
		   else
		   {
			   testLogFail("PO Number is not present ");
		   }
	   }
	   
	   public static void UnappoveTOApprove()
	   {
		   clickOn(OR.Approvalflow_Approve);
		   waitUntilPageReady();
		   waitTime(3);
		   clickOn(OR.Orders_Link);
		   waitForElement(OR.Order_Search_Input);
		   typeIn(OR.Order_Search_Input, getProperty("ApprovePODetailsNumber"));
			clickOn(OR.Order_PO_SearchBtn);
			waitUntilPageReady();
			
			String getStatus = driver.findElement(By.xpath("//tbody/tr[1]/td[3]/div")).getText();
			if(getStatus.contains("Assigned"))
			{
				testLogPass("status changed to "+getStatus);
			}
			else
			{
				testLogFail("status changed to "+getStatus);
			}	
	   }
	   
	   public static void drillAdditems()
	   {
		   waitForElement(OR.OrderDetails_PO_Dropdown);
		   clickOn(OR.OrderDetails_PO_Dropdown);
		   waitForElement(OR.OrderDetails_AdditemsToCart);
		   clickOn(OR.OrderDetails_AdditemsToCart);
		   if(driver.findElements(By.xpath("//*[text()='All the items of order already added in the cart.']")).size()!=0)
		   {
			   getText(OR.OrderDetails_AddItem_validation);
			   clickOn(OR.Confirmionok);
		   }
		  
	   }
	   public static void IconAddNotes()
		{

			String Notes ="test"+randomAlphaNumeric(6);
			clickOn(OR.Template_Add_First);
			getText(OR.Order_PO_Notes_HeaderTxt);
			verifyElement(OR.Order_PO_Notes_Search);
			verifyElement(OR.Order_PO_Notes_AddIcon_btn);
			clickOn(OR.Order_PO_Notes_AddIcon_btn);
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
			waitForElement(OR.Order_PO_Notes_DeleteBtn);
			clickOn(OR.Order_PO_Notes_DeleteBtn);
			verifyElementText(OR.Order_PO_Notes_Deletevalidation,"Are you sure you want to delete this note?");
			clickOn(OR.Order_PO_Notes_Delete_yes);
			
		}
		
		 public static void iconviewDocumentForPO()
			{
			 waitForElement(OR.Order_PO_DocIcon);
			   clickOn(OR.Order_PO_DocIcon);
			   waitForElement(OR.Order_PO_Doc_CloseBtn);
			   clickOn(OR.Order_PO_Doc_CloseBtn);
			   waitForElement(OR.Order_PO_DocIcon);
			   clickOn(OR.Order_PO_DocIcon);
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
		 
		 public static void MarkAsReceived()
		 {
			 	waitForElement(OR.OrderDetails_PO_Dropdown);
			   clickOn(OR.OrderDetails_PO_Dropdown);
			   waitTime(3);
			   //verifyElementText(OR.OrderDetails_ToltipMarkAsReceivedd, "");
			   if(driver.findElements(By.xpath("//a[text()='Mark as Receive Only']")).size()!=0)
			   {
				   waitForElement(OR.ApprovePO_markAsReceive);
				   mouseOver(OR.ApprovePO_markAsReceive);
				   getText(OR.OrderDetails_tootlipvaliadtion);
				   clickOn(OR.ApprovePO_markAsReceive);
				   if(isElementDisplayed(OR.OrderDetails_valiadtion))
				   {
					   verifyElementText(OR.OrderDetails_valiadtion, "Will change this order to Receive Only order. Do you want to perform this action ?");
				   }
			   }
			   else if(driver.findElements(By.xpath("//*[text()='Mark as Non Receive Only']")).size()!=0)
			   {
				   clickOn(OR.ApprovePO_markAsReceiveNon);
				   if(isElementDisplayed(OR.OrderDetails_valiadtionnon))
				   {
					   verifyElementText(OR.OrderDetails_valiadtionnon, "Will change this order to non Receive Only order. Do you want to perform this action ?");
				   }
				   
			   }
			   waitForElement(OR.Template_Cancel);
			   clickOn(OR.Template_Cancel);
			   waitForElement(OR.OrderDetails_PO_Dropdown);
			   clickOn(OR.OrderDetails_PO_Dropdown);
			 waitTime(2);
			   if(driver.findElements(By.xpath("//a[text()='Mark as Receive Only']")).size()!=0)
			   {
				   clickOn(OR.ApprovePO_markAsReceive);
				   if(isElementDisplayed(OR.OrderDetails_valiadtion))
				   {
					   verifyElementText(OR.OrderDetails_valiadtion, "Will change this order to Receive Only order. Do you want to perform this action ?");
					   clickOn(OR.MyCart_confirmButton);
					   verifyElement(OR.Order_PO_RevceiveOnly);
				   }
			   }
			   else if(driver.findElements(By.xpath("//*[text()='Mark as Non Receive Only']")).size()!=0)
			   {
				   clickOn(OR.ApprovePO_markAsReceiveNon);
				   if(isElementDisplayed(OR.OrderDetails_valiadtionnon))
				   {
					   verifyElementText(OR.OrderDetails_valiadtionnon, "Will change this order to non Receive Only order. Do you want to perform this action ?");
					   clickOn(OR.MyCart_confirmButton);
				   }
			   }
			   waitForElement(OR.OrderDetails_PO_Dropdown);
			   clickOn(OR.OrderDetails_PO_Dropdown);
			   waitTime(2);
			   if(driver.findElements(By.xpath("//a[text()='Mark as Receive Only']")).size()!=0)
			   {
				   clickOn(OR.ApprovePO_markAsReceive);
				   if(isElementDisplayed(OR.OrderDetails_valiadtion))
				   {
					   verifyElementText(OR.OrderDetails_valiadtion, "Will change this order to Receive Only order. Do you want to perform this action ?");
					   clickOn(OR.MyCart_confirmButton);
					   verifyElement(OR.Order_PO_RevceiveOnly);
				   }
			   }
			   else if(driver.findElements(By.xpath("//*[text()='Mark as Non Receive Only']")).size()!=0)
			   {
				   clickOn(OR.ApprovePO_markAsReceiveNon);
				   if(driver.findElements(By.xpath("//button[@class='confirm']")).size()!=0)
				   {
					   verifyElementText(OR.OrderDetails_valiadtionnon, "Will change this order to non Receive Only order. Do you want to perform this action ?");
					   clickOn(OR.MyCart_confirmButton);
				   }
			   }
			   
		 }
		 
		 public static void Fav()
		 {
				String Fav = getAttributeValue(OR.Shop_SHopfor_favtab, "ng-if");
				if (Fav.equals("isFavorite")) {
					testLogPass("item is isFavorite");
					String one = getProperty("ItemDesc");
					
					if(driver.findElements(By.xpath("//*[text()='"+one+"']")).size()!=0)
					{
						clickOn(OR.Shop_SHopfor_FavOrderedradiobutton);
						if(driver.findElements(By.xpath("//*[text()='"+one+"']")).size()!=0)
						{
							testLogPass("item in Favorite then it isdisplay under the Favourite Item radio button.");
						}
					}
					
					
				} else

					if (Fav.equals("!isFavorite")) {
						testLogPass("item is !isFavorite");
					}
				clickOn(OR.Shop_SHopfor_favtab);
				String Fav1 = getAttributeValue(OR.Shop_SHopfor_favtab, "ng-if");
				if (Fav1.equals("!isFavorite")) {
					testLogPass("item is !isFavorite");
				} else if (Fav1.equals("isFavorite")) {
					testLogPass("item is isFavorite");

					String one = getProperty("ItemDesc");
					
					if(driver.findElements(By.xpath("//*[text()='"+one+"']")).size()!=0)
					{
						clickOn(OR.Shop_SHopfor_FavOrderedradiobutton);
						if(driver.findElements(By.xpath("//*[text()='"+one+"']")).size()!=0)
						{
							testLogPass("item in Favorite then it isdisplay under the Favourite Item radio button.");
						}
					}
					
				}
				
				 WebElement Fav11 = driver.findElement(By.xpath("//*[text()='"+getProperty("ItemDesc")+"']"));
				    Actions toolAct = new Actions(driver);
				    toolAct.moveToElement(Fav11).build().perform();
				    String one = driver.findElement(By.xpath("//*[@class='tooltip ng-scope ng-isolate-scope right fade in']")).getText();
				    if(one.contains("Favourite"))
				    {
						testLogPass("Toolip for is presnet");
				    }
				
		 }
		   
}
