package testcases_functionality;

import java.io.File;
import java.util.ArrayList;

import org.junit.runners.parameterized.TestWithParameters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import AutomationFramework._OR;
import AutomationFramework.OR;
import funcation_PageObject.*;
import pageObject.Alertpage;
import pageObject.Changepasswordpage;

public class TC_Switchuser extends ApplicationKeyword{

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

			extent = new ExtentReports(folderPath+"/switchuser.html", true);
			extent.addSystemInfo("User Name", "QA");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}

	
	@Test
	public void Tc_Switchuser_001() {
		testStarts("Tc_Switchuser_001", "Verify that \"Select user to login\" frame appears when user clicks on Switch User button.");
		Loginpage.OpenBrowserAndLoginnew();
		clickOn(_OR.Dashboard_User);
		clickOn(_OR.Dashboard_User_SwitchUser);
		isElementDisplayed(_OR.Label_signinnewuser);
		String username =getText(_OR.Loginusername);
		testLogPass("Username is "+username);
		testLogPass("Email is "+getText(_OR.LoginuserEmail));
		testLogPass("Status is "+getText(_OR.LoginuserStatus));
		WebElement Crossicon = driver.findElement(By.xpath("//*[@ng-click='removeUser(user.id)']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(Crossicon).build().perform();
		Crossicon.click();
		
		if(driver.findElements(By.className("user-label")).size()==0)
		{
			testLogPass(" user gets removed from the list when user clicks on the \"X\" sign.");
		}
		else
		{
			testLogFail(" user gets Not removed from the list when user clicks on the \"X\" sign.");
		}
	}
	
	@Test
	public void Tc_Switchuser_002() {
		testStarts("Tc_Switchuser_002", "Verify that system gets redirect to login frame when user clicks on \"Sign in with new user\" link.");
		Loginpage.OpenBrowserAndLoginnew();
		clickOn(_OR.Dashboard_User);
		clickOn(_OR.Dashboard_User_SwitchUser);
		clickOn(_OR.Label_signinnewuser);
		verifyElement(_OR.Login_Username);
	}
	
	@Test
	public void Tc_Switchuser_003() {
		testStarts("Tc_Switchuser_003", "Verify that on login frame \"Back\" button appears at the bottom.");
		Loginpage.OpenBrowserAndLogin();
		clickOn(_OR.Dashboard_User);
		clickOn(_OR.Dashboard_User_SwitchUser);
		clickOn(_OR.Label_signinnewuser);
		verifyElement(_OR.Loginusername);
		if(driver.findElements(By.xpath("//a[text()='Sign in with new user']")).size()!=0)
		{
			clickOn(_OR.Label_signinnewuser);
		}
		if(driver.findElements(By.className("adfslogin-link")).size()!=0)
		{
			clickOn(_OR.Login_link_LoginHybrent);
			if(driver.findElements(By.xpath("//a[@href='#/selectuser']")).size()!=0)
			{
				WebElement Backbtn = driver.findElement(By.xpath("//a[@href='#/selectuser']"));
				Backbtn.click();
				verifyElement(_OR.Loginusername);
			}
		}else
		{
			Loginpage.login(Loginpage.UserName, Loginpage.Password);
			clickOn(_OR.DashBoard_Admin);
			clickOn(_OR.DashBoard_Admin_organization);
			waitforclick(_OR.DashBoard_Admin_organization_Features);
			clickOn(_OR.DashBoard_Admin_organization_Features);
			mouseOver(_OR.DashBoard_Admin_organization_Features_adfs_auth);
			String classAttribute = driver.findElement(By.xpath("//*[@for='adfs_auth']//following::div[2]")).getAttribute("class");
			if(classAttribute.contains("bootstrap-switch-on"))
			{
				driver.findElement(By.xpath("//*[@for='adfs_auth']//following::div[2]")).click();
			}else if(classAttribute.contains("bootstrap-switch-off"))
			{
				driver.findElement(By.xpath("//*[@for='adfs_auth']//following::div[2]")).click();
				mouseOver(OR.ItemCatalog_AddItem_Man_Save);
				clickOn(OR.ItemCatalog_AddItem_Man_Save);
				verifyElement(_OR.Setting_Update_sucess);
				clickOn(_OR.Login_okay);
				clickOn(_OR.Dashboard_User);
				clickOn(_OR.Dashboard_User_SwitchUser);
				clickOn(_OR.Label_signinnewuser);
				verifyElement(_OR.Login_Username);
				if(driver.findElements(By.xpath("//a[text()='Sign in with new user']")).size()!=0)
				{
					clickOn(_OR.Label_signinnewuser);
				}
				if(driver.findElements(By.className("adfslogin-link")).size()!=0)
				{
					clickOn(_OR.Login_link_LoginHybrent);
					if(driver.findElements(By.xpath("//a[@href='#/selectuser']")).size()!=0)
					{
						WebElement Backbtn = driver.findElement(By.xpath("//a[@href='#/selectuser']"));
						Backbtn.click();
					}
				}
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



