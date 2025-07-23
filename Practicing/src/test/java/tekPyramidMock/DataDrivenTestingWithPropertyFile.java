package tekPyramidMock;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DataDrivenTestingWithPropertyFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("./CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String browser=p.getProperty("browser");
		String URL=p.getProperty("url");
		String username=p.getProperty("usn");
		String password=p.getProperty("password");
		String seachfor=p.getProperty("seachfor");
		WebDriver driver=null;
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		//driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(seachfor);
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	}

}
