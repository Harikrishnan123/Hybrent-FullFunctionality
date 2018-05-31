package testCases;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import pageObject.Loginpage;
import pageObject.Shipmentpage;
import AutomationFramework.ApplicationKeyword;
import AutomationFramework.Generickeywords;
import AutomationFramework.OR;

public class Shipments  extends ApplicationKeyword
{
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
				// If you require it to make the entire directory path including parents,
				// use directory.mkdirs(); here instead.
			}

			extent = new ExtentReports(folderPath+"/shipment.html", true);
			// extent.addSystemInfo("Environment","Environment Name")
			extent.addSystemInfo("User Name", "Ravneet");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}

	@Test
	public void Tc_SH_01() throws InterruptedException
	{
		testStarts("Tc_SPO_01", "Verify that user can search shipments by Shipment#, Tracking # and PO# ");
		Loginpage.OpenBrowserAndLogin();
		System.out.println("Tc_SH_01");
		Shipmentpage.InitialSteps();
		waitForElementToDisplayWithoutFail(OR.Shipment_FirstShipmentNum, 5);
		if(isElementDisplayed(OR.Shipment_FirstShipmentNum, 10))
		{		
		String ShipmentNum=getText(OR.Shipment_FirstShipmentNum);	
		System.out.println(ShipmentNum);
		String PoNum=getText(OR.Shipment_ShipmentPONum);
		System.out.println(PoNum);
		typeIn(OR.Shipment_SearchTextBox, ShipmentNum); 
		Shipmentpage.searchAndWait();			
		verifyElementText(OR.Shipment_FirstShipmentNum, ShipmentNum);
		Shipmentpage.clearAndWait();
		typeIn(OR.Shipment_SearchTextBox, PoNum); 
		Shipmentpage.searchAndWait();
		verifyElementText(OR.Shipment_ShipmentPONum, PoNum );
		Shipmentpage.clearAndWait();
		}
		else
		{
			testLogFail("There is no Shipment found in the Module.");
		}

	}

	@Test
	public void Tc_SH_02() throws InterruptedException
	{
		testStarts("Tc_SH_02", "Verify that status dropdown appears with(Pending Shipped Partial Received Received) options");
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_SH_02");
		Shipmentpage.InitialSteps();			
		List<String> list = new ArrayList<String>( Arrays.asList("All", "Pending", "Partial Receive", "Received"));		
		List<WebElement> options = driver.findElements
				(By.xpath("//*[@id='sel1']/option"));	
		boolean textFound;
		if(options.size() == list.size())
		{
			for(String lm:list)
			{
				textFound=false;
				for(WebElement we:options)  
				{
					if(we.getText().trim().equals(lm))
					{
						textFound=true;
					}
				}
				if(textFound)
				{
					testLogPass("Text '" + lm + "' exists in dropdown.");
				}
				else
				{
					testLogFail("Text '" + lm + "' does not exist in dropdown.");
				}
			}
		}
		else
		{
			//fail because size is not equal
			testLogFail("Size of two ArrayList Is not Equal");
		}

	}

	@Test
	public void Tc_SH_03() throws InterruptedException
	{
		testStarts("Tc_SH_03", "Verify that user gets redirected to shipment details screen on clicking �Shipment #�.");
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_SH_03");
		Shipmentpage.InitialSteps();
		waitForElementToDisplayWithoutFail(OR.Shipment_FirstShipmentNum, 10);
		if(isElementDisplayed(OR.Shipment_FirstShipmentNum, 10))
		{
		
		String ShipmentNum=getText(OR.Shipment_FirstShipmentNum).toUpperCase();
		System.out.println(ShipmentNum);
		clickOn(OR.Shipment_FirstShipmentNum);
		waitForElementToDisplayWithoutFail(OR.Shipment_ShipmentDetailPAge, 20);
		String DetailPageText=getText(OR.Shipment_ShipmentDetailPAge);
		System.out.println(DetailPageText);
		if(DetailPageText.trim().contains("SHIPMENT# "+ ShipmentNum))
		{
			testLogPass("Successfully matched the Text and User is redirected to Shipment detail page");
		}
		else
		{
			testLogFail("Could not match the Text and User is not redirected to Shipment detail page");
		}
		}
		else
		{
			testLogFail("There is no Shipment found in the Module.");
		}

	}

	@Test
	public void Tc_SH_04() throws InterruptedException
	{
		testStarts("Tc_SH_04", "Verify that �Receive� button appears for pending and Partial received shipments.�.");
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_SH_04");
		Shipmentpage.InitialSteps();
		selectFromDropdown(OR.Shipment_StatusDropDown, "Pending");
		Shipmentpage.searchAndWait();
		waitForElementToDisplayWithoutFail(OR.Shipment_FirstShipmentNum, 5);
		if(isElementDisplayed(OR.Shipment_FirstShipmentNum, 10))
		{		
		clickOn(OR.Shipment_FirstShipmentNum);
		Shipmentpage.receiveTextandCloseButton();
		waitForElementToDisplayWithoutFail(OR.Shipment_FirstShipmentNum, 60);
		selectFromDropdown(OR.Shipment_StatusDropDown, "Partial Receive");
		Shipmentpage.searchAndWait();
		waitForElementToDisplayWithoutFail(OR.Shipment_FirstShipmentNum, 20);
		clickOn(OR.Shipment_FirstShipmentNum);
		Shipmentpage.receiveTextandCloseButton();
		}
		else
		{
			testLogFail("There is no Shipment found in the Module.");
		}

	}



	@AfterTest
	public void endReport(){
		closeBrowser();
		extent.flush();
	}


}
