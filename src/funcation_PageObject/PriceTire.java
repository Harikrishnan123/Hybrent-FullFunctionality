package funcation_PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;
import AutomationFramework._OR;

public class PriceTire extends ApplicationKeyword{
	
	public static void NavigateToPricetire()
	{
		clickOn(_OR.DashBoard_Admin);
		clickOn(_OR.DashBoard_Admin_pricetier);
		verifyElement(OR.PriceTire_PageTitle);
	}
	
	public static void PageVerification()
	{
		verifyElement(OR.PriceTire_BtnVendorPrice);
		verifyElement(OR.PriceTire_btnAdd);
		verifyElement(OR.PriceTire_SearchBox);
	}
	
	public static void CreatePriceTire()
	{
		String Price_Name ="Ankur"+randomAlphaNumeric(5);
		String Price = "1.8";
		setProperty("PriceTire_Name", Price_Name);
		setProperty("PriceTire_Price", Price);
		verifyElement(OR.PriceTire_AddBtn);
		clickOn(OR.PriceTire_AddBtn);
		verifyElementText(OR.PriceTire_Add_AddPriceTire, "Add Price Tier");
		verifyElement(OR.PriceTire_Add_Nametxt);
		verifyElement(OR.PriceTire_Add_PricePercentagetxt);
		getText(OR.PriceTire_Add_Healpdesk);
		verifyElement(OR.PriceTire_Add_Save);
		verifyElement(OR.PriceTire_Add_Close);
		typeIn(OR.PriceTire_Add_Name_Input, Price_Name);
		typeIn(OR.PriceTire_Add_price_percentage_Input, Price);
		clickOn(OR.PriceTire_Add_Close);
		waitForElementToDisplay(OR.PriceTire_AddBtn, 12);
		clickOn(OR.PriceTire_AddBtn);
		typeIn(OR.PriceTire_Add_Name_Input, Price_Name);
		typeIn(OR.PriceTire_Add_price_percentage_Input, Price);
		clickOn(OR.PriceTire_Add_Save);
		ToastmesssageSucess();
		waitForElementToDisplay(OR.PriceTire_AddBtn, 12);
		waitTime(10);
		clickOn(OR.PriceTire_AddBtn);
		typeIn(OR.PriceTire_Add_Name_Input, Price_Name);
		typeIn(OR.PriceTire_Add_price_percentage_Input, Price);
		clickOn(OR.PriceTire_Add_Save);
		ToastmesssageSucess();
		clickOn(OR.PriceTire_Add_Close);
	}
	
	public static void EditPriceTire()
	{
	
		verifyElement(OR.PriceTire_EditPrice);
		verifyElement(OR.PriceTire_Delete);
		verifyPagination();
		clickOn(OR.PriceTire_EditPrice);
		waitForElement(OR.PriceTire_EditPrice_Pagetitle);
		verifyElementText(OR.PriceTire_EditPrice_Pagetitle, "Edit Price Tier");
		
		String Price_Name ="Ankur"+randomAlphaNumeric(5);
		String Price = "1.8";
		setProperty("PriceTire_Name", Price_Name);
		setProperty("PriceTire_Price", Price);
		
		
		verifyElement(OR.PriceTire_Add_Nametxt);
		verifyElement(OR.PriceTire_Add_PricePercentagetxt);
		getText(OR.PriceTire_Add_Healpdesk);
		verifyElement(OR.PriceTire_Add_Save);
		verifyElement(OR.PriceTire_Add_Close);
		typeIn(OR.PriceTire_Add_Name_Input, Price_Name);
		typeIn(OR.PriceTire_Add_price_percentage_Input, Price);
		clickOn(OR.PriceTire_Add_Close);
		waitForElementToDisplay(OR.PriceTire_AddBtn, 12);
		clickOn(OR.PriceTire_AddBtn);
		typeIn(OR.PriceTire_Add_Name_Input, Price_Name);
		typeIn(OR.PriceTire_Add_price_percentage_Input, Price);
		clickOn(OR.PriceTire_Add_Save);
		ToastmesssageSucess();
	}
	
	public static void VendorPircetire()
	{
		clickOn(OR.PriceTire_BtnVendorPrice);
		verifyElement(OR.VendorAccSetup_SelctVendor);
		selectFromDropdown(OR.VendorAccSetup_VendorDropdown, 1);
		String one = getProperty("UserAddfailityName");
		String s = "//*[contains(text(),'"+one+"')]/following-sibling::div/select";
		WebElement ele = driver.findElement(By.xpath(s));
		Select se = new Select(ele);
		se.selectByIndex(1);
		mouseOver(OR.VendorAccSetup_Save);
		clickOn(OR.VendorAccSetup_Save);
		ToastmesssageSucess();
		
	}
	
	public static void Search()
	{
		typeIn(OR.PriceTire_SearchBox, getProperty("PriceTire_Name"));	
	}
	
	public static void Delete()
	{
		String Price_Name ="Del"+randomAlphaNumeric(5);
		String Price = "1.8";
		verifyElement(OR.PriceTire_AddBtn);
		clickOn(OR.PriceTire_AddBtn);
		typeIn(OR.PriceTire_Add_Name_Input, Price_Name);
		typeIn(OR.PriceTire_Add_price_percentage_Input, Price);
		clickOn(OR.PriceTire_Add_Save);
		ToastmesssageSucess();
		typeIn(OR.PriceTire_SearchBox, Price_Name);	
		clickOn(OR.PriceTire_Delete);
		waitForElement(OR.PriceTire_DeleteValidation);
		clickOn(OR.PriceTire_Delete_cancel);
		waitForElement(OR.PriceTire_Delete);
		clickOn(OR.PriceTire_Delete);
		waitForElement(OR.PriceTire_DeleteValidation);
		clickOn(OR.PriceTire_Delete_Yes);
		ToastmesssageSucess();
		typeIn(OR.PriceTire_SearchBox, getProperty("PriceTire_Name"));	
		clickOn(OR.PriceTire_Delete);
		waitForElement(OR.PriceTire_DeleteValidation);
		clickOn(OR.PriceTire_Delete_Yes);
		ToastmesssageSucess();
		
	}
}
