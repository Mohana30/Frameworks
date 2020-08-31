package Selenium_Tuts1;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HandleTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/29079/2nd-test-pakistan-tour-of-england-2020");
		WebElement ele = driver.findElement(By.xpath("//span[text()='Pakistan 1st Innings']/parent::div/parent::div"));
		int sizeEle = ele.findElements(By.cssSelector(".cb-col.cb-col-100.cb-scrd-itms div:nth-child(3)")).size();
		int sum=0;
		for (int i = 0; i < sizeEle-2; i++) {
			String rank = ele.findElements(By.cssSelector(".cb-col.cb-col-100.cb-scrd-itms div:nth-child(3)")).get(i).getText();	
			sum = sum+Integer.parseInt(rank);
		}
		String extras = driver.findElement(By.xpath("//span[text()='Pakistan 1st Innings']/parent::div/parent::div//div[text()='Extras']/following-sibling::div")).getText();
		sum = sum+Integer.parseInt(extras);
		String total = ele.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
		int Total = Integer.parseInt(total);
		Assert.assertEquals(Total, sum);
		
	}

}
