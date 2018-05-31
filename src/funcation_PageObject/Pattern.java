package funcation_PageObject;

import java.util.Random;

import org.openqa.selenium.By;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;
import AutomationFramework._OR;

public class Pattern extends ApplicationKeyword{
    
	public static void NavigateToPattern()
	{
		 clickOn(_OR.DashBoard_Admin);
		 clickOn(_OR.DashBoard_Admin_pattern);
		 getTextchild("//*[@class='pagehead']");
	}
	
	public static void VerifyPage()
	{
		verifyElementText(OR.Pattern_Name_txt, "Name");
		verifyElementText(OR.Pattern_Template_txt, "Template");
		verifyElementText(OR.Pattern_CurrentValue_txt, "Current Value");
		verifyElement(OR.Pattern_Edit);
		verifyElement(OR.Pattern_Delete);
		verifyPagination();
		verifyElement(OR.Pattern_AddBtn);
	}
	
	public static void CreatePatten()
	{
		String Name =  "00000000"+randomAlphaNumeric(5);
		int u = generateRandomInt1(10000);
		String values = Integer.toString(u);
		clickOn(OR.Pattern_AddBtn);
		verifyElementText(OR.Pattern_Add_AddPttern_txt, "Add Pattern");
		verifyElementText(OR.Pattern_Add_labelName, "");
		
		typeIn(OR.Pattern_Add_Name, Name);
		selectFromDropdown(OR.Pattern_Add_SelectTeamplate, "string");
		selectFromDropdown(OR.Pattern_Add_SelectTeamplate, "date");
		selectFromDropdown(OR.Pattern_Add_SelectTeamplate, "month");
		selectFromDropdown(OR.Pattern_Add_SelectTeamplate, "year");
		selectFromDropdown(OR.Pattern_Add_SelectTeamplate, "series");
		selectFromDropdown(OR.Pattern_Add_SelectTeamplate, "Employee Code");
		selectFromDropdown(OR.Pattern_Add_SelectTeamplate, "Department Code");
		selectFromDropdown(OR.Pattern_Add_SelectTeamplate, "Facility Code");
		selectFromDropdown(OR.Pattern_Add_SelectTeamplate, "Organization Code");
		selectFromDropdown(OR.Pattern_Add_SelectTeamplate, "string");
		verifyElement(OR.Pattern_Add_AddTemplatebtn);
		typeIn(OR.Pattern_Add_InitialValue, "1");
		clickOn(OR.Pattern_Add_AddTemplatebtn);
		clickOn(OR.Pattern_Add_Close);
		waitForElementToDisplay(OR.Pattern_AddBtn, 30);
		clickOn(OR.Pattern_AddBtn);
		typeIn(OR.Pattern_Add_Name, Name);
		selectFromDropdown(OR.Pattern_Add_SelectTeamplate, "string");
		verifyElement(OR.Pattern_Add_AddTemplatebtn);
		typeIn(OR.Pattern_Add_InitialValue, values);
		clickOn(OR.Pattern_Add_AddTemplatebtn);
		clickOn(OR.Pattern_Add_Save);
		//ToastmesssageSucess();
		selectFromDropdown(OR.Pattern_Add_SelectTeamplate, "series");
		typeIn(OR.Pattern_Add_InitialValue, values);
		clickOn(OR.Pattern_Add_AddTemplatebtn);
		verifyElement(OR.Pattern_Add_Save);
		verifyElement(OR.Pattern_Add_Close);
		clickOn(OR.Pattern_Add_Save);
		ToastmesssageSucess();
		Edit(Name);
		Delete(Name);
	}
	
	
	public static void Edit(String search)
	{
		waitForElement(OR.Pagination_Last);
		clickOn(OR.Pagination_Last);
		waitForElement(OR.Pagination_ActivePage);
		String pageLastInex = getText(OR.Pagination_ActivePage);
		waitForElement(OR.Pagination_First);
		clickOn(OR.Pagination_First);
		waitForElement(OR.Pagination_ActivePage);
		String FirstIndex = getText(OR.Pagination_ActivePage);
		
		int Last = Integer.parseInt(pageLastInex);
		int First =Integer.parseInt(FirstIndex);
		for(int j = First; j<=Last; j++)
		{
			int Size = driver.findElements(By.xpath("//*[@id='reqListing']/tbody/tr")).size();
		for(int i =1; i<=Size; i++)
		{
			String one = driver.findElement(By.xpath("//*[@id='reqListing']/tbody/tr["+i+"]/td[1]")).getText();
			if(one.contains(search))
			{
				driver.findElement(By.xpath("(//*[@class='fa fa-edit'])["+i+"]")).click();
				testLogPass("clicked on Edit");
				clickOn(OR.Pattern_Add_Save);
				ToastmesssageSucess();
				break;
			}
		}
		//driver.findElement(By.xpath("//a[text()='Next']")).click();
		}
		
	}
	
	public static void Delete(String search)
	{
		waitForElement(OR.Pagination_Last);
		clickOn(OR.Pagination_Last);
		waitForElement(OR.Pagination_ActivePage);
		String pageLastInex = getText(OR.Pagination_ActivePage);
		waitForElement(OR.Pagination_First);
		clickOn(OR.Pagination_First);
		waitForElement(OR.Pagination_ActivePage);
		String FirstIndex = getText(OR.Pagination_ActivePage);
		
		int Last = Integer.parseInt(pageLastInex);
		int First =Integer.parseInt(FirstIndex);
		for(int j = First; j<=Last; j++)
		{
			int Size = driver.findElements(By.xpath("//*[@id='reqListing']/tbody/tr")).size();
		for(int i =1; i<=Size; i++)
		{
			String one = driver.findElement(By.xpath("//*[@id='reqListing']/tbody/tr["+i+"]/td[1]")).getText();
			if(one.contains(search))
			{
				driver.findElement(By.xpath("(//*[@class='fa fa-trash'])["+i+"]")).click();
				testLogPass("clicked on delete");
				verifyElementText(OR.Pattern_Deletevalidation, "Are you sure you want to delete this Pattern ?");
				clickOn(OR.Dep_Delete_Yes);
				ToastmesssageSucess();
				break;
			}
		}
		//driver.findElement(By.xpath("//a[text()='Next']")).click();
		}
	}
	
	public static void Sample()
	{
		clickOn(OR.pattern_gearButton);
		verifyElement(OR.pattern_Sample_title);
		verifyElement(OR.pattern_IncreasedpatternValue);
		getText(OR.pattern_IncreasedpatternValue);
		clickOn(OR.Template_CloseBtn);
	}
	
	
	
}

