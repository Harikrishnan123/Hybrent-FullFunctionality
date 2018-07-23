package funcation_PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.TextPage;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;
import AutomationFramework._OR;

public class NewsEvent extends ApplicationKeyword{
    
	
	public static void PageLinkAndWait()
    {
		JavascriptExecutor je = (JavascriptExecutor) driver;		
		WebElement element = driver.findElement(By.xpath("//*[@href='#/news']"));
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		clickOn(OR.NewsEvent);
	}
	
	public static void Pageverify()
	{
		verifyElementText(OR.AppPage_headerText, "NEWS");
		
		int size = driver.findElements(By.xpath("//*[@id='news_list']/*[starts-with(@id,'news')]")).size();
		for(int i=1;i<=size;i++)
		{
			String ActiveNews = driver.findElement(By.xpath("(//*[@id='news_list']//h5)["+i+"]")).getText();
			String ActiveNewsDate = driver.findElement(By.xpath("(//*[@id='news_list']//p)["+i+"]")).getText();
			testLogPass("Active News are "+ActiveNews+" and date is "+ActiveNewsDate);
			testLogPass("Header "+getText(OR.NewsEvent_Header));
		}	
	}
}

