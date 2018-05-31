package pageObject;

import org.openqa.selenium.By;

import com.paulhammant.ngwebdriver.ByAngular;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;
import AutomationFramework._OR;

public class Loginpage  extends ApplicationKeyword{
	public static String UserName = "admin";
	public static String Password = "goouser";
	public static String URL = "https://qa4.test.hybrent.com/b/";
	public static String Invalid_Username ="Test";
	public static String Invalid_Password ="Test";

	public static void login(String Username, String Password)
	{	

//		if(isElementDisplayed(OR.Login_link, 10))
//		{
//			//waitForElementToDisplay(OR.Login_link, 10);
//			clickOn(OR.Login_link);
//		}
//		else if(isElementDisplayed(OR.Adfs_link, 10))
//		{
//			clickOn(OR.Adfs_link);
//		}
//		else
//		{
//			waitForElementToDisplay(OR.Label_username,20);
//			//verifyElementText(OR.Label_password, "Password:");
//
//		}
		//         waitForElementToDisplay(OR.Label_username, 20);
		//         verifyPageTitle("Login");
		//         verifyElement(OR.HeaderLogo);
		//         verifyElementText(OR.Label_username, "User Name:");
		//         verifyElementText(OR.Label_password, "Password:");
		typeIn(_OR.Login_Username, Username);
		typeIn(OR.Login_Password, Password);
		Passwordmaskcheck();
		clickOn(OR.Login_Submit);
		verifyPageTitle("Dashboard");
	}

	public static void OpenBrowserAndLogin()
	{
		openBrowser(URL);		 
		Loginpage.login(UserName, Password);
		waitForElementToDisplay(OR.Shop_Menu, 60);

	}
	public static void allPermissions()
	{
		clickOn(OR.User);
		waitForElementToDisplay(OR.User_Profile, 60);
		clickOn(OR.User_Profile);
		String facNAme=getText(OR.Profile_defaultFacility); 
		String userEmail=getAttributeValue(OR.Profile_userEmail, "value");
		clickOn(OR.DashBoard_AdminDropdown);
		clickOn(OR.Users_page);
		typeIn(OR.Users_SearchByText, userEmail);
		clickOn(OR.Users_SearchButton);
		waitForElementToDisplay(OR.Users_waitforResult, 10);
		clickOn(OR.Users_EditUserButton);
		waitForElementToDisplay(OR.Users_EditUserPopupText, 10);
		clickOn(OR.Users_facilityTab);
		typeIn(OR.Users_searchTextBoxFacTab, facNAme);
		clickOn(OR.Users_AllPermissionsCheckBox);
		clickOn(OR.Users_AllPermissionsCheckBox);
		clickOn(OR.Users_saveButton);
		//handling Logout Popup



	}
	public static void ADFS_link()
	{	
		verifyElement(_OR.Login_ADFSlink);
		verifyElement(_OR.Login_link_LoginHybrent);
		verifyElementText(_OR.Login_link_LoginHybrent, "Login with Hybrent");
		clickOn(_OR.Login_link_LoginHybrent);
	}

	public static void verify_LoginLabel()
	{
		verifyElementText(_OR.Label_username, "User Name:");
		verifyElementText(_OR.Label_password, "Password:");
	}
	
	public static void tooltipUsername()
	{
		getAttributeValue(_OR.Label_username, "uib-tooltip");
	}
	
	public static void Passwordmaskcheck()
	{
		if(Password.contains(getAttributeValue(_OR.Login_Password, "type")))
		{
			testLogPass("Password is masked");
		}
		else
		{
			testLogFail("Password is Not masked");
		}
	}	
	
	public static void rightAdflink()
	{
		verifyElement(_OR.Login_link_LoginADFS_Right);
	}
	
	public static void copyRight()
	{
		verifyElement(_OR.Login_copyRight);
		getText(_OR.Login_version);
		getText(_OR.Login_copyRight);
	}
	
	public static void validationMessage()
	{
		verifyElementText(_OR.Login_Error, "Error?");
		verifyElementText(_OR.Login_Validation, "Invalid user name or password.");
		clickOn(_OR.Login_okay);
	}
}
