//Created date : 19-May-2020
//To check the desiredcapabilities class which is ignoring the protected mode settings of all zones in IE browser in run time instead of doing it manually
//To ignore the zoom level with desired capabilities in the run time
//REset the zoom level to 100% again

package Selenium_Tuts1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProtectedMode_DesiredCap {

	public static void main(String[] args) {
		// Set the path of the driver
		System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer.exe");

		// Set the capability of IE driver before launching - to ignore all zones
		// protected mode settings
		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		// Set desired capabilities to Ignore IEDriver zoom level settings and disable
		// native events.
		caps.setCapability("EnableNativeEvents", false);
		caps.setCapability("ignoreZoomSetting", true);

		// Initiate the browser instance
		WebDriver driver = new InternetExplorerDriver(caps);

		// Launch the URL
		driver.get("http://only-testing-blog.blogspot.com/2014/04/calc.html");

		// Press Ctrl+0 of the keyboard keys to set the IE driver instance zoom level to
		// 100%
		driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, "0"));
		// Execute the sample calc test
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id=1]")));
		driver.findElement(By.xpath("//input[@id='1']")).click();
		driver.findElement(By.xpath("//input[@id='plus']")).click();
		driver.findElement(By.xpath("//input[@id='8']")).click();
		driver.findElement(By.xpath("//input[@id='equals']")).click();
		String calc_value = driver.findElement(By.xpath("//input[@id='Resultbox']")).getAttribute("value");
		System.out.println(calc_value);

		// Close the driver
		driver.close();
	}

}
