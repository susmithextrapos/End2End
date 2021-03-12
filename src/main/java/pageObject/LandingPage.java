package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	
	public WebDriver driver;
	
	
	private By signIn = By.cssSelector("a[href*='sign_in']");
	private By title = By.xpath("//h2[contains(text(),'Featured Courses')]");
	private By home = By.xpath("//a[contains(text(),'Home')]");
	private By header = By.cssSelector("div[class*=\"video-banner\"] h3");
	private By popUp =By.xpath("//button[contains(text(),'NO THANKS')]");
	
	
	public LandingPage(WebDriver driver) {

	this.driver= driver;
	}



	
	public int getPopUpSize() {
		return driver.findElements(popUp).size();
	}
	
	public WebElement getPopUp() {
		return driver.findElement(popUp);
	}
	public LoginPage getLogin() {
		
	driver.findElement(signIn).click();
	return new LoginPage(driver);
		}
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement getHome() {
		return driver.findElement(home);
	}
	
	
	public WebElement getHeader() {
		
		System.out.println("-----------------"+driver.findElement(header));
		return driver.findElement(header);
	}
	
}
