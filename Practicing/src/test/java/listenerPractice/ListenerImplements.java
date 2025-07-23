package listenerPractice;

import java.util.Date;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplements implements ITestListener, ISuiteListener{

	
	ExtentSparkReporter spark;
	ExtentReports report;
	ExtentTest test;
	public ThreadLocal<ExtentTest> extenttest=new ThreadLocal<ExtentTest>(); 
	
	@Override
	public void onStart(ITestContext context) {
	System.out.println("On start");
	System.out.println("Report configuration");
	String date=new Date().toString().replace(" ", "_").replace(":","_");
 spark=new ExtentSparkReporter("./Reporter/reports"+date+".html");
 
	spark.config().setDocumentTitle("CRM tes Suite result");
	spark.config().setReportName("CRM Report");
	spark.config().setTheme(Theme.DARK);
	
	report=new ExtentReports();
	report.attachReporter(spark);
	report.setSystemInfo("OS","Window11");
	report.setSystemInfo("Browser", "Chrome");
	
	
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("On finish");
		System.out.println("Report backup");
		report.flush();
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Iam test OnStart");
		test=report.createTest(result.getMethod().getMethodName());
		extenttest.set(test);
		extenttest.get().log(Status.INFO, result.getMethod().getMethodName()+"=======Started=======");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extenttest.get().log(Status.PASS, result.getMethod().getMethodName()+"=======Completed=======");
		System.out.println("Iam OnTestSucess");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Iam On Test Failure");
		extenttest.get().log(Status.FAIL, result.getMethod().getMethodName()+"=======failed=======");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	System.out.println("Iam on test skipped");
	extenttest.get().log(Status.SKIP, result.getMethod().getMethodName()+"=======Skipped=======");
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println(result.getMethod().getMethodName());
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println(result.getMethod().getMethodName());
	}

	@Override
	public void onStart(ISuite suite) {
		System.out.println("Iam osuite on start");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Iam osuite on start");
	}

	


}
