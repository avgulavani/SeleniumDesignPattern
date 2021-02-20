package factory.pattern;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.openqa.selenium.WebDriver;


 public class GoogleFactory {
	
	/*
	 *  lamda expression (java 8)
	 *  Give me the driver i will return you respective page
	 *  ENG, HINDI are the constants hence declared as final static
	 *  
	 *  As language parameter which is passed is String we need to corosponding lambda expression 
	 *  string to lambda function mapping is done in MAP.Put
	 */
	
	
	private static final Function<WebDriver, GooglePage> ENG = (d) -> new GoogleEnglish(d);
	private static final Function<WebDriver, GooglePage> HINDI = (d) -> new GoogleHindi(d);
	private static final Function<WebDriver, GooglePage> MARATHI = (d) -> new GoogleMarathi(d);
	

	private static final Map<String,Function<WebDriver, GooglePage>> MAP=new HashMap<>();
	
	static {
		
		MAP.put("ENG", ENG);
		MAP.put("HINDI", HINDI);
		MAP.put("MARATHI", MARATHI);
	}
	
	public static GooglePage get(String language,WebDriver driver) {
		return MAP.get(language).apply(driver); // --> map.get will give lambda expression and apply will execute function.
	}
}
