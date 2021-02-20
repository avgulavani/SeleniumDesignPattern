package single.responsibility.pattern;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchSuggestion extends AbstractComponent {
	
	@FindBy(css="li.sbct")
	
	private List<WebElement> suggestions;
	
	
	public SearchSuggestion(final WebDriver driver) {
		
		super(driver);
	}
	
	public void clickSuggestionsByIndex(int index) {
		
		this.suggestions.get(index-1).click();;
	}
	
	@Override
	public boolean isDisplayed() {
		
		return this.wait.until((d)-> this.suggestions.size()>5);
		
	}
	

}
