package Pra;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoibiboExample {

	public static void main(String[] args) throws InterruptedException, AWTException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.goibibo.com/");
		WebElement ele1= driver.findElement(By.xpath("//span[@class='logSprite icClose']"));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		wait.until(ExpectedConditions.visibilityOf(ele1));
		//js.executeScript("argumens[0].click();", ele1);
		ele1.click();
		WebElement ele2=driver.findElement(By.xpath("//p[@class='sc-jlwm9r-1 ewETUe']"));
		wait.until(ExpectedConditions.visibilityOf(ele2));
		js.executeScript("arguments[0].click();", ele2);
		
		WebElement from= driver.findElement(By.xpath("//div[@class='sc-12foipm-2 eTBlJr fswFld ']/span[.='From']/../p"));
		wait.until(ExpectedConditions.visibilityOf(from));
		js.executeScript("arguments[0].click();",from);
		Thread.sleep(2000);
		WebElement from1= driver.findElement(By.xpath("//input[@type='text']"));
		wait.until(ExpectedConditions.visibilityOf(from1));
		js.executeScript("arguments[0].value='Bangalore';",from1);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_SPACE);
		r.keyRelease(KeyEvent.VK_SPACE);
		
	WebElement from2 = driver.findElement(By.xpath("//p[@class='sc-12foipm-34 cNjjrh']"));
		wait.until(ExpectedConditions.visibilityOf(from2));
		js.executeScript("arguments[0].click();", from2);
		
		WebElement to= driver.findElement(By.xpath("//input[@type='text']"));
		wait.until(ExpectedConditions.visibilityOf(to));
		js.executeScript("arguments[0].value='New Delhi';", to);
		r.keyPress(KeyEvent.VK_SPACE);
		r.keyRelease(KeyEvent.VK_SPACE);
		
		WebElement to1=driver.findElement(By.xpath("//p[@class='sc-12foipm-34 cNjjrh']"));
		wait.until(ExpectedConditions.visibilityOf(to1));
		js.executeScript("arguments[0].value='New Delhi';", to1);
		r.keyPress(KeyEvent.VK_RIGHT);
		r.keyRelease(KeyEvent.VK_RIGHT);
		r.keyPress(KeyEvent.VK_SPACE);
		r.keyRelease(KeyEvent.VK_SPACE);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		WebElement departure= driver.findElement(By.xpath("//span[.='Departure']/following-sibling::p[@class='sc-12foipm-4 czGBLf fswWidgetTitle']"));
		wait.until(ExpectedConditions.visibilityOf(departure));
		js.executeScript("arguments[0].click();", departure);
		
		int datesel=1;
		String month="November 2025";
		for (int i = 0; i < 12; i++) {
			try {
			WebElement datefrom=driver.findElement(By.xpath("//p[.='"+datesel+"']/ancestor::div[@class='DayPicker-Month']/div[.='"+month+"']/../descendant::p[.='"+datesel+"']"));
			wait.until(ExpectedConditions.visibilityOf(datefrom));
			js.executeScript("arguments[0].click();", datefrom);
			break;
			}
			catch (Exception e) {
				WebElement next=driver.findElement(By.xpath("//span[@aria-label='Next Month']"));
				wait.until(ExpectedConditions.visibilityOf(next));
				js.executeScript("arguments[0].click();", next);
			}
		}
		
		WebElement returndate= driver.findElement(By.xpath("//p[@class='sc-12foipm-9 hInlKv']"));
		wait.until(ExpectedConditions.visibilityOf(returndate));
		js.executeScript("arguments[0].click();", returndate);
		
		int datesel1=5;
		String returnmonth="January 2026";
		for (int i = 0; i < 12; i++) {
			try { 
			WebElement datefrom=driver.findElement(By.xpath("//p[.='"+datesel1+"']/ancestor::div[@class='DayPicker-Month']/div[.='"+returnmonth+"']/../descendant::p[.='"+datesel1+"']"));
		wait.until(ExpectedConditions.visibilityOf(datefrom));
			js.executeScript("arguments[0].click();", datefrom);
		break;
			}
			catch (Exception e) {
				WebElement next=driver.findElement(By.xpath("//span[@aria-label='Next Month']"));
				wait.until(ExpectedConditions.visibilityOf(next));
				js.executeScript("arguments[0].click();", next);
			}
		}
		WebElement travelclass= driver.findElement(By.xpath("//div[@class='sc-12foipm-2 eTBlJr fswFld ']/span[.='Travellers & Class']/.."));
		wait.until(ExpectedConditions.visibilityOf(travelclass));
		js.executeScript("arguments[0].click();", travelclass);
		
	WebElement adult= driver.findElement(By.xpath("(//p[.='Adults']/../descendant::span[@class='sc-12foipm-51 kZvHQU']/*[name()='svg'])[2]"));
	wait.until(ExpectedConditions.visibilityOf(adult));
	adult.click();
	
	WebElement children= driver.findElement(By.xpath("(//p[.='Children']/../descendant::span[@class='sc-12foipm-51 kZvHQU']/*[name()='svg'])[2]"));
	wait.until(ExpectedConditions.visibilityOf(children));
	children.click();
	
	WebElement travelclass1= driver.findElement(By.xpath("//li[.='premium economy']"));
	wait.until(ExpectedConditions.visibilityOf(travelclass1));
	travelclass1.click();
	
	
	WebElement save= driver.findElement(By.xpath("//a[.='Done']"));
	wait.until(ExpectedConditions.visibilityOf(save));
	 save.click();
	
	} 
}
