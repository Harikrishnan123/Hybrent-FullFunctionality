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

public class TC_ScanOut extends ApplicationKeyword{

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

			extent = new ExtentReports(folderPath+"/ScanOut.html", true);
			extent.addSystemInfo("User Name", "QA");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}

	

	
	
	
	@Test
	public void TC_ScanOut_001() {
		testStarts("TC_ScanOut_001", "Verify that \"Scan out Items\" button appear when user add items to cart.");
		Loginpage.OpenBrowserAndLoginnew();
		Scanout.navigateScanout();
		//Scanout.HeaderVerify();
		Scanout.funcScanout_btn();
		Scanout.DDEdit();
		Scanout.DD_PriceChangeHistory();
		Scanout.DD_PurchaseHistory();
		Scanout.ScanOutdetails();
		Scanout.ScannedItem();
	}
	
	
	@Test
	public void TC_ScanOut_002() {
		testStarts("TC_ScanOut_002", "Verify that drop down appears with following options when user clicks the “down arrow”");
		//Loginpage.OpenBrowserAndLogin();
		Scanout.navigateScannedoutItem();
		Scanout.Pageverify();
		Scanout.HeaderVerify();
		waitUntilPageReady();
		typeIn(OR.Scanout_SearchComment, "07983-02");
		clickOn(OR.Scanout_Searchbtn);
		Scanout.ScannedItem();
		Scanout.DDEdit();
		Scanout.DD_PriceChangeHistory();
		Scanout.DD_PurchaseHistory();
		verifyPagination();
	}
	

	@AfterTest
	public void endReport()
	{
		closeBrowser();
		extent.flush();
	}
}


