package strategy.pattern;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PaymentScreen {

	private WebDriver driver;
	private UserInformation userinformation;
	private Order order;
	private PaymentOption paymentOption;
	

	public PaymentScreen(final WebDriver driver) {
		
		this.driver=driver;
		this.userinformation=PageFactory.initElements(driver, UserInformation.class);
		this.order=PageFactory.initElements(driver, Order.class);
	}
	
	public void goTo() {
		
		//https://-u.s3.amazonaws.com/ds/strategy.html
		
		this.driver.get("");
	}

	public UserInformation getUserinformation() {
		return userinformation;
	}

	public Order getOrder() {
		return order;
	}
	
	public void setPaymentOption(PaymentOption paymentOption) {
		this.paymentOption = paymentOption;
		PageFactory.initElements(driver, this.paymentOption);

	}
	
	public void pay(Map<String,String> paymentDetails) {    // payment option guy know how to pay
		this.paymentOption.enterPaymentInformation(paymentDetails);
	}

}
