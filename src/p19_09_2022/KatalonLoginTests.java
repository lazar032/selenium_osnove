package p19_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class KatalonLoginTests {
	private WebDriver driver;
	private WebDriverWait wait;
	private String baseUrl = "https://cms.demo.katalon.com";
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@BeforeMethod
	public void beforeMethod() {
		driver.get(baseUrl);
	}
	
	@Test (priority = 10)
	public void visitLoginPageFromNavBar() {
		
		driver.findElement(By.xpath("//*[contains(@class, 'page_item page-item-10')]"))
				.click();
		
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = baseUrl + "/my-account/";
		
		Assert.assertEquals(actualUrl, expectedUrl, "ERROR: Unexpected URL.");
	}
	
	@Test (priority = 20)
	public void checkInputTypes() {
		driver.get(baseUrl + "/my-account/");
		String actualText = driver.findElement(By.xpath("//*[@type = 'text']")).getAttribute("type");
		String expectedText = "text";
		Assert.assertEquals(actualText, expectedText, "ERROR: Unexpected Text");
		String actualPassword = driver.findElement(By.id("password")).getAttribute("type");
		String expectedPassword = "password";
		Assert.assertEquals(actualPassword, expectedPassword, "ERROR: Unexpected password");
		String actualCheckboxString = driver.findElement(By.id("rememberme")).getAttribute("type");
		String expectedCheckboxString = "checkbox";
		Assert.assertEquals(actualCheckboxString, expectedCheckboxString, "ERROR: Unexpected Checkbox");
		WebElement checkbox = driver.findElement(By.id("rememberme"));
		Boolean actualCheckbox = checkbox.isSelected();
		Boolean expectedCheckbox = false;
		Assert.assertEquals(actualCheckbox, expectedCheckbox, "ERROR: Unexpected checkbox");
		
	}
	
	@Test (priority = 30)
	public void displayErrorWhenCredentialsAreWrong() {
		driver.get(baseUrl + "/my-account/");
		driver.findElement(By.id("username")).sendKeys("invalidemail@gmail.com");
		driver.findElement(By.id("password")).sendKeys("invalid123");
		driver.findElement(By.name("login")).click();
		
		
	}
	
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
