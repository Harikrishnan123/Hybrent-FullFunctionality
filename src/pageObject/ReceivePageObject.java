package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;

public class ReceivePageObject extends ApplicationKeyword {

	public static void pageLinkandwait()
	{
		waitForElement(OR.Receive_pageLink);
		clickOn(OR.Receive_pageLink);
		waitForElementToDisplayWithoutFail(OR.Receive_wait, 10);
	}

	public static void selectByDefaultFacility()
	{
		clickOn(OR.User);
		waitForElementToDisplayWithoutFail(OR.User_Profile, 60);
		clickOn(OR.User_Profile);
		String facNAme=getText(OR.Profile_defaultFacility);
		setProperty("userFac_Profile",facNAme);
		pageLinkandwait();
		String alreadySelectedFac=getText(OR.Receive_selectedFacInDropDown);
		boolean flag=false;
		boolean flaf_02=false;
		if(!alreadySelectedFac.equals(facNAme))
		{
			clickOn(OR.Receive_facilityDropdown);
			WebElement elem=driver.findElement(By.xpath("//*[text()='"+facNAme+"']"));
			elem.click();
			flag=true;
		}						
		String alreadySelectedUser=getText(OR.Receive_selectedUserInDropDown);
		if(!alreadySelectedUser.equals("All"))
		{
			clickOn(OR.Receive_UsersDropdown);
			WebElement elem2=driver.findElement(By.xpath("//*[text()='All']"));
			elem2.click();
			flaf_02=true;
		}
		if(flag||flaf_02)
		{
			clickOn(OR.Receive_searchButton);
		}
	} 
	
	
	public static void shopFacility()
	{
		String fac=getProperty("userdefaultFac");
		waitForElementToDisplayWithoutFail(OR.Invoice_Receive_selectedFacInDropDown, 10);
		String alreadySelectedFac=getText(OR.Invoice_Receive_selectedFacInDropDown);
		System.out.println(alreadySelectedFac);
		boolean flag=false;
		boolean flaf_02=false;
		if(!alreadySelectedFac.equals(fac))
		{
			clickOn(OR.Invoice_Receive_selectedFacInDropDown);
			waitTime(1);
			WebElement elem=driver.findElement(By.xpath("//*[text()='"+fac+"']"));
			elem.click();
			flag=true;
		}						
		String alreadySelectedUser=getText(OR.Order_UsersDropdown1);
		System.out.println(alreadySelectedUser);
		if(!alreadySelectedUser.equals("All"))
		{
			clickOn(OR.Receive_UsersDropdown);
			waitTime(1);
			WebElement elem2=driver.findElement(By.xpath("//*[@name='ddlOrderby']//*[text()='All']"));
			elem2.click();
			flaf_02=true;
		}
		if(flag||flaf_02)
		{
			clickOn(OR.Receive_searchButton);
		}
	} 
	
	public static void InvoiceshopFacility()
	{
		String fac=getProperty("userdefaultFac");
		waitForElementToDisplayWithoutFail(OR.Invoice_Receive_selectedFacInDropDown, 10);
		String alreadySelectedFac=getText(OR.Invoice_Receive_selectedFacInDropDown);
		System.out.println(alreadySelectedFac);
		boolean flag=false;
		boolean flaf_02=false;
		if(!alreadySelectedFac.equals(fac))
		{
			clickOn(OR.Invoice_Receive_selectedFacInDropDown);
			waitTime(1);
			WebElement elem=driver.findElement(By.xpath("//*[text()='"+fac+"']"));
			elem.click();
			flag=true;
		}						
		String alreadySelectedUser=getText(OR.Invoice_UsersDropdown);
		System.out.println(alreadySelectedUser);
		if(!alreadySelectedUser.equals("All"))
		{
			clickOn(OR.Receive_UsersDropdown);
			waitTime(1);
			WebElement elem2=driver.findElement(By.xpath("//*[@name='ddlOrderby']//*[text()='All']"));
			elem2.click();
			flaf_02=true;
		}
		if(flag||flaf_02)
		{
			clickOn(OR.Receive_searchButton);
		}
	} 
	
	

	public static void selectByDefaultUser()
	{
//		String alreadySelectedUser=getText(OR.Invoice_selectedUserInDropDown);
//		System.out.println("text " + alreadySelectedUser);
//		if(!alreadySelectedUser.equals("All"))
//		{
//			System.out.println("ascdffrf");
//			WebElement elem1=driver.findElement(By.xpath("//div[@name='ddlOrderby']"));
//			//WebElement elem1=driver.findElement(By.xpath("//*[@class='panel-body ']//[@class='form-group'][6]"));	
//			elem1.click();
//			waitTime(2);
//			WebElement elem2=elem1.findElement(By.xpath("ul/li/div[3]"));
//			elem2.click();
//			clickOn(OR.Receive_searchButton);
		
		String alreadySelectedUser=getText(OR.Receive_selectedUserInDropDown);
		if(!alreadySelectedUser.equals("All"))
		{
			clickOn(OR.Receive_UsersDropdown);
			WebElement elem2=driver.findElement(By.xpath("//*[text()='All']"));
			elem2.click();
		}
			clickOn(OR.Receive_searchButton);
			
		

	}
}
