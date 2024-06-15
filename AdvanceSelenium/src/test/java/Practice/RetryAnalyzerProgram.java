package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzerProgram {
@Test (retryAnalyzer =GenericUtilities.RetryAnalyzerImplementation.class)
public void sample()
{
	Assert.fail();
	System.out.println("Hi");
}
}
