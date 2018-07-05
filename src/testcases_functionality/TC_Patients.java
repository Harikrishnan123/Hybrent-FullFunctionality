package testcases_functionality;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import funcation_PageObject.*;
import com.relevantcodes.extentreports.ExtentReports;
import AutomationFramework.ApplicationKeyword;
import AutomationFramework.Generickeywords;
import AutomationFramework.OR;

public class TC_Patients extends ApplicationKeyword
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

			extent = new ExtentReports(folderPath+"/patients.html", true);
			// extent.addSystemInfo("Environment","Environment Name")
			extent.addSystemInfo("User Name", "Ravneet");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}
	
	@Test
	public void Tc_Patients_01()
	{
		testStarts("Tc_Patients_01", "Verify that \"Patients For FACILITY\" heading appears on top of page.");
		Loginpage.OpenBrowserAndLoginnew();		
		System.out.println("Tc_Patients_01_02");
		Planner.patientsPageLinkandwait();
		Planner.verifyPage();
		Planner.selectFacility();
		Planner.addPaitent();
		Planner.tablevalues();
		Planner.EditPaitent();
		Planner.Delete();
		Planner.tablevalues();
	}

	@Test
	public void Tc_Patients_03()
	{
		testStarts("Tc_Patients_03", "Verify that "+" (expand) button appears on left of patient name.");
	    NavigateUrl(DashBoardURL);	
	    System.out.println("Tc_Patients_03");
	    Planner.patientsPageLinkandwait();	
	//	waitTime(5);
		waitForElementToDisplayWithoutFail(OR.Patient_plusIcon, 10);
		String s=getText(OR.Patient_plusIcon);
		if(s.equals("+"))
		{
			testLogPass("Drill Down is present");
		}
		else
		{
			testLogFail("Drill Down is not present");

		}
		

	}
//	@Test
//	public void Tc_Patients_04()
//	{
//		testStarts("Tc_Patients_04", "Drill-down > Verify that all preference cards applied for corresponding patient appear on page.");
//	NavigateUrl(DashBoardURL);		
//		//PrefcardPageObject.patientsPageLinkandwait();	
//		//String pateintName=getText(OR.Patient_firstPatient);
//		PrefcardPageObject.casesPageLinkandwait();
//		selectFromDropdown(OR.Cases_SelectDateDropDown, "-- All Dates --");
//		clickOn(OR.Cases_SearchButton);
//		waitForElementToDisplay(OR.Case_firstPatient, 10);	
//		String patientName=getText(OR.Case_firstPatient);
//		typeIn(OR.Cases_searchTextBox,patientName);	
//		clickOn(OR.Cases_SearchButton);
//		waitForElementToDisplay(OR.Case_firstPatient, 10);	
//		//String xpath="//*[@class='table table-bordered']";
//		List<WebElement> allCasessize=driver.findElements(By.xpath("//*[@class='table table-bordered']"));
//		//System.out.println(driver.findElement(By.xpath("//*[@class='table table-bordered']//tbody/tr[1]/td[2]")).getText());
//		List<String> textList=new ArrayList<String>();
//		//List<WebElement> cases=new ArrayList<WebElement>();		
//		for(int i=1; i<=allCasessize.size(); i++)
//		{			
//			//textList.add(allCasessize.get(i-1).findElement(By.xpath("//tbody/tr["+i+"]/td[2]")).getText());			
//			//textList.add(cases.getText());					
//			textList.add(driver.findElement(By.xpath("//table[@class='table table-bordered']["+i+"]//tbody/tr/td[2]")).getText());
//			System.out.println("Text -- " + textList.get(i-1));
//		
//		}
//		
//	}

	@Test
	public void Tc_Patients_05()
	{
		testStarts("Tc_Patients_07", "Drill-down > Verify that edit case page opens when user clicks Edit button.");
		NavigateUrl(DashBoardURL);	
		  System.out.println("Tc_Patients_05");
		  Planner.patientsPageLinkandwait();
		clickOn(OR.Patient_EditPAtient);
		verifyElementText(OR.Patient_EditPAtientPopUp, "Edit Patient ");
		clickOn(OR.Patient_EditPAtientPopUpCancel);
	}


	//May fail in case there is no case attached to first Patient
	@Test
	public void Tc_Patients_07()
	{
		testStarts("Tc_Patients_07", "Drill-down > Verify that case preview opens when user clicks Print case button..");
		NavigateUrl(DashBoardURL);	
		System.out.println("Tc_Patients_07");
		Planner.patientsPageLinkandwait();
		//waitTime(5);
		waitForElementToDisplayWithoutFail(OR.Patient_plusIcon, 10);
		clickOn(OR.Patient_plusIcon);
		clickOn(OR.Patient_PrintIcon);
		verifyElementText(OR.Patient_previewpopup, "Download case");
		clickOn(OR.Patient_ClosePreview);
		
	}

	@Test
	public void Tc_Patients_08_09() throws InterruptedException
	{			
		testStarts("Tc_Patients_08_09", "Verify that user is able to add new patient by clicking 'Add Patient' button.+ "
				+ "Create Patient > Verify that First Name, Last Name, MRN Number, Account Number, DOB, Facility and Is Self Pay are mandatory fields.");
		NavigateUrl(DashBoardURL);	
		System.out.println("Tc_Patients_08_09");
		Planner.patientsPageLinkandwait();

//		clickOn(OR.Patient_EditPAtientPopUpCancel);
	}

	@Test
	public void Tc_Patients_10()
	{			
		testStarts("Tc_Patients_10", "Edit Patient > Verify that all fields are editable.");
		NavigateUrl(DashBoardURL);	
		System.out.println("Tc_Patients_10");
		Planner.patientsPageLinkandwait();			
		//typeIn(OR.Patient_searchTextBox, Test+"Patient);
		//clickOn(OR.Patient_searchbutton);
		waitForElementToDisplayWithoutFail(OR.Patient_firstPatient, 10);
		clickOn(OR.Patient_EditPAtient);

		List<String> xpaths = new ArrayList<String>( 
				Arrays.asList
				(
						OR.Patient_middleName,OR.Patient_lastName,OR.Patient_mrnNumber,
						OR.Patient_accNumber, OR.Patient_dob, OR.Patient_add01,
						OR.Patient_add02, OR.Patient_city, OR.Patient_state, 
						OR.Patient_zip, OR.Patient_Phone, OR.Patient_secphone, 
						OR.Patient_DOS
						));

		for(String xpath:xpaths)
		{
			if(getAttributeValue(xpath, "disabled") == null)
			{
				testLogPass("Value of " + xpath + " is null.");
			}
			else
			{
				testLogFail("Value of " + xpath + " is not null.");
			}
		}
		clickOn(OR.Patient_EditPAtientPopUpCancel);
		
	}
	
	
	@Test
	public void Tc_Patients_11()
	{			
		testStarts("Tc_Patients_11", "Verify that �Apply Preference Card To� pop up appears when user clicks on Apply Preference Card icon.");
		NavigateUrl(DashBoardURL);	
		System.out.println("Tc_Patients_11");
		Planner.patientsPageLinkandwait();			
		waitForElementToDisplayWithoutFail(OR.Patient_firstPatient, 10);
		clickOn(OR.Patient_Addprefcard);
		//System.out.println(getText(OR.Patient_AddprefcardPopUpText));
		verifyElementText(OR.Patient_AddprefcardPopUpText, " Apply Preference Card To");
		
	}
	@AfterTest
	public void endReport()
	{
		closeBrowser();
		extent.flush();
	}




}
