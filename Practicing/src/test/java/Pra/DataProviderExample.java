package Pra;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {
	
	@Test(dataProvider="fetchData")
	public void createContacttest(String firstname,String lastname)
	{
		
		System.out.println("FirstName: " +firstname+ " LastName: "+lastname);
		
	}
	
	@DataProvider
	public Object[][] fetchData()
	{
		Object[][] objref=new Object[3][2];
		objref[0][0]="Kavya";
		objref[0][1]="S";
		
		objref[1][0]="Hemanth";
		objref[1][1]="G";
		
		objref[2][0]="Saroj";
		objref[2][1]="Kumar";
		
		
		return objref;
		
	}

}
