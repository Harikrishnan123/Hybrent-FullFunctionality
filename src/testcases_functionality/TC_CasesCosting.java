package testcases_functionality;

import java.io.File;
import java.net.URL;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.IAnnotationTransformer;
import org.testng.ITestNGListener;
import org.testng.SkipException;
import org.testng.TestNG;
import funcation_PageObject.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.ITestAnnotation;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;


import AutomationFramework.ApplicationKeyword;
import AutomationFramework.Generickeywords;
import AutomationFramework.OR;
import funcation_PageObject.Planner;
import pageObject.PrefcardPageObject;

public class TC_CasesCosting extends ApplicationKeyword
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

			extent = new ExtentReports(folderPath+"/CasesCosting.html", true);
			// extent.addSystemInfo("Environment","Environment Name")
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}

	@Test
	public void Tc_CasesCosting_01()
	{	
		testStarts("Tc_CasesCosting_01", "Verify that \"Case Costing Report For FACILITY\" heading appears on top of page.");
		Loginpage.OpenBrowserAndLoginnew();
		Planner.plannerPageLinkandwait();
		Planner.VerifyPlannercreated();
		Planner.casesPageLinkandwait();
		String searchPlanner = getProperty("PlannerFirstName");
		typeIn(OR.Patient_searchTextBox, searchPlanner);
		clickOn(OR.PrintBarcodes_searchButton);
		Planner.complete();
		Case_Costing.navigateReport();
		Case_Costing.navigatecaseCosting();
		Case_Costing.verifyPage();
		Planner.selectFacility();
		Case_Costing.AddProcedure();
		Case_Costing.AddPhyscian();
		verifyElement(OR.Invoice_FromDate_calander);
		verifyElement(OR.Invoice_ToDate_calander);
		Case_Costing.ChartProcedure();
		Case_Costing.ChartPhy();
		Case_Costing.Header();
		Case_Costing.verifyProcedure();
		Case_Costing.SearchPaitent();
	}
			
	@AfterTest
	public void endReport(){
		closeBrowser();
		extent.flush();
	}
}
