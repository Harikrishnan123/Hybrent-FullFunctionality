package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;

public class Template extends ApplicationKeyword
{
	//public static String CreateTemplateName = "Test"+randomAlphaNumeric(16);
	//public static String EditTemplateName = "EdiTest";

	public static void AddDeleteScheduleTemplate()
	{
		//Add Template
		waitForElementToDisplayWithoutFail(OR.Templates_AddBtn, 60);
		clickOn(OR.Templates_AddBtn);
		verifyElementText(OR.Templates_AddTemplatetxt, "Add Template");
		//verifyElement(OR.Templates_Cancel);
		String TemplateName="Test"+randomAlphaNumeric(5);
		setProperty("TemplateName", TemplateName);
		typeIn(OR.Templates_Name, TemplateName);
		clickOn(OR.Templates_CreateTemplate);	
		waitForElementToDisplayWithoutFail(OR.Template_VerifytempName, 10);
		String tempName_Saved=getText(OR.Template_VerifytempName);
		System.out.println(tempName_Saved);
		if(tempName_Saved.equalsIgnoreCase(TemplateName))
		{
			testLogPass("Template is added");
		}
		else
		{
			testLogFail("Template is not added");
		}
		waitForElementToDisplayWithoutFail(OR.Template_Uncheck_groupBYVendor, 5);
		clickOn(OR.Template_Uncheck_groupBYVendor);	
		//Search Item
		MycartPage.searchItem();
		String ItemDescription=getProperty("ItemDesc");
		clearEditBox(OR.MyCart_searchInCart);
		waitForElementToDisplayWithoutFail(OR.MyCart_searchInCart, 15);
		String alias=getProperty("alias");
		typeIn(OR.MyCart_searchInCart,alias);
		waitForElementToDisplayWithoutFail(OR.MyCart_searchInCart, 15);
		String ItemName=getText(OR.MyCart_firstItemName);
		if(ItemName.equalsIgnoreCase(ItemDescription))
		{
			testLogPass("Item is searched with AliasName-" + alias);
		}
		else
		{
			testLogFail("Item is not searched with AliasName-" + alias);			
		}	
		addItemInTemplate();
		AddEditDeleteScehdule();
		//			//Delete Schedule
		//			deleteSchedule();
		//			clickOn(OR.Template_SAveTemplate);
		//			waitTime(2);		
		//			clickOn(OR.Template_closeButton);
		//			waitForElementToDisplayWithoutFail(OR.Template_HeaderText, 10);
		//			verifyElementText(OR.Template_HeaderText, "My Templates");

	}

	//		//String TemplateName ="Test";
	//		typeIn(OR.Templates_SearchScan,TemplateName);
	//		clickOn(OR.Template_Add_First);
	//		getAttributeValue(OR.Template_Color, "background-color");
	//		clickOn(OR.Template_Schedule);
	//		clickOn(OR.Template_AddSchedule);
	//		//String one = getAttributeValue(OR.Template_Schedule_Every, "selected");
	//		waitForElement(OR.Template_Schedule_Savebtn, 60);
	//		clickOn(OR.Template_Schedule_Savebtn);
	//		waitTime(5);
	//		clickOn(OR.Template_Schedule_Deletebtn);
	//		verifyElementText(OR.Template__Deletevalidation, "Are you sure?");
	//		verifyElementText(OR.Template__Deletevalidation1, "Are you sure you want to delete this schedule ?");
	//		clickOn(OR.Template_Yes);
	//		System.out.println("test");
	//		waitTime(15);
	//		clickOn(OR.Template_Yes);
	//		}
	//		catch(Exception e)
	//		{
	//			if(isElementDisplayed(OR.Template_Yes))
	//			{
	//				clickOn(OR.Template_Yes);
	//			}
	//			NavigateUrl(DashBoardURL);
	//		}
	//	}
	//	
	//	public static void AddTemplate()
	//	{
	//		try
	//		{
	//		waitForElement(OR.Templates_AddBtn, 60);
	//		clickOn(OR.Templates_AddBtn);
	//		verifyElementText(OR.Templates_AddTemplatetxt, "Add Template");
	//		verifyElement(OR.Templates_Cancel);
	//		typeIn(OR.Templates_Name, CreateTemplateName);
	//		clickOn(OR.Templates_CreateTemplate);
	//		}
	//		catch(Exception e)
	//		{
	//			if(isElementDisplayed(OR.Template_Yes))
	//			{
	//				clickOn(OR.Template_Yes);
	//			}
	//			NavigateUrl(DashBoardURL);
	//		}
	//}

	public static void AddEditDeleteScehdule()
	{				
		clickOn(OR.Template_Schedule);
		waitForElementToDisplayWithoutFail(OR.Template_AddSchedule, 10);
		clickOn(OR.Template_AddSchedule);
		//String one = getAttributeValue(OR.Template_Schedule_Every, "selected");
		waitForElementToDisplayWithoutFail(OR.Template_Schedule_Savebtn, 10);
		clickOn(OR.Template_Schedule_Savebtn);		
		if(isElementDisplayed(OR.Template_Schedule_EditButton))
		{
			testLogPass("Schedule is added");
		}
		else
		{
			testLogFail("Schedule is not added");
		}		
		clickOn(OR.Template_Schedule_EditButton);
		waitForElementToDisplayWithoutFail(OR.Template_selectHourValue, 3);
		WebElement elem=driver.findElement(By.xpath("//*[@class='form-group']//*[@class='form-inline']"));
		WebElement elem2=elem.findElement(By.xpath("//*[@class='select-options']//select[1]"));
		elem2.click();
		WebElement elem3=elem2.findElement(By.xpath("//option[@label='Sunday']"));
		elem3.click();
		//selectFromDropdown(elem2, "Sunday");
		clickOn(OR.Template_Schedule_Savebtn);
		waitForElementToDisplayWithoutFail(OR.Template_Schedule_EditButton, 3);
		waitTime(4);
		String changedText=getText(OR.Template_changeHour);
		if(changedText.contains("Every week on Sunday at 12:00"))
		{
			testLogPass("Schedule is edited");
		}
		else
		{
			testLogFail("Schedule is not edited");
		}		
		deleteSchedule();

		//		WebElement elem4=driver.findElement(By.xpath("//*[@class='table ng-scope']//tbody//tr[1]"));
		//		WebElement elem5=elem4.findElement(By.xpath("/td[2]/*[@class='pull-right']/div[1]"));
		//		String className=elem5.getAttribute("class");
		//		System.out.println(elem5.getTagName());
		//		System.out.println(className);
		//		//Toggle
		//		if(className.contains("-switch-animate bootstrap-switch-on"))
		//		{
		//			testLogPass("Toggle is Active");			
		//			WebElement elem6=elem4.findElement(By.xpath("//td[2]//span[1]"));
		//			elem6.click();
		//			if(className.contains("-switch-animate bootstrap-switch-off"))
		//			{
		//				testLogPass("Toggle is Inactive");
		//			}
		//			else
		//			{
		//				testLogFail("Toggle is Active when it should be InACTIVE");
		//			}
		//
		//		}
		//		else
		//		{
		//			testLogFail("Toggle is InActive when it should be ACTIVE");
		//		}

		//clickOn(OR.Template_SAveTemplate);
		//waitTime(4);
	}

	public static void deleteSchedule()
	{
		waitForElementToDisplayWithoutFail(OR.Template_deleteSchedule, 10);
		clickOn(OR.Template_deleteSchedule);
		waitForElementToDisplayWithoutFail(OR.Template_confirmButton, 10);
		clickOn(OR.Template_confirmButton);
		waitForElementToDisplayWithoutFail(OR.Template_Noschedule, 10);
		if(!isElementDisplayed(OR.Template_deleteSchedule))
		{
			testLogPass("Schedule is deleted");
		}
		else
		{
			testLogPass("Schedule is not deleted");
		}
		
	}



	public static void searchTemplate()
	{
		String tempName=getProperty("TemplateName");
		typeIn(OR.Template_Search_Input, tempName);
		clickOn(OR.Template_SearchBtn);
	}

	public static void addItemInTemplate()
	{
		String ItemDescription=getProperty("ItemDesc");
		typeIn(OR.MyCart_searchInCart, ItemDescription );
		waitForElementToDisplayWithoutFail(OR.MyCart_firstItemName, 15);
		String ItemName=getText(OR.MyCart_firstItemName);
		System.out.println(ItemName);
		waitForElementToDisplayWithoutFail(OR.MyCart_firstItemName, 15);
		clickOn(OR.Template_addItemInCart);
		waitForElementToDisplayWithoutFail(OR.Template_SAveTemplate, 10);
		clickOn(OR.Template_SAveTemplate);
	}
	}
