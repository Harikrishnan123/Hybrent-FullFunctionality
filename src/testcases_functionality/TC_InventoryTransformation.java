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

public class TC_InventoryTransformation extends ApplicationKeyword{

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

			extent = new ExtentReports(folderPath+"/InventoryItemTransaction.html", true);
			extent.addSystemInfo("User Name", "QA");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}

	
	@Test
	public void Tc_InventoryItemTransaction_001() {
		testStarts("Tc_InventoryItemTransaction_001", "Verify that \"Inventory Item Transaction for Facility \" heading appears on top left side of page.");
		Loginpage.OpenBrowserAndLoginnew();
		Facility.NavigateHometoFacility();
		 clickOn(OR.Facilities_Add_Btn_Facility);
		 String  FacilityName = "TestName"+randomAlphaNumeric(5);
		 String DeptName  = "Test-Dept"+generateRandomInt(6);
		 String InvetoryName = "Inventory"+randomAlphaNumeric(5);
		 setProperty("Inventory_UserAddInvetoryName",InvetoryName);
		 setProperty("Inventory_UserAddDeptName",DeptName);
		 setProperty("Inventory_UserAddfailityName",FacilityName);
		 String Mnemonic = "Mn"+randomAlphaNumeric(8);
		 int Licensebefore = generateRandomInt(6);
		 String License = Integer.toString(Licensebefore);
		 typeIn(_OR.user_addUser_Facilitydetail_input_Mneonic, Mnemonic);
		 typeIn(_OR.user_addUser_Facilitydetail_input_name, FacilityName);
		 typeIn(_OR.user_addUser_Facilitydetail_input_license_count, License);
		 if(driver.findElements(By.className("bootstrap-switch-handle-off")).size()!=0)
		 {
			 driver.findElement(By.className("bootstrap-switch-handle-off")).click();
			 String oone = System.getProperty("user.dir")+"\\assets\\1.jpeg";
			 driver.findElement(By.xpath("//*[@type='file']")).sendKeys(oone);
		 }
		Facility.addFacilityAddress();
		Facility.addFacilityInvoiceAddress();
		 clickOn(OR.Facilities_Add_Btn_Facility);
		 String  FacilityName1 = "TestName"+randomAlphaNumeric(5);
		 String DeptName1  = "Test-Dept"+generateRandomInt(6);
		 String InvetoryName1 = "Inventory"+randomAlphaNumeric(5);
		 setProperty("Inventory_UserAddInvetoryName1",InvetoryName1);
		 setProperty("Inventory_UserAddDeptName1",DeptName1);
		 setProperty("Inventory_UserAddfailityName1",FacilityName1);
		 String Mnemonic1 = "Mn"+randomAlphaNumeric(8);
		 int Licensebefore1 = generateRandomInt(6);
		 String License1= Integer.toString(Licensebefore1);
		 typeIn(_OR.user_addUser_Facilitydetail_input_Mneonic, Mnemonic1);
		 typeIn(_OR.user_addUser_Facilitydetail_input_name, FacilityName1);
		 typeIn(_OR.user_addUser_Facilitydetail_input_license_count, License1);
		 if(driver.findElements(By.className("bootstrap-switch-handle-off")).size()!=0)
		 {
			 driver.findElement(By.className("bootstrap-switch-handle-off")).click();
			 String oone = System.getProperty("user.dir")+"\\assets\\1.jpeg";
			 driver.findElement(By.xpath("//*[@type='file']")).sendKeys(oone);
		 }
		Facility.addFacilityAddress();
		Facility.addFacilityInvoiceAddress();
		
	}
	
	@Test
	public void Tc_InventoryItemTransaction_002() {
		testStarts("Tc_Inventorylocation_002", "Verify that “Manage Inventory Locations” heading appears on top left side of page.");
		Loginpage.OpenBrowserAndLoginnew();
		Inventorylocations.NavigateHometoLocation();
		String InvetoryCreate = "Inventory"+randomAlphaNumeric(10);
		setProperty("InvetoryCreate1", InvetoryCreate);
		clickOn(OR.InvLoc_AddINvLOc);
		verifyElement(OR.InvLoc_Add_LabelName);
		typeIn(OR.InvLoc_addName, InvetoryCreate);
		selectFromDropdown(OR.InvLoc_Add_Facility_Dropdown, getProperty("UserAddfailityName"));
		waitForElement(OR.InvLoc_Add_CreateBtn);
		clickOn(OR.InvLoc_Add_CreateBtn);
		ToastmesssageSucess();
		
		
		
		ManageInventory.PageLinkAndWait();
		ManageInventory.selectFacility();
		String itemDesc=getProperty("ItemDesc");
		typeIn(OR.manageInv_searchTextBox, itemDesc);
		clickOn(OR.manageInv_searchButton);
		ManageInventory.Tracsfer();
		verifyPagination();
	}
	
	@Test
	public void Tc_Inventorylocation_003() {
		testStarts("Tc_Inventorylocation_003", "Drill Down > Verify that confirmation popup appears when user clicks “Delete” button.");
		//Loginpage.OpenBrowserAndLoginnew();
		Inventorylocations.NavigateHometoLocation();
		Inventorylocations.DeleteInvntory();
	}
	
	@AfterTest
	public void endReport()
	{
		closeBrowser();
		extent.flush();
	}
}


