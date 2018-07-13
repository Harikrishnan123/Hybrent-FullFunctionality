package testcases_functionality;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import funcation_PageObject.*;
import AutomationFramework.ApplicationKeyword;
import AutomationFramework.Generickeywords;
import AutomationFramework.OR;

public class TC_Planner extends ApplicationKeyword
{
	public static String fullName;
	
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

			extent = new ExtentReports(folderPath+"/planner.html", true);
			extent.addSystemInfo("User Name", "Ravneet");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));
		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}

	@Test
	public void Tc_Planner_01() throws InterruptedException
	{
		testStarts("Tc_Planner_01", "Verify that \"PLANNER FOR\" heading appears on top left side of page.");
		Loginpage.OpenBrowserAndLoginnew();
		System.out.println("Tc_Planner_01");
		Planner.plannerPageLinkandwait();
		
		Planner.CreatePlanner();
		  waitUntilPageReady();
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
	
	@Test
	public void Tc_Planner_02()
	{
		testStarts("Tc_Planner_02", "Verify that case can be created by clicking on the calendar vie.");
		NavigateUrl(DashBoardURL);
		Planner.plannerPageLinkandwait();
		Planner.Selectcases();
	}
	
	@AfterTest
	public void endReport()
	{
		closeBrowser();
		extent.flush();
	}
}
