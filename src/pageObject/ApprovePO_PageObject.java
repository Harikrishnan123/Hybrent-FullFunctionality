package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;

public class ApprovePO_PageObject extends ApplicationKeyword{

	public static void Verifydetails()
    {
		waitForElementToDisplay(OR.Order_Myorder_txt, 60);
    	verifyElementText(OR.Order_Myorder_txt, "ORDERS TO APPROVE");
    	verifyElementText(OR.Order_Vendor_txt, "Vendor:");
    	verifyElement(OR.Order_Vendor_dropdown);
    	verifyElementText(OR.Order_type_txt, "Type:");
    	verifyElement(OR.Order_type_dropdown);
    	verifyElementText(OR.Order_depts_txt, "Departments:");
    	verifyElement(OR.Order_depts_dropdown);
    	verifyElementText(OR.Order_facility_txt, "Facility:");
    	verifyElement(OR.Order_facility_dropdown);
    	verifyElementText(OR.Order_creater_txt, "Created By:");
    	verifyElement(OR.Order_creater_dropdown);
    }
	
	public static void shopFacility_ApprovePage()
	{		
		String alreadySelectedFac01=getProperty("userdefaultFac");
		System.out.println(alreadySelectedFac01);
		String alreadySelectedFac=getText(OR.ApprovePO_selectDefaultUser);
		System.out.println(alreadySelectedFac);
		boolean flag=false;
		boolean flaf_02=false;
		if(!alreadySelectedFac.equals(alreadySelectedFac01))
		{
			clickOn(OR.ApprovePO_facilityDropdown);
			WebElement elem=driver.findElement(By.xpath("//*[text()='"+alreadySelectedFac01+"']"));
			elem.click();
			flag=true;
		}	
		waitForElementToDisplayWithoutFail(OR.ApprovePO_selectCreater, 10);
		String alreadySelectedUser=getText(OR.ApprovePO_selectCreater);
		System.out.println(alreadySelectedUser);
		if(!alreadySelectedUser.equals("All"))
		{
			clickOn(OR.ApprovePO_UsersDropdown);
			WebElement elem2=driver.findElement(By.xpath("//*[text()='All']"));
			elem2.click();
			flaf_02=true;
		}
		if(flag||flaf_02)
		{
			clickOn(OR.Receive_searchButton);
		}
	} 
	
}
