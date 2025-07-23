package Pra;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class NotificationPopupExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
WebDriver driver=new ChromeDriver(options);
driver.get("https://www.easemytrip.com/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
Actions act=new Actions(driver);
act.scrollToElement(driver.findElement
		(By.xpath("//a[.='  View All Offers']"))).build().perform();

	}

}
