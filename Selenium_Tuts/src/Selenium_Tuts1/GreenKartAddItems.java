package Selenium_Tuts1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GreenKartAddItems {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String[] itemsToBeSelected = { "Brocolli", "Carrot", "Mushroom", "Pumpkin", "Capsicum", "Corn", "Apple" };
		for (int i = 0; i < itemsToBeSelected.length; i++) {
			try {
				driver.findElement(By.xpath("//h4[contains(text(),'" + itemsToBeSelected[i]+ "')]/following-sibling::div[@class='product-action']/button")).click();
			} catch (NoSuchElementException e) {
				System.out.println("Items not found in the page");
			}
		}
	}
}
