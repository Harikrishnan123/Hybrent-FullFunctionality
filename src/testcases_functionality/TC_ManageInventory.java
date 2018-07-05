package testcases_functionality;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.server.handler.GetTitle;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import AutomationFramework.ApplicationKeyword;
import AutomationFramework.Generickeywords;
import AutomationFramework.OR;
import funcation_PageObject.*;
import pageObject.ManageInventoryPOpage;

public class TC_ManageInventory extends ApplicationKeyword{

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
			extent = new ExtentReports(folderPath+"/ManageInventory.html", true);
			extent.addSystemInfo("User Name", "QA");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}

	
	@Test
	public void TC_ManageInventory_001() {
		testStarts("TC_ManageInventory_001", "Verify that \"Manage Inventory For Facility Name\" label appears on top left of page.");
		Loginpage.OpenBrowserAndLoginnew();
		ManageInventory.NavigateManageInvetory();
		ManageInventory.selectFacility();
		ManageInventory.Inventory();
		ManageInventory.Status();
		verifyElement(OR.manage_categoryt);
	}
		
	@Test
	public void TC_ManageInventory_002()
	{
		testStarts("TC_ManageInventory_002" , "Verify that user can search items on the basis of Item Name, alias, MFR, SKU ands Crosswalk Id ");
		System.out.println("TC_ManageInventory_002");
		//Loginpage.OpenBrowserAndLoginnew();
		ManageInventory.NavigateManageInvetory();
		ManageInventory.Search();
	}
	
	@Test
	public void TC_ManageInventory_003()
	{
		testStarts("TC_ManageInventory_003" , "Print > Verify that “Print Preview” button appear on page, when user clicks “Print\" button for any item.");
		//Loginpage.OpenBrowserAndLoginnew();
		ManageInventory.NavigateManageInvetory();
		ManageInventory.EditInventory();
	}
	
	@Test
	public void TC_ManageInventory_004()
	{
		testStarts("TC_ManageInventory_004" , "Verify that QOH value appears if user selects default inventory from inventory drop down.");
		//Loginpage.OpenBrowserAndLoginnew();
		ManageInventoryPOpage.PageLinkAndWait("inventory", OR.manageInv_pageLink);    
		selectFromDropdown(OR.manageInv_InventoryDropDown, 1);
		clickOn(OR.manageInv_searchButton);
		waitForElementToDisplayWithoutFail(OR.manageInv_minusSign, 20);
		if(isElementDisplayed(OR.manageInv_minusSign, 10))
		{
			testLogPass("Minus sign is present on the Page");
		}
		else
		{
			testLogFail("Minus sign is not present on the Page");
		}
		if(isElementDisplayed(OR.manageInv_plusSign, 10))
		{
			testLogPass("Plus sign is present on the Page");
		}
		else
		{
			testLogFail("Plus sign is not present on the Page");
		}
		String MinMaxPar = "MinMaxInfo#xpath=//*[@ng-if='showInventoryStock && cycleCountEnabled']//*[@class='vendor_info ng-binding']";
		getText(MinMaxPar);
		if(isElementDisplayed(OR.manageInv_cycleCount, 10))
		{
			testLogPass("Cycle Count Button is displayed on the page");
			verifyElement(OR.manageInv_RequestPhysical);
			clickOn(OR.manageInv_cycleCount);
			verifyElement(OR.manageInv_UPDATECount);
			verifyElement(OR.InvLoc_Add_CancelBtn);
			String one =getAttributeValue(OR.manageInv_InventoryDropDown, "disabled");
			if(one.contains("true"));
			{
				testLogPass("Inventory is in disable condition");
			}
			String CurrentCOunt = "CurrentCount#xpath=//*[@ng-show='isCycleCount']//div[2]";
			String CurrentCOuntvalue = "CurrentCount#xpath=(//*[@ng-show='isCycleCount'])[3]";
			String NewCount = "NewCount#xpath=//*[@ng-show='isCycleCount']//div[4]";
			String NewCountvalue = "NewCount#xpath=(//*[@ng-show='isCycleCount'])[4]";
			testLogPass(getText(CurrentCOunt)+"-"+ getText(CurrentCOuntvalue));
			testLogPass(getText(NewCount)+"-"+ getText(NewCountvalue));
			
			String newcout = "12";
			String Currentcount = getText(CurrentCOuntvalue);
			
			typeIn(OR.manageInv_NewCount, "0");
			typeIn(OR.manageInv_NewCount, newcout);
			int newInt = Integer.parseInt(newcout);
			int Currentcountint = Integer.parseInt(Currentcount);
			String Diff = driver.findElement(By.xpath("(//*[@ng-show='isCycleCount'])[4]")).getText();
			int Di = Integer.parseInt(Diff);
			int Differencecal = newInt - Currentcountint;
					
			if(Di==Differencecal)
			{
				testLogPass("Difference = New Count - Current Count is correctly displays");
			}
			
			
			clickOn(OR.manageInv_UPDATECount);
			if(isElementDisplayed(OR.manageInv_CycleCountUpdate))
			{
				verifyElementText(OR.manageInv_CycleCountUpdate, "Cycle Count Updated");
			}
			String Validation = driver.findElement(By.xpath("//hr/following-sibling::h4")).getText();
			testLogPass(Validation);
			int si = driver.findElements(By.xpath("//*[@class='modal-body']//*[contains(@class, 'item-description')]")).size();
			for(int i=1 ;i<=si;i++)
			{
				String TableHeader = driver.findElement(By.xpath("(//*[@class='modal-body']//*[contains(@class, 'item-description')])["+i+"]")).getText();
				testLogPass("Table header value is "+TableHeader);
			}
			getTextchild("//*[@class='fa fa-download']");
			verifyElementText(OR.manageInv_Done, "DONE");
			verifyElement(OR.Order_CloseButton);
			clickOn(OR.manageInv_Done);
			verifyElementText(OR.manageInv_Validation, "Do you want to finish inventory count cycle?");
			clickOn(OR.ItemCatalog_AddItem_MapValidation_Cancel);
			clickOn(OR.manageInv_Done);
			clickOn(OR.ItemCat_ConfirmButton);
			verifyElementText(OR.manageInv_ValidationSucess, "Cycle count updated successfully.");
			clickOn(OR.MyCart_confirmButton);
			
		}
		
		
		
	}
	
	@Test
	public void TC_ManageInventory_005()
	{
		testStarts("TC_ManageInventory_005" , "Print > Verify that “Print Preview” button appear on page, when user clicks “Print\" button for any item.");
		//Loginpage.OpenBrowserAndLoginnew();
		ManageInventory.NavigateManageInvetory();
		String itemDesc=getProperty("ItemDesc");
		typeIn(OR.manageInv_searchTextBox, itemDesc);
		clickOn(OR.manageInv_searchButton);
		ManageInventory.Print();
	}
	
	@Test
	public void TC_ManageInventory_006()
	{
		testStarts("TC_ManageInventory_006" , "Verify that Transfer Inventory popup appears when user clicks “Transfer” button.");
		//Loginpage.OpenBrowserAndLoginnew();
		ManageInventory.NavigateManageInvetory();
		String itemDesc=getProperty("ItemDesc");
		typeIn(OR.manageInv_searchTextBox, itemDesc);
		clickOn(OR.manageInv_searchButton);
		ManageInventory.Tracsfer();
		verifyPagination();
	}
	
	@AfterTest
	public void endReport()
	{
		closeBrowser();
		extent.flush();
	}
}


