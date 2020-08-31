package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;

	By login = By.cssSelector("a[href*='sign_in']");
	By featuredCourses = By.xpath("//h2[text()='Featured Courses']");
	By NavigationCourseTab = By.xpath("//a[text()='Courses']");
	By NavigationHomeTab = By.xpath("//a[text()='Home']");
	By NavigationVideosTab = By.xpath("//a[text()='Videos']");
	By NavigationInterviewGuideTab = By.xpath("//a[text()='Interview Guide']");
	By NavigationPracticeTab = By.xpath("//a[text()='Practice']");
	By NavigationBlogTab = By.xpath("//a[text()='Blog']");
	By NavigationAboutTab = By.xpath("//a[text()='About']");
	By NavigationContactTab = By.xpath("//a[text()='Contact']");
	By SubscribePopUp = By.className("sumome-react-svg-image-container");
	
	
	public LandingPage(WebDriver driver){
		this.driver = driver;
	}	
	public LoginPage getLogin(){
		driver.findElement(login).click();
		LoginPage login = new LoginPage(driver);
		return login;
	}
	public WebElement getFearuredCourses(){
		return driver.findElement(featuredCourses);
	}
	public WebElement getNavCoursesTab(){
		return driver.findElement(NavigationCourseTab);
	}
	public WebElement getNavHomeTab(){
		return driver.findElement(NavigationHomeTab);
	}
	public WebElement getNavVideosTab(){
		return driver.findElement(NavigationVideosTab);
	}
	public WebElement getNavInterviewGuideTab(){
		return driver.findElement(NavigationInterviewGuideTab);
	}
	public WebElement getNavPracticeTab(){
		return driver.findElement(NavigationPracticeTab);
	}
	public WebElement getNavBlogTab(){
		return driver.findElement(NavigationBlogTab);
	}
	public WebElement getNavAboutTab(){
		return driver.findElement(NavigationAboutTab);
	}
	public WebElement getNavContactTab(){
		return driver.findElement(NavigationContactTab);
	}
	public WebElement closeSubscribePopUp(){
		return driver.findElement(SubscribePopUp);
	}
	
}
