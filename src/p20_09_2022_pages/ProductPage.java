package p20_09_2022_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public ProductPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}
	
	public WebElement quantity() {
		return driver.findElement(By.className("qty"));
	}
	
	public WebElement addToCart() {
		return driver.findElement(By.name("add-to-cart"));
	}
	
	public WebElement addedMessage() {
		return driver.findElement(By.className("woocommerce-message"));
	}
}
