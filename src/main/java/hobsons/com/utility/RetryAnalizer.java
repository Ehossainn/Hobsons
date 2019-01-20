package hobsons.com.utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalizer implements IRetryAnalyzer {
	
	int defaultLimit = 0;
	int retryLimit = 2;
	public boolean retry(ITestResult result) {
		if(defaultLimit<retryLimit) {
			defaultLimit++;
			return true;
		}
		return false;
	}

}
