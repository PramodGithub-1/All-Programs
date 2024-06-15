package GenericUtilities;
/**
 * This is the base class consists of configuaration annotations of testNG
 * @author LENOVO
 *
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ContactsObjectRepositery.HomePage;
import ContactsObjectRepositery.LoginPage;

public class BaseClass {
public PropertyFileUtility PUTIL=new PropertyFileUtility();
public ExcelFileUtility EUTIL=new ExcelFileUtility();
public JavaUtility JUTIL=new JavaUtility();
public SeleniumUtility SUTIL=new SeleniumUtility();

public WebDriver driver;
//for listeners
//public static WebDriver sDriver;

@BeforeSuite (groups = "SmokeSuite")//(groups = "RegressionSuite") 
public void bsConfig()
{
	System.out.println("==DB connection sucessful==");
}
//@Parameters ("Browser")
//@BeforeTest (groups = {"RegressionSuite","SmokeSuite"})
@BeforeClass  (groups = "SmokeSuite")//(groups = "RegressionSuite")
public void bcConfig(String BROWSER) throws Throwable
{
	String URL=PUTIL.readDataFromPropertyFile("url");
	driver =new ChromeDriver();
	//if(BROWSER.equals("Edge"))
	//{
	//	driver=new EdgeDriver();
	//}
	//else if(BROWSER.equals("Firefox"))
	//{
		//driver=new FirefoxDriver();
	//}
	SUTIL.maximizeWindow(driver);
	SUTIL.implicitWait(driver);
	driver.get(URL);
	System.out.println("=====browser launched successful====");
}

@BeforeMethod (groups = "SmokeSuite")//(groups = "RegressionSuite")
public void bmConfig() throws Throwable
{
String USERNAME=PUTIL.readDataFromPropertyFile("username");
String PASSWORD=PUTIL.readDataFromPropertyFile("password");

LoginPage lp=new LoginPage(driver);
lp.loginToApp(USERNAME, PASSWORD);

System.out.println("====login to the app successful");
}

@AfterMethod (groups = "SmokeSuite")//(groups = "RegressionSuite") 
public void amConfig() throws Throwable
{
	HomePage hp=new HomePage(driver);
	hp.logoutApp(driver);
	
	System.out.println("===logout from app successful====");
}
//@AfterTest (groups = {"RegressionSuite","SmokeSuite"})
@AfterClass (groups = "SmokeSuite")//(groups = "RegressionSuite")
public void acConfig()throws Throwable
{
	driver.quit();
System.out.println("===browser closed succesful====");
}

@AfterSuite  (groups = "SmokeSuite")//(groups = "RegressionSuite")//(alwaysRun=true)
public void asConfig() throws Throwable
{
	System.out.println("====DB closure sucessful====");
}

}
