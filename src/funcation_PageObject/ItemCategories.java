package funcation_PageObject;

import org.openqa.selenium.By;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;
import AutomationFramework._OR;

public class ItemCategories extends ApplicationKeyword{
  
	public static void VerifyPage()
    {
		verifyElement(OR.ItemcaCategory_btn_AddCategory);
		getTextchild("//*[@class='pagehead']");
		verifyElementText(OR.ItemcaCategory_SearchCategoryBy, "Search Category By");
		verifyElement(OR.ItemcaCategory_btn_Search);
		Gridview();
		
    }
	
	public static void NavigateToItemCategories()
    {
    	clickOn(_OR.DashBoard_Admin);
    	clickOn(_OR.DashBoard_Admin_items_categories);
    }
	
	public static void AddCategory()
	{
		String Name ="catename"+randomAlphaNumeric(6);
		clickOn(OR.ItemcaCategory_btn_AddCategory);
		verifyElementText(OR.ItemcaCategory_CreateCategory,"Create Category");
		verifyElementText(OR.ItemcaCategory_CreateCategory_Label_Name,"Name ");
		verifyElement(OR.ItemcaCategory_CreateCategory_btn_Close);
		verifyElement(OR.ItemcaCategory_CreateCategory_btn_Save);
		String Disable = getAttributeValue(OR.ItemcaCategory_CreateCategory_btn_Save, "disabled");
		if(Disable.contains("disabled"))
		{
			testLogPass("save button is in disable state");
		}
		typeIn(OR.ItemcaCategory_CreateCategory_Input_Name, Name);
		clickOn(OR.ItemcaCategory_CreateCategory_btn_Save);
		ToastmesssageSucess();
		setProperty("NewCategoriesName", Name);
	}
	
	public static void EditCategory()
	{
		String Name = getProperty("NewCategoriesName");
		typeIn(OR.ItemcaCategory_EditCategory_Input_Search,Name);
		clickOn(OR.ItemcaCategory_btn_Search);
		if(driver.findElements(By.xpath("//*[text()='"+Name+"']")).size()!=0)
		{
			testLogPass("Search catefory is present");
			verifyElement(OR.ItemcaCategory_Edit);
			verifyElement(OR.ItemcaCategory_Delete);
			clickOn(OR.ItemcaCategory_Edit);
			verifyElementText(OR.ItemcaCategory_EditCategory,"Edit Category");
			verifyElementText(OR.ItemcaCategory_CreateCategory_Label_Name,"Name");
			verifyElement(OR.ItemcaCategory_CreateCategory_btn_Close);
			verifyElement(OR.ItemcaCategory_CreateCategory_btn_Save);
			clickOn(OR.ItemcaCategory_CreateCategory_btn_Close);
			getTextchild("//*[@class='pagehead']");
			
		}
	}
	
	public static void Delete()
	{
		String Name = getProperty("NewCategoriesName");
		typeIn(OR.ItemcaCategory_EditCategory_Input_Search,Name);
		clickOn(OR.ItemcaCategory_btn_Search);
		if(driver.findElements(By.xpath("//*[text()='"+Name+"']")).size()!=0)
		{
			testLogPass("Search catefory is present");
			clickOn(OR.ItemcaCategory_Delete);
			verifyElement(OR.Template__Deletevalidation);
			clickOn(OR.Dep_Delete_Cancel);
			getTextchild("//*[@class='pagehead']");
		}
	}

}
