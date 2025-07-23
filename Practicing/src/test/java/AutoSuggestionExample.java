import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;


public class AutoSuggestionExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/");
		WebElement ele1=driver.findElement(By.id("small-searchterms"));
		//fluent wait
		FluentWait wait=new FluentWait(driver);
		wait.pollingEvery(Duration.ofSeconds(1));
		wait.withTimeout(Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(ele1));
		ele1.sendKeys("Kavya");
		driver.findElement(By.xpath("(//a[contains(.,'Build your own computer')])[1]")).click();

	}

}
