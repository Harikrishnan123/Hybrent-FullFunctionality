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

public class TC_PriceTire extends ApplicationKeyword{

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

			extent = new ExtentReports(folderPath+"/Pricetire.html", true);
			extent.addSystemInfo("User Name", "QA");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}

	
	@Test
	public void Tc_PriceTire_001() {
		testStarts("Tc_PriceTire_001", "Verify that heading “Manage Price Tier” appear on page.");
		openBrowser(Loginpage.URL);
		Loginpage.login(Loginpage.UserName, Loginpage.Password);
		PriceTire.NavigateToPricetire();
		PriceTire.PageVerification();
		PriceTire.CreatePriceTire();
	}
	
	@Test
	public void Tc_PriceTire_002() {
		testStarts("Tc_PriceTire_002", "Update Price Tier > Verify that Name, Price Percentage fields appear on page.");
		PriceTire.NavigateToPricetire();
		PriceTire.Search();
		PriceTire.EditPriceTire();
	}
	
	@Test
	public void Tc_PriceTire_003() {
		testStarts("Tc_PriceTire_003", "Vendor Price Tier Setup > Verify that \"Vendor Price Tier Setup\" popup appears when user click \"Vendor Price Tier Setup\" button.");
		PriceTire.NavigateToPricetire();
		PriceTire.VendorPircetire();
	}
	@Test
	public void Tc_PriceTire_004() {
		testStarts("Tc_PriceTire_004", "Verify that confirmation popup appears on clicking the delete button for corresponding price tier.");
		PriceTire.NavigateToPricetire();
		PriceTire.Delete();
	}
	
	@AfterTest
	public void endReport()
	{
		closeBrowser();
		extent.flush();
	}
}


