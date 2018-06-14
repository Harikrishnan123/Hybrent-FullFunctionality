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

public class TC_Dashboard extends ApplicationKeyword{

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

			extent = new ExtentReports(folderPath+"/dashboard.html", true);
			extent.addSystemInfo("User Name", "QA");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}


	@Test
	public void Tc_Dashboard_001() {
		testStarts("Tc_Dashboard_001", "Verify Menu options (as per permission to the user in Admin section) present below organization logo with list as follows:\n"
				+ "Verify Admin drop down button appears on top of page.\r\n" + 
				"" );
		Loginpage.OpenBrowserAndLoginnew();
		verifyElement(_OR.Dashboard_Submenu_Dashboard);
		verifyElement(_OR.Dashboard_Submenu_shop);
		verifyElement(_OR.Dashboard_Submenu_Orders);
		verifyElement(_OR.Dashboard_Submenu_Requestservices);
		verifyElement(_OR.Dashboard_Submenu_OrderApprove);
		verifyElement(_OR.Dashboard_Submenu_Receive);
		verifyElement(_OR.Dashboard_Submenu_shipments);
		verifyElement(_OR.Dashboard_Submenu_invoice);
		verifyElement(_OR.Dashboard_Submenu_templates);
		
		verifyElement(_OR.Dashboard_Submenu_Scanout);
		verifyElement(_OR.Dashboard_Submenu_Manageinventory);
		verifyElement(_OR.Dashboard_Submenu_Planner);
		verifyElement(_OR.Dashboard_Submenu_cases);
		verifyElement(_OR.Dashboard_Submenu_patients);
		verifyElement(_OR.Dashboard_Submenu_procedures);
		verifyElement(_OR.Dashboard_Submenu_Prederedcard);
		verifyElement(_OR.Dashboard_Submenu_operating_rooms);
		verifyElement(_OR.Dashboard_Submenu_Report);
		verifyElement(_OR.Dashboard_Submenu_News);
			getText(_OR.Dashboard_version);
			verifyElement(_OR.Dashboard_PoweredBy);
			verifyElement(_OR.Dashboard_HybrentLogo);
	}
	
	@Test
	public void Tc_Dashboard_002() {
		testStarts("Tc_Dashboard_002", "Verify Menu options (as per permission to the user in Admin section) present below organization logo with list as follows:\n"
				+ "Verify Admin drop down button appears on top of page.\r\n" + 
				"" );
			clickOn(_OR.DashBoard_Admin);
			verifyElement(_OR.DashBoard_Admin_organization);
			verifyElement(_OR.DashBoard_Admin_organizationbudget);
			verifyElement(_OR.DashBoard_Admin_facility);
			verifyElement(_OR.DashBoard_Admin_department);
			verifyElement(_OR.DashBoard_Admin_physicians);
			verifyElement(_OR.DashBoard_Admin_approvals);
			verifyElement(_OR.DashBoard_Admin_manufacturers);
			verifyElement(_OR.DashBoard_Admin_glcode);
			verifyElement(_OR.DashBoard_Admin_ponumber);
			verifyElement(_OR.DashBoard_Admin_pattern);
			verifyElement(_OR.DashBoard_Admin_ponumber);
			verifyElement(_OR.DashBoard_Admin_po_special_instructions);
			verifyElement(_OR.DashBoard_Admin_invoicepaymentservice);
			verifyElement(_OR.DashBoard_Admin_news);
			verifyElement(_OR.DashBoard_Admin_vendor);
			verifyElement(_OR.DashBoard_Admin_vendoraccountsetup);
			verifyElement(_OR.DashBoard_Admin_pricetier);
			verifyElement(_OR.DashBoard_Admin_Search_Priority);
			verifyElement(_OR.DashBoard_Admin_DisplayPriority);
			verifyElement(_OR.DashBoard_Admin_items_catalog);
			verifyElement(_OR.DashBoard_Admin_inventory_locations);
			verifyElement(_OR.DashBoard_Admin_inventory_item_transaction);
			verifyElement(_OR.DashBoard_Admin_items_categories);
			verifyElement(_OR.DashBoard_Admin_print_barcodes_qrcodes);
			verifyElement(_OR.DashBoard_Admin_integration);
			verifyElement(_OR.DashBoard_Admin_Hybrent_Apis);
			waitForElementToDisplay(_OR.Dashboard_User, 10);
			clickOn(_OR.Dashboard_User);
			verifyElement(_OR.Dashboard_User_Profile);
			verifyElement(_OR.Dashboard_User_NotificationSetting);
			verifyElement(_OR.Dashboard_User_alert);
			verifyElement(_OR.Dashboard_User_Survey);
			verifyElement(_OR.Dashboard_User_ChangePassword);
			verifyElement(_OR.Dashboard_User_SwitchUser);
			waitForElementToDisplay(_OR.Dashboard_User_NotificationSetting, 10);
			waitForElementToDisplay(_OR.Dashboard_User_Profile, 10);
			clickOn(_OR.Dashboard_User_Profile);
			Profile.profileverification();
			clickOn(_OR.Dashboard_User);
			clickOn(_OR.Dashboard_User_NotificationSetting);
			Dashboard.verificationNotificationPage();
			clickOn(_OR.Dashboard_User);
			waitForElementToDisplay(_OR.Dashboard_User_alert, 60);
			clickOn(_OR.Dashboard_User_alert);
			Alert.VerifyAlert();
			clickOn(_OR.Dashboard_User);
			clickOn(_OR.Dashboard_User_Survey);
			SurveyPage.VerifySurvey();
			waitForElementToDisplay(_OR.Dashboard_User, 60);
			waitforclick(_OR.Dashboard_User);
			clickOn(_OR.Dashboard_User);
			waitforclick(_OR.Dashboard_User_ChangePassword);
			clickOn(_OR.Dashboard_User_ChangePassword);
			Changepasswordpage.VerifyChangePassword();
			waitForElement(OR.Notification_Bell, 60);
			clickOn(OR.Notification_Bell);
			Dashboardpage.NotificationCount();
			Dashboardpage.DeleteNotification();
			clickOn(OR.Notification_Btn_Refresh);
	}
	
	@Test
	public void Tc_Dashboard_003() 
	{
		testStarts("Tc_Dashboard_003", "Verify that “Shopping Cart” icon/ button appear on top right of page.\r\n"
				+ "Verify  that User Profile image & button appear on top right of page.\r\n" + 
				"");
		clickOn(_OR.Dashboard_Submenu_Dashboard);
		verifyElement(OR.MyCart);
		getText(OR.MyCart_count);
		getAttributeValue(OR.MyCart_count, "values");
		verifyElement(_OR.user_top_Img);
		Chat.VerifyChatPage();
		clickOn(OR.Chat_close);
		clickOn(_OR.Dashboard_Submenu_Dashboard);
//		clickOn(_OR.Dashboard_ActionDropdown);
//		clickOn(_OR.Dashboard_ActionDropdown_ShowTour);
//		getText(_OR.Dashboard_ShowTour_welcome);
//		verifyElement(_OR.Dashboard_ShowTour_Next);
//		clickOn(_OR.Dashboard_ShowTour_EndTour);
		clickOn(_OR.Dashboard_Submenu_Dashboard);
		Reportspage.VerifyViewReport();
		clickOn(_OR.Dashboard_Submenu_Dashboard);
		Dashboardpage.MonthlyReport();
		Dashboardpage.PartialReviews();
		Dashboardpage.Avgperformance();
		clickOn(_OR.Dashboard_Submenu_Dashboard);
		Dashboardpage.partialOrderverifystatus();
	}
	
	@Test
	public void Tc_Dashboard_004() 
	{
		testStarts("Tc_Dashboard_004", "Verify that latest 5 purchase orders appear under Recent Orders.\r\n"
				+"Verify that “News & Events” section appear at bottom right side of Dashboard Page.\r\n" + 
				"");
		clickOn(_OR.Dashboard_Submenu_Dashboard);
		Dashboardpage.PartialReviews();
		Dashboardpage.Avgperformance();
		Dashboardpage.VerifyOrders();

		clickOn(_OR.Dashboard_Submenu_Dashboard);
		getText(_OR.Dashboard_Recent_Orders);
		getText(OR.Shop_SHopfor_SelectfirstItemvendorName);
		int size = driver.findElements(By.xpath("(//*[@id='reqListing']//a)")).size();
		for(int i=1 ;i<=size;i++)
		{
			String GetOrder = driver.findElement(By.xpath("(//*[@id='reqListing']//a)["+i+"]")).getText();
			 driver.findElement(By.xpath("(//*[@id='reqListing']//a)["+i+"]")).click();
			clickOn(_OR.Dashboard_Submenu_Orders);
			clickOn(OR.Order_Vendor_dropdown);
			clickOn(_OR.Order_All);
			clickOn(OR.Order_status_dropdown);
			clickOn(_OR.Order_All);
			clickOn(OR.Order_type_dropdown);
			clickOn(_OR.Order_All);
			clickOn(OR.Order_FacilityDropDown);
			clickOn(_OR.Order_All);
			clickOn(OR.Order_depts_dropdown);
			clickOn(_OR.Order_All);
			clickOn(OR.Order_creater_dropdown);
			clickOn(_OR.Order_All);
			typeIn(OR.Order_Search_Input, GetOrder);
			clickOn(OR.Order_PO_SearchBtn);
			if(driver.findElements(By.xpath("(//*[@ng-repeat='order in ordersData.purchaseOrders']//a)["+i+"]")).size()!=0)
			{
				testLogPass("Order is presnt");
			}else
			{
				testLogFail("Order is Not presnt");
			}
			clickOn(_OR.Dashboard_Submenu_Dashboard);
		}
		Dashboardpage.News();
		}
	
	@AfterTest
	public void endReport()
	{
		closeBrowser();
		extent.flush();
	}
}


