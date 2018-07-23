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

public class TC_Alert extends ApplicationKeyword{

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
	public void Tc_Alert_001() {
		testStarts("Tc_Alert_001", "Verify that user gets redirected to \"User Alert\" page when clicks on \" Alert\" button.");
		Loginpage.OpenBrowserAndLoginnew();
		Alert.NavigateToAlert();
		
	}
	
	@Test
	public void Tc_Alert_002() {
		testStarts("Tc_Alert_002", "Verify that “Preferred Item Warning” popup appears when user tries to add corresponding item to cart if “Show Preferred Item Warning” is set as Active.");
		User.adminAndUserPage();
		User.Search(getProperty("created_NeUser"));
		clickOn(OR.glCode_Home_Editfirst);
		waitForElement(_OR.user_add_poalert);
		clickOn(_OR.user_add_poalert);
		 String accessON = getAttributeValue(_OR.user_addUser_input_accesscustomer, "class");
		 if(accessON.contains("bootstrap-switch-off"))
		 {
			 clickOn(_OR.user_addUser_input_accesscustomer);
			 clickOn(_OR.user_addUser_addinventory_facilitysave); 
		 }
		 waitUntilPageReady();
		 if(driver.findElements(By.xpath("//*[@value='Cancel']")).size()!=0)
		 {
			 clickOn(OR.Profile_Btn_cancel);
			 
		 }
		 waitUntilPageReady();
		 waitForElement(OR.MyCart);
			clickOn(OR.MyCart);
			waitUntilPageReady();
			Shopcart.AdditemDecrease();
	}
	
	@AfterTest
	public void endReport()
	{
		closeBrowser();
		extent.flush();
	}
}


