import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ShadowRootCloseShadow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver=new ChromeDriver();
driver.get("https://demoapps.qspiders.com/ui/shadow?sublist=0");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
driver.findElement(By.xpath("//h1[.='Login']")).click();
Actions a=new Actions(driver);
a.sendKeys(Keys.TAB).perform();
a.sendKeys("Kavya").perform();

	}

}
