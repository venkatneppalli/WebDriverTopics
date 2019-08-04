package SeleniumGrid3;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;

public class NewTest {
	public WebDriver driver;
	@Test
	public void f() {
		driver.findElement(By.id("username")).sendKeys("seleniumtesting");
		driver.findElement(By.id("password")).sendKeys("password1");
		driver.findElement(By.id("login")).click();
	}

	@Parameters({ "BrowserName" })
	@BeforeTest
	public void beforeTest(String BrowserName) throws MalformedURLException {

		if (Constants.RunGrid) {
			System.out.println("its trues");
			if (BrowserName.equals("chrome")) {
				ChromeOptions options = new ChromeOptions();
				options.setCapability(CapabilityType.BROWSER_NAME, "chrome");
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
				driver.get("https://adactin.com/HotelApp/");
			} else if (BrowserName.equals("firefox")) {
				FirefoxOptions options = new FirefoxOptions();
				options.setCapability(CapabilityType.BROWSER_NAME, "firefox");
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
				driver.get("https://adactin.com/HotelApp/");
			}

		} 
		
		
		if(Constants.RunLocal){
			
			if (Constants.ChromeBrowser.equals("chrome")) {
					System.setProperty("webdriver.chrome.driver",
							"/Users/venkatneppalli/Documents/BrowserDriverVersions/chromedriver");
					driver = new ChromeDriver();
					driver.get("https://adactin.com/HotelApp/");
				} else if (Constants.FirefoxBrowser.equals("firefox")) {
					System.setProperty("webdriver.gecko.driver",
							"/Users/venkatneppalli/Documents/BrowserDriverVersions/geckodriver");
					driver = new FirefoxDriver();
					driver.get("https://adactin.com/HotelApp/");
				}
			}
		}
	

	@AfterTest
	public void afterTest() {
		driver.findElement(By.linkText("Logout")).click();
		driver.quit();
	}

}
