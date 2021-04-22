package driver.supplier;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

	private static final Supplier<WebDriver> chromeSupplier = () -> {

		System.setProperty("webdriver.chrome.driver", "");
		return new ChromeDriver();

	};

	private static final Map<String, Supplier<WebDriver>> MAP = new HashMap<>();

	static {

		MAP.put("chrome", chromeSupplier);
	}

	public static WebDriver getDriver(String browser) {

		return MAP.get(browser).get();

	}

}
