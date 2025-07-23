package Pra;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap.KeySetView;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class MultipleWindowExample {

	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		// TODO Auto-generated method stub
      WebDriver driver=new ChromeDriver();
      
      driver.get("https://www.flipkart.com/");
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
      WebElement e= driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']"));
    		//  e.sendKeys("Samsung mobiles");
    		  
    		File ele_temp=  e.getScreenshotAs(OutputType.FILE);
    		File ele_dest=new File("./ScreenShot/kk.jpeg");
    		FileHandler.copy(ele_temp, ele_dest);
     Thread.sleep(6000);
//     TakesScreenshot ts=(TakesScreenshot) driver;
//     File temp_loc= ts.getScreenshotAs(OutputType.FILE);
//     File per_loc= new File("./ScreenShot/application.jpeg");
//     FileHandler.copy(temp_loc, per_loc);
     
     
     //WebElement ele2=
    		// driver.findElement(By.xpath("//a[@href='https://advertising.flipkart.com/?otracker=ch_vn_advertise_header']"));
//     JavascriptExecutor js=(JavascriptExecutor) driver;
//     js.executeScript("argument[0].click()", ele2);
     // Robot r=new Robot();
     // r.keyPress(KeyEvent.VK_ENTER);
     // r.keyRelease(KeyEvent.VK_ENTER);
    // WebElement ele1=
    	//	 driver.findElement(By.xpath("//img[@alt='Samsung 1200' and @loading='eager']")).click();
      
     //js.executescript("argument[0].click()", ele1);
//     Set<String> all_windows= driver.getWindowHandles();
//     System.out.println(all_windows);
//     for(String aw:all_windows)
//     {
//    	 if(driver.getTitle().contains("Samsung 1200"))
//    	 {
//    		 driver.switchTo().window(aw);
//    		WebElement ele1= driver.findElement(By.xpath("//button[.='Add to cart']"));
//    	Actions act=new Actions(driver);
//    	act.scrollToElement(ele1);
//    	ele1.click();
    	
    	// }
   //  }
   
	}

}
