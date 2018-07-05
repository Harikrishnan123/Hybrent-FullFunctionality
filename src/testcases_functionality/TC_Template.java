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

public class TC_Template extends ApplicationKeyword{

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

			extent = new ExtentReports(folderPath+"/Template.html", true);
			extent.addSystemInfo("User Name", "QA");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}

	
	@Test
	public void Tc_Template_001() {
		testStarts("Tc_Template_001", "Verify that \"MY TEMPLATES\" heading appear on page");
		Loginpage.OpenBrowserAndLoginnew();
		Template.NavigateTemplate();
		Template.verifyPage();
		Template.AddTemplate();
		Template.NavigateTemplate();
		Template.searchTemplate();
		Template.EditTemplate();
		Template.Refresh();
	}
	
	@Test
	public void Tc_Template_002() {
		testStarts("Tc_Template_002", "Verify that \"Item\" and \"Schedule\" tabs appear on page.");
		//Loginpage.OpenBrowserAndLogin();
		Template.NavigateTemplate();
		Template.SearchTemplate();
		verifyElementText(OR.Template_Schedule, "Schedule");
		verifyElementText(OR.Template_Items, "Items");
		Template.Reorder();
		verifyElementText(OR.Template_Schedule, "Schedule");
		verifyElement(OR.Barcode_ItemNameTxt);
		verifyElement(OR.Barcode_SKUTxt);
		verifyElement(OR.Barcode_UOMTxt);
		verifyElement(OR.Barcode_PriceTxt);
		verifyElement(OR.Template_Qty);
		testLogPass("color is belong to "+getAttributeValue(OR.Template_Color, "uib-tooltip"));
		clickOn(OR.Vendor_Customersupport_Custom_Close);
	}
	
	@Test
	public void Tc_Template_003() 
	{
		testStarts("Tc_Template_003", "Schedule > Verify that message \"No schedule for the template\" appears when there is no schedule added.");
		//Loginpage.OpenBrowserAndLogin();
		Template.NavigateTemplate();
		Template.SearchTemplate();
		typeIn(OR.MyCart_searchInCart,getProperty("ItemtestID"));
		waitTime(2);
		if(driver.findElements(By.xpath("//*[@id='suggestions']//strong[@class='ng-binding']")).size()!=0)
		{
			if(isElementDisplayed(OR.MyCart_addItemInCart))
			{
				verifyElement(OR.MyCart_addItemInCart);
				clickOn(OR.MyCart_addItemInCart);
			}
		}
		Template.Schedule();
		Template.AddSchedule();
		Template.EditSchedule();
		Template.deleteSchedule();
	}
		
	@Test
	public void Tc_Template_004() 
	{
		testStarts("Tc_Template_004", "Schedule > Verify that message \"No schedule for the template\" appears when there is no schedule added.");
		//Loginpage.OpenBrowserAndLogin();
		Template.NavigateTemplate();
		Template.SearchTemplate1();
		 String Itemame ="ItemName#xpath=//*[text()='"+getProperty("TemplateName")+"']";
		if(driver.findElements(By.xpath("//*[text()='"+getProperty("TemplateName")+"']")).size()!=0)
		{
			clickOn(OR.Template_Edit);
		}
		Template.VendorGroup();
		Template.Reorder();

	}
	@Test
	public void Tc_Template_005() 
	{
		testStarts("Tc_Template_005", "Verify that system allows user to Use corresponding template, when user click “Use” button");
		//Loginpage.OpenBrowserAndLogin();
		Template.NavigateTemplate();
		Template.SearchTemplate1();
		getText(OR.Order_depts_dropdown);
		Template.Use();
		verifyElement(OR.Templates_Receiveonly);
		testLogPass("Facility is "+getText(OR.Template_Facility));
		Template.AttachDepart();
		verifyElement(OR.Barcode_SKUTxt);
		verifyElement(OR.Barcode_UOMTxt);
		verifyElement(OR.Barcode_PriceTxt);
		verifyElement(OR.Template_Qty);
		Template.PriceHistory();
		Template.ddEdit();
		Template.ddPriceChangeHistory();
		Template.ddPurchaseHistory();
		Template.Basic();
	}
	
	@AfterTest
	public void endReport()
	{
		closeBrowser();
		extent.flush();
	}
}


