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
import pageObject.Changepasswordpage;
import testCases.ApproveDetails;

public class TC_ApprovedPoDetails extends ApplicationKeyword{

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

			extent = new ExtentReports(folderPath+"/ApprovedPoDetails.html", true);
			extent.addSystemInfo("User Name", "QA");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}

	
	@Test
	public void Tc_ApprovedPoDetails_001() 
	{
		testStarts("Tc_ApprovedPoDetails_001", "Verify that user gets redirected to PO detail page on clicking PO number.");
		Loginpage.OpenBrowserAndLoginnew();
		ApprovePO.SearchNavigation();
		ApprovePODetails.PONumberSelection();
		ApprovePODetails.Verifydetails();
		ApprovePODetails.ChangeFacilityDepart();
	}
	
	@Test
	public void Tc_ApprovedPoDetails_002()
	{
		testStarts("Tc_ApprovedPoDetails_002", "PO detail page> Verify that the status of PO changes as per the rules set by admin user in approval flow.");
		ApprovePODetails.AddItem();
		ApprovePO.NavigateApprovedPO();
		waitForElement(OR.Receive_SearchTextBox, 60);
		typeIn(OR.Receive_SearchTextBox, getProperty("ApprovePODetailsNumber"));
		clickOn(OR.News_searchButton);
		ApprovePODetails.PODetailsNumberSelection();
		ApprovePODetails.UnappoveTOApprove();
		
	}
	
	@Test
	public void Tc_ApprovedPoDetails_003()
	{
		testStarts("Tc_ApprovedPoDetails_003", "Verify that results appears when user performs search on the basis of filters.");
		ApprovePO.SearchNavigation();
		  String PONumberselect ="PONumberSelect#xpath=//*[text()='"+getProperty("ApprovePONumber")+"']";
		   if(isElementDisplayed(PONumberselect))
			{
				clickOn(PONumberselect);
			}
		else
		{
			ApprovePO.AddItemForVerify();
		}
		   waitForElement(OR.OrderDetails_PO_Dropdown);
		   clickOn(OR.OrderDetails_PO_Dropdown);
		   int size = driver.findElements(By.xpath("//*[@class='dropdown-menu dropdown-menu-right']//li/a")).size();
			for(int i=1 ;i<=size;i++)
			{
				String j = driver.findElement(By.xpath("(//*[@class='dropdown-menu dropdown-menu-right']//li/a)["+i+"]")).getText();
				testLogPass(j);
			}
			  clickOn(OR.OrderDetails_PO_Dropdown);
		OrderDetailsPage.PrintLog();
		OrderDetailsPage.AddNotes();
		OrderDetailsPage.viewDocumentForPO();
		OrderDetailsPage.PrintItem();
		ApprovePODetails.drillAdditems();
		ApprovePODetails.IconAddNotes();
		ApprovePODetails.iconviewDocumentForPO();
	}
	
	@Test
	public void Tc_ApprovedPoDetails_004()
	{
		testStarts("Tc_ApprovedPoDetails_004", "Verify that User can approve/reject po as per  Level and Rules added in Approval flow module.");
		ApprovePO.SearchNavigation();
		  String PONumberselect ="PONumberSelect#xpath=//*[text()='"+getProperty("ApprovePONumber")+"']";
		   if(isElementDisplayed(PONumberselect))
			{
				clickOn(PONumberselect);
			}
		else
		{
			ApprovePO.AddItemForVerify();
		}
		 
		ApprovePODetails.MarkAsReceived();
		waitForElement(OR.OrderDetails_PO_Dropdown);
		clickOn(OR.OrderDetails_PO_Dropdown);
		Shopcart.Tour();
		
		//OrderDetailsPage.Refresh();
	}
	@Test
	public void Tc_ApprovedPoDetails_005()
	{
		testStarts("Tc_ApprovedPoDetails_005", "Verify that vendor address appears on mouse hover on the corresponding Vendor name hyperlink.");
		ApprovePO.SearchNavigation();
		  String PONumberselect ="PONumberSelect#xpath=//*[text()='"+getProperty("ApprovePONumber")+"']";
		   if(isElementDisplayed(PONumberselect))
			{
				clickOn(PONumberselect);
			}
		else
		{
			ApprovePO.AddItemForVerify();
		}
		 
		   mouseOver(OR.Shop_SHopfor_SelectfirstItemvendorName);
		   getText(OR.OrderDetails_infos);
		   String one = getAttributeValue(OR.Template_Color, "class").replaceAll("ng-scope ", "");
		   testLogPass("color of the item is "+one);
		   ApprovePODetails.Fav();
		   int size = driver.findElements(By.xpath("//table/thead/tr/th")).size();
			for(int i=2 ;i<=size;i++)
			{
			testLogPass(driver.findElement(By.xpath("(//table/thead/tr/th)["+i+"]")).getText());
			}
		
		
	}
	
	@AfterTest
	public void endReport()
	{
		closeBrowser();
		extent.flush();
	}
}


