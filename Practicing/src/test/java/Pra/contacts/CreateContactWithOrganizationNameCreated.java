package Pra.contacts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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

public class CreateContactWithOrganizationNameCreated {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
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
		Row row= sheet.getRow(7);
		Cell cell=row.getCell(2);
		Cell cell1=row.getCell(3);
		String OrganizationName=cell.getStringCellValue()+randomInt;
		String LastName=cell1.getStringCellValue();


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
		//Step4: Create Organization
		driver.findElement(By.xpath("(//a[.='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(OrganizationName);
		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
		Thread.sleep(3000);

		//Step5:Verify Header message Expected Result
		WebElement Organization_created_message= driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
			
		if(Organization_created_message.getText().contains(OrganizationName))
		{
			System.out.println(OrganizationName+" Organization created==Pass");
		}
		else {
			System.out.println(OrganizationName+" Organization not created==Fail");
		}

		//Step6: Verify Header Organization Name as Expected Result
		WebElement Organization_name_created= driver.findElement(By.id("dtlview_Organization Name"));
		String ocm=Organization_created_message.getText();
		if(ocm.contains(OrganizationName))
		{
			System.out.println(OrganizationName+" Organization name given is created==Pass");
		}
		else {
			System.out.println(OrganizationName+" Organization name given is not created==Fail");
		}
		
		driver.findElement(By.xpath("(//a[.='Contacts'])[1]")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LastName);
		
		
	driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
	
	//Switch to child window
	Set<String> allwindows=driver.getWindowHandles();
	Iterator<String> it= allwindows.iterator();
	while(it.hasNext())
	{
		String windowid= it.next();
		driver.switchTo().window(windowid);
		String current_Url=driver.getCurrentUrl();
		if(current_Url.contains("Accounts&action"))
		{
			break;
		}
	}
	driver.findElement(By.id("search_txt")).sendKeys(OrganizationName);
	driver.findElement(By.name("search")).click();
	Thread.sleep(3000);
	 driver.findElement(By.xpath("//a[.='"+OrganizationName+"']")).click();
	
		//driver.findElement(By.xpath("//a[.='\"+OrganizationName+\"']")).click();
		
	 Iterator<String> it1= allwindows.iterator();
	while(it1.hasNext())
	{
		String windowid= it1.next();
		driver.switchTo().window(windowid);
		String current_Url=driver.getCurrentUrl();
		if(current_Url.contains("Contacts&action"))
		{
			break;
		}
	}
	driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
	WebElement contact_name_created= driver.findElement(By.id("dtlview_Last Name"));

	if(contact_name_created.getText().contains(LastName))
	{
		System.out.println(LastName+"  name given is created==Pass");
	}
	else {
		System.out.println(LastName+"  name given is not created==Fail");
	}	
	String organizationselected=driver.findElement(By.id("mouseArea_Organization Name")).getText();
	if(organizationselected.trim().equals(OrganizationName))
	{
		System.out.println(organizationselected+"  name given is selected==Pass");
	}
	else {
		System.out.println(organizationselected+"  name given is not selected==Fail");
	}	
	Thread.sleep(3000);

		//Step7:Logout from application
		WebElement logout_image= driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions act=new Actions(driver);
			act.moveToElement(logout_image).perform();
			driver.findElement(By.xpath("//a[.='Sign Out']")).click();
			
			
			//Step8:close the browser
			driver.close();
	}

}
