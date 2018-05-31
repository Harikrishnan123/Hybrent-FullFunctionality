package funcation_PageObject;

import org.openqa.selenium.By;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework._OR;
import AutomationFramework.OR;

public class InvoicePaymentTerms extends ApplicationKeyword{

	public static void VerifyPage()
	{
		verifyElement(OR.InvoicePaymentTerm_Title);
		verifyElement(OR.InvoicePaymentTerm_SearchBox);
		verifyElement(OR.InvoicePaymentTerm_Descriptiontxt);
		verifyElement(OR.InvoicePaymentTerm_Typetxt);
		verifyElement(OR.InvoicePaymentTerm_NoOfDaystxt);
		verifyElement(OR.InvoicePaymentTerm_Discounttxt);
		verifyElement(OR.InvoicePaymentTerm_AddPayment_Btn);
	}
	
	public static void NavigateToInvoicePaymentTerms()
	{
		clickOn(_OR.DashBoard_Admin);
		clickOn(_OR.DashBoard_Admin_invoicepaymentservice);
		getTextchild("//*[@class='pagehead']");
		verifyPagination();
	}
	
	public static void AddPayment()
	{
		clickOn(OR.InvoicePaymentTerm_AddPayment_Btn);
		verifyElementText(OR.InvoicePaymentTerm_AddPayment_Header, "Add Payment Term");
		verifyElementText(OR.InvoicePaymentTerm_AddPayment_Description_Label, "Description :");
		verifyElementText(OR.InvoicePaymentTerm_AddPayment_Type_Label, "Type :");
		verifyElementText(OR.InvoicePaymentTerm_AddPayment_Day_Label, "Day(s) :");
		verifyElementText(OR.InvoicePaymentTerm_AddPayment_Percent_Label, "Percent (%) :");
		verifyElementText(OR.InvoicePaymentTerm_AddPayment_APIntegratiot_Label, "AP Integration ID :");
		verifyElement(OR.InvoicePaymentTerm_AddPayment_CancelButtton);
		verifyElement(OR.InvoicePaymentTerm_AddPayment_addButtton);
		String Desc = "TestDEs"+randomAlphaNumeric(7);
		String Edit ="Edit"+randomAlphaNumeric(6);
		int size = driver.findElements(By.xpath("//*[@id='paymentTermType']/option")).size();
				for(int i=1;i<=size;i++)
				{
					String one = driver.findElement(By.xpath("(//*[@id='paymentTermType']/option)["+i+"]")).getText();
					testLogPass("Payement options are "+one);
					selectFromDropdown(OR.InvoicePaymentTerm_AddPayment_paymentTermType_Selectdropdown, one);
				}
				typeIn(OR.Pterms_addDesc, Desc);
				typeIn(OR.InvoicePaymentTerm_AddPayment_Day_Input, "2");
				typeIn(OR.InvoicePaymentTerm_AddPayment_Percent, "103");
				typeIn(OR.InvoicePaymentTerm_AddPayment_APIntegratiot, "text");
				clickOn(OR.InvoicePaymentTerm_AddPayment_CancelButtton);
				waitForElement(OR.InvoicePaymentTerm_AddPayment_Btn, 40);
				clickOn(OR.InvoicePaymentTerm_AddPayment_Btn);
				typeIn(OR.Pterms_addDesc, "12");
				typeIn(OR.InvoicePaymentTerm_AddPayment_Day_Input, "2");
				typeIn(OR.InvoicePaymentTerm_AddPayment_Percent, "2");
				typeIn(OR.InvoicePaymentTerm_AddPayment_APIntegratiot, "text");
				clickOn(OR.InvoicePaymentTerm_AddPayment_addButtton);
				ToastmesssageSucess();
				typeIn(OR.Pterms_addDesc,Desc);
				clickOn(OR.InvoicePaymentTerm_AddPayment_addButtton);
				ToastmesssageSucess();
				Edit(Desc, Edit);
				Delete(Edit);
				
	}
	
	public static void Edit(String search, String Edit)
	{
		typeIn(OR.InvoicePaymentTerm_SearchBox, search);
		clickOn(OR.InvoicePaymentTerm_Editicon);
		verifyElementText(OR.InvoicePaymentTerm_Edit_Header, "Update Payment Term");
		typeIn(OR.Pterms_addDesc,Edit);
		clickOn(OR.InvoicePaymentTerm_Edit_Update);
		ToastmesssageSucess();
	}
	
	public static void Delete(String search)
	{
		typeIn(OR.InvoicePaymentTerm_SearchBox, search);
		clickOn(OR.InvoicePaymentTerm_Deleteicon);
		testLogPass("delete validation"+getText(OR.PriceTire_DeleteValidation));
		clickOn(OR.Dep_Delete_Yes);
		verifyElementText(OR.InvoicePaymentTerm_Delete_sucess, "Payment Term deleted successfully.");
		clickOn(OR.InvoicePaymentTerm_Delete_Ok);
		
	}
	
	public static void Duplicate()
	{
		String Des ="Test"+randomAlphaNumeric(5);
		String Days ="2";
		typeIn(OR.InvoicePaymentTerm_SearchBox, "Other");
		if(driver.findElements(By.xpath("(//i[@class='fa fa-trash-o'])[1]")).size()==0)
		{
			testLogPass("Other dont have the edit and delete action");
		}
		clickOn(OR.InvoicePaymentTerm_AddPayment_Btn);
		verifyElementText(OR.InvoicePaymentTerm_AddPayment_Header, "Add Payment Term");
		typeIn(OR.Pterms_addDesc, Des);
		typeIn(OR.InvoicePaymentTerm_AddPayment_Day_Input, Days);
		typeIn(OR.InvoicePaymentTerm_AddPayment_Percent, "1");
		typeIn(OR.InvoicePaymentTerm_AddPayment_APIntegratiot, "text");
		clickOn(OR.InvoicePaymentTerm_AddPayment_addButtton);
		ToastmesssageSucess();
		waitForElement(OR.InvoicePaymentTerm_AddPayment_Btn, 40);
		clickOn(OR.InvoicePaymentTerm_AddPayment_Btn);
		verifyElementText(OR.InvoicePaymentTerm_AddPayment_Header, "Add Payment Term");
		typeIn(OR.Pterms_addDesc, Des);
		typeIn(OR.InvoicePaymentTerm_AddPayment_Day_Input, Days);
		typeIn(OR.InvoicePaymentTerm_AddPayment_Percent, "1");
		typeIn(OR.InvoicePaymentTerm_AddPayment_APIntegratiot, "text");
		waitForElement(OR.InvoicePaymentTerm_AddPayment_Btn, 40);
		clickOn(OR.InvoicePaymentTerm_AddPayment_addButtton);
		ToastmesssageSucess();
		clickOn(OR.InvoicePaymentTerm_AddPayment_CancelButtton);
		
	}
	
}

