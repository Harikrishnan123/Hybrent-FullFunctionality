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

public class TC_Procedure extends ApplicationKeyword{

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

			extent = new ExtentReports(folderPath+"/Procedure.html", true);
			extent.addSystemInfo("User Name", "QA");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}

	
	@Test
	public void Tc_Procedure_001() {
		testStarts("Tc_Procedure_001", "Verify that \"Manage Procedures\" heading appears on top left side of page.");
		Loginpage.OpenBrowserAndLoginnew();
		Physicians.NavigatetoPhysicians();
		Physicians.Addphy();
		Planner.procedurePageLinkandwait();
		clickOn(OR.Procedure_AddProcedure); 
		if(getAttributeValue(OR.Procedure_SaveButton, "disabled") != null)
		{
			testLogPass("Save button is disabled");
		}
		else
		{
			testLogFail("Save button is not disabled");
		}
		String procName="Proc"+ApplicationKeyword.randomAlphaNumeric(3);
		setProperty("procName",procName);
		typeIn(OR.Procedure_addName, procName);
		typeIn(OR.Procedure_Physicians, getProperty("Procedure_FirstName"));
		clickOn(OR.Procedure_SelectPhysican1);
		String firstPhysician=getText(OR.Procedure_SelectPhysican1Label);
		setProperty("firstPhysician", firstPhysician);
		String cptCode="001"+ApplicationKeyword.randomAlphaNumeric(3);
		setProperty("cptCode",cptCode);
		typeIn(OR.Procedure_cptCode, cptCode);
		if(getAttributeValue(OR.Procedure_SaveButton, "disabled") == null)
		{
			testLogPass("Save button is enabled");
		}
		else
		{
			testLogFail("Save button is not enabled");
		}
		clickOn(OR.Procedure_SaveButton);
		waitForElementToDisplayWithoutFail(OR.Procedure_SearchTextBox, 10);
		typeIn(OR.Procedure_SearchTextBox, procName);
		
		waitTime(10);
		
		String firstElemAfterSearch=getText(OR.Procedure_firstElem);
		String finalName=firstElemAfterSearch.substring(2).trim();
		if(finalName.equals(procName))
		{
			testLogPass("Procedure is added successfully");	
		}
		else
		{
			testLogFail("Procedure is not added successfully");			
		}
	}
	
	@AfterTest
	public void endReport()
	{
		closeBrowser();
		extent.flush();
	}
}


