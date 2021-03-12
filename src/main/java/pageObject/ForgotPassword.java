package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {

	WebDriver driver;
	By userName = By.xpath("//input[@id='user_email']");
	By sendMeInstruction = By.xpath("//*[@id=\"hero\"]/div/form/div[2]/input");
	
	public ForgotPassword(WebDriver driver) {

	this.driver = driver;
	
	}

public WebElement getEmail() {
		
		return driver.findElement(userName);
	}
	

public WebElement sendMeInstruction() {
	return driver.findElement(sendMeInstruction);
}
	
}
