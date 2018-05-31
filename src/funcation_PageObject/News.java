package funcation_PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.TextPage;

import AutomationFramework.ApplicationKeyword;
import AutomationFramework.OR;
import AutomationFramework._OR;

public class News extends ApplicationKeyword{
    
	public static void NavigateToNews()
	{
		 clickOn(_OR.DashBoard_Admin);
		 clickOn(_OR.DashBoard_Admin_news);
		 getTextchild("//*[@class='pagehead']");
		 String one = driver.findElement(By.xpath("(//*[@ng-repeat='NewsData in NewsDatas'])[1]")).getAttribute("class");
		 if(one.contains("grid-item"))
		 {
			 testLogPass("All news are in Grid view");
		 }
	}
	
	public static void Pageverify()
	{
		testLogPass("Title of new is "+getText(OR.News_firstNewsa));
		verifyElement(OR.News_deleteNews);
		verifyElement(OR.News_EditNews);
		verifyElement(OR.News_Updatedat);
		verifyElement(OR.News_UpdatedBy);
		testLogPass("updatedby name is "+getText(OR.News_Updatedbyname));
		testLogPass("updated at is "+getText(OR.News_Updatedatname));
		verifyElement(OR.Itemcatalog_SearchBy);
		int size = driver.findElements(By.xpath("//*[@id='search-status']")).size();
		for(int i =1 ;i<=size;i++)
		{
			String one = driver.findElement(By.xpath("(//*[@id='search-status']/option)["+i+"]")).getText();
			testLogPass("Status dropDown contains "+one);
		}
		Select select = new Select(driver.findElement(By.xpath("//*[@id='search-status']")));
		WebElement option = select.getFirstSelectedOption();
		String defaultItem = option.getText();
		testLogPass("Status dropDown contains "+defaultItem);
		verifyElement(OR.News_searchButton);
		verifyElement(OR.News_addNews);
	}
	
	public static void AddActiveNews()
	{
		String Addnews = "News"+randomAlphaNumeric(5);
		String AddDes = "Des"+randomAlphaNumeric(5);
		verifyElement(OR.News_addNews);
		clickOn(OR.News_addNews);
		verifyElementText(OR.News_add_AddnewsTitle, "ADD NEWS");
		typeIn(OR.News_addTitle, Addnews);
		typeIn(OR.News_addDec, AddDes);
		String file =System.getProperty("user.dir")+"/assets/1.jpeg";
    	driver.findElement(By.xpath("(//*[@type='file'])[1]")).sendKeys(file);
    	clickOn(OR.News_UploadBtn);
    	waitForElement(OR.News_UploadImgPath, 30);
    	verifyElementText(OR.News_UploadImgPath, "Uploaded Image Path");
    	testLogPass("File path is "+getText(OR.News_Filepth));
    	clickOn(OR.Template_Schedule_Savebtn);
    	clickOn(OR.DashBoard);
    	waitForElement(OR.DashBoard, 30);
    	int Size = driver.findElements(By.className("news-sub-head")).size();
    	for(int k=1;k<=Size;k++)
    	{
    		String s = driver.findElement(By.xpath("(//*[@class='news-sub-head ng-binding'])["+k+"]")).getText();
    		if(s.contains(Addnews))
    		{
    			testLogPass("News is in active state");
    		}
    	}
    	
    	NavigateToNews();
    	typeIn(OR.News_searchTextBox,Addnews);
    	clickOn(OR.News_searchButton);
    	clickOn(OR.News_EditNews);
    	waitForElement(OR.News_EditTitle, 30);
    	String attribute = driver.findElement(By.xpath("//*[text()='Status']/following-sibling::div/div")).getAttribute("class");
    	if(attribute.contains("bootstrap-switch-on"))
    	{
    		driver.findElement(By.xpath("//*[text()='Status']/following-sibling::div/div")).click();
    	}
    	mouseOver(OR.Template_Schedule_Savebtn);
    	WebElement e = driver.findElement(By.xpath("(//button[text()='Save'])[1]"));
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    	jse.executeScript("arguments[0].click();", e);
    	//clickOn(OR.Template_Schedule_Savebtn);
    	clickOn(OR.DashBoard);
    	waitForElement(OR.DashBoard, 30);
    	int Size1 = driver.findElements(By.className("news-sub-head")).size();
    	for(int j=1;j<=Size1;j++)
    	{
    		String s = driver.findElement(By.xpath("(//*[@class='news-sub-head ng-binding'])["+j+"]")).getText();
    		if(s.contains(Addnews))
    		{
    			testLogFail("News is in active state");
    		}else
    		{
    			testLogPass("News is Not in active state");
    		}
    	}
    	Delete(Addnews);
	}
	
	
	
	
	
	
	
	
	public static void Delete(String Searc)
	{
		NavigateToNews();
		typeIn(OR.News_searchTextBox,Searc);
		selectFromDropdown(OR.Users_StatusDropDown, "In active");
    	clickOn(OR.News_searchButton);
    	clickOn(OR.News_deleteNews);
    	clickOn(OR.Login_okay);
    	
	}

}

