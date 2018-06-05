package funcation_PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.reporters.jq.TestPanel;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;

public class Shopcart extends ApplicationKeyword{
	
    public static void VerifyPage()
    {
    	verifyElement(OR.MyCart);
    	clickOn(OR.MyCart);
    	verifyElement(OR.MyCart_Sku);
    	verifyElement(OR.MyCart_Qty);
    	verifyElement(OR.MyCart_UOM);
    	verifyElement(OR.MyCart_status);
    	verifyElement(OR.MyCart_Price);
    	verifyElement(OR.MyCart_TotalPrice);
    	if(getText(OR.MyCart_cartFor_Details).contains(getProperty("ItemDesc")))
    	{
    		testLogPass("Facility are matching");
    	}
    	String beforeadd = getText(OR.MyCart_count);
    	int countitem =Integer.parseInt(beforeadd);
    	if(countitem==0)
    	{
    	Additem();
    	}
    }
    
    public static void matchFac()
	{	
	String facName =getProperty("UserAddfailityName");
	clickOn(OR.Shop_SHopfor_ShopfaclitySelect);
	waitForElementToDisplayWithoutFail(OR.Shop_SHopfor_Shopfaclity, 10);
	verifyElementText(OR.Shop_SHopfor_Shopfaclity, "Select Facility");
	waitForElementToDisplayWithoutFail(OR.Shop_countoffacilities, 10);
	int one = driver.findElements(By.xpath("//*[@style='border-right: none;vertical-align: middle;']")).size();
	boolean facFound=false;
	String xpath;
	String selectedFacility;
	WebElement btn;
	for(int i=1; i<=one; i++)
	{
		xpath="(//table[@class='table table-responsive table-striped table-bordered']/tbody/tr["+i+"]";
		selectedFacility=driver.findElement(By.xpath(xpath+"/td)")).getText();
		//System.out.println(selectedFacility);
		if(selectedFacility.equals(facName))
		{  
			facFound=true;
			btn= driver.findElement(By.xpath(xpath+"/td[2]/div/button)"));
			if(btn.getAttribute("disabled")!=null)
			{
				testLogPass("Go the text '"+selectedFacility+ "' Matches with selected Facility" );
			}
			else
			{
				testLogFail("'" + facName + "' is not selected in popup." );
			}
			break;
		}
	}
	if(!facFound)
	{
		testLogFail("Could not Got the text '"+facName+ "' Matches with selected Facility" );
	}
	clickOn(OR.Shop_SHopfor_cancelButtonPopup);
	}

    public static void Additem() 
    {
    	String beforeadd, AfterAdd;
    	beforeadd = getText(OR.MyCart_count);
    	int countitem =Integer.parseInt(beforeadd);
		testLogPass("before adding the item to cart is "+countitem);
		SearchItem(getProperty("ItemDesc"));
		waitUntilAngularReady();
		String one = getTextchild("//*[@class='modal-title']") ;
		if(one.contains("Item reorder warning"))
		{
			clickOn(OR.MyCart_warningPopup);
			System.out.println();
		}
		AfterAdd = getText(OR.MyCart_count);
		int AfterAdd1 =Integer.parseInt(AfterAdd);
		testLogPass("After adding the item to cart is "+AfterAdd1);
    }
    
    public static void CartMore()
    {
    	Select select = new Select(driver.findElement(By.xpath("//*[@id='shippingLocationDepartment']")));
    	WebElement option = select.getFirstSelectedOption();
    	String defaultItem = option.getText();
    	testLogPass("Default selected dropdown value is "+defaultItem);
    	waitForElement(OR.MyCart_cartFor_CartMore);
    	clickOn(OR.MyCart_cartFor_CartMore);
    	Tour();
    	waitForElement(OR.MyCart_cartFor_CartMore);
    	clickOn(OR.MyCart_cartFor_CartMore);
    	int Size = driver.findElements(By.xpath("//*[@tour-step='cart-more']//li/a")).size();
    	for(int i=1;i<=Size;i++)
    	{
    		String one = driver.findElement(By.xpath("(//*[@tour-step='cart-more']//li/a)["+i+"]")).getText();
    		testLogPass("Dropd Down value are "+one);
    		
    	}
    	for(int j=1;j<=Size;j++)
    	{
    		WebElement one = driver.findElement(By.xpath("(//*[@tour-step='cart-more']//li/a)["+j+"]"));
    		if(one.getText().contains("Clear Current Cart"))
    		{
    			one.click();
    			verifyElementText(OR.OrderDetails_DeleteConfirmion, "Are you sure you want to clear cart?");
    			clickOn(OR.Dep_Delete_Yes);
    			verifyElementText(OR.OrderDetails_DeleteSucessConfirmion, "Cart cleared successfully.");
    			clickOn(OR.Template_Warningok);
    			String s = driver.findElement(By.xpath("//*[text()='Your cart is Empty']")).getText();
    			
    			if(s.contains("Your cart is Empty"))
    			{
    				testLogPass("Card is empty");
    			}
    			break;
    		}
    		
    	}
    }
    
    public static void Tour()
    {
    	clickOn(OR.Shop_showTour1);
		testLogPass("Tour message is "+ getText(OR.Shop_showTour_Message));
		verifyElement(OR.Shop_showTour_Next);
		verifyElement(OR.Shop_showTour_EndTour);
		clickOn(OR.Shop_showTour_Next);
		testLogPass("Tour message is "+ getText(OR.Shop_showTour_Message));
		clickOn(OR.Shop_showTour_EndTour);
    }
    
    public static void SearchItem(String Search)
    {
    	typeIn(OR.MyCart_searchInCart, Search);
		clickOn(OR.Shop_GeneratePo);
    }
    
    public static void vendor()
    {
    	verifyElementText(OR.Mycard_GenderFor, "Generate for");
    	verifyElement(OR.Mycard_GenderFor_vendor);
    	clickOn(OR.MyCart_drillDownVendor);
    	verifyElement(OR.MyCart_accountSetUp);
    	verifyElement(OR.MyCart_removeVendor);
    	verifyElement(OR.MyCart_Checkaccount);
    	clickOn(OR.MyCart_removeVendor);
    	verifyElementText(OR.MyCart_removeVendor_validation, "Are you sure you want to remove this vendor's items from cart?");
    	clickOn(OR.Dep_Delete_Cancel);
    	clickOn(OR.MyCart_drillDownVendor);
    	waitForElement(OR.MyCart_removeVendor);
    	clickOn(OR.MyCart_removeVendor);
    	verifyElementText(OR.MyCart_removeVendor_validation, "Are you sure you want to remove this vendor's items from cart?");
    	clickOn(OR.Template_Yes);
    	if(isElementDisplayed(OR.Template_Warningok))
    	{
    	waitForElement(OR.Template_Warningok);
    	clickOn(OR.Template_Warningok);
    	}
    }
    
    public static void AccountSetup()
    {
    	    	clickOn(OR.MyCart_drillDownVendor);
    	    	verifyElement(OR.MyCart_accountSetUp);
    	    	clickOn(OR.MyCart_accountSetUp);
    	    	getTextchild("//*[@class='pagehead']");
    	    	int size = driver.findElements(By.xpath("//input[starts-with(@id,'facility_account_text')]")).size();
    	    	for(int i=1; i<=size; i++ )
    	    	{
    	    		driver.findElement(By.xpath("(//input[starts-with(@id,'facility_account_text')])["+i+"]")).sendKeys("123");
    	    		
    	    	}
    	    	WebElement element = driver.findElement(By.xpath("//button[text()='Close']"));
    	    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    	    	executor.executeScript("arguments[0].click();", element);

    	    	waitForElement(OR.MyCart_drillDownVendor);
    	    	clickOn(OR.MyCart_drillDownVendor);
    	    	verifyElement(OR.MyCart_accountSetUp);
    	    	clickOn(OR.MyCart_accountSetUp);
    	    	
    	    	int size1 = driver.findElements(By.xpath("//input[starts-with(@id,'facility_account_text')]")).size();
    	    	for(int j=1; j<=size1; j++ )
    	    	{
    	    		driver.findElement(By.xpath("(//input[starts-with(@id,'facility_account_text')])["+j+"]")).clear();
    	    		driver.findElement(By.xpath("(//input[starts-with(@id,'facility_account_text')])["+j+"]")).sendKeys("123");
    	    	}
    	    	
    	    	WebElement save = driver.findElement(By.xpath("//button[text()='Save']"));
    	    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", save);
    	    	executor.executeScript("arguments[0].click();", save);
    	    	//ToastmesssageSucess();
    }
    
    public static void Price()
    {
    	String s = driver.findElement(By.xpath("(//*[@ng-click='$ctrl.setItemPrice()()'])[1]")).getTagName();
		if(s.contains("a"))
		{
			testLogPass("Price contains the link");
			clickOn(OR.MyCart_Price1);
			verifyElementText(OR.MyCart_Price_updateprice, "Update Item Price");
			verifyElement(OR.Shop_UpdatePrice1);
			verifyElement(OR.ItemCatalog_FileUpload_CloseBtn);
			clickOn(OR.HeaderClose);
		}
		String s1 = driver.findElement(By.xpath("(//*[@ng-click='$ctrl.setItemPrice()()'])[1]")).getTagName();
		if(s1.contains("a"))
		{
			clickOn(OR.MyCart_Price1);
			clickOn(OR.ItemCatalog_FileUpload_CloseBtn);
		}
		String beforeprice = driver.findElement(By.xpath("//nobr")).getText();
		int pri = Integer.parseInt(beforeprice);
		int priceupdate;
		if(pri==0)
		{
			priceupdate = generateRandomInt1(2);
		}
		else
		{
			priceupdate = generateRandomInt1(2);
		}
		clickOn(OR.MyCart_Price1);
		String jprice = getText(OR.MyCart_UpdatePrice);
		int piruceget = Integer.parseInt(jprice);
		if(piruceget==priceupdate)
		{
			priceupdate =generateRandomInt1(3);
		}
		else
		{
		String sprice =Integer.toString(priceupdate);
			typeIn(OR.MyCart_UpdatePrice, sprice);
			clickOn(OR.Shop_UpdatePrice1);
		}
		ToastmesssageSucess();
		String afterupdate = driver.findElement(By.xpath("//nobr")).getText();
		testLogPass("After updating the price is "+afterupdate);
    }
}

