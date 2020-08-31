package Selenium_Tuts1;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentWindowHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		Set<String> tabHandles = driver.getWindowHandles();
		String parentHandle = driver.getWindowHandle();
		Iterator<String> it = tabHandles.iterator();
		while(it.hasNext()) {
			String childHandle = it.next();
			if(!parentHandle.contentEquals(childHandle)) {
				driver.switchTo().window(childHandle);
				System.out.println(driver.findElement(By.cssSelector(".example")).getText());
				driver.switchTo().window(parentHandle);
				System.out.println(driver.findElement(By.cssSelector(".example h3")).getText());
				break;
			}
		}
		driver.quit();

	}

}
