package Academy;

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

public class ValidateTitle extends Base{
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	public LandingPage lpage;
	
	@BeforeTest
	public void initialize() throws IOException {
		
		driver = initializeDriver();
		log.info("driver has been initialized in validatetitle class");
		driver.get(prop.getProperty("url"));

	}
	
	@Test
	public void getTitle() throws IOException {
		
	//	lpage = new LandingPage(driver);
	
		Assert.assertEquals(lpage.getTitle().getText(), "FEATURED COURSES..");
		log.info("successfully validated");
	}
	
	
	@Test
	public void getHeader()throws IOException {
	
		lpage = new LandingPage(driver);
		Assert.assertEquals(lpage.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		
	}
	
	
	
	 @AfterTest
		public void tearDown() {
			
			driver.close();
		}
		
	
}
