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

public class TC_PreferenceCards extends ApplicationKeyword{

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

			extent = new ExtentReports(folderPath+"/PreferenceCards.html", true);
			extent.addSystemInfo("User Name", "QA");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}

	
	@Test 
	public void Tc_PreferenceCards_001()
	{
		testStarts("Tc_PreferenceCards_001", "Verify that \"Manage Procedures\" heading appears on top left side of page.");
		Loginpage.OpenBrowserAndLoginnew();
		PreferenceCards.prefCardPagePageLinkandwait();
		PreferenceCards.verifyPage();
		//PreferenceCards.addStageAndItem();
		PreferenceCards.AddPreferenceCard();
		PreferenceCards.AddPreferenceCard2();
		PreferenceCards.Delete();
		
	}
	
	@Test 
	public void Tc_PreferenceCards_002()
	{
		testStarts("Tc_PreferenceCards_002", "Create Preference Card > Stage tab > Verify that Reorder items and Remove Stage buttons appear on page.");
		PreferenceCards.prefCardPagePageLinkandwait();
		PreferenceCards.RemoveStage();
	}
	
	@Test 
	public void Tc_PreferenceCards_003()
	{
		testStarts("Tc_PreferenceCards_003", "Edit Preference Card > Verify that user is able to edit Open and Hold qty and same get saved on clicking Save button.");
		PreferenceCards.prefCardPagePageLinkandwait();
		PreferenceCards.AddPreferenceCard1();
		typeIn(OR.prefCard_searchTextBox, getProperty("PreferenceCards"));
		verifyPagination();
		PreferenceCards.EditPrefcard();
		
	}
	
	@AfterTest
	public void endReport()
	{
		closeBrowser();
		extent.flush();
	}
}


