package Practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertProgram {
	@Test
public void sample()
{
		String s="hi";
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
SoftAssert sa=new SoftAssert();
//sa.fail();
//sa.assertAll();
//sa.assertTrue(s.contains("o"));
//sa.assertFalse(s.contains("i"));
//sa.assertSame("i", "i");
//sa.assertNotEquals(1, 0);
System.out.println("step-5");
System.out.println("step-6");
System.out.println("step-7");

}
}
