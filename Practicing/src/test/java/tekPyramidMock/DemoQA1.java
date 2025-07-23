package tekPyramidMock;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class DemoQA1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
   WebDriver driver=new ChromeDriver();
   driver.manage().window().maximize();
   driver.get("https://demoqa.com");
   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    
//Thread.sleep(2000);
    Actions a=new Actions(driver);
  a.scrollByAmount(0,300).perform();
  WebElement ele1= driver.findElement(By.xpath("(//*[local-name()='svg'])[3]"));
  ele1.click();
  Thread.sleep(2000);
  
  WebElement ele2= driver.findElement(By.xpath("(//div[@class='header-text'])[3]"));
   //ele2.click();
 
 
  // driver.findElement(By.xpath("//div[.='Alerts, Frame & Windows']")).click();
   WebElement ele3=  driver.findElement(By.xpath("//span[.='Browser Windows']"));
   //ele3.click();
 
    
    JavascriptExecutor js=(JavascriptExecutor) driver;
 js.executeScript("arguments[0].click();", ele3);
 a.scrollByAmount(0,300).perform();
 driver.findElement(By.id("messageWindowButton")).click();
 String s=driver.getWindowHandle();
 
 Set<String> s2=driver.getWindowHandles();
 
 s2.remove(s);
 for(String e:s2)
 {
	
	 
		 driver.switchTo().window(e);
		 WebElement ele4=  driver.findElement(By.tagName("body"));
		 Thread.sleep(4000);
		 System.out.println(ele4.getText());
		
	 
 }

 
	}

}
