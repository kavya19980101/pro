package Pra;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class WorkingWithRelativeLocators {
	
	
   public static void main(String[] args) {
	
	   WebDriver driver=new ChromeDriver();
	   driver.get("https://demowebshop.tricentis.com/");
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	   //to leftof() example
//	   driver.findElement(RelativeLocator.with(By.tagName("input"))
//			   .toLeftOf(By.xpath("//input[@type='submit']"))).sendKeys("mobile");
//       //to rightof() example
//	   driver.findElement(RelativeLocator.with(By.tagName("input"))
//			   .toRightOf(By.id("small-searchterms"))).click();
	   
	   //above() example
	   driver.findElement(RelativeLocator.with(By.name("pollanswers-1"))
			   .above(By.xpath("//label[.='Good']"))).click();
	   //below() example
	   driver.findElement(RelativeLocator.with(By.name("pollanswers-1"))
			   .below(By.xpath("//label[.='Excellent']"))).click();
	   
	   //near() example
	   driver.findElement(RelativeLocator.with(By.xpath("//a"))
			   .near(By.xpath("//a[.='Register']"))).click();
	   
   driver.close();
   }
}
