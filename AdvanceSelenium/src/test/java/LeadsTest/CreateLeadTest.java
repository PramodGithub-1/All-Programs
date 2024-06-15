package LeadsTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.SeleniumUtility;
import LeadsObjectRepository.HomePage;
import LeadsObjectRepository.LeadValidation;
import LeadsObjectRepository.LeadsLookUpPage;
import LeadsObjectRepository.LeadsPage;
import LeadsObjectRepository.LoginPage;

public class CreateLeadTest {
	@Test (groups = "SmokeSuite")
public void createLeadWithMF() throws Throwable
{
		
		    PropertyFileUtility PUTIL=new PropertyFileUtility();
	        ExcelFileUtility EUTIL=new ExcelFileUtility();
	        SeleniumUtility SUTIL=new SeleniumUtility();
	        String URL=PUTIL.readDataFromPropertyFile("url");
	  		String USERNAME=PUTIL.readDataFromPropertyFile("username");
	  		String PASSWORD=PUTIL.readDataFromPropertyFile("password");
	  		String LASTNAME=EUTIL.readDataFromExcelFile("Leads", 1, 2);
	  		String COMPANY=EUTIL.readDataFromExcelFile("Leads", 1, 3);
	  			WebDriver driver=new ChromeDriver();
	  		    SUTIL.implicitWait(driver);
	  		    SUTIL.maximizeWindow(driver);
	  			driver.get(URL);
	  			LoginPage lp=new LoginPage(driver);
	  			lp.loginToApp(driver, USERNAME, PASSWORD);
	  		    HomePage hp=new HomePage(driver);
	  		    hp.clickOnLeadsLink();
	  		    LeadsLookUpPage llp=new LeadsLookUpPage(driver);
	  		    llp.clickOnLeadLookUp();
	  		    LeadsPage lpe=new LeadsPage(driver);
	  		    lpe.saveLead(LASTNAME, COMPANY);
	  		    LeadValidation lv=new LeadValidation(driver);
	  			String leadHeader=lv.validateLead();
	  			Assert.assertTrue(leadHeader.contains(LASTNAME));
	  		    /*if(leadHeader.contains(LASTNAME))
	  		    {
	  		    	System.out.println("lead is created");
	  		    }
	  		    else
	  		    {
	  		    	System.out.println("lead is not created");
	  		    }*/
	  		hp.logoutFromApp(driver);
	  	        driver.quit();	
}
}
