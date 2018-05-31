package funcation_PageObject;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;
import AutomationFramework._OR;

public class Barcode extends ApplicationKeyword{
    
	public static void NavigateToBarcode()
	{
		 clickOn(_OR.DashBoard_Admin);
		 clickOn(_OR.DashBoard_Admin_print_barcodes_qrcodes);
		 getTextchild("//*[@class='pagehead']");
	}
	
	public static void BarcodeFacility()
	{
		clickOn(OR.Barcode_Facility);
		verifyElement(OR.Barcode_Facility_Header);
		verifyElement(OR.Shop_SHopfor_SearchBox);
		typeIn(OR.Shop_SHopfor_SearchBox, "test");
		verifyElement(OR.manageInv_selectedButton);
		clickOn(OR.csManufacture_Close);
	}
	
	public static void Searchitem()
	{
		verifyElement(OR.Barcode_SearchItemByTxt);
		verifyElement(OR.Shop_VendorSelect);
		verifyElement(OR.Users_InventoryDropDownAddUSer);
		verifyElement(OR.PrintBarcodes_searchButton);
		verifyElement(OR.Barcode_ItemNameTxt);
		verifyElement(OR.Barcode_VendorTxt);
		verifyElement(OR.Barcode_SKUTxt);
		verifyElement(OR.Barcode_UOMTxt);
		verifyElement(OR.Barcode_StatusTxt);
		verifyElement(OR.Barcode_PriceTxt);
		verifyElement(OR.Patient_PrintIcon);
		clickOn(OR.Patient_PrintIcon);
		verifyElement(OR.print_header);
		verifyElement(OR.PrintBarcodes_text01);
		verifyElement(OR.PrintBarcodes_text02);
		verifyElement(OR.PrintBarcodes_text03);
		verifyElement(OR.PrintBarcodes_text04);
		verifyElement(OR.PrintBarcodes_PrintButton);
		
	}
	
	
	public static void PrintSheet()
	{
		
		verifyElement(OR.PrintBarcodes_sku1);
		clickOn(OR.PrintBarcodes_PrintButton);
		verifyElement(OR.PrintBarcodes_PDF_Print);
		clickOn(OR.PrintBarcodes_PDF_PrintClose);
		verifyPagination();
	}
	
}

