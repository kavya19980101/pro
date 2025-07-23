package Pra;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KsrtcInspectExample {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://ksrtc.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	Actions a=new Actions(driver);
		a.scrollByAmount(0,300).perform();
		Thread.sleep(2000);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		 WebElement departure= driver.findElement(By.xpath("(//div[@class='input-bottom-box'])[1]"));
		 wait.until(ExpectedConditions.visibilityOf(departure));
		 departure.click();
		 WebElement cityinput= driver.findElement(By.xpath("(//input[@placeholder='Search Your City Name' and @type='text'])[1]"));
		 wait.until(ExpectedConditions.visibilityOf(cityinput));
		cityinput.sendKeys("Bangalore");
		 Robot r=new Robot();
		 r.keyPress(KeyEvent.VK_ENTER);
		 r.keyRelease(KeyEvent.VK_ENTER);
		 
		 WebElement going= driver.findElement(By.xpath("(//div[@class='input-bottom-box'])[2]"));
		 wait.until(ExpectedConditions.visibilityOf(going));
		 going.click();
		 WebElement citygoinginput= driver.findElement(By.xpath("(//input[@placeholder='Search Your City Name' and @type='text'])[2]"));
		 wait.until(ExpectedConditions.visibilityOf(citygoinginput));
		 citygoinginput.sendKeys("mysore");
		 r.keyPress(KeyEvent.VK_ENTER);
		 r.keyRelease(KeyEvent.VK_ENTER);
		 WebElement date1= driver.findElement(By.xpath("(//div[@class='input-right-box'])[1]"));
		 wait.until(ExpectedConditions.visibilityOf(date1));
		 date1.click();
		for (int i = 0; i < 12; i++) {
			try {
				WebElement date_to=driver.findElement(By.xpath("//td[@data-handler='selectDay' and @data-month='7' and @data-year='2025']/a[.='8']"));
				wait.until(ExpectedConditions.visibilityOf(date_to));
				 date_to.click();
				 break;
			}
			catch (Exception e) {
				WebElement next= driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']"));
				wait.until(ExpectedConditions.visibilityOf(next));
				next.click();
			}
		}
		
	}
}
