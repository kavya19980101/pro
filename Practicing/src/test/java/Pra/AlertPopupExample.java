package Pra;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopupExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
   WebDriver driver=new ChromeDriver();
   driver.get("https://demowebshop.tricentis.com/");
   driver.manage().window().maximize();
   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
   driver.findElement(By.xpath("//input[@type='submit']")).click();
   Alert a= driver.switchTo().alert();
   Thread.sleep(4000);
   a.accept();
	}

}
