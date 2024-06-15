package Practice;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertProgram {
	@Test
public void sample()
{
	String s="Hi";
	System.out.println("step-1");
	System.out.println("step-2");
	System.out.println("step-3");
	System.out.println("step-4");
   // Assert.assertTrue(s.contains("i"));
    //Assert.assertFalse(s.contains("d"));
	//Assert.assertSame("i", "i");
	//Assert.assertSame("i", "o");
	//Assert.assertEquals(0, 0);
	//Assert.assertEquals(0, 1);
	//Assert.assertNotEquals(0, 1);
	//Assert.assertEquals(0, 0);
	Assert.fail();
	System.out.println("step-5");
	System.out.println("step-6");
}

}
