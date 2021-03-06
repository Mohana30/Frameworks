package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {
	WebDriver driver;
	By eMail = By.cssSelector("#user_email");
	By sendMeInstruction = By.cssSelector("input[type='submit'");
	
	
	public ForgotPassword(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getEmail() {
		return driver.findElement(eMail);
	}
	public WebElement sendMeInstruction() {
		return driver.findElement(sendMeInstruction);
	}
	
}
