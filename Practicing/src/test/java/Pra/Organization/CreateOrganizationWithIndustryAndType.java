package Pra.Organization;

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
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationWithIndustryAndType {

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
		Sheet sheet= book.getSheet("Organization");
		Row row= sheet.getRow(4);
		Cell cell1=row.getCell(2);
		Cell cell2=row.getCell(3);
		Cell cell3=row.getCell(4);
		String OrganizationName=cell1.getStringCellValue()+randomInt;
		String industry= cell2.getStringCellValue();
		String Org_type= cell3.getStringCellValue();


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
		
		//Step5:Select the Organization Industry 
		WebElement org_industry= driver.findElement(By.name("industry"));
         Select s1=new Select(org_industry);
         s1.selectByVisibleText(industry);
         
        //Step6:Select the Organization Type
         WebElement organization_type= driver.findElement(By.name("accounttype"));
         Select s2=new Select(organization_type);
         s2.selectByVisibleText(Org_type);
         
         //Step7:Click on save button
         driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
 		Thread.sleep(3000);
		//Step8:Verify Header message Expected Result
		WebElement Organization_created_message= driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
			
		if(Organization_created_message.getText().contains(OrganizationName))
		{
			System.out.println(OrganizationName+" Organization created==Pass");
		}
		else {
			System.out.println(OrganizationName+" Organization not created==Fail");
		}

		//Step9: Verify Header Organization Name as Expected Result
		WebElement Organization_name_created= driver.findElement(By.id("dtlview_Organization Name"));

		if(Organization_name_created.getText().contains(OrganizationName))
		{
			System.out.println(OrganizationName+" Organization name given is created==Pass");
		}
		else {
			System.out.println(OrganizationName+" Organization name given is not created==Fail");
		}
		//Step10:Verify Industry type as expected
		WebElement indus_result= driver.findElement(By.id("dtlview_Industry"));
		if (indus_result.getText().equals(industry)) {
			System.out.println(industry+" is selected as Industry==Pass");
		}
		else {
			System.out.println(indus_result+" is not selected as Industry==Fail");
		}
		//Step11:Verify Industry type as expected
				WebElement OrgType_result= driver.findElement(By.id("dtlview_Type"));
				if (OrgType_result.getText().equals(Org_type)) {
					System.out.println(Org_type+" is selected as type==Pass");
				}
				else {
					System.out.println(Org_type+" is not selected as type==Fail");
				}
		
		

		//Step12:Logout from application
		WebElement logout_image= driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions act=new Actions(driver);
			act.moveToElement(logout_image).perform();
			driver.findElement(By.xpath("//a[.='Sign Out']")).click();
			
			
			//Step13:close the browser
			driver.close();
	}

}
