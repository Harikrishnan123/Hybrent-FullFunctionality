package testcases_functionality;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import funcation_PageObject.*;
import AutomationFramework.ApplicationKeyword;
import AutomationFramework.Generickeywords;
import AutomationFramework.OR;
import funcation_PageObject.Loginpage;

public class TC_Planner extends ApplicationKeyword
{
	public static String fullName;
	
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

			extent = new ExtentReports(folderPath+"/planner.html", true);
			// extent.addSystemInfo("Environment","Environment Name")
			extent.addSystemInfo("User Name", "Ravneet");
			extent.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));

		} catch (Exception e) 
		{
			System.out.println("--Start REPORT-Cases-Error---" + e.toString());
		}
	}

	@Test
	public void Tc_Planner_01() throws InterruptedException
	{
		testStarts("Tc_Planner_01", "Verify that \"PLANNER FOR\" heading appears on top left side of page.");
		Loginpage.OpenBrowserAndLoginnew();
		System.out.println("Tc_Planner_01");
		Planner.plannerPageLinkandwait();
		
		String facility_Name=getText(OR.Patient_getfacilityName);
		clickOn(OR.Planner_createPatient);		
		//verifyElementText(OR.Planner_popUpText, "Create Patient ");
		String firstName="Test1"+randomAlphaNumeric(5);
		setProperty("PlannerFirstName", firstName);
		String lastName="Patient1";		
		typeIn(OR.Patient_firstName, firstName);
		//typeIn(OR.Patient_middleName, "Pat");
		typeIn(OR.Patient_lastName, lastName);
		typeIn(OR.Patient_mrnNumber, "00001");
		typeIn(OR.Patient_accNumber, "465000");
		typeIn(OR.Patient_dob, "11112017");
		clickOn(OR.Patient_facDropDown);
		WebElement elem=driver.findElement(By.xpath("//li[@class='ui-select-choices-group']//span[text()='"+facility_Name+"']"));
		elem.click();
		clickOn(OR.Planner_AddPatient);
		ToastmesssageSucess();
		Planner.patientsPageLinkandwait();
		typeIn(OR.Patient_searchTextBox, firstName+" "+lastName);
		clickOn(OR.Patient_searchbutton);
		waitForElementToDisplayWithoutFail(OR.Patient_firstPatient, 20);
		verifyElement(OR.Patient_firstPatient);
		String patientName=getText(OR.Patient_firstPatient);
		String finalName=patientName.substring(2).trim();
		if(finalName.equals(firstName+" "+lastName))
		{
			testLogPass("New Patient is added");
		}
		else
		{
			testLogFail("New Patient is not added");
		}			
		
				
	}
	
	@Test
	public void Tc_Planner_02()
	{
		testStarts("Tc_Planner_02", "Verify that case can be created by clicking on the calendar vie.");
		System.out.println("Tc_Planner_01");
		NavigateUrl(DashBoardURL);
		Planner.plannerPageLinkandwait();
		clickOn(OR.Planner_datatime630);
		verifyElementText(OR.Planner_createCaseHeading, "Schedule Case -");
	}
	
	@AfterTest
	public void endReport()
	{
		closeBrowser();
		extent.flush();
	}
}
