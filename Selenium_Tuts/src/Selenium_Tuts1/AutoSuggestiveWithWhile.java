package Selenium_Tuts1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveWithWhile {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://ksrtc.in/");
		driver.findElement(By.id("fromPlaceName")).sendKeys("BENG");
		Thread.sleep(5000);
		String fromLocation = "INTERNATION AIRPORT";
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//a[contains(text(),'"+fromLocation+"')]")).click();
		

	}

}
