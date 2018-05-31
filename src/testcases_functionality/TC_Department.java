package testcases_functionality;

import java.io.File;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.sun.jna.platform.win32.DdemlUtil.DdemlException;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.Generickeywords;
import AutomationFramework._OR;
import AutomationFramework.OR;
import funcation_PageObject.*;
import pageObject.Alertpage;

public class TC_Department extends ApplicationKeyword{

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

			extent = new ExtentReports(folderPath+"/Department.html", true);
			extent.addSystemInfo("User Name", "QA");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}

	
	@Test
	public void Tc_Department_001() {
		testStarts("Tc_Department_001", "Verify that heading “Manage Facilities” appear on page.");
		openBrowser(Loginpage.URL);
		Loginpage.login(Loginpage.UserName, Loginpage.Password);
		Department.NavigateHometoDepartment();
		Department.verifyDepartmentPage();
	}
	
	
	@Test
	public void Tc_Department_002() {
		testStarts("Tc_Department_002", "Verify that “Add Department” pop up opens on clicking Add button.");
		openBrowser(Loginpage.URL);
		Loginpage.login(Loginpage.UserName, Loginpage.Password);
		Department.NavigateHometoDepartment();
		Department.addDepartment();
		Department.searchDept();
		Department.EditDept();
		Department.DeleteDept();
		verifyElementText(OR.ItemCat_NoRecordFoundText, "No records found");
	}
	
	@AfterTest
	public void endReport()
	{
		closeBrowser();
		extent.flush();
	}
}


