package funcation_PageObject;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework._OR;
import AutomationFramework.OR;

public class Manufacturers extends ApplicationKeyword{
 
	public static void NavigateToManufacture()
	{
		clickOn(_OR.DashBoard_Admin);
		clickOn(_OR.DashBoard_Admin_manufacturers);
		getTextchild("//*[@class='pagehead']");
	}
	
	public static void pageVerify()
	{
		Gridview();
		verifyElementText(OR.manufacturer_searchby, "Search by");
		verifyPagination();
		String ibe = getText(_OR.DashBoard_Admin_manufacturersFirst);
		typeIn(OR.InvoicePaymentTerm_SearchBox, ibe);
		clickOn(_OR.DashBoard_Admin_manufacturers_Searchbtn);
		
		
				
	}
 
}
