package template.pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EBayShopping extends ShoppingTemplate {
	
		
	private WebDriver driver;
	private WebDriverWait  wait;
	private String product;
	
	public EBayShopping(WebDriver driver,String product) {
		
		this.driver=driver;
		this.product=product;
		this.wait=new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="gh-ac")
	private WebElement searchBox;
	
	@FindBy(id="gh-btn")
	private WebElement searchBtn;
	
	@FindBy(css="div.s-item_info a")
	private WebElement item;
	
	@FindBy(id="prcIsum")
	private WebElement price;
	

	@Override
	public void openSite() {
		
	this.driver.get("https://www.ebay.com");
		
	}

	@Override
	public void searchProdcut() {
		
		this.searchBox.sendKeys(this.product);
		this.searchBtn.click();
	}

	@Override
	public void selectProduct() {
		
		this.wait.until(a->this.item.isDisplayed());
		this.item.click();
	
	}

	@Override
	public void buy() {
		
	this.wait.until(d->this.price.isDisplayed());
	System.out.println();
	this.item.getText();	
		
	}

	
}
