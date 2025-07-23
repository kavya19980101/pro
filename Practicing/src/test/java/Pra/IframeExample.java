package Pra;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeExample {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/Users/Kaviya%20S/Downloads/FrameExample.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='frame1']")));
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("laptop");
		Thread.sleep(4000);
		driver.switchTo().defaultContent();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[.='Google link']")).click();
		
	}

}
