package single.responsibility.pattern;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.util.concurrent.Uninterruptibles;

public class SearchWidget extends AbstractComponent {

	@FindBy(name = "q")
	private WebElement searchBox;

	public SearchWidget(final WebDriver driver) {

		super(driver);

	}

	public void enter(String keyword) {

		this.searchBox.clear();
		for (char ch : keyword.toCharArray()) {
			Uninterruptibles.sleepUninterruptibly(30, TimeUnit.MILLISECONDS);
			this.searchBox.sendKeys(String.valueOf(ch));
		}

	}

	@Override
	public boolean isDisplayed() {

		return this.wait.until((d) -> this.searchBox.isDisplayed());
	}

}
