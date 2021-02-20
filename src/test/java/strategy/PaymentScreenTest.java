package strategy;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Maps;

import com.google.common.util.concurrent.Uninterruptibles;

import srp.BaseTest;
import strategy.pattern.CreditCard;
import strategy.pattern.NetBanking;
import strategy.pattern.PaymentOption;
import strategy.pattern.PaymentOptionFactory;
import strategy.pattern.PaymentScreen;

public class PaymentScreenTest extends BaseTest {
	
	// instance of paymentscreen
	
	private PaymentScreen paymentScreen;
	
	@BeforeTest
	public void setPaymentScreen() {
		this.paymentScreen=new PaymentScreen(this.driver);
	}
	
	@Test(dataProvider = "getData")
	
	//** Strategy Patter **
	//some one will provide payment option
	
	//public void paymentTest(PaymentOption paymentOption, Map <String,String> paymentDetails ) { 
	
	//** Factory Pattern **
	
	public void paymentTest(String option, Map <String,String> paymentDetails ) { 
		this.paymentScreen.goTo();
		this.paymentScreen.getUserinformation().enterDetails("test1", "test2", "abc@abc.com");
		//** Strategy Patter **
		//this.paymentScreen.setPaymentOption(paymentOption);	
		
		//** Factory Pattern **
		this.paymentScreen.setPaymentOption(PaymentOptionFactory.get(option));	
		this.paymentScreen.pay(paymentDetails);
		String ordernumber=this.paymentScreen.getOrder().placeOrder();
		System.out.println("Order numbber is "+ordernumber);
		
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);		
		
		//-->  why sometimes here set and get payment option can't we use directly? reason is chances are payment option is not initilized
		//this.paymentScreen.getPaymentOption();
				
	}
	
	@DataProvider
	public Object[][] getData(){
		
		Map<String,String> cc= Maps.newHashMap(); //testng method
				cc.put("cc", "12345678");
				cc.put("year", "2021");
				cc.put("cvv", "123");
				
		Map<String,String> nb= Maps.newHashMap(); //testng method
				nb.put("bank", "WELLS FARGO");
				nb.put("account", "myaccount123");
				nb.put("pin", "999");
		
				/*   -->  Strategy method  
				 * 
			return new Object[][] {
				{new CreditCard(),cc},
				{new NetBanking(),nb}
		};*/
		
		return new Object[][] {
			{"CC",cc},
			{"NB",nb}
	};
	}
}
