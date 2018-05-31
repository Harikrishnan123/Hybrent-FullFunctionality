package testcases_functionality;

import java.io.File;
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

public class TC_Shop extends ApplicationKeyword{

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

			extent = new ExtentReports(folderPath+"/shop.html", true);
			extent.addSystemInfo("User Name", "QA");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}

	
	@Test
	public void Tc_Shop_001() {
		testStarts("Tc_Shop_001", "Verify that \"Shopping For Facility Name\" label appears on top left of page.");
		Loginpage.OpenBrowserAndLoginnew();
		clickOn(_OR.Dashboard_Submenu_shop);
		Shop.verifyShop();
		//Shop.autosearch();
		//Shop.verifyselectedFacdisable();
		//Shop.Search("tes");
	//	verifyElement(OR.Shop_VendorSelect);
		Shop.Vendorlisverification();
		//clickOn(OR.HeaderClose);
	}
	
	@Test
	public void Tc_Shop_002() {
		testStarts("Tc_Shop_002", "Verify that \"Shopping For Facility Name\" label appears on top left of page.");
		Loginpage.OpenBrowserAndLoginnew();
		Shop.Organiationchange();
		Shop.Grid();
		Shop.MenuList();
		clickOn(OR.Shop_SHopfor_MostOrderedradiobutton);
		Shop.MenuList();
		clickOn(OR.Shop_SHopfor_RecentlyOrderedradiobutton);
		Shop.MenuList();
		clickOn(OR.Shop_SHopfor_FavOrderedradiobutton);
		Shop.MenuList();
	}
	
	
	
	
	@AfterTest
	public void endReport()
	{
		closeBrowser();
		extent.flush();
	}
}


