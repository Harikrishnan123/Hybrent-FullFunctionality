package pageObject;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;
import AutomationFramework._OR;

public class Changepasswordpage extends ApplicationKeyword {
    public static void VerifyChangePassword()
    {
    	verifyElement(OR.Cpwd__Header);
        verifyElement(OR.Cpwd_btn_submit);
        verifyElement(OR.Cpwd_txt_changepassword);
        verifyElement(OR.Cpwd_txt_confirmpassword);
        verifyElement(OR.Cpwd_txt_oldpassword);
        verifyElement(OR.Cpwd_txt_newpassword);
        clickOn(_OR.HeaderClose);
    }
    
    public static void changePassword() 
    {
    	String Password = "goouser3";
    	String oldPassword = getProperty("updated_NewPassword");
    	typeIn(OR.changepassword_Input_oldPwd, oldPassword);
    	typeIn(OR.changepassword_Input_newPwd, Password);
    	typeIn(OR.changepassword_Input_confirmPassword, Password);
    	clickOn(OR.Cpwd_btn_submit);
    	verifyElementText(OR.Cpwd_sucesschanged, "Your password is updated successfully.");
    	clickOn(OR.Cpwd_okay);
    	setProperty("updated_NewPassword", Password);
    }
}

