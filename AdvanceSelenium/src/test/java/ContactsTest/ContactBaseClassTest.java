package ContactsTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ContactsObjectRepositery.ContactInfoPage;
import ContactsObjectRepositery.ContactsPage;
import ContactsObjectRepositery.CreateNewContactPage;
import ContactsObjectRepositery.HomePage;
import ContactsObjectRepositery.LoginPage;
import GenericUtilities.BaseClass;
import GenericUtilities.ExcelFileUtility;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.SeleniumUtility;

@Listeners (GenericUtilities.ListenersImplementation.class)
public class ContactBaseClassTest  extends BaseClass{
	@Test (groups = "SmokeSuite")//(groups = "RegressionSuite")
public void createContactWithMandataoryFields () throws Throwable
{
				//3.using excel utility
				String LASTNAME=EUTIL.readDataFromExcelFile("Contacts", 1, 2);
				//4)launch the browser 
				//7.navigate to contacts link and click on it using Contacts POM
				HomePage hp=new HomePage(driver);
				hp.clickOnContactsLink();
				//8.click on new contact look up icon using contacts page POM
				ContactsPage cp=new ContactsPage(driver);
				cp.ClickOnContactsLookUp();
				//9.enter last name into create new contact and click on save button using createnewContactpage POM
			    CreateNewContactPage cncp=new CreateNewContactPage(driver);
			    cncp.CreateNewContact(LASTNAME);
				//10.validate by using contactInfoPage POM
			    ContactInfoPage cip=new ContactInfoPage(driver);
			    String conheader=cip.captureHeaderText();
			    Assert.assertTrue(conheader.contains(LASTNAME));
				/*if(conheader.contains(LASTNAME))
				{
					
					System.out.println("pass");
					System.out.println(conheader);
				}
				else
					System.out.println("fail");*/
				
				System.out.println("sign out done successfully");
				}
}
