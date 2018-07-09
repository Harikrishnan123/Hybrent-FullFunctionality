package testCases;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import pageObject.Loginpage;
import pageObject.ManageInventoryPOpage;
import AutomationFramework.ApplicationKeyword;
import AutomationFramework.Generickeywords;
import AutomationFramework.OR;
public class ManageInventory extends ApplicationKeyword{
	
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

			extent = new ExtentReports(folderPath+"/manageinventory.html", true);
			// extent.addSystemInfo("Environment","Environment Name")
			extent.addSystemInfo("User Name", "Ravneet");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}

	@Test
	public void Tc_manageInv_01()
	{
		testStarts("Tc_manageInv_01" , "Verify that user can search items on the basis of Item Name, alias, MFR, SKU ands Crosswalk Id ");
		System.out.println("Tc_manageInv_01");
		Loginpage.OpenBrowserAndLogin();		
		ManageInventoryPOpage.PageLinkAndWait("inventory", OR.manageInv_pageLink);
		String itemDesc=getProperty("ItemDesc");
		typeIn(OR.manageInv_searchTextBox, itemDesc);
		clickOn(OR.manageInv_searchButton);
		//waitForElementToDisplayWithoutFail(OR.manageInv_firstItemDesc, 20);
		waitForElementToDisplayWithoutFail("firstItemDesc#xpath=(//*[@class='item-description']/span[text()='"+itemDesc+"'])[1]", 10);
		String ItemName=getText(OR.manageInv_firstItemDesc);
		if(ItemName.equalsIgnoreCase(itemDesc))
		{
			testLogPass("Item is searched with " + ItemName);
		}
		else
		{
			testLogFail("Item is not searched with " + ItemName);			
		}
		clearEditBox(OR.manageInv_searchTextBox);
		waitForElementToDisplayWithoutFail(OR.manageInv_wait2, 20);
		String Sku=getProperty("Sku");
		typeIn(OR.manageInv_searchTextBox,Sku);
		clickOn(OR.manageInv_searchButton);
		waitForElementToDisplayWithoutFail(OR.manageInv_firstItemSku, 20);
		String getskuName=getText(OR.manageInv_firstItemSku);
		System.out.println(getskuName);
		waitForElementToDisplayWithoutFail(OR.manageInv_firstItemSku, 15);
		if(getskuName.equalsIgnoreCase(Sku))
		{
			testLogPass("Item is searched with " + Sku);
		}
		else
		{
			testLogFail("Item is not searched with " + Sku);			
		}	
		clearEditBox(OR.manageInv_searchTextBox);
		waitForElementToDisplayWithoutFail(OR.manageInv_wait2, 15);
		String mfr=getProperty("ItemMfr");
		typeIn(OR.manageInv_searchTextBox,mfr);
		clickOn(OR.manageInv_searchButton);
		waitForElementToDisplayWithoutFail(OR.manageInv_firstItemDesc, 15);
		if(ItemName.equalsIgnoreCase(itemDesc))
		{
			testLogPass("Item is searched with " + mfr);
		}
		else
		{
			testLogFail("Item is not searched with " + mfr);			
		}	
		clearEditBox(OR.manageInv_searchTextBox);
		waitForElementToDisplayWithoutFail(OR.manageInv_wait2, 15);
		String alias=getProperty("alias");
		typeIn(OR.manageInv_searchTextBox,alias);
		clickOn(OR.manageInv_searchButton);
		waitForElementToDisplayWithoutFail(OR.manageInv_firstItemDesc, 15);
		if(ItemName.equalsIgnoreCase(itemDesc))
		{
			testLogPass("Item is searched with " + alias);
		}
		else
		{
			testLogFail("Item is not searched with " + alias);			
		}
		//waitTime(3);
	}


	@Test
	public void Tc_manageInv_03()
	{
		testStarts("Tc_manageInv_03" , "Edit Item > Verify that changes made get saved successfully, on clicking SAVE button");
		System.out.println("Tc_manageInv_03");
		//Loginpage.OpenBrowserAndLogin();
		NavigateUrl(DashBoardURL);	
		ManageInventoryPOpage.PageLinkAndWait("inventory", OR.manageInv_pageLink);
		String itemDesc=getProperty("ItemDesc");
		typeIn(OR.manageInv_searchTextBox, itemDesc);
		clickOn(OR.manageInv_searchButton);	
		//waitTime(4);		
		waitForElementToDisplayWithoutFail(OR.manageInv_firstItemDesc, 10);
		String ItemName=getText(OR.manageInv_firstItemDesc);
		System.out.println(ItemName);
		System.out.println(itemDesc);
		if(ItemName.trim().equalsIgnoreCase(itemDesc))
		{
			clickOn(OR.manageInv_EditIem);
			waitForElementToDisplayWithoutFail(OR.manageInv_VendorsTab, 10);
			clickOn(OR.manageInv_VendorsTab);
			String temp=getDropDownText(OR.manageInv_EditStockStatus, 1);	
			clearEditBox(OR.manageInv_EditItem_GPoContractPrice);
			typeIn(OR.manageInv_EditItem_GPoContractPrice, "60");
			//waitTime(2);
			waitForElementToDisplayWithoutFail(OR.manageInv_EditItem_SaveButton, 10);
			clickOn(OR.manageInv_EditItem_SaveButton);
			//waitTime(4);
			waitForElementToDisplayWithoutFail(OR.manageInv_firstItemDesc, 20);
			clearEditBox(OR.manageInv_searchTextBox);
			typeIn(OR.manageInv_searchTextBox, itemDesc);
			clickOn(OR.manageInv_searchButton);
			waitForElementToDisplayWithoutFail(OR.manageInv_firstItemDesc, 20);
			String ItemName2=getText(OR.manageInv_firstItemDesc);
			if(ItemName2.equalsIgnoreCase(itemDesc))
			{
				clickOn(OR.manageInv_EditIem);
				waitForElementToDisplayWithoutFail(OR.manageInv_EditIemHeaderText, 20);
				clickOn(OR.manageInv_VendorsTab);
				String temp1=getAttributeValue(OR.manageInv_EditStockStatus, "value");
				if(temp1.contains(temp))
				{
					testLogPass("Item is Edited Successfully");
				}
				else
				{
					testLogFail("Item is not Edited Successfully");
				}
			}
			else
			{
				testLogFail("Seach is not working properly");
			}
		}
		else
		{
			testLogFail("Seach is not working properly");
		}	

		//waitTime(5);
	}

//	@Test
//	public void Tc_manageInv_04()
//	{
//		testStarts("Tc_manageInv_04" , "Delete > Verify that corresponding item gets deleted from page, on clicking �Delete� button");
//		System.out.println("Tc_manageInv_04");
//		NavigateUrl(DashBoardURL);	
//	   //Loginpage.OpenBrowserAndLogin();	
//		ManageInventoryPOpage.PageLinkAndWait("inventory", OR.manageInv_pageLink);
////		String itemDesc=getProperty("ItemDesc");
////		typeIn(OR.manageInv_searchTextBox, itemDesc);
////		clickOn(OR.manageInv_searchButton);
//		waitForElementToDisplayWithoutFail(OR.manageInv_DeleteIcon, 20);
//		//String ItemName=getText(OR.manageInv_firstItemDesc);
//		//char quotes='"';
//		clickOn(OR.manageInv_DeleteIcon);
//		verifyElementText(OR.manageInv_DeletePoUp, ("Do you really want to delete the item"));
//		clickOn(OR.manageInv_cancelPopUP);
//		//waitTime(3);
//	}


	@Test
	public void Tc_manageInv_05_06()
	{
		testStarts("Tc_manageInv_05_06" , "Verify that �Print Preview� button with total number of items to print appear on page, on clicking �Print button� for any item "
				+ "+Verify that Print popup window opens on clicking Print Preview button.");
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_manageInv_05_06");
		ManageInventoryPOpage.PageLinkAndWait("inventory", OR.manageInv_pageLink);
		String itemDesc=getProperty("ItemDesc");
		typeIn(OR.manageInv_searchTextBox, itemDesc);
		clickOn(OR.manageInv_searchButton);
		//waitTime(4);
		waitForElementToDisplayWithoutFail(OR.manageInv_firstItemDesc, 10);
		String ItemName=getText(OR.manageInv_firstItemDesc);				
		if(ItemName.equalsIgnoreCase(itemDesc))
		{
			clickOn(OR.manageInv_PrintIcon);
			clickOn(OR.manageInv_PrintPreviewButton);
			verifyElementText(OR.manageInv_PrintPopUpText, "Selected Items");
			List<WebElement> allItemrows=driver.findElements(By.xpath("//*[@id='populate_items_pdf']/tr"));
			for(int i=1;i<=allItemrows.size();i++)
			{
				String we=(allItemrows.get(i-1)).findElement(By.xpath("//td["+i+"]")).getText();		
				System.out.println(we);
				if(we.contains(itemDesc))
				{
					testLogPass("Item found in the Print Pop up");
					break;
				}								
			}
		}
		clickOn(OR.manage_PrintCloseclose);
		//waitTime(3);
	}

	@Test
	public void Tc_manageInv_07()
	{
		testStarts("Tc_manageInv_07" , "Verify that Transfer Inventory popup appears on clicking �Transfer� button.");
		System.out.println("Tc_manageInv_07");
		NavigateUrl(DashBoardURL);	
		ManageInventoryPOpage.PageLinkAndWait("inventory", OR.manageInv_pageLink);
		clickOn(OR.manageInv_TransferIcon);
		verifyElementText(OR.manageInv_TransferPopUpText, "Transfer Inventory");
		//waitTime(4);
		//waitForElementToDisplayWithoutFail(OR.manage_PrintCloseclose, 10);
		//clickOn(OR.manage_PrintCloseclose);
		//waitTime(3);	
	}

	@Test
	public void Tc_manageInv_02_09()
	{
		testStarts("Tc_manageInv_02_09" , "Verify that on selecting any Inventory + and � buttons are appearing +"
				+ "Verify that  Cycle Count option appears on page");
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_manageInv_02_09");
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
		if(isElementDisplayed(OR.manageInv_cycleCount, 10))
		{
			testLogPass("Cycle Count Button is displayed on the page");			
		}
				
	}
	
	@AfterTest
	public void endReport()
	{
		closeBrowser();
		extent.flush();
	}



}
