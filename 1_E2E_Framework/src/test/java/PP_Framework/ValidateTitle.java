package PP_Framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.LoginPage;

import resources.baseClass;

public class ValidateTitle extends baseClass {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(ValidateTitle.class.getName());
	@BeforeClass
	public void Launch() throws IOException {
		driver=initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("URL"));
		log.info("URL launched");
		Actions ac = new Actions(driver);
		LandingPage landing = new LandingPage(driver);
		ac.moveToElement(landing.closeSubscribePopUp()).click().build().perform();
		log.info("Subscribe popup was closed");
	}

	@Test
	public void validateTextandTitle() throws IOException {
			
		//If you want to use the method or variables of other class there are two ways
		//1. inheritence
		//2. Creating object for the class and calling the method
		LandingPage landing = new LandingPage(driver);
		Assert.assertEquals("FEATURE COURSES",landing.getFearuredCourses().getText());
		log.info("Featured course matched");
		//driver.findElement(By.className("sumome-react-svg-image-container")).click();
		
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
	


}
