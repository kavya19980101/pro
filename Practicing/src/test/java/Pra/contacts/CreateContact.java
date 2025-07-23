package Pra.contacts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContact {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		//Read common data from properties file
		FileInputStream fis=new FileInputStream("./VtigerCommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String Browser=p.getProperty("browser");
		String URL=p.getProperty("url");
		String username=p.getProperty("username");
		String password=p.getProperty("password");

		//Random Number generation
		Random random=new Random();
		int randomInt=random.nextInt(1000);

		//Read data from Excel
		FileInputStream fis1=new FileInputStream("C:\\Users\\Kaviya S\\Downloads\\excelddt\\TestScriptData.xlsx");
		Workbook book= WorkbookFactory.create(fis1);
		Sheet sheet= book.getSheet("Contacts");
		Row row= sheet.getRow(1);
		Cell cell=row.getCell(2);
		String ContactName=cell.getStringCellValue();


		//Step1: Launch the Browser
		WebDriver driver=null;
		if(Browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if (Browser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else if (Browser.equals("edge")) {
			driver=new EdgeDriver();
		}
		//Step2:Enter the URL
		driver.get(URL);
		//Step3:Login to Vtiger application as admin
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(3000);
		//Step4: Create Contact
		driver.findElement(By.xpath("(//a[.='Contacts'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(ContactName);
		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
		Thread.sleep(3000);

		//Step5:Verify Header message Expected Result
		WebElement Contact_created_message= driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
			
		if(Contact_created_message.getText().contains(ContactName))
		{
			System.out.println(ContactName+" Organization created==Pass");
		}
		else {
			System.out.println(ContactName+" Organization not created==Fail");
		}

		//Step6: Verify Header Organization Name as Expected Result
		WebElement contact_name_created= driver.findElement(By.id("dtlview_Last Name"));

		if(contact_name_created.getText().contains(ContactName))
		{
			System.out.println(ContactName+" Organization name given is created==Pass");
		}
		else {
			System.out.println(ContactName+" Organization name given is not created==Fail");
		}

		//Step7:Logout from application
		WebElement logout_image= driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions act=new Actions(driver);
			act.moveToElement(logout_image).perform();
			driver.findElement(By.xpath("//a[.='Sign Out']")).click();
			
			
			//Step8:close the browser
			driver.close();
			
	}

}
