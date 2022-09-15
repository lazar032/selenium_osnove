package p13_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://cms.demo.katalon.com/");
		
		driver.findElement(By.xpath("//*[@name='s']")).sendKeys("Flying Ninja");
		
		driver.findElement(By.xpath("//button[@class='search-submit']")).click();
		
		Thread.sleep(5000);
		
		driver.quit();

	}

}
