package Pra;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClassListener {

	@BeforeSuite
	public void bs()
	{
		System.out.println("Iam Before suite");
	}
	@AfterSuite
	public void as()
	{
		System.out.println("Iam After suite");
	}
	
	@BeforeTest
	public void bt()
	{
		System.out.println("iam before test");
	}
	
	@AfterTest
	public void at()
	{
		System.out.println("Iam after test");
	}
	
	@BeforeClass
	public void bc()
	{
		System.out.println("Iam before class ");
	}
	
	@AfterClass
	public void ac()
	{
		System.out.println("Iam after class");
	}
	
	@BeforeMethod
	public void bm()
	{
		System.out.println("Iam before method");
	}
	
	@AfterMethod
	public void am()
	{
		System.out.println("Iam after method");
	}
}
