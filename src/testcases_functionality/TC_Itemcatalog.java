package testcases_functionality;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import AutomationFramework.ApplicationKeyword;
import AutomationFramework.Generickeywords;
import AutomationFramework.OR;
import AutomationFramework._OR;
import funcation_PageObject.*;
import pageObject.Alertpage;
import pageObject.ApprovePO_PageObject;
import pageObject.Changepasswordpage;
import pageObject.Dashboardpage;
import pageObject.MycartPage;
import pageObject.OrderPage;
import pageObject.ProfilePage;
import pageObject.Reportspage;
import pageObject.SurveyPage;

public class TC_Itemcatalog extends ApplicationKeyword{

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

			extent = new ExtentReports(folderPath+"/itemcatalog.html", true);
			extent.addSystemInfo("User Name", "QA");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}

	@Test
	public void Tc_Itemcatalog_001() {
		testStarts("Tc_Itemcatalog_001", "Verify that \"Item Catalog\" heading appears on top left side of the page.");
		String invalidItem = "!@#$%^&*()fghjklhjkkjhjfndfkdf";
		Loginpage.OpenBrowserAndLoginnew();
		Itemcatalog.NavigatetoItemcatalog();
		Itemcatalog.verifytypeDropdown();
		Itemcatalog.verifyStatusDropdown();
		Itemcatalog.verifyNoItemfound(invalidItem);
	}
	
	@Test
	public void Tc_Itemcatalog_002() {
		testStarts("Tc_Itemcatalog_002", "Verify that User can only Add/Edit items if he/she has access to Add/Edit items in 'Inventory Catalog access' in User profile.");
		//Loginpage.OpenBrowserAndLoginnew();
		Itemcatalog.NavigatetoItemcatalog();
		Itemcatalog.addNewItem();
	}
	
	@Test
	public void Tc_Itemcatalog_003() {
		testStarts("Tc_Itemcatalog_003", "Verify that Edit Item popup appears when user clicks Edit button for corresponding item.");
		Itemcatalog.NavigatetoItemcatalog();
		Itemcatalog.EditItem();
	}
	
	@Test
	public void Tc_Itemcatalog_004() {
		testStarts("Tc_Itemcatalog_004", "Verify that user can search facilities by their name.");
		//Loginpage.OpenBrowserAndLoginnew();
		//Loginpage.OpenBrowserAndLogin();
		Itemcatalog.NavigatetoItemcatalog();
		Itemcatalog.EditMapFacility();
		Itemcatalog.Map();
		getText(OR.ItemCatalog_AddItem_Map_Header);
		waitForElementToDisplayWithoutFail(OR.ItemCatalog_AddItem_Map_Closepage, 10);	
		clickOn(OR.ItemCatalog_AddItem_Map_Closepage);		
	}
	@Test
	public void Tc_Itemcatalog_005() {
		testStarts("Tc_Itemcatalog_005", "Verify that user can search facilities by their name.");
		//Loginpage.OpenBrowserAndLoginnew();
		Itemcatalog.NavigatetoItemcatalog();
		Itemcatalog.CLoseMap();
		waitForElementToDisplayWithoutFail(OR.ItemCatalog_AddItem_Map_Closepage, 10);	
		clickOn(OR.ItemCatalog_AddItem_Map_Closepage);	
	}
	
	@AfterTest
	public void endReport()
	{
		closeBrowser();
		extent.flush();
	}
}


