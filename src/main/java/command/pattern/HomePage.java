package command.pattern;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	private final WebDriver dirver;
	
	@FindBy(css="div.button-box button.btn-info")
	private WebElement infoBtn;
	
	@FindBy(css="div.button-box button.btn-warning")
	private WebElement warnBtn;
	
	@FindBy(css="div.button-box button.btn-success")
	private WebElement successBtn;
	
	@FindBy(css="div.button-box button.btn-danger")
	private WebElement dangerBtn;
	
	//notifications alert
	
	@FindBy(css="div.jq-icon-info")
	private WebElement infoAlert;
	
	@FindBy(css="div.jq-icon-warning")
	private WebElement warnAlert;
	
	@FindBy(css="div.jq-icon-success")
	private WebElement successAlert;
	
	@FindBy(css="div.jq-icon-error")
	private WebElement dangerAlert;
	
	//dismissal alert

	@FindBy(css="div.card-body div.row div:nth-child(2) div.alert-info")
	private WebElement dismissInfoAlert;
	
	@FindBy(css="div.card-body div.row div:nth-child(2) div.alert-success")
	private WebElement dismisSuccessAlert;
	
	@FindBy(css="div.card-body div.row div:nth-child(2) div.alert-danger")
	private WebElement dismisDangerAlert;
	
	@FindBy(css="div.card-body div.row div:nth-child(2) div.alert-warning")
	private WebElement dismissWarningAlert;
	
	
	public HomePage(final WebDriver driver) {
		
		this.dirver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void goTo() {
		this.dirver.get("https://wrappixel.com/demos/admin-templates/admin-pro/main/ui-notification.html");
	}
	
	public List<ElementValidator> getElementValidators(){
		return Arrays.asList(
				
				// notification validation
				new NotificationValidator(infoBtn, infoAlert),
				new NotificationValidator(successBtn, successAlert),
				new NotificationValidator(warnBtn, warnAlert),
				new NotificationValidator(dangerBtn, dangerAlert),
				
				//dismiss valiadtion
				new DismissalAlertValidator(dismissInfoAlert),
				new DismissalAlertValidator(dismisSuccessAlert),
				new DismissalAlertValidator(dismissWarningAlert),
				new DismissalAlertValidator(dismisDangerAlert)

				);
	}


}
	