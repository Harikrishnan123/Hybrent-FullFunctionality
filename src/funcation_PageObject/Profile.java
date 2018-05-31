package funcation_PageObject;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework._OR;

public class Profile extends ApplicationKeyword{
	 public static void profileverification()
     {
         verifyElementText(_OR.Dashboard_Profile_Label_Name, "Name*");
         verifyElementText(_OR.Dashboard_Profile_Label_Email, "Email*");
         verifyElementText(_OR.Dashboard_Profile_Label_phone, "Phone");
         verifyElementText(_OR.Dashboard_Profile_Label_Photo, "Photo:");
         verifyElementText(_OR.Dashboard_Profile_Label_Facility, "Facility");
         verifyElementText(_OR.Dashboard_Profile_Label_Dept, "Department:");
         verifyElementText(_OR.Dashboard_Profile_Label_Inventory, "Inventory");
         verifyElementText(_OR.Dashboard_Profile_Label_Journeydate, "Joining Date:");
        // verifyElementText(OR.Profile_Label_QuickBook, "Quick Books:");
         verifyPageTitle("User Profile");
     }
	 public static void typeEmail(String Email)
	 {
		 typeIn(_OR.Dashboard_Profile_Input_Email, Email);
	 }
    
}
