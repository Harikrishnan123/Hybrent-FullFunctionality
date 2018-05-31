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
import funcation_PageObject.*;

public class TC_Login extends ApplicationKeyword{

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

			extent = new ExtentReports(folderPath+"/login.html", true);
			extent.addSystemInfo("User Name", "QA");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}


//	@Test
//	public void Tc_Login_001() {
//		testStarts("TC_01,TC_02", "Verify that Hybrent logo appears on page\r\n");
//		Loginpage.OpenBrowserAndLogin();
//	
//	}
//	@Test
//	public void Tc_Angular() {
//		testStarts("TC_01,TC_02", "Verify that Hybrent logo appears on page\r\n");
//		Loginpage.Angularlogin(Node, Node);
//		
//	
//	}	
	
	@Test
	public void Tc_Login_001() {
		testStarts("Tc_Login_001", "Verify that Hybrent logo appears on page\r\n" + 
				"Verify that \"Login with Hybrent\" hyperlink appear below the \"Login with ADFS\" on Login frame.\r\n" + 
				"Verify that on clicking \"Login with Hybrent\" user get redirected to Hybrent login frame\r\n" + 
				"Verify that “User Name” field appears on Login Frame\r\n" + 
				"Verify that tooltip “Your Nickname” appears when user clicks on Username field.\r\n" + 
				"Verify that \"Password\" field appears on Login Frame.\r\n" + 
				"Verify that value entered in “Password” field appears in masked form.\r\n" + 
				"Verify that “Login” button appear on Login Frame.\r\n" + 
				"Verify that \"Login with ADFS\" hyperlink appear right below on hybrent login frame\r\n" + 
				"Verify that copyright text should be there at bottom of page .\r\n" + 
				"Verify that “Current Year” & “Build Version” appear in Copyright info.\r\n" + 
				"Verify that system does not allow user to Login with “Invalid Credentials”.\r\n" + 
				"");
		openBrowser(Loginpage.URL);	
		//Loginpage.ADFS_link();
		if(driver.findElements(By.xpath("//a[text()='Sign in with new user']")).size()!=0)
		{
			clickOn(_OR.Label_signinnewuser);
		}
		Loginpage.verify_LoginLabel();
		Loginpage.tooltipUsername();
		//Loginpage.rightAdflink();
		Loginpage.login(Loginpage.Invalid_Username, Loginpage.Invalid_Password);
		Loginpage.validationMessage();
		Loginpage.login(Loginpage.UserName, Loginpage.Password);
	}
	
	@AfterTest
	public void endReport()
	{
		closeBrowser();
		extent.flush();
	}
}


