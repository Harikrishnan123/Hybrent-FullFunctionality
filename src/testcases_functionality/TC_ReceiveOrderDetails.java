package testcases_functionality;

import java.awt.Container;
import java.io.File;
import java.util.ArrayList;

import org.apache.bcel.generic.GETSTATIC;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import AutomationFramework.ApplicationKeyword;
import AutomationFramework.Generickeywords;
import AutomationFramework._OR;
import AutomationFramework.OR;
import funcation_PageObject.*;
import pageObject.Alertpage;
import pageObject.ShopPage;

public class TC_ReceiveOrderDetails extends ApplicationKeyword{

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

			extent = new ExtentReports(folderPath+"/ReceiveOrderDetails.html", true);
			extent.addSystemInfo("User Name", "QA");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}

	
	@Test
	public void Tc_ReceiveOrderDetails_001() 
	{
		testStarts("Tc_ReceiveOrderDetails_001", "Verify that PO number appears on top.");
	//	Loginpage.OpenBrowserAndLoginnew();
		Loginpage.OpenBrowserAndLogin();
		Receive.NavigateToApprovalflow();
		ReceiveOrderDetails.Search(getProperty("GeneratePoNumber"));
		waitForElement(OR.OrderDetails_PO_Dropdown);
		clickOn(OR.OrderDetails_PO_Dropdown);
		String web="Menu#xpath=//*[@class='dropdown-menu dropdown-menu-right']//a";
		waitForElement(web);
		int size = driver.findElements(By.xpath("//*[@class='dropdown-menu dropdown-menu-right']//a")).size();
		for(int i=1; i<=size; i++)
		{
			String Dropdownvalue = driver.findElement(By.xpath("(//*[@class='dropdown-menu dropdown-menu-right']//a)["+i+"]")).getText();
			if(Dropdownvalue.isEmpty())
			{
				continue;
				
			}else
			{	
			
			testLogPass("Dropdiwn value "+Dropdownvalue);
			}
		}
		ReceiveOrderDetails.verifyReceive();
		ReceiveOrderDetails.Search(getProperty("GeneratePoNumber"));
		ReceiveOrderDetails.PrintItem();
		ReceiveOrderDetails.drillAdditems();
		
	}
	
	@Test
	public void Tc_ReceiveOrderDetails_002() 
	{
		testStarts("Tc_ReceiveOrderDetails_002", "Notes>Verify that Notes popup opens on clicking on Notes link");
	//	Loginpage.OpenBrowserAndLoginnew();
		//Loginpage.OpenBrowserAndLogin();
		Receive.NavigateToApprovalflow();
		ReceiveOrderDetails.Search(getProperty("GeneratePoNumber"));
		ReceiveOrderDetails.AddNotes();
		ReceiveOrderDetails.viewDocumentForPO();
		ReceiveOrderDetails.PrintLog();
		ApprovePODetails.MarkAsReceived();
		
	}
	
	@Test
	public void Tc_ReceiveOrderDetails_003() 
	{
		testStarts("Tc_ReceiveOrderDetails_003", "Verify that \"Mark as receive only\" option appears for Non-Receive Only PO's");
	//	Loginpage.OpenBrowserAndLoginnew();
		//Loginpage.OpenBrowserAndLogin();
		Receive.NavigateToApprovalflow();
		if(driver.findElements(By.xpath("//button[@class='confirm']")).size()!=0)
		{
			waitForElement(OR.MyCart_confirmButton);
			   clickOn(OR.MyCart_confirmButton);
		}
		ReceiveOrderDetails.Search(getProperty("GeneratePoNumber"));
		ReceiveOrderDetails.refresh();
		waitForElement(OR.OrderDetails_PO_Dropdown);
		   clickOn(OR.OrderDetails_PO_Dropdown);
		Shopcart.Tour();
		testLogPass("Vendor Name: "+getText(OR.Shop_SHopfor_SelectfirstItemvendorName));
		mouseOver(OR.Shop_SHopfor_SelectfirstItemvendorName);
		getText(OR.OrderDetails_infos);
		testLogPass("Facility : "+getText(OR.OrderDetails__FacilityName));
		testLogPass("Department : "+getText(OR.OrderDetails_DeptName));
		getText(OR.OrderDetails_userinfo);
		getText(OR.OrderDetails_Approvedinfo);
		getText(OR.OrderDetails_TotalPo);
		//verifyElementText(OR.OrderDetails_SpecialInstruction, "Special Instructions:");
		testLogPass("item colr is "+getAttributeValue(OR.Template_Color, "class").replace("ng-scope ", ""));
		for(int i=2; i<=13;i++)
		{
			String value = driver.findElement(By.xpath("(//table/tbody/tr[2]/td)["+i+"]")).getText();
			String g = driver.findElement(By.xpath("(//table/thead/tr/th)["+i+"]")).getText();
			testLogPass(g+" ' = ' "+value);
		}
		
//		ArrayList<String> AdminInventory = new ArrayList<>();
//		ArrayList<String> ReiveOrderDetailsInventory = new ArrayList<>();
//		if(driver.findElements(By.xpath("//*[@id='inventory']/option")).size()!=0)
//		{
//		String Invetory ="InventoryDropdown#xpath=//*[@id='inventory1']";
//		 int Receivesize = driver.findElements(By.xpath("//*[@id='inventory']/option")).size();
//		 for(int i=1;i<=Receivesize;i++)
//		 {
//			 String Value = driver.findElement(By.xpath("(//*[@id='inventory1']/option)["+i+"]")).getText();
//			 ReiveOrderDetailsInventory.add(Value);
//		 }
//		 
//		 selectFromDropdown(Invetory, 1);
//		User.adminAndUserPage();
//		 typeIn(OR.Users_SearchTextBox, Loginpage.UserName);
//		 clickOn(OR.Users_SearchButton);
//		 clickOn(OR.Users_EditFirstUser);
//		 int AdminSize = driver.findElements(By.xpath("//*[@id='inventory']/option")).size();
//		 for(int i=1;i<=AdminSize;i++)
//		 {
//			 String Value = driver.findElement(By.xpath("(//*[@id='inventory']/option)["+i+"]")).getText();
//			 AdminInventory.add(Value);
//		 }
		// clickOn(OR.PrintBarcodes_PDF_PrintClose);
		 
//		 if(AdminInventory.equals(ReiveOrderDetailsInventory))
//		 {
//			 testLogPass("Inventory are same");
//		 }
//		 else
//		 {
//			 testLogFail("Inventory are not same");
//		 }
//		}
		
	}
	
	@Test
	public void Tc_ReceiveOrderDetails_004() 
	{
		testStarts("Tc_ReceiveOrderDetails_004", "Verify that Shipment tracking info link appear on order details page(apllied using test.cs).");
		Receive.NavigateToApprovalflow();
		ReceiveOrderDetails.Search(getProperty("GeneratePoNumber"));
		WebElement Element1 = driver.findElement(By.xpath("//*[text()='Page size:']"));
		executor.executeScript("arguments[0].scrollIntoView();", Element1);
			clickOn(OR.Shop_ItemNameDropDown_First);
			waitForElement(OR.Shop_ItemNameDropDownEdit_First);
			clickOn(OR.Shop_ItemNameDropDownEdit_First);
			verifyElementText(OR.EditItem_text,"Edit Item");
			clickOn(OR.ItemCatalog_Close);
			// Price Change History
			waitForElement(OR.Shop_ItemNameDropDown_First);
			clickOn(OR.Shop_ItemNameDropDown_First);
			WebElement Element = driver.findElement(By.xpath("(//*[@class='dropdown-menu']//*[text()='Price Change History'])[1]"));
			executor.executeScript("arguments[0].scrollIntoView();", Element);
			clickOn(OR.Shop_ItemNameDropDownPricechangeHistory_First);
			verifyElementText(OR.PriceChangeDetails_text, "Price Change Details");
			int size =driver.findElements(By.xpath("//*[@class='table table-striped']//th")).size();
			for(int i=1; i<=size;i++)
			{
				String one = driver.findElement(By.xpath("(//*[@class='table table-striped']//th)["+i+"]")).getText();
				if(one.isEmpty())
				{
					
				}
				else
				{
				testLogPass(one);
				}
			}
			clickOn(OR.ItemCatalog_Close);
			// Purchace History
			waitForElement(OR.Shop_ItemNameDropDown_First);
			clickOn(OR.Shop_ItemNameDropDown_First);
			WebElement Element2 = driver.findElement(By.xpath("(//*[@class='dropdown-menu']//*[text()='Price Change History'])[1]"));
			executor.executeScript("arguments[0].scrollIntoView();", Element2);
			clickOn(OR.Shop_ItemNameDropDownPurchaceHistory_First);
			String onedesc = driver.findElement(By.xpath("//p[@class='ng-binding']")).getText();
			testLogPass("Item name is "+onedesc);
			int size1 =driver.findElements(By.xpath("//*[@class='table table-hover customtable']//th")).size();
			for(int i=1; i<=size1;i++)
			{
				String one1 = driver.findElement(By.xpath("(//*[@class='table table-hover customtable']//th)["+i+"]")).getText();
				if(one1.isEmpty())
				{
					
				}
				else
				{
				testLogPass(one1);
				}
			}
			
			getTextchild("//*[@class='modal-title']");
			clickOn(OR.ItemCatalog_Close);
			mouseOver(OR.PrintBarcodes_firstItem);
			getText(OR.OrderDetails_itemToolTipDetails);
			String EditText = getAttributeValue(OR.ReceiveOrderDetails_receivedAmount, "disabled");
			
			if(EditText.isEmpty())
			{
				testLogPass("Receive Amount is not editable");
			}
			else
			{
				testLogFail("Receive Amount is  editable");
			}

	}
	
	@Test
	public void Tc_ReceiveOrderDetails_005() 
	{
		testStarts("Tc_ReceiveOrderDetails_005", "Verify that \"Partial Received by USER NAME (time elapsed)\" appears on top right side of page for partial received orders in place on PO status.");
		Receive.NavigateToApprovalflow();
		ReceiveOrderDetails.Search(getProperty("GeneratePoNumber"));
		waitForElement(OR.ReceiveOrderDetails_PartialReceive);
		clickOn(OR.ReceiveOrderDetails_PartialReceive);
		waitUntilPageReady();
		if(isElementDisplayed(OR.ReceiveOrderDetails_validation))
		{
			verifyElementText(OR.ReceiveOrderDetails_validation, "Are you sure, you want to mark this purchase order as partial received ?");
			clickOn(OR.OP_confirmButton);
			ToastmesssageSucess();
		}
	}
	
//	@Test
//	public void Tc_ReceiveOrderDetails_006() 
//	{
//		testStarts("Tc_ReceiveOrderDetails_006", "Verify that \"Partial Received by USER NAME (time elapsed)\" appears on top right side of page for partial received orders in place on PO status.");
//		Receive.NavigateToApprovalflow();
//		ReceiveOrderDetails.Search(getProperty("GeneratePoNumber"));
//		waitForElement(OR.ReceiveOrderDetails_Complete);
//		selectFromDropdown(OR.Inventory, 1);
//		clickOn(OR.ReceiveOrderDetails_Complete);
//			ToastmesssageSucess();
//	}
	
	@Test
	public void Tc_ReceiveOrderDetails_007() 
	{
		testStarts("Tc_ReceiveOrderDetails_007", "Verify that user's facility's logo appears on top left of PDF");
		//Loginpage.OpenBrowserAndLogin();
		Receive.NavigateToApprovalflow();
		ReceiveOrderDetails.Search(getProperty("GeneratePoNumber"));
		ReceiveOrderDetails.PO();
		
	}
	
	@Test
	public void Tc_ReceiveOrderDetails_008() 
	{
		testStarts("Tc_ReceiveOrderDetails_008", "Verify that heading \"Invoices for PO #\" with the PO number & its status appear on top left side of page.");
		//Loginpage.OpenBrowserAndLogin();
		Receive.NavigateToApprovalflow();
		ReceiveOrderDetails.Search(getProperty("GeneratePoNumber"));
		ReceiveOrderDetails.Invoideverify();
		ReceiveOrderDetails.AddInvoiceVerify();
		
	}
	
	@Test
	public void Tc_ReceiveOrderDetails_009() 
	{
		testStarts("Tc_ReceiveOrderDetails_009", "Add Invoice > Verify that all Payment Terms appear in alphabetic order in “Invoice Payment Terms” drop down.");
		//Loginpage.OpenBrowserAndLogin();
		Receive.NavigateToApprovalflow();
		ReceiveOrderDetails.Search(getProperty("GeneratePoNumber"));
		clickOn(OR.OrderDetails_PO_Dropdown);
		mouseOver(OR.Order_PO_first_invoice);
		waitForElement(OR.OrderDetails_AddInvoice);
		clickOn(OR.OrderDetails_AddInvoice);
		ReceiveOrderDetails.AddPaymentTerm();
		verifyElementText(OR.ReceiveOrderDetails_NOItem, "No item added in invoice.");
		selectFromDropdown(OR.Invoice_AddItemInInvoice, "All");
		verifyElement(OR.Invoice_AddItemButton);
		verifyElementText(OR.Invoice_POLabel, "Add PO item to invoice:");
		clickOn(OR.Invoice_AddItemButton);
		int Size = driver.findElements(By.xpath("//table/thead/tr/th")).size();
		for(int i =1;i<=Size; i++)
		{
			String getText = driver.findElement(By.xpath("(//table/thead/tr/th)["+i+"]")).getText();
			if(getText.contains("Line #"))
			{
				testLogPass("Line # label is presnet in the Add item page");
			}
			else if(getText.contains("Item/GL Code"))
			{
				testLogPass("Item/GL Code label is presnet in the Add item page");
			} else if(getText.contains("SKU"))
			{
				testLogPass("SKU label is presnet in the Add item page");
			}else if(getText.contains("Requested Qty/Price"))
			{
				testLogPass("Requested Qty/Price label is presnet in the Add item page");
			}else if(getText.contains("Received Qty/Price"))
			{
				testLogPass("Received Qty/Price label is presnet in the Add item page");
			}else if(getText.contains("Invoiced Qty *"))
			{
				testLogPass("Invoiced Qty * label is presnet in the Add item page");
			}else if(getText.contains("Invoiced Unit Price *"))
			{
				testLogPass("Invoiced Unit Price * label is presnet in the Add item page");
			}else if(getText.contains("Invoiced Price"))
			{
				testLogPass("Invoiced Price label is presnet in the Add item page");
			}
		}
		
		getAttributeValue(OR.Template_Color, "class");
		
		
	}
	
	
	@Test
	public void Tc_ReceiveOrderDetails_010() 
	{
		testStarts("Tc_ReceiveOrderDetails_010", "Add Invoice > Verify that user is able to add invoice without selecting items from \"Add PO Items to Invoice\" drop down.");
		//Loginpage.OpenBrowserAndLogin();
		Receive.NavigateToApprovalflow();
		ReceiveOrderDetails.Search(getProperty("GeneratePoNumber"));
		clickOn(OR.OrderDetails_PO_Dropdown);
		mouseOver(OR.Order_PO_first_invoice);
		waitForElement(OR.OrderDetails_AddInvoice);
		clickOn(OR.OrderDetails_AddInvoice);
		
		
		selectFromDropdown(OR.Invoice_AddItemInInvoice, "All");
		clickOn(OR.Invoice_AddItemButton);
		
		clickOn(OR.SI_SAveButton);
		if(isElementDisplayed(OR.ReceiveOrderDetails_InvoiceBlank))
		{
			verifyElementText(OR.ReceiveOrderDetails_InvoiceBlank, "Invoice # is blank.");
			clickOn(OR.SI_ConfirmButton);
		}
		String InvoiceNumber= "InvoiceUpdateNo"+generateRandomInt(5);
		setProperty("InvoiceUpdateNumber", InvoiceNumber);
		typeIn(OR.OrderDetails_InvoiceInput, InvoiceNumber);
		clickOn(OR.SI_SAveButton);
		if(isElementDisplayed(OR.OrderDetails_Invoice_validation))
		{	
			clickOn(OR.Dep_confirmButton);
			ToastmesssageSucess();
		}else
		if(isElementDisplayed(OR.ReceiveOrderDetails_InvoiceBlank))
		{
			verifyElementText(OR.ReceiveOrderDetails_InvoiceBlank, "Invoice # is blank.");
			clickOn(OR.SI_ConfirmButton);
		}
		if(isElementDisplayed(OR.Template_Schedule_Deletebtn))
		{
			verifyElement(OR.Template_Schedule_Deletebtn);
			clickOn(OR.Template_Schedule_Deletebtn);
			verifyElement(OR.Template__Deletevalidation);
			clickOn(OR.MyCart_confirmButton);
			ToastmesssageSucess();
		}
		String Edit ="EDIT#xpath=//a[text()='"+InvoiceNumber+"']";
		if(isElementDisplayed(Edit))
		{
			clickOn(Edit);
			waitForElement(OR.ReceiveOrderDetails_AttachHardCopy);
			clickOn(OR.ReceiveOrderDetails_AttachHardCopy);
			waitForElement(OR.ReceiveOrderDetails_AttachHardCopy_InvoiceHardCopy);
			verifyElementText(OR.ReceiveOrderDetails_AttachHardCopy_InvoiceHardCopy, "Invoice Hard Copies");
			verifyElement(OR.ItemCatalog_FileUpload);
			verifyElement(OR.ItemCatalog_Mapfacility_Cancel);
			WebElement elem=driver.findElement(By.xpath("//*[@type='file']"));
			String projectPath = System.getProperty("user.dir");
			System.out.println("Project path --- " + projectPath);
			elem.sendKeys(projectPath + "/assets/1.jpeg");
			testLogPass("Document name is "+getText(OR.Invoice_UploadDocName));
			
			String docdetails =getTextchild("(//*[@ng-repeat='item in rows']//a)/following-sibling::div");
			testLogPass("Document details is "+docdetails);
			clickOn(OR.glCode_saveButton);
			if(isElementDisplayed(OR.OrderDetails_Invoice_validation))
			{	
				clickOn(OR.Dep_confirmButton);
				ToastmesssageSucess();
			}
		}
	}
	
	@AfterTest
	public void endReport()
	{
		closeBrowser();
		extent.flush();
	}
}


