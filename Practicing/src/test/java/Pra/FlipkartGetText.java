package Pra;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FlipkartGetText {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		WebElement ele= driver.findElement(By.xpath("(//span[.='Fashion'])[1]"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.xpath("//a[.='All']")).click();
		WebElement ele2= driver.findElement(By.xpath("//span[contains(.,'Men')]"));
		Thread.sleep(3000);
		ele2.click();
		//act.moveToElement(ele2).perform();
		Thread.sleep(3000);
List<WebElement> elem= driver.findElements(By.xpath("//div[@class='jzpKY6']/div[@class='wZsanD']/a"));
for (WebElement w : elem) {
	String s= w.getText();
	System.out.println(s);
}
	}

}
