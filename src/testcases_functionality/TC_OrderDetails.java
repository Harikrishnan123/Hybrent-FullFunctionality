package testcases_functionality;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import AutomationFramework.ApplicationKeyword;
import AutomationFramework.Generickeywords;
import AutomationFramework.OR;
import funcation_PageObject.*;

public class TC_OrderDetails extends ApplicationKeyword{

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
			extent = new ExtentReports(folderPath+"/OrderDetails.html", true);
			extent.addSystemInfo("User Name", "QA");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}

	
	@Test
	public void TC_OrderDetails_001() {
		testStarts("TC_OrderDetails_001", "Verify that PO number appears on top.");
		Loginpage.OpenBrowserAndLoginnew();
		clickOn(OR.Order);
		waitUntilPageReady();
		String one =driver.findElement(By.xpath("//a/i/sup")).getText();
		int COunt = Integer.parseInt(one);
		if(COunt!=0)
		{
			waitUntilPageReady();
			driver.findElement(By.xpath("//a/i/sup")).click();
			waitUntilPageReady();
			clickOn(OR.OrderDetails_Btn_GeneratePo);
			clickOn(OR.OrderDetails_Btn_ClearAllCart);
			clickOn(OR.Template_confirmButton);
			clickOn(OR.Confirmionok);
		}
		clickOn(OR.Order);
		OrderPage.SearchItem(getProperty("GeneratePoNumber"));
		if(driver.findElements(By.xpath("//*[text()='"+getProperty("GeneratePoNumber")+"']")).size()!=0)
		{
			driver.findElement(By.xpath("//*[text()='"+getProperty("GeneratePoNumber")+"']")).click();
			waitForElement(OR.OrderDetails_PO_Dropdown);
			getTextchild(" class='pagehead ng-binding'");
			verifyElement(OR.OrderDetails_Close);
			clickOn(OR.OrderDetails_Close);
			verifyElement(OR.Order_Search_Input);
		}	
	}
	
	@Test
	public void TC_OrderDetails_002() {
		testStarts("TC_OrderDetails_002", "Verify that on click \"Print\"  button PO details opened in new window.");
		//Loginpage.OpenBrowserAndLoginnew();
		waitForElement(OR.Order, 30);
		clickOn(OR.Order);
		OrderPage.SearchItem(getProperty("GeneratePoNumber"));
		if(driver.findElements(By.xpath("//*[text()='"+getProperty("GeneratePoNumber")+"']")).size()!=0)
		{
			driver.findElement(By.xpath("//*[text()='"+getProperty("GeneratePoNumber")+"']")).click();
			waitUntilPageReady();
			OrderPage.PrintPo();
		}	
	}
	
	@Test
	public void TC_OrderDetails_003() {
		testStarts("TC_OrderDetails_003", "Verify that following links appear under \"drop down\" button");
		//Loginpage.OpenBrowserAndLoginnew();
		clickOn(OR.Order);
		OrderPage.SearchItem(getProperty("GeneratePoNumber"));
		if(driver.findElements(By.xpath("//*[text()='"+getProperty("GeneratePoNumber")+"']")).size()!=0)
		{
			driver.findElement(By.xpath("//*[text()='"+getProperty("GeneratePoNumber")+"']")).click();
			waitUntilPageReady();
			   waitForElement(OR.OrderDetails_PO_Dropdown);
			   clickOn(OR.OrderDetails_PO_Dropdown);
				int Size = driver.findElements(By.xpath("//*[@class='dropdown-menu dropdown-menu-right']//li/a")).size();
				for(int i=1 ;i<=Size; i++)
				{
					String one = driver.findElement(By.xpath("(//*[@class='dropdown-menu dropdown-menu-right']//li/a)["+i+"]")).getText();
					testLogPass("Drop Down value is "+one);
				}
				
		}	
	}
	@Test
	public void TC_OrderDetails_004() {
		testStarts("TC_OrderDetails_004", "Verify that items in PO gets added to cart, when user clicks ADD ITEMS TO CART button");
		//Loginpage.OpenBrowserAndLoginnew();
		waitForElement(OR.Order, 30);
		clickOn(OR.Order);
		OrderPage.SearchItem(getProperty("GeneratePoNumber"));
		waitUntilPageReady();
		if(driver.findElements(By.xpath("//*[text()='"+getProperty("GeneratePoNumber")+"']")).size()!=0)
		{
			driver.findElement(By.xpath("//*[text()='"+getProperty("GeneratePoNumber")+"']")).click();
			waitUntilPageReady();
			   waitForElement(OR.OrderDetails_PO_Dropdown);
			   clickOn(OR.OrderDetails_PO_Dropdown);
				String Before = driver.findElement(By.xpath("(//i/sup)[2]")).getText();
				 waitForElementToDisplayWithoutFail(OR.OrderDetails_AdditemsToCart, 10);
					clickOn(OR.OrderDetails_AdditemsToCart);
					waitTime(4);
					if(driver.findElements(By.xpath("//*[text()='All the items of order already added in the cart.']")).size()!=0)
					{
						clickOn(OR.Confirmionok);
					}
					waitUntilPageReady();
					String After = driver.findElement(By.xpath("(//i/sup)[2]")).getText();	
					
					testLogPass(Before +"'Before adding item and after adding is "+After);
				
				
		}	
	}
	
	
	@Test
	public void TC_OrderDetails_005() {
		testStarts("TC_OrderDetails_005", "Verify that on clicking PO Log link, PO logs popup opens for that PO");
		//Loginpage.OpenBrowserAndLoginnew();
		waitForElement(OR.Order, 30);
		clickOn(OR.Order);
		OrderPage.SearchItem(getProperty("GeneratePoNumber"));
		if(driver.findElements(By.xpath("//*[text()='"+getProperty("GeneratePoNumber")+"']")).size()!=0)
		{
			driver.findElement(By.xpath("//*[text()='"+getProperty("GeneratePoNumber")+"']")).click();
			 waitForElementToDisplayWithoutFail(OR.OrderDetails_PO_Dropdown, 10);
				OrderDetailsPage.PrintLog();
				
		}	
	}
	@Test
	public void TC_OrderDetails_006() {
		testStarts("TC_OrderDetails_006", "Notes>Verify that Notes popup opens on clicking Notes link");
		//Loginpage.OpenBrowserAndLoginnew();
		waitForElement(OR.Order, 30);
		clickOn(OR.Order);
		OrderPage.SearchItem(getProperty("GeneratePoNumber"));
		if(driver.findElements(By.xpath("//*[text()='"+getProperty("GeneratePoNumber")+"']")).size()!=0)
		{
			driver.findElement(By.xpath("//*[text()='"+getProperty("GeneratePoNumber")+"']")).click();
				OrderDetailsPage.AddNotes();
				
		}	
	}
	
	@Test
	public void TC_OrderDetails_007() {
		testStarts("TC_OrderDetails_007", "Verify that \"Order Items\" popup opens on clicking the Print Items button.");
		//Loginpage.OpenBrowserAndLoginnew();
		waitForElement(OR.Order, 30);
		waitForElement(OR.Order);
		clickOn(OR.Order);
		OrderPage.SearchItem(getProperty("GeneratePoNumber"));
		waitUntilPageReady();
		if(driver.findElements(By.xpath("//*[text()='"+getProperty("GeneratePoNumber")+"']")).size()!=0)
		{
			driver.findElement(By.xpath("//*[text()='"+getProperty("GeneratePoNumber")+"']")).click();
				OrderDetailsPage.PrintItem();
				
		}	
	}
	
	@Test
	public void TC_OrderDetails_008() {
		testStarts("TC_OrderDetails_008", "Verify that Document popup opens on clicking document link");
		//Loginpage.OpenBrowserAndLoginnew();
		waitForElement(OR.Order, 30);
		clickOn(OR.Order);
		OrderPage.SearchItem(getProperty("GeneratePoNumber"));
		if(driver.findElements(By.xpath("//*[text()='"+getProperty("GeneratePoNumber")+"']")).size()!=0)
		{
			driver.findElement(By.xpath("//*[text()='"+getProperty("GeneratePoNumber")+"']")).click();
				OrderDetailsPage.viewDocumentForPO();
				
		}	
	}
	
	@Test
	public void TC_OrderDetails_009() {
		testStarts("TC_OrderDetails_009", "Invoices>Verify that on hovering Invoices link, \"Add Invoice\", \"All Invoices\" and Invoice number (if any) links appear.");
		//Loginpage.OpenBrowserAndLoginnew();
		waitForElement(OR.Order, 30);
		clickOn(OR.Order);
		OrderPage.SearchItem(getProperty("GeneratePoNumber"));
		waitUntilPageReady();
		if(driver.findElements(By.xpath("//*[text()='"+getProperty("GeneratePoNumber")+"']")).size()!=0)
		{
			driver.findElement(By.xpath("//*[text()='"+getProperty("GeneratePoNumber")+"']")).click();
				OrderDetailsPage.AddInvoiceInvoice();
				
		}	
	}
	
	@Test
	public void TC_OrderDetails_010() {
		testStarts("TC_OrderDetails_010", "Refresh>Verify that on clicking Refresh button all changes made in PO get saved.");
		//Loginpage.OpenBrowserAndLoginnew();
		waitForElement(OR.Order, 30);
		clickOn(OR.Order);
		OrderPage.SearchItem(getProperty("GeneratePoNumber"));
		waitUntilPageReady();
		if(driver.findElements(By.xpath("//*[text()='"+getProperty("GeneratePoNumber")+"']")).size()!=0)
		{
			driver.findElement(By.xpath("//*[text()='"+getProperty("GeneratePoNumber")+"']")).click();
				OrderDetailsPage.Refresh();
				waitForElement(OR.OrderDetails_PO_Dropdown);
				 clickOn(OR.OrderDetails_PO_Dropdown);
				Shopcart.Tour();
				testLogPass("Vendor Name is "+getText(OR.Shop_SHopfor_SelectfirstItemvendorName));
				mouseOver(OR.Shop_SHopfor_SelectfirstItemvendorName);
				getText(OR.OrderDetails_infos);
				getText(OR.OrderDetails__FacilityName);
				getText(OR.OrderDetails_DeptName);
				clickOn(OR.OrderDetails_Change_Facility_Department);
				waitForAngularLoad();
				Select s =  new Select(driver.findElement(By.id("facility")));
				String defaultItem = s.getFirstSelectedOption().getText();
				if(defaultItem.contains(getProperty("UserAddfailityName")))
				{
					testLogPass("Facilty name for the user are access");
				}
				else
				{
					System.out.println("Error");
				}
				
				Select s1 =  new Select(driver.findElement(By.id("department")));
				String defaultItem1 = s1.getFirstSelectedOption().getText();
				
				if(defaultItem1.contains(getProperty("UserAddDeptName")))
				{
					testLogPass("Department name for the user are access");
				}
				else
				{
					System.out.println("Error");
				}
				verifyElement(OR.ItemcaCategory_CreateCategory_btn_Close);
				clickOn(OR.InvoicePaymentTerm_Edit_Update);
				ToastmesssageSucess();
				getText(OR.OrderDetails_ShippingAddress);
				verifyElement(OR.OrderDetails_SpecialInstruction);
				getText(OR.OrderDetails_userinfo);
				getText(OR.OrderDetails_Approvedinfo);
				getText(OR.OrderDetails_TotalPo);
				testLogPass("item colr is "+getAttributeValue(OR.Template_Color, "class").replace("ng-scope ", ""));
				int size = driver.findElements(By.xpath("//table/thead/tr/th")).size();
				for(int i=2; i<=size;i++)
				{
					String value = driver.findElement(By.xpath("(//table/tbody/tr[2]/td)["+i+"]")).getText();
					String g = driver.findElement(By.xpath("(//table/thead/tr/th)["+i+"]")).getText();
					testLogPass(g+" ' = ' "+value);
				}
		}	
	}
	
	@Test
	public void TC_OrderDetails_011() {
		testStarts("TC_OrderDetails_011", "Verify that User is able to set any Item as Favourite");
		//Loginpage.OpenBrowserAndLoginnew();
		waitForElement(OR.Order, 30);
		clickOn(OR.Order);
		OrderPage.SearchItem(getProperty("GeneratePoNumber"));
		waitUntilPageReady();
		if(driver.findElements(By.xpath("//*[text()='"+getProperty("GeneratePoNumber")+"']")).size()!=0)
		{
			driver.findElement(By.xpath("//*[text()='"+getProperty("GeneratePoNumber")+"']")).click();
			waitForElementToDisplay(OR.Shop_ItemNameDropDown_First, 20);
			mouseOver(OR.Shop_ItemNameDropDown_First);
			clickOn(OR.Shop_ItemNameDropDown_First);
			
			verifyElementText(OR.Shop_ItemNameDropDownEdit_First, "Edit");
			WebElement Element = driver.findElement(By.xpath("//*[@class='dropdown-menu']//*[text()='Price Change History']"));
			executor.executeScript("arguments[0].scrollIntoView();", Element);
			verifyElementText(OR.Shop_ItemNameDropDownPricechangeHistory_First, "Price Change History");
			verifyElementText(OR.Shop_ItemNameDropDownPurchaceHistory_First, "Purchase History");
			
			
			
		String Fav = driver.findElement(By.xpath("//*[@uib-tooltip='Favourite']/i")).getAttribute("ng-if");
		if (Fav.equals("!isFavorite")) 
		{
				testLogPass("Order item is !isFavorite");
				driver.findElement(By.xpath("//*[@uib-tooltip='Favourite']/i")).click();
				testLogPass("Order item is isFavorite");
		}
		else if (Fav.equals("isFavorite")) 
		{
				testLogPass("Order item is isFavorite");
		}
		
		clickOn(OR.Shop_Menu);
		waitForElement(OR.Shop_SHopfor_FavOrderedradiobutton);
		clickOn(OR.Shop_SHopfor_FavOrderedradiobutton);
		typeIn(OR.Shop_searchfield, getProperty("ItemDesc"));
		if(getText(OR.PrintBarcodes_firstItem).contains(getProperty("ItemDesc")))
		{
			testLogPass("Item is in the fav in shop page.");
		}
		
		
		}
	}
	@Test
	public void TC_OrderDetails_012() {
		testStarts("TC_OrderDetails_012", "Verify that “Edit Item” popup appears when user clicks “Edit” button.");
		//Loginpage.OpenBrowserAndLoginnew();
		waitForElement(OR.Order, 30);
		clickOn(OR.Order);
		OrderPage.SearchItem(getProperty("GeneratePoNumber"));
		waitTime(4);
		if(driver.findElements(By.xpath("//*[text()='"+getProperty("GeneratePoNumber")+"']")).size()!=0)
		{
			driver.findElement(By.xpath("//*[text()='"+getProperty("GeneratePoNumber")+"']")).click();
			waitForElement(OR.Shop_ItemNameDropDown_First);
			clickOn(OR.Shop_ItemNameDropDown_First);
			waitForElement(OR.Shop_ItemNameDropDownEdit_First);
			clickOn(OR.Shop_ItemNameDropDownEdit_First);
			verifyElementText(OR.EditItem_text,"Edit Item");
			clickOn(OR.ItemCatalog_Close);
			// Price Change History
			waitForElement(OR.Shop_ItemNameDropDown_First);
			clickOn(OR.Shop_ItemNameDropDown_First);
			WebElement Element = driver.findElement(By.xpath("//*[@class='dropdown-menu']//*[text()='Price Change History']"));
			executor.executeScript("arguments[0].scrollIntoView();", Element);
			clickOn(OR.Shop_ItemNameDropDownPricechangeHistory_First);
			verifyElementText(OR.PriceChangeDetails_text, "Price Change Details");
			int size =driver.findElements(By.xpath("(//table/thead/tr/th)")).size();
			for(int i=1; i<=size;i++)
			{
				String one = driver.findElement(By.xpath("(//table/thead/tr/th)["+i+"]")).getText();
				testLogPass(one);
			}
			clickOn(OR.ItemCatalog_Close);
			// Purchace History
			waitForElement(OR.Shop_ItemNameDropDown_First);
			clickOn(OR.Shop_ItemNameDropDown_First);
			WebElement Element1 = driver.findElement(By.xpath("//*[@class='dropdown-menu']//*[text()='Price Change History']"));
			executor.executeScript("arguments[0].scrollIntoView();", Element1);
			clickOn(OR.Shop_ItemNameDropDownPurchaceHistory_First);
			String onedesc = driver.findElement(By.xpath("//p[@class='ng-binding']")).getText();
			testLogPass("Item name is "+onedesc);
			int size1 =driver.findElements(By.xpath("(//table/thead/tr/th)")).size();
			for(int i=1; i<=size1;i++)
			{
				String one1 = driver.findElement(By.xpath("(//table/thead/tr/th)["+i+"]")).getText();
				testLogPass(one1);
			}
			
			getTextchild("//*[@class='modal-title']");
			clickOn(OR.ItemCatalog_Close);
			mouseOver(OR.PrintBarcodes_firstItem);
			getText(OR.OrderDetails_itemToolTipDetails);
		}
	}
	
	
	@AfterTest
	public void endReport()
	{
		closeBrowser();
		extent.flush();
	}
}


