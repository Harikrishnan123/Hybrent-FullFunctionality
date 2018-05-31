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

public class TC_GL_Codes extends ApplicationKeyword{

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

			extent = new ExtentReports(folderPath+"/Glcode.html", true);
			extent.addSystemInfo("User Name", "QA");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}

	
	@Test
	public void Tc_Gl_Code_001() {
		testStarts("Tc_Gl_Code_001", "Verify that heading “Manage GL Codes” appear on page.");
		openBrowser(Loginpage.URL);
		Loginpage.login(Loginpage.UserName, Loginpage.Password);
		GlCode.NavigateToGlcode();
		GlCode.verifyPage();
		GlCode.AddGlCode();
		
	}
	
	@Test
	public void Tc_Gl_Code_002() {
		testStarts("Tc_Gl_Code_002", "Edit GL Code > Verify that user is able to edit all fields of GL Code.");
		GlCode.NavigateToGlcode();
		GlCode.Edit();
	}
	@Test
	public void Tc_Gl_Code_003() {
		testStarts("Tc_Gl_Code_003", "Edit GL Code > Verify that user is able to edit all fields of GL Code.");
		GlCode.NavigateToGlcode();
		GlCode.Delete();
	}
	
	@AfterTest
	public void endReport()
	{
		closeBrowser();
		extent.flush();
	}
}


