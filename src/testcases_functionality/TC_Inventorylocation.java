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

public class TC_Inventorylocation extends ApplicationKeyword{

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

			extent = new ExtentReports(folderPath+"/InventoryLocation.html", true);
			extent.addSystemInfo("User Name", "QA");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}

	
	@Test
	public void Tc_Inventorylocation_001() {
		testStarts("Tc_Inventorylocation_001", "Verify that “Manage Inventory Locations” heading appears on top left side of page.");
		Loginpage.OpenBrowserAndLoginnew();
		Inventorylocations.NavigateHometoLocation();
		Inventorylocations.verifyPage();
		Inventorylocations.AddInvntory();
		
	}
	
	@Test
	public void Tc_Inventorylocation_002() {
		testStarts("Tc_Inventorylocation_002", "Verify that “Manage Inventory Locations” heading appears on top left side of page.");
		//Loginpage.OpenBrowserAndLoginnew();
		Inventorylocations.NavigateHometoLocation();
		typeIn(OR.InvLoc_searchTextBox, getProperty("InvetoryCreate"));
		clickOn(OR.InvLoc_Add_PlusBtn);
		testLogPass("Inventory cout is "+getText(OR.InvLoc_InventoryCount));
		verifyElementText(OR.InvLoc_InventoriesText, "Inventories");
		verifyElement(OR.InvLoc_EditFacIcon);
		verifyElement(OR.InvLoc_DeleteFacIcon);
		clickOn(OR.InvLoc_EditFacIcon);
		clickOn(OR.InvLoc_Save);
		ToastmesssageSucess();
	}
	
	@Test
	public void Tc_Inventorylocation_003() {
		testStarts("Tc_Inventorylocation_003", "Drill Down > Verify that confirmation popup appears when user clicks “Delete” button.");
		//Loginpage.OpenBrowserAndLoginnew();
		Inventorylocations.NavigateHometoLocation();
		Inventorylocations.DeleteInvntory();
	}
	
	
	
	
	@AfterTest
	public void endReport()
	{
		closeBrowser();
		extent.flush();
	}
}


