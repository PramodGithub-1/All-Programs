package LeadsTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import LeadsObjectRepository.HomePage;
import LeadsObjectRepository.LeadValidation;
import LeadsObjectRepository.LeadsLookUpPage;
import LeadsObjectRepository.LeadsPage;
import LeadsObjectRepository.LoginPage;
@Listeners (GenericUtilities.ListenersImplementation.class)
public class LeadBaseClassTest  extends BaseClass{
	@Test (groups = "SmokeSuite")//(groups = "RegressionSuite")
	public void createLeadWithMandatoryFields() throws Throwable
	{
		    String LASTNAME=EUTIL.readDataFromExcelFile("Leads", 1, 2);
  		    String COMPANY=EUTIL.readDataFromExcelFile("Leads", 1, 3);
  		    HomePage hp=new HomePage(driver);
  		    hp.clickOnLeadsLink();
  		    LeadsLookUpPage llp=new LeadsLookUpPage(driver);
  		    llp.clickOnLeadLookUp();
  		    LeadsPage lpe=new LeadsPage(driver);
  		    lpe.saveLead(LASTNAME, COMPANY);
  		    LeadValidation lv=new LeadValidation(driver);
  			String leadHeader=lv.validateLead();
  			 Assert.assertTrue(leadHeader.contains(LASTNAME));
  		    /*if(LeadHeader.contains(LASTNAME))
  		    {
  		    	System.out.println("lead is created");
  		    }
  		    else
  		    {
  		    	System.out.println("lead is not created");
  		    }*/
  		    System.out.println("lead is created");
	}
}
