package tekPyramidMock;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Flipkart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		 WebDriver driver=new ChromeDriver();
		   driver.manage().window().maximize();
		 driver.get("https://www.flipkart.com/");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	WebElement ele1=driver.findElement(By.xpath("(//div[.='Fashion'])[1]"));
	Actions a=new Actions(driver);
	Thread.sleep(2000);
	  a.moveToElement(ele1).perform();
	 WebElement ele2=	 driver.findElement(By.xpath("//a[@class='_1BJVlg _11MZbx']"));	  
	 Thread.sleep(2000); 
	 a.moveToElement(ele2).perform();
	  WebElement ele3=	 driver.findElement(By.xpath("(//a[@class='_3490ry'])[2]"));
  Thread.sleep(2000);
	  ele3.click();
	}

}
