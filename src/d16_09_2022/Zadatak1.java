package d16_09_2022;

import java.io.File;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Zadatak1 {


	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you");
		driver.manage().window().maximize();
		File slika1 = new File("");
		File slika2 = new File("");
		File slika3 = new File("");
		File slika4 = new File("");
		for (int i = 1; i < 5; i++) {
			File slika = null;
			if (i==1) {
				slika = slika1;
			}else if(i==2) {
				slika = slika2;
			}else if(i==3) {
				slika = slika3;
			}else if(i==4) {
				slika = slika4;
			}
			driver.findElement(By.xpath("//*[@alt= 'image "+ i + "']")).click();
			driver.findElement(By.xpath("//*[contains(text(),'+ Add photo')]")).click();
			driver.findElement(By.xpath("//input[@type='file']")).sendKeys(slika.getAbsolutePath());
			Thread.sleep(1000);
			wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//img[@loading='lazy']"), i));
			driver.findElement(By.xpath("//img[@loading='lazy']")).click();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Use One Side Only']")));
			driver.findElement(By.xpath("//*[text()='Use One Side Only']")).click();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Done']")));
			driver.findElement(By.xpath("//*[text()='Done']")).click();
			Thread.sleep(1000);	
		}
			Random random = new Random();
			int x = random.nextInt();
			driver.findElement(By.xpath("//*[@name='"+ x +"']")).click();
			Thread.sleep(1000);	
			driver.findElement(By.xpath("//*[text()='Add to cart ']")).click();
			Thread.sleep(1000);	
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(" //*[@action='error']")));
			System.out.println("Greska je izlozena!");
		Thread.sleep(5000);
		driver.quit();

	}

}