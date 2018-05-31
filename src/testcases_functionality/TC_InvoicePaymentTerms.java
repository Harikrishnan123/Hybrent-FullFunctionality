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

public class TC_InvoicePaymentTerms extends ApplicationKeyword{

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

			extent = new ExtentReports(folderPath+"/InvoicePaymentTerms.html", true);
			extent.addSystemInfo("User Name", "QA");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}

	
	@Test
	public void Tc_InvoicePaymentTerms_001() {
		testStarts("Tc_InvoicePaymentTerms_001", "Verify that “Manage Invoice Payment Terms” heading appears on top left side of page.");
		openBrowser(Loginpage.URL);
		Loginpage.login(Loginpage.UserName, Loginpage.Password);
		InvoicePaymentTerms.NavigateToInvoicePaymentTerms();
		InvoicePaymentTerms.AddPayment();
	}
	
	@Test
	public void Tc_InvoicePaymentTerms_002() {
		testStarts("Tc_InvoicePaymentTerms_002", "Add Payment Term > Verify that validation message appears for field, if user tries to save Payment Term with invalid data.");
		openBrowser(Loginpage.URL);
		Loginpage.login(Loginpage.UserName, Loginpage.Password);
		InvoicePaymentTerms.NavigateToInvoicePaymentTerms();
		InvoicePaymentTerms.Duplicate();
	}
	
	@AfterTest
	public void endReport()
	{
		closeBrowser();
		extent.flush();
	}
}



