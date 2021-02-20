package demand;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import command.pattern.ElementValidator;
import command.pattern.HomePage;
import srp.BaseTest;

public class HomePageTest extends BaseTest {
	
	private HomePage homepage;
	
	@BeforeTest
	public void setHomePage() {
		this.homepage=new HomePage(driver);

	}
	
	@Test
	public void homePageTest() {
		
		this.homepage.goTo();
		this.homepage.getElementValidators()
		.stream()
		.parallel()    // -> Java 8 cool feature to improve performance . IF there are multiple elements we can use this. Java  will create thread.
		.map(ev-> ev.validate())
		.forEach(b->Assert.assertTrue(b));
		
	}
	
	// Data Provide example 
	
/*
	
	@Test(dataProvider = "getData", dependsOnMethods = "goTo")
    public void homePageTest(ElementValidator elementValidator){
        Assert.assertTrue(elementValidator.validate());
    }
 
    @DataProvider
    public Object[] getData(){
        return this.homePage.getElementValidators()
                            .toArray();
    }
*/
	
}
