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

public class TC_Cases extends ApplicationKeyword
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

			extent = new ExtentReports(folderPath+"/case.html", true);
			// extent.addSystemInfo("Environment","Environment Name")
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}

	@Test
	public void Tc_Cases_01()
	{	
		testStarts("Tc_Cases_01", "Verify that \"Cases for FACILTY\" heading appears on top of page.");
		Loginpage.OpenBrowserAndLoginnew();
		Planner.plannerPageLinkandwait();
		Planner.VerifyPlannercreated();
		Planner.casesPageLinkandwait();
		Planner.CasesVerify();
		Planner.EditCases();
		Planner.Print();
		Planner.selectFacility();

	}	

	@Test
	public void Tc_Cases_02()
	{
		testStarts("Tc_Cases_02", "Verify that Case preview page open when user clicks on Print.");
		NavigateUrl(DashBoardURL);			
		PrefcardPageObject.casesPageLinkandwait();
		selectFromDropdown(OR.Cases_SelectDateDropDown, "-- All Dates --");
		clickOn(OR.Cases_SearchButton);
		//waitTime(4);
		waitForElementToDisplayWithoutFail(OR.Cases_Printbutton, 10);
		clickOn(OR.Cases_Printbutton);
		verifyElementText(OR.Cases_PreviewPopUp, "Download case");
	}
			
	@AfterTest
	public void endReport(){
		closeBrowser();
		extent.flush();
	}
}
