package TestNGeg;

import org.testng.annotations.Test;

public class AnnotationTestNG2 {
	
	@Test
	//Test case 1
	public void Weblogin() {
		//Selenium
		System.out.println("Web2");
	}
	
	@Test
	//Test case 2
	public void Mobilelogin() {
		//Appium
		System.out.println("Mobile2");
	}
	
	@Test
	//Test case 2
	public void APIlogin() {
		//REST
		System.out.println("API2");
	}
	
}
