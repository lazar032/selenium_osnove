package p16_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Zadatak2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		
		driver.manage().window().maximize();
		driver.get("https://crop-circle.imageonline.co/#circlecropresult");
		
		new Actions(driver).scrollByAmount(0, 750).perform();
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("inputImage"))
				.sendKeys("C:\\Users\\Lazar\\Desktop\\golden-retriever.jpg");
		
		Thread.sleep(2000);
	
		
		driver.findElement(By.id("photobutton")).click();
		
		Thread.sleep(5000);
		
		driver.quit();
		

	}

}
