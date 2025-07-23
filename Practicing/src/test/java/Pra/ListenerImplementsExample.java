package Pra;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementsExample implements ITestListener, ISuiteListener {

	

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Started "+result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" fail");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getMethod().getMethodName()+" skipped");
	}

//	@Override
//	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//		// TODO Auto-generated method stub
//		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
//	}
//
//	@Override
//	public void onTestFailedWithTimeout(ITestResult result) {
//		// TODO Auto-generated method stub
//		ITestListener.super.onTestFailedWithTimeout(result);
//	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Suite started");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Suite finished");
	}

	
	
}
