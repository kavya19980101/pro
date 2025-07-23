package Pra;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassKeyUpAndKeyDownExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebElement ele1= driver.findElement(By.name("username"));
		Actions act=new Actions(driver);
		act.moveToElement(ele1).click().keyDown(Keys.SHIFT)
		.sendKeys("kavya").keyUp(Keys.SHIFT).perform();
		WebElement ele2= driver.findElement(By.xpath("//input[@placeholder='Password']"));
	act.moveToElement(ele2).click().keyDown(Keys.SHIFT).sendKeys("kavya").
	keyUp(Keys.SHIFT).perform();
	}

}
