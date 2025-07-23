package tekPyramidMock;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CandyMapper {
public static void main(String[] args) throws InterruptedException {
	 WebDriver driver=new ChromeDriver();
	   driver.manage().window().maximize();
	   driver.get("https://candymapper.com/");
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	   
	  
	 driver.findElement(By.id("popup-widget307423-close-icon")).click();
	driver.navigate().refresh();
	  Thread.sleep(3000);
	 
	 // driver.findElement(By.xpath("//img[@id='logo-307302']")).click();
	  String tit=driver.getTitle();
	  System.out.println();
	  Thread.sleep(3000);
 // WebElement ele2= driver.findElement(By.xpath("//select[@id='tCounty']"));
//  Select s=new Select(ele2);
//  s.
  if(tit.contains("CandyMapper.Com")) {
 Actions a=new Actions(driver);
	  a.scrollByAmount(0, 1300).perform();
	 // WebElement ele3= driver.findElement(By.xpath("//iframe[@id='iframe-undefined11']"));
	
	  driver.switchTo().frame(1);
	  WebElement ele2= driver.findElement(By.id("tCounty"));
	 // driver.findElement(By.xpath("//option[.='Select a County']")).click();
	  Select s=new Select(ele2);
	  s.selectByVisibleText("Avon");
  }
}
}
