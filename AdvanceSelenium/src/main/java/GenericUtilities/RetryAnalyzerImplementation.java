package GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/**
 * This class provides imlementation to IretryAnalyzer interface of testNG
 * @author LENOVO
 *
 */

public class RetryAnalyzerImplementation implements IRetryAnalyzer {

	int  count=0;
	int retryCount=3;//based on manual analysis
	public boolean retry(ITestResult result) {
		while(count<retryCount)
		{
			count++;
			return true;// retry
		}
		return false;//stop retry
	}

}
