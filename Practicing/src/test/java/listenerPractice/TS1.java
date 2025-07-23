package listenerPractice;

import org.testng.annotations.Test;

public class TS1 extends BaseClass{

	
	@Test()
	public void tc1()
	{
		System.out.println("Tc1");
	}
	
	@Test(priority = 1)
	public void tc2()
	{
		System.out.println("Tc2");
	}
	
	@Test
	public void tc3()
	{
		System.out.println("tc3");
	}
}
