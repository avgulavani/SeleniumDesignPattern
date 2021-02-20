package factory.pattern;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

 class GoogleHindi extends GoogleEnglish {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(css="//*[@id=\"SIvCob\"]/a[4]")
	private WebElement langugae;
	
	@FindBy(name="q")
	private WebElement searchbox;
	
	@FindBy(name="btnk")
	private WebElement searchBtn;
	
	@FindBy(css="div.rc")
	private List<WebElement> results;
	
	public GoogleHindi(WebDriver driver) {
		super(driver);
	}	

	@Override
	public void launchSite() {	
		this.driver.get("https://www.google.com");
		this.langugae.click();
	}

}
