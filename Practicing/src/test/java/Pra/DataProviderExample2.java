package Pra;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample2 {

	
	public String getDataFromExcel(String sheetName, int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./testdata/TestScriptData.xlsx");
		Workbook book= WorkbookFactory.create(fis);
		String data= book.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		book.close();
		return data;
	}
	
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./testdata/TestScriptData.xlsx");
		Workbook book= WorkbookFactory.create(fis);
		int rowcount= book.getSheet(sheetName).getLastRowNum();
		book.close();
		return rowcount;
	}
	
	public void setDataIntoExcel(String sheetName,int rowNum,int celNum,String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./testdata/TestScriptData.xlsx");
		Workbook book= WorkbookFactory.create(fis);
		book.getSheet(sheetName).getRow(rowNum).createCell(celNum);
		FileOutputStream fos=new FileOutputStream("./testdata/TestScriptData.xlsx");
		book.write(fos);
		book.close();
	}
	
	public int getColoumnCount(String sheetName, int row) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./testdata/TestScriptData.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		int lastcell=book.getSheet(sheetName).getRow(row).getLastCellNum();
		return lastcell;
	}
	@DataProvider(name="testdata")
	public Object[][] fetchProductPrice() throws EncryptedDocumentException, IOException
	{
		int lastrow=getRowCount("Flipkart_Details");
		int lastcolumn=getColoumnCount("Flipkart_Details", 0);
		Object[][] objref=new Object[lastrow][lastcolumn];
		for (int i = 0; i < lastrow; i++) {
			for (int j = 0; j < lastcolumn; j++) {
				objref[i][j]=getDataFromExcel("Flipkart_Details", i, j);
			}
		}
		return objref;
		
		
	}
	WebDriver driver=null;
	@BeforeClass
	public void launchbrowser()
	{
		driver=new ChromeDriver();
	}
	@Test(dataProvider  = "testdata")
	public void flipkart(String product,String price)
	{
		
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@class='Pke_EE']")).sendKeys(product);
		driver.findElement(By.xpath("//input[@class='Pke_EE']")).clear();
	}
	@Test(invocationCount = 3)
	public void flipkart1() throws InterruptedException
	{
		
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@class='Pke_EE']")).sendKeys("Hi");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@class='Pke_EE']")).clear();
	}
	@AfterClass
	public void close()
	{
		driver.close();
	}
	
}
