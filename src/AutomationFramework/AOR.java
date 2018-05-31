package AutomationFramework;

public class AOR {
	
	// Login Page
	public static String Login_link="LinkLogin#lnktext=Login with Hybrent";
	
	
	
	
	public static String Login_HybrentLogo="HybrentLogo#xpath=//img[@src='images/site-logos/hybrent-light.png']";
	public static String Login_ADFSlink="ADFSlink#xpath=//*[@class='adfslogin-link']/a[contains(text(),'Login with ADFS')]";
	public static String Login_link_LoginHybrent="LoginHybrent#xpath=//a[contains(text(),'Login with Hybrent')]";
	public static String Login_link_LoginHybrents="LoginHybrent#xpath=//a[contains(text(),'Login with Hybrent')]";
	public static String Label_username = "Labelusername#xpath=//*[@for='userName']";
	public static String Label_password = "Labelpassword#xpath=//*[@for='password']";
	public static String Login_Username = "Input_UserName#id=userName";
	public static String Login_Password = "Input_Password#id=password";
	public static String Login_Submit = "LoginBtn#xpath=//*[@type='submit']";
	public static String Login_Error = "Error#xpath=//h2[contains(text(),'Error?')]";
	public static String Login_Validation = "ErrorValidation#xpath=//*[contains(text(),'Invalid user name or password.')]";
	public static String Login_okay = "Errorok#xpath=//*[@class='confirm']";
	public static String Login_copyRight = "CopyRight#xpath=//copyright";
	public static String Login_version = "buildVersion#xpath=//build-version";
	
	
}
