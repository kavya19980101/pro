package Pra;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class TaskOnMyntra {
	
	@Test
	public void Tc01() throws InterruptedException, IOException
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		Actions act=new Actions(driver);
		List<WebElement> ele1= driver.findElements(By.xpath("//div[@class='desktop-navLink']"));
		for (int i = 0; i <=5; i++) {
			Thread.sleep(10000);
			WebElement ele= ele1.get(i);
			act.moveToElement(ele).perform();
			List<WebElement> list1=	driver.findElements(By.xpath("//li[@class='desktop-oddColumnContent']/ul/li/a|//li[@class='desktop-evenColumnContent desktop-oddColumnContent']/ul/li/a"));
			for (WebElement w : list1) {
				String values= w.getText();
				if(!values.isEmpty())
				{
				System.out.println(values);
				}
		}
		}
			
		
			WebElement ele2= driver.findElement(By.xpath("(//div[@class='desktop-navLink'])[7]"));
		act.moveToElement(ele2).perform();
		WebElement pho= driver.findElement(By.xpath("(//div[@class='desktop-newPaneContent'])"));
		
		File src= pho.getScreenshotAs(OutputType.FILE);
		File ds= new File("./ScreenShot/pho.jpg");
		FileHandler.copy(src, ds);
		
		}
@Test
public void Tc02() throws InterruptedException, AWTException
{//li[@class='product-base']/descendant::h3[@class='product-brand'][position() mod 3]
	ChromeOptions option=new ChromeOptions();
	option.addArguments("--disable-notifications");
	WebDriver driver=new ChromeDriver(option);
	
	driver.get("https://www.myntra.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	driver.findElement(By.xpath("(//div[@class='desktop-navLink'])[1]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys("shirts");
	Robot r=new Robot();
	r.keyPress(KeyEvent.VK_SPACE);
	r.keyRelease(KeyEvent.VK_SPACE);
	r.keyPress(KeyEvent.VK_DOWN);
	r.keyRelease(KeyEvent.VK_DOWN);
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	Thread.sleep(2000);
	List<WebElement> pro= driver.findElements(By.xpath("//li[@class='product-base']/descendant::h3[@class='product-brand'][position() mod 3]|//div[@class='product-price']/span"));
	for (WebElement w : pro) {
		System.out.println(w.getText());
		
	}
}
}
