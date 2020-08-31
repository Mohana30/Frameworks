package Selenium_Tuts1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptAlert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys("Priya");
		driver.findElement(By.cssSelector("#alertbtn")).click();
		//You will get the alert in this step, but the alert is not the DOM - Document object Model(which is not HTML code)
		//Note : webdriver can access or control the webpage but not the browser(Wndows application)
		//And the alert is not one of the object property of web page - instead it is javascript and its is of webbrowser window
		//To access those alert in selenium there is a wrapper class called Alert,,, with that we can handle this situation
		String alertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println("1. Alert captured and handled in selenium with the help of alert() \n text is:"+alertText);
		driver.findElement(By.id("confirmbtn")).click();
		alertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().dismiss();
		System.out.println("2. Alert captured and handled in selenium with the help of alert() \n text is:"+alertText);
		driver.close();
	}

}
