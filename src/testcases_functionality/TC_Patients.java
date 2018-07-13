package testcases_functionality;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import funcation_PageObject.*;
import com.relevantcodes.extentreports.ExtentReports;
import AutomationFramework.ApplicationKeyword;
import AutomationFramework.Generickeywords;
import AutomationFramework.OR;

public class TC_Patients extends ApplicationKeyword
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
				// If you require it to make the entire directory path including parents,
				// use directory.mkdirs(); here instead.
			}

			extent = new ExtentReports(folderPath+"/patients.html", true);
			// extent.addSystemInfo("Environment","Environment Name")
			extent.addSystemInfo("User Name", "Ravneet");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}
	
	@Test
	public void Tc_Patients_01()
	{
		testStarts("Tc_Patients_01", "Verify that \"Patients For FACILITY\" heading appears on top of page.");
		Loginpage.OpenBrowserAndLoginnew();		
		System.out.println("Tc_Patients_01_02");
		Planner.patientsPageLinkandwait();
		Planner.verifyPage();
		Planner.selectFacility();
		Planner.addPaitent();
		Planner.tablevalues();
		Planner.EditPaitent();
		Planner.tablevalues();
		Planner.Delete();
		
	}

    @Test
	public void Tc_Patients_02()
	{
		testStarts("Tc_Patients_02", "Verify that \"Apply Preference Card\" popup appears when user clicks Apply Preference Card button.");
	    System.out.println("Tc_Patients_02");
	    Planner.patientsPageLinkandwait();
	   Planner.addPaitent();
	    Planner.paitent_ApplyPrefcard();
	    if(driver.findElements(By.xpath("//button[contains(text(),'+')]")).size()!=0)
	    {
	    waitForElementToDisplayWithoutFail(OR.Patient_plusIcon, 10);
		String s=getText(OR.Patient_plusIcon);
		if(s.equals("+"))
		{
			testLogPass("Drill Down is present");
			Planner.PaitentHeader();
			Planner.PaitentMousover();
			Planner.VerifyPreferendCard();
			Planner.Edit();
		}
		else
		{
			testLogFail("Drill Down is not present");

		}
	    }
	    else
	    {
	    	Planner.addPaitentwithoutClose();
	    	String s=getText(OR.Patient_plusIcon);
			if(s.equals("+"))
			{
				testLogPass("Drill Down is present");
				Planner.PaitentHeader();
				Planner.PaitentMousover();
				Planner.VerifyPreferendCard();
				Planner.Edit();
			}
			else
			{
				testLogFail("Drill Down is not present");

			}
	    }
	}
	@AfterTest
	public void endReport()
	{
		closeBrowser();
		extent.flush();
	}




}
