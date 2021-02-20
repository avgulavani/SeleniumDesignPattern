package factory;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import factory.pattern.GoogleFactory;
import factory.pattern.GooglePage;
import single.responsibility.pattern.GoogleMainPage;
import single.responsibility.pattern.GoogleResultPage;
import srp.BaseTest;

/*
 *  extend base test as driver is coming from base test
 * 
 */

public class GoogleSearchTest extends BaseTest {

	private GooglePage googlePage;
	

	@Test(dataProvider = "getData" )
	public void searchTest(String language,String keyword ) {
		
		/*
		 *  Here- hey google factory i will give you language and driver and pl give me corrosponding implementation
		 *  google factory is like a dealer give me lang and driver i will give you specific method      
		 *  not caring about how object is build
		 *   
		 *   so here this class doesn't care of car type just give me specification and i will return required car for you
		 *   
		 */
		
		this.googlePage=GoogleFactory.get(language, this.driver);
		this.googlePage.launchSite();
		this.googlePage.search(keyword);
		int resultcount=this.googlePage.getResultCount();
		
		System.out.println("Result Count is " +resultcount);
		
	}
	
	@DataProvider
	public Object[][] getData(){
		
		return new Object[][] {
			{"ENG","Selenium"},
			{"HINDI","design patterns"},
			{"MARATHI","docker"}
		};
	}

}
