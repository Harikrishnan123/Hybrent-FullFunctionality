package funcation_PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;

public class Procedure extends ApplicationKeyword{
	
   
	public static void verifyPage()
	{
		getTextchild("//*[@class='pagehead']");
		verifyElement(OR.Phy_SearchTextBox);
		verifyElement(OR.Procedure_HeaderProcedure);
		verifyElement(OR.Procedure_HeaderCPTCode);
		verifyElement(OR.Procedure_HeaderLastUpdateat);
		verifyPagination();
	}
	
    public static void SearchProcedure()
    {
    	waitForElementToDisplayWithoutFail(OR.Procedure_SearchTextBox, 10);
		typeIn(OR.Procedure_SearchTextBox, getProperty("procName"));
		String firstElemAfterSearch=getText(OR.Procedure_firstElem);
		String finalName=firstElemAfterSearch.substring(2).trim();
		if(finalName.equals(getProperty("procName")))
		{
			testLogPass("Procedure is added successfully");	
		}
		else
		{
			testLogFail("Procedure is not added successfully");			
		}
    }
    
    public static void Edit()
    {
    	SearchProcedure();
    	waitForElement(OR.Procedure_Edit);
    	clickOn(OR.Procedure_Edit);
    	verifyElementText(OR.Procedure_EditHeader, "EDIT PROCEDURE");
    	clickOn(OR.Procedure_CloseButton);
		waitUntilPageReady();
		waitForElement(OR.Procedure_Edit);
    	clickOn(OR.Procedure_Edit);
    	clickOn(OR.Procedure_CloseButton);
		waitUntilPageReady();
    	clickOn(OR.Procedure_SaveButton);
		ToastmesssageSucess();
    }
    
    public static void Delete()
    {
    	SearchProcedure();
    	waitUntilPageReady();
    	Deleteicon();
    	verifyElement(OR.Procedure_DeleteValidation);
    	testLogPass("Delete validation "+getText(OR.Procedure_DeleteValidation));
    	verifyElement(OR.Procedure_ConfirmButton);
    	verifyElement(OR.manageInv_cancelPopUP);
    	clickOn(OR.manageInv_cancelPopUP);
    	waitUntilPageReady();
    	Deleteicon();
    	verifyElement(OR.Procedure_DeleteValidation);
    	testLogPass("Delete validation "+getText(OR.Procedure_DeleteValidation));
    	clickOn(OR.Procedure_ConfirmButton);
    	ToastmesssageSucess();
    }
    
    public static void Headertablevalues()
	{
		int sizeheader = driver.findElements(By.xpath("//table//th")).size();
		for(int i =1 ;i<=sizeheader;i++)
		{
			String value = driver.findElement(By.xpath("(//table//th)["+i+"]")).getText();
			testLogPass("Header is "+value);
		}
		verifyPagination();
	}

    
	public static void procedurePageLinkandwait()
	{	 
		WebElement element = driver.findElement(By.xpath("//*[@href='#/preference-card/procedures']"));
		executor.executeScript("arguments[0].scrollIntoView(true);",element);
		clickOn(OR.Procedure_PageLink);
		//waitForElementToDisplay(OR.Procedure_wait, 10);

	}
	public static void Deleteicon()
	{
		waitTime(1);
		WebElement element = driver.findElement(By.xpath("//*[@uib-tooltip='Delete Procedure']"));
		executor.executeScript("arguments[0].click();",element);
	}
	
	public static void addProcedureWithoutSave()
	{
		clickOn(OR.Procedure_AddProcedure); 
		if(getAttributeValue(OR.Procedure_SaveButton, "disabled") != null)
		{
			testLogPass("Save button is disabled");
		}
		else
		{
			testLogFail("Save button is not disabled");
		}
		String procName="Proc"+ApplicationKeyword.randomAlphaNumeric(3);
		setProperty("procName",procName);
		typeIn(OR.Procedure_addName, procName);
		//typeIn(OR.Procedure_Physicians, getProperty("Procedure_FirstName"));
		clickOn(OR.Procedure_SelectPhysican1);
		String firstPhysician=getText(OR.Procedure_SelectPhysican1Label);
		setProperty("firstPhysician", firstPhysician);
		String cptCode="001"+ApplicationKeyword.randomAlphaNumeric(3);
		setProperty("cptCode",cptCode);
		typeIn(OR.Procedure_cptCode, cptCode);
		if(getAttributeValue(OR.Procedure_SaveButton, "disabled") == null)
		{
			testLogPass("Save button is enabled");
		}
		else
		{
			testLogFail("Save button is not enabled");
		}
	}
	
	public static void drilldownPlus()
	{
		waitForElement(OR.InvLoc_Add_PlusBtn);
		clickOn(OR.InvLoc_Add_PlusBtn);
		waitForElement(OR.InvLoc_Add_MinusBtn);
		verifyElement(OR.InvLoc_Add_MinusBtn);
	}
	
    public static void NPINumber()
	{
		int sizeheader = driver.findElements(By.xpath("//*[@class='table table-bordered']//tr")).size();
		for(int i =1 ;i<=sizeheader;i++)
		{
			String value = driver.findElement(By.xpath("(//*[@class='table table-bordered']//tr)["+i+"]")).getText();
			testLogPass(value);
		}
		verifyPagination();
	}

}

