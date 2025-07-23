package tekPyramidMock;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestAutomationPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		   driver.manage().window().maximize();
		 driver.get("https://testautomationpractice.blogspot.com/");
		 Actions a=new Actions(driver);
		  a.scrollByAmount(0,1500).perform();
//		WebElement ele1=  driver.findElement(By.xpath("//p[.='Drag me to my target']"));
//		WebElement ele2=  driver.findElement(By.id("droppable"));
//				
//				a.dragAndDrop(ele1, ele2).perform();
		  
//		  WebElement ele3=driver.findElement(By.id("singleFileInput"));
//		 ele3.sendKeys("C:\\Users\\Kaviya S\\Downloads\\Ar.java");
		  
		// WebElement ele4= driver.findElement(By.xpath("(//*[name()='svg']/*[name()='rect'])[1]"));
		 driver.findElement(By.id("comboBox")).click();
		 
	}

}
