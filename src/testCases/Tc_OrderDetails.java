package testCases;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import pageObject.Loginpage;
import pageObject.MycartPage;
import pageObject.OrderDetailsPage;
import pageObject.OrderPage;
import pageObject.ReceivePageObject;
import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;
import AutomationFramework.Generickeywords;

public class Tc_OrderDetails extends ApplicationKeyword{

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
			extent = new ExtentReports(folderPath+"/orderdetail.html", true);
			extent.addSystemInfo("User Name", "Ravneet");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}


	@Test()
	public void Tc_OrderDetails_002() {
		testStarts("Tc_OrderDetails_002",
				"Verify that �Add Note for PO #� pop up appears when user clicks on �Add New Note�"
						+"Verify that notes gets deleted when user clicks on �Delete� button for the added note.");

		Loginpage.OpenBrowserAndLogin();
		System.out.println("Tc_OrderDetails_002");
		clickOn(OR.Order);	
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 10);
		OrderPage.shopFacility_OrderPage();
		waitForElementToDisplayWithoutFail(OR.Order_PO_ID_First, 5);
		if(isElementDisplayedwithoutFail(OR.Order_PO_ID_First, 5))
		{
		clickOn(OR.Order_PO_ID_First);
		OrderDetailsPage.viewNotesForPO();
		OrderDetailsPage.AddNotes();
		waitForElementToDisplayWithoutFail(OR.OrderNotes_searchBox, 10);
		typeIn(OR.OrderNotes_searchBox, "TestOrderDetailsNOtes");	
		waitForElementToDisplayWithoutFail(OR.Receive_searchedfirstNote, 10);
		if(getText(OR.Receive_searchedfirstNote).equals("TestOrderDetailsNOtes"))
		{
			clickOn(OR.Receive_DeleteIcon);
			waitForElementToDisplayWithoutFail(OR.Receive_confirmButton, 10);
			clickOn(OR.Receive_confirmButton);
			waitForElementToDisplayWithoutFail(OR.OrderNotes_searchBox, 10);
			typeIn(OR.OrderNotes_searchBox, "TestOrderDetailsNOtes");	
			waitForElementToDisplayWithoutFail(OR.Receive_searchedfirstNote, 10);
			if(!getText(OR.Receive_searchedfirstNote).equals("TestOrderDetailsNOtes"))
			{
				testLogPass("Note is deleted");
			}
			else
			{
				testLogFail("Note is not deleted");
			}
		}
		else
		{
			testLogFail("Note is not searched or added");
		}	
		}
		else
		{
			testLogFail("There is no order in orders page in default Facility");
		}
	}
	//		waitForElementToDisplayWithoutFail(OR.Order_PO_ID_First, 10);
	//		clickOn(OR.Order_PO_ID_First);
	//		OrderDetailsPage.viewNotesForPO();
	//		OrderDetailsPage.AddNotes();
	//		typeIn(OR.OrderNotes_searchBox, "TestOrderDetailsNOtes");	
	//		waitForElementToDisplayWithoutFail(OR.Receive_searchedfirstNote, 10);
	//		if(getText(OR.Receive_searchedfirstNote).equals("TestOrderDetailsNOtes"))
	//		{
	//			clickOn(OR.Receive_DeleteIcon);
	//			clickOn(OR.Receive_confirmButton);
	//			typeIn(OR.OrderNotes_searchBox, "TestOrderDetailsNOtes");	
	//			waitForElementToDisplayWithoutFail(OR.Receive_searchedfirstNote, 10);
	//			if(!getText(OR.Receive_searchedfirstNote).equals("TestOrderDetailsNOtes"))
	//			{
	//			
	//			testLogPass("Note is deleted");
	//				
	//			}
	//			else
	//			{
	//				testLogFail("Note is not deleted");
	//			}
	//		}
	//		else
	//		{
	//			testLogFail("Note is not searched or added");
	//		}	
	//		}	

	@Test()
	public void Tc_ApproveDetails_003() {
		testStarts("Tc_OrderDetails_003, Tc_OrderDetails_015",
				"Verify that �PO # XXXX11 Documents� pop up appears when clicks on Documents icon with count.");
		//Loginpage.OpenBrowserAndLogin();
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_OrderDetails_003");
		clickOn(OR.Order);
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 10);
		OrderPage.shopFacility_OrderPage();
		waitForElementToDisplayWithoutFail(OR.Order_PO_ID_First, 5);
		if(isElementDisplayedwithoutFail(OR.Order_PO_ID_First, 5))
		{
		clickOn(OR.Order_PO_ID_First);
		waitForElementToDisplayWithoutFail(OR.Order_PO_Doc_Icon, 10);
		clickOn(OR.Order_PO_Doc_Icon);
		OrderDetailsPage.viewDocumentForPO();
		clickOn(OR.OrderNotes_PO_NotesClose);
		}
		else
		{
		testLogFail("There is no order in Orders Module in default facility");
		}

	}

	@Test()
	public void Tc_OrderDetails_004() {
		testStarts("Tc_OrderDetails_004, Tc_OrderDetails_016",
				"Verify that select file from computer window opens when user clicks on Upload File button.");
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_OrderDetails_004");
		clickOn(OR.Order);
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 10);
		OrderPage.shopFacility_OrderPage();
		waitForElementToDisplayWithoutFail(OR.Order_PO_ID_First, 5);
		if(isElementDisplayedwithoutFail(OR.Order_PO_ID_First, 5))
		{
		clickOn(OR.Order_PO_ID_First);
		waitForElementToDisplayWithoutFail(OR.Order_PO_Doc_Icon, 10);
		clickOn(OR.Order_PO_Doc_Icon);
		WebElement elem=driver.findElement(By.xpath("//*[@type='file']"));
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path --- " + projectPath);
		elem.sendKeys(projectPath + "/assets/images.jpeg");
		String nameOfFile_Expected="images.jpeg";
		waitTime(5);
		waitForElementToDisplayWithoutFail(OR.Invoice_UploadDocName, 10);
		String s2=getText(OR.Invoice_UploadDocName).trim();		
		//		clickOn(OR.Order_CloseButton);
		//		typeIn(OR.Order_Search_Input, "images.jpeg");
		//		clickOn(OR.Order_PO_SearchBtn);
		//		waitForElementToDisplayWithoutFail(OR.Order_dropDownIcon, 10);
		//		if(getText(OR.Order_firstPONUm).equalsIgnoreCase(s))
		//		{
		//			testLogPass("Item is searched with Documents added");
		//			clickOn(OR.Order_DocsLink);
		if(s2.trim().equalsIgnoreCase(nameOfFile_Expected))
		{
			testLogPass("File is uploaded with the same name as expected");
			waitTime(2);
			WebElement wholeElem=driver.findElement(By.xpath("//*[@class='col-sm-18']"));
			WebElement trashIcon=wholeElem.findElement(By.xpath("(//a[@class='a-with-icon pull-right ng-scope']/i[@class='fa fa-trash-o'])[1]"));
			trashIcon.click();
			//clickOn(OR.Receive_NotesDeleteIcon);
			waitForElementToDisplayWithoutFail(OR.Receive_confirmButton, 10);
			//waitForElementToDisplay(OR.Receive_confirmButton, 10);
			clickOn(OR.Receive_confirmButton);
			waitTime(4);
		}
		else
		{			
			testLogFail("File is not uploaded with the same name as expected");			
		}
		}
		else
		{
		testLogFail("There is no order in Orders Module in default facility");
		}

	}

	@Test()
	public void Tc_OrderDetails_005() {
		testStarts("Tc_OrderDetails_005","Verify that items in PO gets added to cart when user clicks on �Add Items to cart� option");
		NavigateUrl(DashBoardURL);
		clickOn(OR.MyCart);
		MycartPage.checkIfCartIsEmpty();	
		clickOn(OR.Order);
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 10);
		OrderPage.shopFacility_OrderPage();
		waitForElementToDisplayWithoutFail(OR.Order_PO_ID_First, 5);
		if(isElementDisplayedwithoutFail(OR.Order_PO_ID_First, 5))
		{
		//waitForElementToDisplayWithoutFail(OR.Order_PO_ID_First, 10);
		clickOn(OR.Order_PO_ID_First);
		waitForElementToDisplayWithoutFail(OR.OrderDetails_HeaderDropdown, 10);
		clickOn(OR.OrderDetails_HeaderDropdown);
		clickOn(OR.OrderDetails_AdditemsToCart);
		
		//waitForElementToDisplayWithoutFail(OR.order_firstPOHeadingText, 10);
		List<String> allItemNames=new ArrayList<String>();		
		List<WebElement> itemNames=driver.findElements(By.xpath("//table[@class='table table-body-striped ng-scope']//item-info[@class='ng-isolate-scope']"));		
		for(int i=1; i<=itemNames.size(); i++)
		{			
			String ProductName=getAttributeValue(OR.Receive_itemNames, "name");						
			allItemNames.add(ProductName);	
			System.out.println(ProductName);
		}
		clickOn(OR.MyCart);	
		List<WebElement> itemNamesInCart=driver.findElements(By.xpath("//*[@value='name']"));
		System.out.println(itemNamesInCart.size());
		boolean prodNotFoundInCart=true; 		
		for(int i=1;i<=allItemNames.size();i++)
		{
			prodNotFoundInCart = false;
			for(int j=1;j<=itemNamesInCart.size();j++)
			{
				String ProductNameInCart=itemNamesInCart.get(i-1).getText().trim();// getText(OR.Receive_itemsNamesInCart);
				System.out.println("NAME in CART -- " + ProductNameInCart);
				System.out.println("NAME in PO -- " + allItemNames.get(i-1).trim());				
				if(allItemNames.get(i-1).trim().equalsIgnoreCase(ProductNameInCart))
				{
					prodNotFoundInCart=false;
					break;
				}
				else
					prodNotFoundInCart=true;
			}			
			if(prodNotFoundInCart)
			{
				testLogFail("Both the lists do not have same items");
				break;
			}
			else
			{
				testLogPass("Both the lists have same items");

			}
		}
		}
		else
		{
		testLogFail("There is no order in Orders Module in default facility");
		}
	}

//	@Test()
//	public void Tc_OrderDetails_006() {
//		testStarts("Tc_OrderDetails_006",
//				"Verify that 'Print PO' preview window appears when user clicks on Print Po option in action dropdown ");
//		//Loginpage.OpenBrowserAndLogin();
//		NavigateUrl(DashBoardURL);
//		System.out.println("Tc_OrderDetails_006");
//		clickOn(OR.Order);
//		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 10);
//		ReceivePageObject.shopFacility();
//		waitForElementToDisplayWithoutFail(OR.Order_PO_ID_First, 5);
//		if(isElementDisplayedwithoutFail(OR.Order_PO_ID_First, 5))
//		{
//		//waitForElementToDisplayWithoutFail(OR.Order_PO_ID_First, 10);
//		clickOn(OR.Order_PO_ID_First);
//		waitForElementToDisplayWithoutFail(OR.OrderDetails_HeaderDropdown, 10);
//		clickOn(OR.OrderDetails_HeaderDropdown);
//		waitForElementToDisplayWithoutFail(OR.Order_PO_first_PoLog, 10);
//		clickOn(OR.Order_PO_first_PoLog);
//		verifyElementText(OR.Order_PO_PoLogHead, "Purchase Order# ");
//		clickOn(OR.OrderNotes_PO_NotesClose);
//		}
//		else
//		{
//		testLogFail("There is no order in Orders Module in default facility");
//		}
//	}


	@Test()
	public void Tc_OrderDetails_0071() {
		testStarts("Tc_OrderDetails_0071","Verify that Print popup window opens on clicking Print Items button.");
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_OrderDetails_0071");
		clickOn(OR.Order);
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 10);
		OrderPage.shopFacility_OrderPage();
		//waitForElement(OR.Order_PO_ID_First);
		waitForElementToDisplayWithoutFail(OR.Order_PO_ID_First, 5);
		if(isElementDisplayedwithoutFail(OR.Order_PO_ID_First, 5))
		{
		
		clickOn(OR.Order_PO_ID_First);
		waitForElementToDisplayWithoutFail(OR.OrderDetails_HeaderDropdown, 10);
		clickOn(OR.OrderDetails_HeaderDropdown);
		clickOn(OR.OrderDetails_PrintItems);
		verifyElementText(OR.OrderDetails_OrderItems, "Order Items");
		clickOn(OR.OrderNotes_PO_NotesClose);
	}
		else
		{
		testLogFail("There is no order in Orders Module in default facility");
		}
	}

	@Test()
	public void Tc_OrderDetails_008() {
		testStarts("Tc_OrderDetails_008","Verify that user gets redirected to “INVOICE FOR PO #” page, on clicking “Add Invoice” option.");
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_OrderDetails_008");
		//clickOn(OR.Order);
		//waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 10);
		//Tc_Order.selectALL_Assigned();
		clickOn(OR.Orders_Link);	
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		OrderPage.shopFacility_OrderPage();
				clickOn(OR.Order_status_dropdown);
				waitForElementToDisplayWithoutFail(OR.Order_PO_StatusDropdown_Assigned, 5);
				clickOn(OR.Order_PO_StatusDropdown_Assigned);
				clickOn(OR.Order_PO_SearchBtn);
				waitForElementToDisplayWithoutFail(OR.NOOrderFound, 5);
				String s=getText(OR.NOOrderFound);
				if (s.trim().equalsIgnoreCase("No Order Found"))
				{
					testLogPass("Assigned State has no orders");
					clickOn(OR.Order_status_dropdown);
					clickOn(OR.Order_PO_StatusDropdown_Confirmed);
					clickOn(OR.Order_PO_SearchBtn);
					waitForElementToDisplayWithoutFail(OR.NOOrderFound, 5);
					String s1=getText(OR.NOOrderFound);
					if(s1.trim().equalsIgnoreCase("No Order Found"))
					{
						testLogPass("Confirmed State has no orders");
						clickOn(OR.Order_status_dropdown);
						clickOn(OR.Order_PO_StatusDropdown_PartialReceived);
						clickOn(OR.Order_PO_SearchBtn);
						waitForElementToDisplayWithoutFail(OR.NOOrderFound, 5);
						String s2=getText(OR.NOOrderFound);
						if(s2.trim().equalsIgnoreCase("No Order Found"))
						{
							testLogPass("PartialReceived State has no orders");
							clickOn(OR.Order_status_dropdown);
							clickOn(OR.Order_PO_StatusDropdown_Completed);
							clickOn(OR.Order_PO_SearchBtn);
							waitForElementToDisplayWithoutFail(OR.NOOrderFound, 5);
							String s3=getText(OR.NOOrderFound);
							if(s3.trim().equalsIgnoreCase("No Order Found"))
							{
								testLogPass("Completed State has no orders");
								testLogFail("There are no orders for which the Invoice could be generated");
							}
						}
				else
				{		
					allInvoices();

				}
			}
			else
			{		
				allInvoices();
			}
		}
		else
		{		
			allInvoices();
		}

	}

	//		} else 
	//			if (driver.findElements(By.xpath("(//a[text()='Invoices'])[1]")).size() == 0) 
	//			{
	//			waitTime(6);		
	//			clickOn(OR.Order_status_dropdown);
	//			clickOn(OR.Order_PO_StatusDropdown_Confirmed);
	//			clickOn(OR.Order_PO_SearchBtn);
	//			waitTime(5);
	//			clickOn(OR.Order_PO_first_dropdown);
	//			waitTime(5);
	//			clickOn(OR.OrderDetails_HeaderDropdown);
	//			clickOn(OR.Order_PO_first_AllInvoice);
	//			
	//			if (driver.findElements(By.xpath("(//a[text()='Invoices'])[1]")).size() != 0) {
	//				WebElement element = driver.findElement(By.xpath("(//a[text()='Invoices'])[1]"));
	//				Actions action = new Actions(driver);
	//				action.moveToElement(element).build().perform();
	//				clickOn(OR.Order_PO_first_AllInvoice);	
	//			  //  driver.findElement(By.linkText("Add Invoice")).click();
	//				
	//			}
	//		}
	//		getText(OR.Order_PO_first_AllInvoice_Header);
	//		extent.flush();
	//	}

	@Test()
	public void Tc_OrderDetails_009() {
		testStarts("Tc_OrderDetails_009","Verify that �INVOICES FOR PO #� page appears when user clicks on All Invoices option.");
		//Loginpage.OpenBrowserAndLogin();
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_OrderDetails_009");
		clickOn(OR.Orders_Link);	
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		OrderPage.shopFacility_OrderPage();
				clickOn(OR.Order_status_dropdown);
				waitForElementToDisplayWithoutFail(OR.Order_PO_StatusDropdown_Assigned, 5);
				clickOn(OR.Order_PO_StatusDropdown_Assigned);
				clickOn(OR.Order_PO_SearchBtn);
				waitForElementToDisplayWithoutFail(OR.NOOrderFound, 8);				
				String s=getText(OR.NOOrderFound);
				System.out.println(s);
				if (s.trim().equalsIgnoreCase("No Order Found"))
				{
					testLogPass("Assigned State has no orders");
					clickOn(OR.Order_status_dropdown);
					clickOn(OR.Order_PO_StatusDropdown_Confirmed);
					clickOn(OR.Order_PO_SearchBtn);
					waitForElementToDisplayWithoutFail(OR.NOOrderFound, 8);
					String s1=getText(OR.NOOrderFound);
					if(s1.trim().equalsIgnoreCase("No Order Found"))
					{
						testLogPass("Confirmed State has no orders");
						clickOn(OR.Order_status_dropdown);
						clickOn(OR.Order_PO_StatusDropdown_PartialReceived);
						clickOn(OR.Order_PO_SearchBtn);
						waitForElementToDisplayWithoutFail(OR.NOOrderFound, 8);
						String s2=getText(OR.NOOrderFound);
						if(s2.trim().equalsIgnoreCase("No Order Found"))
						{
							testLogPass("PartialReceived State has no orders");
							clickOn(OR.Order_status_dropdown);
							clickOn(OR.Order_PO_StatusDropdown_Completed);
							clickOn(OR.Order_PO_SearchBtn);
							waitForElementToDisplayWithoutFail(OR.NOOrderFound, 5);
							String s3=getText(OR.NOOrderFound);
							if(s3.trim().equalsIgnoreCase("No Order Found"))
							{
								testLogPass("Completed State has no orders");
								testLogFail("There are no orders for which the Invoice could be generated");
							}
						}
				else
				{		
					addInvoice();

				}
			}
			else
			{		
				addInvoice();
			}
		}
		else
		{		
			addInvoice();
		}
	}


	@Test
	public void Tc_OrderDetails_007() {
		testStarts("Tc_OrderDetails_008","Verify that Print popup window opens on clicking Print Items button.");
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_OrderDetails_007");
		clickOn(OR.Orders_Link);	
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		OrderPage.shopFacility_OrderPage();
				clickOn(OR.Order_status_dropdown);
				waitForElementToDisplayWithoutFail(OR.Order_PO_StatusDropdown_Assigned, 5);
				clickOn(OR.Order_PO_StatusDropdown_Assigned);
				clickOn(OR.Order_PO_SearchBtn);
				waitForElementToDisplayWithoutFail(OR.NOOrderFound, 5);
				String s=getText(OR.NOOrderFound);
				if (s.trim().equalsIgnoreCase("No Order Found"))
				{
					testLogPass("Assigned State has no orders");
					clickOn(OR.Order_status_dropdown);
					clickOn(OR.Order_PO_StatusDropdown_Confirmed);
					clickOn(OR.Order_PO_SearchBtn);
					waitForElementToDisplayWithoutFail(OR.NOOrderFound, 5);
					String s1=getText(OR.NOOrderFound);
					if(s1.trim().equalsIgnoreCase("No Order Found"))
					{
						testLogPass("Confirmed State has no orders");
						clickOn(OR.Order_status_dropdown);
						clickOn(OR.Order_PO_StatusDropdown_PartialReceived);
						clickOn(OR.Order_PO_SearchBtn);
						waitForElementToDisplayWithoutFail(OR.NOOrderFound, 5);
						String s2=getText(OR.NOOrderFound);
						if(s2.trim().equalsIgnoreCase("No Order Found"))
						{
							testLogPass("PartialReceived State has no orders");
							clickOn(OR.Order_status_dropdown);
							clickOn(OR.Order_PO_StatusDropdown_Completed);
							clickOn(OR.Order_PO_SearchBtn);
							waitForElementToDisplayWithoutFail(OR.NOOrderFound, 5);
							String s3=getText(OR.NOOrderFound);
							if(s3.trim().equalsIgnoreCase("No Order Found"))
							{
								testLogPass("Completed State has no orders");
								testLogFail("There are no orders for which the print pop up could be opened");
							}
						}
				else
				{		
					printItems();

				}
			}
			else
			{		
				printItems();
			}
		}
		else
		{		
			printItems();
		}



	}

	@Test()
	public void Tc_OrderDetails_010() {
		testStarts("Tc_OrderDetails_010",
				"Verify that �PO AUDIT LOGS FOR PO #� pop up window appears when user clicks on Po Log option in the dropdown.");
		//Loginpage.OpenBrowserAndLogin();
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_OrderDetails_010");
		waitForElementToDisplayWithoutFail(OR.Order, 10);
		clickOn(OR.Order);
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		OrderPage.shopFacility_OrderPage();
		waitForElementToDisplayWithoutFail(OR.Order_PO_ID_First, 5);
		if(isElementDisplayedwithoutFail(OR.Order_PO_ID_First, 5))
		{	
		waitForElement(OR.Order_PO_ID_First);
		clickOn(OR.Order_PO_ID_First);
		clickOn(OR.OrderDetails_HeaderDropdown);
		waitForElementToDisplayWithoutFail(OR.Order_PO_first_PoLog, 10);
		clickOn(OR.Order_PO_first_PoLog);
		//clickOn(OR.OrderDetails_POApprovalLog);
		waitForElementToDisplayWithoutFail(OR.Order_PO_AuditLog, 10);
		verifyElementText(OR.Order_PO_AuditLog, "PO AUDIT LOGS FOR PO #");
		clickOn(OR.OrderNotes_PO_NotesClose);
		
	}
		else
		{
		testLogFail("There is no order in Orders Module in default facility");
		}
	}

	@Test()
	public void Tc_OrderDetails_011() {
		testStarts("Tc_OrderDetails_011",
				"Verify that �PO APPROVAL LOGS FOR PO # � pop up appears when user clicks on PO Approval Log option");
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_OrderDetails_011");
		clickOn(OR.Order);
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		OrderPage.shopFacility_OrderPage();
		waitForElementToDisplayWithoutFail(OR.Order_PO_ID_First, 5);
		if(isElementDisplayedwithoutFail(OR.Order_PO_ID_First, 5))
		{	
		clickOn(OR.Order_PO_ID_First);
		waitForElementToDisplayWithoutFail(OR.OrderDetails_HeaderDropdown, 10);
		clickOn(OR.OrderDetails_HeaderDropdown);
		waitForElementToDisplayWithoutFail(OR.OrderDetails_POApprovalLog, 10);
		clickOn(OR.OrderDetails_POApprovalLog);
		getText(OR.Order_PO_PoLogHead);
		clickOn(OR.OrderNotes_PO_NotesClose);
		//extent.flush();
	}
		else
		{
		testLogFail("There is no order in Orders Module in default facility");
		}
	}

	//	@Test()
	//	public void Tc_OrderDetails_012() {
	//		testStarts("Tc_OrderDetails_012",
	//				"Verify that �PO APPROVAL LOGS FOR PO # � pop up appears when user clicks on PO Approval Log option");
	//		NavigateUrl(DashBoardURL);
	//		
	//		clickOn(OR.Order);
	//		clickOn(OR.Order_status_dropdown);
	//		clickOn(OR.Order_PO_StatusDropdown_Assigned);
	//		clickOn(OR.Order_PO_SearchBtn);
	//		waitTime(5);
	//		waitForElement(OR.Order_PO_ID_First);
	//		clickOn(OR.Order_PO_ID_First);
	//		clickOn(OR.OrderDetails_HeaderDropdown);
	//		clickOn(OR.OrderDetails_POApprovalLog);
	//		getText(OR.Order_PO_PoLogHead);
	//		clickOn(OR.OrderNotes_PO_NotesClose);
	//		extent.flush();
	//	}

	@Test()
	public void Tc_OrderDetails_018() {
		testStarts("Tc_OrderDetails_018","Verify that Delete PO option appears.\r\n");
		NavigateUrl(DashBoardURL);
		clickOn(OR.Order);
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		OrderPage.shopFacility_OrderPage();
		waitForElementToDisplayWithoutFail(OR.Order_PO_ID_First, 5);
		if(isElementDisplayedwithoutFail(OR.Order_PO_ID_First, 5))
		{	
		clickOn(OR.Order_PO_ID_First);
		waitForElementToDisplayWithoutFail(OR.OrderDetails_HeaderDropdown, 10);
		clickOn(OR.OrderDetails_HeaderDropdown);
		verifyElement(OR.OrderDetails_DeletePO);
		//extent.flush();
	}
		else
		{
		testLogFail("There is no order in Orders Module in default facility");
		}
	}

	@Test()
	public void Tc_OrderDetails_019() {
		testStarts("Tc_OrderDetails_019",
				"Verify that show tour pops appear when user clicks on show tour option in dropdown next to refresh button.");
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_OrderDetails_019");
		clickOn(OR.Order);
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		OrderPage.shopFacility_OrderPage();
		waitForElementToDisplayWithoutFail(OR.Order_PO_ID_First, 5);
		if(isElementDisplayedwithoutFail(OR.Order_PO_ID_First, 5))
		{	
		clickOn(OR.Order_PO_ID_First);
		waitForElementToDisplayWithoutFail(OR.OrderDetails_HeaderDropdown, 10);
		clickOn(OR.OrderDetails_HeaderDropdown);
		waitForElementToDisplayWithoutFail(OR.OrderDetails_ShowTour, 10);
		clickOn(OR.OrderDetails_ShowTour);
		waitTime(2);
		if(isElementPresent(By.xpath("//button[text()='End tour']")))
		{
			testLogPass("Show tour popup is opened.");
		}
		else
		{
			testLogFail("Show tour popup is NOT opened.");
		}
		}
		else
		{
		testLogFail("There is no order in Orders Module in default facility");
		}

	}


	@Test()
	public void Tc_OrderDetails_020_021() {
		testStarts("Tc_OrderDetails_020,Tc_OrderDetails_021","Verify that �Departments� pop up appears when user clicks on Attach  department hyperlink.\r\n"+"Verify that �Physicians� pop up appears when user clicks on �Attach Physician� hyperlink.");
		//Loginpage.OpenBrowserAndLogin();
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_OrderDetails_020_021");
		clickOn(OR.Order);
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		OrderPage.shopFacility_OrderPage();
		waitForElementToDisplayWithoutFail(OR.Order_PO_ID_First, 5);
		if(isElementDisplayedwithoutFail(OR.Order_PO_ID_First, 5))
		{	
		clickOn(OR.Order_PO_ID_First);	
		waitForElementToDisplayWithoutFail(OR.OrderDetails_Depatment, 10);
		System.out.println(getText(OR.OrderDetails_Depatment));
		System.out.println(getText(OR.OrderDetails_Physician));
		if(getText(OR.OrderDetails_Depatment).contains("All Departments"))
		{
			testLogPass("Department Dropdown is present on the page");			
		}
		else
		{
			testLogFail("Department Dropdown is not activated from the Organization settings");
		}

		if(getText(OR.OrderDetails_Physician).contains("All Physicians"))
		{
			testLogPass("Physicians Dropdown is present on the page");
			
		}
		else
		{
			testLogFail("Physicians Dropdown is not activated from the Organization settings");
		}
		}
		else
		{
		testLogFail("There is no order in Orders Module in default facility");
		}
	}
	@Test()
	public void Tc_OrderDetails_022() {
		testStarts("Tc_OrderDetails_022","Verify that Order detail screen gets closed when user clicks on Close option.");
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_OrderDetails_022");
		clickOn(OR.Order);
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		OrderPage.shopFacility_OrderPage();
		waitForElementToDisplayWithoutFail(OR.Order_PO_ID_First, 5);
		if(isElementDisplayedwithoutFail(OR.Order_PO_ID_First, 5))
		{		
		clickOn(OR.Order_PO_ID_First);
		waitForElementToDisplayWithoutFail(OR.OrderDetails_Close, 10);
		clickOn(OR.OrderDetails_Close);
		waitTime(4);;
		verifyElement(OR.OrderDetails_MyOrderTxt);
		extent.flush();	
	}
		else
		{
		testLogFail("There is no order in Orders Module in default facility");
		}
	}

	@AfterTest
	public void endReport()
	{
		closeBrowser();
		extent.flush();
	}

	public void notes_Add_Delete()
	{
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		OrderPage.shopFacility_OrderPage();
		waitForElementToDisplayWithoutFail(OR.Order_PO_ID_First, 5);
		if(isElementDisplayedwithoutFail(OR.Order_PO_ID_First, 5))
		{
		clickOn(OR.Order_PO_ID_First);
		OrderDetailsPage.viewNotesForPO();
		OrderDetailsPage.AddNotes();
		typeIn(OR.OrderNotes_searchBox, "TestOrderDetailsNOtes");	
		waitForElementToDisplayWithoutFail(OR.Receive_searchedfirstNote, 10);
		if(getText(OR.Receive_searchedfirstNote).equals("TestOrderDetailsNOtes"))
		{
			clickOn(OR.Receive_DeleteIcon);
			clickOn(OR.Receive_confirmButton);
			typeIn(OR.OrderNotes_searchBox, "TestOrderDetailsNOtes");	
			waitForElementToDisplayWithoutFail(OR.Receive_searchedfirstNote, 10);
			if(!getText(OR.Receive_searchedfirstNote).equals("TestOrderDetailsNOtes"))
			{

				testLogPass("Note is deleted");

			}
			else
			{
				testLogFail("Note is not deleted");
			}
		}
		else
		{
			testLogFail("Note is not searched or added");
		}	
		}
		else
		{
		testLogFail("There is no order in Orders Module in default facility");
		}

	}


	public void allInvoices()
	{
		//waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		//ReceivePageObject.shopFacility();
		waitForElementToDisplayWithoutFail(OR.Order_PO_ID_First, 5);
		if(isElementDisplayedwithoutFail(OR.Order_PO_ID_First, 5))
		{
		//waitForElementToDisplayWithoutFail(OR.Order_PO_ID_First, 10);
		//waitForElement(OR.Order_PO_ID_First);
		clickOn(OR.Order_PO_ID_First);
		//Tc_Order.goToInvoiceDetail();
		waitForElementToDisplayWithoutFail(OR.OrderDetails_HeaderDropdown, 10);
		clickOn(OR.OrderDetails_HeaderDropdown);
		if (driver.findElements(By.xpath("(//a[text()='Invoices'])[1]")).size()!= 0) 
		{
			WebElement element = driver.findElement(By.xpath("(//a[text()='Invoices'])[1]"));
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			clickOn(OR.Order_PO_first_AllInvoice);
			String s=getText(OR.Order_PO_first_AllInvoice_Header);
			System.out.println(s);
			if(s.contains("INVOICES FOR PO #"))
			{

				testLogPass("Pop up is opened");
			}
			else
			{
				testLogPass("Pop up is not opened");

			}

		}
		}
		else
		{
			testLogFail("There is no order in Orders page in Default Facility");
		}
	}


	public void addInvoice()
	{
		//waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
	//	ReceivePageObject.shopFacility();
		waitForElementToDisplayWithoutFail(OR.Order_PO_ID_First, 5);
		if(isElementDisplayedwithoutFail(OR.Order_PO_ID_First, 5))
		{
		clickOn(OR.Order_PO_ID_First);
		waitForElementToDisplayWithoutFail(OR.OrderDetails_HeaderDropdown, 10);
		clickOn(OR.OrderDetails_HeaderDropdown);	
		WebElement element = driver.findElement(By.xpath("(//a[text()='Invoices'])[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		clickOn(OR.OrderDetails_AddInvoice);
		verifyElementText(OR.Order_InvoiceForText, "INVOICE FOR PO #:");
		}
		else
		{
			testLogFail("No order found in Order Module in Default facility");
		}
	}

	public void printItems()
	{
		//waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		//ReceivePageObject.shopFacility();
		waitForElementToDisplayWithoutFail(OR.Order_PO_ID_First, 5);
		if(isElementDisplayedwithoutFail(OR.Order_PO_ID_First, 5))
		{	
		clickOn(OR.Order_PO_ID_First);
		
		clickOn(OR.OrderDetails_HeaderDropdown);
		clickOn(OR.OrderDetails_PrintItems);
		verifyElementText(OR.OrderDetails_OrderItems, "Order Items");
		}
		else
		{
			testLogFail("No order found in Order Module in Default facility");
		}
	}


}


