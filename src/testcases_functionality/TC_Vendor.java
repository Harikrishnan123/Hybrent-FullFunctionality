package testcases_functionality;

import java.io.File;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import AutomationFramework.ApplicationKeyword;
import AutomationFramework.Generickeywords;
import AutomationFramework.OR;
import funcation_PageObject.*;

public class TC_Vendor extends ApplicationKeyword{

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

			extent = new ExtentReports(folderPath+"/Vendor.html", true);
			extent.addSystemInfo("User Name", "QA");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}

	
	@Test
	public void Tc_Vendor_001() {
		testStarts("Tc_Vendor_001", "Verify that heading “Manage Vendors” appear on page.");
		Loginpage.OpenBrowserAndLoginnew();
		Vendor.NavigateToVendor();
		Vendor.verifyVendor();
		Vendor.verifyEdit();
		Vendor.EditAddressFIeld();
		clickOn(OR.PriceChangeDetails_Close);
		clickOn(OR.Dep_Delete_Cancel);
	}
	
	@Test
	public void Tc_Vendor_002() {
		testStarts("Tc_Vendor_002", "Edit Vendor > Vendor > Verify that toggle button (On/Off) appears with Is Price Update from 855 field.");
		Vendor.NavigateToVendor();
		waitForElement(OR.Vendor_EditFirst);
		mouseOver(OR.Vendor_EditFirst);
		clickOn(OR.Vendor_EditFirst);
		Vendor.ONOFFToggle(OR.Vendor_Edit_Priceupdate855, "class");
		Vendor.ONOFFToggle(OR.Vendor_Edit_Priceupdate810, "class");
		String one = getAttributeValue(OR.Vendor_Edit_Payment_Term_Input, "disabled");
		if(one.contains("disabled"))
		{
			testLogPass("Not able to edit the payment terms");
		}
		String one1 = getAttributeValue(OR.Vendor_Edit_Payment_Term_Input, "maxlength");
		testLogPass("Maximum character in the payment terms is "+one1);
		Vendor.ONOFFToggle(OR.Vendor_Edit_StatusInput, "class");
		clickOn(OR.PriceChangeDetails_Close);
		clickOn(OR.Dep_Delete_Cancel);
	}
	
	@Test
	public void Tc_Vendor_003() {
		testStarts("Tc_Vendor_003", "Edit Vendor > Address > Verify that Address Line 1, Address Line 2, City, County, State, Postal Code, Country, Phone 1, Phone 2, Fax 1, Fax 2, Email 1 and Email 2 fields appear on page.");
		
		Loginpage.OpenBrowserAndLoginnew();
		Vendor.NavigateToVendor();
		waitForElement(OR.Vendor_EditFirst);
		mouseOver(OR.Vendor_EditFirst);
		clickOn(OR.Vendor_EditFirst);
		Vendor.Address();
		Vendor.Interface();
		Vendor.UOM();
		Vendor.Customersupport();
		Vendor.Sales();
		Vendor.Editsales();
		Vendor.DeleteSales();
		clickOn(OR.Vendor_txt);
		clickOn(OR.PriceChangeDetails_Close);
		clickOn(OR.Dep_Delete_Cancel);
	}
	
	@Test
	public void Tc_Vendor_004() {
		testStarts("Tc_Vendor_004", "Active ventor");
		Vendor.NavigateToVendor();
		clickOn(OR.Vendor_EditFirst);
		Vendor.ActiveVendor();
	}
	
	
	@AfterTest
	public void endReport()
	{
		closeBrowser();
		extent.flush();
	}
}


