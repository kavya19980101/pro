import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class ShadowRootElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver=new ChromeDriver();
driver.get("https://demoapps.qspiders.com/ui/shadow?sublist=0");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
SearchContext shadowhost=driver.findElement(By.xpath("//form/div[1]")).getShadowRoot();

shadowhost.findElement(By.cssSelector("input[type='text']")).sendKeys("Kavya");
	}

}
