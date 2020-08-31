package Selenium_Tuts1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("mousehover")));
		Thread.sleep(5000);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Top']"))).click().build().perform();
		
		
		

	}

}
