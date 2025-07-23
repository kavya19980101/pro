package Pra;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FlipkartExcel {
	

	public static void main(String[] args) throws AWTException, EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
WebDriver driver=new ChromeDriver();
driver.get("https://www.flipkart.com/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
driver.findElement(By.xpath("//input[@class='Pke_EE']")).sendKeys("laptop");
Robot r=new Robot();
r.keyPress(KeyEvent.VK_ENTER);
r.keyRelease(KeyEvent.VK_ENTER);
POM p=new POM(driver);

FileInputStream fis=new FileInputStream("C:\\Users\\Kaviya S\\Downloads\\excelddt\\ExampleForDataDrivenTesting.xlsx");
Workbook book= WorkbookFactory.create(fis);
Sheet sheet= book.getSheet("Flipkart_Details"); 
int count=p.getpro().size();
Row row;
for(int i=1;i<count;i++)
{
	WebElement pro=p.getpro().get(i);
	String s=pro.getText();
	row= sheet.createRow(i);
	Cell cell= row.createCell(0);
	cell.setCellValue(s);
	WebElement price=p.getprice().get(i);
	String s1=price.getText();
	Cell cell1= row.createCell(1);
	cell1.setCellValue(s1);
	
}

	  
	
  FileOutputStream fos=new FileOutputStream("C:\\Users\\Kaviya S\\Downloads\\excelddt\\ExampleForDataDrivenTesting.xlsx");
	  book.write(fos);
	  book.close();
	  
	
	
	  



	}

}
