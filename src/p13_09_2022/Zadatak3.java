package p13_09_2022;

import java.sql.Driver;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {

	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		ArrayList<String> list = new ArrayList<String>();
		list.add("https://google.com/");
		list.add("https://youtube.com/");
		list.add("https://www.ebay.com/");
		list.add("https://www.kupujemprodajem.com/");
		
		for (int i = 0; i < list.size(); i++) {
			driver.get(list.get(i));
			System.out.println(driver.getTitle());
		}
		
		
		driver.quit();

	}

}
