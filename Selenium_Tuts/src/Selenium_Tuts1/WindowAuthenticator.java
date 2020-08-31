package Selenium_Tuts1;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowAuthenticator {
	public static void main(String[] args) throws InterruptedException, IOException {
		
		String downloadPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		HashMap<String,Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("profile.default_content_settings.cookies",2);
		chromePrefs.put("download.default_directory",downloadPath);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		//Tell the browser that the default download path 
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://admin:admin@the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='Basic Auth']")).click();
		driver.get("https://altoconvertpdftojpg.com/");
		driver.findElement(By.cssSelector(".button")).click();
		driver.findElement(By.id("dropzoneInput-label")).click();
		Thread.sleep(5000);
		//Selenium cannot able to handle windows popup or authentication anything
		//so we are using auto it to control the window file explorer
		//1. Install Auto IT
		//2. Goto SciTE and open the editor and write the code(for find out the windows objects we are using "Au3Info" from the Auto IT
		//3. Save the editor file with the .au3 extension and right click and compile the file so it will convert into .exe
		//Java can execute all the .exe files so we we have converted the au3(AUto IT script) file into exe
		//Selenium dont have any idea about calling .exe file
		
		Runtime.getRuntime().exec("D:\\Autoit\\Autoit_fileuploadscript.exe");
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Convert Now!']")));	
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Convert Now!']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Download Now']")));		
		driver.findElement(By.xpath("//a[text()='Download Now']")).click();
		Thread.sleep(5000);
		File fi = new File(downloadPath+"/Result.zip");
		if(fi.exists()) {
			System.out.println("File is downloaded");
			if(fi.delete())
				System.out.println("File is deleted");
		}
		
		
	}

}
