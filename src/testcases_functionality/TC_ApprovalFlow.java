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

public class TC_ApprovalFlow extends ApplicationKeyword{

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
			extent = new ExtentReports(folderPath+"/ApprovalFlow.html", true);
			extent.addSystemInfo("User Name", "QA");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}

	
	@Test
	public void TC_ApprovalFlow_001() {
		testStarts("TC_ApprovalFlow_001", "Verify that user gets redirected to \"User Alert\" page when clicks on \" Alert\" button.");
		Loginpage.OpenBrowserAndLoginnew();
		ApprovalFlow.NavigateToApprovalflow();
		ApprovalFlow.NoSearch();
		ApprovalFlow.AddTemplate(getProperty("UserAddfailityName"));
	}
	
	@Test
	public void TC_ApprovalFlow_002()
	{
		testStarts("TC_ApprovalFlow_002", "Template details > Verify that text \"APPROVAL FLOW\" with Template name appears on top of the page");
		ApprovalFlow.NavigateToApprovalflow();
		ApprovalFlow.NoAddTemplate();
		ApprovalFlow.SearchFlow(getProperty("NOTemplateName"));
		clickOn(OR.ApprovalFlow_First_ManageFlow);
		verifyElementText(OR.Approvalflow_MangeFlow_NoLevel, "No level is added to this template");
	}
	
	@Test
	public void TC_ApprovalFlow_003()
	{
		testStarts("TC_ApprovalFlow_003", "Template details > Verify that text \"APPROVAL FLOW\" with Template name appears on top of the page");
		//Loginpage.OpenBrowserAndLoginnew();
		ApprovalFlow.NavigateToApprovalflow();
		ApprovalFlow.SearchFlow(getProperty("TemplateName"));
		ApprovalFlow.MangeFlow();
		ApprovalFlow.EditLevel();
	}
	
	@Test
	public void TC_ApprovalFlow_004()
	{
		testStarts("TC_ApprovalFlow_004", "Template details > Levels > Add Rule > Verify that Add Rule popup appears if user clicks on Add rule link");
		ApprovalFlow.NavigateToApprovalflow();
		ApprovalFlow.SearchFlow(getProperty("TemplateName"));
		clickOn(OR.ApprovalFlow_First_ManageFlow);
		ApprovalFlow.AddRules();
		ApprovalFlow.DeleteRule();
	}
	
	@Test
	public void TC_ApprovalFlow_005()
	{
		testStarts("TC_ApprovalFlow_005", "Verify that Edit Template popup appears when user clicks on \"Manage Facilities\" button");
		ApprovalFlow.NavigateToApprovalflow();
		ApprovalFlow.SearchFlow(getProperty("TemplateName"));
		ApprovalFlow.MangeFacility();
		ApprovalFlow.Delete();
	}
	
	@AfterTest
	public void endReport()
	{
		closeBrowser();
		extent.flush();
	}
}


