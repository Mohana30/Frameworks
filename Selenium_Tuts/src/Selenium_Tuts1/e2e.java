package Selenium_Tuts1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class e2e {
	
	public static void main(String[] args)
	{
		
		//Set the driver path for the browser -- so the driver server for communicating your selenium code to the browser
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(" ");
		driver.manage().window().maximize();
		
		//------------------------------------------Select the Start and return city------------------------------------------		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@Value='COK']")).click();
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		driver.findElement(By.xpath("(//a[@Value='CJB'])[2]")).click();
		//----------------------------------------------------------------------------------------------------------------------

		
		//-------------------------------------Select the date from the calendar------------------------------------------------
		//driver.findElement(By.cssSelector(".ui-datepicker-trigger")).click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		//----------------------------------------------------------------------------------------------------------------------
		
		//------------------------------------------Select the Passengers------------------------------------------
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("divpaxinfo")));  //Thread.sleep(2000L) was the 
		
		//Click on the Passengers div
		driver.findElement(By.cssSelector("#divpaxinfo")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("ctl00_mainContent_ddl_Adult")));
		
		//Able to see the number of adult drop down	and the tagName is Select so only we are using Select Class
		Select s = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));
		//Working with while loop
		int i = 1;
			while(i<=5)
			{
			s.selectByValue(Integer.toString(i));
			i++;
			}
		
			//workng with for loop
			for(i=5;i<9;i++)
			{
				s.selectByIndex(i);
			}
		
		
		String text = driver.findElement(By.id("ctl00_mainContent_ddl_Adult")).getText();
		System.out.println(text+" is displayed");
		//----------------------------------------------------------------------------------------------------------------------

		//------------------------------------Click on Round trip and return date as well----------------------------------------------------
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("Style"));
		
		//driver.findElement(By.id("ui-datepicker-trigger")).click();
		//driver.findElement(By.className("ui-state-default ui-state-active")).click();
		
		
		
		//----------------------------------------------------------------------------------------------------------------------
		
		
		//----------------------------------Click on search button---------------------------------------------------------------
		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		//----------------------------------------------------------------------------------------------------------------------
		
	}

}
