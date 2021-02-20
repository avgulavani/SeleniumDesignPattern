package single.responsibility.pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/*
 * GoogleMainPage class is Page Object Class and not Component (SearchWidget,SearchSuggestion)
 * So we are not extending Abstract class
 */

public class GoogleMainPage {

	private WebDriver driver;
	private SearchWidget searchWidget;
	private SearchSuggestion searchSuggestion;
	public GoogleMainPage(final WebDriver driver) {

		this.driver = driver;

		/*
		 * Use of below code is- PageFactory.initElements --> Create a new instance of
		 * passed class and give it to me
		 */

		this.searchWidget = PageFactory.initElements(driver, SearchWidget.class);
		this.searchSuggestion = PageFactory.initElements(driver, SearchSuggestion.class);
	}

	public void goTo() {
		this.driver.get("https://www.google.com");
	}

	public SearchWidget getSearchWidget() {
		return searchWidget;
	}

	public SearchSuggestion getSearchSuggestion() {
		return searchSuggestion;
	}
}
