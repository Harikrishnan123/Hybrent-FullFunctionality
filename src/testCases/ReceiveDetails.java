package testCases;

import java.io.File;
import java.util.ArrayList;
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

public class ReceiveDetails extends ApplicationKeyword
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

			extent = new ExtentReports(folderPath+"/receivedetails.html", true);
			// extent.addSystemInfo("Environment","Environment Name")
			extent.addSystemInfo("User Name", "Ravneet");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}

	@Test
	public void Tc_RECDET_01()
	{
		testStarts("Tc_RECDET_01", "Verify that 'Notes for PO #' window appears when user clicks on notes icon with count."+"Verify that �Add Note for PO #� pop up appears when user clicks on �Add New Note�");
		Loginpage.OpenBrowserAndLogin();	
		System.out.println("Tc_RECDET_01");
		ReceivePageObject.pageLinkandwait();
		ReceivePageObject.shopFacility();
		waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 3);
		if(isElementDisplayedwithoutFail(OR.Receive_firstPONum, 5))
		{
			waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 10);
			//waitTime(5);
			clickOn(OR.Receive_firstPONum);
			waitForElement(OR.Receive_NotesLinkPODetail);
			clickOn(OR.Receive_NotesLinkPODetail);
			waitForElement(OR.Receive_NotesLinkText);
			verifyElementText(OR.Receive_NotesLinkText, "Notes for PO # ");
			clickOn(OR.Receive_AddNewNotesLink);
			waitForElement(OR.Receive_NotesLinkText);
			verifyElementText(OR.Receive_NotesLinkText, "Add Note for PO # ");
			clickOn(OR.Receive_PrintCloseclose);
			waitForElement(OR.Receive_PrintCloseclose);
			clickOn(OR.Receive_PrintCloseclose);
		}

		else
		{
			testLogFail("No PO in receive module");
		}
	}

	//	@Test(priority=2)
	//	public void Tc_RECDET_02()
	//	{
	//		testStarts("Tc_RECDET_02", "Verify that �Add Note for PO #� pop up appears when user clicks on �Add New Note�");
	//		NavigateUrl(DashBoardURL);	
	//		ReceivePageObject.pageLinkandwait();
	//		waitForElementToDisplay(OR.Receive_firstPONum, 10);
	//		clickOn(OR.Receive_firstPONum);
	//		waitForElementToDisplay(OR.Receive_NotesLinkPODetail, 10);
	//		clickOn(OR.Receive_NotesLinkPODetail);
	//		waitForElementToDisplay(OR.Receive_NotesLinkText, 10);
	//		verifyElementText(OR.Receive_NotesLinkText, "Notes for PO # ");
	//		clickOn(OR.Receive_AddNewNotesLink);
	//		waitForElementToDisplay(OR.Receive_NotesLinkText, 10);
	//		verifyElementText(OR.Receive_NotesLinkText, "Add Note for PO # ");
	//		clickOn(OR.Receive_PrintCloseclose);
	//		waitTime(3);
	//		
	//	}

	@Test
	public void Tc_RECDET_03_04() throws InterruptedException
	{
		testStarts("Tc_RECDET_03_04()", "Verify that �PO # XXXX11 Documents� pop up appears when clicks on Documents icon with count +"
				+ "Verify that select file from computer window opens when user clicks on Upload File button.");
		NavigateUrl(DashBoardURL);	
		System.out.println("Tc_RECDET_03_04");
		ReceivePageObject.pageLinkandwait();
		//ReceivePageObject.selectByDefaultFacility();
		ReceivePageObject.shopFacility();
		waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 3);
		if(isElementDisplayedwithoutFail(OR.Receive_firstPONum, 5))
		{
			waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 10);
			//waitTime(5);
			String s=getText(OR.Receive_firstPONum);
			clickOn(OR.Receive_firstPONum);
			waitForElement(OR.Receive_DocsLinkPODetail);
			clickOn(OR.Receive_DocsLinkPODetail);
			waitForElement(OR.Receive_DocsLinkText);
			verifyElementText(OR.Receive_DocsLinkText, "PO # " +s+ " Documents");		
			WebElement elem=driver.findElement(By.xpath("//*[@type='file']"));
			String projectPath = System.getProperty("user.dir");
			elem.sendKeys(projectPath + "/assets/images.jpeg");
			waitTime(3);
			waitForElementToDisplay(OR.Invoice_UploadDocName, 10);
			String nameOfFile_Expected="images.jpeg";
			String s2=getText(OR.Invoice_UploadDocName).trim();
			if(s2.equalsIgnoreCase(nameOfFile_Expected))
			{
				testLogPass("Name of the image uploaded  matched");
				WebElement wholeElem=driver.findElement(By.xpath("//*[@class='col-sm-18']"));
				WebElement trashIcon=wholeElem.findElement(By.xpath("(//a[@class='a-with-icon pull-right ng-scope']/i[@class='fa fa-trash-o'])[1]"));
				trashIcon.click();
				clickOn(OR.Receive_confirmButton);
				waitTime(2);
			}
			else
			{			
				testLogFail("Name of the image uploaded is not matched");			
			}	
			clickOn(OR.Receive_PrintCloseclose);		
		}
		else
		{
			testLogFail("No PO in receive module");
		}
	}

	@Test
	public void Tc_RECDET_05() 
	{
		testStarts("Tc_RECDET_05()", "Verify that items in PO gets added to cart when user clicks on �Add Items to cart� option");
		System.out.println("Tc_RECDET_05");		
		NavigateUrl(DashBoardURL);	
		clickOn(OR.MyCart);
		MycartPage.checkIfCartIsEmpty();
		ReceivePageObject.pageLinkandwait();
		//ReceivePageObject.selectByDefaultFacility();
		ReceivePageObject.shopFacility();
		waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 3);
		if(isElementDisplayedwithoutFail(OR.Receive_firstPONum, 5))
		{
			waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 10);
			//waitTime(5);
			clickOn(OR.Receive_firstPONum);
			//waitTime(5);
			waitForElementToDisplayWithoutFail(OR.Receive_DrillDownPODetailPage,10);
			clickOn(OR.Receive_DrillDownPODetailPage);
			waitForElementToDisplayWithoutFail(OR.Receive_AddOrderItemsTOCartDetaipPage,10);
			clickOn(OR.Receive_AddOrderItemsTOCartDetaipPage);
			waitTime(4);
			//waitForElementToDisplay(OR.Receive_firstPOHeadingText, 10);
			//boolean result=false;
			List<String> allItemNames=new ArrayList<String>();		
			List<WebElement> itemNames=driver.findElements(By.xpath("//table[@class='table table-body-striped ng-scope']//item-info[@class='ng-isolate-scope']"));		
			System.out.println(itemNames.size());
			for(int i=1; i<=itemNames.size(); i++)
			{			
				String ProductName=getAttributeValue(OR.Receive_itemNames, "name");						
				allItemNames.add(ProductName);	
			}
			clickOn(OR.MyCart);	
			waitTime(4);
			//waitForElementToDisplay(OR.Receive_itemsNamesInCart, 20);
			List<WebElement> itemNamesInCart=driver.findElements(By.xpath("//*[@value='name']"));
			System.out.println("CART SIZE -- " + itemNamesInCart.size());
			System.out.println("PO SIZE -- " + allItemNames.size());
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
	public void Tc_RECDET_06()
	{
		testStarts("Tc_RECDET_06()", "Verify that �Print PO� preview window appears when user clicks on Print Po option in action dropdown");
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_RECDET_06");
		ReceivePageObject.pageLinkandwait();
		//ReceivePageObject.selectByDefaultFacility();
		ReceivePageObject.shopFacility();
		waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 3);
		if(isElementDisplayedwithoutFail(OR.Receive_firstPONum, 5))
		{
			waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 10);
			//waitTime(3);
			//waitForElementToDisplay(OR.Receive_firstPONum,10);
			clickOn(OR.Receive_firstPONum);
			waitForElement(OR.Receive_firstPONum);
			clickOn(OR.Receive_DrillDownPODetailPage);
			waitForElementToDisplay(OR.Receive_PrintPOLinkPoDetail, 20);
			clickOn(OR.Receive_PrintPOLinkPoDetail);
			waitForElementToDisplay(OR.Receive_PrintPOText, 10);		
			verifyElementText(OR.Receive_PrintPOText, " Print PO");
			clickOn(OR.Receive_PrintPReviewclose);
		}
		else
		{
			testLogFail("No PO in receive module");
		}

	}

	@Test
	public void Tc_RECDET_07() 
	{
		testStarts("Tc_RECDET_07()", "Verify that �Print Window� appears on clicking Print button..");
		NavigateUrl(DashBoardURL);	
		System.out.println("Tc_RECDET_07");
		ReceivePageObject.pageLinkandwait();
		//ReceivePageObject.selectByDefaultFacility();
		ReceivePageObject.shopFacility();
		waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 3);
		if(isElementDisplayedwithoutFail(OR.Receive_firstPONum, 5))
		{
			waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 10);
			clickOn(OR.Receive_firstPONum);
			waitForElement(OR.Receive_DrillDownPODetailPage);
			clickOn(OR.Receive_DrillDownPODetailPage);
			waitForElementToDisplay(OR.Receive_printItemsDetailPage, 20);
			clickOn(OR.Receive_printItemsDetailPage);
			waitForElement(OR.Receive_printPOText);
			verifyElementText(OR.Receive_printPOText, "Order Items");
			clickOn(OR.Receive_PrintCloseclose);
		}
		else
		{
			testLogFail("No PO in receive module");
		}

	}

	@Test
	public void Tc_RECDET_08() 
	{
		testStarts("Tc_RECDET_08()", "Verify that user gets redirected to �INVOICE FOR PO #� page, on clicking �Add Invoice� option.");
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_RECDET_08");
		ReceivePageObject.pageLinkandwait();
		//ReceivePageObject.selectByDefaultFacility();
		ReceivePageObject.shopFacility();
		waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 3);
		if(isElementDisplayedwithoutFail(OR.Receive_firstPONum, 5))
		{
			waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 10);
			//waitTime(3);
			//waitForElementToDisplay(OR.Receive_firstPONum,10);
			clickOn(OR.Receive_firstPONum);		
			clickOn(OR.Receive_DrillDownPODetailPage);
			WebElement element = driver.findElement(By.xpath("(//a[text()='Invoices'])[1]"));
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			//		waitForElementToDisplay(OR.Receive_PODetailAddInvoice, 60);
			clickOn(OR.Receive_PODetailAddInvoice);
			verifyElementText(OR.Receive_PODetailInvoiceText, "INVOICE FOR PO #:");
		}
		else
		{
			testLogFail("No PO in receive module");
		}
	}
	//Had to use waitTime instead of dynamic
	@Test
	public void Tc_RECDET_09() 
	{
		testStarts("Tc_RECDET_09()", "Verify that �INVOICES FOR PO #� page appears when user clicks on All Invoices option.");
		NavigateUrl(DashBoardURL);	
		System.out.println("Tc_RECDET_09");
		ReceivePageObject.pageLinkandwait();
		//ReceivePageObject.selectByDefaultFacility();
		ReceivePageObject.shopFacility();
		waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 3);
		if(isElementDisplayedwithoutFail(OR.Receive_firstPONum, 5))
		{
			waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 10);
			clickOn(OR.Receive_firstPONum);		
			waitForElement(OR.Receive_DrillDownPODetailPage);
			clickOn(OR.Receive_DrillDownPODetailPage);
			waitTime(3);
			mouseOver(OR.Order_PO_first_invoice);
			clickOn(OR.Receive_AllInvoiceDetailPage);
			String s=getText(OR.Order_PO_first_AllInvoice_Header);
			System.out.println(s);
			if(s.contains("INVOICES FOR PO #"))
			{			
				testLogPass("All Invoices Page is opened");
			}
			else
			{
				testLogPass("All Invoices Page is not opened");			
			}
		}
		else
		{
			testLogFail("No PO in receive module");
		}

	}
	//Had to use waitTime instead of dynamic
	@Test
	public void Tc_RECDET_10() {
		testStarts("Tc_RECDET_10",
				"Verify that �PO AUDIT LOGS FOR PO #� pop up window appears when user clicks on Po Log option in the dropdown.");
		NavigateUrl(DashBoardURL);	
		System.out.println("Tc_RECDET_10");
		ReceivePageObject.pageLinkandwait();
		//ReceivePageObject.selectByDefaultFacility();
		ReceivePageObject.shopFacility();
		waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 3);
		if(isElementDisplayedwithoutFail(OR.Receive_firstPONum, 5))
		{
			waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 10);
			clickOn(OR.Receive_firstPONum);		
			clickOn(OR.Receive_DrillDownPODetailPage);
			waitForElementToDisplay(OR.Receive_POLogDetailPage, 10);
			clickOn(OR.Receive_POLogDetailPage);	
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
	public void Tc_RECDET_11() {
		testStarts("Tc_RECDET_11",
				"Verify that PO APPROVAL LOGS FOR PO# pop up appears when user clicks on PO Approval Log option");
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_RECDET_11");
		ReceivePageObject.pageLinkandwait();
		//ReceivePageObject.selectByDefaultFacility();
		ReceivePageObject.shopFacility();
		waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 3);
		if(isElementDisplayedwithoutFail(OR.Receive_firstPONum, 5))
		{
			waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 10);
			//waitForElementToDisplay(OR.Receive_DrillDownIconwait,20);
			clickOn(OR.Receive_firstPONum);		
			clickOn(OR.Receive_DrillDownPODetailPage);
			waitForElementToDisplay(OR.Receive_POApprovalLogs, 10);
			clickOn(OR.Receive_POApprovalLogs);	
			waitForElementToDisplay(OR.Receive_POApprovalLogsPopUpText,10);
			verifyElementText(OR.Receive_POApprovalLogsPopUpText, "PO APPROVAL LOGS FOR PO #");		
			clickOn(OR.Receive_PrintCloseclose);
		}
		else
		{
			testLogFail("No PO in receive module");
		}
	}

	@Test
	public void Tc_RECDET_12() {
		testStarts("Tc_RECDET_12",
				"Verify that Notes for PO# window appears when user clicks on notes icon with count.");
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_RECDET_12");
		ReceivePageObject.pageLinkandwait();
		//ReceivePageObject.selectByDefaultFacility();
		ReceivePageObject.shopFacility();
		waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 3);
		if(isElementDisplayedwithoutFail(OR.Receive_firstPONum, 5))
		{
			//waitForElementToDisplay(OR.Receive_DrillDownIconwait,20);
			waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 10);
			clickOn(OR.Receive_firstPONum);		
			clickOn(OR.Receive_DrillDownPODetailPage);
			waitForElementToDisplay(OR.Receive_PODetailNotesLinkDrillDown, 10);
			clickOn(OR.Receive_PODetailNotesLinkDrillDown);	
			waitForElementToDisplay(OR.Receive_NotesLinkText, 10);
			verifyElementText(OR.Receive_NotesLinkText, "Notes for PO # ");	
			clickOn(OR.Receive_PrintCloseclose);
		}
		else
		{
			testLogFail("No PO in receive module");
		}
	}

	@Test
	public void Tc_RECDET_13() {
		testStarts("Tc_RECDET_13",
				"Verify that Add Note for PO# pop up appears when user clicks on Add New Note.");
		NavigateUrl(DashBoardURL);	
		System.out.println("Tc_RECDET_13");;	
		ReceivePageObject.pageLinkandwait();	
	//	ReceivePageObject.selectByDefaultFacility();
		ReceivePageObject.shopFacility();
		waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 3);
		if(isElementDisplayedwithoutFail(OR.Receive_firstPONum, 5))
		{
			waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 10);
			//waitForElementToDisplay(OR.Receive_DrillDownIconwait,20);
			clickOn(OR.Receive_firstPONum);		
			clickOn(OR.Receive_DrillDownPODetailPage);
			waitForElementToDisplay(OR.Receive_PODetailNotesLinkDrillDown, 10);
			clickOn(OR.Receive_PODetailNotesLinkDrillDown);	
			waitForElementToDisplay(OR.Receive_NotesLinkText, 10);
			verifyElementText(OR.Receive_NotesLinkText, "Notes for PO # ");
			clickOn(OR.Receive_AddNewNotesLink);
			waitForElementToDisplay(OR.Receive_NotesLinkText, 10);
			verifyElementText(OR.Receive_NotesLinkText, "Add Note for PO # ");		
			clickOn(OR.Receive_PrintCloseclose);
			waitTime(5);
			clickOn(OR.Receive_PrintCloseclose);
		}
		else
		{
			testLogFail("No PO in receive module");
		}

	}


	@Test
	public void Tc_RECDET_14() {
		testStarts("Tc_RECDET_14",
				"Verify that notes gets deleted when user clicks on �Delete� button for the added note.");
		NavigateUrl(DashBoardURL);	
		System.out.println("Tc_RECDET_14");
		ReceivePageObject.pageLinkandwait();
		//ReceivePageObject.selectByDefaultFacility();
		ReceivePageObject.shopFacility();
		waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 3);
		if(isElementDisplayedwithoutFail(OR.Receive_firstPONum, 5))
		{
			waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 10);
			//waitTime(5);
			//waitForElementToDisplay(OR.Receive_DrillDownIconwait,20);
			clickOn(OR.Receive_firstPONum);		
			clickOn(OR.Receive_DrillDownPODetailPage);
			//waitForElementToDisplay(OR.Receive_PODetailNotesLinkDrillDown, 10);
			waitTime(5);
			clickOn(OR.Receive_PODetailNotesLinkDrillDown);	
			//waitForElementToDisplay(OR.Receive_NotesLinkText, 10);
			waitTime(6);
			verifyElementText(OR.Receive_NotesLinkText, "Notes for PO # ");
			clickOn(OR.Receive_AddNewNotesLink);
			waitForElementToDisplay(OR.Receive_NotesLinkText, 10);
			verifyElementText(OR.Receive_NotesLinkText, "Add Note for PO # ");
			String testNote="Note"+ApplicationKeyword.randomAlphaNumeric(3);;
			typeIn(OR.Receive_AddNewNote, testNote);		
			clickOn(OR.Receive_AddNewNoteButton);
			waitTime(6);
			typeIn(OR.Receive_searchBox, testNote);
			//String addedNOte=getText(OR.Receive_searchedfirstNote);
			if(getText(OR.Receive_searchedfirstNote).equalsIgnoreCase(testNote))
			{
				testLogPass("Note is added");
				waitTime(4);
				//getWhenVisible((driver.findElement(By.xpath(//span[@class='pull-right ng-scope']//i[@class='fa fa-trash-o'])[1]), 10);
				//clickWhenReady(elem, 10);
				WebElement elem=driver.findElement(By.xpath("//*[@class='notes-list ng-scope']"));
				WebElement elem2=elem.findElement(By.xpath("//span[@class='pull-right ng-scope']//a[2]/i"));
				elem2.click();
				//clickOn(OR.Receive_NotesDeleteIcon);
				clickOn(OR.Receive_confirmButton);
			}
			else
			{
				testLogFail("Note is not added");
			}
			waitTime(5);
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
	public void Tc_RECDET_15_16() throws InterruptedException
	{
		testStarts("Tc_RECDET_15_16()", "Verify that �PO # XXXX11 Documents� pop up appears when clicks on Documents icon with count +"
				+ "Verify that select file from computer window opens when user clicks on Upload File button.");
		//	Loginpage.OpenBrowserAndLogin();	
		NavigateUrl(DashBoardURL);
		System.out.println("Tc_RECDET_15_16");
		ReceivePageObject.pageLinkandwait();
		//ReceivePageObject.selectByDefaultFacility();
		ReceivePageObject.shopFacility();
		waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 3);
		if(isElementDisplayedwithoutFail(OR.Receive_firstPONum, 5))
		{
			String s=getText(OR.Receive_firstPONum);
			clickOn(OR.Receive_firstPONum);		
			clickOn(OR.Receive_DrillDownPODetailPage);
			waitTime(5);
			//waitForElementToDisplay(OR.Receive_PODocsDrillDown, 10);
			clickOn(OR.Receive_PODocsDrillDown);			
			verifyElementText(OR.Receive_DocsLinkText, "PO # " +s+ " Documents");		
			WebElement elem=driver.findElement(By.xpath("//*[@type='file']"));
			String projectPath = System.getProperty("user.dir");
			elem.sendKeys(projectPath + "/assets/images.jpeg");
			waitTime(5);
			String nameOfFile_Expected="images.jpeg";
			String s2=getText(OR.Invoice_UploadDocName).trim();
			if(s2.contains(nameOfFile_Expected))
			{
				testLogPass("Name of the image uploaded  matched");
				WebElement wholeElem=driver.findElement(By.xpath("//*[@class='col-sm-18']"));
				WebElement trashIcon=wholeElem.findElement(By.xpath("(//a[@class='a-with-icon pull-right ng-scope']/i[@class='fa fa-trash-o'])[1]"));
				trashIcon.click();
				clickOn(OR.Receive_confirmButton);
				waitTime(3);
			}
			else
			{			
				testLogFail("Name of the image uploaded is not matched");			
			}
			clickOn(OR.Receive_PrintCloseclose);
		}
		else
		{
			testLogFail("No PO in receive module");
		}
	}


	@Test
	public void Tc_RECDET_17() {
		testStarts("Tc_RECDET_17",
				"Verify that Mark as Receive only option appears.");
		NavigateUrl(DashBoardURL);	
		System.out.println("Tc_RECDET_17");
		ReceivePageObject.pageLinkandwait();
		//ReceivePageObject.selectByDefaultFacility();
		ReceivePageObject.shopFacility();
		waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 3);
		if(isElementDisplayedwithoutFail(OR.Receive_firstPONum, 5))
		{
			waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 10);
			//waitForElementToDisplay(OR.Receive_DrillDownIconwait,20);
			clickOn(OR.Receive_firstPONum);
			waitForElement(OR.Receive_DrillDownPODetailPage);
			clickOn(OR.Receive_DrillDownPODetailPage);
			//waitForElementToDisplay(OR.Receive_PODetailNotesLinkDrillDown, 10);
			waitForElement(OR.ApprovePO_markAsReceive);			
			String text=getText(OR.ApprovePO_markAsReceive);
			if(text.equalsIgnoreCase("Mark as Non Receive Only") || text.equalsIgnoreCase("Mark as Receive Only"))

			{
				testLogPass("Text is Present");
			}
			else
			{
				testLogFail("Text is not Present");
			}
		}
		else
		{
			testLogFail("No PO in receive module");
		}

	}

	@Test
	public void Tc_RECDET_19() {
		testStarts("Tc_RECDET_18",
				"Verify that show tour pop up appears when user clicks on show tour option in dropdown next to refresh button.");
		NavigateUrl(DashBoardURL);	
		System.out.println("Tc_RECDET_19");
		ReceivePageObject.pageLinkandwait();
		//ReceivePageObject.selectByDefaultFacility();
		ReceivePageObject.shopFacility();
		waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 3);
		if(isElementDisplayedwithoutFail(OR.Receive_firstPONum, 5))
		{
			waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 10);
			//waitForElementToDisplay(OR.Receive_DrillDownIconwait,20);
			clickOn(OR.Receive_firstPONum);	
			//waitTime(3);
			waitForElementToDisplayWithoutFail(OR.Receive_DrillDownPODetailPage, 10);
			clickOn(OR.Receive_DrillDownPODetailPage);
			//waitTime(5);
			waitForElementToDisplayWithoutFail(OR.Receive_ShowTour, 10);
			//waitForElementToDisplay(OR.Receive_PODetailNotesLinkDrillDown, 10);
			clickOn(OR.Receive_ShowTour);
			waitTime(2);

			//String s=getText(OR.Receive_ShowTourText);
			if(isElementPresent(By.xpath("//button[text()='End tour']")))
			{
				testLogPass("Show tour popup is opened.");
			}
			else
			{
				testLogFail("Show tour popup is NOT opened.");
			}
		}
		else
		{
			testLogFail("No PO in receive module");
		}
	}

	@Test
	public void Tc_RECDET_20() {
		testStarts("Tc_RECDET_20",
				"Verify that �Departments� pop up appears when user clicks on Attach department hyperlink.");
		NavigateUrl(DashBoardURL);	
		System.out.println("Tc_RECDET_20");
		ReceivePageObject.pageLinkandwait();
		//ReceivePageObject.selectByDefaultFacility();
		ReceivePageObject.shopFacility();
		waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 3);
		if(isElementDisplayedwithoutFail(OR.Receive_firstPONum, 5))
		{
			waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 10);
			//waitTime(5);
			//waitForElementToDisplay(OR.Receive_DrillDownIconwait,20);
			clickOn(OR.Receive_firstPONum);		
			verifyElementText(OR.Receive_Depatment, "Department:");
		}
		else
		{
			testLogFail("No PO in receive module");
		}
	}

	@Test
	public void Tc_RECDET_21() {
		testStarts("Tc_RECDET_21",
				"Verify that Physicians pop up appears when user clicks on Attach Physician hyperlink.");
		NavigateUrl(DashBoardURL);	
		System.out.println("Tc_RECDET_21");
		ReceivePageObject.pageLinkandwait();
	//	ReceivePageObject.selectByDefaultFacility();
		ReceivePageObject.shopFacility();
		waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 3);
		if(isElementDisplayedwithoutFail(OR.Receive_firstPONum, 5))
		{
			waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 10);
			//waitForElementToDisplay(OR.Receive_DrillDownIconwait,20);
			clickOn(OR.Receive_firstPONum);		
			verifyElementText(OR.Receive_Physician, "Physician:");
		}
		else
		{
			testLogFail("No PO in receive module");
		}
	}

	@Test
	public void Tc_RECDET_22_23() throws InterruptedException 
	{
		testStarts("Tc_RECDET_22_23",
				"Verify that Partial Receive and Complete buttons appear for corresponding PO number whose status is Confirmed/Assigned/Partial Received."
						+ "Verify that Order detail screen gets closed when user clicks on Close option.");
		NavigateUrl(DashBoardURL);	
		System.out.println("Tc_RECDET_22_23");
		ReceivePageObject.pageLinkandwait();
		//ReceivePageObject.selectByDefaultFacility();
		ReceivePageObject.shopFacility();
		waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 3);
		if(isElementDisplayedwithoutFail(OR.Receive_firstPONum, 5))
		{
			waitForElementToDisplayWithoutFail(OR.Receive_firstPONum, 10);
			//waitTime(5);
			//waitForElementToDisplay(OR.Receive_DrillDownIconwait,20);
			clickOn(OR.Receive_firstPONum);
			verifyElementText(OR.Receive_patialButtonText, "Partial Receive");
			verifyElementText(OR.Receive_completeButtonText, "Complete");
			clickOn(OR.Receive_CloseButtonText);
			//waitTime(7);
			waitForElementToDisplayWithoutFail(OR.Receive_DrillDownIcon, 10);
			//waitForElementToDisplayWithoutFail(OR.Receive_OrdersListingPageText,10);
			//waitForElementToDisplay(OR.Receive_SearchTextBox, 10);
			System.out.println(getText(OR.Receive_OrdersListingPageText));
			//verifyElementText(OR.Receive_OrdersListingPageText, "ORDERS TO RECEIVE");
			if(isElementDisplayed(OR.Receive_vendorDropdown, 10))
			{
				testLogPass("User is navigated to Orders receive Listing Page");
			}
			else
			{
				testLogFail("User is not navigated to Orders receive Listing Page");
			}
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
