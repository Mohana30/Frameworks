package Selenium_Tuts1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment_UI {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		driver.manage().window().maximize();
		Thread.sleep(9000);
		//SelectFromLocation(driver);
		//SelectToLocation(driver);
		ChooseCalender(driver);
		ChooseDropdown(driver);
		driver.findElement(By.cssSelector("#SearchBtn")).click();
		//Get the error message
		String errorText = driver.findElement(By.cssSelector("#homeErrorMessage")).getText();
		System.out.println("Error message captured is : "+errorText );
		driver.close();
	}
	
	public static void SelectFromLocation(WebDriver driver) throws InterruptedException {
		driver.findElement(By.id("FromTag")).sendKeys("Irela");		
		Thread.sleep(10000);
		List<WebElement> fromLocation = driver.findElements(By.cssSelector(".list a"));
		for(WebElement from:fromLocation)
		{
			String[] location = from.getText().split(",");
			String loc = location[0].trim();
			if(loc.contentEquals("Dublin"))
			{
				from.click();
				break;
			}
				
		}
	}
	
	public static void SelectToLocation(WebDriver driver) throws InterruptedException {
		driver.findElement(By.id("ToTag")).sendKeys("Irel");
		Thread.sleep(10000);
		List<WebElement> fromLocation = driver.findElements(By.cssSelector(".list a"));
		for(WebElement from:fromLocation)
		{
			String[] location = from.getText().split(",");
			String loc = location[0].trim();
			if(loc.contentEquals("Cork"))
			{
				from.click();
				break;
			}
		}
	}
	
	public static void ChooseCalender(WebDriver driver) {
		driver.findElement(By.id("DepartDate")).click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();;
	}
	
	public static void ChooseDropdown(WebDriver driver) {
		
		Select s = new Select(driver.findElement(By.id("Adults")));
		s.selectByValue("5");
		
		
		Select s1 = new Select(driver.findElement(By.id("Childrens")));
		s1.selectByValue("2");
		
		
		Select s11 = new Select(driver.findElement(By.id("Infants")));
		s11.selectByValue("1");
		
	}
}
