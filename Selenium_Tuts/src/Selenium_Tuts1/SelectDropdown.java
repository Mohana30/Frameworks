package Selenium_Tuts1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SelectDropdown {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://spicejet.com/");
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("divpaxinfo"))); // Thread.sleep(2000L) was the

		// Click on the Passengers div
		driver.findElement(By.cssSelector("#divpaxinfo")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("ctl00_mainContent_ddl_Adult")));

		// Able to see the number of adult drop down and the tagName is Select so only
		// we are using Select Class
		Select s = new Select(driver.findElement(By.id("ctl00_mainContent_ddl_Adult")));

		// Working with while loop
		int i = 1;
		while (i <= 5) {
			s.selectByValue(Integer.toString(i));
			i++;
		}

		// workng with for loop
		for (i = 5; i < 9; i++) {
			s.selectByIndex(i);
		}

		String text = driver.findElement(By.id("ctl00_mainContent_ddl_Adult")).getText();
		System.out.println(text + " is displayed");

		driver.findElement(By.cssSelector(".ui-datepicker-trigger")).click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

		System.out.println(driver.findElement(By.id("Div1")).isEnabled());
		// This may not work sometimes, so find out some other attributes which is
		// changing the enable and disable
		// Because object was enabled in the code level(REturn date) so it is not
		// returning true in the above line of code.. Developer has changed the opacity
		// alone to show the object as a disabled one
		// Get the attribute value of style to check that the object
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("Style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("Style"));

		if (driver.findElement(By.id("Div1")).getAttribute("Style").contains("0.5")) {
			System.out.println("REturn date is enabled");
			// When you want to fail the test case use the assertions based on issues
			// Like i have clicked on 'Round trip' radio button and the REturn date should
			// be enabled if it is not enabled then that is error
			Assert.assertTrue(true);
		} else {
			System.out.println("REturn date is disabled");
			// We can capture our error with this else and also we can stop the test by the
			// below assertions
			Assert.assertTrue(false);
		}

		// Close the driver
		driver.close();

	}

}
