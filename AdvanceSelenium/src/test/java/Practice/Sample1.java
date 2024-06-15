package Practice;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class Sample1 {
@Test 
	public void m1()
	{
	SoftAssert sa=new SoftAssert();
	sa.assertAll();
		System.out.println("Hi");
	}
	@Test 
	public void m2()
	{
	 SoftAssert sa=new SoftAssert();	
		System.out.println("iam");
	}
	@Test 
	public void m3()
	{
		System.out.println("pramod");
	}
	@Test 
	public void m4()
	{
		System.out.println("leela");
	}

}
