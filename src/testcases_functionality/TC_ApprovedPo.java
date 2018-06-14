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
import pageObject.Changepasswordpage;

public class TC_ApprovedPo extends ApplicationKeyword{

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

			extent = new ExtentReports(folderPath+"/ApprovedPo.html", true);
			extent.addSystemInfo("User Name", "QA");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}

	
	@Test
	public void Tc_ApprovedPo_001() {
		testStarts("Tc_ApprovedPo_001", "Verify that 'ORDERS TO APPROVE' label text appear left of the page.");
		Loginpage.OpenBrowserAndLoginnew();
		ApprovePO.NavigateApprovedPO();
		ApprovePO.Menu();
		ApprovePO.Verifydetails();
		clickOn(OR.ApprovePO_Menu_ShopApp);
		Shopcart.Tour();
	}
	
	@Test
	public void Tc_ApprovedPo_002()
	{
		testStarts("Tc_ApprovedPo_002", "Verify that results appears when user performs search on the basis of filters.");
		Loginpage.OpenBrowserAndLoginnew();
		ApprovePO.NavigateApprovedPO();
		ApprovePO.VendorUnappove();
		ApprovePO.AddItem();
	}
	
	@Test
	public void Tc_ApprovedPo_003()
	{
		testStarts("Tc_ApprovedPo_003", "Verify that results appears when user performs search on the basis of filters.");
		Loginpage.OpenBrowserAndLoginnew();
		ApprovePO.NavigateApprovedPO();
		ApprovePO.SearchNavigation();
		ApprovePO.DrillDowntext();
		ApprovePO.Apprvalicon();
	}
	
	@Test
	public void Tc_ApprovedPo_004()
	{
		testStarts("Tc_ApprovedPo_004", "Verify that User can approve/reject po as per  Level and Rules added in Approval flow module.");
		Loginpage.OpenBrowserAndLoginnew();
		ApprovePO.NavigateApprovedPO();
		ApprovePO.SearchNavigation();
		ApprovePO.ApproveFlow();
	}
	
	@AfterTest
	public void endReport()
	{
		closeBrowser();
		extent.flush();
	}
}


