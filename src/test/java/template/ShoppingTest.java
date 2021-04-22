package template;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import driver.supplier.DriverFactory;
import srp.BaseTest;
import template.pattern.AmazonShopping;
import template.pattern.EBayShopping;
import template.pattern.ShoppingTemplate;

public class ShoppingTest {
	
	
	private WebDriver driver;
	
	
	@BeforeTest
	@Parameters("browser")
	public void getDriver(@Optional("chrome") String browser) {
		
		this.driver=DriverFactory.getDriver(browser);
		
	}

	@Test(dataProvider = "getData")
	public void shoppingTest(ShoppingTemplate shoppingTemplate) {
		
		shoppingTemplate.shop();
		
	}
	
	@DataProvider
	public Object[] getData() {
		
		return new Object[] {
				
				new AmazonShopping(driver, "samsung"),
				new EBayShopping(driver,"samsung")
				
		};
	}
	
	@AfterTest
	public void quitDriver() {
		this.driver.quit();
	}
}


