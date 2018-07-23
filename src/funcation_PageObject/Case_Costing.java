package funcation_PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework._OR;
import AutomationFramework.OR;

public class Case_Costing extends ApplicationKeyword{
   

	public static void navigateReport()
	{	 
		waitUntilPageReady();
		JavascriptExecutor je = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//a[@href='#/reports/activity-report']"));
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		clickOn(OR.Report);
	}
	
	public static void navigatecaseCosting()
	{
		waitForElement(OR.Report_ViewMoreREports);
		clickOn(OR.Report_ViewMoreREports);
		waitForElement(OR.Report_ViewMoreREports_CaseCosting);
		clickOn(OR.Report_ViewMoreREports_CaseCosting);
	}
	
	public static void verifyPage()
	{
		testLogPass("header title is "+getText(OR.AppPage_headerText));
		verifyElement(OR.Report_cpt_code);
		verifyElement(OR.Report_SelectProcedure);
		verifyElement(OR.Report_Procedures);
		verifyElement(OR.Report_Physicians);
		verifyElement(OR.Report_From_procedure);
		verifyElement(OR.Report_To_procedure);
		verifyElement(OR.Report_SearchBtn);
		verifyElement(OR.Report_ExcelReport);
		verifyElement(OR.Report_Selection_cpt_code);
		verifyElement(OR.Report_Selection_SelectProcedure);
		verifyCheckBoxIsChecked(OR.Report_Selection_SelectProcedure);
	}
	
	public static void verifyProcedure()
	{
		verifyElement(OR.Report_ProceduresSort);
		verifyElement(OR.Scanout_plus);
		clickOn(OR.Scanout_plus);
		verifyElement(OR.Report_Search);
		int size = driver.findElements(By.xpath("//*[@class='child-table']//th")).size();
		for(int i=1;i<=size;i++)
		{
		String one = driver.findElement(By.xpath("(//*[@class='child-table']//th)["+i+"]")).getText();
		if(one.isEmpty())
		{
			
		}
		else
		{
			testLogPass(one);
		}
		}
		int size1 = driver.findElements(By.xpath("(//*[starts-with(@ng-repeat,'prefCard')]//td[2])")).size();
		for(int j=1;j<=size1;j++)
		{
		String one1 = driver.findElement(By.xpath("(//*[starts-with(@ng-repeat,'prefCard')]//td[2])["+j+"]")).getText();
		if(one1.isEmpty())
		{
			
		}
		else
		{
			testLogPass("Paitent Name is "+one1);
		}
		}
		
		verifyElement(OR.Scanout_Minus);
	}
	
	public static void SearchPaitent()
	{
		waitForElement(OR.Report_Search);
		mouseOver(OR.Report_Search);
		clickOn(OR.Report_Search);
		verifyElementText(OR.Report_Seach_PreferedcardDetails, "Preference Card Details");
		
		int size1 = driver.findElements(By.xpath("//*[text()='Preference Card Details']/following-sibling::div//label")).size();
		for(int j=1;j<=size1;j++)
		{
		String Label = driver.findElement(By.xpath("(//*[text()='Preference Card Details']/following-sibling::div//label)["+j+"]")).getText();
		String Value = driver.findElement(By.xpath("(//*[text()='Preference Card Details']/following-sibling::div//p)["+j+"]")).getText();
			testLogPass(Label+ " - "+Value);
		
		}
		clickOn(OR.MyCart_PrintCloseclose);
		verifyPagination();
	}
	
	public static void AddProcedure()
	{
		waitForElement(OR.Report_Add_procedure_Show);
		clickOn(OR.Report_Add_procedure_Show);
		verifyElement(OR.Report_Add_procedure_plus);
		clickOn(OR.Report_Add_procedure_plus);
		waitUntilPageReady();
		if(driver.findElements(By.xpath("//*[contains(text(),'Add Procedures to Existing List')]")).size()!=0)
		{
		verifyElementText(OR.Report_Add_procedure_Header, "Add Procedures to Existing List");
		clickOn(OR.Report_Add_procedure_plus);
		verifyElement(OR.PriceTire_btnAdd);
		
		verifyElementText(OR.Report_ExitingAdd_Procedures, "Procedures");
		verifyElement(OR.Report_Add_procedure_Show);
		
		clickOn(OR.MyCart_PrintCloseclose);
		}
		waitUntilPageReady();
		if(driver.findElements(By.xpath("//*[contains(text(),'Add Procedures to Existing List')]")).size()!=0)
		{
		verifyElementText(OR.Report_Add_procedure_Header, "Add Procedures to Existing List");
		clickOn(OR.Report_Add_procedure_plus);
		clickOn(OR.PriceTire_btnAdd);
		}
	}
	
	public static void AddPhyscian()
	{
		verifyElement(OR.Report_PhysiciansRemove);
		clickOn(OR.Report_PhysiciansRemove);
		waitTime(4);
		if(driver.findElements(By.xpath("//*[@ng-click=\"addBackToList('removedPhysicianList', 'Physicians')\"]")).size()!=0)
		{
			waitForElement(OR.Report_add_Physician);
			clickOn(OR.Report_add_Physician);
			verifyElementText(OR.Report_add_PhysicianHeader, "Add Physicians to Existing List");
			verifyElementText(OR.Report_add_Physician_HeaderPhysicians, "Physicians");
			if(driver.findElements(By.xpath("//*[@ng-click=\"addBackToList('removedPhysicianList', 'Physicians')\"]")).size()!=0)
			{
				waitTime(2);
				clickOn(OR.Report_add_Physician_AddPhysicians);
				verifyElement(OR.PriceTire_btnAdd);
				verifyElement(OR.Report_ExitingAdd_SearchPhy);
				verifyElement(OR.Report_Add_procedure_Show);
				clickOn(OR.MyCart_PrintCloseclose);
			}
			waitTime(2);
			clickOn(OR.Report_add_Physician);
			waitUntilPageReady();
			verifyElementText(OR.Report_add_PhysicianHeader, "Add Physicians to Existing List");
			if(driver.findElements(By.xpath("//*[@ng-click=\"addBackToList('removedPhysicianList', 'Physicians')\"]")).size()!=0)
			{
				clickOn(OR.Report_add_Physician_AddPhysicians);
				waitUntilPageReady();
				clickOn(OR.PriceTire_btnAdd);
			}
		}
		
	}
	
	public static void ChartProcedure()
	{
		int sie = driver.findElements(By.xpath("//*[@text-anchor='start']")).size();
		for(int i=1;i<=sie;i++)
		{
			String one = driver.findElement(By.xpath("(//*[@text-anchor='start'])["+i+"]")).getText();
			testLogPass(one);
		}
	}
	public static void Header()
	{
		int sie = driver.findElements(By.xpath("//*[@class='tab-pane ng-scope active']//table//th")).size();
		for(int i=1;i<=sie;i++)
		{
			String one = driver.findElement(By.xpath("(//*[@class='tab-pane ng-scope active']//table//th)["+i+"]")).getText();
			
			if(one.isEmpty())
			{
				
			}
			else
			{
				testLogPass("Header is "+one);
			}
		}
	}
	public static void ChartPhy()
	{
			String Phy = driver.findElement(By.xpath("(//tbody//tr/td)[1]")).getText();
			String Phy1 = driver.findElement(By.xpath("(//tbody//tr/td)[2]")).getText();
			testLogPass(Phy+" - "+Phy1);
		
	}
}
