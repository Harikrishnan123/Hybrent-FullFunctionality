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
import AutomationFramework.OR;
import funcation_PageObject.*;

public class TC_Order extends ApplicationKeyword{

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
			extent = new ExtentReports(folderPath+"/Order.html", true);
			extent.addSystemInfo("User Name", "QA");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}

	
	@Test
	public void TC_Order_001() {
		testStarts("TC_Order_001", "Verify that \"MY ORDERS\" label appears on top left of page.");
		Loginpage.OpenBrowserAndLoginnew();
		clickOn(OR.Order);
		OrderPage.VerifyOrder();
		String one = driver.findElement(By.xpath(".//*[@id='leftMenuScrollContainer']/ul/li[3]")).getCssValue("background").replace(" none repeat scroll 0px 0px / auto padding-box border-box", "");

		String[] numbers = one.replace("rgb(", "").replace(")", "").split(",");
		int r = Integer.parseInt(numbers[0].trim());
		int g = Integer.parseInt(numbers[1].trim());
		int b = Integer.parseInt(numbers[2].trim());
		System.out.println("r: " + r + "g: " + g + "b: " + b);
		String hex = "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);
		System.out.println(hex);
		if(hex.contains("#d2dde6"))
		{
			testLogPass("Back ground is white");
		}
		verifyPagination();
		OrderPage.SearchItem("");
		getAttributeValue(OR.Order_Search_Input, "placeholder");
		OrderPage.StatusDropdown();
		OrderPage.TypeDropdown();
		waitForElement(OR.Order);
		String FacilityName = driver.findElement(By.xpath("//*[@id='facility']//*[@class='ng-binding ng-scope']")).getText();
		String Department = driver.findElement(By.xpath("//*[@id='depts']//*[@class='ng-binding ng-scope']")).getText();
		String createdBy = driver.findElement(By.xpath("//*[@id='creater']//*[@class='ng-binding ng-scope']")).getText();
		clickOn(OR.Order);
		OrderPage.SearchItem(getProperty("GeneratePoNumber"));
		if(driver.findElements(By.xpath("//*[text()='"+getProperty("GeneratePoNumber")+"']")).size()!=0)
		{
			driver.findElement(By.xpath("//*[text()='"+getProperty("GeneratePoNumber")+"']")).click();
			waitForElement(OR.OrderDetails_PO_Dropdown);
			clickOn(OR.OrderDetails_PO_Dropdown);
			Shopcart.Tour();
			
		}
		
		clickOn(OR.OrderDetails_Close);
		String FacilityName1 = driver.findElement(By.xpath("//*[@id='facility']//*[@class='ng-binding ng-scope']")).getText();
		String Department1 = driver.findElement(By.xpath("//*[@id='depts']//*[@class='ng-binding ng-scope']")).getText();
		String createdBy1 = driver.findElement(By.xpath("//*[@id='creater']//*[@class='ng-binding ng-scope']")).getText();
		
		if(FacilityName1.contains(FacilityName)) {
			testLogPass("Facility is in selected mode when we came back from order detail page");
		}
		if(Department1.contains(Department)) {
			testLogPass("Departent is in selected mode when we came back from order detail page");
		}
		if(createdBy1.contains(createdBy)) {
			testLogPass("Creater is in selected mode when we came back from order detail page");
		}
		OrderPage.SearchItem(getProperty("SpecialGeneratePoNumber"));
		OrderPage.PrintPo();
		OrderPage.PrintItem();
		OrderPage.PrintLog();
		OrderPage.viewNotesForPO();
		OrderPage.viewDocumentForPO();
		OrderPage.SearchItem(getProperty("SpecialGeneratePoNumber"));
		OrderPage.AddInvoiceInvoice();
		OrderPage.VielAllInvoiceInvoice();
		OrderPage.DeletePo();
	}
	
	@AfterTest
	public void endReport()
	{
		closeBrowser();
		extent.flush();
	}
}


