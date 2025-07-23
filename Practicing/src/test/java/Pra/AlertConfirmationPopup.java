package Pra;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertConfirmationPopup {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriver driver=new ChromeDriver();
driver.get("https://demo.guru99.com/test/delete_customer.php");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
driver.findElement(By.name("cusid")).sendKeys("4321");
driver.findElement(By.name("submit")).click();
Thread.sleep(4000);
driver.switchTo().alert().dismiss();
	}

}
