package Pra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ExpectedConditionjdbc {

	@Test
	public void test1() throws SQLException
	{
		String expectedCustomerName="kavya";
		boolean flag=false;
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);

		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/crm", "root", "root");
		System.out.println("===done=====");
		 
		Statement s= con.createStatement();
		ResultSet resultset= s.executeQuery("select * from customer");

		while(resultset.next())
		{
			String actualcustomername=resultset.getString(2);
			if(expectedCustomerName.equals(actualcustomername))
			{
				flag=true;
				System.out.println(expectedCustomerName+ " is available == pass");
			}
		}
		if (flag==false) {
			System.out.println(expectedCustomerName+ " is not available == fail");
		}
		con.close();
	}
	
}
