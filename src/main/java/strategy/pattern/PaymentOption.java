package strategy.pattern;

import java.util.Map;

public interface PaymentOption {
	
	void enterPaymentInformation(Map<String,String> paymentDetails);

}
