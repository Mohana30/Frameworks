package ComponentsPractice;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SelectRadioButton {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		// selectRadioButton(driver, "radio1");
		// selectRadioButton(driver, "radio2");
		// selectRadioButton(driver, "radio3");
		// selectAutoSuggestiveDropDown(driver, "Irel", "Ireland");
		// selectStaticDropDown(driver,"Option1");
		// selectCheckBox(driver,"checkBoxOption1");
		// openNewWindow(driver);
		// selectAlertButton(driver);
		verifyHideElement(driver);

	}

	public static void selectRadioButton(WebDriver driver, String sampleText) {

		Assert.assertFalse(driver.findElement(By.xpath("//input[@value='" + sampleText + "']")).isSelected());
		driver.findElement(By.xpath("//input[@value='" + sampleText + "']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='" + sampleText + "']")).isSelected());
	}

	public static void selectAutoSuggestiveDropDown(WebDriver driver, String autoCompleteText, String expectedResult) {
		driver.findElement(By.cssSelector("#autocomplete")).clear();
		driver.findElement(By.cssSelector("#autocomplete")).sendKeys(autoCompleteText);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-menu-item-wrapper")));
		try {
			driver.findElement(By.xpath("//div[text()='" + expectedResult + "' and @class='ui-menu-item-wrapper']"))
					.click();
		} catch (NoSuchElementException e) {
			System.out.println("Element not found in the auto suggestive drop down");
		}
	}

	public static void selectStaticDropDown(WebDriver driver, String ValuetobeSelected) {
		Select s = new Select(driver.findElement(By.cssSelector("#dropdown-class-example")));
		s.selectByVisibleText(ValuetobeSelected);
	}

	public static void selectCheckBox(WebDriver driver, String IDCheckBoxToBechoosen) {

		Assert.assertFalse(driver.findElement(By.cssSelector("#" + IDCheckBoxToBechoosen)).isSelected());
		driver.findElement(By.cssSelector("#" + IDCheckBoxToBechoosen)).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("#" + IDCheckBoxToBechoosen)).isSelected());

	}

	public static void openNewWindow(WebDriver driver) throws InterruptedException {

		// driver.findElement(By.cssSelector("#openwindow")).click();
		driver.findElement(By.id("opentab")).click();
		Thread.sleep(5000);
		String parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		String parentWindow = driver.getWindowHandle();
		Iterator<String> it = s.iterator();

		while (it.hasNext()) {
			String nextWindow = it.next();
			if (!parent.equals(nextWindow)) {
				driver.switchTo().window(nextWindow);
				System.out.println("Next window title : " + driver.switchTo().window(nextWindow).getTitle());
				driver.findElement(By.xpath("//a[text()='Mentorship']")).click();
				Thread.sleep(5000);
				driver.close();
			}
			driver.switchTo().window(parentWindow);
		}
	}

	public static void selectAlertButton(WebDriver driver) {
		driver.findElement(By.id("name")).sendKeys("Priya");
		driver.findElement(By.cssSelector("#alertbtn")).click();
		String alertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out
				.println("1. Alert captured and handled in selenium with the help of alert() \n text is:" + alertText);
		driver.findElement(By.id("confirmbtn")).click();
		alertText = driver.switchTo().alert().getText();
		driver.switchTo().alert().dismiss();
		System.out
				.println("2. Alert captured and handled in selenium with the help of alert() \n text is:" + alertText);
	}

	public static void verifyHideElement(WebDriver driver) {
		Assert.assertTrue(driver.findElement(By.id("displayed-text")).isDisplayed());
		driver.findElement(By.id("hide-textbox")).click();
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// driver.findElement(By.id("show-textbox")).click();
		driver.findElement(By.id("displayed-text")).click();
	}
}
