import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoSuggestionWithDisapperDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver=new ChromeDriver();
//implicit wait
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
driver.get("https://www.flipkart.com/");
driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).sendKeys("laptop");
WebElement dd2= driver.findElement(By.xpath("(//div[.='in Laptops'])[1]"));
//explicit wait
WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
wait.until(ExpectedConditions.visibilityOf(dd2));
dd2.click();

	}

}
