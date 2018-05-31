
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

import pageObject.ApprovePO_PageObject;
import pageObject.Loginpage;
import pageObject.MycartPage;
import pageObject.OrderDetailsPage;
import pageObject.OrderPage;
import pageObject.ReceivePageObject;
import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;
import AutomationFramework.Generickeywords;

public class ApproveDetails  extends ApplicationKeyword{

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
			extent = new ExtentReports(folderPath+"/ApproveDetails.html", true);
			extent.addSystemInfo("User Name", "Ravneet");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}


	@Test()
	public void Tc_ApprovePODetails_002() {
		testStarts("Tc_ApprovePODetails_002",
				"Verify that �Add Note for PO #� pop up appears when user clicks on �Add New Note�"
						+"Verify that notes gets deleted when user clicks on �Delete� button for the added note.");

		Loginpage.OpenBrowserAndLogin();
		System.out.println("Tc_ApprovePODetails_002");
		waitForElementToDisplayWithoutFail(OR.ApprovePOLink, 10);
		clickOn(OR.ApprovePOLink);
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		ReceivePageObject.shopFacility();
		waitForElementToDisplayWithoutFail(OR.Order_PO_ID_First, 5);
		if(isElementDisplayedwithoutFail(OR.Order_PO_ID_First, 5))
		{
		//waitForElementToDisplayWithoutFail(OR.Order_PO_ID_First, 10);
		clickOn(OR.Order_PO_ID_First);
		OrderDetailsPage.viewNotesForPO();
		OrderDetailsPage.AddNotes();
		waitForElementToDisplayWithoutFail(OR.OrderNotes_searchBox, 10);
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
	public void Tc_ApprovePODetails_003() {
		testStarts("Tc_ApprovePODetails_003",
				"Verify that �PO # XXXX11 Documents� pop up appears when clicks on Documents icon with count.");
		//Loginpage.OpenBrowserAndLogin();
		System.out.println("Tc_ApprovePODetails_003");
		NavigateUrl(DashBoardURL);
		waitForElementToDisplayWithoutFail(OR.ApprovePOLink, 10);
		clickOn(OR.ApprovePOLink);
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		ApprovePO_PageObject.shopFacility_ApprovePage();
		waitForElementToDisplayWithoutFail(OR.Order_PO_ID_First, 5);
		if(isElementDisplayedwithoutFail(OR.Order_PO_ID_First, 5))
		{
		//waitForElementToDisplayWithoutFail(OR.Order_PO_ID_First, 10);
		clickOn(OR.Order_PO_ID_First);
		waitForElementToDisplayWithoutFail(OR.Order_PO_Doc_Icon, 10);
		clickOn(OR.Order_PO_Doc_Icon);
		OrderDetailsPage.viewDocumentForPO();
		clickOn(OR.OrderNotes_PO_NotesClose);
		}
	}

	@Test()
	public void Tc_ApprovePODetails_004() {
		testStarts("Tc_ApprovePODetails_004",
				"Verify that select file from computer window opens when user clicks on Upload File button.");
		//Loginpage.OpenBrowserAndLogin();
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_ApprovePODetails_004");
		NavigateUrl(DashBoardURL);
		clickOn(OR.ApprovePOLink);
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		ApprovePO_PageObject.shopFacility_ApprovePage();
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

	}

	@Test()
	public void Tc_ApprovePODetails_005() {
		testStarts("Tc_ApprovePODetails_005","Verify that items in PO gets added to cart when user clicks on �Add Items to cart� option");
		//Loginpage.OpenBrowserAndLogin();
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_ApprovePODetails_005");
		clickOn(OR.MyCart);
		MycartPage.checkIfCartIsEmpty();				
		System.out.println("Tc_OrderDetails_004");
		//NavigateUrl(DashBoardURL);
		clickOn(OR.ApprovePOLink);
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		ApprovePO_PageObject.shopFacility_ApprovePage();
		waitForElementToDisplayWithoutFail(OR.Order_PO_ID_First, 5);
		if(isElementDisplayedwithoutFail(OR.Order_PO_ID_First, 5))
		{
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
	}

	@Test()
	public void Tc_ApprovePODetails_0091() {
		testStarts("Tc_ApprovePODetails_008",
				"Verify that “PO AUDIT LOGS FOR PO #” pop up window appears when user clicks on Po Log option in the dropdown. ");
		//Loginpage.OpenBrowserAndLogin();
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_ApprovePODetails_0091");
		clickOn(OR.ApprovePOLink);
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		ApprovePO_PageObject.shopFacility_ApprovePage();
		waitForElementToDisplayWithoutFail(OR.Order_PO_ID_First, 5);
		if(isElementDisplayedwithoutFail(OR.Order_PO_ID_First, 5))
		{
		clickOn(OR.Order_PO_ID_First);
		waitForElementToDisplayWithoutFail(OR.OrderDetails_HeaderDropdown, 10);
		clickOn(OR.OrderDetails_HeaderDropdown);
		waitForElementToDisplayWithoutFail(OR.Order_PO_first_PoLog, 10);
		clickOn(OR.Order_PO_first_PoLog);
		waitForElementToDisplayWithoutFail(OR.Receive_POLOgText,10);
		verifyElementText(OR.Receive_POLOgText, "PO AUDIT LOGS FOR PO #");		
		clickOn(OR.Receive_PrintCloseclose);
		}
	}


	@Test()
	public void Tc_ApprovePODetails_0071() {
		testStarts("Tc_ApprovePODetails_0071","Verify that Print popup window opens on clicking Print Items button.");
		//Loginpage.OpenBrowserAndLogin();
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_ApprovePODetails_0071");
		clickOn(OR.ApprovePOLink);
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		ApprovePO_PageObject.shopFacility_ApprovePage();
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
	}			

	@Test()
	public void Tc_ApproveDetails_016_15() {
		testStarts("Tc_ApproveDetails_016_15",
				"Verify that show tour pops appear when user clicks on show tour option in dropdown next to refresh button."
						+"Verify that “Mark as Receive only” option appears.");
		//Loginpage.OpenBrowserAndLogin();
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_ApproveDetails_016_15");
		clickOn(OR.ApprovePOLink);
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		ApprovePO_PageObject.shopFacility_ApprovePage();
		waitForElementToDisplayWithoutFail(OR.Order_PO_ID_First, 5);
		if(isElementDisplayedwithoutFail(OR.Order_PO_ID_First, 5))
		{
		waitForElementToDisplayWithoutFail(OR.Order_PO_ID_First, 10);
		clickOn(OR.Order_PO_ID_First);
		waitForElementToDisplayWithoutFail(OR.OrderDetails_HeaderDropdown, 10);
		clickOn(OR.OrderDetails_HeaderDropdown);
		waitForElementToDisplayWithoutFail(OR.ApprovePO_markAsReceive, 10);			
		String text=getText(OR.ApprovePO_markAsReceive);
		if(text.equalsIgnoreCase("Mark as Non Receive Only") || text.equalsIgnoreCase("Mark as Receive Only"))

		{
			testLogPass("Text is Present");
		}
		else
		{
			testLogFail("Text is not Present");
		}			
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

	}


	@Test()
	public void Tc_ApproveDetails_017_018() {
		testStarts("Tc_ApproveDetails_017_018","Verify that �Departments� pop up appears when user clicks on Attach  department hyperlink.\r\n"+"Verify that �Physicians� pop up appears when user clicks on �Attach Physician� hyperlink.");
		//Loginpage.OpenBrowserAndLogin();
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_ApproveDetails_017_018");
		clickOn(OR.ApprovePOLink);
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		ApprovePO_PageObject.shopFacility_ApprovePage();
		waitForElementToDisplayWithoutFail(OR.Order_PO_ID_First, 5);
		if(isElementDisplayedwithoutFail(OR.Order_PO_ID_First, 5))
		{
		//waitForElementToDisplayWithoutFail(OR.Order_PO_ID_First, 10);
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
	}
	@Test()
	public void Tc_ApproveDetails_019() {
		testStarts("Tc_ApproveDetails_019","Verify that Approve detail screen gets closed when user clicks on Close option.");
		//Loginpage.OpenBrowserAndLogin();
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_ApproveDetails_019");
		clickOn(OR.ApprovePOLink);
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		ApprovePO_PageObject.shopFacility_ApprovePage();
		waitForElementToDisplayWithoutFail(OR.Order_PO_ID_First, 5);
		if(isElementDisplayedwithoutFail(OR.Order_PO_ID_First, 5))
		{
		waitForElementToDisplayWithoutFail(OR.Order_PO_ID_First, 10);
		clickOn(OR.Order_PO_ID_First);
		waitForElementToDisplayWithoutFail(OR.OrderDetails_Close, 10);
		clickOn(OR.OrderDetails_Close);
		waitTime(4);;
		verifyElement(OR.ApprovePO_MyOrderTxt);
		}
	}

	@Test()
	public void Tc_ApproveDetails_005_006() {
		testStarts("Tc_ApproveDetails_005_006","Verify that pop up text ”Changing the ship to location would put the PO again in approval flow of new facility.” appears when user clicks on Change Facility/Department button."
				+"Verify that  Approve and Reject button appears on the page.");
		//Loginpage.OpenBrowserAndLogin();
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_ApproveDetails_005_006");
		clickOn(OR.ApprovePOLink);
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		ApprovePO_PageObject.shopFacility_ApprovePage();
		waitForElementToDisplayWithoutFail(OR.Order_PO_ID_First, 5);
		if(isElementDisplayedwithoutFail(OR.Order_PO_ID_First, 5))
		{
		waitForElementToDisplayWithoutFail(OR.Order_PO_ID_First, 10);
		clickOn(OR.Order_PO_ID_First);
		waitForElementToDisplayWithoutFail(OR.ApprovePO_ApproveButton, 10);	
		verifyElementText(OR.ApprovePO_ApproveButton, "Approve ");
		verifyElementText(OR.ApprovePO_RejectButton, "Reject ");
		waitForElementToDisplayWithoutFail(OR.ApprovePO_changeDepartment, 10);
		clickOn(OR.ApprovePO_changeDepartment);
		System.out.println(getText(OR.ApprovePO_changeDepartmentText));
		verifyElementText(OR.ApprovePO_changeDepartmentText, "Changing the ship to location would put the PO again in approval flow of new facility.");
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
		ReceivePageObject.shopFacility();
		waitForElementToDisplayWithoutFail(OR.Order_PO_ID_First, 5);
		if(isElementDisplayedwithoutFail(OR.Order_PO_ID_First, 5))
		{
		//waitForElementToDisplayWithoutFail(OR.Order_PO_ID_First, 10);
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

	}


	public void allInvoices()
	{
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		ReceivePageObject.shopFacility();
		waitForElementToDisplayWithoutFail(OR.Order_PO_ID_First, 5);
		if(isElementDisplayedwithoutFail(OR.Order_PO_ID_First, 5))
		{
	//	waitForElementToDisplayWithoutFail(OR.Order_PO_ID_First, 10);
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
	}


	public void addInvoice()
	{
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		ReceivePageObject.shopFacility();
		waitForElementToDisplayWithoutFail(OR.Order_PO_ID_First, 5);
		if(isElementDisplayedwithoutFail(OR.Order_PO_ID_First, 5))
		{
		//waitForElementToDisplayWithoutFail(OR.Order_PO_ID_First, 10);	
		clickOn(OR.Order_PO_ID_First);
		waitForElementToDisplayWithoutFail(OR.OrderDetails_HeaderDropdown, 10);
		clickOn(OR.OrderDetails_HeaderDropdown);	
		WebElement element = driver.findElement(By.xpath("(//a[text()='Invoices'])[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		clickOn(OR.OrderDetails_AddInvoice);

		verifyElementText(OR.Order_InvoiceForText, "INVOICE FOR PO #:");
		}
	}

	public void printItems()
	{
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		ReceivePageObject.shopFacility();
		waitForElementToDisplayWithoutFail(OR.Order_PO_ID_First, 5);
		if(isElementDisplayedwithoutFail(OR.Order_PO_ID_First, 5))
		{
		//waitForElementToDisplayWithoutFail(OR.Order_PO_ID_First, 10);
		clickOn(OR.Order_PO_ID_First);
		clickOn(OR.OrderDetails_HeaderDropdown);
		clickOn(OR.OrderDetails_PrintItems);
		verifyElementText(OR.OrderDetails_OrderItems, "Order Items");
	}
	}

}






