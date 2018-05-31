package testCases;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import pageObject.Loginpage;
import pageObject.ManageInventoryPOpage;
import pageObject.MycartPage;
import pageObject.OrderDetailsPage;
import pageObject.OrderPage;
import pageObject.Template;
import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;
import AutomationFramework.Generickeywords;

public class Tc_Template extends ApplicationKeyword{


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
			}

			extent = new ExtentReports(folderPath+"/template.html", true);
			extent.addSystemInfo("User Name", "Ravneet");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}

	@Test()
	public void Tc_Template_001() {
		testStarts("Tc_Template_001, Tc_Template_002","Verify that user is able to add template by clicking Add Template button."
				+"Verify that user is able to add items in template by scanning/searching for corresponding items on the basis of Name, alias, MFR# and SKU.");
		//NavigateUrl(DashBoardURL);
		Loginpage.OpenBrowserAndLogin();
		clickOn(OR.Templates);		
		Template.AddDeleteScheduleTemplate();

	}

	@Test()
	public void Tc_Template_010() {
		testStarts("Tc_Template_010","Verify that users gets redirected to â€œUse templateâ€� screen on clicking Use icon.");
		//Loginpage.OpenBrowserAndLogin();
		NavigateUrl(DashBoardURL);
		clickOn(OR.Templates);		
		Template.searchTemplate();
		String tempName=getProperty("TemplateName");
		waitForElementToDisplayWithoutFail(OR.Template_UseTemplate, 10);
		clickOn(OR.Template_UseTemplate);
		waitForElementToDisplayWithoutFail(OR.Template_VerifytempName, 10);
		waitTime(4);
		if(getText(OR.Template_VerifytempName).equalsIgnoreCase(tempName))
		{				
			testLogPass("Use template screen is opened");
		}
		else
		{
			testLogFail("Use template screen is not opened");
		}						
	}

	@Test()
	public void Tc_Template_004_005() {
		testStarts("Tc_Template_004, Tc_Template_005","Verify that only user with edit access of template should be able to edit 'Template'\n"
				+"Edit Template > Verify the red/green/yellow circle appear with corresponding item after user saves templates and edits it again.");
		//Loginpage.OpenBrowserAndLogin();
		NavigateUrl(DashBoardURL);
		clickOn(OR.Templates);		
		String tempName=getProperty("TemplateName");
		typeIn(OR.Template_Search_Input, tempName);
		clickOn(OR.Template_SearchBtn);
		waitForElementToDisplayWithoutFail(OR.Template_firstTemplate, 10);
		waitForElementToDisplayWithoutFail(OR.Template_Edit, 10);
		if(getText(OR.Template_firstTemplate).equalsIgnoreCase(tempName))
		{
			clickOn(OR.Template_Edit);
			verifyPageTitle("Manage Templates");
			if(!getAttributeValue(OR.Template_circleIcons, "class").equalsIgnoreCase(null))
			{
				testLogPass("Red icon is present");

			}
			else
			{
				testLogFail("Red icon is not present");
			}
			//			clickOn(OR.Template_Schedule);
			//			Template.deleteSchedule();
			clickOn(OR.Template_SAveTemplate);
			waitForElementToDisplayWithoutFail(OR.Template_closeButton, 10);
			waitTime(2);		
			clickOn(OR.Template_closeButton);
			waitTime(4);

			waitForElementToDisplayWithoutFail(OR.Template_HeaderText, 10);
			waitTime(3);
			String header=getText(OR.Template_HeaderText);
			if(header.equalsIgnoreCase("My Templates"))
			{
				testLogPass("NAvigated to MY templates Page");
			}
			else
			{
				testLogFail("Cannot Navigate to MY templates Page");
			}
		}
		else
		{
			testLogFail("Template is not searched Properly");
		}		
	}

	@Test()
	public void Tc_Template_009() {
		testStarts("Tc_Template_009","Verify that Template gets deleted on clicking Delete button.");
		NavigateUrl(DashBoardURL);
		clickOn(OR.Templates);
		String tempName=getProperty("TemplateName");
		typeIn(OR.Template_Search_Input, tempName);
		clickOn(OR.Template_SearchBtn);
		waitForElementToDisplayWithoutFail(OR.Template_firstTemplate, 10);
		if(getText(OR.Template_firstTemplate).equalsIgnoreCase(tempName))
		{
			clickOn(OR.Template_Delete);
			waitForElementToDisplayWithoutFail(OR.Template__Deletevalidation, 10);
			verifyElementText(OR.Template__Deletevalidation, "Are you sure?");
			verifyElementText(OR.Template__Deletetemplatevalidation, "Are you sure you want to delete this template ?");
			clickOn(OR.Template_Yes);
			waitForElementToDisplayWithoutFail(OR.Template_Search_Input, 10);
			typeIn(OR.Template_Search_Input, tempName);
			clickOn(OR.Template_SearchBtn);
			waitForElementToDisplayWithoutFail(OR.Template_firstTemplate, 10);
			if(getText(OR.Template_NoTemplate).equalsIgnoreCase("No Template Found"))
			{
				testLogPass("Template is Deleted");
			}
			else
			{
				testLogPass("Template is not Deleted");
			}
		}
		else
		{
			testLogFail("Template is not searched");
		}

	}

	//Delete Created Item
	@Test
	public void Tc_manageInv_04()
	{
		testStarts("Tc_manageInv_04","Delete created item");
		NavigateUrl(DashBoardURL);
		ManageInventoryPOpage.PageLinkAndWait("inventory", OR.manageInv_pageLink);
		String itemDesc=getProperty("ItemDesc");
		typeIn(OR.manageInv_searchTextBox, itemDesc);
		clickOn(OR.manageInv_searchButton);
		//waitForElementToDisplayWithoutFail(OR.manageInv_firstItemDesc, 20);
		waitForElementToDisplayWithoutFail("firstItemDesc#xpath=(//*[@class='item-description']/span[text()='"+itemDesc+"'])[1]", 10);
		String ItemName=getText(OR.manageInv_firstItemDesc);
		if(ItemName.equalsIgnoreCase(itemDesc))
		{
			testLogPass("Item is searched with " + ItemName);
			waitForElementToDisplayWithoutFail(OR.manageInv_DeleteIcon, 20);
			clickOn(OR.manageInv_DeleteIcon);
			verifyElementText(OR.manageInv_DeletePoUp, ("Do you really want to delete the item"));
			clickOn(OR.manageInv_confirmButton);
			waitForElementToDisplayWithoutFail("firstItemDesc#xpath=(//*[@class='item-description']/span[text()='"+itemDesc+"'])[1]", 10);
			String ItemName2=getText(OR.manageInv_firstItemDesc);
			if(!ItemName2.equalsIgnoreCase(itemDesc))
			{
				testLogPass("Item is deleted successfully");
			}
			else
			{
				testLogFail("Item is not deleted");
			}
		}
		else
		{
			testLogFail("Item is not searched with " + ItemName);			
		}

	}

	@AfterTest
	public void endReport(){
		closeBrowser();
		extent.flush();
	}
}


