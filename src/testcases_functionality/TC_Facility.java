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

public class TC_Facility extends ApplicationKeyword{

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

			extent = new ExtentReports(folderPath+"/Facility.html", true);
			extent.addSystemInfo("User Name", "QA");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}

	
	@Test
	public void Tc_Facility_001() {
		testStarts("Tc_Facility_001", "Verify that heading “Manage Facilities” appear on page.");
		openBrowser(Loginpage.URL);
		Loginpage.login(Loginpage.UserName, Loginpage.Password);
		Facility.NavigateHometoFacility();
		Facility.CreateFacility();
		Facility.addFacilityAddress();
		Facility.addFacilityInvoiceAddress();
		Facility.verifyFacilityName();
	}
	
	@Test
	public void Tc_Facility_002() {
		testStarts("Tc_Facility_002", "Create Facility > Verify that the changes are discarded and user is redirected to “Manage Facilities” page on clicking Cancel button.");
		openBrowser(Loginpage.URL);
		Loginpage.login(Loginpage.UserName, Loginpage.Password);
		Facility.NavigateHometoFacility();
		 clickOn(OR.Facilities_Add_Btn_Facility);
		 clickOn(OR.Template_CloseBtn);
		 getTextchild("//*[@class='pagehead']");
	}
	
	@Test
	public void Tc_Facility_003() {
		testStarts("Tc_Facility_003", "Update Facility > Verify that user is able to edit all fields of facility.");
		openBrowser(Loginpage.URL);
		Loginpage.login(Loginpage.UserName, Loginpage.Password);
		Facility.NavigateHometoFacility();
		Facility.verifyFacilityName();
		
		 getTextchild("//*[@class='pagehead']");
	}
	@AfterTest
	public void endReport()
	{
		closeBrowser();
		extent.flush();
	}
}


