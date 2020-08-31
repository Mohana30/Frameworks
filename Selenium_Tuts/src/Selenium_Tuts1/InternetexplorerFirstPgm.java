//Created at 19-May-2020
//Purpose : as a first internet explorer and faced one issue with protected mode and set all the zones protected mode manually and the code pass
//Error : without setting it manually - Webdriver wait for so long time after launching the URL and the program failes with the Timout exception/org.openqa.selenium.SessionNotCreatedException



package Selenium_Tuts1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InternetexplorerFirstPgm {
	
	public static void main(String[] args) throws Exception
	{
		//Set the path of driver
		System.setProperty("webdriver.ie.driver","D:\\IEDriverServer.exe");
		//System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		//Initialize Internet Explorer Instance
		WebDriver driver = new InternetExplorerDriver();
		//WebDriver driver = new ChromeDriver();
		
		//Launch the URL
		driver.get("http://only-testing-blog.blogspot.com/2014/04/calc.html");
		
		//Execute the sample calc test
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id=1]")));
		driver.findElement(By.xpath("//input[@id='1']")).click();
		driver.findElement(By.xpath("//input[@id='plus']")).click();
		driver.findElement(By.xpath("//input[@id='8']")).click();
		driver.findElement(By.xpath("//input[@id='equals']")).click();
		String calc_value = driver.findElement(By.xpath("//input[@id='Resultbox']")).getAttribute("value");
		System.out.println(calc_value);
		
		//Close the driver
		driver.close();
		
	}

}