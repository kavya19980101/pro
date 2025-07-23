package Pra;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;



public class DatabaseJdbc {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
Driver driverRef=new Driver();
DriverManager.registerDriver(driverRef);

Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/crm", "root", "root");
System.out.println("===done=====");
 
Statement s= con.createStatement();
ResultSet resultset= s.executeQuery("select * from orders");

while(resultset.next())
{
	System.out.println(resultset.getInt(1) +"\t"+ resultset.getInt(2) +"\t"+ resultset.getString(3) +"\t" +resultset.getString(4));
}
con.close();

	}

}
