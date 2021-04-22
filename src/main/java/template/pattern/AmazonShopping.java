package template.pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import templatte.pages.AmazonProdcutDescription;
import templatte.pages.AmazonResultPage;
import templatte.pages.AmazonSearchPage;

public class AmazonShopping extends ShoppingTemplate {
	
	/*
	 *  This class is template , handling workflow.
	 *  This class delegate responsbility to different pages to get job done.
	 * 
	 */
	
		
	private WebDriver driver;
	private WebDriverWait  wait;
	private String product;
	
	private AmazonSearchPage amazonSearchPage;
	private AmazonResultPage amazonResultPage;
	private AmazonProdcutDescription amazonProdcutDescription;
	
	public AmazonShopping(WebDriver driver,String product) {
		
		this.driver=driver;
		this.product=product;
		this.amazonSearchPage=PageFactory.initElements(this.driver, AmazonSearchPage.class);
		this.amazonResultPage=PageFactory.initElements(this.driver, AmazonResultPage.class);
		this.amazonProdcutDescription=PageFactory.initElements(this.driver, AmazonProdcutDescription.class);
		
		
	}

	@Override
	public void openSite() {
		amazonSearchPage.openSite();
		
	}

	@Override
	public void searchProdcut() {
		amazonSearchPage.searchProdcut(this.product);
	
	}

	@Override
	public void selectProduct() {
		amazonResultPage.selectProduct();
	
	}

	@Override
	public void buy() {
		
		amazonProdcutDescription.buy();
	}
	
	
}

