package funcation_PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;
import pageObject.MycartPage;

public class ApprovePO extends ApplicationKeyword{

	
	public static void NavigateApprovedPO()
	{
		waitForElement(OR.ApprovePOLink, 30);
		clickOn(OR.ApprovePOLink);
	}
	
	public static void Verifydetails()
    {
		waitForElementToDisplay(OR.Order_Vendor_txt, 60);
		getTextchild("//*[@class='pagehead ng-binding']").contains("Orders to Approve");
    	verifyElementText(OR.Order_Vendor_txt, "Vendor:");
    	verifyElement(OR.Order_Vendor_dropdown);
    	verifyElementText(OR.Order_type_txt, "Type:");
    	verifyElement(OR.Order_type_dropdown);
    	verifyElementText(OR.Order_depts_txt, "Departments:");
    	verifyElement(OR.Order_depts_dropdown);
    	verifyElementText(OR.Order_facility_txt, "Facility:");
    	verifyElement(OR.Order_facility_dropdown);
    	verifyElementText(OR.Order_creater_txt, "Created By:");
    	verifyElement(OR.Order_creater_dropdown);
    	verifyElementText(OR.Order_creater_txt, "Created By:");
    	verifyElement(OR.Order_Search_Input);
    	verifyElementText(OR.Order_Search_txt, "Search:");
    	verifyElement(OR.Order_SearrchBtn);
    }
	
	public static void Menu()
	{
		verifyElement(OR.ApprovePO_Menu_PO);
		verifyElement(OR.ApprovePO_Menu_VendorName);
		verifyElement(OR.ApprovePO_Menu_Status);
		verifyElement(OR.ApprovePO_Menu_RequestedCost);
		verifyElement(OR.ApprovePO_Menu_ReceivedCost);
		verifyElement(OR.ApprovePO_Menu_CreatedAt);
		verifyElement(OR.ApprovePO_Menu_Buyer);
		verifyElement(OR.ApprovePO_Menu_VendorName);
		verifyElement(OR.ApprovePO_Menu_VendorName);
		verifyElement(OR.ApprovePO_Menu_VendorName);
	}
	
	public static void shopFacility_ApprovePage()
	{		
		String alreadySelectedFac01=getProperty("userdefaultFac");
		System.out.println(alreadySelectedFac01);
		String alreadySelectedFac=getText(OR.ApprovePO_selectDefaultUser);
		System.out.println(alreadySelectedFac);
		boolean flag=false;
		boolean flaf_02=false;
		if(!alreadySelectedFac.equals(alreadySelectedFac01))
		{
			clickOn(OR.ApprovePO_facilityDropdown);
			WebElement elem=driver.findElement(By.xpath("//*[text()='"+alreadySelectedFac01+"']"));
			elem.click();
			flag=true;
		}	
		waitForElementToDisplayWithoutFail(OR.ApprovePO_selectCreater, 10);
		String alreadySelectedUser=getText(OR.ApprovePO_selectCreater);
		System.out.println(alreadySelectedUser);
		if(!alreadySelectedUser.equals("All"))
		{
			clickOn(OR.ApprovePO_UsersDropdown);
			WebElement elem2=driver.findElement(By.xpath("//*[text()='All']"));
			elem2.click();
			flaf_02=true;
		}
		if(flag||flaf_02)
		{
			clickOn(OR.Receive_searchButton);
		}
	} 
	
	public static void AddItem()
	{
		clickOn(OR.MyCart);
		waitForElement(OR.MyCart_searchInCart);
		typeIn(OR.MyCart_searchInCart, getProperty("ItemMfr"));
		waitForElement(OR.MyCart_addItemInCart);
		if(isElementDisplayed(OR.MyCart_addItemInCart))
		{
			clickOn(OR.MyCart_addItemInCart);
			
			waitForElement(OR.MyCart_drillDownVendor);
			
			String one = getText(OR.Shop_SHopfor_SelectfirstItemvendorName);
			setProperty("VendorNameShop", one);
			clickOn(OR.MyCart_drillDownVendor);
			waitForElement(OR.MyCart_accountSetUp);
			clickOn(OR.MyCart_accountSetUp);
			waitUntilPageReady();
			int size = driver.findElements(By.xpath("(//*[text()='Account Number*']/following-sibling::div/input )")).size();
			for(int i=1;i<=size;i++)
			{
				WebElement AccType = driver.findElement(By.xpath("(//*[text()='Account Number*']/following-sibling::div/input )["+i+"]"));
				String textInsideInputBox = AccType.getAttribute("value");
				if(textInsideInputBox.isEmpty())
				{
				AccType.clear();
				AccType.sendKeys("12");
				}
			}
			mouseOver(OR.VendorAccSetup_Save);
			WebElement element = driver.findElement(By.xpath("//button[text()='Save']"));
			executor.executeScript("arguments[0].click();", element);	
			ToastmesssageSucess();
			WebElement element1 = driver.findElement(By.xpath("//button[text()='Close']"));
			executor.executeScript("arguments[0].click();", element1);
		}
		clickOn(OR.MyCart_usePo);
		String PONumber = "PON-"+randomAlphaNumeric(6);
		setProperty("ApprovePONumber", PONumber);
		typeIn(OR.MyCart_usePo_value, getProperty("ApprovePONumber"));
		clickOn(OR.MyCart_GeneratePo);
		ToastmesssageSucess();
	}
	
	
	public static void VendorUnappove()
	{
		clickOn(OR.MyCart);
		waitForElement(OR.MyCart_searchInCart);
		typeIn(OR.MyCart_searchInCart, getProperty("ItemMfr"));
		waitForElement(OR.MyCart_addItemInCart);
		if(isElementDisplayed(OR.MyCart_addItemInCart))
		{
			clickOn(OR.MyCart_addItemInCart);
			
			waitForElement(OR.MyCart_drillDownVendor);
			
			String one = getText(OR.Shop_SHopfor_SelectfirstItemvendorName);
			setProperty("VendorNameShop", one);
		}
		
		ApprovalFlow.NavigateToApprovalflow();
		clickOn(OR.Order_FacilityDropDown);
		driver.findElement(By.xpath("//*[@id='facility']/input[1]")).sendKeys(getProperty("UserAddfailityName"));
		driver.findElement(By.xpath("//*[@id='facility']/input[1]")).sendKeys(Keys.ENTER);
		clickOn(OR.Phy_SearchButton	);
		//ApprovalFlow.SearchFlow(getProperty("UserAddfailityName"));
		waitForElement(OR.ApprovalFlow_First_ManageFlow);
		clickOn(OR.ApprovalFlow_First_ManageFlow);
		waitForElement(OR.Approvalflow_MangeFlow_Edit);
		clickOn(OR.Approvalflow_MangeFlow_Edit);
		
		String attrvalue = driver.findElement(By.xpath("//*[text()='Auto approve PO if created by this user']/following-sibling::div/div")).getAttribute("class");
		if(attrvalue.contains("bootstrap-switch-on"))
		{
			driver.findElement(By.xpath("//*[text()='Auto approve PO if created by this user']/following-sibling::div/div")).click();
		}
		
		clickOn(OR.glCode_saveButton);
		
		ProfileUpdateLogmeOut();
	}
	
	
	public static void SearchNavigation()
	{
		NavigateApprovedPO();
		waitForElement(OR.Receive_SearchTextBox, 60);
		typeIn(OR.Receive_SearchTextBox, getProperty("ApprovePONumber"));
		clickOn(OR.News_searchButton);
	}
	
	public static void DrillDowntext()
	{
		waitForElement(OR.Receive_DrillDownIcon);
		clickOn(OR.Receive_DrillDownIcon);
		int size = driver.findElements(By.xpath("(//ul[@class=\"dropdown-menu\"])[1]/li/a")).size();
		for(int i=1 ;i<=size;i++)
		{
			String j = driver.findElement(By.xpath("((//ul[@class='dropdown-menu'])[1]/li/a)["+i+"]")).getText();
			testLogPass(j);
		}
	}
	
	public static void Apprvalicon()
	{
		waitForElement(OR.Receive_DrillDownIcon);
		clickOn(OR.Receive_DrillDownIcon);
		mouseOver(OR.ApprovePO_approve);
		int size = driver.findElements(By.xpath("//tbody/tr[1]/td[8]/div/ul/li[1]/ul/li")).size();
		for(int i=1 ;i<=size;i++)
		{
			String j = driver.findElement(By.xpath("//tbody/tr[1]/td[8]/div/ul/li[1]/ul/li["+i+"]/a"+i+"]")).getText();
			testLogPass(j);
		}
	}
	
	public static void ApproveFlow()
	{
		waitUntilPageReady();
		if(driver.findElements(By.xpath("//*[text()='"+getProperty("ApprovePONumber")+"']")).size()!=0)
		{
			driver.findElement(By.xpath("//*[text()='"+getProperty("ApprovePONumber")+"']")).click();
			clickOn(OR.Approvalflow_Approve);
			//ToastmesssageSucess();
		}
		verifyElement(OR.Order_Search_txt);
	}
	
	public static void RejectFlow()
	{
		AddItemForVerify();
			clickOn(OR.Approvalflow_Reject);
			verifyElementText(OR.Approvalflow_Reject_validation, "Are you sure? Do you want to reject this order?");
			clickOn(OR.Dep_Delete_Cancel);
			waitForElement(OR.Approvalflow_Reject);
			clickOn(OR.Approvalflow_Reject);
			verifyElementText(OR.Approvalflow_Reject_validation, "Are you sure? Do you want to reject this order?");
			clickOn(OR.MyCart_confirmButton);
			
		
		verifyElement(OR.Order_Search_txt);
	}
	
	public static void AddItemForVerify()
	{
		clickOn(OR.MyCart);
		waitForElement(OR.MyCart_searchInCart);
		typeIn(OR.MyCart_searchInCart, getProperty("ItemMfr"));
		waitForElement(OR.MyCart_addItemInCart);
		if(isElementDisplayed(OR.MyCart_addItemInCart))
		{
			clickOn(OR.MyCart_addItemInCart);
			if(isElementDisplayed(OR.MyCart_warningPopup))
			{
				clickOn(OR.MyCart_warningPopup);
			}
		}	
		waitForElement(OR.MyCart_usePo);
			String one = getText(OR.Shop_SHopfor_SelectfirstItemvendorName);
			setProperty("VendorNameShop", one);
			clickOn(OR.MyCart_usePo);
			String PONumber = "PONs-"+randomAlphaNumeric(6);
			setProperty("ApprovePONumber", PONumber);
			typeIn(OR.MyCart_usePo_value, getProperty("ApprovePONumber"));
			clickOn(OR.MyCart_GeneratePo);
			ToastmesssageSucess();
		
		NavigateApprovedPO();
		waitUntilPageReady();
		if(driver.findElements(By.xpath("//*[text()='"+getProperty("ApprovePONumber")+"']")).size()!=0)
		{
			driver.findElement(By.xpath("//*[text()='"+getProperty("ApprovePONumber")+"']")).click();
		}
	}
	
	   public static void PrintItem()
	   {
		   waitForElementToDisplayWithoutFail(OR.Order_dropDownIcon, 10);
			clickOn(OR.OrderDetails_PO_Dropdown);
			clickOn(OR.OrderDetails_PrintItems);
			waitForElementToDisplayWithoutFail(OR.Receive_printPOText, 10);		
			getText(OR.Receive_printPOText);
			
	   }
	   
	   public static void Barcode()
	   {
		   clickOn(OR.Approvalflow_PrintItem_GeneratePO);
			verifyElement(OR.Approvalflow_PrintItem_Barcode);
			verifyElement(OR.Approvalflow_PrintItem_QRCODE);
		   clickOn(OR.Approvalflow_PrintItem_Barcode);
		   String ItemName = driver.findElement(By.xpath("//*[@id='viewer']/div/div[2]/div[1]")).getText();
		   testLogPass("ItemName is "+ItemName);
		   String Sku = driver.findElement(By.xpath("//*[@id='viewer']/div/div[2]/div[3]")).getText();
		   testLogPass(Sku);
		   clickOn(OR.ItemCatalog_Close);
	   }
	   public static void QRcode()
	   {
		   clickOn(OR.Approvalflow_PrintItem_GeneratePO);
			verifyElement(OR.Approvalflow_PrintItem_Barcode);
		   clickOn(OR.Approvalflow_PrintItem_QRCODE);
		   String ItemName = driver.findElement(By.xpath("//*[@id='viewer']/div/div[2]/div[1]")).getText();
		   testLogPass("VendorName is "+ItemName);
		   String Sku = driver.findElement(By.xpath("//*[@id='viewer']/div/div[2]/div[3]")).getText();
		   testLogPass(Sku);
		   clickOn(OR.ItemCatalog_Close);
		   waitForElement(OR.csManufacture_Close);
		   clickOn(OR.csManufacture_Close);
	   }
	   
	
}
