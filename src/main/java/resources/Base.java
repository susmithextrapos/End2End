package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		
		
		String filePath = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties";
		
		prop = new Properties();
		FileInputStream fin = new FileInputStream(filePath);
		prop.load(fin);
		
		//String browserName = System.getProperty("browser"); // from maven
		String browserName = prop.getProperty("browser"); //from property
		
		
		if(browserName.contains("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Susmith\\Downloads\\chromedriver_win32 (6)\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if (browserName.contains("headless")) {
				options.addArguments("--headless");
				
			}
			
			driver = new ChromeDriver(options);
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\testing\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			driver =new FirefoxDriver();
		}
		else {
			
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}

	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot tc = (TakesScreenshot) driver;
		File source = tc.getScreenshotAs(OutputType.FILE);
		String destinationFile =System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
	
}
