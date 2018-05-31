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

public class TC_Notification extends ApplicationKeyword{

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

			extent = new ExtentReports(folderPath+"/Notification.html", true);
			extent.addSystemInfo("User Name", "QA");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}


	@Test
	public void Tc_Notification_001() {
		testStarts("Tc_Notification_001", "Verify that system gets redirected to “NOTIFICATION SETTINGS” page when user clicks on “Notification settings” button." + 
				""
				+ "Verify Admin drop down button appears on top of page.\r\n" + 
				"" );
		openBrowser(Loginpage.URL);
		Loginpage.login(Loginpage.UserName, Loginpage.Password);
		//Loginpage.OpenBrowserAndLogin();
		clickOn(_OR.Dashboard_User);
		clickOn(_OR.Dashboard_User_NotificationSetting);
		verifyElement(OR.NotficationPage_Text);
		verifyElementText(OR.NotficationPage_Text_Event,"Event");
		verifyElementText(OR.NotficationPage_Text_MobilePush,"Mobile Push");
		verifyElementText(OR.NotficationPage_Text_Email,"Email Notification");
		verifyElementText(OR.NotficationPage_Text_Web,"Web Notification");
		
		verifyElementText(OR.NotficationPage_Text_Event_Purchase_order_Approval,"Purchase Order Approval	");
		verifyElementText(OR.NotficationPage_Text_Event_Pending_Approval,"Pending Approval");
		verifyElementText(OR.NotficationPage_Text_Event_Purchase_Order_Approved,"Purchase Order Approved");
		verifyElementText(OR.NotficationPage_Text_Event_Purchase_Order_Confirmation,"Purchase Order Confirmation");
		verifyElementText(OR.NotficationPage_Text_Event_Purchase_Order_Shipped,"Purchase Order Shipped");
		verifyElementText(OR.NotficationPage_Text_Event_Purchase_Order_Invoice,"Purchase Order Invoice");
		verifyElementText(OR.NotficationPage_Text_Event_QOH_LessThanParLevel,"QOH Less Than Par Level");
		verifyElementText(OR.NotficationPage_Text_Event_Template_Schedule_Create_PO,"Template Schedule Create PO");
		verifyElementText(OR.NotficationPage_Text_Event_Purchase_Order_Rejected,"Purchase Order Rejected");
		
		int Headingtitlesize  = driver.findElements(By.xpath("//thead//th")).size();
		for(int k=1;k<=Headingtitlesize;k++)
		{int Titlesize = driver.findElements(By.xpath("(//tr/td[1])")).size();
			String getHeaderTitle = driver.findElement(By.xpath("(//thead//th)["+k+"]")).getText();
		for(int i=1;i<=Titlesize;i++)
		{
			String getTitle = driver.findElement(By.xpath("(//tr/td[1])["+i+"]")).getText();
			if(driver.findElements(By.className("bootstrap-switch-handle-on")).size()!=0)
			{
				testLogPass("Title is "+getHeaderTitle +" Sub heading "+getTitle +"is in ON option");	
			}
			else
			{
				testLogPass("Title is "+getHeaderTitle +" Sub heading "+getTitle +"is in OFF option");
			}
			
			
		}
		}
		verifyElement(OR.NotficationPage_Save);
		verifyElement(OR.NotficationPage_Cancel);
		
	}
	

	
	@AfterTest
	public void endReport()
	{
		closeBrowser();
		extent.flush();
	}

}


