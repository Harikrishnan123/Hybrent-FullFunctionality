package funcation_PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;
import AutomationFramework._OR;

public class Physicians extends ApplicationKeyword{
	
    public static void VerifyPhysicians()
    {
    	waitForElement(OR.Physicians_searchBy, 60);
    	verifyElement(OR.Physicians_Name);
    	verifyElement(OR.Physicians_NPINumber);
    	verifyElement(OR.Physicians_Facilities);
    	verifyElement(OR.Physicians_Delete_first);
    	verifyElement(OR.Physicians_Edit_first);
    	verifyElement(OR.Physicians_Addbtn);
    	
    	
    }
    
    public static void NavigatetoPhysicians()
    {
    	clickOn(_OR.DashBoard_Admin);
    	waitForElementToDisplay(_OR.DashBoard_Admin_physicians, 60);
    	clickOn(_OR.DashBoard_Admin_physicians);
    	String one =getTextchild("//*[@class='pagehead']");
    	if(one.contains("MANAGE PHYSICIANS"))
    	{
    		testLogPass("Manage Physicians is present ");
    	}
    	else
    	{
    		testLogFail("Manage Physicians is Not present ");
    	}
    }
    
    public static void AddPhysician()
    {
    	clickOn(OR.Physicians_Addbtn);
    	verifyElement(OR.Template_Schedule_Savebtn);
    	verifyElement(OR.Template_CloseBtn);
    	verifyElement(OR.Physicians_Label_last_name);
    	verifyElement(OR.Physicians_Label_mrn_number);
    	verifyElement(OR.Physicians_Label_Facility);
    	
    	String FirstName = "First"+randomAlphaNumeric(5);
    	String LastName = "Last"+randomAlphaNumeric(5);
    	int NIPNumber = getRandomNumberInRange(10, 1000);
    	String s = Integer.toString(NIPNumber);
    	typeIn(OR.Physicians_FirstName, FirstName);
    	typeIn(OR.Physicians_last_name, LastName);
    	typeIn(OR.Physicians_mrn_number, s);
    	clickOn(OR.Physicians_Facility_ItemList);
    	
    	for(int i=1;i<=5;i++)
    	{
    		if(driver.findElements(By.xpath("(//button[@ng-click='selectItem(item.name,item.id)'])["+i+"]")).size()!=0)
    		{
    			driver.findElement(By.xpath("(//button[@ng-click='selectItem(item.name,item.id)'])["+i+"]")).click();	
    		}
    		
    	}
    	clickOn(OR.Template_Schedule_Savebtn);
    	SearchPhysician(FirstName);
    	EdtPhysic();
    }
    
    public static void SearchPhysician(String SerachInput)
    {
    	typeIn(OR.Phy_SearchTextBox, SerachInput);
    	clickOn(OR.manage_searchButton);
    }
    
    public static void EdtPhysic()
    {
    	clickOn(OR.Physicians_Edit);
    	verifyElement(OR.Template_Schedule_Savebtn);
    	verifyElement(OR.Template_CloseBtn);
    	verifyElement(OR.Physicians_Label_last_name);
    	verifyElement(OR.Physicians_Label_mrn_number);
    	verifyElement(OR.Physicians_Label_Facility);
    	verifyElementText(OR.Physicians_EditTitle, "Edit Physician");
    	clickOn(OR.HeaderClose);
    }
    
}

