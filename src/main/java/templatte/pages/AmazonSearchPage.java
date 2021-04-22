package templatte.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonSearchPage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	

	@FindBy(id="twotabsearchtextbox")
	private WebElement searchBox;
	
	@FindBy(css="input.nav-input")
	private WebElement searchBtn;
	
	public AmazonSearchPage(WebDriver driver) {
		this.driver=driver;	
		this.wait=	new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	
	

	public void openSite() {
		
	this.driver.get("https://www.amazon.com");
		
	}

	
	public void searchProdcut(String product) {
		
		this.searchBox.sendKeys(product);
		this.searchBtn.click();
	}


}
