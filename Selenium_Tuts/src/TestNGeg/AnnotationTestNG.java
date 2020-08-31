package TestNGeg;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AnnotationTestNG {
	
	@BeforeSuite
	//Test case 1
	public void Webloan() {
		//Selenium
		System.out.println("Web1");
	}
	@Parameters({"URL"})
	@Test
	//Test case 2
	public void Mobileloan(String link) {
		//Appium
		System.out.println("Mobile1");
		System.out.println(link);
	}
	
	@Test
	//Test case 2
	public void APIloan() {
		//REST
		System.out.println("API1");
	}
	
}
