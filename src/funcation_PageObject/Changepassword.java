package funcation_PageObject;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework._OR;

public class Changepassword extends ApplicationKeyword {
    
	public static void UserChangepassword()
	{
		verifyElementText(_OR.user_changepassword_Header, "Change Password");
		verifyElementText(_OR.user_changepassword_msg, "You are logging in for the first time please change password to proceed.");
		verifyElementText(_OR.user_changepassword_Label_oldPwd, "Old Password :");
		verifyElementText(_OR.user_changepassword_Label_newPwd, "New Password :");
		verifyElementText(_OR.user_changepassword_Label_confirmPassword, "Confirm Password :");
		 setProperty("updated_NewPassword","gouser1");
		typeIn(_OR.user_changepassword_Input_oldPwd, getProperty("created_NewPassword"));
		typeIn(_OR.user_changepassword_Input_newPwd, getProperty("updated_NewPassword"));
		typeIn(_OR.user_changepassword_Input_confirmPassword, getProperty("updated_NewPassword"));
		clickOn(_OR.user_changepassword_btnChangepassword);
		verifyElement(_OR.user_changepassword_sucesschanged);
		clickOn(_OR.user_changepassword_ok);
		
	}
	
}
