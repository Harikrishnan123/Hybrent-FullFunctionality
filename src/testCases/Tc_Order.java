package testCases;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import pageObject.Loginpage;
import pageObject.MycartPage;
import pageObject.OrderPage;
import pageObject.ReceivePageObject;
import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;
import AutomationFramework.Generickeywords;

public class Tc_Order extends ApplicationKeyword{

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
				// If you require it to make the entire directory path including parents,
				// use directory.mkdirs(); here instead.
			}

			extent = new ExtentReports(folderPath+"/order.html", true);
			// extent.addSystemInfo("Environment","Environment Name")
			extent.addSystemInfo("User Name", "Ravneet");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}


	@Test
	public void Tc_Order_001_20() {
		testStarts("Tc_Order_001,TC_Order_020", "Verify that user can search PO on basis PO#, Sku.+Verify that user gets redirected to PO detail page on clicking PO number.");
		Loginpage.OpenBrowserAndLogin();
		OrderPage.pageLinkandwait();
		//waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 10);
		OrderPage.shopFacility_OrderPage();
		//waitForElementToDisplayWithoutFail(OR.NOOrderFound, 8);
		//String s=getText(OR.NOOrderFound);
		//System.out.println(s);
//		if (s.trim().equalsIgnoreCase("No Order Found"))
//		{
//			testLogPass("Assigned State has no orders");
//			clickOn(OR.Order_status_dropdown);
//			clickOn(OR.Order_PO_StatusDropdown_Confirmed);
//			clickOn(OR.Order_PO_SearchBtn);
//			waitForElementToDisplayWithoutFail(OR.NOOrderFound, 5);
//			String s1=getText(OR.NOOrderFound);
//			if(s1.trim().equalsIgnoreCase("No Order Found"))
//			{
//				testLogPass("Confirmed State has no orders");
//				clickOn(OR.Order_status_dropdown);
//				clickOn(OR.Order_PO_StatusDropdown_PartialReceived);
//				clickOn(OR.Order_PO_SearchBtn);
//				waitForElementToDisplayWithoutFail(OR.conditionForNoOrder, 5);
//				String s2=getText(OR.NOOrderFound);
//				if(s2.trim().equalsIgnoreCase("No Order Found"))
//				{
//					testLogPass("PartialReceived State has no orders");
//					clickOn(OR.Order_status_dropdown);
//					clickOn(OR.Order_PO_StatusDropdown_Completed);
//					clickOn(OR.Order_PO_SearchBtn);
//					waitForElementToDisplayWithoutFail(OR.conditionForNoOrder, 5);
//					String s3=getText(OR.NOOrderFound);
//					if(s3.trim().equalsIgnoreCase("No Order Found"))
//					{
//						testLogPass("Completed State has no orders");
//						testLogFail("There are no orders for which the Invoice could be generated");
//					}
//				}
//				else
//				{		
					searchPO();

//				}
//			}
//			else
//			{		
//				searchPO();
//			}
//		}
//		else
//		{		
//			searchPO();
//		}

	}

	@Test
	public void Tc_Order_002() {
		testStarts("Tc_Order_002",
				"Verify that following dropdown filters appear on page. Vendor, Status, Type, Facility, Department and Created By .");
		NavigateUrl(DashBoardURL);
		waitForElementToDisplayWithoutFail(OR.Order, 10);
		clickOn(OR.Order);
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		OrderPage.shopFacility_OrderPage();
		waitForElementToDisplayWithoutFail(OR.Order_firstPONUm, 5);
		if(isElementDisplayedwithoutFail(OR.Order_firstPONUm, 5))
		{
		waitForElementToDisplayWithoutFail(OR.Order_dropDownIcon, 10);	
		OrderPage.VerifyOrder();
		}

	}

//	@Test
//	public void Tc_Order_003() {
//		testStarts("Tc_Order_003", "Verify that sorting works  for PO#, Requested Cost, Created At columns.");
//		NavigateUrl(DashBoardURL);
//		clickOn(OR.Order);
//		clickOn(OR.Order_PO_Title);
//		ArrayList<String> BeforeSorting = new ArrayList<String>();
//		ArrayList<String> afterSorting = new ArrayList<String>();
//		waitTime(10);
//		int Size = driver.findElements(By.xpath("(//*[@ng-repeat='order in ordersData.purchaseOrders']/td/a)")).size();
//		List<WebElement> myElements = driver
//				.findElements(By.xpath("(//*[@ng-repeat='order in ordersData.purchaseOrders']/td/a)"));
//		for (int i = 0; i < Size; i++) {
//
//			BeforeSorting.add(myElements.get(i).getText().trim());
//			afterSorting.add(myElements.get(i).getText().trim());
//
//		}
//		if (elementPresent(OR.Assending)) {
//
//			Collections.sort(afterSorting);
//			if (BeforeSorting.equals(afterSorting)) {
//				testLogPass("Verify object is in ascending  order ");
//			} else {
//
//				testLogFail("Verify object is not in ascending order ");
//			}
//
//		} else if (elementPresent(OR.Descending)) {
//			Comparator<String> comparator = Collections.reverseOrder();
//			Collections.sort(afterSorting, comparator);
//			if (BeforeSorting.equals(afterSorting)) {
//				testLogPass("Verify if object  is in Decending order ");
//			} else {
//				testLogFail("verify object is not in Decending order ");
//			}
//		}
//
//
//	}

	@Test
	public void Tc_Order_005() {
		testStarts(" Tc_Order_004, Tc_Order_014, Tc_Order_005, Tc_Order_015",
				"Verify that 'Notes for PO #' window appears when user clicks on notes icon with count."
						+ "Verify that 'Add Note for PO #' pop up appears when user clicks on �Add New Note'"
						+ "Verify that 'Notes for PO #' window appears when user clicks on notes icon with count.");		
		NavigateUrl(DashBoardURL);
		clickOn(OR.Order);
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		OrderPage.shopFacility_OrderPage();
		waitForElementToDisplayWithoutFail(OR.Order_firstPONUm, 5);
		if(isElementDisplayedwithoutFail(OR.Order_firstPONUm, 5))
		{
		clickOn(OR.OrderNotes_PO_First);
		OrderPage.viewNotesForPO();
		}
	}

	@Test
	public void Tc_Order_019() {
		testStarts("Tc_Order_019",
				"Verify that items in PO gets added to cart when user clicks on 'Add Items to cart' option");
		//Loginpage.OpenBrowserAndLogin();
		NavigateUrl(DashBoardURL);
		clickOn(OR.MyCart);
		MycartPage.checkIfCartIsEmpty();
		clickOn(OR.Order);
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		OrderPage.shopFacility_OrderPage();
		waitForElementToDisplayWithoutFail(OR.Order_firstPONUm, 5);
		if(isElementDisplayedwithoutFail(OR.Order_firstPONUm, 5))
		{
		waitForElementToDisplayWithoutFail(OR.Order_dropDownIcon, 3);
		clickOn(OR.Order_dropDownIcon);
		waitForElementToDisplayWithoutFail(OR.Order_AdditemsToCart,10);
		clickOn(OR.Order_AdditemsToCart);
		clickOn(OR.Order_firstPONUm);
		waitForElementToDisplayWithoutFail(OR.order_firstPOHeadingText, 10);
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
	}

	@Test
	public void Tc_Order_006() {
		testStarts("Tc_Order_006, Tc_Order_017",
				"Verify that 'PO # XXXX11 Documents' pop up appears when clicks on Documents icon with count. ");
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_Order_006, Tc_Order_017");
		clickOn(OR.Order);
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		OrderPage.shopFacility_OrderPage();
		waitForElementToDisplayWithoutFail(OR.Order_firstPONUm, 5);
		if(isElementDisplayedwithoutFail(OR.Order_firstPONUm, 5))
		{
		clickOn(OR.OrderDoc_PO_First);
		OrderPage.viewDocumentForPO();
		}
		else
		{
			
		}
	}

	@Test
	public void Tc_Order_007() {
		testStarts("Tc_Order_018, TC_Order_001,TC_16",
				"Verify that select file from computer window opens when user clicks on Upload File button."
						+"Verify that user can search PO on basis of Documents.");
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_Order_018, TC_Order_001,TC_16");
		clickOn(OR.Order);
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		OrderPage.shopFacility_OrderPage();
		waitForElementToDisplayWithoutFail(OR.Order_firstPONUm, 5);
		if(isElementDisplayedwithoutFail(OR.Order_firstPONUm, 5))
		{
		String s=getText(OR.Order_firstPONUm);
		waitForElementToDisplayWithoutFail(OR.Order_DocsLink, 3);
		clickOn(OR.Order_DocsLink);		
		verifyElementText(OR.Receive_DocsLinkText, "PO # " +s+ " Documents");		
		WebElement elem=driver.findElement(By.xpath("//*[@type='file']"));
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path --- " + projectPath);
		elem.sendKeys(projectPath + "/assets/images.jpeg");
		String nameOfFile_Expected="images.jpeg";
		waitTime(5);
		waitForElementToDisplayWithoutFail(OR.Invoice_UploadDocName, 10);
		String s2=getText(OR.Invoice_UploadDocName).trim();		
		clickOn(OR.Order_CloseButton);
		typeIn(OR.Order_Search_Input, "images.jpeg");
		clickOn(OR.Order_PO_SearchBtn);
		waitForElementToDisplayWithoutFail(OR.Order_dropDownIcon, 10);
		if(getText(OR.Order_firstPONUm).equalsIgnoreCase(s))
		{
			testLogPass("Item is searched with Documents added");
			clickOn(OR.Order_DocsLink);
			waitTime(3);
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
		}
	}
	//need to select assigned for this.
	@Test
	public void Tc_Order_008() {
		testStarts("Tc_Order_008",
				"Verify that 'Print PO' preview window appears when user clicks on Print Po option in action dropdown.");
		//Loginpage.OpenBrowserAndLogin();
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_Order_008");
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
					printPo();

				}
			}
			else
			{		
				printPo();
			}
		}
		else
		{		
			printPo();
		}
	}

	//Need to select assigned for this

	@Test
	public void Tc_Order_009() {
		testStarts("Tc_Order_009, Tc_Order_010",
				"Verify that user gets redirected to 'INVOICE FOR PO #' page, on clicking 'Add Invoice' option."
						+"Verify that 'INVOICES FOR PO #' page appears when user clicks on All Invoices option");
		NavigateUrl(DashBoardURL);		
		System.out.println("Tc_Order_009, Tc_Order_010");
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
							goToInvoiceDetail();

						}
					}
					else
					{		
						goToInvoiceDetail();
					}
				}
				else
				{		
					goToInvoiceDetail();
				}
	}

	@Test
	public void Tc_Order_013() {
		testStarts("Tc_Order_013",
				"Verify that 'PO AUDIT LOGS FOR PO #' pop up window appears when user clicks on Po Log option in the dropdown.");
		//Loginpage.OpenBrowserAndLogin();
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_Order_013");
		clickOn(OR.Order);
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
//		clickOn(OR.Order_status_dropdown);
//		clickOn(OR.Order_PO_StatusDropdown_Assigned);
//		clickOn(OR.Order_PO_SearchBtn);
//		waitTime(10);
		OrderPage.shopFacility_OrderPage();
		waitForElementToDisplayWithoutFail(OR.Order_firstPONUm, 5);
		if(isElementDisplayedwithoutFail(OR.Order_firstPONUm, 5))
		{
		waitForElementToDisplayWithoutFail(OR.Order_PO_first_dropdown, 10);
		clickOn(OR.Order_PO_first_dropdown);
		waitForElementToDisplayWithoutFail(OR.Order_PO_first_PoLog, 10);
		clickOn(OR.Order_PO_first_PoLog);
		waitForElementToDisplayWithoutFail(OR.Order_PO_first_PoLog, 10);
		verifyElementText(OR.Order_PO_headerText, "PO AUDIT LOGS FOR PO #");
		}
	}

	@Test
	public void Tc_Order_016() {
		testStarts("Tc_Order_016,Tc_Order_001",
				"Verify that notes gets deleted when user clicks on 'Delete' button for the added note."
		+"Verify that user can search PO on basis Notes ");
		//Loginpage.OpenBrowserAndLogin();
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_Order_016,Tc_Order_001");
		waitForElementToDisplayWithoutFail(OR.Order, 10);
		clickOn(OR.Order);
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		OrderPage.shopFacility_OrderPage();
		waitForElementToDisplayWithoutFail(OR.Order_firstPONUm, 5);
		if(isElementDisplayedwithoutFail(OR.Order_firstPONUm, 5))
		{
		String firstPoNum2=getText(OR.Order_firstPONUm);	
		waitForElementToDisplayWithoutFail(OR.Order_firstPONUm, 10);
		clickOn(OR.OrderNotes_PO_First);
		OrderPage.viewNotesForPO();
		OrderPage.AddNotes();
		waitForElementToDisplayWithoutFail(OR.Order_CancelNotesPopUP, 3);
		clickOn(OR.Order_CancelNotesPopUP);
		typeIn(OR.Order_Search_Input, "TestABCwrererer");
		clickOn(OR.Order_PO_SearchBtn);
		waitForElementToDisplayWithoutFail(OR.Order_firstPONUm, 10);		
		if(getText(OR.Order_firstPONUm).equalsIgnoreCase(firstPoNum2))
		{
			testLogPass("Item is searched with PO Notes");
			clearEditBox(OR.Order_Search_Input);
			clickOn(OR.Order_PO_SearchBtn);
			waitForElementToDisplayWithoutFail(OR.Order_dropDownIcon, 10);	
			clickOn(OR.OrderNotes_PO_First);
			typeIn(OR.OrderNotes_searchBox, "TestABCwrererer");	
			waitForElementToDisplayWithoutFail(OR.Receive_searchedfirstNote, 10);
			if(getText(OR.Receive_searchedfirstNote).equals("TestABCwrererer"))
			{
				clickOn(OR.Receive_DeleteIcon);
				clickOn(OR.Receive_confirmButton);
				waitTime(2);
			}	
		}
		else
		{
			testLogFail("Item is not searched with PO Notes");	
		}
		}
		//		System.out.println("Tc_Order_016,Tc_Order_001");
		//		clickOn(OR.Order);
		//		clickOn(OR.OrderNotes_PO_First);
		//		OrderPage.viewNotesForPO();
		//		OrderPage.AddNotes();
		//		waitForElement(OR.Order_PO_Notes_DeleteBtn);
		//		clickOn(OR.Order_PO_Notes_DeleteBtn);
		//		waitForElement(OR.Order_PO_Notes_Deletevalidation, 60);
		//		verifyElementText(OR.Order_PO_Notes_Deletevalidation, "Are you sure you want to delete this note?");
		//		clickOn(OR.Order_PO_Notes_Delete_yes);

	}

	@AfterTest
	public void endReport(){
		closeBrowser();
		extent.flush();
	}


	public static void goToInvoiceDetail()
	{
		hoverOverInvoice();
		waitForElementToDisplayWithoutFail(OR.Order_PO_first_Addinvoice, 60);
		clickOn(OR.Order_PO_first_Addinvoice);
		verifyElementText(OR.Order_InvoiceForText, "INVOICE FOR PO #:");	
		driver.navigate().back();
		hoverOverInvoice();
		waitForElementToDisplayWithoutFail(OR.Order_PO_first_AllInvoice, 10);
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

	public static void hoverOverInvoice()
	{
//		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
//		ReceivePageObject.shopFacility();
		waitForElementToDisplayWithoutFail(OR.Order_firstPONUm, 5);
		if(isElementDisplayedwithoutFail(OR.Order_firstPONUm, 5))
		{
		waitForElementToDisplayWithoutFail(OR.Order_dropDownIcon, 10);
		clickOn(OR.Order_dropDownIcon);
		WebElement element = driver.findElement(By.xpath("(//a[text()='Invoices'])[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	else
	{
		testLogFail("There is no order in Orders Page in default facility");
	}
	}
	

	public static void searchPO()
	{
//		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
//		ReceivePageObject.shopFacility();
		waitTime(3);
		waitForElementToDisplayWithoutFail(OR.Order_firstPONUm, 5);
		if(isElementDisplayedwithoutFail(OR.Order_firstPONUm, 5))
		{
		String firstPoNum=getText(OR.Order_firstPONUm);	
		System.out.println(firstPoNum);
		typeIn(OR.Order_Search_Input, firstPoNum);
		clickOn(OR.Order_PO_SearchBtn);
		waitForElementToDisplayWithoutFail(OR.Order_dropDownIcon, 10);
		if(getText(OR.Order_firstPONUm).equalsIgnoreCase(firstPoNum))
		{
			testLogPass("Item is searched with PO Number");
		}
		else
		{
			testLogFail("Item is not searched with PO Number");	
		}
		clearEditBox(OR.Order_Search_Input);
		clickOn(OR.Order_PO_SearchBtn);
		waitForElementToDisplayWithoutFail(OR.Order_dropDownIcon, 3);
		clickOn(OR.Order_firstPONUm);
		waitForElementToDisplayWithoutFail(OR.Order_skuNUmber, 6);
		String skuNumber=getText(OR.Order_skuNUmber);
		System.out.println(skuNumber);
		clickOn(OR.Order_CloseButtonText);
		waitForElementToDisplayWithoutFail(OR.Order_dropDownIcon, 3);
		typeIn(OR.Order_Search_Input, skuNumber);
		clickOn(OR.Order_PO_SearchBtn);
		waitForElementToDisplayWithoutFail(OR.Order_dropDownIcon, 3);
		if(getText(OR.Order_firstPONUm).equalsIgnoreCase(firstPoNum))
		{
			testLogPass("Item is searched with SKU");

		}
		else
		{
			testLogFail("Item is not searched with SKU");	
		}	
		}
		else
		{
			testLogFail("There is no order in the Order page which can be searched");
		}
	}

	public static void selectALL_Assigned()

	{
		if(!getText(OR.Order_TextInDropDown).equalsIgnoreCase("All"))
		{
			System.out.println(getText(OR.Order_TextInDropDown));
			clickOn(OR.Order_clcikNfacilityDropDown);
			clickOn(OR.Order_selectAllFromDropDown);
			clickOn(OR.Order_searchButton);
		}
		clickOn(OR.Order_status_dropdown);
		waitForElementToDisplayWithoutFail(OR.Order_PO_StatusDropdown_Assigned, 5);
		clickOn(OR.Order_PO_StatusDropdown_Assigned);
		clickOn(OR.Order_PO_SearchBtn);		
	}
	
	public static void printPo()
	{
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		ReceivePageObject.shopFacility();
		waitForElementToDisplayWithoutFail(OR.Order_firstPONUm, 5);
		if(isElementDisplayedwithoutFail(OR.Order_firstPONUm, 5))
		{
	waitForElementToDisplayWithoutFail(OR.Order_dropDownIcon, 10);
	clickOn(OR.Order_dropDownIcon);
	clickOn(OR.Order_PrintPOLink);
	waitForElementToDisplayWithoutFail(OR.Order_PrintPOText, 10);		
	verifyElementText(OR.Order_PrintPOText, " Print PO");
	clickOn(OR.Order_PrintPReviewclose);
		
	}
	}
	
}


