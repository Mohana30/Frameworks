	
package Selenium_Tuts1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_Table {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement tab = driver.findElement(By.id("product"));
		int rowCount = tab.findElements(By.tagName("tr")).size();
		System.out.println("Product table row count is : "+rowCount);
		System.out.println(tab.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
		System.out.println(tab.findElements(By.tagName("tr")).get(2).getText());
		driver.close();
	}

}
