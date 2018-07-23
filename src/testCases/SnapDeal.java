package testCases;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SnapDeal {

	WebDriver driver = new ChromeDriver();
	String username = ""; // Change to your username and passwrod
	String password = "";
	String pinCode = "";

	// This method is to navigate flipkart URL
	@BeforeClass
	public void init() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.navigate().to("https://www.snapdeal.com");
	}

	// To log in flipkart
	@Test
	public void login() {
		driver.findElement(By.xpath("//button[text()='Login']")).click();

		driver.switchTo().frame("loginIframe");

		driver.findElement(By.cssSelector("div[onClick='getLoginForm()']"))
				.click();

		driver.findElement(By.id("j_username")).sendKeys(username);
		driver.findElement(By.id("j_password_login")).sendKeys(password);
		driver.findElement(By.id("signin_submit")).click();

		driver.switchTo().defaultContent();
	}

	// Search For product
	@Test
	public void searchAndSelectProduct() {
		driver.findElement(By.cssSelector(".col-xs-20.searchformInput.keyword"))
				.sendKeys("iphone 6s");
		driver.findElement(By.cssSelector(".sd-icon.sd-icon-search")).click();

		// select the first item in the search results
		String css = ".product_grid_row:nth-of-type(1)>div:nth-child(1)";
		driver.findElement(By.cssSelector(css)).click();
	}

	@Test
	public void buyAndRemoveFromCart() {

		driver.findElement(By.xpath("//li[contains(text(),'Silver')]")).click();
		driver.findElement(By.id("pincode-check")).sendKeys(pinCode);
		driver.findElement(By.id("buy-button-id")).click();
		
		driver.findElement(By.cssSelector("i[title='Delete Item']")).click();
		Alert a = driver.switchTo().alert();	
		a.accept();
	}

	@Test
	public void logout() {
		
		driver.findElement(By.linkText("START SHOPPING NOW")).click();
		Actions s = new Actions(driver);
		WebElement user = driver.findElement(By.cssSelector(".sd-icon.sd-icon-user"));
		s.moveToElement(user).build().perform();
		driver.findElement(By.linkText("Logout")).click();
	}

	@AfterClass
	public void quit() {
		driver.close();
	}
}