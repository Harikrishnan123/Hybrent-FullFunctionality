package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;

public class OrderPage extends ApplicationKeyword{

	public static void VerifyOrder()
	{
		waitForElementToDisplay(OR.Order_Myorder_txt, 60);
		// 	verifyElementText(OR.Order_Myorder_txt, "ORDERS TO APPROVE");
		verifyElementText(OR.Order_Vendor_txt, "Vendor:");
		verifyElement(OR.Order_Vendor_dropdown);
		verifyElementText(OR.Order_status_txt, "Status:");
		verifyElement(OR.Order_status_dropdown);
		verifyElementText(OR.Order_type_txt, "Type:");
		verifyElement(OR.Order_type_dropdown);
		verifyElementText(OR.Order_facility_txt, "Facility:");
		verifyElement(OR.Order_facility_dropdown);
		verifyElementText(OR.Order_depts_txt, "Departments:");
		verifyElement(OR.Order_depts_dropdown);
		verifyElementText(OR.Order_creater_txt, "Created By:");
		verifyElement(OR.Order_creater_dropdown);
	}

	public static void viewNotesForPO()
	{
		getText(OR.Order_PO_Header);
		clickOn(OR.Order_PO_Notes_AddIcon_btn);
		getText(OR.Order_PO_Notes_HeaderTxt);
		verifyElement(OR.Order_PO_Notes_AddBtn);

	}

	public static void pageLinkandwait()
	{
		clickOn(OR.Order);
		waitForElementToDisplayWithoutFail(OR.Order_wait, 10);
	}

	public static void AddNotes()
	{
		clickOn(OR.Order_PO_Notes_AddIcon_btn);
		getText(OR.Order_PO_Notes_HeaderTxt);
		verifyElement(OR.Order_PO_Notes_AddBtn);
		verifyElement(OR.Order_PO_Notes_CloseBtn);
		getText(OR.Order_PO_Notes_Add_HeaderTxt);
		typeIn(OR.Order_PO_Notes_Input,"TestABCwrererer");
		clickOn(OR.Order_PO_Notes_AddBtn);

	}

	public static void viewDocumentForPO()
	{
		getText(OR.Order_PO_Doc_HeaderTxt);
		verifyElement(OR.Order_PO_Doc_UploadFile);
		verifyElement(OR.Order_PO_Doc_CloseBtn);

	}

	public static void LogPo()
	{
		getText(OR.Order_PO_PoLogHead);

	}
	public static String getFirstPONum()
	{
		String firstPoNum=getText(OR.Order_firstPONUm);		
		typeIn(OR.Order_Search_Input, firstPoNum);
		waitForElementToDisplayWithoutFail(OR.Order_dropDownIcon, 10);	
		return firstPoNum;		
	}

	public static void shopFacility_OrderPage()
	{		
		String alreadySelectedFac01=getProperty("userdefaultFac");
		System.out.println(alreadySelectedFac01);
		String alreadySelectedFac=getText(OR.Order_selectDefaultUser);
		System.out.println(alreadySelectedFac);
//		boolean flag=false;
//		boolean flaf_02=false;
		if(!alreadySelectedFac.equals(alreadySelectedFac01))
		{
			clickOn(OR.ApprovePO_facilityDropdown);
			WebElement elem=driver.findElement(By.xpath("//*[text()='"+alreadySelectedFac01+"']"));
			elem.click();
			//flag=true;
		}	
		waitForElementToDisplayWithoutFail(OR.Order_selectCreater, 10);
		String alreadySelectedUser=getText(OR.Order_selectCreater);
		System.out.println(alreadySelectedUser);
		if(!alreadySelectedUser.equals("All"))
		{
			clickOn(OR.Order_UsersDropdown);
			WebElement elem2=driver.findElement(By.xpath("//*[text()='All']"));
			elem2.click();
			//flaf_02=true;
		}
//		if(flag||flaf_02)
//		{
			clickOn(OR.Order_SearrchBtn);
//		}
	} 


}

