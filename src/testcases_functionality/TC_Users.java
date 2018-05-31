package testcases_functionality;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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

public class TC_Users extends ApplicationKeyword{

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

			extent = new ExtentReports(folderPath+"/Users.html", true);
			extent.addSystemInfo("User Name", "QA");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}


	@Test
	public void Tc_User_001() {
		testStarts("Tc_User_001", "Verify that heading “Manage User's” appear on page.\r\n" + 
				""
				+ "Verify Admin drop down button appears on top of page.\r\n" + 
				"" );
		openBrowser(Loginpage.URL);	
		//Loginpage.ADFS_link();
		Loginpage.login(Loginpage.UserName, Loginpage.Password);
		User.adminAndUserPage();
		User.verifyUserpage();
		User.verifyUserpage();
		User.verify_Dropdown_status();
	}
	
	@Test
	public void Tc_User_002() {
		testStarts("Tc_User_002", "Verify that heading “Manage User's” appear on page.\r\n" + 
				""
				+ "Verify Admin drop down button appears on top of page.\r\n" + 
				"" );
		//Loginpage.ADFS_link();
		User.adminAndUserPage();
		User.verifyUserpage();
		User.verifyUserpage();
		User.verify_Dropdown_status();
		User.createUser();
		User.userAddFacility();
		User.userAccessTab();
		User.Itemcatalogacesstab();
		User.selectFacility();
		User.Addvendor();
		String one = getAttributeValue(_OR.user_addUser_Save,"ng-disabled");
		if(one.contains("user.$invalid"))
		{
			clickOn(_OR.user_addUser_Save);
			
		}
		else
		{
			System.out.println("Save button is disable");
		}
		WebElement element = driver.findElement(By.xpath("//*[@class='logout' and last()]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		// actions.click();
		actions.perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(250,350)");
		clickOn(_OR.Logout);
		clickOn(_OR.Label_signinnewuser);
		//Loginpage.ADFS_link();

			Loginpage.login(getProperty("created_NeUser"), getProperty("created_NewPassword"));
		Changepassword.UserChangepassword();
		if(isElementDisplayed(_OR.Label_signinnewuser))
		{
			clickOn(_OR.Label_signinnewuser);
			Loginpage.login(getProperty("created_NeUser"), getProperty("updated_NewPassword"));
		}
		else
		{
			Loginpage.login(getProperty("created_NeUser"), getProperty("updated_NewPassword"));
		}
		User.Terms();
		//waitTime(10);
		waitForElementToDisplay(_OR.Dashboard_Submenu_Dashboard, 60);
		clickOn(_OR.Dashboard_Submenu_Dashboard);
	}
	

	
	@AfterTest
	public void endReport()
	{
		closeBrowser();
		extent.flush();
	}

}


