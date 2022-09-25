package p20_09_2022_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public CartPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
		
	public WebElement cartLink() {
		return driver.findElement(By.className("page-item-8"));
		
	}
	
	public WebElement checkoutLink() {
		return driver.findElement(By.className("page-item-9"));
		
	}
	
	public WebElement myAccountLink() {
		return driver.findElement(By.className("page-item-10"));
		
	}
	
	public WebElement sampleLink() {
		return driver.findElement(By.className("page-item-2"));
		
	}
	
	public WebElement shopLink() {
		return driver.findElement(By.className("page-item-7"));
		
	}

}
