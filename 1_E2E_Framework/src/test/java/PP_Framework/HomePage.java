package PP_Framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import PageObjects.ForgotPassword;
import PageObjects.LandingPage;
import PageObjects.LoginPage;

import resources.baseClass;


public class HomePage extends baseClass {
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(HomePage.class.getName());
	
	@BeforeClass
	public void Launch() throws IOException {
		driver=initializeDriver();
		log.info("Driver is initialized");
		
		
	}
	
	@Test(dataProvider="getData")
	public void validateLogin(String username,String password,String text) {
		
		//If you want to use the method or variables of other class there are two ways
		//1. inheritence
		//2. Creating object for the class and calling the method
		driver.get(prop.getProperty("URL"));
		log.info("Navigated to home page");
		//Actions ac = new Actions(driver);
		LandingPage landing = new LandingPage(driver);
		//ac.moveToElement(landing.closeSubscribePopUp()).click().build().perform();
		log.info("Subscribe popup was closed");
		LoginPage login = landing.getLogin();
		log.info("Signin button was clicked");
		login.getEmail().sendKeys(username);
		log.info("Entered Username");
		login.getPassword().sendKeys(password);
		log.info("Entered password");
		login.getLoginButton().click();
		log.info("Login button clicked");
		ForgotPassword fp = login.forgotPassword();
		fp.getEmail().sendKeys("hfjghdjfgh");
		fp.sendMeInstruction().click();
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
		log.info("browser closed");		
	}
	
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];
		data[0][0] = "nonrestricteduser@qw.com";
		data[0][1] = "123456";
		data[0][2] = "Restricted User";
		
		data[1][0] = "restricteduser@qw.com";
		data[1][1] = "456788";
		data[1][2] = "Non Restricted User";
		
		return data;
	}

}
