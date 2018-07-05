package testcases_functionality;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.python.jline.internal.TestAccessible;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.reporters.jq.TestPanel;

import com.relevantcodes.extentreports.ExtentReports;
import AutomationFramework.ApplicationKeyword;
import AutomationFramework.Generickeywords;
import AutomationFramework._OR;
import freemarker.core._DelayedShortClassName;
import AutomationFramework.OR;
import funcation_PageObject.*;
import pageObject.Alertpage;

public class TC_ShopCart extends ApplicationKeyword{

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
			extent = new ExtentReports(folderPath+"/Shopcart.html", true);
			extent.addSystemInfo("User Name", "QA");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}

	
	@Test
	public void TC_ShopCart_001() {
		testStarts("TC_ShopCart_001", "Verify that same facility appears selected at top which was selected on shop at the time of checkout.");
		Loginpage.OpenBrowserAndLoginnew();
		Shopcart.VerifyPage();
		Shopcart.matchFac();
		Shopcart.CartMore();
	}
	
	@Test
	public void TC_ShopCart_002() {
		testStarts("TC_ShopCart_002", "Show Tour > Verify that in each tour section, description for the highlighted section appears correct.");
		Shopcart.VerifyPage();
		typeIn(OR.MyCart_searchInCart, "dhsjhfjhjfhjfhdjfh");
		waitForElement(OR.MyCart_cartFor_NoElementFound);
		verifyElementText(OR.MyCart_cartFor_NoElementFound, "NO ITEMS FOUND.");
		typeIn(OR.MyCart_searchInCart, "");
		Shopcart.vendor();
	}
	
	@Test
	public void TC_ShopCart_003() {
		testStarts("TC_ShopCart_003", "Verify that Vendor Account Setup page gets opened when user clicks \" Account Setup\"");
		//Loginpage.OpenBrowserAndLoginnew();
		//Shopcart.VerifyPage();
		waitForElement(OR.MyCart);
		clickOn(OR.MyCart);
		String beforeadd = getText(OR.MyCart_count);
		int countitem =Integer.parseInt(beforeadd);
    	if(countitem==0)
    	{
    		Shopcart.Additem();
    	}
		Shopcart.AccountSetup();
	}
	
	@Test
	public void TC_ShopCart_004() {
		testStarts("TC_ShopCart_004", "Verify that Vendor Account Setup page gets opened when user clicks \" Account Setup\"");
		clickOn(OR.MyCart);
		Shopcart.Price();		
    	verifyElement(OR.MyCart_Receiveonly);
    	verifyElement(OR.MyCart_ReceiveonlyCheckbox);
		clickOn(OR.MyCart_drillDownVendor);
    	verifyElement(OR.MyCart_accountSetUp);
    	clickOn(OR.MyCart_accountSetUp);
    	getTextchild("//*[@class='pagehead']");
    }
	@Test
	public void TC_ShopCart_005()
	{
		testStarts("TC_ShopCart_005", "Verify that Tooltip with discount appears when user hovers price.");
		//Loginpage.OpenBrowserAndLoginnew();
//		clickOn(_OR.DashBoard_Admin);
//		waitForElement(_OR.DashBoard_Admin_organization);
//		clickOn(_OR.DashBoard_Admin_organization);
//		waitForElement(_OR.DashBoard_Admin_organization_Features);
//		clickOn(_OR.DashBoard_Admin_organization_Features);
//		waitForElement(OR.Shop_wait);
//		mouseOver(OR.Shop_Contractpriecradiobtn);
//		clickOn(OR.Shop_listpriecradiobtn);
//		mouseOver(OR.Template_Schedule_Savebtn);
//		clickOn(OR.Template_Schedule_Savebtn);
//		waitForElement(OR.Template_Warningok);
//		clickOn(OR.Template_Warningok);
		clickOn(OR.MyCart);
		String beforeadd = getText(OR.MyCart_count);
		int countitem =Integer.parseInt(beforeadd);
    	if(countitem==0)
    	{
    		Shopcart.Additem();
    	}
    	if(driver.findElements(By.xpath("//*[text()='Back Ordered']")).size()!=0)
    	{
    		mouseOver(OR.MyCart_BackOrder);
    			String one = driver.findElement(By.xpath("//*[@class='tooltip ng-scope ng-isolate-scope left fade in']")).getText();
    			testLogPass(one);
    	}
    	String attributeColor = getAttributeValue(OR.Template_Color, "class");
    	testLogPass("Color of the item is +"+attributeColor.replaceAll("ng-scope ", ""));
    	
//    	mouseOver(OR.MyCart_Price1);
//	    String one = driver.findElement(By.xpath("//*[@class='tooltip ng-scope ng-isolate-scope right fade in']")).getText();
//	    testLogPass(one);
//	    testLogPass(one);
	     getText(OR.MyCart_Grandtotal);
	     clickOn(OR.MyCart_usePo);
	     String PoNumber = randomAlphaNumeric(6)+"-001"; 
	    		 setProperty("GeneratePoNumber", PoNumber);
	    typeIn(OR.MyCart_GeneratePoNumber, PoNumber);
	    clickOn(OR.MyCart_GeneratePo);
	    ToastmesssageSucess();
	    clickOn(OR.Orders_Link);
	    typeIn(OR.Receive_SearchTextBox, PoNumber);
	    clickOn(OR.PrintBarcodes_searchButton);
	    driver.findElement(By.xpath("//*[text()='"+PoNumber+"']")).click();
	    String one = driver.getPageSource();
	    String one1 = getProperty("UserAddDeptName");		
	    if(one.contains(one1)) 
	    {
	    	testLogPass("Department assigned to item is displays in Po");
	    }
	}
	
	@Test
	public void TC_ShopCart_006()
	{
		testStarts("TC_ShopCart_006", "Verify that \"Inactive\" items do not appear in cart.");
		//Loginpage.OpenBrowserAndLoginnew();

		clickOn(OR.MyCart);
		String beforeadd = getText(OR.MyCart_count);
		int countitem =Integer.parseInt(beforeadd);
    	if(countitem==0)
    	{
    		Shopcart.Additem();
    	}
    	clickOn(_OR.DashBoard_Admin);
    	clickOn(_OR.DashBoard_Admin_items_catalog);
    	typeIn(OR.ItemCatalog_searchTextBox, getProperty("ItemDesc"));
    	
    	clickOn(OR.ItemCatalog_searchButtoncommon);
    	clickOn(OR.ItemCatalog_firstEDitButton);
    	verifyElementText(OR.EditItem_text,"Edit Item");
    	String attributevalue = getAttributeValue(OR.ItemCatalog_additem_Active_toogle, "class");
    	if(attributevalue.contains("bootstrap-switch-on"))
    	{
    		clickOn(OR.ItemCatalog_additem_Active_toogle);
    		clickOn(OR.ItemCatalog_Mapfacility_Save);
    		ToastmesssageSucess();
    	}
    	clickOn(OR.MyCart);
    	String beforeadd1 = getText(OR.MyCart_count);
		int countitem1 =Integer.parseInt(beforeadd1);
		if(countitem1 ==0)
		{
			testLogPass("Item is not displaying in the mycart");
		}
	}
	
	@Test
	public void TC_ShopCart_007()
	{
		testStarts("TC_ShopCart_007", "Verify that \"Attach department\" link appear below every item name.");
		//Loginpage.OpenBrowserAndLoginnew();
		clickOn(OR.MyCart);
		String beforeadd = getText(OR.MyCart_count);
		int countitem =Integer.parseInt(beforeadd);
    	if(countitem==0)
    	{
    		Shopcart.Additem();
    	}
    	String Dept = getProperty("UserAddDeptName");
    	if(driver.findElements(By.xpath("//a[contains(text(),'"+Dept+"')]")).size()!=0)
    	{
    		testLogPass("Department deep link is presnt for item");
    		driver.findElement(By.xpath("(//a[contains(text(),'"+Dept+"')])[1]")).click();
    		typeIn(OR.ItemCat_SearchTextBox, Dept);
    		waitForAngularLoad();
    		if(driver.findElements(By.xpath("//td[text()='"+Dept+"')]")).size()!=0)
        	{
    			testLogPass("Department search element is presnet "+Dept);	
        	}
    		typeIn(OR.ItemCat_SearchTextBox, "fdfdfjdkjfkdjfkdjf");
    		verifyElementText(OR.ItemCat_NoDataAvailable, "No data available");
    		clickOn(OR.csManufacture_Close);
    	}		
	}
	
	@Test
	public void TC_ShopCart_008()
	{
		testStarts("TC_ShopCart_008", "Verify that \"Attach Physician\" link with \"Attach Department\" link appear with levery item name.");
		//Loginpage.OpenBrowserAndLoginnew();
		clickOn(OR.MyCart);
		String beforeadd = getText(OR.MyCart_count);
		int countitem =Integer.parseInt(beforeadd);
    	if(countitem==0)
    	{
    		Shopcart.Additem();
    	}
   	String Dept = getProperty("UserAddDeptName");
    	if(driver.findElements(By.xpath("//a[contains(text(),'"+Dept+"')]")).size()!=0)
    	{
    		testLogPass("Department deep link is presnt for item");
    		
    		typeIn(OR.ItemCat_SearchTextBox, "fdfdfjdkjfkdjfkdjf");
    		verifyElementText(OR.ItemCat_NoDataAvailable, "No data available");
    		clickOn(OR.csManufacture_Close);
    	}	
    	Shopcart.Dropdown();
    	WebElement element = driver.findElement(By.xpath("//a[contains(text(),'"+Dept+"')]"));
	    Actions toolAct = new Actions(driver);
	    toolAct.moveToElement(element).build().perform();
    	verifyElement(OR.Template_Delete);
    	mouseOver(OR.Template_Delete);
    	String one = driver.findElement(By.xpath("//*[@class='tooltip ng-scope ng-isolate-scope top fade in']")).getText();
		testLogPass("Toottip "+ one);
		clickOn(OR.MyCart_AttachPhycian);
		verifyElementText(OR.MyCart_AttachPhycian_Physicians_title, "Physicians");
		clickOn(OR.csManufacture_Close);
	}
	
	@Test
	public void TC_ShopCart_009()
	{
		testStarts("TC_ShopCart_009", "Verify that “Special Instruction” text field appears for each vendor.");
		//Loginpage.OpenBrowserAndLoginnew();
		clickOn(OR.MyCart);
		String beforeadd = getText(OR.MyCart_count);
		int countitem =Integer.parseInt(beforeadd);
    	if(countitem==0)
    	{
    		Shopcart.Additem();
    	}
    	verifyElement(OR.MyCart_SpecialInstruction);
    		
    	String BeforeCount = driver.findElement(By.xpath("//*[@class='item-qty-editable-label ng-binding']")).getText();
    	int before = Integer.parseInt(BeforeCount);
    	
    	testLogPass("Before increasing the item "+before);
    	clickOn(OR.InvLoc_Add_PlusBtn);
    	waitForAngularLoad();
    	String AfterIncreaseCount = driver.findElement(By.xpath("//*[@class='item-qty-editable-label ng-binding']")).getText();
    	int After = Integer.parseInt(AfterIncreaseCount);
    	if(before!=After)
    	{
    		testLogPass("Price is increased");
    	}
    	clickOn(OR.InvLoc_Add_MinusBtn);
    	waitForAngularLoad();
    	String BeforeCount1 = driver.findElement(By.xpath("//*[@class='item-qty-editable-label ng-binding']")).getText();
    	int before1 = Integer.parseInt(BeforeCount1);
    	if(before1==before)
    	{
    		testLogPass("Price is decreasment");
    	}
		
    	waitForElementToDisplayWithoutFail(OR.MyCart_editItemQty, 10);
		clickOn(OR.MyCart_editItemQty);
		typeIn(OR.MyCart_editItemQtyTextBox, "0");
		waitForElementToDisplayWithoutFail(OR.MyCart_cancelQty, 10);
		clickOn(OR.MyCart_cancelQty);
		waitForElementToDisplayWithoutFail(OR.MyCart_editItemQty, 10);
		clickOn(OR.MyCart_editItemQty);
		typeIn(OR.MyCart_editItemQtyTextBox, "2");
		waitForElementToDisplayWithoutFail(OR.MyCart_submitQty, 10);
		clickOn(OR.MyCart_submitQty);
		waitForElementToDisplayWithoutFail(OR.MyCart_editItemQty, 10);
		clickOn(OR.MyCart_editItemQty);
		typeIn(OR.MyCart_editItemQtyTextBox, "1");
		waitForElementToDisplayWithoutFail(OR.MyCart_submitQty, 10);
		clickOn(OR.MyCart_submitQty);
    	String SpecialInstr = randomAlphaNumeric(8)+"sp1"; 
		setProperty("SpecialGenerateNumber", SpecialInstr);
    	typeIn(OR.MyCart_SpecialInstruction,SpecialInstr);
    	 String PoNumber = randomAlphaNumeric(9)+"-002"; 
		 setProperty("SpecialGeneratePoNumber", PoNumber);
		 
		 clickOn(OR.MyCart_usePo);
		 getTextchild("//*[@ng-model='checked_pos[key].check']");
		 typeIn(OR.MyCart_GeneratePoNumber, getProperty("GeneratePoNumber"));
		 clickOn(OR.MyCart_GeneratePo);
		 ToastmesssageSucess();
		 
typeIn(OR.MyCart_GeneratePoNumber, PoNumber);
clickOn(OR.MyCart_GeneratePo);
ToastmesssageSucess();
verifyElement(OR.MyCart_YourcartEmpty);
waitForElement(OR.Order_Myorder_txt);
verifyElement(OR.Order_Myorder_txt);
clickOn(OR.Orders_Link);
typeIn(OR.Receive_SearchTextBox, PoNumber);
clickOn(OR.PrintBarcodes_searchButton);
driver.findElement(By.xpath("//*[text()='"+PoNumber+"']")).click();
typeIn(OR.MyCart_SpecialInstruction,"");
clickOn(OR.MyCart_Save);
ToastmesssageSucess();
	}
	
	@AfterTest
	public void endReport()
	{
		closeBrowser();
		extent.flush();
	}
}


