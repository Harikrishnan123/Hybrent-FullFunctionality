package funcation_PageObject;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;
import AutomationFramework._OR;

public class PospecialInstructions extends ApplicationKeyword
{
    
    public static void NavigateToPOSInst()
    {
    	clickOn(_OR.DashBoard_Admin);
    	clickOn(_OR.DashBoard_Admin_po_special_instructions);
    	verifyElement(OR.DashBoard_Report_News_Header);
    }
    
    public static void pageVerification()
    {
    	getTextchild("//*[@class='pagehead']");
    	verifyElement(OR.PoSpecialInst_Add);
    }
    
    public static void AddSpecialInst()
    {
    	String SpecialInstName = "Special"+randomAlphaNumeric(6);
    	setProperty("NameSpecialInstruct", SpecialInstName);
    	clickOn(OR.PoSpecialInst_Add);
    	waitForElement(OR.PoSpecialInst_AddPageTitle);
    	testLogPass("title of page is "+getText(OR.PoSpecialInst_AddPageTitle));
    	verifyElementText(OR.PoSpecialInst_Add_SpecialInstruction, "Special Instructions*");
    	verifyElement(OR.PoSpecialInst_Add_Close);
    	verifyElement(OR.PoSpecialInst_Add_Save);
    	String attr = getAttributeValue(OR.PoSpecialInst_Add_Save, "disabled");
    			if(attr.contains("true"))
    			{
    				testLogPass("Save button is in disable state");
    			}
    			
    			typeIn(OR.PoSpecialInst_Add_InputName, SpecialInstName);
    			clickOn(OR.PoSpecialInst_Add_Close);
    			clickOn(OR.PoSpecialInst_Add);
    	    	waitForElement(OR.PoSpecialInst_AddPageTitle);
    	    	typeIn(OR.PoSpecialInst_Add_InputName, SpecialInstName);
    	    	clickOn(OR.PoSpecialInst_Add_Save);
    			ToastmesssageSucess();
    			verifyPagination();
    			Edit(SpecialInstName);
    			Delete(SpecialInstName);
    }
    public static void Edit(String search)
    {
    	String SpecialInstName = "Special"+randomAlphaNumeric(6);
    	setProperty("NameSpecialInstruct", SpecialInstName);
    	verifyElement(OR.PoSpecialInst_Edit_SpecialInstruction);
    	typeIn(OR.PoSpecialInst_SearchInput, "dhjkdhdjfkhdfhkjdhjkfhdkjhfkjdhkfjhk");
    	clickOn(OR.PoSpecialInst_SearchBtn);
    	verifyElementText(OR.PoSpecialInst_Searchvalidation, "No data available in table");
    	
    	typeIn(OR.PoSpecialInst_SearchInput, search);
    	clickOn(OR.PoSpecialInst_SearchBtn);
    	clickOn(OR.PoSpecialInst_EditIcon);
    	verifyElement(OR.PoSpecialInst_Add_SpecialInstruction);
    	typeIn(OR.PoSpecialInst_Add_InputName, SpecialInstName);
		clickOn(OR.PoSpecialInst_Add_Close);
		clickOn(OR.PoSpecialInst_Add);
    	waitForElement(OR.PoSpecialInst_AddPageTitle);
    	typeIn(OR.PoSpecialInst_Add_InputName, SpecialInstName);
    	verifyElement(OR.PoSpecialInst_Add_Close);
    	verifyElement(OR.PoSpecialInst_Add_Save);
		clickOn(OR.PoSpecialInst_Add_Save);
    	ToastmesssageSucess();
    	
    }
    
    
    public static void Delete(String Search)
    {
    	typeIn(OR.PoSpecialInst_SearchInput, Search);
    	clickOn(OR.PoSpecialInst_SearchBtn);
    	clickOn(OR.PoSpecialInst_DeleteIcon);
    	waitForElement(OR.PoSpecialInst_Deletevalidation);
    	verifyElementText(OR.PoSpecialInst_Deletevalidation, "Are you sure you want to delete this Special instruction ?");
    	clickOn(OR.Dep_Delete_Cancel);
    	clickOn(OR.PoSpecialInst_DeleteIcon);
    	waitForElement(OR.PoSpecialInst_Deletevalidation);
    	verifyElementText(OR.PoSpecialInst_Deletevalidation, "Are you sure you want to delete this Special instruction ?");
    	clickOn(OR.Dep_Delete_Yes);
    	ToastmesssageSucess();
    	
    }
    

}
