package Pra;

import java.nio.channels.SelectableChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class CreaeProjectAndVerifyDataInDBWITHGUI {

	public static void main(String[] args) throws SQLException, InterruptedException {
		// TODO Auto-generated method stub
WebDriver driver=new EdgeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
driver.get("http://49.249.28.218:8091/");
driver.findElement(By.id("username")).sendKeys("rmgyantra");
driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
driver.findElement(By.xpath("//button[.='Sign in']")).click();
Thread.sleep(5000);

driver.findElement(By.xpath("//a[.='Projects']")).click();
driver.findElement(By.xpath("//span[.='Create Project']")).click();

Thread.sleep(5000);
driver.findElement(By.name("projectName")).sendKeys("Insta01011998");
driver.findElement(By.name("createdBy")).sendKeys("kavya");
WebElement project_status= driver.findElement(By.xpath("(//select[@name='status'])[2]"));
Select s=new Select(project_status);
s.selectByIndex(1);
driver.findElement(By.xpath("//input[@value='Add Project']")).click();
//		
//		Driver driverRef=new Driver();
//		DriverManager.registerDriver(driverRef);
//
		//Connection con= DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root@%", "root");
//		System.out.println("===done=====");
//		 
//		Statement s= con.createStatement();
//		int result= s.executeUpdate("insert into customer values(9,'Lakhsmi','Bangalore')");
//		int result=s.executeUpdate("insert into project(project_id,created_by, created_on, project_name, status, team_size) values(111,'kavyas','LLgg1','01/06/2025','Createdd',1)");
//		System.out.println(result);
//	ResultSet resultset= s.executeQuery("select * from project");
//		
//	while(resultset.next())
//	{
//		System.out.println(resultset.getInt(1) +"\t"+ resultset.getString(2) +"\t"+ resultset.getString(3) +"\t" +resultset.getString(4) +"\t" +resultset.getString(5) +"\t" +resultset.getInt(6));
//	}
//		con.close();
	}

}
