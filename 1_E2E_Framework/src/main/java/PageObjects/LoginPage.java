package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;
	By eMail = By.cssSelector("#user_email");
	By password = By.cssSelector("#user_password");
	By loginbutton = By.cssSelector("input[type='submit']");
	By forgotPassword = By.cssSelector("a[href*='password'");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getEmail() {
		return driver.findElement(eMail);
	}
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	public WebElement getLoginButton() {
		return driver.findElement(loginbutton);
	}
	public ForgotPassword forgotPassword() {
		driver.findElement(forgotPassword).click();
		return new ForgotPassword(driver);
	}

}
