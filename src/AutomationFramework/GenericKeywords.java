package AutomationFramework;

import Utiliites.Common;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import java.io.File;
import Utiliites.Common.identifierType;
//import jdk.jfr.Timespan;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.WebDriver;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GenericKeywords extends Common
{

	public static ExtentReports extent;
	public static ExtentTest logger;
	public static WebDriver driver;

	public static String identifier;
	public static String locator;
	public static String locatorDescription;
	public static String outputDirectory;
	public static String currentExcelBook;
	public static String mainWindow;
	public static String currentBrowser = "";


	public static Common.identifierType idType;
	public static WebElement webElement;
	public static boolean testFailure = false;
	public static boolean loadFailure = false;
	public static int temp = 1;
	public static String testStatus = "";
	public static int testCaseDataRow;
	public static int testLoadWaitTime = 40;
	public static int elementLoadWaitTime = 30;
	public static int implicitlyWaitTime = 40;
	public static int pageLoadWaitTime = 40;
	public static final ArrayList<String> testCaseNames = new ArrayList();
	public static boolean windowreadyStateStatus = true;


	public static void openBrowser(String URL)
	{
		try
		{
			//System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\Downloads\\Drivers\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", "D:\\Ravneet\\Ravneet\\Selenium\\Downloads\\Drivers\\chromedriver.exe");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);
			driver.navigate().to(URL);
			testLogPass("Open the url "+URL);
			driver.manage().timeouts().implicitlyWait(implicitlyWaitTime,TimeUnit.SECONDS) ;
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			driver.manage().window().maximize();

		}
		catch(Exception e)
		{ 
			testLogFail("Exception " + e.toString());

		}

	}

	public static void identifyBy(String identifier) {
		Common.identifierType i = Common.identifierType.valueOf(identifier);
		switch (i) {
		case classname:
			webElement = driver.findElement(By.className(locator));
			break;
		case id:
			webElement = driver.findElement(By.id(locator));
			break;
		case cssselector:
			webElement = driver.findElement(By.cssSelector(locator));
			break;
		case lnktext:
			webElement = driver.findElement(By.linkText(locator));
			break;
		case name:
			webElement = driver.findElement(By.name(locator));
			break;
		case partiallinktext:
			webElement = driver.findElement(By.partialLinkText(locator));
			break;
		case tagname:
			webElement = driver.findElement(By.tagName(locator));
			break;
		case xpath:
			webElement = driver.findElement(By.xpath(locator));
			break;
		default:

		}
	}

	public static void waitForElement(String objName)
	{
		waitForElement(objName, elementLoadWaitTime);
	}

	public static void waitForElement(String objectName, int timeout) {
		try {
			driver.manage().timeouts().implicitlyWait(0L, TimeUnit.SECONDS);

			for (int i = 1; i <= timeout; i++)
			{
				try
				{
					findWebElement(objectName);
				}
				catch (InvalidSelectorException e)
				{
					waitTime(1L);
				}
				catch (StaleElementReferenceException e)
				{
					waitTime(1L);
				}
				catch (NoSuchElementException e)
				{
					waitTime(1L);
				}
				catch (ElementNotVisibleException e) {
					waitTime(1L);
				}
				catch (UnreachableBrowserException e)
				{

				}
				catch (WebDriverException e) {
					waitTime(1L);
				}

			}
		}
		catch (Exception e)
		{
			testLogFail("Exception " + e.toString());
		}
		finally
		{
			driver.manage().timeouts().implicitlyWait(implicitlyWaitTime, TimeUnit.SECONDS);
		}
	}

	public static void verifyElementText(String objectLocator, String expectedText)
	{

		waitForElementToDisplay(objectLocator, elementLoadWaitTime);
		try 
		{
			if (webElement.getText().trim().contains((expectedText.trim())))
			{
				ApplicationKeyword.testLogInfo("verify if the " + locatorDescription + " element contains text '" + expectedText);
				ApplicationKeyword.testLogPass("verify if the " + locatorDescription + " element contains text '" + expectedText);
			}
			else
			{
				ApplicationKeyword.testLogFail("verify if the " + webElement.getText() + " element contains text '" + expectedText);
			}
		}
		catch (Exception e)
		{
			ApplicationKeyword.testLogFail("Exception Error '" + e.toString() + "'");
		}
	}

	public static void findWebElement(String objectLocator)
	{
		parseidentifyByAndlocator(objectLocator);
		identifyBy(identifier);
	}




	public static void typeIn(String objectLocator, String inputValue)
	{
		waitForElementToDisplay(objectLocator, elementLoadWaitTime);

		{
			try
			{

				webElement.sendKeys(inputValue);
				ApplicationKeyword.testLogPass("Type '" + inputValue + "' in : " + locatorDescription);
			}
			catch (InvalidSelectorException e)
			{
				waitTime(1L);
			}
			catch (StaleElementReferenceException e)
			{
				waitTime(1L);
			}
			catch (ElementNotVisibleException e)
			{
				waitTime(1L);
			}
			catch (UnreachableBrowserException e)
			{
				ApplicationKeyword.testLogFail(e.toString());
			}
			catch (UnhandledAlertException e)
			{
				waitTime(1L);
			}
			catch (WebDriverException e)
			{
				waitTime(1L);
			}
			catch (Exception e)
			{
				ApplicationKeyword.testLogFail("Exception Error '" + e.toString() + "'");
			}
		}
	}

	public static void sendkeys(String Locator, String inputValue)
	{
		try
		{
			driver.findElement(By.xpath(Locator)).clear();
			driver.findElement(By.xpath(Locator)).sendKeys(new CharSequence[] { inputValue });

			ApplicationKeyword.testLogPass(  "Type '" + inputValue + "' in : " + locatorDescription);
		}
		catch (Exception e)
		{

			ApplicationKeyword.testLogFail("Element is not in editable state '" + locatorDescription);
		}
	}

	public static void refreshPage()
	{
		try
		{
			driver.navigate().refresh();
			ApplicationKeyword.testLogPass("Sucessfully Refreshed browser");
		}
		catch (InvalidSelectorException e)
		{
			waitTime(1L);
		}
		catch (StaleElementReferenceException e)
		{
			waitTime(1L);
		}
		catch (ElementNotVisibleException e)
		{
			waitTime(1L);
		}
		catch (UnreachableBrowserException e)
		{
			ApplicationKeyword.testLogFail(e.toString());
		}
		catch (UnhandledAlertException e)
		{
			waitTime(1L);
		}
		catch (WebDriverException e)
		{
			waitTime(1L);
		}
		catch (Exception e)
		{
			ApplicationKeyword.testLogFail("Exception Error '" + e.toString() + "'");
		}

	}

	public static void clickOnBackButton()
	{
		for (int i = 1; i <= elementLoadWaitTime; i++)
		{
			try
			{
				driver.navigate().back();
				ApplicationKeyword.testLogPass("Sucessfully moved to 'Back' page");
			}
			catch (InvalidSelectorException e)
			{
				waitTime(1L);
			}
			catch (StaleElementReferenceException e)
			{
				waitTime(1L);
			}
			catch (ElementNotVisibleException e)
			{
				waitTime(1L);
			}
			catch (UnreachableBrowserException e)
			{
				ApplicationKeyword.testLogFail(e.toString());
			}
			catch (UnhandledAlertException e)
			{
				waitTime(1L);
			}
			catch (WebDriverException e)
			{
				waitTime(1L);
			}
			catch (Exception e)
			{
				ApplicationKeyword.testLogFail("Exception Error '" + e.toString() + "'");
			}
			if (i == elementLoadWaitTime)
			{
				ApplicationKeyword.testLogFail("Error moving to 'Back' page");
			}
		}
	}

	public static void clickOnForwardButton()
	{
		for (int i = 1; i <= elementLoadWaitTime; i++)
		{
			try
			{
				driver.navigate().forward();
				ApplicationKeyword.testLogPass("Sucessfully moved to 'Forward' page");
			}
			catch (InvalidSelectorException e)
			{
				waitTime(1L);
			}
			catch (StaleElementReferenceException e)
			{
				waitTime(1L);
			}
			catch (ElementNotVisibleException e)
			{
				waitTime(1L);
			}
			catch (UnreachableBrowserException e)
			{
				ApplicationKeyword.testLogFail(e.toString());
			}
			catch (UnhandledAlertException e)
			{
				waitTime(1L);
			}
			catch (WebDriverException e)
			{
				waitTime(1L);
			}
			catch (Exception e)
			{
				ApplicationKeyword.testLogFail("Exception Error '" + e.toString() + "'");
			}
			if (i == elementLoadWaitTime)
			{
				ApplicationKeyword.testLogFail("Error moving to 'Forward' page");
			}
		}
	}

	public static void alertOk()
	{
		for (int i = 1; i <= elementLoadWaitTime; i++)
		{
			try
			{
				Alert alert = driver.switchTo().alert();
				alert.accept();

				ApplicationKeyword.testLogPass(  "Click on Alert OK button");
			}
			catch (InvalidSelectorException e)
			{
				waitTime(1L);
			}
			catch (StaleElementReferenceException e)
			{
				waitTime(1L);
			}
			catch (ElementNotVisibleException e)
			{
				waitTime(1L);
			}
			catch (UnreachableBrowserException e)
			{
				ApplicationKeyword.testLogFail(e.toString());
			}
			catch (UnhandledAlertException e)
			{
				waitTime(1L);
			}
			catch (WebDriverException e)
			{
				waitTime(1L);
			}
			catch (Exception e)
			{
				ApplicationKeyword.testLogFail("Exception Error '" + e.toString() + "'");
			}
			if (i == elementLoadWaitTime)
			{
				ApplicationKeyword.testLogFail("Click on Alert OK button");
			}
		}
	}

	public static void alertCancel()
	{
		for (int i = 1; i <= elementLoadWaitTime; i++)
		{
			try
			{
				Alert alert = driver.switchTo().alert();
				alert.dismiss();

				ApplicationKeyword.testLogPass(  "Click on Alert Cancel button");
			}
			catch (InvalidSelectorException e)
			{
				waitTime(1L);
			}
			catch (StaleElementReferenceException e)
			{
				waitTime(1L);
			}
			catch (ElementNotVisibleException e)
			{
				waitTime(1L);
			}
			catch (UnreachableBrowserException e)
			{
				ApplicationKeyword.testLogFail(e.toString());
			}
			catch (UnhandledAlertException e)
			{
				waitTime(1L);
			}
			catch (WebDriverException e)
			{
				waitTime(1L);
			}
			catch (Exception e)
			{
				ApplicationKeyword.testLogFail("Exception Error '" + e.toString() + "'");
			}
			if (i == elementLoadWaitTime)
			{
				ApplicationKeyword.testLogFail("Click on Alert Cancel button");
			}
		}
	}

	public static boolean isAlertWindowPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch (Exception E)
		{
		}
		return false;
	}

	public static void verifyElement(String objLocator)
	{
		waitForElementToDisplay(objLocator, elementLoadWaitTime);

		try
		{

			ApplicationKeyword.testLogPass(  "Verify Element : '" + locatorDescription+"' is present as expected");
		}

		catch (Exception e)
		{
			ApplicationKeyword.testLogFail("Verify Element : " + locatorDescription+ "' is not present as expected");
			ApplicationKeyword.testLogFail("Exception Error '" + e.toString() + "'");
		}


	}

	public static void mouseOver(String objLocator)
	{
		waitForElementToDisplay(objLocator, elementLoadWaitTime);
		for (int i = 1; i <= elementLoadWaitTime; i++)
		{
			try
			{
				Actions builder = new Actions(driver);
				builder.moveToElement(webElement).build().perform();

				ApplicationKeyword.testLogPass(  "Move the mouse over '" + locatorDescription + "'");
				break;
			}
			catch (InvalidSelectorException e)
			{
				waitTime(1L);
			}
			catch (StaleElementReferenceException e)
			{
				waitTime(1L);
			}
			catch (ElementNotVisibleException e)
			{
				waitTime(1L);
			}
			catch (UnreachableBrowserException e)
			{
				ApplicationKeyword.testLogFail(e.toString());
			}
			catch (UnhandledAlertException e)
			{
				waitTime(1L);
			}
			catch (WebDriverException e)
			{
				waitTime(1L);
			}
			catch (Exception e)
			{
				ApplicationKeyword.testLogFail("Exception Error '" + e.toString() + "'");
			}
			if (i == elementLoadWaitTime)
			{
				ApplicationKeyword.testLogFail("Move the mouse over '" + locatorDescription + "'");
			}
		}
	}

	public static void waitTime(long waittime)
	{
		ApplicationKeyword.testLogPass("Waiting for " + waittime + " seconds...");
		try {
			Thread.sleep(waittime * 1000L);
		}
		catch (InterruptedException e)
		{
			ApplicationKeyword.testLogFail( "Thread.sleep operation failed, during waitTime function call");
		}
	}

	public static  void getallFacilities() throws Exception 
	{

		List<String> list = new ArrayList<String>();

		list.add(getText(OR.Shop_SHopfor_allfacilityArray));



	}



	public static void selectFromDropdown(String objLocator, String valueToSelect)
	{
		waitForElementToDisplay(objLocator, elementLoadWaitTime);
		try {
			driver.manage().timeouts().implicitlyWait(0L, TimeUnit.SECONDS);


			try
			{
				webElement.click();
				Select select = new Select(webElement);
				waitTime(5);
				select.selectByVisibleText(valueToSelect);

				ApplicationKeyword.testLogPass(  "Select '" + valueToSelect + "' from : " + locatorDescription);
			}
			catch (InvalidSelectorException e)
			{
				waitTime(1L);
			}
			catch (StaleElementReferenceException e)
			{
				waitTime(1L);
			}
			catch (ElementNotVisibleException e)
			{
				waitTime(1L);
			}
			catch (UnreachableBrowserException e)
			{
				ApplicationKeyword.testLogFail(e.toString());
			}
			catch (UnhandledAlertException e)
			{
				waitTime(1L);
			}
			catch (WebDriverException e)
			{
				waitTime(1L);
			}
			catch (Exception e)
			{
				ApplicationKeyword.testLogFail("Exception Error '" + e.toString() + "'");
			}


		}
		catch (Exception e)
		{
			ApplicationKeyword.testLogFail(e.toString());
		}
		finally
		{
			driver.manage().timeouts().implicitlyWait(implicitlyWaitTime, TimeUnit.SECONDS);
		}
	}

	public static void selectFromDropdown(String objLocator, int indexNumber)
	{
		waitForElementToDisplay(objLocator, elementLoadWaitTime);
		try {
			driver.manage().timeouts().implicitlyWait(0L, TimeUnit.SECONDS);

			for (int i = 1; i <= elementLoadWaitTime; i++)
			{
				try
				{
					webElement.click();
					Select select = new Select(webElement);
					select.selectByIndex(indexNumber);


					ApplicationKeyword.testLogPass(  "Select '" + indexNumber + "' option from : " + locatorDescription);
				}
				catch (InvalidSelectorException e)
				{
					waitTime(1L);
				}
				catch (StaleElementReferenceException e)
				{
					waitTime(1L);
				}
				catch (ElementNotVisibleException e)
				{
					waitTime(1L);
				}
				catch (UnreachableBrowserException e)
				{
					ApplicationKeyword.testLogFail(e.toString());
				}
				catch (UnhandledAlertException e)
				{
					waitTime(1L);
				}
				catch (WebDriverException e)
				{
					waitTime(1L);
				}
				catch (Exception e)
				{
					ApplicationKeyword.testLogFail("Exception Error '" + e.toString() + "'");
				}
				if (i == elementLoadWaitTime)
				{

					ApplicationKeyword.testLogFail("Select '" + indexNumber + "' from : " + locatorDescription);
				}
			}

		}
		catch (Exception e)
		{
			ApplicationKeyword.testLogFail(e.toString());
		}
		finally
		{
			driver.manage().timeouts().implicitlyWait(implicitlyWaitTime, TimeUnit.SECONDS);
		}
	}


	public static void verifyPageTitle(String partialTitle)
	{

		try {
			if (driver.getTitle().contains(partialTitle))
			{

				ApplicationKeyword.testLogPass(  "Verify if the page title contains text '" + partialTitle + "'");
			}
			else
			{

				ApplicationKeyword.testLogFail("Verify if the page title contains text '" + partialTitle + "'");
			}

		}
		catch (InvalidSelectorException e)
		{
			waitTime(1L);
		}
		catch (StaleElementReferenceException e)
		{
			waitTime(1L);
		}
		catch (ElementNotVisibleException e)
		{
			waitTime(1L);
		}
		catch (UnreachableBrowserException e)
		{
			ApplicationKeyword.testLogFail(e.toString());
		}
		catch (UnhandledAlertException e)
		{
			waitTime(1L);
		}
		catch (WebDriverException e)
		{
			waitTime(1L);
		}
		catch (Exception e)
		{
			ApplicationKeyword.testLogFail("Exception Error '" + e.toString() + "'");
		}

	}

	public static void verifyLinkText(String txt)
	{
		try
		{
			driver.findElement(By.linkText(txt));

			ApplicationKeyword.testLogPass(  "Verify if link '" + txt + "' is present");
		}
		catch (Exception e)
		{

			ApplicationKeyword.testLogFail("Verify if link '" + txt + "' is present");
		}
	}

	public static void verifyAttribute(String objLocator, String attributeType, String expectedAttributeValue)
	{
		waitForElement(objLocator, elementLoadWaitTime);
		for (int i = 1; i <= elementLoadWaitTime; i++)
		{
			try {
				String attribute = "";
				attribute = webElement.getAttribute(attributeType);

				if (!attribute.trim().equalsIgnoreCase(expectedAttributeValue.trim()))
				{

					ApplicationKeyword.testLogFail("Verify attribute of '" + attribute + "' for value '" + expectedAttributeValue + "'");
				}
				else
				{		
					ApplicationKeyword.testLogPass(  "Verify attribute of '" + attribute + "' for value '" + expectedAttributeValue + "'");
					break;
				}
			}
			catch (InvalidSelectorException e)
			{
				waitTime(1L);
			}
			catch (StaleElementReferenceException e)
			{
				waitTime(1L);
			}
			catch (ElementNotVisibleException e)
			{
				waitTime(1L);
			}
			catch (UnreachableBrowserException e)
			{
				ApplicationKeyword.testLogFail(e.toString());
			}
			catch (UnhandledAlertException e)
			{
				waitTime(1L);
			}
			catch (WebDriverException e)
			{
				waitTime(1L);
			}
			catch (Exception e)
			{
				ApplicationKeyword.testLogFail("Exception Error '" + e.toString() + "'");
			}

			if (i == elementLoadWaitTime)
			{
				ApplicationKeyword.testLogFail(locatorDescription + " element found but its not in editable/clickable state within " + elementLoadWaitTime + " timeouts");
			}
		}
	}

	public static void waitForText(String txt)
	{
		waitForText(txt, testLoadWaitTime);
	}

	public static void waitForText(String txt, int timeout)
	{
		for (int second = 0; second < timeout; second++)
		{
			try {
				driver.getCurrentUrl();
			} catch (Exception e) {
				ApplicationKeyword.testLogFail("WebDriver is not found");
			}if (second == timeout - 1) {
				ApplicationKeyword.testLogInfo( "Text is not found ' " + txt + "'");
				ApplicationKeyword.testLogFail("Text is not found ' " + txt + "'");
				break;
			}
			try
			{
				if (driver.getPageSource().contains(txt))
					ApplicationKeyword.testLogPass("Text: '" + txt + "' is present");
			}
			catch (Exception localException1)
			{
				try
				{
					Thread.sleep(1000L);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void clickOn(String objLocator)
	{
		waitForElementToDisplay(objLocator, elementLoadWaitTime);

		try
		{	
			webElement.click();
			//System.out.println("Click on :" + locatorDescription);
			ApplicationKeyword.testLogPass(  "Click on :" + locatorDescription);
		}
		catch (InvalidSelectorException e)
		{
			waitTime(1L);
		}
		catch (StaleElementReferenceException e)
		{
			waitTime(1L);
		}
		catch (ElementNotVisibleException e)
		{
			waitTime(1L);
		}
		catch (UnreachableBrowserException e)
		{
			ApplicationKeyword.testLogFail(e.toString());
		}
		catch (UnhandledAlertException e)
		{
			waitTime(1L);
		}
		catch (WebDriverException e)
		{
			waitTime(1L);
		}
		catch (Exception e)
		{
			ApplicationKeyword.testLogFail("Exception Error '" + e.toString() + "'");
		}


	}

	//	public static void clickOn(String objLocator, boolean checkVisibilityInWait)
	//	{
	//		waitForElementToDisplay(objLocator, elementLoadWaitTime, checkVisibilityInWait);
	//
	//		try
	//		{
	//			webElement.click();
	//
	//			ApplicationKeyword.testLogPass(  "Click on :" + locatorDescription);
	//		}
	//		catch (InvalidSelectorException e)
	//		{
	//			waitTime(1L);
	//		}
	//		catch (StaleElementReferenceException e)
	//		{
	//			waitTime(1L);
	//		}
	//		catch (ElementNotVisibleException e)
	//		{
	//			waitTime(1L);
	//		}
	//		catch (UnreachableBrowserException e)
	//		{
	//			ApplicationKeyword.testLogFail(e.toString());
	//		}
	//		catch (UnhandledAlertException e)
	//		{
	//			waitTime(1L);
	//		}
	//		catch (WebDriverException e)
	//		{
	//			waitTime(1L);
	//		}
	//		catch (Exception e)
	//		{
	//			ApplicationKeyword.testLogFail("Exception Error '" + e.toString() + "'");
	//		}
	//
	//
	//	}

	/* public static void switchToWindow(String objTitle)
  {
    try
    {
      Set AllHandle = driver.getWindowHandles();
      for (String han : AllHandle) {
        driver.switchTo().window(han);
        try {
          Thread.sleep(2000L);
        }
        catch (InterruptedException e) {
          e.printStackTrace();
        }
        String getTitle = driver.getTitle();
        if (getTitle.contains(objTitle)) {
          ApplicationKeyword.testLogInfo("Switched to window..." + objTitle);
          ApplicationKeyword.testLogPass(  "Switch to window :" + objTitle);

          break;
        }

      }

    }
    catch (Exception e)
    {
      ApplicationKeyword.testLogInfo( "Error switching to window..." + objTitle);
      ApplicationKeyword.testLogFail("Switch to window :" + objTitle);
    }
  }
	 */
	public static void dragAndDrop(String sourceObjLocator, String destinationObjLocator)
	{
		String sourceDesc = ""; String destinationDesc = "";
		try
		{
			findWebElement(sourceObjLocator);
			WebElement source = webElement;
			sourceDesc = locatorDescription;
			findWebElement(destinationObjLocator);
			WebElement target = webElement;
			destinationDesc = locatorDescription;
			new Actions(driver).dragAndDrop(source, target).perform();
			ApplicationKeyword.testLogInfo("Drag and drop successful");
			ApplicationKeyword.testLogPass(  "Drag '" + sourceDesc + "' and drop on '" + destinationDesc + "'");
		}
		catch (Exception e)
		{
			ApplicationKeyword.testLogInfo( "Error during drag and drop");
			ApplicationKeyword.testLogFail("Drag '" + sourceDesc + "' and drop on '" + destinationDesc + "'");
		}
	}

	public static void switchFrame(String fr)
	{
		waitTime(10);
		try
		{
			driver.switchTo().frame(fr);
			ApplicationKeyword.testLogInfo("Switched to frame :" + fr);
			ApplicationKeyword.testLogPass(  "Switch to frame :" + fr);
		}
		catch (InvalidSelectorException e)
		{
			waitTime(1L);
		}
		catch (StaleElementReferenceException e)
		{
			waitTime(1L);
		}
		catch (ElementNotVisibleException e)
		{
			waitTime(1L);
		}
		catch (UnreachableBrowserException e)
		{
			ApplicationKeyword.testLogFail(e.toString());
		}
		catch (UnhandledAlertException e)
		{
			waitTime(1L);
		}
		catch (WebDriverException e)
		{
			waitTime(1L);
		}
		catch (Exception e)
		{
			ApplicationKeyword.testLogFail("Exception Error '" + e.toString() + "'");
		}
	}

	public static void clearEditBox(String objLocator)
	{
		waitForElementToDisplay(objLocator, elementLoadWaitTime);
		try
		{
			webElement.click();
			webElement.clear();
			ApplicationKeyword.testLogInfo("Clear Text Box '' in : " + locatorDescription);
		}
		catch (InvalidSelectorException e)
		{
			waitTime(1L);
		}
		catch (StaleElementReferenceException e)
		{
			waitTime(1L);
		}
		catch (ElementNotVisibleException e)
		{
			waitTime(1L);
		}
		catch (UnreachableBrowserException e)
		{
			ApplicationKeyword.testLogFail(e.toString());
		}
		catch (UnhandledAlertException e)
		{
			waitTime(1L);
		}
		catch (WebDriverException e)
		{
			waitTime(1L);
		}
		catch (Exception e)
		{
			ApplicationKeyword.testLogFail("Exception Error '" + e.toString() + "'");
		}
	}

	public static void rightClick(String objLocator)
	{
		waitForElementToDisplay(objLocator, elementLoadWaitTime);
		for (int i = 1; i <= elementLoadWaitTime; i++)
		{
			try
			{
				Actions builder = new Actions(driver);
				builder.contextClick(webElement).build().perform();
				ApplicationKeyword.testLogInfo("Successfully right clicked '" + locatorDescription + "'");
				ApplicationKeyword.testLogPass(  "Right Clicked '" + locatorDescription + "'");
			}
			catch (InvalidSelectorException e)
			{
				waitTime(1L);
			}
			catch (StaleElementReferenceException e)
			{
				waitTime(1L);
			}
			catch (ElementNotVisibleException e)
			{
				waitTime(1L);
			}
			catch (UnreachableBrowserException e)
			{
				ApplicationKeyword.testLogFail(e.toString());
			}
			catch (UnhandledAlertException e)
			{
				waitTime(1L);
			}
			catch (WebDriverException e)
			{
				waitTime(1L);
			}
			catch (Exception e)
			{
				ApplicationKeyword.testLogFail("Exception Error '" + e.toString() + "'");
			}

			if (i == elementLoadWaitTime)
			{
				ApplicationKeyword.testLogFail(locatorDescription + " element found but its not in editable/clickable state within " + elementLoadWaitTime + " timeouts");
			}
		}
	}

	public static void doubleClick(String objLocator) {
		waitForElementToDisplay(objLocator, elementLoadWaitTime);
		for (int i = 1; i <= elementLoadWaitTime; i++)
		{
			try
			{
				Actions builder = new Actions(driver);
				builder.doubleClick(webElement).build().perform();
				ApplicationKeyword.testLogInfo("Successfully double clicked '" + locatorDescription + "'");
				ApplicationKeyword.testLogPass(  "Double Clicked '" + locatorDescription + "'");
			}
			catch (InvalidSelectorException e)
			{
				waitTime(1L);
			}
			catch (StaleElementReferenceException e)
			{
				waitTime(1L);
			}
			catch (ElementNotVisibleException e)
			{
				waitTime(1L);
			}
			catch (UnreachableBrowserException e)
			{
				ApplicationKeyword.testLogFail(e.toString());
			}
			catch (UnhandledAlertException e)
			{
				waitTime(1L);
			}
			catch (WebDriverException e)
			{
				waitTime(1L);
			}
			catch (Exception e)
			{
				ApplicationKeyword.testLogFail("Exception Error '" + e.toString() + "'");
			}

			if (i == elementLoadWaitTime)
			{
				ApplicationKeyword.testLogFail(locatorDescription + " element found but its not in editable/clickable state within " + elementLoadWaitTime + " timeouts");
			}
		}
	}

	protected boolean isElementPresent(By by){
		try{
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			driver.findElement(by);
			return true;
		}
		catch(NoSuchElementException e){

		}
		finally
		{
			driver.manage().timeouts().implicitlyWait(implicitlyWaitTime,TimeUnit.SECONDS);
		}

		return false;
	}

	public static boolean elementPresent(String objectLocator)
	{
		try
		{
			findWebElement(objectLocator);
			return true;
		}
		catch (NoSuchElementException e)
		{
			return false;
		}
		catch (Exception e)
		{
			ApplicationKeyword.testLogFail(e.toString());
		}return false;
	}

	public static void verifyPageShouldContainText(String text)
	{
		if (driver.getPageSource().contains(text))
		{
			ApplicationKeyword.testLogInfo("Verify if page '" + text + "' text is present");
			ApplicationKeyword.testLogPass(  "Verify if page '" + text + "' text is present");
		}
		else
		{
			ApplicationKeyword.testLogInfo( text + "' text is not present");
			ApplicationKeyword.testLogFail("Verify if page '" + text + "' text is present");
		}
	}

	public static void verifyPageShouldNotContainText(String text)
	{
		if (driver.getPageSource().contains(text))
		{
			ApplicationKeyword.testLogInfo("'" + text + "' text is present");
			ApplicationKeyword.testLogFail("Verify if page '" + text + "' text is not present");
		}
		else
		{
			ApplicationKeyword.testLogInfo( "Verify if page '" + text + "' text is not present");
			ApplicationKeyword.testLogPass(  "Verify if page '" + text + "' text is not present");
		}
	}
	public static String getTextSelectedOption(String objLocator)
	{
		waitForElementToDisplay(objLocator, elementLoadWaitTime);
		String SelectText = "";
		for (int i = 1; i <= elementLoadWaitTime; i++)
		{
			try {
				Select select = new Select(webElement);
				return select.getFirstSelectedOption().getText().toString();
			}
			catch (InvalidSelectorException e)
			{
				waitTime(1L);
			}
			catch (StaleElementReferenceException e)
			{
				waitTime(1L);
			}
			catch (ElementNotVisibleException e)
			{
				waitTime(1L);
			}
			catch (UnreachableBrowserException e)
			{
				ApplicationKeyword.testLogFail(e.toString());
			}
			catch (UnhandledAlertException e)
			{
				waitTime(1L);
			}
			catch (WebDriverException e)
			{
				waitTime(1L);
			}
			catch (Exception e)
			{
				ApplicationKeyword.testLogFail("Exception Error '" + e.toString() + "'");
			}

			if (i == elementLoadWaitTime)
			{
				ApplicationKeyword.testLogFail(locatorDescription + " element found but its not in editable/clickable state within " + elementLoadWaitTime + " timeouts");
			}
		}

		return SelectText;
	}

	public static void verifyTextFieldCount(String objLocator, int CountNumber)
	{
		waitForElement(objLocator, elementLoadWaitTime);
		for (int i = 1; i <= elementLoadWaitTime; i++)
		{
			try {
				String text = getAttributeValue(objLocator, "value");
				if (text.length() > CountNumber)
				{
					ApplicationKeyword.testLogInfo( locatorDescription + "textfield is getting more than '" + CountNumber + "' value ");
					ApplicationKeyword.testLogFail(locatorDescription + "textfield is getting more than '" + CountNumber + "' value ");
				}
				else
				{
					ApplicationKeyword.testLogInfo("Verify if " + locatorDescription + " textfield is not getting more than '" + CountNumber + "' value");
					ApplicationKeyword.testLogPass(  "Verify if " + locatorDescription + " textfield is not getting more than '" + CountNumber + "' value");
				}

			}
			catch (InvalidSelectorException e)
			{
				waitTime(1L);
			}
			catch (StaleElementReferenceException e)
			{
				waitTime(1L);
			}
			catch (ElementNotVisibleException e)
			{
				waitTime(1L);
			}
			catch (UnreachableBrowserException e)
			{
				ApplicationKeyword.testLogFail(e.toString());
			}
			catch (UnhandledAlertException e)
			{
				waitTime(1L);
			}
			catch (WebDriverException e)
			{
				waitTime(1L);
			}
			catch (Exception e)
			{
				ApplicationKeyword.testLogFail("Exception Error '" + e.toString() + "'");
			}

			if (i == elementLoadWaitTime)
			{
				ApplicationKeyword.testLogFail(locatorDescription + " element found but its not in editable/clickable state within " + elementLoadWaitTime + " timeouts");
			}
		}
	}

	public static void verifyTextValueNotCharacter(String objLocator)
	{
		waitForElement(objLocator, elementLoadWaitTime);
		for (int i = 1; i <= elementLoadWaitTime; i++)
		{
			try {
				String text = getAttributeValue(objLocator, "value");
				if (text.matches("[a-zA-z]+"))
				{
					ApplicationKeyword.testLogInfo(locatorDescription + "textfield is getting character value ");
					ApplicationKeyword.testLogFail(locatorDescription + "textfield is getting character value");
				}
				else
				{
					ApplicationKeyword.testLogInfo( "Verify if " + locatorDescription + " textfield is  getting only number value");
					ApplicationKeyword.testLogPass(  "Verify:" + locatorDescription + " textfield is  getting only number value");
				}

			}
			catch (InvalidSelectorException e)
			{
				waitTime(1L);
			}
			catch (StaleElementReferenceException e)
			{
				waitTime(1L);
			}
			catch (ElementNotVisibleException e)
			{
				waitTime(1L);
			}
			catch (UnreachableBrowserException e)
			{
				ApplicationKeyword.testLogFail(e.toString());
			}
			catch (UnhandledAlertException e)
			{
				waitTime(1L);
			}
			catch (WebDriverException e)
			{
				waitTime(1L);
			}
			catch (Exception e)
			{
				ApplicationKeyword.testLogFail("Exception Error '" + e.toString() + "'");
			}

			if (i == elementLoadWaitTime)
			{
				ApplicationKeyword.testLogFail(locatorDescription + " element found but its not in editable/clickable state within " + elementLoadWaitTime + " timeouts");
			}
		}
	}

	public static void verifyTextValueNotNumber(String objLocator)
	{
		waitForElement(objLocator, elementLoadWaitTime);
		for (int i = 1; i <= elementLoadWaitTime; i++)
		{
			try {
				String text = getAttributeValue(objLocator, "value");
				if (text.matches("[0-9]+"))
				{
					ApplicationKeyword.testLogInfo( locatorDescription + "textfield is getting Number value ");
					ApplicationKeyword.testLogFail(locatorDescription + "textfield is getting Number value ");
				}
				else
				{
					ApplicationKeyword.testLogInfo( "Verify if " + locatorDescription + " textfield is  getting  only character value");
					ApplicationKeyword.testLogPass(  "Verify if " + locatorDescription + " textfield is  getting only character value");
				}

			}
			catch (InvalidSelectorException e)
			{
				waitTime(1L);
			}
			catch (StaleElementReferenceException e)
			{
				waitTime(1L);
			}
			catch (ElementNotVisibleException e)
			{
				waitTime(1L);
			}
			catch (UnreachableBrowserException e)
			{
				ApplicationKeyword.testLogFail(e.toString());
			}
			catch (UnhandledAlertException e)
			{
				waitTime(1L);
			}
			catch (WebDriverException e)
			{
				waitTime(1L);
			}
			catch (Exception e)
			{
				ApplicationKeyword.testLogFail("Exception Error '" + e.toString() + "'");
			}

			if (i == elementLoadWaitTime)
			{
				ApplicationKeyword.testLogFail(locatorDescription + " element found but its not in editable/clickable state within " + elementLoadWaitTime + " timeouts");
			}
		}
	}

	public static void verifyAlertTextShouldContain(String expectedAlertText)
	{
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		if (alertText.contains(expectedAlertText))
		{
			ApplicationKeyword.testLogInfo( "Verify if '" + expectedAlertText + "' alert text is present ");
			ApplicationKeyword.testLogPass(  "Verify if '" + expectedAlertText + "' alert text is present ");
		}
		else
		{
			ApplicationKeyword.testLogInfo( expectedAlertText + "' alert text is not present ");
			ApplicationKeyword.testLogFail("'" + expectedAlertText + "' alert text is not present");
		}
	}

	public static void verifyTextFieldShouldContain(String objectLocator, String expectedValue)
	{
		waitForElement(objectLocator, elementLoadWaitTime);

		for (int i = 1; i <= elementLoadWaitTime; i++)
		{
			try {
				String actualValue = getAttributeValue(objectLocator, "value");
				if (actualValue.contains(expectedValue))
				{
					ApplicationKeyword.testLogInfo("Verify if '" + expectedValue + "' is present in " + locatorDescription + " textfield");
					ApplicationKeyword.testLogPass("Verify if '" + expectedValue + "' is present in " + locatorDescription + " textfield");
				}
				else
				{
					ApplicationKeyword.testLogFail("'" + expectedValue + "' is not present in " + locatorDescription + " textfield");
				}

			}
			catch (InvalidSelectorException e)
			{
				waitTime(1L);
			}
			catch (StaleElementReferenceException e)
			{
				waitTime(1L);
			}
			catch (ElementNotVisibleException e)
			{
				waitTime(1L);
			}
			catch (UnreachableBrowserException e)
			{
				ApplicationKeyword.testLogFail(e.toString());
			}
			catch (UnhandledAlertException e)
			{
				waitTime(1L);
			}
			catch (WebDriverException e)
			{
				waitTime(1L);
			}
			catch (Exception e)
			{
				ApplicationKeyword.testLogFail("Exception Error '" + e.toString() + "'");
			}

			if (i == elementLoadWaitTime)
			{
				ApplicationKeyword.testLogFail(locatorDescription + " element found but its not in editable/clickable state within " + elementLoadWaitTime + " timeouts");
			}
		}
	}

	public static void verifyTextFieldShouldNotContain(String objectLocator, String expectedValue)
	{
		waitForElement(objectLocator, elementLoadWaitTime);
		for (int i = 1; i <= elementLoadWaitTime; i++)
		{
			try
			{
				String textValue = getAttributeValue(objectLocator, "value");
				if (!textValue.contains(expectedValue))
				{
					ApplicationKeyword.testLogInfo("Verify if '" + expectedValue + "' is not present in " + locatorDescription + " textfield");
					ApplicationKeyword.testLogPass(  "Verify if '" + expectedValue + "' is not present in " + locatorDescription + " textfield");
				}
				else
				{
					ApplicationKeyword.testLogInfo( "'" + expectedValue + "' is present in " + locatorDescription + " textfield");
					ApplicationKeyword.testLogFail("'" + expectedValue + "' is present in " + locatorDescription + " textfield");
				}

			}
			catch (InvalidSelectorException e)
			{
				waitTime(1L);
			}
			catch (StaleElementReferenceException e)
			{
				waitTime(1L);
			}
			catch (ElementNotVisibleException e)
			{
				waitTime(1L);
			}
			catch (UnreachableBrowserException e)
			{
				testLogFail(e.toString());
			}
			catch (UnhandledAlertException e)
			{
				waitTime(1L);
			}
			catch (WebDriverException e)
			{
				waitTime(1L);
			}
			catch (Exception e)
			{
				testLogFail("Exception Error '" + e.toString() + "'");
			}

			if (i == elementLoadWaitTime)
			{
				testLogFail(locatorDescription + " element found but its not in editable/clickable state within " + elementLoadWaitTime + " timeouts");
			}
		}
	}

	/*public static void closeAllBrowser()
  {
    deleteAllCookies();
    Set windowhandles = driver.getWindowHandles();
    for (String handle : windowhandles)
    {
      driver.switchTo().window(handle);
      driver.close();
    }
  }*/

	public static void closeChildBrowser(String windowTitle)
	{
		try {
			for (String winHandle : driver.getWindowHandles())
			{
				driver.switchTo().window(winHandle);
				if (driver.getTitle().equalsIgnoreCase(windowTitle))
				{
					driver.close();
					testLogInfo("Browser: Close Successful");
					testLogPass(  "Close Browser");
					break;
				}
			}
		}
		catch (Exception e)
		{
			testLogInfo( "Browser: Close Failure");
			testLogFail("Close Browser");
		}
	}

	public static String getText(String objLocator)
	{
		String getText = null;
		for (int i = 1; i <= elementLoadWaitTime; i++)
		{
			try {
				waitForElement(objLocator, elementLoadWaitTime);
				getText = webElement.getText();
				testLogPass("Sucessfully got the text '" + getText + "'");
				break;
			}
			catch (InvalidSelectorException e)
			{
				waitTime(1L);
			}
			catch (StaleElementReferenceException e)
			{
				waitTime(1L);
			}
			catch (ElementNotVisibleException e)
			{
				waitTime(1L);
			}
			catch (UnreachableBrowserException e)
			{
				ApplicationKeyword.testLogFail(e.toString());
			}
			catch (UnhandledAlertException e)
			{
				waitTime(1L);
			}
			catch (WebDriverException e)
			{
				waitTime(1L);
			}
			catch (Exception e)
			{
				testLogFail("Exception Error '" + e.toString() + "'");
			}
		}

		return getText;
	}

	public static String getAttributeValue(String objLocator, String attributeName)
	{
		String getAttributeValue = null;
		for (int i = 1; i <= elementLoadWaitTime; i++)
		{
			try {
				waitForElement(objLocator, elementLoadWaitTime);
				getAttributeValue = webElement.getAttribute(attributeName);
				testLogPass("Sucessfully got the attribute value '" + getAttributeValue + "'");
				break;
			}
			catch (InvalidSelectorException e)
			{
				waitTime(1L);
			}
			catch (StaleElementReferenceException e)
			{
				waitTime(1L);
			}
			catch (ElementNotVisibleException e)
			{
				waitTime(1L);
			}
			catch (UnreachableBrowserException e)
			{
				ApplicationKeyword.testLogFail(e.toString());
			}
			catch (UnhandledAlertException e)
			{
				waitTime(1L);
			}
			catch (WebDriverException e)
			{
				waitTime(1L);
			}
			catch (Exception e)
			{
				testLogFail("Exception Error '" + e.toString() + "'");
			}


		}

		return getAttributeValue;
	}

	public static int getMatchingXpathCount(String objLocator)
	{
		List xpathCount = null;
		for (int i = 1; i <= elementLoadWaitTime; i++)
		{
			try
			{
				xpathCount = driver.findElements(By.xpath(objLocator));
				testLogInfo("Sucessfully got the matchingxPath Count'" + xpathCount + "'");
			}
			catch (InvalidSelectorException e)
			{
				waitTime(1L);
			}
			catch (StaleElementReferenceException e)
			{
				waitTime(1L);
			}
			catch (ElementNotVisibleException e)
			{
				waitTime(1L);
			}
			catch (UnreachableBrowserException e)
			{
				testLogFail(e.toString());
			}
			catch (UnhandledAlertException e)
			{
				waitTime(1L);
			}
			catch (WebDriverException e)
			{
				waitTime(1L);
			}
			catch (Exception e)
			{
				testLogFail("Exception Error '" + e.toString() + "'");
			}

			if (i == elementLoadWaitTime)
			{
				testLogFail(locatorDescription + " element found but its not in editable/clickable state within " + elementLoadWaitTime + " timeouts");
			}
		}

		return xpathCount.size();
	}


	public static void UnSelectFrame()
	{
		try {
			testLogInfo("Switching to default content frame ");
			driver.switchTo().defaultContent();
		}
		catch (Exception e)
		{
			testLogFail("Error in swiching to default content frame");
		}
	}

	public static void waitForAlertWindow(int timeout)
	{
		for (int i = 0; i <= timeout; i++)
		{
			if (isAlertWindowPresent())
			{
				break;
			}

			waitTime(1L);

			if (i == timeout)
			{
				testLogFail("Alert Window is not present within '" + timeout + "' timeout");
			}
		}
	}

	public static void waitForAlertWindow(String alertTitle, int timeout)
	{
		for (int i = 0; i <= timeout; i++)
		{
			if (isAlertWindowPresent())
			{
				break;
			}

			waitTime(1L);

			if (i == timeout)
			{
				testLogFail(alertTitle + " alert Window is not present within '" + timeout + "' timeout");
			}
		}
	}

	/* public static void waitForChildWindow(String windowTitle, int timeout)
  {
    for (int i = 1; i <= timeout; i++)
    {
      String loopstatus = "false";
      if (i == timeout)
      {
        ApplicationKeyword.testLogInfo(windowTitle + "window is not present within '" + timeout + "' timeout");
        ApplicationKeyword.testLogFail(windowTitle + "window is not present within '" + timeout + "' timeout");
      }

      Set AllHandle = driver.getWindowHandles();
      for (String han : AllHandle)
      {
        driver.switchTo().window(han);
        String getTitle = driver.getTitle();
        if (getTitle.trim().equalsIgnoreCase(windowTitle))
        {
          loopstatus = "true";
          break;
        }
      }
      if (loopstatus.equalsIgnoreCase("true"))
      {
        break;
      }
      waitTime(1L);
    }
  } */

	//	public static void waitForElementToDisplay(String objLocator, int timeout, boolean checkVisibility)
	//	{
	//		boolean webElementStatus = false;
	//		try {
	//			driver.manage().timeouts().implicitlyWait(0L, TimeUnit.SECONDS);
	//
	//			for (int i = 1; i <= timeout; i++)
	//			{
	//				try
	//				{
	//					if (!webElementStatus)
	//					{
	//
	//						findWebElement(objLocator);
	//						webElementStatus = true;
	//						checkPageIsReady();
	//						
	//						if(!checkVisibility)
	//							break;
	//					}
	//					
	//					if (webElement.isDisplayed())
	//					{
	//						break;
	//					}
	//
	//					waitTime(1L);
	//				}
	//				catch (InvalidSelectorException e)
	//				{
	//					waitTime(1L);
	//				}
	//				catch (StaleElementReferenceException e)
	//				{
	//					waitTime(1L);
	//				}
	//				catch (NoSuchElementException e)
	//				{
	//					waitTime(1L);
	//				}
	//				catch (ElementNotVisibleException e) {
	//					waitTime(1L);
	//				}
	//				catch (UnreachableBrowserException e)
	//				{
	//					testLogFail(e.toString());
	//				}
	//				catch (WebDriverException e) {
	//					waitTime(1L);
	//				}
	//
	//				if (i == timeout)
	//				{
	//					if (webElementStatus)
	//					{
	//						testLogFail(locatorDescription + " element is present but its not in clickable/editable state within '" + timeout + "' timeout");
	//					}
	//					else
	//					{
	//						testLogFail(locatorDescription + " element not found in '" + timeout + "' seconds timeout ");
	//					}
	//				}
	//			}
	//		}
	//		catch (Exception e)
	//		{
	//			testLogFail("Exception error '" + e.toString() + "'");
	//		}
	//		finally
	//		{
	//			webElementStatus = false;
	//
	//			driver.manage().timeouts().implicitlyWait(implicitlyWaitTime, TimeUnit.SECONDS);
	//		}
	//	}

	public static void waitForElementToDisplay(String objLocator, int timeout)
	{
		boolean webElementStatus = false;
		try {
			driver.manage().timeouts().implicitlyWait(0L, TimeUnit.SECONDS);
			for (int i = 1; i <= timeout; i++)
			{
				try
				{
					if (!webElementStatus)
					{		
						findWebElement(objLocator);
						webElementStatus = true;
						checkPageIsReady();
					}
					if (webElement.isDisplayed())
					{
						//System.out.println(locatorDescription + " is displayed");
						break;
					}

					waitTime(1L);
				}
				catch (InvalidSelectorException e)
				{
					waitTime(1L);
				}
				catch (StaleElementReferenceException e)
				{
					waitTime(1L);
				}
				catch (NoSuchElementException e)
				{
					waitTime(1L);
				}
				catch (ElementNotVisibleException e) {
					waitTime(1L);
				}
				catch (UnreachableBrowserException e)
				{
					testLogFail(e.toString());
				}
				catch (WebDriverException e) {
					waitTime(1L);
				}

				if (i == timeout)
				{
					if (webElementStatus)
					{
						testLogFail(locatorDescription + " element is present but its not in clickable/editable state within '" + timeout + "' timeout");
					}
					else
					{
						testLogFail(locatorDescription + " element not found in '" + timeout + "' seconds timeout ");
					}
				}
			}
		}
		catch (Exception e)
		{
			testLogFail("Exception error '" + e.toString() + "'");
		}
		finally
		{
			webElementStatus = false;

			driver.manage().timeouts().implicitlyWait(implicitlyWaitTime, TimeUnit.SECONDS);
		}
	}

	//Had to create overload because 'checkPageIsReady' is important in some scnearios
	//Existing method neither waits nor calls this methos
	//waitForElement method also does not call this method
	public static boolean isElementDisplayed(String objLocator, int timeout)
	{
		boolean webElementStatus = false;
		try {
			driver.manage().timeouts().implicitlyWait(0L, TimeUnit.SECONDS);

			for (int i = 1; i <= timeout; i++)
			{
				try
				{
					if (!webElementStatus)
					{
						findWebElement(objLocator);
						webElementStatus = true;
						checkPageIsReady();
					}
					if (webElement.isDisplayed())
					{
						//System.out.println(locatorDescription + " is displayed");
						break;
					}

					waitTime(1L);
				}
				catch (InvalidSelectorException e)
				{
					waitTime(1L);
				}
				catch (StaleElementReferenceException e)
				{
					waitTime(1L);
				}
				catch (NoSuchElementException e)
				{
					waitTime(1L);
				}
				catch (ElementNotVisibleException e) {
					waitTime(1L);
				}
				catch (UnreachableBrowserException e)
				{
					testLogFail(e.toString());
				}
				catch (WebDriverException e) {
					waitTime(1L);
				}

				if (i == timeout)
				{
					return false;
				}
			}
		}
		catch (Exception e)
		{
			testLogFail("Exception error '" + e.toString() + "'");
		}
		finally
		{
			webElementStatus = false;

			driver.manage().timeouts().implicitlyWait(implicitlyWaitTime, TimeUnit.SECONDS);
		}

		return true;
	}



	public static void clickOnSpecialElement(String objectLocator)
	{
		try
		{
			waitForElement(objectLocator, elementLoadWaitTime);
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", new Object[] { webElement });
			testLogPass(  "Click on :" + locatorDescription);
		}
		catch (Exception e)
		{
			testLogFail("Click on :" + locatorDescription);
		}
	}

	public static boolean isElementDisplayed(String objectLocator)
	{
		findWebElement(objectLocator);

		if (webElement.isDisplayed())
		{
			return true;
		}

		return false;
	}

	public static boolean isTextPresent(String expectedText)
	{
		if (driver.getPageSource().contains(expectedText))
		{
			return true;
		}

		return false;
	}

	public static void deleteAllCookies()
	{
		try
		{
			driver.manage().deleteAllCookies();
			testLogInfo("Successfully deleted all cookies");
		}
		catch (Exception e)
		{
			windowreadyStateStatus = false;
			testLogFail("Delete All cookies keyword exception error" + e.toString());
		}
	}

	public static void maximiseWindow()
	{
		try
		{
			driver.manage().window().maximize();
			testLogInfo("Successfully Maximised Browser Window");
		}
		catch (Exception e)
		{
			windowreadyStateStatus = false;
			testLogFail("Maximise window keyword exception error" + e.toString());
		}
	}

	public static void selectCheckBox(String objLocator)
	{
		waitForElementToDisplay(objLocator, elementLoadWaitTime);
		try
		{
			if (!webElement.isSelected())
			{
				webElement.click();
			}
			testLogPass("Checked on the " + locatorDescription + " checkbox");
		}
		catch (Exception e)
		{
			testLogFail(e.toString());
		}
	}

	public static void unSelectCheckBox(String objLocator)
	{
		waitForElementToDisplay(objLocator, elementLoadWaitTime);
		try
		{
			if (webElement.isSelected())
			{
				webElement.click();
			}
			testLogPass("Unchecked the " + locatorDescription + " checkbox");
		}
		catch (Exception e)
		{
			testLogFail(e.toString());
		}
	}

	public static void verifyCheckBoxIsChecked(String objLocator)
	{
		waitForElementToDisplay(objLocator, elementLoadWaitTime);
		try
		{
			if (webElement.isSelected())
			{
				testLogPass("Verified that " + locatorDescription + " is checked");
			}
			else
			{
				testLogFail(locatorDescription + " is not checked");
			}

		}
		catch (Exception e)
		{
			testLogFail(e.toString());
		}
	}

	public static void verifyCheckBoxIsUnChecked(String objLocator)
	{
		waitForElementToDisplay(objLocator, elementLoadWaitTime);
		try
		{
			if (!webElement.isSelected())
			{
				testLogPass("Verified that " + locatorDescription + " is Unchecked");
			}
			else
			{
				testLogFail(locatorDescription + " is  checked");
			}

		}
		catch (Exception e)
		{
			testLogFail(e.toString());
		}
	}


	public static void testStarts(String TestCaseName, String Description)
	{
		try
		{
			logger = extent.startTest(TestCaseName, Description);
			Assert.assertTrue(true);
			logger.log(LogStatus.PASS, Description);
		}
		catch(Exception e)
		{
			testLogFail("unable to generate the pass report "+e.toString());
		}
	}

	public static void testLogInfo(String Description)
	{
		try
		{
			logger.log(LogStatus.INFO, Description);
		}
		catch(Exception e)
		{
			testLogFail("unable to generate the Info report "+e.toString());
		}

	}

	public static void testLogPass(String Description)
	{
		try
		{
			logger.log(LogStatus.PASS, Description);
		}
		catch(Exception e)
		{
			testLogFail("unable to generate the Error report "+e.toString());
		}
	}
	public static void testLogError(String Description)
	{
		try
		{
			String screenshotPath = getScreenshot();
			logger.log(LogStatus.ERROR, Description, logger.addScreenCapture(screenshotPath));
		}
		catch(Exception e)
		{
			testLogFail("unable to generate the Error report "+e.toString());
		}
	}

	public static void testLogFail(String Description)
	{
		try
		{
			logger.log(LogStatus.FAIL, Description);
			String screenshotPath = getScreenshot();
			//To add it in the extent report 
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));

		}
		catch(Exception e)
		{
			testLogFail("unable to generate the fail report "+e.toString());
		}
	}

	public static void checkPageIsReady() {
		try
		{
			JavascriptExecutor js = (JavascriptExecutor)driver;
			//Initially bellow given if condition will check ready state of page.
			if (js.executeScript("return document.readyState").toString().equals("complete"))
			{
				Thread.sleep(2000);
				System.out.println("Page Is loaded.");
				return; 
			}
		}
		catch (Exception e) {

			testLogFail("unable to execute the menthod checkPageIsReady "+e.toString());
		}


	}

	public void getscreenshot() throws Exception 
	{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//The below method will save the screen shot in d drive with name "screenshot.png"
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") +"/test-output/screenshot.png"));
	}

	public static String getScreenshot() throws Exception 
	{

		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		//
		String destination = System.getProperty("user.dir") + "/test-output/Automation"+dateName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);

		return destination;
	}

	public static enum keys
	{
		ENTER, 
		SPACE, 
		ESCAPE, 
		CONTROL, 
		ALT, 
		BACKSPACE, 
		CANCEL, 
		DELETE, 
		PAGEDOWN, 
		PAGEUP, 
		TAB;
	}
	
	 public boolean isFileDownloaded(String downloadPath, String fileName) {
		  File dir = new File(downloadPath);
		  File[] dirContents = dir.listFiles();

		  for (int i = 0; i < dirContents.length; i++) {
		      if (dirContents[i].getName().equals(fileName)) {
		          // File has been found, it can now be deleted:
		          dirContents[i].delete();
		          return true;
		      }
		          }
		      return false;
		  }
	
	
	
	
	
	public static void closeBrowser()
	{
		try
		{   deleteAllCookies();
		driver.quit();
		testLogPass("Closed browser sucessfully");
		}
		catch (Exception e)
		{

			testLogFail("unable to Close browser "+e.toString());
		}

	}


}