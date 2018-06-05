package testcases_functionality;

import java.io.File;

import org.openqa.selenium.By;
import org.python.jline.internal.TestAccessible;
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

public class TC_ShopCart extends ApplicationKeyword{

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
			extent = new ExtentReports(folderPath+"/Shopcart.html", true);
			extent.addSystemInfo("User Name", "QA");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}

	
	@Test
	public void TC_ShopCart_001() {
		testStarts("TC_ShopCart_001", "Verify that same facility appears selected at top which was selected on shop at the time of checkout.");
		Loginpage.OpenBrowserAndLoginnew();
		Shopcart.VerifyPage();
		Shopcart.matchFac();
		Shopcart.CartMore();
	}
	
	@Test
	public void TC_ShopCart_002() {
		testStarts("TC_ShopCart_002", "Show Tour > Verify that in each tour section, description for the highlighted section appears correct.");
		Shopcart.VerifyPage();
		typeIn(OR.MyCart_searchInCart, "dhsjhfjhjfhjfhdjfh");
		waitForElement(OR.MyCart_cartFor_NoElementFound);
		verifyElementText(OR.MyCart_cartFor_NoElementFound, "NO ITEMS FOUND.");
		typeIn(OR.MyCart_searchInCart, "");
		Shopcart.vendor();
	}
	
	@Test
	public void TC_ShopCart_003() {
		testStarts("TC_ShopCart_003", "Verify that Vendor Account Setup page gets opened when user clicks \" Account Setup\"");
		//Loginpage.OpenBrowserAndLoginnew();
		//Shopcart.VerifyPage();
		waitForElement(OR.MyCart);
		clickOn(OR.MyCart);
		String beforeadd = getText(OR.MyCart_count);
		int countitem =Integer.parseInt(beforeadd);
    	if(countitem==0)
    	{
    		Shopcart.Additem();
    	}
		Shopcart.AccountSetup();
	}
	
	@Test
	public void TC_ShopCart_004() {
		testStarts("TC_ShopCart_004", "Verify that Vendor Account Setup page gets opened when user clicks \" Account Setup\"");
		Loginpage.OpenBrowserAndLoginnew();
		clickOn(OR.MyCart);
		Shopcart.Price();		
    	verifyElement(OR.MyCart_Receiveonly);
    	verifyElement(OR.MyCart_ReceiveonlyCheckbox);
		clickOn(OR.MyCart_drillDownVendor);
    	verifyElement(OR.MyCart_accountSetUp);
    	clickOn(OR.MyCart_accountSetUp);
    	getTextchild("//*[@class='pagehead']");

	}
	
	@AfterTest
	public void endReport()
	{
		closeBrowser();
		extent.flush();
	}
}


