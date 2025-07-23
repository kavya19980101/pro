package listenerPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestS2 extends BaseClass{
	public void tc1()
	{
		System.out.println("Tc4");
		Assert.fail();
		Assert.assertEquals(true, true);
		
	}
	
	@Test
	public void tc2()
	{
		System.out.println("Tc5");
	}
	
	@Test
	public void tc3()
	{
		System.out.println("tc6");
	}
}
