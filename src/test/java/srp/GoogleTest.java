package srp;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import single.responsibility.pattern.GoogleMainPage;
import single.responsibility.pattern.GoogleResultPage;

/*
 *  extend base test as driver is coming from base test
 * 
 */

public class GoogleTest extends BaseTest {

	private GoogleMainPage googleMainPage;
	private GoogleResultPage googleResultPage;

	@BeforeTest
	public void setUpPages() {
		this.googleMainPage = new GoogleMainPage(driver);
		this.googleResultPage = new GoogleResultPage(driver);

	}

	@Test(dataProvider = "getData" )
	public void googleWorkFlow(String keyword,int index) {
		
		//String keyword="selenium webdriver";
		//int index=3;
		
		googleMainPage.goTo();
		Assert.assertTrue(googleMainPage.getSearchWidget().isDisplayed());

		googleMainPage.getSearchWidget().enter(keyword);
		Assert.assertTrue(googleMainPage.getSearchSuggestion().isDisplayed());

		googleMainPage.getSearchSuggestion().clickSuggestionsByIndex(index);

		googleResultPage.getNavigationBar().goToNews();

		System.out.println(googleResultPage.getResultStat().getStat());

	}
	
	@DataProvider
	public Object[][] getData(){
		
		return new Object[][] {
			{"selenium",3},
			{"docker",2}
		};
	}

}
