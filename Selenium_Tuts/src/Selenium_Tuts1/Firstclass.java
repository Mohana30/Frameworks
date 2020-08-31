

package Selenium_Tuts1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Firstclass {

	//main function
	
	public static void main(String[] args)
	{
		
		//Set the driver path for the browser -- so the driver server for communicating your selenium code to the browser
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//Open URL
		driver.get("http://only-testing-blog.blogspot.in");
		String str_Url = driver.getCurrentUrl();
		System.out.println(str_Url);
		
		//----Launch google website and enter search text----
		driver.get("http://www.google.com");
		
		//-----------------------------------Verify the Url launched was correct or not---------------------------
		//1. with the get title you can check
		String title = driver.getTitle();
		System.out.println("Title of the page with getTitle() method"+title);
		
		
		//2. with the launched current url and already i am getting it in the line 29
		System.out.println("Current url with the getCurrentUrl() method"+str_Url);
		
		//3. Get the page source from the browser for the page and validate it
		String str_PageSource = driver.getPageSource();
		//System.out.println("PageSource with the getPageSource() method"+str_PageSource);
		//--------------------------------------------------------------------------------------------------------
		
		
		
		//-----------------------Locator and identifiers in selenium--------------------------------------------------
		//Selenium will recognises all the objects in the page with the help of locators
		//In inspect element we can see the unique property created by the developer to create the object in the web page
		//What are the locators : ID,ClassName,Name,Linktext,xPath,CSS path and Partial link text
		
		if(driver.findElement(By.xpath("//input[@name='q']")).isEnabled())
		{
			driver.findElement(By.xpath("//input[@name='q']")).sendKeys("WebDriver Test successful.    ");
			driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
			//driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Search");
			driver.manage().window().maximize();

			//WebElement element = driver.findElement(By.xpath("//input[@name='btnK']"));
			//JavascriptExecutor ex = (JavascriptExecutor)driver;
			//ex.executeScript("argument[0].click()", element);
			//driver.findElement(By.xpath("//input[@name='btnK']")).click();
			System.out.println("Google search completed.");
		}
		else
		{
		   System.out.println("Google search test box Is Not enabled.");

		}
		//--------------------------------------------------------------------------------------------------------
		
		
		
		
		driver.get("https://www.facebook.com/");

		//------------------------------------Navigate with the browser-----------------------------------------
		//Navigate to previous page
		driver.navigate().back();
				
		//Navigate to next page
		driver.navigate().forward();
		//--------------------------------------------------------------------------------------------------------
		

		
		//------------------------------------Login with Salesforce-----------------------------------------------
		//--------------------------xPath and css locator---------------------------------------------------------
		//1. Right click on the object properties line and select copy -> copy xpath => used in the salesforce login and username and same for css selector
		//2. Write it manually - the xpath and css as well
		//Xpath : //tagname[@attribute='value']
		//css Selector : tagname[attribute='value'] and tagname#id and tagname#className 
		driver.get("https://login.salesforce.com/?locale=eu");
		driver.findElement(By.cssSelector("input[type=email]")).sendKeys("ASDF");
		driver.findElement(By.cssSelector("#username")).sendKeys("ASDFG");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("ASDFG");
		driver.findElement(By.xpath("//*[@id='Login']")).click(); 	
		//--------------------------------------------------------------------------------------------------------
		//--------------------------------------------------------------------------------------------------------
		
		
		
		//----------------------------Regex xpath and css selector------------------------------------------------
		//  Regex in xpath       -->  //tagName[contans(@attribute,'value)]
		// Regex in css selector -->  tagName[attriute*='value']
		//--------------------------------------------------------------------------------------------------------
		driver.get("https://www.rediff.com/");
		driver.findElement(By.xpath("//a[contains(@title,'Sign')]")).click();
		driver.findElement(By.cssSelector("#login1")).sendKeys("HEllo");
		driver.findElement(By.cssSelector("input[name*='pass']")).sendKeys("HEllo");
		driver.findElement(By.xpath("//input[contains(@value,'Sign')]")).click();

		//-------------------------------------------Close the driver--------------------------------
		//1. Closes the browser where you are in focus
		driver.close();
		//2. Close all the windows opened by selenium (when you are dealing with child windows you can use it)
		driver.quit();
		//--------------------------------------------------------------------------------------------------------
	}
	
	
}
