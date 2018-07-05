package testcases_functionality;

import java.io.File;

import org.openqa.selenium.By;
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

public class TC_Invoice extends ApplicationKeyword{

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

			extent = new ExtentReports(folderPath+"/Invoice.html", true);
			extent.addSystemInfo("User Name", "QA");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}

	
	@Test
	public void Tc_Invoice_001() {
		testStarts("Tc_Invoice_001", "Verify that “Manage Inventory Locations” heading appears on top left side of page.");
		Loginpage.OpenBrowserAndLogin();
		Receive.NavigateToApprovalflow();
		ReceiveOrderDetails.Search(getProperty("GeneratePoNumber"));
		clickOn(OR.OrderDetails_PO_Dropdown);
		mouseOver(OR.Order_PO_first_invoice);
		waitForElement(OR.OrderDetails_AddInvoice);
		clickOn(OR.OrderDetails_AddInvoice);
		selectFromDropdown(OR.Invoice_AddItemInInvoice, "All");
		clickOn(OR.Invoice_AddItemButton);
		String InvoiceNumber= "InvoiceUpdateNo"+generateRandomInt(5);
		setProperty("InvoiceUpdateNumber", InvoiceNumber);
		typeIn(OR.OrderDetails_InvoiceInput, InvoiceNumber);
		clickOn(OR.SI_SAveButton);
		waitTime(3);
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
		Invoices.NavigateToInvoice();
		int size = driver.findElements(By.xpath("//table/thead/tr/th//a")).size();
		for(int i=1; i<=size;i++)
		{
			String one = driver.findElement(By.xpath("(//table/thead/tr/th//a)["+i+"]")).getText();
			if(one.isEmpty())
			{
				
			}
			else
			{
			testLogPass("Header is "+one);
			}
		}
	
		
	}
	
	
	@Test
	public void Tc_Invoice_002() {
		testStarts("Tc_Invoice_002", "Verify that data should be same on print and pdf.");
		waitForElement(OR.Request_InvoicePageLink);
		clickOn(OR.Request_InvoicePageLink);
		waitForElement(OR.Patient_searchTextBox);
		typeIn(OR.Patient_searchTextBox, getProperty("GeneratePoNumber"));
		clickOn(OR.OP_searchButton);
		waitForElement(OR.Order_Vendor_txt);
		Invoices.Print();
		Invoices.Delete();
	}
	
	@Test
	public void Tc_Invoice_003() {
		testStarts("Tc_Invoice_002", "Verify that Pdf gets downloaded when user clicks on \"Pdf\" Icon");
		waitForElement(OR.Request_InvoicePageLink);
		clickOn(OR.Request_InvoicePageLink);
		waitForElement(OR.Patient_searchTextBox);
		typeIn(OR.Patient_searchTextBox, getProperty("GeneratePoNumber"));
		clickOn(OR.OP_searchButton);
		waitForElement(OR.Order_Vendor_txt);
		Invoices.Print();
		Invoices.Delete();
	}
	
	@AfterTest
	public void endReport()
	{
		closeBrowser();
		extent.flush();
	}
}


