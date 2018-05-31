package testcases_functionality;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
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

public class TC_Userprofile extends ApplicationKeyword{

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
	public void Tc_UserProfile_001() {
		testStarts("Tc_UserProfile_001", "Verify that “Email” field should accept valid email. E.g : hybrent@test.com"
				+ "Verify Admin drop down button appears on top of page.\r\n" + 
				"Verify that validation message appears if user tries to upload large size (more than 3 mb) image." );
		Loginpage.OpenBrowserAndLogin();
		waitforclick(_OR.Dashboard_User);
		clickOn(_OR.Dashboard_User);
		verifyElement(_OR.Dashboard_User_Profile);
		clickOn(_OR.Dashboard_User_Profile);
		Profile.profileverification();

		Profile.typeEmail("Test");
		verifyElementText(_OR.Dashboard_Profile_Label_Email_Validation, "Email is not a valid email address.");
		Profile.typeEmail("ankur.leekha@hybrent.com");
		clickOn(_OR.Dashboard_Profile_Btn_Update);
		waitJQueryAngular();
		isElementDisplayed(_OR.Dashboard_Profile_input_Facility);
		isElementDisplayed(_OR.Dashboard_Profile_input_Dept);
		isElementDisplayed(_OR.Dashboard_Profile_input_Inventory);
		if(driver.findElements(By.xpath("//label[text()='Quick Books:']")).size()!=0)
		{
			testLogPass("Quick Book is present");
		}
		else
		{
			clickOn(_OR.DashBoard_Admin);
			clickOn(_OR.DashBoard_Admin_organization);
			verifyPageTitle("Organization");
			waitforclick(_OR.DashBoard_Admin_organization_Features);
			clickOn(_OR.DashBoard_Admin_organization_Features);
			if(driver.findElements(By.xpath("//*[@for='quick_book_integration']//following::div[@class='bootstrap-switch-on']")).size()!=0)
			{
				testLogPass("Quick Book is already in active mode");	
			}else
			{
				WebElement dr = driver.findElement(By.xpath("//*[@for='quick_book_integration']//following::div[2]"));
				Actions builder = new Actions(driver);
				builder.moveToElement(dr).build().perform();
				dr.click();
				WebElement save = driver.findElement(By.xpath("//button[text()='Save']"));
				builder.moveToElement(save).build().perform();
				save.click();
				clickOn(_OR.Login_okay);
				waitforclick(_OR.Dashboard_User);
				clickOn(_OR.Dashboard_User);
				verifyElement(_OR.Dashboard_User_Profile);
				clickOn(_OR.Dashboard_User_Profile);
				isElementDisplayed(_OR.Dashboard_Profile_Label_QuickBook);
			}
			
		}
			
			
	}
	
	
	
	@AfterTest
	public void endReport()
	{
		closeBrowser();
		extent.flush();
	}
}


