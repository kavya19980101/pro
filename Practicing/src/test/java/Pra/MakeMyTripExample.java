package Pra;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MakeMyTripExample {

	public static void main(String[] args) throws InterruptedException, AWTException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	WebElement ele1=driver.findElement(By.xpath("//span[@class='commonModal__close']"));
wait.until(ExpectedConditions.visibilityOf(ele1));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", ele1);
	WebElement from= driver.findElement(By.xpath("//label[@for='fromCity']"));
	wait.until(ExpectedConditions.visibilityOf(from));
	js.executeScript("arguments[0].click();", from);
	WebElement ele2
	= driver.findElement(By.xpath("//span[@data-cy='travel-card-close']"));
	wait.until(ExpectedConditions.visibilityOf(ele2));
	String fromcity="Bengaluru";
	String tocity="New Delhi";
	js.executeScript("arguments[0].click();", ele2);
		WebElement from1= driver.findElement(By.xpath("//input[@type='text' and @placeholder='From']"));
		wait.until(ExpectedConditions.visibilityOf(from1));
		from1.sendKeys(fromcity);
		WebElement citydp= driver.findElement(By.xpath("//p[@class='searchedResult font14 blackText appendBottom5']/descendant::span[.='"+fromcity+"']"));
		wait.until(ExpectedConditions.visibilityOf(citydp));
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		WebElement to=driver.findElement(By.xpath("//label[@for='toCity']"));
		wait.until(ExpectedConditions.visibilityOf(to));
		js.executeScript("arguments[0].click();", to);
		WebElement to1= driver.findElement(By.xpath("//input[@type='text' and @placeholder='To']"));
		wait.until(ExpectedConditions.visibilityOf(to1));
		to1.sendKeys(tocity);
		WebElement citytodp= driver.findElement(By.xpath("//p[@class='searchedResult font14 blackText appendBottom5']/descendant::span[.='"+tocity+"']"));
		wait.until(ExpectedConditions.visibilityOf(citytodp));
		//js.executeScript("arguments[0].value='Bangalore'", to1);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		WebElement departure= driver.findElement(By.xpath("//label[@for='departure']"));
		wait.until(ExpectedConditions.visibilityOf(departure));
		js.executeScript("arguments[0].click();", departure);
		String monthofdep="November 2025";
		int selectdate=1;
	for(int i=1;i<=12;i++)
	{
		String ele=driver.findElement(By.xpath("(//div[@class='DayPicker-Caption'])[2]")).getText();
		if(monthofdep.equals(ele))
		{
			 WebElement date1=driver.findElement(By.xpath("//div[.='"+monthofdep+"']/../div[@class='DayPicker-Body']/descendant::p[.='"+selectdate+"']"));
		        wait.until(ExpectedConditions.visibilityOf(date1));
		        js.executeScript("arguments[0].click();", date1);
		        break;
		}
		else {
			System.out.println("click next month");
			WebElement month= driver.findElement(By.xpath("//span[@role='button' and @aria-label='Next Month']"));		
			wait.until(ExpectedConditions.visibilityOf(month));
			js.executeScript("arguments[0].click();", month);
		}
		}
	
	WebElement returndate= driver.findElement(By.xpath("//div[@data-cy='returnArea']"));
	wait.until(ExpectedConditions.visibilityOf(returndate));
	js.executeScript("arguments[0].click();", returndate);
		String monthofreturn="January";
		String yearofreturn="2026";
		int return_date=5;
	for (int i = 0; i<=11; i++) {
		try {
		WebElement date_2= driver.findElement(By.xpath("//div[@class='DayPicker-Month']/descendant::div[contains(.,'"+monthofreturn+"')]/span[.='"+yearofreturn+"']/../../../div[@class='DayPicker-Body']/descendant::p[.='"+return_date+"']"));
	wait.until(ExpectedConditions.visibilityOf(date_2));
	js.executeScript("arguments[0].click();", date_2);
	break;
	}
		catch (Exception e) 
	 {
		System.out.println("click on next month");
	
		driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
	
		
	}
		
	}
	
	
	       
			
	        
	        WebElement classtra= driver.findElement(By.xpath("//span[@data-cy='travellerText']"));
	        wait.until(ExpectedConditions.visibilityOf(classtra));
	        js.executeScript("arguments[0].click();", classtra);
	WebElement adultselection=  driver.findElement(By.xpath("//li[@data-cy='adults-2']"));
	wait.until(ExpectedConditions.visibilityOf(adultselection));
	js.executeScript("arguments[0].click();", adultselection);
	WebElement apply_btn=driver.findElement(By.xpath("//button[.='APPLY']"));
	wait.until(ExpectedConditions.visibilityOf(apply_btn));
	js.executeScript("arguments[0].click();", apply_btn);
	WebElement searchbtn= driver.findElement(By.xpath("//a[.='Search']"));
	wait.until(ExpectedConditions.visibilityOf(searchbtn));
	js.executeScript("arguments[0].click();", searchbtn);
	}
}		
	 

	
	
	

