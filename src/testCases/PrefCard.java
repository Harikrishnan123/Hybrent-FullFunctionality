package testCases;


import java.io.File;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import pageObject.Loginpage;
import pageObject.MycartPage;
import pageObject.PrefcardPageObject;
import AutomationFramework.ApplicationKeyword;
import AutomationFramework.Generickeywords;
import AutomationFramework.OR;

public class PrefCard extends ApplicationKeyword
{
	@Parameters({"siteName", "siteUrl"})
	@BeforeTest
	public void startReport(String siteName, String siteUrl) {
		try {
			Loginpage.URL=siteUrl + "#/login/";
			Generickeywords.SITENAME=siteName;
			Generickeywords.DashBoardURL=siteUrl + "#/dashboard";
			String folderPath=OutputDirectory + "/" + siteName;

			File directory = new File(folderPath);
			if (! directory.exists()){
				directory.mkdir();
				// If you require it to make the entire directory path including parents,
				// use directory.mkdirs(); here instead.
			}

			extent = new ExtentReports(folderPath+"/prefcard.html", true);
			// extent.addSystemInfo("Environment","Environment Name")
			extent.addSystemInfo("User Name", "Ravneet");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}
	//Needs data from SHOP page, has to be run after the SHOP TC's

	@Test
	public void Tc_prefCard_01()
	{
		testStarts("Tc_prefCard_01" , "Verify that 'Add Preference Card' button appears on page.");
		System.out.println("Tc_prefCard_01");
		Loginpage.OpenBrowserAndLogin();		
		PrefcardPageObject.prefCardPagePageLinkandwait();
		waitForElementToDisplayWithoutFail(OR.prefCard_AddPrefCard, 10);
		verifyElement(OR.prefCard_AddPrefCard);
	}

	@Test
	public void Tc_prefCard_02()
	{
		testStarts("Tc_prefCard_02" , "Create Preference Card > Verify that CardName and Physician are mandatory fields.");
		System.out.println("Tc_prefCard_02");
		NavigateUrl(DashBoardURL);	
		PrefcardPageObject.prefCardPagePageLinkandwait();
		waitForElementToDisplayWithoutFail(OR.prefCard_AddPrefCard, 10);
		clickOn(OR.prefCard_AddPrefCard);
		if(getAttributeValue(OR.prefCard_CardName, "required")!=null)
		{
			testLogPass("Card Name is mandatory field");
		}
		if(getAttributeValue(OR.prefCard_PhysicianName, "required")!=null)
		{
			testLogPass("Physician Name is mandatory field");
		}

	}

	@Test
	public void Tc_prefCard_03_04()
	{
		testStarts("Tc_prefCard_03" , "Create Preference Card > Verify that 'Add Stage' pop-up appears when user click Add Stage button..");
		System.out.println("Tc_prefCard_03_04");
		NavigateUrl(DashBoardURL);	
		PrefcardPageObject.prefCardPagePageLinkandwait();
		waitForElementToDisplayWithoutFail(OR.prefCard_AddPrefCard, 10);
		clickOn(OR.prefCard_AddPrefCard);
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
		//waitTime(2);	
	}

	//	@Test(priority=4)
	//	public void Tc_prefCard_04()
	//		{
	//		testStarts("Tc_prefCard_04" , "Create Preference Card > Add Stage > Verify that Name field is mandatory.");
	//		NavigateUrl(DashBoardURL);	
	//		PrefcardPageObject.prefCardPagePageLinkandwait();
	//		waitForElementToDisplay(OR.prefCard_AddPrefCard, 10);
	//		clickOn(OR.prefCard_AddPrefCard);
	//		clickOn(OR.prefCard_addStage);
	//		if(getAttributeValue(OR.prefCard_addStageName, "required")!=null)
	//		{
	//		testLogPass("Add Stage Name is mandatory field");
	//		}
	//		else
	//		{
	//			testLogFail("Add Stage Name is not a mandatory field");
	//		}
	//		
	//		
	//		}

	//	@Test
	//	public void Tc_prefCard_05()
	//		{
	//		testStarts("Tc_prefCard_05" , "Create Preference Card > Verify that user is able to reorder stages by clicking Reorder Stage button.");
	//		NavigateUrl(DashBoardURL);	
	//		PrefcardPageObject.prefCardPagePageLinkandwait();
	//		waitForElementToDisplay(OR.prefCard_AddPrefCard, 10);
	//		clickOn(OR.prefCard_AddPrefCard);
	//		clickOn(OR.prefCard_addStage);
	//		typeIn(OR.prefCard_addStageName, "TestStage001");
	//		waitForElementToDisplay(OR.prefCard_addStageButton, 20);
	//		clickOn(OR.prefCard_addStageButton);
	//		clickOn(OR.prefCard_addStage);
	//		typeIn(OR.prefCard_addStageName, "TestStage002");
	//		waitForElementToDisplay(OR.prefCard_addStageButton, 20);
	//		clickOn(OR.prefCard_addStageButton);
	//		clickOn(OR.prefCard_reorderStageButton);
	//		String firstStageBeforeDrag=getText(OR.prefCard_firstStage);
	//		System.out.println(firstStageBeforeDrag);
	//		String secondStageBeforeDrag=getText(OR.prefCard_secondStage);
	//		System.out.println(secondStageBeforeDrag);
	//		WebElement From = driver.findElement(By.xpath("//ul[@dnd-list='Ctrl.prefCardStages']/li[1]//p"));		  
	//		WebElement To = driver.findElement(By.xpath("//ul[@dnd-list='Ctrl.prefCardStages']/li[2]//p"));
	//		dragAndDrop2(From,To);
	//		
	//		//dragAndDrop(OR.prefCard_firstStage, OR.prefCard_secondStage);
	//		String firstStageAfterDrag=getText(OR.prefCard_firstStage);
	//		System.out.println(firstStageAfterDrag);
	//		String secondStageAfterDrag=getText(OR.prefCard_secondStage);
	//		System.out.println(secondStageAfterDrag);
	////		if(firstStageBeforeDrag.equals(secondStageAfterDrag)&&secondStageBeforeDrag.equals(firstStageAfterDrag))
	////		{
	////			testLogPass("Stages are Re-ordered");
	////		}
	////		else
	////		{
	////			testLogFail("Stages are not Re-ordered");
	////		}
	//		
	//		}

	@Test
	public void Tc_prefCard_06()
	{
		testStarts("Tc_prefCard_06" , "Create Preference Card > Stage tab > Verify that user is able to search item on basis of Name, alias, SKU and MFR.");
		System.out.println("Tc_prefCard_06");
		NavigateUrl(DashBoardURL);	
		//		cartPage.addNewItem();
		PrefcardPageObject.prefCardPagePageLinkandwait();
		waitForElementToDisplayWithoutFail(OR.prefCard_AddPrefCard, 10);
		clickOn(OR.prefCard_AddPrefCard);
		clickOn(OR.prefCard_addStage);
		setProperty("Prefcard_StageName", "abcdef");
		String sName=getProperty("Prefcard_StageName");
		typeIn(OR.prefCard_addStageName, sName);
		clickOn(OR.prefCard_addStageButton);		
		MycartPage.searchItem();

	}

	@Test
	public void Tc_prefCard_07()
	{
		testStarts("Tc_prefCard_07" , "Create Preference Card > Stage tab > Verify that item category appears above item name.");
		System.out.println("Tc_prefCard_07");
		NavigateUrl(DashBoardURL);
		//cartPage.addNewItem();
		clickOn(OR.DashBoard_AdminDropdown);
		clickOn(OR.Admin_ItemCatalog);
		waitForElementToDisplayWithoutFail(OR.ItemCatalog_AddItem, 20);
		String itemDesc=getProperty("ItemDesc");
		typeIn(OR.ItemCatalog_searchTextBox, itemDesc);
		clickOn(OR.ItemCatalog_searchButtoncommon);	
		waitForElementToDisplayWithoutFail(OR.ItemCatalog_firstitemName, 30);
		String firstCategory=null;
		if(getText(OR.ItemCatalog_firstitemName).equals(itemDesc))
		{
			clickOn(OR.ItemCatalog_firstEDitButton);		
			firstCategory = getDropDownText(OR.ItemCatalog_itemCategory,1);
			setProperty("firstCategory", firstCategory);
			clickOn(OR.ItemCatalog_SaveButton);
		}
		else
		{
			testLogFail("Search is not working properly on Item catalog page");
		}		
		PrefcardPageObject.addStageAndItem();		
		if(firstCategory!=null)
		{
			String temp=getText(OR.prefCard_catName);
			if(temp.equalsIgnoreCase(firstCategory))
			{
				testLogPass("Category" +firstCategory+ " is shown on the top of Item Name. ");				
			}			
		}
		else 
		{
			String temp=getText(OR.prefCard_catName);
			if(temp.equalsIgnoreCase("No category"))
			{
				testLogPass("Category name is Blank, so 'No category' is shown");				
			}
		}

	}

	@Test
	public void Tc_prefCard_08()
	{
		testStarts("Tc_prefCard_08" , "Create Preference Card > Stage tab > Verify that item category appears above item name.");
		System.out.println("Tc_prefCard_08");
		NavigateUrl(DashBoardURL);
		PrefcardPageObject.addStageAndItem();
		String s=getText(OR.prefCard_InitialopenQty);
		int intialOpenQty=Integer.parseInt(s);		
		String s1=getText(OR.prefCard_IntialHoldQty);
		int intialcloseQty=Integer.parseInt(s1);
		clickOn(OR.prefCard_plusIconOpenQTY);		
		String s3=getText(OR.prefCard_InitialopenQty);
		int afterOpenQty=Integer.parseInt(s3);		
		clickOn(OR.prefCard_plusIconHoldQTY);
		String s4=getText(OR.prefCard_InitialopenQty);
		int aftercloseQty=Integer.parseInt(s4);
		if(afterOpenQty==(intialOpenQty+1) && aftercloseQty==(intialcloseQty+1))
		{
			testLogPass("Quantities are Changing on clicking + Icon of Open and Close Quantities");	
		}
		else
		{
			testLogFail("Quantities are not Changing on clicking + Icon of Open and Close Quantities");	
		}

	}

	@Test
	public void Tc_prefCard_09()
	{
		testStarts("Tc_prefCard_09" , "Create Preference Card > Stage tab > Verify that corresponding item gets deleted when user clicks Delete button.");
		System.out.println("Tc_prefCard_09");
		NavigateUrl(DashBoardURL);
		PrefcardPageObject.addStageAndItem();
		clickOn(OR.prefCard_deleteQty);
		waitForElement(OR.prefCard_confirmButton);
		clickOn(OR.prefCard_confirmButton);
		waitForElementToDisplayWithoutFail(OR.prefCard_NoItemText, 10);
		verifyElementText(OR.prefCard_NoItemText ," No item in this stage.");

	}
	@Test
	public void Tc_prefCard_010()
	{
		testStarts("Tc_prefCard_10" , "Create Preference Card > Stage tab > Verify that corresponding stage gets deleted when user clicks Remove Stage button.");
		System.out.println("Tc_prefCard_010");
		NavigateUrl(DashBoardURL);
		PrefcardPageObject.prefCardPagePageLinkandwait();
		waitForElementToDisplayWithoutFail(OR.prefCard_AddPrefCard, 10);
		clickOn(OR.prefCard_AddPrefCard);
		clickOn(OR.prefCard_addStage);
		String sName=getProperty("Prefcard_StageName");
		typeIn(OR.prefCard_addStageName, sName);
		clickOn(OR.prefCard_addStageButton);
		waitForElement(OR.prefCard_removeStage);
		clickOn(OR.prefCard_removeStage);
		waitForElement(OR.prefCard_removeStage);
		clickOn(OR.prefCard_confirmButton);
		if(!isElementDisplayed(OR.prefCard_removeStage, 10))
		{
			testLogPass("Stage is deleted Successfully");
		}
		else
		{
			testLogFail("Stage is deleted Successfully");			
		}

	}

	@Test
	public void Tc_prefCard_12()
	{
		testStarts("Tc_prefCard_12" , "Create Preference Card > Verify that user can copy stage's from other prefcards using copy stages button. ");
		System.out.println("Tc_prefCard_12");
		NavigateUrl(DashBoardURL);
		PrefcardPageObject.prefCardPagePageLinkandwait();
		waitForElementToDisplayWithoutFail(OR.prefCard_AddPrefCard, 10);
		clickOn(OR.prefCard_AddPrefCard);
		clickOn(OR.prefCard_copyStages);
		waitForElementToDisplayWithoutFail(OR.prefCard_copyStagesPopUpText,50);
		selectFromDropdown(OR.prefCard_copyPredCardDrpDown, 1);
		String stageName=getDropDownText(OR.prefCard_copyPredCardStageDroppDown, 1);
		System.out.println(stageName);
		clickOn(OR.prefCard_addButtton);
		clickOn(OR.prefCard_copyButtton);
		String temp=getText(OR.prefCard_stageName);
		System.out.println(temp);
		if(temp.contains(stageName))
		{
			testLogPass("Stage is copied from other Preference Card");
		}
		else
		{
			testLogFail("Stage is not copied from other Preference Card");
		}

	}

	@Test
	public void Tc_prefCard_14()
	{
		testStarts("Tc_prefCard_14" , "Verify that corresponding preference card gets deleted when user clicks Delete button if corresponding card has no stages in it.");
		System.out.println("Tc_prefCard_14");
		Loginpage.OpenBrowserAndLogin();
		NavigateUrl(DashBoardURL);
		PrefcardPageObject.prefCardPagePageLinkandwait();
		waitForElementToDisplayWithoutFail(OR.prefCard_AddPrefCard, 10);
		clickOn(OR.prefCard_AddPrefCard);
		String cardName = "cardName"+ApplicationKeyword.randomAlphaNumeric(2);
		typeIn(OR.prefCard_CardName, cardName);
		selectFromDropdown(OR.prefCard_PhysicianName, 1);
		waitForElementToDisplayWithoutFail(OR.prefCard_saveButton, 10);
		clickOn(OR.prefCard_saveButton);
		waitForElementToDisplayWithoutFail(OR.prefCard_searchTextBox, 10);
		typeIn(OR.prefCard_searchTextBox, cardName);
		waitForElementToDisplayWithoutFail(OR.prefCard_firstprefcard, 10);
		if(getText(OR.prefCard_firstprefcard).contains(cardName))
		{
			clickOn(OR.prefCard_removePrefCard);
			waitForElementToDisplayWithoutFail(OR.prefCard_confirmButton, 20);
			clickOn(OR.prefCard_confirmButton);
			typeIn(OR.prefCard_searchTextBox, cardName);
			verifyElementText(OR.prefCard_NoPrefCardText, "No Preference cards Found.");			
		}
		else
		{
			testLogFail("Either preference card is not created or there is some issue in search on this page");
		}

	}

	@Test
	public void Tc_prefCard_15()
	{
		testStarts("Tc_prefCard_15" , "Verify that user can copy any existing prefcard using �Copy Preference Card.� icon.");
		System.out.println("Tc_prefCard_15");
		NavigateUrl(DashBoardURL);
		//Loginpage.OpenBrowserAndLogin();	
		PrefcardPageObject.prefCardPagePageLinkandwait();
		waitForElementToDisplayWithoutFail(OR.prefCard_copyCard, 10);
		//waitTime(3);
		clickOn(OR.prefCard_copyCard);
		verifyElementText(OR.prefCard_copyCardPopUpText, "Copy Preference Card.");	

	}



	@AfterTest
	public void endReport(){
		closeBrowser();
		extent.flush();
	}

}
