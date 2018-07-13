package funcation_PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.GetPageSource;
import org.openqa.selenium.remote.server.handler.html5.GetAppCacheStatus;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;

public class PreferenceCards extends ApplicationKeyword {	
	public static void pageLinkandwait()
	{

		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//a[@href='#/preference-card/operating-rooms']"));
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		clickOn(OR.OP_ORoomPageLink);
		waitForElementToDisplay(OR.OP_wait, 10);

	}
	public static void patientsPageLinkandwait()
	{	 
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//a[@href='#/preference-card/patients']"));
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		clickOn(OR.Patient_PatientsPageLink);
		waitForElementToDisplay(OR.OP_wait2, 10);

	}

	public static void casesPageLinkandwait()
	{
		try
		{
			JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement element = driver.findElement(By.xpath("//a[@href='#/preference-card/cases']"));
			je.executeScript("arguments[0].scrollIntoView(true);",element);
			clickOn(OR.Cases_CasesPageLink);
			pageLinkExists=true;
		}
		catch(Exception e)
		{
			testLogError("Page link does not exist.");
			pageLinkExists=false;
		}
		//cannot put wait on table elements bcoz no elemenet is present on page by default
		//waitForElementToDisplay(OR.Case_firstCase, 10);

	}
	public static void procedurePageLinkandwait()
	{	 
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//*[@href='#/preference-card/procedures']"));
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		clickOn(OR.Procedure_PageLink);
		//waitForElementToDisplay(OR.Procedure_wait, 10);

	}
	public static void plannerPageLinkandwait()
	{	 
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//*[@href='#/preference-card/planner']"));
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		clickOn(OR.Planner_PageLink);

	}
	public static void prefCardPagePageLinkandwait()
	{	 
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//*[@href='#/preference-card/cards']"));
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		clickOn(OR.prefCard_PageLink);
		waitForElementToDisplay(OR.prefCard_AddPrefCard, 10);

	}
	public static void addStageAndItem()
	{

		PreferenceCards.prefCardPagePageLinkandwait();
		waitForElementToDisplay(OR.prefCard_AddPrefCard, 10);
		clickOn(OR.prefCard_AddPrefCard);
		waitForElement(OR.prefCard_addStage);
		clickOn(OR.prefCard_addStage);
		String sName="Stage"+randomAlphaNumeric(5);
		setProperty("Prefcard_StageName", sName);
		typeIn(OR.prefCard_addStageName, getProperty("Prefcard_StageName"));
		clickOn(OR.prefCard_addStageButton);
		String itemDesc=getProperty("ItemDesc");
		typeIn(OR.prefCard_searchInCart,itemDesc);
		if(isElementDisplayed(OR.prefCard_addItemInCart, 10))
			{
			waitForElementToDisplay(OR.prefCard_addItemInCart, 10);
			
		clickOn(OR.prefCard_addItemInCart);
			}
		clickOn(OR.prefCard_saveButton);
	}
	
	public static void AddItem()
	{
		String itemDesc=getProperty("ItemDesc");
		waitForElement(OR.prefCard_searchInCart);
		
		typeIn(OR.prefCard_searchInCart,"dsdsdsdsdsdsdsdsds");
		if(isElementDisplayed(OR.MyCart_cartFor_NoElementFound))
		{
			verifyElementText(OR.MyCart_cartFor_NoElementFound, "No Items Found.");
		}
		
		
		
		typeIn(OR.prefCard_searchInCart,itemDesc);
		
		if(isElementDisplayed(OR.prefCard_addItemInCart, 10))
			{
			waitForElementToDisplay(OR.prefCard_addItemInCart, 10);
			clickOn(OR.prefCard_addItemInCart);
			testLogPass("ItemDes "+getText(OR.prefCard_ItemDes+ " Sku"+getText(OR.prefCard_Sku)));
			IncreaseDecreaseQty();
			}
		
		int size = driver.findElements(By.xpath("//*[@class='tab-pane ng-scope active']//tr/th")).size();
		for(int i=1;i<=size;i++)
		{
			String one = driver.findElement(By.xpath("(//*[@class='tab-pane ng-scope active']//tr/th)["+i+"]")).getText();
			if(one.isEmpty())
			{
				
			}
			else
			{
				testLogPass("Header is "+one);
			}
		}
		
		typeIn(OR.prefCard_searchInCart,"");
		if(driver.findElements(By.xpath("//*[@id='suggestions']")).size()!=0)
		{
			testLogPass("Suggestion is not there");
		}
		
		int sizecat = driver.findElements(By.xpath("//*[starts-with(@ng-repeat,'categories')]//h4")).size();
		for(int i=1;i<=sizecat;i++)
		{
			String one = driver.findElement(By.xpath("(//*[starts-with(@ng-repeat,'categories')]//h4)["+i+"]")).getText();
			if(one.isEmpty())
			{
				
			}
			else
			{
				testLogPass("categories is "+one);
			}
		}
	}
	
	
	
	public static void IncreaseDecreaseQty()
	{
		String one = driver.findElement(By.xpath("(//*[@ng-click='openQtyForm.$show();'])[1]")).getText();
		if(one!= null && !one.isEmpty())
		{	
			String BeforeHoldqtyIncrease = getText(OR.prefCard_HoldQty);
			String BeforeOpenqtyIncrease = getText(OR.prefCard_OpenQty);
			int holdqtyysize = Integer.parseInt(BeforeHoldqtyIncrease);
			int Openqtyysize = Integer.parseInt(BeforeOpenqtyIncrease);
			testLogPass("Before Hold Increase "+holdqtyysize);
			testLogPass("Before Open Increase "+Openqtyysize);
			clickOn(OR.prefCard_OpenQtyIncrease);
			clickOn(OR.prefCard_HoldQtyIncrease);
			String BeforeHoldqtyIncrease1 = getText(OR.prefCard_HoldQty);
			String BeforeOpenqtyIncrease1 = getText(OR.prefCard_OpenQty);
			int holdqtyysize1 = Integer.parseInt(BeforeHoldqtyIncrease1);
			int Openqtyysize1 = Integer.parseInt(BeforeOpenqtyIncrease1);
			testLogPass("After Hold Increase "+holdqtyysize1);
			testLogPass("After Open Increase "+Openqtyysize1);
			
			String AfterHoldqtyDecrease = getText(OR.prefCard_HoldQty);
			String AfterOenDec = getText(OR.prefCard_OpenQty);
			int holdqtyysizeDec = Integer.parseInt(AfterHoldqtyDecrease);
			int OpenqtyysizeDec = Integer.parseInt(AfterOenDec);
			testLogPass("After Hold Decrease "+holdqtyysizeDec);
			testLogPass("After Open Decrease "+OpenqtyysizeDec);
			
			clickOn(OR.prefCard_HoldQty);
			if(isElementDisplayed(OR.prefCard_number))
			{
				typeIn(OR.prefCard_number, "-1");
				clickOn(OR.Templates_EditSubmit);
				waitForElement(OR.prefCard_OpenQtyValidation);
				getText(OR.prefCard_OpenQtyValidation);
				clickOn(OR.Confirmionok);
				
			}
			
		}
	}
	
	public static void Deleteqty()
	{
		waitForElement(OR.prefCard_deleteQty);
		clickOn(OR.prefCard_deleteQty);
		waitForElement(OR.prefCard_DeleteStage_validation);
		verifyElementText(OR.prefCard_DeleteStage_validation, "Do you really want to remove the item from stage?");
		clickOn(OR.manageInv_cancelPopUP);
		waitForElement(OR.prefCard_deleteQty);
		clickOn(OR.prefCard_deleteQty);
		waitForElement(OR.prefCard_DeleteStage_validation);
		verifyElementText(OR.prefCard_DeleteStage_validation, "Do you really want to remove the item from stage?");
		clickOn(OR.Dep_Delete_Yes);
	}
	
	
	public static void RemoveStage()
	{
		waitForElement(OR.prefCard_AddPrefCard);
		clickOn(OR.prefCard_AddPrefCard);
		waitForElement(OR.prefCard_addStage);
		clickOn(OR.prefCard_addStage);
		waitForElement(OR.prefCard_addStageName);
		String sName=getProperty("Prefcard_StageName");
		typeIn(OR.prefCard_addStageName, sName);
		clickOn(OR.prefCard_addStageButton);
		waitForElement(OR.prefCard_removeStage);
		clickOn(OR.prefCard_removeStage);
		waitForElement(OR.manageInv_cancelPopUP);
		
		
		
		clickOn(OR.manageInv_cancelPopUP);
		waitForElement(OR.prefCard_removeStage);
		clickOn(OR.prefCard_removeStage);
		waitForElement(OR.Dep_Delete_Yes);
		clickOn(OR.Dep_Delete_Yes);
		
		
		
		if(!isElementDisplayed(OR.prefCard_removeStage, 10))
		{
			testLogPass("Stage is deleted Successfully");
		}
		else
		{
			testLogFail("Stage is deleted Successfully");			
		}

	}
	
	public static void verifyPage()
	{
		getTextchild("//*[starts-with(@class,'pagehead')]");
		verifyElement(OR.prefCard_searchTextBox);
		verifyElement(OR.prefCard_selectPhyscian);
	}
	
	public static void EditPrefcard()
	{
		verifyPage();
		waitForElement(OR.SI_EditItem);
		clickOn(OR.SI_EditItem);
		waitForElement(OR.prefCard_HoldQtyIncrease);
		clickOn(OR.prefCard_HoldQtyIncrease);
		waitForElementToDisplay(OR.prefCard_saveButton, 30);
		WebElement ele = driver.findElement(By.xpath("//*[@ng-click='savePreferenceCard(preferenceCard)']"));
		executor.executeScript("arguments[0].click();",ele); 
		ToastmesssageSucess();
	}
	
	public static void AddPreferenceCard1()
	{
		waitUntilPageReady();
		waitForElement(OR.prefCard_AddPrefCard);
		clickOn(OR.prefCard_AddPrefCard);
		getTextchild("//*[@class='pagehead ng-binding']");
		verifyElement(OR.prefCard_copyStages);
		verifyElement(OR.prefCard_addStage);
		if(getAttributeValue(OR.prefCard_CardName, "required")!=null)
		{
			testLogPass("Card Name is mandatory field");
		}
		if(getAttributeValue(OR.prefCard_PhysicianName, "required")!=null)
		{
			testLogPass("Physician Name is mandatory field");
		}
		String cardName = "cardName"+ApplicationKeyword.randomAlphaNumeric(6);
		typeIn(OR.prefCard_CardName, cardName);
		setProperty("PreferenceCards", cardName);
		selectFromDropdown(OR.prefCard_PhysicianName, getProperty("firstPhysician"));
		waitForElementToDisplayWithoutFail(OR.prefCard_saveButton, 10);
		
		
		waitForElementToDisplay(OR.prefCard_addStage, 30);
		clickOn(OR.prefCard_addStage);
		String one = "Stage"+randomAlphaNumeric(4);
		setProperty("Prefcard_StageName", one);
		waitForElementToDisplay(OR.prefCard_addStage, 30);
		verifyElementText(OR.prefCard_addStageText, "Add Stage");
		typeIn(OR.prefCard_addStageName, one);
		clickOn(OR.preferenceCard_BtnAddStage);
		String itemDesc=getProperty("ItemDesc");
		waitForElement(OR.prefCard_searchInCart);
		typeIn(OR.prefCard_searchInCart,itemDesc);
		if(isElementDisplayed(OR.prefCard_addItemInCart, 10))
		{
		waitForElementToDisplay(OR.prefCard_addItemInCart, 10);
		
		clickOn(OR.prefCard_addItemInCart);
		}
		waitForElementToDisplay(OR.prefCard_addStage, 30);
		WebElement ele = driver.findElement(By.xpath("//input[@value='Add Stage']"));
		executor.executeScript("arguments[0].click();",ele); 
		//clickOn(OR.prefCard_addStage);
		verifyElementText(OR.prefCard_addStageText, "Add Stage");
		String one1 = "Stage"+randomAlphaNumeric(4);
		typeIn(OR.prefCard_addStageName, one1);
		clickOn(OR.preferenceCard_BtnAddStage);
		typeIn(OR.prefCard_searchInCart,itemDesc);
		if(isElementDisplayed(OR.prefCard_addItemInCart, 10))
		{
		waitForElementToDisplay(OR.prefCard_addItemInCart, 10);
		
		clickOn(OR.prefCard_addItemInCart);
		}
		waitForElementToDisplay(OR.prefCard_saveButton, 30);
		WebElement ele1 = driver.findElement(By.xpath("//*[@ng-click='savePreferenceCard(preferenceCard)']"));
		executor.executeScript("arguments[0].click();",ele1); 
		ToastmesssageSucess();
	}
	
	
	public static void AddPreferenceCard()
	{
		waitUntilPageReady();
		waitForElement(OR.prefCard_AddPrefCard);
		clickOn(OR.prefCard_AddPrefCard);
		getTextchild("//*[@class='pagehead ng-binding']");
		verifyElement(OR.prefCard_copyStages);
		verifyElement(OR.prefCard_addStage);

		String cardName = "cardName"+ApplicationKeyword.randomAlphaNumeric(6);
		typeIn(OR.prefCard_CardName, cardName);
		setProperty("PreferenceCards", cardName);
		selectFromDropdown(OR.prefCard_PhysicianName, getProperty("firstPhysician"));
		waitForElementToDisplayWithoutFail(OR.prefCard_saveButton, 10);
		AddStage();
		ReOrder();
		AddItem();
		
		waitForElementToDisplay(OR.prefCard_saveButton, 30);
		WebElement ele = driver.findElement(By.xpath("//*[@ng-click='savePreferenceCard(preferenceCard)']"));
		executor.executeScript("arguments[0].click();",ele); 
		ToastmesssageSucess();
	}
	
	
	public static void AddPreferenceCard2()
	{
		waitForElement(OR.prefCard_AddPrefCard);
		clickOn(OR.prefCard_AddPrefCard);
		getTextchild("//*[@class='pagehead ng-binding']");
		
		String cardName = "cardName"+ApplicationKeyword.randomAlphaNumeric(2);
		typeIn(OR.prefCard_CardName, cardName);
		setProperty("PreferenceCards", cardName);
		selectFromDropdown(OR.prefCard_PhysicianName, getProperty("firstPhysician"));
		waitForElementToDisplayWithoutFail(OR.prefCard_saveButton, 10);
		CopyStage();
		waitForElement(OR.prefCard_saveButton);
		clickOn(OR.prefCard_saveButton);
		ToastmesssageSucess();
		
	}
	
	public static void ReOrder()
	{
		waitForElement(OR.prefCard_reorderStageButton);
		if(getAttributeValue(OR.prefCard_reorderStageButton, "disabled")==null)
		{
			WebElement ele = driver.findElement(By.xpath("//*[@value='Re-order Stage']"));
			executor.executeScript("arguments[0].click();",ele); 
			verifyElementText(OR.prefCard_reorderStage_hash, "#");
			verifyElementText(OR.prefCard_reorderStage_Name, "Name");
			verifyElement(OR.Vendor_Customersupport_Custom_Close);
			clickOn(OR.Vendor_Customersupport_Custom_Close);
			verifyElement(OR.prefCard_addStage);
			
		}
	}
	
	public static void Delete()
	{
		waitForElementToDisplayWithoutFail(OR.prefCard_searchTextBox, 10);
		typeIn(OR.prefCard_searchTextBox, getProperty("PreferenceCards"));
		verifyPagination();
		Header();
		waitForElementToDisplayWithoutFail(OR.prefCard_firstprefcard, 10);
		if(getText(OR.prefCard_firstprefcard).contains(getProperty("PreferenceCards")))
		{
			waitForElement(OR.prefCard_removePrefCard);
			clickOn(OR.prefCard_removePrefCard);
			waitForElement(OR.manageInv_cancelPopUP);
			clickOn(OR.manageInv_cancelPopUP);
			waitForElement(OR.prefCard_removePrefCard);
			clickOn(OR.prefCard_removePrefCard);
			waitForElement(OR.prefCard_confirmButton);;
			clickOn(OR.prefCard_confirmButton);
			ToastmesssageSucess();
			typeIn(OR.prefCard_searchTextBox, getProperty("PreferenceCards"));
			verifyElementText(OR.prefCard_NoPrefCardText, "No Preference cards Found.");			
		}
		else
		{
			testLogFail("Either preference card is not created or there is some issue in search on this page");
		}
	}
	
	public static void AddStage()
	{
		waitForElementToDisplay(OR.prefCard_addStage, 30);
		clickOn(OR.prefCard_addStage);
		verifyElementText(OR.prefCard_addStageText, "Add Stage");
		if(getAttributeValue(OR.prefCard_addStageName, "required")!=null)
		{
			testLogPass("Add Stage Name is mandatory field");
		}
		else
		{
			testLogFail("Add Stage Name is not a mandatory field");
		}
		clickOn(OR.prefCard_CanelBUtton);
		String one = "Stage"+randomAlphaNumeric(4);
		setProperty("Prefcard_StageName", one);
		waitForElement(OR.prefCard_addStage);
		clickOn(OR.prefCard_addStage);
		
		verifyElementText(OR.prefCard_addStageText, "Add Stage");
		typeIn(OR.prefCard_addStageName, one);
		clickOn(OR.preferenceCard_BtnAddStage);
		String item = getProperty("ItemDesc");
		typeIn(OR.prefCard_searchInCart,item);
		if(isElementDisplayed(OR.prefCard_addItemInCart, 10))
			{
			waitForElementToDisplay(OR.prefCard_addItemInCart, 10);
			clickOn(OR.prefCard_addItemInCart);
			}
		
		WebElement ele = driver.findElement(By.xpath("//input[@value='Add Stage']"));
		executor.executeScript("arguments[0].click();",ele); 
		waitForElementToDisplay(OR.prefCard_addStage, 30);
		clickOn(OR.prefCard_addStage);
		verifyElementText(OR.prefCard_addStageText, "Add Stage");
		String one1 = "Stage"+randomAlphaNumeric(4);
		typeIn(OR.prefCard_addStageName, one1);
		clickOn(OR.preferenceCard_BtnAddStage);
	}
	
	public static void CopyStage()
	{
		waitForElement(OR.prefCard_copyStages);
		clickOn(OR.prefCard_copyStages);
		waitForElement(OR.csManufacture_Close);
		verifyElementText(OR.prefCard_copyCardPopUpText, "Copy Stages:-");
		clickOn(OR.csManufacture_Close);
		waitForElement(OR.prefCard_copyStages);
		clickOn(OR.prefCard_copyStages);
		verifyElementText(OR.prefCard_copyCardPopUpText, "Copy Stages:-");
		
		selectFromDropdown(OR.prefCard_copyPredCardDrpDown, getProperty("PreferenceCards"));
		selectFromDropdown(OR.prefCard_copyPredCardStageDroppDown, getProperty("Prefcard_StageName"));
		String stageName=getProperty("Prefcard_StageName");
		System.out.println(stageName);
		waitForElementToDisplay(OR.prefCard_ADDButtton, 20);
		clickOn(OR.prefCard_ADDButtton);
		waitForElementToDisplay(OR.prefCard_copyButtton, 20);
		clickOn(OR.prefCard_copyButtton);
		ToastmesssageSucess();
	}
	
	public static void Header()
	{
		int size = driver.findElements(By.xpath("//thead//a")).size();
		for(int i =1 ;i<=size;i++)
		{	
			String one = driver.findElement(By.xpath("(//thead//a)["+i+"]")).getText();
			testLogPass("Header is "+one);
		}
	}
	
	public static void Staging()
	{
		int size = driver.findElements(By.xpath("//uib-tab-heading")).size();
		for(int i =1 ;i<=size;i++)
		{	
			String one = driver.findElement(By.xpath("(//uib-tab-heading)["+i+"]")).getText();
			testLogPass("stages are	 "+one);
		}
	}
}