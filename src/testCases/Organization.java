package testCases;

import java.io.File;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import pageObject.Loginpage;
import AutomationFramework.ApplicationKeyword;
import AutomationFramework.Generickeywords;
import AutomationFramework.OR;

public class Organization extends ApplicationKeyword
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

			extent = new ExtentReports(folderPath + "/organization.html", true);
			// extent.addSystemInfo("Environment","Environment Name")
			extent.addSystemInfo("User Name", "Ravneet");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) {
			System.out.println("--Start REPORT-Organization-Error---" + e.toString());
			//testLogFail("unable to generate the pass report " + e.toString());
		}
	}

	@Test
	public static void TC_ORG_01()
	{	
		testStarts("TC_ORG_01_02_03_04", "Verify that Organization Details page appears when user clicks on organization option in admin dropdown.");
		Loginpage.OpenBrowserAndLogin();
		System.out.println("TC_ORG_01");
		clickOn(OR.DashBoard_AdminDropdown);
		verifyElementText(OR.orgsetting_AdminMenuText, "Admin");		 
		clickOn(OR.Shop_orgpage);
		waitForElementToDisplayWithoutFail(OR.orgsetting_orgPageTextt, 10);
		verifyPageTitle("Organization");
		verifyElementText(OR.orgsetting_orgPageTextt, "ORGANIZATION DETAILS");		 
		clickOn(OR.Shop_orgFeatures2Page); 
		waitForElementToDisplayWithoutFail(OR.orgsetting_orgFeaturesPageText, 10);
		verifyElementText(OR.orgsetting_orgFeaturesPageText,"INVENTORY");
		clickOn(OR.DashBoard_AdminDropdown);
		clickOn(OR.orgsetting_orgBudgetPage);
		waitForElementToDisplayWithoutFail(OR.orgsetting_orgBudgetPageText, 10);
		verifyPageTitle("Organization");
		//System.out.println(getText(OR.orgsetting_orgBudgetPageText));
		//		waitTime(4);
		waitForElementToDisplayWithoutFail(OR.orgsetting_orgBudgetPageText, 10);
		verifyElementText(OR.orgsetting_orgBudgetPageText, "MANAGE ORGANIZATION BUDGET");		 

	} 

	@AfterTest
	public void endReport(){
		closeBrowser();
		extent.flush();
	}	

}
