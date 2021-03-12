package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.ForgotPassword;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

public class HomePageNavigation extends Base{
	
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	//public static Logger log = LogManager.getLogger(Base.class.getName());

		@BeforeTest
		public void initialize() throws IOException {
			
			driver = initializeDriver();
			log.info("driver has been initialized in homepagenavigation class");

		}
	
	@Test(dataProvider = "getData")
	
	public void basePageNavigation(String email, String password) throws IOException {
	
		driver.get(prop.getProperty("url"));
		
		LandingPage lp =new LandingPage(driver);
		LoginPage login= lp.getLogin();
		
		login.getEmail().sendKeys(email);
		login.getPassword().sendKeys(password);
		login.submit().click();
		
		ForgotPassword fpswd=(ForgotPassword) login.forgotPassword();
		fpswd.getEmail().sendKeys("xxx");
		fpswd.sendMeInstruction().click();
		
		
		
		
	}
	  @DataProvider
	  public Object[][] getData() {
	  
	  
	  Object[][] data = new Object[2][2]; 
	  data[0][0] = "mailtosusmith@gmail.com";
	  data[0][1] ="chuchu123";
	  data[1][0] = "mailtoprasad@gmail.com";
	  data[1][1] ="prasad123";
	  
	  return data;
	  
	  }
	 
	  @AfterTest
	public void tearDown() {
		
		driver.close();
	}
	
	

}
