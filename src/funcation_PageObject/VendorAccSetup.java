package funcation_PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;
import AutomationFramework._OR;

public class VendorAccSetup extends ApplicationKeyword {
    
		public static void NavigateToVendorAccSetup()
		{
			clickOn(_OR.DashBoard_Admin);
	    	clickOn(_OR.DashBoard_Admin_vendoraccountsetup);
	    	verifyElement(OR.VendorAccSetup_Pagetitle);
		}
		
		public static void PageVerify()
		{
		
			verifyElementText(OR.VendorAccSetup_SelctVendor, "Select Vendors");
			verifyElement(OR.VendorAccSetup_VendorDropdown);
		}
		public static void SelectVendor()
		{
			String Vname, FName;
			selectFromDropdown(OR.VendorAccSetup_VendorDropdown, 1);
			verifyElement(OR.VendorAccSetup_AccountNumber_First);
			getText(OR.VendorAccSetup_VendorName);
			getText(OR.VendorAccSetup_FacilityName);
			verifyElement(OR.VendorAccSetup_AccountNumber_Radiobtn1);
			verifyElement(OR.VendorAccSetup_AccountNumber_RadioBtn2);
			selectRadioBtn(OR.VendorAccSetup_AccountNumber_Radiobtn1);
			typeIn(OR.VendorAccSetup_AccountNumber_First, "");
			getText(OR.VendorAccSetup_Validation);
			int size = driver.findElements(By.xpath("(//*[text()='Account Number*']/following-sibling::div/input )")).size();
			
			for(int i=1;i<=size;i++)
			{
				WebElement AccType = driver.findElement(By.xpath("(//*[text()='Account Number*']/following-sibling::div/input )["+i+"]"));
				AccType.clear();
				AccType.sendKeys("12");
			}
			mouseOver(OR.VendorAccSetup_Save);
			WebElement element = driver.findElement(By.xpath("//button[text()='Save']"));
			executor.executeScript("arguments[0].click();", element);	
			ToastmesssageSucess();
		}
		
		public static void Department()
		{
			selectRadioBtn(OR.VendorAccSetup_AccountNumber_RadioBtn2);
			verifyElement(OR.VendorAccSetup_DepartmentWise);
			verifyElement(OR.VendorAccSetup_Departments);
			verifyElement(OR.VendorAccSetup_AccountNumber);
			clickOn(OR.VendorAccSetup_Close);
			testLogPass(driver.getTitle());
		}
}
