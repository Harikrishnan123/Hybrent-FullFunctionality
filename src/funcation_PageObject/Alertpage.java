package funcation_PageObject;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework._OR;
import AutomationFramework.OR;

public class Alertpage extends ApplicationKeyword{
    public static void VerifyAlert()
    {
    	waitForElementToDisplay(_OR.Dashboard_Alert_txt_userAlert, 60);
    	verifyElementText(_OR.Dashboard_Alert_txt_userAlert, "USER ALERT");
        verifyElement(_OR.Dashboard_Alert_Btn_cancel);
        verifyElement(_OR.Dashboard_Alert_Btn_Update);
    }
    
    public static void verifywarning()
    {
    	verifyElement(OR.User_alert_preference_warning);
    	verifyElement(OR.User_alert_already_in_PO);
    	verifyElement(OR.User_alert_backorder_warning);
    	verifyElement(OR.User_alert_discount_warning);
    	verifyElement(OR.User_alert_discount_contact_warning);
    }
    public static void verifySucessvalidation()
    {
    	verifyElementText(OR.User_alert_sucessmessage, "Profile updated successfully");
    }

}
