package testCases;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import pageObject.Invoicespage;
import pageObject.Loginpage;
import pageObject.ReceivePageObject;
import AutomationFramework.ApplicationKeyword;
import AutomationFramework.Generickeywords;
import AutomationFramework.OR;

public class InvoicePage extends ApplicationKeyword
{

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

			extent = new ExtentReports(folderPath+"/invoice.html", true);
			extent.addSystemInfo("User Name", "Ravneet");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}

	@Test
	public void Tc_INV_01() throws InterruptedException
	{
		testStarts("Tc_INV_01_", "Verify that following dropdown filters(Vendor,Status,Search By ,Due Date,Facility,Departments,Ordered By	) appear on page");
		Loginpage.OpenBrowserAndLogin();	
		System.out.println("Tc_INV_01");
		waitForElementToDisplayWithoutFail(OR.Shop_Menu, 60);
		//get the By default Facility Name of USer	
		clickOn(OR.Orders_Link);	
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 5);
		ReceivePageObject.shopFacility();
		clickOn(OR.Order_status_dropdown);
		waitForElementToDisplayWithoutFail(OR.Order_PO_StatusDropdown_Assigned, 5);
		clickOn(OR.Order_PO_StatusDropdown_Assigned);
		clickOn(OR.Order_PO_SearchBtn);
		waitForElementToDisplayWithoutFail(OR.conditionForNoOrder, 10);
		String s=getText(OR.conditionForNoOrder);
		if (s.trim().equalsIgnoreCase("No Order Found"))
		{
			testLogPass("Assigned State has no orders");
			clickOn(OR.Order_status_dropdown);
			clickOn(OR.Order_PO_StatusDropdown_Confirmed);
			clickOn(OR.Order_PO_SearchBtn);
			waitForElementToDisplayWithoutFail(OR.conditionForNoOrder, 5);
			String s1=getText(OR.conditionForNoOrder);
			if(s1.trim().equalsIgnoreCase("No Order Found"))
			{
				testLogPass("Confirmed State has no orders");
				clickOn(OR.Order_status_dropdown);
				clickOn(OR.Order_PO_StatusDropdown_PartialReceived);
				clickOn(OR.Order_PO_SearchBtn);
				waitForElementToDisplayWithoutFail(OR.conditionForNoOrder, 5);
				String s2=getText(OR.conditionForNoOrder);
				if(s2.trim().equalsIgnoreCase("No Order Found"))
				{
					testLogPass("PartialReceived State has no orders");
					clickOn(OR.Order_status_dropdown);
					clickOn(OR.Order_PO_StatusDropdown_Completed);
					clickOn(OR.Order_PO_SearchBtn);
					waitForElementToDisplayWithoutFail(OR.conditionForNoOrder, 5);
					String s3=getText(OR.conditionForNoOrder);
					if(s3.trim().equalsIgnoreCase("No Order Found"))
					{
						testLogPass("Completed State has no orders");
						testLogFail("There are no orders for which the Invoice could be generated");
					}
				}
				else
				{		
					CreateInvoice();
				}
			}
			else
			{		
				CreateInvoice();
			}
		}
		else
		{		
			CreateInvoice();
		}

	}

	public void CreateInvoice() throws InterruptedException
	{
		waitForElementToDisplayWithoutFail(OR.Order_PO_first_dropdown, 5);
		if(isElementDisplayedwithoutFail(OR.Order_PO_first_dropdown, 5))
		{
			//waitForElementToDisplayWithoutFail(OR.Order_PO_first_dropdown, 20);
			clickOn(OR.Order_PO_first_dropdown);
			waitForElementToDisplayWithoutFail(OR.Invoice_wait, 60);
			WebElement element = driver.findElement(By.xpath("(//a[text()='Invoices'])[1]"));
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			waitForElementToDisplayWithoutFail(OR.Order_PO_first_Addinvoice, 60);
			clickOn(OR.Order_PO_first_Addinvoice);
			waitForElementToDisplayWithoutFail(OR.Invoice_InvoicePONum, 60);
			String PoNum=getText(OR.Invoice_InvoicePONum);
			String invoiceName="TestINV000AA"+ApplicationKeyword.randomAlphaNumeric(3);
			setProperty("invoiceName", invoiceName);
			typeIn(OR.Invoice_InvoiceDesc, invoiceName);
			clickOn(OR.Invoice_SaveButton);
			clickOn(OR.Invoice_ConfirmButton);
			testLogPass("Second Test case starts");
			waitForElementToDisplayWithoutFail(OR.Invoice_PONUmInHeader, 5);
			String PONUmberHeader=getText(OR.Invoice_PONUmInHeader).trim();
			System.out.println(PONUmberHeader);
			clickOn(OR.Invoice_SelectFirstInvoice);
			waitForElementToDisplayWithoutFail(OR.Invoice_PageHeadTextIncludingPONum, 5);
			String header1=getText(OR.Invoice_PageHeadTextIncludingPONum).trim();
			System.out.println(header1);
			if(header1.contains(PONUmberHeader))
			{
				testLogPass("Edit PO page is opened");
			}
			else
			{
				testLogFail("Edit PO page is not opened");
			}
			testLogPass("Third Test case starts");		
			clickOn(OR.Invoice_DocButton);
			//waitForElementToDisplay(OR.Invoice_clickOnUploadFIle,12);
			WebElement elem=driver.findElement(By.xpath("//*[@type='file']"));
			String projectPath = System.getProperty("user.dir");
			System.out.println("Project path --- " + projectPath);
			elem.sendKeys(projectPath + "/assets/images.jpeg");
			waitForElementToDisplayWithoutFail(OR.Invoice_UploadDocName, 10);
			String nameOfFile_Expected="images.jpeg";
			String s2=getText(OR.Invoice_UploadDocName).trim();
			if(s2.contains(nameOfFile_Expected))
			{
				System.out.println("Name matched");
				testLogPass("Name matched");
			}
			else
			{
				testLogFail("Name not matched");
			}
			clickOn(OR.Invoice_closeButton);
			clickOn(OR.Request_InvoicePageLink);
			waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 10);
			ReceivePageObject.shopFacility();	
			typeIn(OR.Invoice_SearchInInvoiceTextBox, PoNum);
			clickOn(OR.Invoice_SearchButton);
			//Thread.sleep(4000);
			waitForElementToDisplayWithoutFail(OR.Invoice_SelectFirstPONUmFromInvoicePage, 10);
			verifyElementText(OR.Invoice_SelectFirstPONUmFromInvoicePage, PoNum);		
			clearEditBox(OR.Invoice_SearchInInvoiceTextBox);
			typeIn(OR.Invoice_SearchInInvoiceTextBox, invoiceName);
			clickOn(OR.Invoice_SearchButton);
			//	Thread.sleep(4000);
			waitForElementToDisplayWithoutFail(OR.Invoice_SelectFirstPONUmFromInvoicePage, 10);
			String abc=getText(OR.Invoice_SelectFirstInvoiceFromInvoicePage);
			if(abc.equalsIgnoreCase(invoiceName))
			{
				testLogPass("Invoice is searched with PO number");								
			}
			else
			{
				testLogFail("Invoice is not searched with PO number");	
			}
			clearEditBox(OR.Invoice_SearchInInvoiceTextBox);
			typeIn(OR.Invoice_SearchInInvoiceTextBox, nameOfFile_Expected);
			clickOn(OR.Invoice_SearchButton);
			Thread.sleep(4000);
			waitForElementToDisplayWithoutFail(OR.Invoice_SelectFirstPONUmFromInvoicePage, 10);
			verifyElementText(OR.Invoice_SelectFirstPONUmFromInvoicePage , PoNum);

		}
		else
		{
			testLogFail("There is no order for whcich Invoice could be generated");
		}
	}
	@Test
	public void Tc_INV_09_10() throws InterruptedException
	{
		testStarts("Tc_INV_09 and 10", "Verify that Invoice PDF gets downloaded when user clicks Download PDF button"
				+ " Verify that Invoice Print preview appears when user clicks Print button.");
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_INV_09_10");
		Invoicespage.typeAndSearchInvoice();	
		waitForElementToDisplayWithoutFail(OR.Invoice_DownoadPDF, 10);
		clickOn(OR.Invoice_DownoadPDF);	
		waitForElementToDisplayWithoutFail(OR.Invoice_PrintPDF, 10);
		clickOn(OR.Invoice_PrintPDF);
		//waitForElementToDisplay(OR.Invoice_PrintPReviewWindow,10);
		String IvnoiceText=getText(OR.Invoice_PrintPReviewWindow);
		if(IvnoiceText.contains("Print Invoice"))
		{
			testLogPass("Print Preview window opens");			
		}
		else
		{
			testLogFail("Print Preview window doesnot opens");
		}
		clickOn(OR.Invoice_PrintPReviewclose);

	}

	@Test
	public void Tc_INV_02() throws InterruptedException
	{
		testStarts("Tc_INV_02", "Verify that following dropdown(VendorStatusSearch By Due Date ,Facility, Departments, Ordered By  ) filters appear on page.");
		System.out.println("Tc_INV_02");
		NavigateUrl(DashBoardURL);
		clickOn(OR.Request_InvoicePageLink);		
		//Vendor DropDpwn		
		waitForElementToDisplayWithoutFail(OR.Invoice_vendorDropDownLabels, 5);
		verifyElementText(OR.Invoice_vendorDropDownLabels, "Vendor:");
		if(isElementDisplayed(OR.Invoice_vendorDropDowns, 10))
		{
			testLogPass("Vendor DropDownPresent");
		}
		else
		{
			testLogFail("Vendor DropDown not Present");
		}	    
		//Status DropDpwn	    
		verifyElementText(OR.Invoice_statusDropDownLabel, "Status:");
		if(isElementDisplayed(OR.Invoice_statusDropDowns, 10))
		{
			testLogPass("Status DropDownPresent");
		}
		else
		{
			testLogFail("Status DropDown not Present");
		}
		//Search By Due date DropDpwn	    
		verifyElementText(OR.Invoice_SearchBYDueDateLabel, "Search by Due-Date");
		if(isElementDisplayed(OR.Invoice_SearchBYDueDateDropDowns, 10))
		{
			testLogPass("Search by Due Date DropDownPresent");
		}
		else
		{
			testLogFail("Search by Due Date DropDown not Present");
		}	    
		//Search By Facility DropDpwn	    
		verifyElementText(OR.Invoice_FacilityLabel, "Facility");
		if(isElementDisplayed(OR.Invoice_facilityDateDropDowns, 10))
		{
			testLogPass("Search by Facility DropDown Present");
		}
		else
		{
			testLogFail("Search by Facility DropDown not Present");
		}	    
		//Search By Department DropDpwn	    
		verifyElementText(OR.Invoice_departmentLabel, "Departments");
		if(isElementDisplayed(OR.Invoice_departmentDropDown, 10))
		{
			testLogPass("Search by Department Drop Down Present");
		}
		else
		{
			testLogFail("Search by Department Drop Down not Present");
		}	    	    
		//Search By Ordered DropDpwn	    
		verifyElementText(OR.Invoice_OrderedByLabel, "Ordered By:");
		if(isElementDisplayed(OR.Invoice_OrderedByDropDown, 10))
		{
			testLogPass("Search by Due Date DropDownPresent");
		}
		else
		{
			testLogFail("Search by Due Date DropDown not Present");
		}

	}

	@Test
	public void Tc_INV_03() throws InterruptedException
	{
		testStarts("Tc_INV_03", "Edit Invoice > Verify that �Send to accounting� button appears on top right side of page.");
		System.out.println("Tc_INV_03");
		NavigateUrl(DashBoardURL);
		if(!Invoicespage.IntactAndQucikBook_Toggle())
		{
			Invoicespage.typeAndSearchInvoice();
			clickOn(OR.Invoice_SelectFirstInvoice);
			verifyElementText(OR.Invoice_SentToAccounting, "Send To Accounting");
			testLogPass("Sent to Accounting button is present");
		}
		else
		{
			testLogPass("Either of the toggles 'Intact' or 'QuickBook' is enabled as a result Sent to Accounting button is not present");
		}

	}

	@Test
	public void Tc_INV_04()
	{
		testStarts("Tc_INV_04", "Verify that invoice gets deleted on clicking corresponding Delete button.");
		System.out.println("Tc_INV_04");
		NavigateUrl(DashBoardURL);
		Invoicespage.typeAndSearchInvoice();
		waitForElementToDisplayWithoutFail(OR.Invoice_firstInvoice, 10);
		String invoiceName=getProperty("invoiceName");
		if(getText(OR.Invoice_firstInvoice).equalsIgnoreCase(invoiceName))
		{
			waitForElementToDisplayWithoutFail(OR.Invoice_Delete, 10);
			clickOn(OR.Invoice_Delete);
			clickOn(OR.Invoice_confirmButton);
			waitForElementToDisplayWithoutFail(OR.Invoice_firstInvoice, 10);
			Invoicespage.typeAndSearchInvoice();
			if(!getText(OR.Invoice_firstInvoice).equalsIgnoreCase(invoiceName))
			{
				testLogPass("Invoice is deleted successfully");
			}
			else
			{
				testLogFail("Invoice is not deleted");
			}
		}
		else
		{
			testLogFail("Invoice was not seacrhed or added properly");
		}
		//		clickOn(OR.Invoice_confirmButton);
		//		verifyElementText(OR.Invoice_NoInvoiceFoundMessage, "No Invoice Found");	

	}
	@AfterTest
	public void endReport(){
		closeBrowser();
		extent.flush();
	}		
}		









