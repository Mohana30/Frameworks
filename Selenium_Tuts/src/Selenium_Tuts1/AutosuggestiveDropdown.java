 package Selenium_Tuts1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutosuggestiveDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		System.out.println("IND entered");
		Thread.sleep(3000);
		List<WebElement> options= driver.findElements(By.cssSelector("ul[class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all'] a"));
		for(WebElement option:options) {
			String location = option.getText();
			if(location.equals("India"))
			{
				System.out.println("Match found");
				option.click();
			}
			else
			{
				System.out.println("Match not found");
			}
		}
		driver.close();
	}
	
	

}
