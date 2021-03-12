package pageObject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.Base;

public class LoginPage extends Base{

	WebDriver driver;
	
	By userName = By.xpath("//input[@id='user_email']");
	By password = By.xpath("//input[@id='user_password']");
	By submit = By.xpath("//*[@id=\"hero\"]/div/form/div[3]/input");
	By forgotpswd = By.cssSelector("a[href*=\"password/new\"]");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	
	}

	public WebElement getEmail() {
		
		return driver.findElement(userName);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement submit() {
		return driver.findElement(submit);
	}
	
	public ForgotPassword forgotPassword() {
		driver.findElement(forgotpswd).click();
		return new ForgotPassword(driver);
	}
	
}
