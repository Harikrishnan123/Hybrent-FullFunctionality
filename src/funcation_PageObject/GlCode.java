package funcation_PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;
import AutomationFramework._OR;

public class GlCode extends ApplicationKeyword
{
	public static void NavigateToGlcode()
	{
		clickOn(_OR.DashBoard_Admin);
		clickOn(_OR.DashBoard_Admin_glcode);
		getTextchild("//*[@class='pagehead']");
	}
	
	public static void verifyPage()
	{
		verifyElement(OR.glCode_Home_Name);
		verifyElement(OR.glCode_Home_Code);
		verifyElement(OR.glCode_Home_Description);
		verifyElement(OR.glCode_Home_Editfirst);
		verifyPagination();
		Gridview();
	}
	
	public static void AddGlCode()
	{
		clickOn(OR.glCode_addGlCOde);
		String Code = "glco"+randomAlphaNumeric(6);
		String Name = "Naame"+randomAlphaNumeric(6);
		String Description = "Des"+randomAlphaNumeric(6);
		setProperty("Gl_code", Code);
		setProperty("Gl_Name", Name);
		verifyElementText(OR.glCode_add_Header, "Add GL Code");
		verifyElement(OR.glCode_add_Label_Code);
		verifyElement(OR.glCode_add_Label_Name);
		verifyElement(OR.glCode_add_Label_Description);
		verifyElement(OR.glCode_saveButton);
		verifyElement(OR.glCode_CloseButton	);
		typeIn(OR.glCode_add_code, Code);
		typeIn(OR.glCode_add_Name, Name);
		typeIn(OR.glCode_add_Desc, Description);
		clickOn(OR.glCode_CloseButton);
		typeIn(OR.glCode_searchTextBox, Code);
		clickOn(OR.glCode_searchButton);
		verifyElementText(OR.glCode_NoRecordFound,"No records found");
		clickOn(OR.glCode_addGlCOde);
		typeIn(OR.glCode_add_code, Code);
		typeIn(OR.glCode_add_Name, Name);
		typeIn(OR.glCode_add_Desc, Description);
		clickOn(OR.glCode_saveButton);
		ToastmesssageSucess();
		clickOn(OR.glCode_addGlCOde);
		typeIn(OR.glCode_add_code, Code);
		typeIn(OR.glCode_add_Name, Name);
		typeIn(OR.glCode_add_Desc, Description);
		clickOn(OR.glCode_saveButton);
		ToastmesssageSucess();
		clickOn(OR.glCode_CloseButton);
	}
	
	
	public static void Edit()
	{
	
		typeIn(OR.glCode_searchTextBox, getProperty("Gl_Name"));
		clickOn(OR.glCode_searchButton);
		clickOn(OR.glCode_Home_Editfirst);
		clickOn(OR.glCode_CloseButton);
		typeIn(OR.glCode_searchTextBox, getProperty("Gl_Name"));
		clickOn(OR.glCode_searchButton);
		clickOn(OR.glCode_Home_Editfirst);
		clickOn(OR.glCode_saveButton);
		ToastmesssageSucess();
	}
	
	public static void Delete()
	{
		typeIn(OR.glCode_searchTextBox, getProperty("Gl_Name"));
		clickOn(OR.glCode_searchButton);
		clickOn(OR.glCode_Home_Deletefirst);
		verifyElementText(OR.glCode_Deleteconfirmation, "Are you sure you want to delete this GL Code ?");
		clickOn(OR.glCode_Home_DeleteCancelbtn);
		clickOn(OR.glCode_Home_Deletefirst);
		verifyElementText(OR.glCode_Deleteconfirmation, "Are you sure you want to delete this GL Code ?");
		clickOn(OR.glCode_confirmButton);
		typeIn(OR.glCode_searchTextBox, getProperty("Gl_Name"));
		clickOn(OR.glCode_searchButton);
		verifyElementText(OR.glCode_NoRecordFound,"No records found");
	}
	
}
