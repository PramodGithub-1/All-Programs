package Practice;

import org.testng.annotations.Test;

public class TestNG_Flags {
	@Test 
public void sample()
{
	System.out.println("leela");
}
	@Test (dependsOnMethods ="sample")
public void simple()
{
	System.out.println("sai");
}
	@Test 
public void semple()
{
	System.out.println("pramod");
}
	@Test 
public void name()
{
	System.out.println("prasanna");
}
}
