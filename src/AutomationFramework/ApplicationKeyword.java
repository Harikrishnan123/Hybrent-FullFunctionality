package AutomationFramework;

import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import AutomationFramework._OR;
import funcation_PageObject.Loginpage;

public class ApplicationKeyword extends Generickeywords 
{
	public static String facility_Name;
	public static String vendor_Name;	
	public static String firstCategory;
	public static String ItemDescription ;
	public static String ItemMfrNumber;
	public static String ItemTestID ;
	public static String SkuName;
	public static String aliasName;
	public static List<String> depNames_FacPage= null ;
	public static String defFac=getProperty("userdefaultFac");
	public static String npiNum=getProperty("NPI_FOr_Physician");
	public static Properties prop;
	public static String ItemCatName;
	public static String SI;
	public static String PT;
	public static String Days;
	public static String Percentage;
	public static String NewsTitle;
	public static String NewsDesc;
	private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	public static String randomAlphaNumeric(int count) 
	{
	StringBuilder builder = new StringBuilder();
	while (count-- != 0) 
	{
	int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
	builder.append(ALPHA_NUMERIC_STRING.charAt(character));
	}
	return builder.toString();
	}
	
	public static int generateRandomInt(int upperRange)
	{
		int input =100000+upperRange; 
	    Random random = new Random();
	    return random.nextInt(input);
	   
	}
	
	public static int generateRandomInt1(int upperRange)
	{
		int input =upperRange; 
	    Random random = new Random();
	    return random.nextInt(input);
	   
	}
	public static String getTextchild(String xpath)
	{
		waitUntilPageReady();
		WebElement element = driver.findElement(By.xpath(xpath));
		String text = element.getText();
	    	for (WebElement child : element.findElements(By.xpath("./*"))) {
	    		text = text.replaceFirst(child.getText(), "");
	    	}
	    testLogPass("Got the child text ' "+text);
		return text;
	}	
	
	
	public static int getRandomNumberInRange(int min, int max) {
		
		Random r = new Random();
		return r.ints(min, (max + 1)).limit(1).findFirst().getAsInt();
		
	}
	
	public static void verifyPagination()
	{
		verifyElement(OR.Pagination);
	}
	
	public static void Gridview()
	{
		waitTime(2);
		int size = driver.findElements(By.className("grid-item")).size();
		if(size!=0)
		{
			testLogPass("Grid view");
		}
		else
		{
			testLogFail("Its not in Grid View");
		}	
	}
	
	public static void ToastmesssageSucess()
	{ waitUntilPageReady();
		WebElement toast =driver.findElement(By.className("toast-title"));
		if(toast.getText().contains("Success"))
		{
			String one = driver.findElement(By.xpath("//*[@class='toast-message']")).getText();
			testLogPass("Sucess Toast Message "+one);
		}
		else if(toast.getText().contains("Error"))
		{
			String one = driver.findElement(By.xpath("//*[@class='toast-message']")).getText();
			testLogPass("Error Toast Message ' "+one);
		}
		else
		{
			testLogFail("Unable to get toast message");
		}
	}
	
	public static void pagesize()
	{
		waitUntilPageReady();
		int size = driver.findElements(By.xpath("//*[@id='pageSize']/option")).size();
		for(int i =1; i<=size; i++)
		{
			Select s =  new Select(driver.findElement(By.xpath("//*[@id='pageSize']")));
			WebElement option = s.getOptions().get(i);
			String defaultItem = option.getText();
			testLogPass("selected page size is "+defaultItem);
		}
	}
	
	public static String BootstrapgetToolTip(WebElement baseElement, WebElement tooltipElement, WebDriver driver)
	{
		// Actions class object
		Actions action= new Actions(driver);
		// Explicit wait
		WebDriverWait wait= new WebDriverWait(driver,10);
		// Moving mouse cursor to base element to make tooltip visible
		action.moveToElement(baseElement).build().perform();
		// Wait till tooltip is visible/displayed
		WebElement tooltipTextEle=wait.until(ExpectedConditions.visibilityOf(tooltipElement));
		// Get tool tip using getText method
		String toolTip= tooltipTextEle.getText();
		// return tool tip
		return toolTip;
	}

	public static void ProfileUpdateLogmeOut()
	{
		if(isElementDisplayed(OR.ProfileUpdate))
		{
			clickOn(OR.ProfileUpdate_Logmeout);
		}
		Loginpage.newlogin(getProperty("created_NeUser"), getProperty("updated_NewPassword"));
	}
	
	public static void MouseOverToolTip(String objLocator)
	{
		mouseOver(objLocator);
		testLogPass("ToolTip value is "+getAttributeValue(objLocator, "uib-tooltip"));
		
	}
	

	
	public static void OrgSettingChangerelogin()
	{
		waitUntilPageReady();
		verifyElementText(OR.organization_OrgSettingUpdate, "Organization update.");
		getText(OR.organization_OrganizationSettingUpdate_validation);
		clickOn(OR.MyCart_confirmButton);
		verifyElementText(OR.organization_SettingUpdate, "Setting update.");
		getText(OR.organization_SettingUpdate_validation);
		waitUntilPageReady();
		clickOn(OR.organization_SettingUpdate_Logout);
		waitUntilPageReady();
		Loginpage.newlogin(getProperty("created_NeUser"), getProperty("updated_NewPassword"));
	}
}

