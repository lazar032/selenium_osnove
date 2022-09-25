package p20_09_2022_tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import p20_09_2022_pages.CartPage;
import p20_09_2022_pages.ProductPage;

public class KatalonShopTests {
	private WebDriver driver;
	private WebDriverWait wait;
	private String baseURL = "https://cms.demo.katalon.com";
	private CartPage cartPage;
	private ProductPage productPage;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		cartPage = new CartPage(driver, wait);
		productPage = new ProductPage(driver, wait);
	}
	
	@BeforeMethod
	public void BeforeMethod() {

		driver.get(baseURL);
	}
	
	@Test (priority = 10)
	public void openHomePage() {
		
		
		
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
