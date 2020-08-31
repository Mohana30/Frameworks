package Selenium_Tuts1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GreenKart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String str_Title = driver.getTitle();
		System.out.println("Title is" + str_Title);
		//if (str_Title == "GreenKart - veg and fruits kart")
		//{
		//	It will not go into the loop because the '==' is only for compare the obj refernece not the content of the string, , in other words it will be used to check the memory addre of the object
		//}
		if(str_Title.equals("GreenKart - veg and fruits kart"))
		{
			System.out.println("Title matched");
		}
		
		//---------------------------identify the object with the help of relative xpath---------------------------
		if(driver.findElement(By.xpath("//div[@class='brand greenLogo']")).isDisplayed())
		{
			System.out.println("Logo is displayed");
		}
		
		WebElement ele = driver.findElement(By.xpath("//div[contains(@class,'brand')]"));
		if(ele.isDisplayed())
		{
			System.out.println("Logo is displayed with the help of Webelement object");
		}
		
		
		//---------------------------identify the object with the help of absolute xpath---------------------------
		if(driver.findElement(By.xpath("//div/div/footer/p")).isDisplayed())
		{
			String footer = driver.findElement(By.xpath("//div/div/footer/p")).getText();
			System.out.println("Footer is displayed and the text is "+footer);
		}
		
		//---------------------------identify the child with the help of parent---------------------------
		
		
		//---------------------------identify the parent with the help of child---------------------------
		if(driver.findElement(By.xpath("//h4[text()='Brocolli - 1 Kg']/parent::div")).isDisplayed())
		{
			System.out.println("Identify parent with the help of child is done");
		}
		
		//---------------------------identify the sibling with the help of sibling---------------------------
	}

}
