package Practice;

import org.testng.ITestListener;
import org.testng.ITestResult;

import GenericUtilities.JavaUtility;
import GenericUtilities.SeleniumUtility;

public class ListenersDemo implements ITestListener {

	
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName()+"test is passed");
	}

	
	public void onTestFailure(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println(result.getName()+"test is failed");
		SeleniumUtility SUTIL=new SeleniumUtility();
		JavaUtility JUTIL=new JavaUtility();
		String screeenShotName=methodName+"-"+JUTIL.getSystemDate();
		try
		{
			SUTIL.takingScreenShot(Demo.driver, screeenShotName);
			
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
	}

	
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getName()+"test is skipped");
	}

	
	

}
