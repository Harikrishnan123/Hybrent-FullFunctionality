package testcases_functionality;

import java.io.File;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import funcation_PageObject.Loginpage;
import funcation_PageObject.Organisation;
import funcation_PageObject.Shopcart;
import funcation_PageObject.Template;
import AutomationFramework.ApplicationKeyword;
import AutomationFramework.Generickeywords;
import AutomationFramework.OR;
import AutomationFramework._OR;

public class TC_Organization extends ApplicationKeyword
{
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
				// If you require it to make the entire directory path including parents,
				// use directory.mkdirs(); here instead.
			}

			extent = new ExtentReports(folderPath + "/organization.html", true);
			// extent.addSystemInfo("Environment","Environment Name")
			extent.addSystemInfo("User Name", "Ravneet");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) {
			System.out.println("--Start REPORT-Organization-Error---" + e.toString());
			//testLogFail("unable to generate the pass report " + e.toString());
		}
	}

	@Test
	public static void TC_Organization_001()
	{	
		testStarts("TC_Organization_001", "Verify that heading \"ORGANIZATION DETAILS\" appears on page.");
		Loginpage.OpenBrowserAndLoginnew();
		System.out.println("TC_Organization_01");
		Organisation.adminAndOrgPage();
		Organisation.verifypage();
		Organisation.SaveOrganization();
		
		
 

	} 
	@Test
	public static void TC_Organization_002()
	{	
		testStarts("TC_Organization_002", "Verify that heading \"ORGANIZATION DETAILS\" appears on page.");
		
		Organisation.adminAndOrgPage();
		Organisation.Feature();
		Organisation.subInventory();
		Organisation.subOrder();
		Organisation.subPreferencecard();
		Organisation.subTemplate();
		Organisation.subIntegrations();
		Organisation.subReseller();
		Organisation.subReplenishBin();
		
	}
	@Test
	public static void TC_Organization_003()
	{	
		testStarts("TC_Organization_003", "Update Organization > Settings > Is Item Receive In Inventory > Verify that \"Receive in inventory location\" field with inventory drop down appears in orders details for Assigned PO on front end, if \"Is Item Receive In Inventory\" is set as Active.");
		
		Organisation.adminAndOrgPage();
		Organisation.Feature();
		Organisation.ItemReceiveInventory();
		clickOn(_OR.Dashboard_Submenu_shop);
		String one = getText(OR.MyCart_count);
		int S = Integer.parseInt(one);
		testLogPass("Before adding the item to card the count is "+S);
		if(driver.findElements(By.xpath("(//*[@id='btnAdd' and contains(text(),'Add')])[1]")).size()!=0)
		{
			testLogPass("Item add button is present");
		
		clickOn(OR.Shop_SHopfor_Search_Addtocart_First);
		if(isElementDisplayed(OR.Shop_Alertvalidation))
		{
			verifyElementText(OR.Shop_Alertvalidation, "This item is not under contract or a preference item from your distributor, It may cost more.");
			clickOn(OR.MyCart_warningPopup);
		}
		}
		//else if()
			
		
	}
	
	@Test
	public static void TC_Organization_004()
	{	
		testStarts("TC_Organization_004", "Update Organization > Features > Manufacturer Level >  Verify that user is able to set Manufacturer level on per Item/Vendor Basis");
		
		clickOn(_OR.Dashboard_Submenu_shop);
		waitForElement(_OR.Dashboard_Submenu_shop);
		if(driver.findElements(By.xpath("(//hyb-highlight/span)[1]")).size()!=0)
		{
			testLogPass("Item is presnet");
		
			driver.findElement(By.xpath("(//hyb-highlight/span)[1]")).click();
			
			if(driver.findElements(By.xpath("//*[contains(text(),'MFR:')]")).size()!=0)
			{
				testLogPass("MFR: is present in item");
			}
			

			if(driver.findElements(By.xpath("//*[contains(text(),'MFR #:')]")).size()!=0)
			{
				testLogPass("MFR #: is present in item");
			}
			Organisation.adminAndOrgPage();
			clickOn(OR.organization_tab_Features);
			waitUntilPageReady();
			selectFromDropdown(OR.organization_mfr_level, "Vendor");
			WebElement save =  driver.findElement(By.xpath("//button[text()='Save']"));
			executor.executeScript("arguments[0].click();", save);
			ApplicationKeyword.OrgSettingChangerelogin();
			waitForElement(_OR.Dashboard_Submenu_shop);
			clickOn(_OR.Dashboard_Submenu_shop);
			waitForElement(_OR.Dashboard_Submenu_shop);
			clickOn(OR.Shop_ItemNameDropDown_First);
			clickOn(OR.DD_Edit);
			clickOn(OR.ItemTabVendor);
			if(driver.findElements(By.xpath("//*[contains(text(),'Mfr Number*')]")).size()!=0)
			{
				testLogPass("Mfr Number* is present in item");
			}
			

			if(driver.findElements(By.xpath("//*[contains(text(),'Manufacturer*')]")).size()!=0)
			{
				testLogPass("Manufacturer* is present in item");
			}
			clickOn(OR.ItemCatalog_Close);
			Organisation.adminAndOrgPage();
			clickOn(OR.organization_tab_Features);
			waitUntilPageReady();
			selectFromDropdown(OR.organization_mfr_level, "Item");
			WebElement save1 =  driver.findElement(By.xpath("//button[text()='Save']"));
			executor.executeScript("arguments[0].click();", save1);
			ApplicationKeyword.OrgSettingChangerelogin();
		}
		else
		{
			testLogFail("No item is presnet in the shop page");
		}
		
	}
	
	@Test
	public static void TC_Organization_005()
	{	
		testStarts("TC_Organization_005", "Update Organization > Features > Verify that user can set “Use Cross walk id as item identifier” toggle button ON/Off.");
		
		System.out.println("TC_Organization_05");
		Organisation.adminAndOrgPage();
		waitUntilPageReady();
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		Organisation.Crosswalkid();
	}
	
	@Test
	public static void TC_Organization_006()
	{	
		testStarts("TC_Organization_006", "Update Organization > Features > Item Identifier >  Verify that \"Item Identifier text\" field appear in \"Create Item page\" with label as entered in \"Item Identifier Description\" field in Organization settings");
	//	Loginpage.OpenBrowserAndLoginnew();	
		System.out.println("TC_Organization_06");
		Organisation.adminAndOrgPage();
		waitUntilPageReady();
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		Organisation.ItemIdentifier();
	}
	
	@Test
	public static void TC_Organization_007()
	{	
		testStarts("TC_Organization_007", "Update Organization > Features > Vendor Preference > Verify that Vendor Priority module appears in the Admin drop down and the items in Shop module sort on the basis of vendor priority, if \"Vendor Preference\" is set as Active.");
		Organisation.adminAndOrgPage();
		waitUntilPageReady();
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		Organisation.VendorPreference();
	}
	
	@Test
	public static void TC_Organization_008()
	{	
		testStarts("TC_Organization_008", "Update Organization > Features > Approval Required > Verify that PO is generated with “Unapproved” status by default and it needs to be approved by the user, if \"Approval Required\" is set as Active.");
		Organisation.adminAndOrgPage();
		waitUntilPageReady();
		waitForElement(OR.organization_tab_Features);
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		Organisation.ApprovalRequirement();
	}
	
	
	@Test
	public static void TC_Organization_009()
	{	
		testStarts("TC_Organization_009", "Update Organization > Features > Physician Cost Center Check > Verify that \"Physician\" drop down field does NOT appear on Cart/template/order details/Invoices page, if “Physician Cost Center Check” is set as Inactive.");
		
		Organisation.adminAndOrgPage();
		waitUntilPageReady();
		waitForElement(OR.organization_tab_Features);
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		Organisation.PhysicianCostCenterInActive();
		waitUntilPageReady();
		clickOn(OR.MyCart);
		Shopcart.Additem();
		waitUntilPageReady();
		if(driver.findElements(By.xpath("//*[contains(text(),'Attach Physician')]")).size()!=0)
		{
			testLogFail("Attach Physician is present");
		}
		else
		{
			testLogPass("Attach Physician is  not present");
		}
	}
	
	@Test
	public static void TC_Organization_010()
	{	
		testStarts("TC_Organization_010", "Update Organization > Features > Department Cost Center Check > Verify that \"Department\" drop down field appears with items on Cart/template/order details/Invoice page, if “Department Cost Center Check” is set as Active.");
		
		Organisation.adminAndOrgPage();
		waitUntilPageReady();
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		Organisation.DepartmentCostCenterActive();
		waitForElement(OR.MyCart);
		clickOn(OR.MyCart);
		waitUntilPageReady();
		Shopcart.Additem();
		waitUntilPageReady();
		if(driver.findElements(By.xpath("//*[@ng-click='selectDepartments(cartItem);']")).size()!=0)
		{
			testLogPass("Department Cost Center is present");
		}
		else
		{
			testLogFail("Department Cost Center is  not present");
		}
		Organisation.adminAndOrgPage();
		waitUntilPageReady();
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		Organisation.DepartmentCostCenterInActive();
		clickOn(OR.MyCart);
		waitUntilPageReady();
		if(driver.findElements(By.xpath("//*[@ng-click='selectDepartments(cartItem);']")).size()!=0)
		{
			testLogFail("Department Cost Center is present");
		}
		else
		{
			testLogPass("Department Cost Center is  not present");
		}
		Organisation.adminAndOrgPage();
		waitUntilPageReady();
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		Organisation.DepartmentCostCenterActive();
	}
	
	@Test
	public static void TC_Organization_011()
	{	
		testStarts("TC_Organization_011", "Update Organization > Settings > Is Vendor display Order > Verify that \"Display Priority\" module appears in Admin drop down and vendors in Vendor drop down on Shop/Orders module sort on the basis of Display Priority, if \"Is Vendor display Order\" is set as Active.");
		
		Organisation.adminAndOrgPage();
		waitUntilPageReady();
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		Organisation.IsVendordisplayActive();
		
		clickOn(OR.DashBoard_AdminDropdown);
		waitUntilPageReady();
		if(driver.findElements(By.xpath("//a[@href='#/vendors-sort']")).size()!=0)
		{
			testLogPass("Display Priority is present");
		}
		else
		{
			testLogFail("Display Priority is not present");
		}
		clickOn(OR.DashBoard_AdminDropdown);
		waitUntilPageReady();
		Organisation.adminAndOrgPage();
		waitUntilPageReady();
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		Organisation.IsVendordisplayInActive();
		waitUntilPageReady();
		clickOn(OR.DashBoard_AdminDropdown);
		waitUntilPageReady();
		
		if(driver.findElements(By.xpath("//a[@href='#/vendors-sort']")).size()!=0)
		{
			testLogFail("Display Priority is present");
		}
		else
		{
			testLogPass("Display Priority is not present");
		}
		waitUntilPageReady();
		clickOn(OR.DashBoard_AdminDropdown);
		waitUntilPageReady();
		Organisation.adminAndOrgPage();
		waitUntilPageReady();
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		Organisation.IsVendordisplayActive();
	}
	@Test
	public static void TC_Organization_012()
	{	
		testStarts("TC_Organization_012", "Update Organization > Settings > Use Price > Verify that two radio buttons, \"List Price\" and \"Contract Price\" appear with Use Price field.");
		
		Organisation.adminAndOrgPage();
		waitUntilPageReady();
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		waitUntilPageReady();
		Organisation.listcontract();

	}
	
	@Test
	public static void TC_Organization_013()
	{	
		testStarts("TC_Organization_013", "Update Organization > Features > Use My Own PO#: > Verify that \"Use my own PO\"  field appears on cart page when \"Use My Own PO#\" is set as Active");
		
		Organisation.adminAndOrgPage();
		waitUntilPageReady();
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		Organisation.UseMyPoActive();
		waitUntilPageReady();
		clickOn(OR.MyCart);
		Shopcart.Additem();
		waitUntilPageReady();
		if(driver.findElements(By.xpath("//*[@uib-tooltip='Here you can give PO # of your choice.']")).size()!=0)
		{
			testLogPass("Use My PO# is present");
		}
		else
		{
			testLogFail("Use My PO# is  not present");
		}
		Organisation.adminAndOrgPage();
		waitUntilPageReady();
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		Organisation.UseMyPoDeactive();
		clickOn(OR.MyCart);
		waitUntilPageReady();
		if(driver.findElements(By.xpath("//*[@uib-tooltip='Here you can give PO # of your choice.']")).size()!=0)
		{
			testLogFail("Use My PO# is present");
		}
		else
		{
			testLogPass("Use My PO# is  not present");
		}
		Organisation.adminAndOrgPage();
		waitUntilPageReady();
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		Organisation.UseMyPoActive();
	
	}
	
	@Test
	public static void TC_Organization_014()
	{	
		testStarts("TC_Organization_014", "Update Organization > Features > Preference Card Item Key > Verify that \"Preference Card Item Key\" drop down appears, if \"Is Preference Card On\" is set as Active.");
		
		Organisation.adminAndOrgPage();
		waitUntilPageReady();
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		Organisation.PreferedItemKeyActive();
		clickOn(OR.DashBoard_AdminDropdown);
		waitUntilPageReady();
		if(driver.findElements(By.xpath("//*[@href='#/preference-card/cards']")).size()!=0)
		{
			testLogPass("Prefecard is in admin DD");
		}
		else
		{
			testLogFail("Pref card is not in the admin dd");
		}
		clickOn(OR.DashBoard_AdminDropdown);
		Organisation.adminAndOrgPage();
		waitUntilPageReady();
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		Organisation.PreferedItemKeyInActive();
		waitUntilPageReady();
		if(driver.findElements(By.xpath("//*[@href='#/preference-card/cards']")).size()!=0)
		{
			testLogFail("Prefecard is in admin DD");
		}
		else
		{
			testLogPass("Pref card is not in the admin dd");
		}
		clickOn(OR.DashBoard_AdminDropdown);
		Organisation.adminAndOrgPage();
		waitUntilPageReady();
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		Organisation.PreferedItemKeyActive();
	}
	
	@Test
	public static void TC_Organization_015()
	{	
		testStarts("TC_Organization_015", "Update Organization > Settings > Is Default Template Items Grouped > Verify that default grouping of Template items appear if \"Is Default Template Items Grouped:\" is set as Active.");
		
		Organisation.adminAndOrgPage();
		waitUntilPageReady();
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		Organisation.DefaultActive();
		waitUntilPageReady();
		Template.NavigateTemplate();
		clickOn(OR.Templates_AddBtn);
		
		String TemplateName="Test"+randomAlphaNumeric(5);
		typeIn(OR.Templates_Name, TemplateName);
		clickOn(OR.Templates_CreateTemplate);	
		ToastmesssageSucess();
		waitUntilPageReady();
		String Attr = driver.findElement(By.xpath("//*[text()='View Group By Vendors?']/following-sibling::input")).getAttribute("class");
		if(Attr.contains("ng-not-empty"))
		{
			testLogPass("View Group By Vendors? is present");
		}
		else
		{
			testLogFail("View Group By Vendors? is not present");
		}
		Organisation.adminAndOrgPage();
		waitUntilPageReady();
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		Organisation.DefaultInActive();
		waitUntilPageReady();
		Template.NavigateTemplate();
		waitForElement(OR.Template_Edit);
		clickOn(OR.Template_Edit);
		waitUntilPageReady();
		String Attr1 = driver.findElement(By.xpath("//*[text()='View Group By Vendors?']/following-sibling::input")).getAttribute("class");
		if(Attr1.contains("ng-empty"))
		{
			testLogPass("View Group By Vendors? is not present");
		}
		else
		{
			testLogFail("View Group By Vendors? is present");
		}
		Organisation.adminAndOrgPage();
		waitUntilPageReady();
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		Organisation.DefaultActive();
	}
	
	@Test
	public static void TC_Organization_016()
	{	
		testStarts("TC_Organization_016", "Update Organization > Settings > Is price tier on > Verify that \"Price Tier Setup\" module appears in Admin dropdown if \"Is price tier on\" is set as Active.");
		
		Organisation.adminAndOrgPage();
		waitUntilPageReady();
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		Organisation.IsPriceTireActive();
		waitUntilPageReady();
		clickOn(OR.DashBoard_AdminDropdown);
		waitUntilPageReady();
		if(driver.findElements(By.xpath("//a[@href='#/admin/pricetier']")).size()!=0)
		{
			testLogPass("Price tire is present");
		}
		else
		{
			testLogFail("Price tire  is not present");
		}
		clickOn(OR.DashBoard_AdminDropdown);
		waitUntilPageReady();
		
		
		Organisation.adminAndOrgPage();
		waitUntilPageReady();
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		Organisation.IsPriceTireInactive();
		waitUntilPageReady();
		clickOn(OR.DashBoard_AdminDropdown);
		waitUntilPageReady();
		if(driver.findElements(By.xpath("//a[@href='#/admin/pricetier']")).size()!=0)
		{
			testLogFail("Price tire is present");
		}
		else
		{
			testLogPass("Price tire  is not present");
		}
		clickOn(OR.DashBoard_AdminDropdown);
		waitUntilPageReady();
		
		Organisation.adminAndOrgPage();
		waitUntilPageReady();
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		Organisation.IsPriceTireActive();
	}
	
	
	@Test
	public static void TC_Organization_017()
	{	
		testStarts("TC_Organization_017", "Update Organization > Settings > Quick Book Integration > Verify that \"Quick Book\" fields appears on User Profile page, if \"Quick Book Integration\" is set as Active. ");
		
		Organisation.adminAndOrgPage();
		waitUntilPageReady();
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		Organisation.QuickBookActive();
		waitUntilPageReady();
		clickOn(_OR.Dashboard_User);
		verifyElement(_OR.Dashboard_User_Profile);
		clickOn(_OR.Dashboard_User_Profile);
		waitUntilPageReady();
		if(driver.findElements(By.xpath("//*[contains(text(),'Quick Books:')]/following-sibling::div/img[starts-with(@src,'images/Connect_to_QuickBooks_button')]")).size()!=0)
		{
			testLogPass("Quick book connection is present");
		}
		else
		{
			testLogFail("Quick book connection is not present");
		}
		
		Organisation.adminAndOrgPage();
		waitUntilPageReady();
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		Organisation.QuickbookInactive();
		waitUntilPageReady();
		clickOn(_OR.Dashboard_User);
		verifyElement(_OR.Dashboard_User_Profile);
		clickOn(_OR.Dashboard_User_Profile);
		waitUntilPageReady();
		if(driver.findElements(By.xpath("//*[contains(text(),'Quick Books:')]/following-sibling::div/img[starts-with(@src,'images/Connect_to_QuickBooks_button')]")).size()!=0)
		{
			testLogFail("Quick book connection is present");
		}
		else
		{
			testLogPass("Quick book connection is not present");
		}
		waitUntilPageReady();
		
		Organisation.adminAndOrgPage();
		waitUntilPageReady();
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		Organisation.QuickBookActive();
	}
	
	
	@Test
	public static void TC_Organization_018()
	{	
		testStarts("TC_Organization_018", "Update Organization > Settings > Sage Intacct Integration > Verify that \"Configure Intacct\" button appears if \"Sage Intacct Integration\" is set as Active.");
		Organisation.adminAndOrgPage();
		waitForElement(OR.organization_tab_Features);
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		Organisation.SageIntacctActive();
		waitUntilPageReady();
		Organisation.adminAndOrgPage();
		waitUntilPageReady();
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		Organisation.SageIntacctInactive();
		waitUntilPageReady();
		Organisation.adminAndOrgPage();
		waitUntilPageReady();
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		Organisation.SageIntacctActive();
	}
	
	@Test
	public static void TC_Organization_019()
	{	
		testStarts("TC_Organization_019", "Update Organization > Settings > Reseller > Current organization will convert to reseller if set as Active.");
		
		Organisation.adminAndOrgPage();
		waitUntilPageReady();
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		Organisation.ResellerActive();
	}
	
	@Test
	public static void TC_Organization_020()
	{	
		testStarts("TC_Organization_020", "Update Organization > Settings > Replenish Bin >Verify that Replenish Bin module appears in the left navigation bar on Mobile devices if \"Replenish Bin\" toggle is set as active.");
		
		Organisation.adminAndOrgPage();
		waitUntilPageReady();
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		Organisation.ReplenishBinActive();
	}
	
	@Test
	public static void TC_Organization_021()
	{	
		testStarts("TC_Organization_021", "Update Organization > Settings > ADFS AUTH >Verify that Login With ADFS frame appears on Login page if ADFS AUTH toggle button is set as Active.");
		
		Organisation.adminAndOrgPage();
		waitUntilPageReady();
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		Organisation.AdfAuthActive();
		waitUntilPageReady();
		Organisation.adminAndOrgPage();
		waitUntilPageReady();
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		Organisation.AdfAuthInactive();
		waitUntilPageReady();
		Organisation.adminAndOrgPage();
		waitUntilPageReady();
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		Organisation.AdfAuthActive();
	}
	@AfterTest
	public void endReport(){
		closeBrowser();
		extent.flush();
	}	

}
