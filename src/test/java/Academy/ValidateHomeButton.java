package Academy;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import resources.Base;

public class ValidateHomeButton extends Base {

	public static Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException {
		
		driver = initializeDriver();
		log.info("driver has been initialized in validateHome class");
		driver.get(prop.getProperty("url"));

		
	}
	
	
	
	@Test
	public void validateHome() throws IOException {
	
		LandingPage lpage = new LandingPage(driver);
		//assertTrue(lpage.getHome().isDisplayed());
		Assert.assertTrue(lpage.getHome().isDisplayed());
		log.info("home link is validated");
	}
	
	 @AfterTest
		public void tearDown() {
			
			driver.close();
		}
		
	
	
}
