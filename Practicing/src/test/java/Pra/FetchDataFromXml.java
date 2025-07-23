package Pra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class FetchDataFromXml {

	@Test
	public void test(XmlTest test)
	{
		String browser=test.getParameter("browser");
		String URL=test.getParameter("url");
		WebDriver driver;
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if (browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		driver.get(URL);
	}
}
