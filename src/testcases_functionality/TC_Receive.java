package testcases_functionality;

import java.io.File;

import org.apache.bcel.generic.GETSTATIC;
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

public class TC_Receive extends ApplicationKeyword{

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

			extent = new ExtentReports(folderPath+"/Receive.html", true);
			extent.addSystemInfo("User Name", "QA");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}

	
	@Test
	public void Tc_Receive_001() {
		testStarts("Tc_Receive_001", "Verify that PO count appears with \"Receive\" on Menu bar.");
		Loginpage.OpenBrowserAndLoginnew();
		Receive.NavigateToApprovalflow();
		Receive.Verify();
		String s =getAttributeValue(OR.Receive_SearchTextBox, "placeholder");
		if(s.contains("by PO #, sku, notes or documents"))
		{
			testLogPass("\"PO#:,Sku\" and 'Notes or document' wartermark text are appears ");
		}
		Receive.Search(getProperty("GeneratePoNumber"));
		Receive.Facilityverify();
		clickOn(OR.ApprovePO_Menu_ShopApp);
		Shopcart.Tour();
		mouseOver(OR.Shop_SHopfor_SelectfirstItemvendorName);
		getText(OR.OrderDetails_infos);

	}
	
	@Test
	public void Tc_Receive_002() {
		testStarts("Tc_Receive_002", "Verify that “Print Window” appears when user clicks Print button.");
		Receive.NavigateToApprovalflow();
		Receive.Search(getProperty("GeneratePoNumber"));
		waitUntilPageReady();
		Receive.PrintLog();
		Receive.AddNotes();
		Receive.viewDocumentForPO();
		Receive.PrintItem();
		Receive.PrintPo();
		OrderPage.AddInvoiceInvoice();
		verifyPagination();
		pagesize();
		
	}
	
	@AfterTest
	public void endReport()
	{
		closeBrowser();
		extent.flush();
	}
}


