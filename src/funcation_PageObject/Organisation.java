package funcation_PageObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.Generickeywords;
import AutomationFramework.OR;
import AutomationFramework._OR;

public class Organisation extends ApplicationKeyword {
	public static String ItemCatName;
	public static String facName=null;
	public static List<String> depNames_FacPage= null ;
	//For User Page
	
	public static void adminAndOrgPage()
	{	
		clickOn(OR.DashBoard);
		waitForElement(OR.DashBoard_AdminDropdown);
		clickOn(OR.DashBoard_AdminDropdown);
		clickOn(OR.organization);
		getTextchild("//*[@class='pagehead']");					 
	}
	
	public static void verifypage()
	{
		verifyElementText(OR.organization_tab_Details, "Details");
		verifyElementText(OR.organization_tab_Features, "Features");
		verifyElement(OR.Dep_addFacmnemonic);
		verifyElement(OR.Dep_addName);
		verifyElement(OR.organization_time_zone);
		verifyElement(OR.Receive_uploadFile);
		verifyElement(OR.Procedure_SaveButton);
		verifyElement(OR.Scanout_Close);
		verifyElement(OR.organization_imageborder);
	}
	
	public static void SaveOrganization()
	{
		clickOn(OR.Procedure_SaveButton);
		waitForElement(OR.organization_Validation);
		OrgSettingChangerelogin();
	}
	
	public static void Feature()
	{
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		int size = driver.findElements(By.xpath("//*[@class='sub-header-block']")).size();
		for(int i=1; i<size; i++)
			{
				String one = driver.findElement(By.xpath("(//*[@class='sub-header-block'])["+i+"]")).getText();
				testLogPass(one);					
			}			
	}
	
	public static void subInventory()
	{
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		String Header= getText(OR.organization_Sub_Inventory);
		int size = driver.findElements(By.xpath("(//*[@class='sub-header-block' and text()='Inventory']/following-sibling::div/label)")).size();
		for(int i=1; i<size; i++)
			{
				String one = driver.findElement(By.xpath("(//*[@class='sub-header-block' and text()='Inventory']/following-sibling::div/label)["+i+"]")).getText();
				testLogPass(Header+" - "+one);					
			}
	}	
	
	public static void subOrder()
	{
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		testLogPass("Sub Header is "+ getText(OR.organization_SubOrder));
		int size = driver.findElements(By.xpath("//*[@class='sub-header-block' and text()='Order']/following-sibling::div/label")).size();
		for(int i=1; i<size; i++)
			{
				String one = driver.findElement(By.xpath("(//*[@class='sub-header-block' and text()='Order']/following-sibling::div/label)["+i+"]")).getText();
				testLogPass(one);					
			}
	}
	
	public static void subPreferencecard()
	{
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		String Header= getText(OR.organization_Sub_PreferenceCard);
		int size = driver.findElements(By.xpath("(//*[@class='sub-header-block' and text()='Preference Card']/following-sibling::div/label)")).size();
		for(int i=1; i<size; i++)
			{
				String one = driver.findElement(By.xpath("(//*[@class='sub-header-block' and text()='Preference Card']/following-sibling::div/label)["+i+"]")).getText();
				testLogPass(Header+" - "+one);					
			}
	}
	
	public static void subTemplate()
	{
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		String Header= getText(OR.organization_Sub_Templates);
		String xpath= "(//*[@class='sub-header-block' and text()='Templates']/following-sibling::div/label)";
		int size = driver.findElements(By.xpath(xpath)).size();
		for(int i=1; i<size; i++)
			{
				String one = driver.findElement(By.xpath(xpath+"["+i+"]")).getText();
				testLogPass(Header+" - "+one);					
			}
		int togleBtn = driver.findElements(By.xpath("//*[@class='sub-header-block' and text()='Templates']/following-sibling::div//div[starts-with(@class,'bootstrap-switch')]")).size();
		if(togleBtn!=0)
		{
			testLogPass("Toggel button is presnet for "+Header);
		}
	}
	
	public static void subIntegrations()
	{
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		String Header= getText(OR.organization_Sub_Integrations);
		String xpath= "(//*[@class='sub-header-block' and text()='Integrations']/following-sibling::div/label)";
		int size = driver.findElements(By.xpath(xpath)).size();
		for(int i=1; i<size; i++)
			{
				String one = driver.findElement(By.xpath(xpath+"["+i+"]")).getText();
				testLogPass(Header+" - "+one);					
			}
		int togleBtn = driver.findElements(By.xpath("//*[@class='sub-header-block' and text()='Integrations']/following-sibling::div//div[starts-with(@class,'bootstrap-switch')]")).size();
		if(togleBtn!=0)
		{
			testLogPass("Toggel button is presnet for "+Header);
		}
	}
	
	public static void subReseller()
	{
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		String Header= getText(OR.organization_Sub_Reseller);
		String xpath= "(//*[@class='sub-header-block' and text()='Reseller']/following-sibling::div/label)";
		int size = driver.findElements(By.xpath(xpath)).size();
		for(int i=1; i<size; i++)
			{
				String one = driver.findElement(By.xpath(xpath+"["+i+"]")).getText();
				testLogPass(Header+" - "+one);					
			}
		
		int togleBtn = driver.findElements(By.xpath("//*[@class='sub-header-block' and text()='Reseller']/following-sibling::div//div[starts-with(@class,'bootstrap-switch')]")).size();
		if(togleBtn!=0)
		{
			testLogPass("Toggel button is presnet for "+Header);
		}
	}
	
	public static void subReplenishBin()
	{
		clickOn(OR.organization_tab_Features);
		waitUntilPageReady();
		String Header= getText(OR.organization_Sub_ADFSAuth);
		String xpath= "(//*[@class='sub-header-block' and text()='ADFS Auth']/following-sibling::div/label)";
		int size = driver.findElements(By.xpath(xpath)).size();
		for(int i=1; i<size; i++)
			{
				String one = driver.findElement(By.xpath(xpath+"["+i+"]")).getText();
				testLogPass(Header+" - "+one);					
			}
		
		int togleBtn = driver.findElements(By.xpath("//*[@class='sub-header-block' and text()='ADFS Auth']/following-sibling::div//div[starts-with(@class,'bootstrap-switch')]")).size();
		if(togleBtn!=0)
		{
			testLogPass("Toggel button is presnet for "+Header);
		}
	}
	public static void adminAndUserPage()
	{	
		waitForElement(OR.DashBoard_AdminDropdown);
		clickOn(OR.DashBoard_AdminDropdown);
		clickOn(OR.Users_page);
		waitForElementToDisplayWithoutFail(OR.Users_FirstUserName, 10);					 
	}
	
	public static void searchAndUserWait()
	{	

		clickOn(OR.Users_SearchButton);
		waitForElementToDisplayWithoutFail(OR.Users_SearchTextBox, 10);	

	}

	public static void verifyTabs()
	{

		List<String> tabs = new ArrayList<String>( Arrays.asList("User", "User Access", "Item Catalog Access", "PO Alerts", "Facility Access", "Vendor Access", "Notification Access"));
		List<WebElement> actualTabs = driver.findElements
				(By.xpath("//ul[@class='nav nav-tabs']//a[@class='nav-link ng-binding']"));
		if(tabs.size() == actualTabs.size())
		{
			for(int i=0; i<tabs.size(); i++)
			{
				if(tabs.get(i).equals(actualTabs.get(i).getText()))
				{	
					testLogPass(tabs.get(i)+" Tab matched with " +actualTabs.get(i).getText());					
				}
				else
				{
					testLogFail(tabs.get(i)+" Tab doesnot matched with " +actualTabs.get(i).getText());	

				}
			}

		}	


		else
		{
			testLogFail("Both the Lists Donot have same number of Tabs");
		}

	}

	//For Facility Page

	public static void AdminAndFacilityLink()
	{	
		clickOn(OR.DashBoard_AdminDropdown);
		clickOn(OR.Facilty_FacilityLink);	
		waitForElementToDisplayWithoutFail(OR.Facilty_WaitforTableElem, 10);
	}
	//Item CAtegory page
	public static void AdminAndItemCat()
	{	
		clickOn(OR.DashBoard_AdminDropdown);
		clickOn(OR.ItemCat_PageLink);	
		waitForElementToDisplayWithoutFail(OR.ItemCat_pageContainerWait, 10);
	}

	public static void AdminAndPrintBarcodeLink()
	{	
		clickOn(OR.DashBoard_AdminDropdown);
		clickOn(OR.PrintBarcodes_PageLink);	
		//waitForElementToDisplayWithoutFail(OR.PrintBarcodes_waitforForFIrst, 10);
	}
	
	public static void SIPage()
	{	
		clickOn(OR.DashBoard_AdminDropdown);
		clickOn(OR.SI_PageLink);	
		//waitForElementToDisplay(OR.SI_TableWait, 10);
	}
	
	public static void PhysicianPage()
	{	
		clickOn(OR.DashBoard_AdminDropdown);
		clickOn(OR.Physician_PageLink);	
		//waitForElementToDisplay(OR.SI_TableWait, 10);
	}


	public static void InvoicePayementTermPage()
	{	
		clickOn(OR.DashBoard_AdminDropdown);
		clickOn(OR.Pterms_PageLink);	
		
	}

	public static void newsPage()
	{	
		clickOn(OR.DashBoard_AdminDropdown);
		clickOn(OR.News_PageLink);			
	}
	
	public static void vendorsPage()
	{	
		clickOn(OR.DashBoard_AdminDropdown);
		clickOn(OR.Vendor_PageLink);	
	}
	public static void priceTierPage()
	{	
		clickOn(OR.DashBoard_AdminDropdown);
		clickOn(OR.priceTier_PageLink);	
	}
	public static void itemCatalogPage()
	{	
		clickOn(OR.DashBoard_AdminDropdown);
		clickOn(OR.Admin_ItemCatalog);
		waitForElementToDisplay(OR.ItemCatalog_AddItem, 60);	
	}
	
	public static void InvLocationPage()
	{	
		clickOn(OR.DashBoard_AdminDropdown);
		clickOn(OR.InvLoc_PageLink);
		//waitForElementToDisplay(OR.ItemCatalog_AddItem, 60);	
	}
	
	public static WebElement matchFac_Inv()
	{	
		String INvLoc=getProperty("InventoryLocation");
		String userfac=getProperty("userdefaultFac");
		typeIn(OR.InvLoc_searchTextBox, INvLoc);
		waitForElementToDisplay(OR.InvLoc_waitfortable, 10);
		

		System.out.println("UserFac--" + userfac);
		System.out.println("GetText--" + getText(OR.InvLoc_firstInventoryLoc));
		

		if(getText(OR.InvLoc_firstInventoryLoc).trim().equalsIgnoreCase(userfac.trim()))
		{
			clickOn(OR.InvLoc_firstPlusIcon);
			List<WebElement> allFac=driver.findElements(By.xpath("//ul[@class='facility_department_sublist']/li"));
			for(WebElement elem:allFac)
			{
				String invName=elem.getText();
				if(INvLoc.trim().equalsIgnoreCase(invName.trim()))
				{ 
					return elem;					
				}
			}
		}
		return null;
	}

	public static List<String> getAllDeps()
	{	
		clickOn(OR.DashBoard_AdminDropdown);
		clickOn(OR.Dep_PageLink);
		String facName=getProperty("userdefaultFac");		
		selectFromDropdown(OR.Dep_SelectFac, facName);
		clickOn(OR.Dep_SearchButton);
		waitForElementToDisplay(OR.Dep_wait, 10);		
		List<WebElement> allDeps=driver.findElements(By.xpath("//*[@class='grid-item ng-scope']//*[@class='grid-heading grid-title-label ng-binding']"));
		depNames_FacPage= new ArrayList<String>() ;
		for(int i=1;i<=allDeps.size();i++)
		{
			String depName=allDeps.get(i-1).getText();
			System.out.println(depName);
			depNames_FacPage.add(depName);
		}
		return depNames_FacPage;
	}
	
	public static boolean ifButtonDisabled(String objLocator)
	{
		if(getAttributeValue(objLocator, "disabled")!=null)
			{
				return true;
			}
			else
			{
				return false;
			}			
	}
	
	public static void physicianPage()
	{
		clickOn(OR.DashBoard_AdminDropdown);
		clickOn(OR.Phy_pageLink);
		
	}
	
	public static void searchwithNPI()
	{
	String npi=getProperty("NPI_FOr_Physician");
	typeIn(OR.Phy_SearchTextBox, npi);
	String defFac=getProperty("userdefaultFac");
	selectFromDropdown(OR.Phy_SelectFac, defFac);
	clickOn(OR.Phy_SearchButton);
	waitForElementToDisplay(OR.Phy_wait, 20);
	
	}
	
	public static void manageApprovalPage()
	{
		clickOn(OR.DashBoard_AdminDropdown);
		clickOn(OR.AppPage_PageLink);
		
	}
	public static void manufacturerPage()
	{
		clickOn(OR.DashBoard_AdminDropdown);
		clickOn(OR.manufacturer_PageLink);
		
	}
	public static void glCode()
	{
		clickOn(OR.DashBoard_AdminDropdown);
		clickOn(OR.glCode_PageLink);
		
	}
	public static void patternPage()
	{
		clickOn(OR.DashBoard_AdminDropdown);
		clickOn(OR.pattern_PageLink);
		
	}
	
	public static void ItemReceiveInventory()
	{
		WebElement element = driver.findElement(By.xpath("//*[text()='Is Item Receive In Inventory']/following-sibling::div/div[starts-with(@class,'bootstrap-switch-')]"));
		String GetAttribute = element.getAttribute("class");
		if(GetAttribute.contains("bootstrap-switch-off"))
		{
			testLogPass("Item Receive Inventory toggle is off");
			element.click();
WebElement save =  driver.findElement(By.xpath("//button[text()='Save']"));
			executor.executeScript("arguments[0].click();", save);
			ApplicationKeyword.ProfileUpdateLogmeOut();
			OrgSettingChangerelogin();
		}else if(GetAttribute.contains("bootstrap-switch-on"))
		{
			testLogPass("Item Receive Inventory toggle is ON");
			
		}
	}
	
	public static void Crosswalkid()
	{
		WebElement element = driver.findElement(By.xpath("//*[text()='Use Cross walk id as item identifier']/following-sibling::div/div[starts-with(@class,'bootstrap-switch-')]"));
		String GetAttribute = element.getAttribute("class");
		String Valuecrosswalk = null;
		if(GetAttribute.contains("bootstrap-switch-off"))
		{
			testLogPass("Item Receive Inventory toggle is off");
			element.click();
		Valuecrosswalk = getAttributeValue(OR.organization_cross_walk_desc, "value");
WebElement save =  driver.findElement(By.xpath("//button[text()='Save']"));
			executor.executeScript("arguments[0].click();", save);
			OrgSettingChangerelogin();
		}else if(GetAttribute.contains("bootstrap-switch-on"))
		{
			testLogPass("Cross walk id toggle is ON");
			Valuecrosswalk = getAttributeValue(OR.organization_cross_walk_desc, "value");
		}
		clickOn(_OR.Dashboard_Submenu_shop);
		waitForElement(_OR.Dashboard_Submenu_shop);
		if(driver.findElements(By.xpath("//*[contains(text(),'"+Valuecrosswalk+"')]")).size()!=0)
		{
			testLogPass("crosswalk value is present");
		}
		else
		{
			testLogFail("Crosswalk id is not resent");
		}
	}
	
	public static void ItemIdentifier()
	{
		WebElement element = driver.findElement(By.xpath("//*[text()='Item Identifier']/following-sibling::div/div[starts-with(@class,'bootstrap-switch-')]"));
		String GetAttribute = element.getAttribute("class");
		String Valuecrosswalk = null;
		if(GetAttribute.contains("bootstrap-switch-off"))
		{
			testLogPass("Item Identifier toggle is off");
			element.click();
			Valuecrosswalk = getAttributeValue(OR.organization_item_identifier_desc, "value");
			WebElement save =  driver.findElement(By.xpath("//button[text()='Save']"));
			executor.executeScript("arguments[0].click();", save);
			OrgSettingChangerelogin();
		}else if(GetAttribute.contains("bootstrap-switch-on"))
		{
			testLogPass("Item Identifier is ON");
			Valuecrosswalk = getAttributeValue(OR.organization_item_identifier_desc, "value");
		}
		
		itemCatalogPage();
		clickOn(OR.Itemcatalog_btn_AddItem);
		waitUntilPageReady();
		if(driver.findElements(By.xpath("//*[contains(text(),'"+Valuecrosswalk+"')]")).size()!=0)
		{
			testLogPass("Item Identifier is present");
		}
		else
		{
			testLogFail("Item Identifier is not resent");
		}
		clickOn(OR.HeaderClose);
	}
	
	public static void VendorPreference()
	{
		WebElement element = driver.findElement(By.xpath("//*[text()='Vendor Preference']/following-sibling::div/div[starts-with(@class,'bootstrap-switch-')]"));
		String GetAttribute = element.getAttribute("class");
		String Valuecrosswalk = null;
		if(GetAttribute.contains("bootstrap-switch-off"))
		{
			testLogPass("Vendor Preference toggle is off");
			element.click();
			Valuecrosswalk = getAttributeValue(OR.organization_item_identifier_desc, "value");
			WebElement save =  driver.findElement(By.xpath("//button[text()='Save']"));
			executor.executeScript("arguments[0].click();", save);
			OrgSettingChangerelogin();
		}else if(GetAttribute.contains("bootstrap-switch-on"))
		{
			testLogPass("Vendor Preference is ON");
			Valuecrosswalk = getAttributeValue(OR.organization_item_identifier_desc, "value");
		}
	}
	
	public static void ApprovalRequirement()
	{
		WebElement element = driver.findElement(By.xpath("//*[text()='Approval Required']/following-sibling::div/div[starts-with(@class,'bootstrap-switch-')]"));
		String GetAttribute = element.getAttribute("class");
		if(GetAttribute.contains("bootstrap-switch-off"))
		{
			testLogPass("Approval Required toggle is off");
			element.click();
			WebElement save =  driver.findElement(By.xpath("//button[text()='Save']"));
			executor.executeScript("arguments[0].click();", save);
			OrgSettingChangerelogin();
		}else if(GetAttribute.contains("bootstrap-switch-on"))
		{
			testLogPass("Approval Required is ON");
		}
		ShowApproveDetails();
		PhysicianCostCenter();
			clickOn(OR.MyCart);
			Shopcart.Additem();
			waitUntilPageReady();
			if(driver.findElements(By.xpath("//*[contains(text(),'Attach Physician')]")).size()!=0)
			{
				testLogPass("Attach Physician is present");
			}
			else
			{
				testLogFail("Attach Physician is  not present");
			}
			waitUntilPageReady();
			if(driver.findElements(By.xpath("//*[@id='btnAdd' and contains(text(),'Generate PO')]")).size()!=0)
			{
				clickOn(OR.MyCart_GeneratePo);
			}
			waitUntilPageReady();
			if(driver.findElements(By.xpath("//*[text()='Generate PO']")).size()!=0)
			{
				clickOn(OR.Invoice_ConfirmButton);
			}
			waitUntilPageReady();
			if(driver.findElements(By.xpath("//*[text()='Min Order Value']")).size()!=0)
			{
				clickOn(OR.Invoice_ConfirmButton);
			}
			waitUntilPageReady();
			if(driver.findElements(By.xpath("(//tbody//*[contains(text(),'Assigned')])[1]")).size()!=0)
			{
				testLogPass("Item is in assigned state");
			}	
	}
	public static void ShowApproveDetails()
	{
		waitUntilPageReady();
		WebElement element = driver.findElement(By.xpath("//*[text()=\"Show Approver's details\"]/following-sibling::div/div[starts-with(@class,'bootstrap-switch-')]"));
		String GetAttribute = element.getAttribute("class");
		if(GetAttribute.contains("bootstrap-switch-off"))
		{
			testLogPass("ShowApproveDetails toggle is off");
			element.click();
			WebElement save =  driver.findElement(By.xpath("//button[text()='Save']"));
			executor.executeScript("arguments[0].click();", save);
			OrgSettingChangerelogin();
		}else if(GetAttribute.contains("bootstrap-switch-on"))
		{
			testLogPass("ShowApproveDetails is ON");
		}
	}
	
	public static void PhysicianCostCenter()
	{
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Physician Cost Center Check')]/following-sibling::div/div[starts-with(@class,'bootstrap-switch-')]"));
		String GetAttribute = element.getAttribute("class");
		if(GetAttribute.contains("bootstrap-switch-off"))
		{
			testLogPass("PhysicianPhysician is off");
			element.click();
			WebElement save =  driver.findElement(By.xpath("//button[text()='Save']"));
			executor.executeScript("arguments[0].click();", save);
			OrgSettingChangerelogin();
		}else if(GetAttribute.contains("bootstrap-switch-on"))
		{
			testLogPass("Physician is ON");
		}
	}
	
	
	public static void PhysicianCostCenterInActive()
	{
		waitUntilPageReady();
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Physician Cost Center Check')]/following-sibling::div/div[starts-with(@class,'bootstrap-switch-')]"));
		String GetAttribute = element.getAttribute("class");
		if(GetAttribute.contains("bootstrap-switch-off"))
		{
			testLogPass("ShowApproveDetails toggle is off");
			
		}else if(GetAttribute.contains("bootstrap-switch-on"))
		{
			testLogPass("ShowApproveDetails is ON");
			element.click();
			WebElement save =  driver.findElement(By.xpath("//button[text()='Save']"));
			executor.executeScript("arguments[0].click();", save);
			OrgSettingChangerelogin();
		}
	}
	
	public static void DepartmentCostCenterActive()
	{
		waitUntilPageReady();
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Department Cost Center')]/following-sibling::div/div[starts-with(@class,'bootstrap-switch-')]"));
		String GetAttribute = element.getAttribute("class");
		if(GetAttribute.contains("bootstrap-switch-off"))
		{
			testLogPass("Department Cost Center toggle is off");
			element.click();
			WebElement save =  driver.findElement(By.xpath("//button[text()='Save']"));
			executor.executeScript("arguments[0].click();", save);
			OrgSettingChangerelogin();
			
		}else if(GetAttribute.contains("bootstrap-switch-on"))
		{
			testLogPass("Department Cost Center is ON");
			
		}
	}
	
	public static void DepartmentCostCenterInActive()
	{
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Department Cost Center')]/following-sibling::div/div[starts-with(@class,'bootstrap-switch-')]"));
		String GetAttribute = element.getAttribute("class");
		if(GetAttribute.contains("bootstrap-switch-off"))
		{
			testLogPass("Department Cost Center toggle is off");
			
		}else if(GetAttribute.contains("bootstrap-switch-on"))
		{
			testLogPass("Department Cost Center is ON");
			element.click();
			WebElement save =  driver.findElement(By.xpath("//button[text()='Save']"));
			executor.executeScript("arguments[0].click();", save);
			OrgSettingChangerelogin();
			
		}
	}
	
	
	public static void  IsVendordisplayActive()
	{
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Is Vendor display Order')]/following-sibling::div/div[starts-with(@class,'bootstrap-switch-')]"));
		String GetAttribute = element.getAttribute("class");
		if(GetAttribute.contains("bootstrap-switch-off"))
		{
			testLogPass("Department Cost Center toggle is off");
			element.click();
			WebElement save =  driver.findElement(By.xpath("//button[text()='Save']"));
			executor.executeScript("arguments[0].click();", save);
			OrgSettingChangerelogin();
			
			
			System.out.println();
			
		}else if(GetAttribute.contains("bootstrap-switch-on"))
		{
			testLogPass("Department Cost Center is ON");
		}	
	}
	
	public static void  IsVendordisplayInActive()
	{
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Is Vendor display Order')]/following-sibling::div/div[starts-with(@class,'bootstrap-switch-')]"));
		String GetAttribute = element.getAttribute("class");
		if(GetAttribute.contains("bootstrap-switch-off"))
		{
			testLogPass("Department Cost Center toggle is off");
			
		}else if(GetAttribute.contains("bootstrap-switch-on"))
		{
			testLogPass("Department Cost Center is ON");
			element.click();
			WebElement save =  driver.findElement(By.xpath("//button[text()='Save']"));
			executor.executeScript("arguments[0].click();", save);
			OrgSettingChangerelogin();
		}	
	}
	
	
	public static void listcontract()
	{
		if(driver.findElements(By.xpath("//*[@id='use_list_price']")).size()!=0)
		{
			testLogPass("List price is present");
		}
		
		if(driver.findElements(By.xpath("//*[@id='use_list_price_no']")).size()!=0)
		{
			testLogPass("contract price is present");
		}
	}
	
	public static void UseMyPoActive()
	{
		waitUntilPageReady();
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Use My Own PO#:')]/following-sibling::div/div[starts-with(@class,'bootstrap-switch-')]"));
		String GetAttribute = element.getAttribute("class");
		if(GetAttribute.contains("bootstrap-switch-off"))
		{
			testLogPass("UseMy PO is off");
			element.click();
			WebElement save =  driver.findElement(By.xpath("//button[text()='Save']"));
			executor.executeScript("arguments[0].click();", save);
			OrgSettingChangerelogin();
		}
		else if(GetAttribute.contains("bootstrap-switch-on"))
		{
			testLogPass("UseMy PO Center is ON");
			
		}
	}

	public static void UseMyPoDeactive()
	{
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Use My Own PO#:')]/following-sibling::div/div[starts-with(@class,'bootstrap-switch-')]"));
		String GetAttribute = element.getAttribute("class");
		if(GetAttribute.contains("bootstrap-switch-off"))
		{
			testLogPass("UseMy PO is off");
		}
		else if(GetAttribute.contains("bootstrap-switch-on"))
		{
			testLogPass("UseMy PO Center is ON");
			element.click();
			WebElement save =  driver.findElement(By.xpath("//button[text()='Save']"));
			executor.executeScript("arguments[0].click();", save);
			OrgSettingChangerelogin();
		}
	}
	
	public static void PreferedItemKeyActive()
	{
		
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Preference Card')]/following-sibling::div/div[starts-with(@class,'bootstrap-switch-')]"));
		String GetAttribute = element.getAttribute("class");
		if(GetAttribute.contains("bootstrap-switch-off"))
		{
			testLogPass("Preference Card is off");
			element.click();
			PreferedItemKeyActivecalue();
			WebElement save =  driver.findElement(By.xpath("//button[text()='Save']"));
			executor.executeScript("arguments[0].click();", save);
			OrgSettingChangerelogin();
		}
		else if(GetAttribute.contains("bootstrap-switch-on"))
		{
			testLogPass("Preference Card is ON");
		}
	}
		
		
	public static void PreferedItemKeyInActive()
	{
		
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Preference Card')]/following-sibling::div/div[starts-with(@class,'bootstrap-switch-')]"));
		String GetAttribute = element.getAttribute("class");
		if(GetAttribute.contains("bootstrap-switch-off"))
		{
			testLogPass("Preference Card is off");
		}
		else if(GetAttribute.contains("bootstrap-switch-on"))
		{
			PreferedItemKeyActivecalue();
			testLogPass("Preference Card is ON");
			element.click();
			
			WebElement save =  driver.findElement(By.xpath("//button[text()='Save']"));
			executor.executeScript("arguments[0].click();", save);
			OrgSettingChangerelogin();
			
		}
	}
		
		
	public static void PreferedItemKeyActivecalue()
	{
		
		
		int element = driver.findElements(By.xpath("//*[@id='prefcard_item_key']/option")).size();
		for(int i= 1;i<=element;i++)
		{
			String DDvalue = driver.findElement(By.xpath("(//*[@id='prefcard_item_key']/option)["+i+"]")).getText();
			testLogPass("Preference Card Item Key - "+DDvalue);
		}
	}
	
	public static void DefaultActive()
	{
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Default Template Items Grouped')]/following-sibling::div/div[starts-with(@class,'bootstrap-switch-')]"));
		String GetAttribute = element.getAttribute("class");
		if(GetAttribute.contains("bootstrap-switch-off"))
		{
			testLogPass("Default Template Items is off");
element.click();
			
			WebElement save =  driver.findElement(By.xpath("//button[text()='Save']"));
			executor.executeScript("arguments[0].click();", save);
			OrgSettingChangerelogin();
		}
		else if(GetAttribute.contains("bootstrap-switch-on"))
		{
			
			testLogPass("Default Template Items is ON");
			
			
		}
	}
	
	public static void DefaultInActive()
	{
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Default Template Items Grouped')]/following-sibling::div/div[starts-with(@class,'bootstrap-switch-')]"));
		String GetAttribute = element.getAttribute("class");
		if(GetAttribute.contains("bootstrap-switch-off"))
		{
			testLogPass("Default Template Items is off");
		}
		else if(GetAttribute.contains("bootstrap-switch-on"))
		{
			
			testLogPass("Default Template Items is ON");
element.click();
			
			WebElement save =  driver.findElement(By.xpath("//button[text()='Save']"));
			executor.executeScript("arguments[0].click();", save);
			OrgSettingChangerelogin();
		}
	}
	
	public static void IsPriceTireInactive()
	{
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Price tier')]/following-sibling::div/div[starts-with(@class,'bootstrap-switch-')]"));
		String GetAttribute = element.getAttribute("class");
		if(GetAttribute.contains("bootstrap-switch-off"))
		{
			testLogPass("Default Template Items is off");
		}
		else if(GetAttribute.contains("bootstrap-switch-on"))
		{
			
			testLogPass("Default Template Items is ON");
element.click();
			
			WebElement save =  driver.findElement(By.xpath("//button[text()='Save']"));
			executor.executeScript("arguments[0].click();", save);
			OrgSettingChangerelogin();
		}
	}
	
	public static void IsPriceTireActive()
	{
		
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Price tier')]/following-sibling::div/div[starts-with(@class,'bootstrap-switch-')]"));
		String GetAttribute = element.getAttribute("class");
		if(GetAttribute.contains("bootstrap-switch-off"))
		{
			testLogPass("Default Template Items is off");
			element.click();
			WebElement save =  driver.findElement(By.xpath("//button[text()='Save']"));
			executor.executeScript("arguments[0].click();", save);
			OrgSettingChangerelogin();
		}
		else if(GetAttribute.contains("bootstrap-switch-on"))
		{
			testLogPass("Default Template Items is ON");

		}
	}
	
	public static void QuickBookActive()
	{
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Quick Book Integration:')]/following-sibling::div/div[starts-with(@class,'bootstrap-switch-')]"));
		String GetAttribute = element.getAttribute("class");
		if(GetAttribute.contains("bootstrap-switch-off"))
		{
			testLogPass("QuickBook is off");
			element.click();
			WebElement save =  driver.findElement(By.xpath("//button[text()='Save']"));
			executor.executeScript("arguments[0].click();", save);
			OrgSettingChangerelogin();
		}
		else if(GetAttribute.contains("bootstrap-switch-on"))
		{
			testLogPass("QuickBook is ON");
		}
	}
	
	public static void QuickbookInactive()
	{
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Quick Book Integration:')]/following-sibling::div/div[starts-with(@class,'bootstrap-switch-')]"));
		String GetAttribute = element.getAttribute("class");
		if(GetAttribute.contains("bootstrap-switch-off"))
		{
			testLogPass("QuickBook is off");
		}
		else if(GetAttribute.contains("bootstrap-switch-on"))
		{
			
			testLogPass("QuickBook is ON");
element.click();
			
			WebElement save =  driver.findElement(By.xpath("//button[text()='Save']"));
			executor.executeScript("arguments[0].click();", save);
			OrgSettingChangerelogin();
		}
	}
	
	public static void SageIntacctActive()
	{
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Sage Intacct Integration:')]/following-sibling::div/div[starts-with(@class,'bootstrap-switch-')]"));
		String GetAttribute = element.getAttribute("class");
		if(GetAttribute.contains("bootstrap-switch-off"))
		{
			testLogPass("Sage Intacct  is off");
			element.click();
			if(driver.findElements(By.xpath("//*[@name='configure_intacct']")).size()!=0)
			{
				testLogPass("configure_intacct is present");
				WebElement configure = driver.findElement(By.xpath("//*[@name='configure_intacct']"));
				configure.click();
				verifyElementText(OR.Authorize_Header, "Authorize with Intacct.");
				verifyElement(OR.Authorize_companyid);
				verifyElement(OR.Authorize_intacctid);
				verifyElement(OR.Authorize_intacctpass);
				verifyElement(OR.Authorize_Btn);
				verifyElement(OR.Authorize_BtnCancel);
				clickOn(OR.Authorize_BtnCancel);
			}
			else
			{
				testLogFail("configure_intacct is not present");
			}
			waitUntilPageReady();
			WebElement save =  driver.findElement(By.xpath("//button[text()='Save']"));
			executor.executeScript("arguments[0].click();", save);
			OrgSettingChangerelogin();
		}
		else if(GetAttribute.contains("bootstrap-switch-on"))
		{
			testLogPass("Sage Intacct  is ON");
			if(driver.findElements(By.xpath("//*[@name='configure_intacct']")).size()!=0)
			{
				testLogPass("configure_intacct is present");
			}
			else
			{
				testLogFail("configure_intacct is not present");
			}
		}
	}
	
	public static void SageIntacctInactive()
	{
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Sage Intacct Integration:')]/following-sibling::div/div[starts-with(@class,'bootstrap-switch-')]"));
		String GetAttribute = element.getAttribute("class");
		if(GetAttribute.contains("bootstrap-switch-off"))
		{
			testLogPass("Sage Intacct  is off");
		}
		else if(GetAttribute.contains("bootstrap-switch-on"))
		{	
			testLogPass("Sage Intacct  is ON");
			element.click();
			if(driver.findElements(By.xpath("//*[@name='configure_intacct']")).size()!=0)
			{
				testLogPass("configure_intacct is present");
				WebElement configure = driver.findElement(By.xpath("//*[@name='configure_intacct']"));
				configure.click();
				verifyElementText(OR.Authorize_Header, "Authorize with Intacct.");
				verifyElement(OR.Authorize_companyid);
				verifyElement(OR.Authorize_intacctid);
				verifyElement(OR.Authorize_intacctpass);
				verifyElement(OR.Authorize_Btn);
				verifyElement(OR.Authorize_BtnCancel);
				clickOn(OR.Authorize_BtnCancel);
			}
			else
			{
				testLogFail("configure_intacct is not present");
			}
			waitUntilPageReady();
			WebElement save =  driver.findElement(By.xpath("//button[text()='Save']"));
			executor.executeScript("arguments[0].click();", save);
			OrgSettingChangerelogin();
		}
	}
	
	
	public static void ResellerActive()
	{
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Reseller')]/following-sibling::div/div[starts-with(@class,'bootstrap-switch-')]"));
		String GetAttribute = element.getAttribute("class");
		if(GetAttribute.contains("bootstrap-switch-off"))
		{
			testLogPass("Reseller  is off");
			element.click();
			testLogPass("Reseller  is ON");
			waitUntilPageReady();
			
		}
		else if(GetAttribute.contains("bootstrap-switch-on"))
		{
			testLogPass("Reseller  is ON");
		}
	}
	
	public static void ReplenishBinActive()
	{
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Replenish Bin')]/following-sibling::div/div[starts-with(@class,'bootstrap-switch-')]"));
		String GetAttribute = element.getAttribute("class");
		if(GetAttribute.contains("bootstrap-switch-off"))
		{
			testLogPass("ReplenishBin is off");
			element.click();
			testLogPass("ReplenishBin  is ON");
			waitUntilPageReady();
			
		}
		else if(GetAttribute.contains("bootstrap-switch-on"))
		{
			testLogPass("ReplenishBin  is ON");
		}
	}
	
	public static void AdfAuthActive()
	{
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'ADFS Auth')]/following-sibling::div/div[starts-with(@class,'bootstrap-switch-')]"));
		String GetAttribute = element.getAttribute("class");
		if(GetAttribute.contains("bootstrap-switch-off"))
		{
			testLogPass("QuickBook is off");
			element.click();
			WebElement save =  driver.findElement(By.xpath("//button[text()='Save']"));
			executor.executeScript("arguments[0].click();", save);
			OrgSettingChangerelogin();
		}
		else if(GetAttribute.contains("bootstrap-switch-on"))
		{
			testLogPass("QuickBook is ON");
		}
	}
	
	public static void AdfAuthInactive()
	{
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'ADFS Auth')]/following-sibling::div/div[starts-with(@class,'bootstrap-switch-')]"));
		String GetAttribute = element.getAttribute("class");
		if(GetAttribute.contains("bootstrap-switch-off"))
		{
			testLogPass("QuickBook is off");
		}
		else if(GetAttribute.contains("bootstrap-switch-on"))
		{
			
			testLogPass("QuickBook is ON");
element.click();
			
			WebElement save =  driver.findElement(By.xpath("//button[text()='Save']"));
			executor.executeScript("arguments[0].click();", save);
			OrgSettingChangerelogin();
		}
	}
}