package Pra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQueryJdbc {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);

		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/crm", "root", "root");
		System.out.println("===done=====");
		 
		Statement s= con.createStatement();
		int result= s.executeUpdate("insert into customer values(9,'Lakhsmi','Bangalore')");
System.out.println(result);
		
		con.close();
	}

}
