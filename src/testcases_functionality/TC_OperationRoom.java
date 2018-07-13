package testcases_functionality;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

public class TC_OperationRoom extends ApplicationKeyword{

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

			extent = new ExtentReports(folderPath+"/OperationRoom.html", true);
			extent.addSystemInfo("User Name", "QA");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}

	
	@Test
	public void TC_OperationRoom_001() {
		testStarts("TC_OperationRoom_001", "Verify that “Manage Inventory Locations” heading appears on top left side of page.");
		Loginpage.OpenBrowserAndLoginnew();
		OperationRoom.navigateOperationRoom();
		OperationRoom.Verifypage();
		OperationRoom.AddOperationRoom();
		OperationRoom.Search(getProperty("OPerationRoom"));
		OperationRoom.EditOperationRoom(getProperty("OPerationRoom"));
		OperationRoom.Search(getProperty("OPerationRoom"));
		OperationRoom.Delete(getProperty("OPerationRoom"));
		
	}
	@Test
	public void TC_OperationRoom_002() {
		testStarts("TC_OperationRoom_002", "Verify that “Manage Inventory Locations” heading appears on top left side of page.");
		OperationRoom.navigateOperationRoom();
		waitForElement(OR.OP_CreatenewOP);
		clickOn(OR.OP_CreatenewOP);
		String opRoom="OPeration"+ApplicationKeyword.randomAlphaNumeric(5);
		setProperty("OPerationRoom", opRoom);
		typeIn(OR.OP_OpName, opRoom);
		clickOn(OR.OP_FacilityDropDown);		
		String fact = getProperty("UserAddfailityName");
		if(isElementDisplayed(OR.OP_FacilityInput))
		{
			typeIn(OR.OP_FacilityInput, fact);
		}
		
		verifyElement(OR.csManufacture_Close);
		WebElement elem2=driver.findElement(By.xpath("//*[@class='ui-select-choices-row-inner']//*[text()='"+fact+"']"));
		elem2.click();

		clickOn(OR.OP_disabledSaveButton);
		ToastmesssageSucess();
		
	}
	@AfterTest
	public void endReport()
	{
		closeBrowser();
		extent.flush();
	}
}


