package testCases;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import pageObject.Loginpage;
import pageObject.MycartPage;
import pageObject.ReceivePageObject;
import AutomationFramework.ApplicationKeyword;
import AutomationFramework.Generickeywords;
import AutomationFramework.OR;

public class Receive extends ApplicationKeyword
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

			extent = new ExtentReports(folderPath+"/receive.html", true);
			// extent.addSystemInfo("Environment","Environment Name")
			extent.addSystemInfo("User Name", "Ravneet");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}
	
	@Test
	public void Tc_Receive_01() throws InterruptedException
	{
		testStarts("Tc_Receive_01()", "Verify that PO with 'Assigned', 'Confirmed' or 'Partial Received' status appear on page.");
		Loginpage.OpenBrowserAndLogin();	
		System.out.println("Tc_Receive_01");
		ReceivePageObject.pageLinkandwait();
		List<String> status = new ArrayList<String>( Arrays.asList("All", "Assigned" , "Confirmed", "Partial Received"));
		clickOn(OR.Receive_statusDropdown);
		waitTime(2);
		List<WebElement> actualStatus = driver.findElements
				(By.xpath("//*[@id='status']//ul/li/div[@role='option']"));		
		if(status.size() == actualStatus.size())
		{
			for(int i=0; i<status.size(); i++)
			{	
				if(status.get(i).equals(actualStatus.get(i).getText()))
				{	
					testLogPass(status.get(i)+" Option matched with " +actualStatus.get(i).getText());					
				}
				else
				{
					testLogFail(status.get(i)+" Option doesnot matched with " +actualStatus.get(i).getText());					
				}
			}
		}	
		else
		{
			testLogFail("Both the Lists Donot have same number of Options");
		}		  
		
	}
	
	
//	@Test
//	public void Tc_Receive_02() 
//	{
//		testStarts("Tc_Receive_02()", "Verify that user can search PO on basis PO#, Sku, Notes or Documents. ");
//		NavigateUrl(DashBoardURL);	
//		ReceivePageObject.pageLinkandwait();
//		
//		String s=getText(OR.Receive_firstPONum);
//		typeIn(OR.Receive_SearchTextBox, s);
//		clickOn(OR.Receive_searchButton);
//		waitForElementToDisplay(OR.Receive_firstPONum, 10);
//		String s2=getText(OR.Receive_firstPONum);
//		verifyElementText(OR.Receive_firstPONum, s2);
//		
//	}
	
	
	@Test
	public void Tc_Receive_03() throws InterruptedException
	{
		testStarts("Tc_Receive_03()", "Verify that following dropdown filters appear on page. Vendor Status Type Facility Department Created By");
		NavigateUrl(DashBoardURL);	
		System.out.println("Tc_Receive_03");
		ReceivePageObject.pageLinkandwait();
		if(isElementDisplayed(OR.Receive_vendorDropdown, 10))
		{
			testLogPass("Vendor DropDown is Present");
		}
		else
		{
			testLogFail("Vendor DropDown is not Present");

		}
		if(isElementDisplayed(OR.Receive_statusDropdown, 10))
		{
			testLogPass("Status DropDown is Present");
		}
		else
		{
			testLogFail("Status DropDown is not Present");

		}
		if(isElementDisplayed(OR.Receive_facilityDropdown, 10))
		{
			testLogPass("Facility DropDown is Present");
		}
		else
		{
			testLogFail("Facility DropDown is not Present");

		}
		if(isElementDisplayed(OR.Receive_departmentDropdown, 10))
		{
			testLogPass("Department DropDown is Present");
		}
		else
		{
			testLogFail("Department DropDown is not Present");

		}
		if(isElementDisplayed(OR.Receive_typeDropdown, 10))
		{
			testLogPass("Type DropDown is Present");
		}
		else
		{
			testLogFail("Type DropDown is not Present");

		}
		if(isElementDisplayed(OR.Receive_createdByDropdown, 10))
		{
			testLogPass("CreatedBy DropDown is Present");
		}
		else
		{
			testLogFail("CreatedBy DropDown is not Present");

		}
		
	}

	@Test
	public void Tc_Receive_05_06() 
	{
		testStarts("Tc_Receive_05_06()", "Verify that �Notes for PO #� window appears when user clicks on notes icon with count."
	+"Verify that �Add Note for PO #� pop up appears when user clicks on �Add New Note�\"");
		NavigateUrl(DashBoardURL);	
		System.out.println("Tc_Receive_05_06");
		ReceivePageObject.pageLinkandwait();
		waitForElementToDisplayWithoutFail(OR.Receive_selectedFacInDropDown, 10);
		ReceivePageObject.shopFacility();
		waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 6);
		if(isElementDisplayedwithoutFail(OR.Receive_firstPONum, 5))
		{
		clickOn(OR.Receive_NotesLink);
		waitForElementToDisplayWithoutFail(OR.Receive_NotesLinkText, 10);
		verifyElementText(OR.Receive_NotesLinkText, "Notes for PO # ");
		clickOn(OR.Receive_AddNewNotesLink);
		waitForElementToDisplayWithoutFail(OR.Receive_NotesLinkText, 10);
		verifyElementText(OR.Receive_NotesLinkText, "Add Note for PO # ");
		clickOn(OR.Receive_PrintCloseclose);	
		waitTime(2);
		clickOn(OR.Receive_PrintCloseclose);
		}
		else
		{
			testLogFail("No PO in receive module");
		}
		
		
	}
//	@Test(priority=4)
//	public void Tc_Receive_06() throws InterruptedException 
//	{
//		testStarts("Tc_Receive_06()", "Verify that �Add Note for PO #� pop up appears when user clicks on �Add New Note�");
//		NavigateUrl(DashBoardURL);
//		ReceivePageObject.pageLinkandwait();
//		ReceivePageObject.selectByDefaultFacility();
//		waitForElementToDisplay(OR.Receive_NotesLinkWait, 10);
//		clickOn(OR.Receive_NotesLink);
//		waitForElementToDisplay(OR.Receive_NotesLinkText, 10);
//		clickOn(OR.Receive_AddNewNotesLink);
//		waitForElementToDisplay(OR.Receive_NotesLinkText, 10);
//		verifyElementText(OR.Receive_NotesLinkText, "Add Note for PO # ");
//		clickOn(OR.Receive_PrintCloseclose);	
//		waitTime(1);
//		
//	}
	@Test
	public void Tc_Receive_07_19() throws InterruptedException 
	{
		testStarts("Tc_Receive_07_19()", "Verify that �PO # XXXX11 Documents� pop up appears when clicks on Documents icon with count +"
				+ "Verify that select file from computer window opens when user clicks on Upload File button.");
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_Receive_07_19");
		ReceivePageObject.pageLinkandwait();
//		String alreadySelectedFac=getText(OR.Receive_selectedFacInDropDown);
//		setProperty("selectedFac_InReceiveModule",alreadySelectedFac);
//		String alreadySelectedUser=getText(OR.Receive_selectedUserInDropDown);
//		setProperty("selectedUser_InReceiveModule",alreadySelectedUser);
//		if(alreadySelectedFac)
		ReceivePageObject.shopFacility();
		waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 3);
		if(isElementDisplayedwithoutFail(OR.Receive_firstPONum, 5))
		{
		waitForElementToDisplayWithoutFail(OR.Receive_DocsLink, 10);
		clickOn(OR.Receive_DocsLink);
		waitForElementToDisplayWithoutFail(OR.Receive_DocsLinkText, 10);
		String s=getText(OR.Receive_firstPONum);
		verifyElementText(OR.Receive_DocsLinkText, "PO # " +s+ " Documents");		
		WebElement elem=driver.findElement(By.xpath("//*[@type='file']"));
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path --- " + projectPath);
		elem.sendKeys(projectPath + "/assets/images.jpeg");
		String nameOfFile_Expected="images.jpeg";
		waitTime(5);
		waitForElementToDisplayWithoutFail(OR.Invoice_UploadDocName, 10);
		String s2=getText(OR.Invoice_UploadDocName).trim();
		if(s2.trim().equalsIgnoreCase(nameOfFile_Expected))
		{
			testLogPass("File is uploaded with the same name as expected");
			WebElement wholeElem=driver.findElement(By.xpath("//*[@class='col-sm-18']"));
			WebElement trashIcon=wholeElem.findElement(By.xpath("(//a[@class='a-with-icon pull-right ng-scope']/i[@class='fa fa-trash-o'])[1]"));
			trashIcon.click();
			//clickOn(OR.Receive_NotesDeleteIcon);
			waitForElementToDisplayWithoutFail(OR.Receive_confirmButton, 10);
			//waitForElementToDisplay(OR.Receive_confirmButton, 10);
			clickOn(OR.Receive_confirmButton);
		}
		else
		{			
			testLogFail("File is uploaded with the same name as expected");			
		}
		//waitForElementToDisplay(OR.Receive_waitDoc, 10);
		//Thread.sleep(4000);
		waitForElementToDisplayWithoutFail(OR.Receive_PrintCloseclose, 10);
//		clickOn(OR.Receive_NotesDeleteIcon);
//		waitForElementToDisplay(OR.Receive_confirmButton, 10);
//		clickOn(OR.Receive_confirmButton);
		clickOn(OR.Receive_PrintCloseclose);
		}
		else
		{
			testLogFail("No PO in receive module");
		}
		
	}
	@Test
	public void Tc_Receive_09() 
	{
		testStarts("Tc_Receive_09()", "Verify that �Print PO� preview window appears when user clicks on Print Po option in action dropdown");
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_Receive_09");
		ReceivePageObject.pageLinkandwait();	
		ReceivePageObject.shopFacility();
		waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 3);
		if(isElementDisplayedwithoutFail(OR.Receive_firstPONum, 5))
		{
		waitForElementToDisplayWithoutFail(OR.Receive_DrillDownIcon, 10);
		clickOn(OR.Receive_DrillDownIcon);
		clickOn(OR.Receive_PrintPOLink);
		waitForElementToDisplayWithoutFail(OR.Receive_PrintPOText, 10);		
		verifyElementText(OR.Receive_PrintPOText, " Print PO");
		clickOn(OR.Receive_PrintPReviewclose);	
		}
		else
		{
			testLogFail("No PO in receive module");
		}
		
	}
	@Test
	public void Tc_Receive_10() 
	{
		testStarts("Tc_Receive_10()", "Verify that user gets redirected to �INVOICE FOR PO #� page, on clicking �Add Invoice� option.");
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_Receive_10");
		ReceivePageObject.pageLinkandwait();
		ReceivePageObject.shopFacility();
		waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 3);
		if(isElementDisplayedwithoutFail(OR.Receive_firstPONum, 5))
		{
		waitForElementToDisplayWithoutFail(OR.Receive_DrillDownIcon, 10);
		clickOn(OR.Receive_DrillDownIcon);
		WebElement element = driver.findElement(By.xpath("(//a[text()='Invoices'])[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		waitForElementToDisplayWithoutFail(OR.Order_PO_first_Addinvoice, 60);
		clickOn(OR.Order_PO_first_Addinvoice);
		verifyElementText(OR.Receive_InvoiceForText, "INVOICE FOR PO #:");
		}
		else
		{
			testLogFail("No PO in receive module");
		}
	}
	
	//necessary to put waiTime instead of dynamic
	
	@Test
	public void Tc_Receive_11() throws InterruptedException 
	{
		testStarts("Tc_Receive_11()", "Verify that �INVOICES FOR PO #� page appears when user clicks on All Invoices option.");
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_Receive_11");
		ReceivePageObject.pageLinkandwait();
		ReceivePageObject.shopFacility();
		waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 3);
		if(isElementDisplayedwithoutFail(OR.Receive_firstPONum, 5))
		{
		waitForElementToDisplayWithoutFail(OR.Receive_DrillDownIcon, 10);
		clickOn(OR.Receive_DrillDownIcon);
		WebElement element = driver.findElement(By.xpath("(//a[text()='Invoices'])[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		//Thread.sleep(3000);
		waitForElementToDisplayWithoutFail(OR.Order_PO_first_AllInvoice, 10);
		clickOn(OR.Order_PO_first_AllInvoice);
		String s=getText(OR.Order_PO_first_AllInvoice_Header);
		System.out.println(s);
		if(s.contains("INVOICES FOR PO #"))
		{
			
			testLogPass("Pop up is opened");
		}
		else
		{
			testLogPass("Pop up is not opened");
			
		} 
		}
		else
		{
			testLogFail("No PO in receive module");
		}
	}
	
	//necessary to put waiTime instead of dynamic
	@Test
	public void Tc_Receive_12() 
	{
		testStarts("Tc_Receive_12()", "Verify that �Print Window� appears on clicking Print button..");
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_Receive_12");
		ReceivePageObject.pageLinkandwait();
		ReceivePageObject.shopFacility();
		waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 3);
		if(isElementDisplayedwithoutFail(OR.Receive_firstPONum, 5))
		{
		waitForElementToDisplayWithoutFail(OR.Receive_DrillDownIcon, 10);		
		clickOn(OR.Receive_DrillDownIcon);
		waitForElementToDisplayWithoutFail(OR.Receive_printPO, 10);
		clickOn(OR.Receive_printPO);
		verifyElementText(OR.Receive_printPOText, "Print PO # ");
		clickOn(OR.Receive_PrintCloseclose);	
		//waitTime(3);
		
		}
		else
		{
			testLogFail("No PO in receive module");
		}
	}
	
	@Test
	public void Tc_Receive_014() {
		testStarts("Tc_Receive_014",
				"Verify that �PO AUDIT LOGS FOR PO #� pop up window appears when user clicks on Po Log option in the dropdown.");
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_Receive_014");
		ReceivePageObject.pageLinkandwait();
		ReceivePageObject.shopFacility();
		waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 3);
		if(isElementDisplayedwithoutFail(OR.Receive_firstPONum, 5))
		{
		waitForElementToDisplayWithoutFail(OR.Receive_DrillDownIcon, 10);
		clickOn(OR.Receive_DrillDownIcon);
		waitForElementToDisplay(OR.Receive_POLOg, 10);
		clickOn(OR.Receive_POLOg);	
		waitForElementToDisplayWithoutFail(OR.Receive_POLOgText,10);
		verifyElementText(OR.Receive_POLOgText, "PO AUDIT LOGS FOR PO #");	
		clickOn(OR.Receive_PrintCloseclose);	
		}
		else
		{
			testLogFail("No PO in receive module");
		}
				
	}
	
	@Test
	public void Tc_Receive_017() {
		testStarts("Tc_Receive_017",
				"Verify that notes gets deleted when user clicks on 'Delete' button for the added note.");
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_Receive_017");
		ReceivePageObject.pageLinkandwait();
		ReceivePageObject.shopFacility();
		waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 3);
		if(isElementDisplayedwithoutFail(OR.Receive_firstPONum, 5))
		{
		waitForElementToDisplayWithoutFail(OR.Receive_DrillDownIcon, 10);
		clickOn(OR.Receive_NotesLink);
		waitForElementToDisplayWithoutFail(OR.Receive_NotesLinkText, 10);
		clickOn(OR.Receive_AddNewNotesLink);
		//waitForElementToDisplay(OR.Receive_NotesLinkText, 10);
		String testNote="TestNote";
		typeIn(OR.Receive_AddNewNote, testNote);		
		clickOn(OR.Receive_AddNewNoteButton);
		typeIn(OR.Receive_searchBox, testNote);	
		waitForElementToDisplayWithoutFail(OR.Receive_searchedfirstNote, 10);
		if(getText(OR.Receive_searchedfirstNote).equals(testNote))
		{
			clickOn(OR.Receive_DeleteIcon);
			clickOn(OR.Receive_confirmButton);
		}		
		typeIn(OR.Receive_searchBox, testNote);
		verifyElementText(OR.Receive_NoNOteavailable, "No note available.");
		clickOn(OR.Receive_PrintCloseclose);	
		}
		else
		{
			testLogFail("No PO in receive module");
		}
		
	}
	
	
	@Test
	public void Tc_Receive_20() 
	{
		testStarts("Tc_Receive_20()", "Verify that items in PO gets added to cart when user clicks on �Add Items to cart� option");
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_Receive_20");
		clickOn(OR.MyCart);
		MycartPage.checkIfCartIsEmpty();
		ReceivePageObject.pageLinkandwait();
		ReceivePageObject.shopFacility();
		waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 3);
		if(isElementDisplayedwithoutFail(OR.Receive_firstPONum, 5))
		{		
		waitForElementToDisplayWithoutFail(OR.Receive_DrillDownIconwait, 10);
		clickOn(OR.Receive_DrillDownIcon);
		waitForElementToDisplayWithoutFail(OR.Receive_AdditemsToCart,10);
		clickOn(OR.Receive_AdditemsToCart);
		//waitTime(3000);
		waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 10);
		clickOn(OR.Receive_firstPONum);
		waitForElementToDisplayWithoutFail(OR.Receive_firstPOHeadingText, 10);
		//boolean result=false;
		List<String> allItemNames=new ArrayList<String>();		
		List<WebElement> itemNames=driver.findElements(By.xpath("//table[@class='table table-body-striped ng-scope']//item-info[@class='ng-isolate-scope']"));		
		for(int i=1; i<=itemNames.size(); i++)
		{			
			String ProductName=getAttributeValue(OR.Receive_itemNames, "name");						
			allItemNames.add(ProductName);	
			System.out.println(ProductName);
		}
		clickOn(OR.MyCart);	
		//waitForElementToDisplay(OR.Receive_itemsNamesInCart, 10);
		List<WebElement> itemNamesInCart=driver.findElements(By.xpath("//*[@value='name']"));
		System.out.println(itemNamesInCart.size());
		boolean prodNotFoundInCart=true; 		
		for(int i=1;i<=allItemNames.size();i++)
		{
			prodNotFoundInCart = false;
			for(int j=1;j<=itemNamesInCart.size();j++)
			{
				String ProductNameInCart=itemNamesInCart.get(i-1).getText().trim();// getText(OR.Receive_itemsNamesInCart);
				System.out.println("NAME in CART -- " + ProductNameInCart);
				System.out.println("NAME in PO -- " + allItemNames.get(i-1).trim());				
				if(allItemNames.get(i-1).trim().equalsIgnoreCase(ProductNameInCart))
				{
					prodNotFoundInCart=false;
					break;
				}
				else
					prodNotFoundInCart=true;
			}			
			if(prodNotFoundInCart)
			{
				testLogFail("Both the lists do not have same items");
				break;
			}
			else
			{
				testLogPass("Both the lists have same items");
				
			}
		}
		}
		else
		{
			testLogFail("No PO in receive module");
		}
	}


	@Test
	public void Tc_Receive_21() 
	{
		testStarts("Tc_Receive_10()", "Verify that user gets redirected to PO detail page on clicking PO number.");
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_Receive_21");
		ReceivePageObject.pageLinkandwait();
		ReceivePageObject.shopFacility();
		waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 3);
		if(isElementDisplayedwithoutFail(OR.Receive_firstPONum, 5))
		{
		waitForElementToDisplayWithoutFail(OR.Receive_DrillDownIconwait, 10);
		//String firstPoNum=getText(OR.Receive_firstPONum).toUpperCase();
		clickOn(OR.Receive_firstPONum);
		waitForElementToDisplayWithoutFail(OR.Receive_firstPOHeadingText, 10);
		verifyElementText(OR.Receive_firstPOHeadingText, ("PURCHASE ORDER # "));		
		}
		else
		{
			testLogFail("No PO in receive module");
		}
	}

	@AfterTest
	public void endReport(){
		closeBrowser();
		extent.flush();
	}

	


}
