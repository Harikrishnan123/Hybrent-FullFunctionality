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

public class Testm extends ApplicationKeyword{

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

			extent = new ExtentReports(folderPath+"/Alert.html", true);
			extent.addSystemInfo("User Name", "QA");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}

	
	@Test
	public void Tc_Test_001() {
		testStarts("Tc_Test_001", "Verify that user gets redirected to \"User Alert\" page when clicks on \" Alert\" button.");
		openBrowser(Loginpage.URL);
		Loginpage.login(Loginpage.UserName, Loginpage.Password);
		User.adminAndUserPage();
		typeIn(OR.Facilty_SearchBox, "13 Feb");
		clickOn(OR.News_searchButton);
		waitForElement(OR.ItemcaCategory_Edit);
		clickOn(OR.ItemcaCategory_Edit);
		waitForElement(_OR.user_addUser_FacilityAccess);
		 clickOn(_OR.user_addUser_FacilityAccess);
		 
		 clickOn(OR.Pagination_Last);
		 String GetTextLAST = driver.findElement(By.xpath("(//*[@class='pagination-page ng-scope active']/a)[1]")).getText();
		 int ConvertLAstText =Integer.parseInt(GetTextLAST);
		 
		 
		 for(int j =1 ;j<=ConvertLAstText;j++)
		 {
			 clickOn(OR.Pagination_First);
			 int sizeOfEdit = driver.findElements(By.xpath("//label[text()='Edit PO']/following-sibling::div/input")).size();
			 for(int i=1 ;i<=sizeOfEdit;i++)
			 {
				 driver.findElement(By.xpath("(//label[text()='Edit PO']/following-sibling::div/input)["+i+"]")).click();
			 }
			 
			 
			 if(driver.findElements(By.xpath("//*[@class=\"pagination-next ng-scope disabled\"]")).size()!=0)
			 {
				 
			 }else if(driver.findElements(By.xpath("(//*[@ class='pagination-page ng-scope']/a)["+j+"]")).size()!=0)
			 {
				 driver.findElement(By.xpath("(//*[@ class='pagination-page ng-scope']/a)["+j+"]")).click();
			 }
				 
		 }
	}
	
	@Test
	public void Tc_Test_002() {
		testStarts("Tc_Test_001", "Verify that user gets redirected to \"User Alert\" page when clicks on \" Alert\" button.");
		openBrowser(Loginpage.URL);
		Loginpage.login(Loginpage.UserName, Loginpage.Password);
		
		
		selectFromDropdown(OR.VendorAccSetup_VendorDropdown, "Cardinal Pharma");
		int sie = driver.findElements(By.xpath("//*[starts-with(@id,'facility_account_text')]")).size();
		for(int i=1;i<=sie;i++)
		{driver.findElement(By.xpath("(//*[starts-with(@id,'facility_account_text')])["+i+"]")).clear();
		driver.findElement(By.xpath("(//*[starts-with(@id,'facility_account_text')])["+i+"]")).sendKeys("123");
		}
		System.out.println("123");
	}
	
	@AfterTest
	public void endReport()
	{
		closeBrowser();
		extent.flush();
	}
}


