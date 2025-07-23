package Pra;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class CreateContactWithExtentReport {
	
	@Test
	public void createContact()
	{
		//In order to setup and configure the reports
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvancedReport/report.html");
		spark.config().setDocumentTitle("CRM test Suite Resuls");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//In order to add Environment information and create test
		ExtentReports report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Window-11");
		report.setSystemInfo("Browser", "Chrome");
		
		//in order add log details
		ExtentTest test=report.createTest("Create Contact");
		WebDriver driver=new ChromeDriver();
		driver.get("http://49.249.28.218:8888/");
		test.log(Status.INFO, "Login to application");
		test.log(Status.INFO, "Navigate to Contact Page");
		if("HDDFC".equals("HDFC"))
		{
			test.log(Status.PASS, "Contact is created");
		}
		else
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
		String path=	ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(path, "Error file");
			test.log(Status.FAIL,"Contact is not created");
		}
		report.flush();
		
		driver.close();
	}

}
