package testCases;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObject.ApprovePO_PageObject;
import pageObject.Loginpage;
import pageObject.MycartPage;
import pageObject.OrderPage;
import pageObject.ReceivePageObject;

import com.relevantcodes.extentreports.ExtentReports;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.Generickeywords;
import AutomationFramework.OR;

public class ApprovePO extends ApplicationKeyword{

	@Parameters({"siteName", "siteUrl"})
	@BeforeTest
	public void startReport(String siteName, String siteUrl) {
		try {
			Loginpage.URL=siteUrl + "#/login/";
			Generickeywords.DashBoardURL=siteUrl + "#/dashboard";
			String folderPath=OutputDirectory + "/" + siteName;
			File directory = new File(folderPath);
			if (! directory.exists()){
				directory.mkdir();
			}
			extent = new ExtentReports(folderPath+"/ApprovePO.html", true);
			extent.addSystemInfo("User Name", "Ravneet");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));
		} catch (Exception e) {
			System.out.println("--Start REPORT-Cart-Error---" + e.toString());
		}
	}

	@Test
	public void Tc_ApprovePO_01()
	{
		testStarts("Tc_ApprovePO_01()" , "Verify that PO with Unapproved status appear on page."
				+ " Verify that following dropdown filters appear on page(Vendor, Type, Facility, Department,Created By ");
		System.out.println("Tc_ApprovePO_01()");		
		Loginpage.OpenBrowserAndLogin();	
		clickOn(OR.ApprovePOLink);
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		ApprovePO_PageObject.shopFacility_ApprovePage();
		waitForElementToDisplayWithoutFail(OR.ApprovePO_Status, 10);
		if(isElementDisplayedwithoutFail(OR.ApprovePO_Status, 10))
		{		
		verifyElementText(OR.ApprovePO_Status, "Status");
		System.out.println(getText(OR.ApprovePO_Unapproved));
		if(getText(OR.ApprovePO_Unapproved).equalsIgnoreCase("Unapproved"))
		{
			testLogPass("Unapproved status is mentioned in PO");
		}
		else
		{
			testLogFail("NO order is found in the Approve PO details page");
		}
		}
		else
		{
			testLogFail("No order to be approved in User;s Default facility");
		}
	}

	@Test
	public void Tc_ApprovePO_02_18() {
		testStarts("Tc_ApprovePO_02_18", "Verify that user can search PO on basis PO#, Sku.+Verify that user gets redirected to PO detail page on clicking PO number.");
		System.out.println("Tc_ApprovePO_02_18()");		
	//	Loginpage.OpenBrowserAndLogin();	
		NavigateUrl(DashBoardURL);
		waitForElementToDisplayWithoutFail(OR.ApprovePOLink, 10);
		clickOn(OR.ApprovePOLink);
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		ApprovePO_PageObject.shopFacility_ApprovePage();
		searchPO();
		
	}

	@Test
	public void Tc_ApprovePO_003() {
		testStarts("Tc_ApprovePO_003",
				"Verify that following dropdown filters appear on page. Vendor, Type, Facility, Department and Created By .");
		System.out.println("Tc_ApprovePO_003()");		
		NavigateUrl(DashBoardURL);
		//Loginpage.OpenBrowserAndLogin();	
		waitForElementToDisplayWithoutFail(OR.ApprovePOLink, 10);
		clickOn(OR.ApprovePOLink);
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		ApprovePO_PageObject.shopFacility_ApprovePage();
		waitForElementToDisplayWithoutFail(OR.Order_dropDownIcon, 5);
		if(isElementDisplayedwithoutFail(OR.Order_dropDownIcon, 5))
		{
//		waitForElementToDisplayWithoutFail(OR.Order_dropDownIcon, 10);	
		Verifydetails();
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
	public void Tc_ApprovePO_005_006() {
		testStarts(" Tc_ApprovePO_005_006",
				"Verify that 'Notes for PO #' window appears when user clicks on notes icon with count."
						+ "Verify that 'Add Note for PO #' pop up appears when user clicks on �Add New Note'");		
		System.out.println("Tc_ApprovePO_005_006()");		
		NavigateUrl(DashBoardURL);
		//Loginpage.OpenBrowserAndLogin();
		waitForElementToDisplayWithoutFail(OR.ApprovePOLink, 10);
		clickOn(OR.ApprovePOLink);
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		ApprovePO_PageObject.shopFacility_ApprovePage();
		waitForElementToDisplayWithoutFail(OR.OrderNotes_PO_First, 5);
		if(isElementDisplayedwithoutFail(OR.OrderNotes_PO_First, 5))
		{
		//waitForElementToDisplayWithoutFail(OR.OrderNotes_PO_First, 10);
		clickOn(OR.OrderNotes_PO_First);
		OrderPage.viewNotesForPO();
		}
	}

	@Test
	public void Tc_ApprovePO_012_14() {
		testStarts("Tc_ApprovePO_012_14",
				"Verify that items in PO gets added to cart when user clicks on �Add Items to cart� option"
		+"Verify that user gets redirected to PO detail page on clicking PO number.");
		System.out.println("Tc_ApprovePO_012_14()");		
		NavigateUrl(DashBoardURL);
		//Loginpage.OpenBrowserAndLogin();
		clickOn(OR.MyCart);
		MycartPage.checkIfCartIsEmpty();
		clickOn(OR.ApprovePOLink);		
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		ApprovePO_PageObject.shopFacility_ApprovePage();
		waitForElementToDisplayWithoutFail(OR.Order_dropDownIcon, 5);
		if(isElementDisplayedwithoutFail(OR.Order_dropDownIcon, 5))
		{
		//waitForElementToDisplayWithoutFail(OR.Order_dropDownIcon, 3);
		clickOn(OR.Order_dropDownIcon);
		waitForElementToDisplayWithoutFail(OR.Order_AdditemsToCart,10);
		clickOn(OR.Order_AdditemsToCart);
		clickOn(OR.Order_firstPONUm);
		//verifyElementText(OR.ApprovePO_POHeader, "Purchase Order #");
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
	public void Tc_ApprovePO_007() {
		testStarts("Tc_ApprovePO_007",
				"Verify that 'PO # XXXX11 Documents' pop up appears when clicks on Documents icon with count. ");
		NavigateUrl(DashBoardURL);		
		//Loginpage.OpenBrowserAndLogin();
		System.out.println("Tc_ApprovePO_007");
		clickOn(OR.ApprovePOLink);
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		ApprovePO_PageObject.shopFacility_ApprovePage();
		waitForElementToDisplayWithoutFail(OR.OrderDoc_PO_First, 5);
		if(isElementDisplayedwithoutFail(OR.OrderDoc_PO_First, 5))
		{
		//waitForElementToDisplayWithoutFail(OR.OrderDoc_PO_First, 10);
		clickOn(OR.OrderDoc_PO_First);
		OrderPage.viewDocumentForPO();
		}
	}

	@Test
	public void Tc_ApprovePO_008_001() {
		testStarts("Tc_ApprovePO_008_001",
				"Verify that select file from computer window opens when user clicks on Upload File button."
						+"Verify that user can search PO on basis of Documents.");
		NavigateUrl(DashBoardURL);
		//Loginpage.OpenBrowserAndLogin();
		System.out.println("Tc_ApprovePO_008_001");
		clickOn(OR.ApprovePOLink);
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		ApprovePO_PageObject.shopFacility_ApprovePage();
		waitForElementToDisplayWithoutFail(OR.Order_firstPONUm, 5);
		if(isElementDisplayedwithoutFail(OR.Order_firstPONUm, 5))
		{
		//waitForElementToDisplayWithoutFail(OR.Order_dropDownIcon, 6);
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
	@Test
	public void Tc_ApprovePO_010() {
		testStarts("Tc_ApprovePO_010",
				"Verify that 'Print PO' preview window appears when user clicks on Print Po option in action dropdown.");
		NavigateUrl(DashBoardURL);
		//Loginpage.OpenBrowserAndLogin();
		System.out.println("Tc_ApprovePO_010");
		clickOn(OR.ApprovePOLink);
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		ApprovePO_PageObject.shopFacility_ApprovePage();
		waitForElementToDisplayWithoutFail(OR.Order_PO_first_dropdown, 5);
		if(isElementDisplayedwithoutFail(OR.Order_PO_first_dropdown, 5))
		{
		waitForElementToDisplayWithoutFail(OR.Order_dropDownIcon, 5);
		clickOn(OR.Order_dropDownIcon);
		clickOn(OR.ApprovePO_PrintItems);
		waitForElementToDisplayWithoutFail(OR.ApprovePO_PrintItemsText, 5);		
		verifyElementText(OR.ApprovePO_PrintItemsText, "Print PO #");		
		
	}
	}
	@Test
	public void Tc_ApprovePO_011() {
		testStarts("Tc_ApprovePO_011",
				"Verify that 'PO AUDIT LOGS FOR PO #' pop up window appears when user clicks on Po Log option in the dropdown.");
		//Loginpage.OpenBrowserAndLogin();
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_ApprovePO_011");
		clickOn(OR.ApprovePOLink);
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		ApprovePO_PageObject.shopFacility_ApprovePage();
		waitForElementToDisplayWithoutFail(OR.Order_PO_first_dropdown, 5);
		if(isElementDisplayedwithoutFail(OR.Order_PO_first_dropdown, 5))
		{
		waitForElementToDisplayWithoutFail(OR.Order_PO_first_dropdown, 5);
		clickOn(OR.Order_PO_first_dropdown);
		waitForElementToDisplayWithoutFail(OR.Order_PO_first_PoLog, 5);
		clickOn(OR.Order_PO_first_PoLog);
		waitForElementToDisplayWithoutFail(OR.ApprovePO_POAuditLog, 5);
		verifyElementText(OR.ApprovePO_POAuditLog, "PO AUDIT LOGS FOR PO #");
	}
	}

//	@Test
//	public void Tc_ApprovePO_009() {
//		testStarts("Tc_ApprovePO_009",
//				"Verify that Approve/Reject sub option appears when user hovers Approval option in dropdown.");
//		Loginpage.OpenBrowserAndLogin();
//		//NavigateUrl(DashBoardURL);
//		System.out.println("Tc_ApprovePO_009");
//		clickOn(OR.ApprovePOLink);
//		selectALL();
//		waitForElementToDisplayWithoutFail(OR.Order_PO_first_dropdown, 5);
//		clickOn(OR.Order_PO_first_dropdown);
////		WebElement element = driver.findElement(By.xpath("(//a[text()='Approval'])[1]"));
////		Actions action = new Actions(driver);
////		action.moveToElement(element).build().perform();
//		waitForElementToDisplayWithoutFail(OR.ApprovePO_Approve, 10);
//		System.out.println(getText(OR.ApprovePO_Approve));
////		verifyElementText(OR.ApprovePO_Approve, "Approve");
////		verifyElementText(OR.ApprovePO_RejectPOText, "Reject");
//		//hoverOverApproval();
//	}

	
	
	
	@Test
	public void Tc_ApprovePO_013_001() {
		testStarts("Tc_ApprovePO_013_001",
				"Verify that notes gets deleted when user clicks on 'Delete' button for the added note."
						+"Verify that user can search PO on basis Notes ");
	//	Loginpage.OpenBrowserAndLogin();
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_ApprovePO_013_001");
		waitForElementToDisplayWithoutFail(OR.ApprovePOLink, 10);
		clickOn(OR.ApprovePOLink);
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		ApprovePO_PageObject.shopFacility_ApprovePage();
		waitForElementToDisplayWithoutFail(OR.Order_firstPONUm, 5);
		if(isElementDisplayedwithoutFail(OR.Order_firstPONUm, 5))
		{
		//waitForElementToDisplayWithoutFail(OR.Order_firstPONUm, 10);
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
		hoverOverApproval();
		waitForElementToDisplayWithoutFail(OR.Order_PO_first_Addinvoice, 60);
		clickOn(OR.Order_PO_first_Addinvoice);
		verifyElementText(OR.Order_InvoiceForText, "INVOICE FOR PO #:");	
		driver.navigate().back();
		hoverOverApproval();
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

	public static void hoverOverApproval()
	{
		waitForElementToDisplayWithoutFail(OR.Order_dropDownIcon, 5);
		if(isElementDisplayedwithoutFail(OR.Order_dropDownIcon, 5))
		{
		//waitForElementToDisplayWithoutFail(OR.Order_dropDownIcon, 10);
		clickOn(OR.Order_dropDownIcon);
		waitForElementToDisplayWithoutFail(OR.ApprovePO_Approval, 10);
		WebElement element = driver.findElement(By.xpath(OR.ApprovePO_Approval));
		Actions action = new Actions(driver);
		
		action.moveToElement(element).build().perform();
		waitTime(6);
		clickOn(OR.ApprovePO_approve);
		}
//		WebElement elem2=element.findElement(By.xpath("/ul[@class='dropdown-menu']//a[1]"));
//		elem2.getText();
//		System.out.println(elem2.getText());
//		WebElement elem3=element.findElement(By.xpath("/ul[@class='dropdown-menu']//a[2]"));
//		elem3.getText();
//		System.out.println(elem3.getText());
		
	}

	public static void searchPO()
	{
		waitForElementToDisplayWithoutFail(OR.Order_dropDownIcon, 5);
		if(isElementDisplayedwithoutFail(OR.Order_dropDownIcon, 5))
		{
		//waitForElementToDisplayWithoutFail(OR.Order_dropDownIcon, 10);	
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

	}

	public static void selectALL()

	{
		System.out.println(getText(OR.Order_TextInDropDown));
		if(!getText(OR.Order_TextInDropDown).equalsIgnoreCase("All"))
		{
			System.out.println(getText(OR.Order_TextInDropDown));
			clickOn(OR.Order_clcikNfacilityDropDown);
			clickOn(OR.Order_selectAllFromDropDown);
			clickOn(OR.Order_searchButton);
		}
	}

	public static void printPo()
	{
		waitForElementToDisplayWithoutFail(OR.Order_dropDownIcon, 5);
		if(isElementDisplayedwithoutFail(OR.Order_dropDownIcon, 5))
		{
		//waitForElementToDisplayWithoutFail(OR.Order_dropDownIcon, 10);
		clickOn(OR.Order_dropDownIcon);
		waitForElementToDisplayWithoutFail(OR.ApprovePO_PrintPO, 10);
		clickOn(OR.ApprovePO_PrintPO);
		waitForElementToDisplayWithoutFail(OR.Order_PrintPOText, 10);		
		verifyElementText(OR.Order_PrintPOText, " Print PO");
		clickOn(OR.Order_PrintPReviewclose);
		}
		else
		{
			testLogFail("");
		}
	}
	
	public static void Verifydetails()
    {
	waitForElementToDisplay(OR.ApprovePO_OrdestoApprove_txt, 60);
    	verifyElementText(OR.ApprovePO_OrdestoApprove_txt, "ORDERS TO APPROVE");
    	verifyElementText(OR.Order_Vendor_txt, "Vendor:");
    	verifyElement(OR.Order_Vendor_dropdown);
    	verifyElementText(OR.Order_type_txt, "Type:");
    	verifyElement(OR.Order_type_dropdown);
    	verifyElementText(OR.Order_depts_txt, "Departments:");
    	verifyElement(OR.Order_depts_dropdown);
    	verifyElementText(OR.Order_facility_txt, "Facility:");
    	verifyElement(OR.Order_facility_dropdown);
    	verifyElementText(OR.Order_creater_txt, "Created By:");
    	verifyElement(OR.Order_creater_dropdown);
    }
	
	

}





