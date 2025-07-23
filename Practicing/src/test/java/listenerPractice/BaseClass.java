package listenerPractice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	
	@BeforeSuite
	public void suite()
	{
		System.out.println("Iam Before Suite1");
	}
	
	@BeforeSuite
	public void suite1()
	{
		System.out.println("Iam Before Suite2");
	}
	
	@BeforeTest
	public void test1()
	{
		System.out.println("Iam before test");
	}
	
	@BeforeTest
	public void test2()
	{
		System.out.println("Iam before test2");
	}
	
	@BeforeClass
	public void classs1()
	{
		System.out.println("Iam before class");
	}
	
	@BeforeClass
	public void classs2()
	{
		System.out.println("Iam before class2");
	}
	
	@BeforeMethod
	public void bmethod1()
	{
		System.out.println("Iam before method1");
	}
	
	@BeforeMethod
	public void bmethod2()
	{
		System.out.println("Iam before method2");
	}
	
	@AfterMethod
	public void amethod1()
	{
		System.out.println("after method1");
	}
	
	@AfterMethod
	public void amethod2()
	{
		System.out.println("after method2");
	}
	

	@AfterClass
	public void aclass1()
	{
		System.out.println("after class1");
	}
	
	@AfterClass
	public void aclass2()
	{
		System.out.println("after class2");
	}
	@AfterTest
	public void atest1()
	{
		System.out.println("after test");
	}
	
	@AfterTest
	public void atest2()
	{
		System.out.println("after test");
	}
	
	@AfterSuite
	public void asuite1()
	{
		System.out.println("after suite1");
	}
	
	@AfterSuite()
	public void asuite2()
	{
		System.out.println("after suite2");
	}
}
