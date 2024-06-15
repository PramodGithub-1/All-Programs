package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGpractice {

@Test
public void sample()
{
	Assert.fail();
	System.out.println("Leelasaipramod");
}

@Test 
public void jagan()
{
	System.out.println("jai jagan");
}


@Test (dependsOnMethods = "sample") 
public void cbn()
{
	System.out.println("never");
}
}
