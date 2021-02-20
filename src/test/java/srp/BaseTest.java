package srp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.google.common.util.concurrent.Uninterruptibles;

public class BaseTest {
	
	
		protected WebDriverWait wait;
		protected WebDriver driver;
		
		@BeforeTest
		public void setUpDriver() {
			System.setProperty("webdriver.chrome.driver", "/Users/a.vitthal.gulavani/Downloads/chromedriver");
			this.driver=new ChromeDriver();
		}
		
		@AfterTest
		public void quitDriver() {
			Uninterruptibles.sleepUninterruptibly(15, TimeUnit.SECONDS);
			this.driver.quit();
		}
}
