package GenericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ListenersImplementation implements ITestListener {

	ExtentReports report;
	ExtentTest test;
	public void onTestStart(ITestResult result) {
		
		String methodName=result.getMethod().getMethodName();
		System.out.println("----test started----");
		test=report.createTest(methodName);
	}

	
	public void onTestSuccess(ITestResult result) {
	 String methodName=result.getMethod().getMethodName();
	 System.out.println("----test pass----");
	 test.log(Status.PASS,methodName);
	}

	
	public void onTestFailure(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println("----test fail----");
		test.log(Status.FAIL, methodName);
		test.log(Status.INFO,result.getThrowable());
	}


	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println("----test skip----");
		test.log(Status.SKIP,methodName);
		test.log(Status.INFO,result.getThrowable());
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	
	public void onStart(ITestContext context) {
		System.out.println("----suite execution started----");
	}

	
	public void onFinish(ITestContext context) {
		System.out.println("-----suite execution finished");
	}
	

}
