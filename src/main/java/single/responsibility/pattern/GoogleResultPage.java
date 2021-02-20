package single.responsibility.pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/*
 * GoogleResultPage class is Page Object Class and not Component(SearchWidget,SearchSuggestion)
 * So we are not extending Abstract class
 * 
 * 	PageObject here is nothing but collection of component
 */

public class GoogleResultPage {

	// 4 Component classes

	private WebDriver driver;
	private SearchWidget searchWidget;
	private SearchSuggestion searchSuggestion;
	private NavigationBar navigationBar;
	private ResultStat resultStat;

	public GoogleResultPage(final WebDriver driver) {

		this.driver = driver;

		/*
		 * Use of below code is- PageFactory.initElements --> Create a new instance of
		 * passed class and give it to me
		 */

		this.searchWidget = PageFactory.initElements(driver, SearchWidget.class);
		this.searchSuggestion = PageFactory.initElements(driver, SearchSuggestion.class);
		this.navigationBar = PageFactory.initElements(driver, NavigationBar.class);
		this.resultStat = PageFactory.initElements(driver, ResultStat.class);
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

	public NavigationBar getNavigationBar() {
		return navigationBar;
	}

	public ResultStat getResultStat() {
		return resultStat;
	}
}
