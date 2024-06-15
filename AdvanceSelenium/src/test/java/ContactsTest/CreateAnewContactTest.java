package ContactsTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import ContactsObjectRepositery.ContactInfoPage;
import ContactsObjectRepositery.ContactsPage;
import ContactsObjectRepositery.CreateNewContactPage;
import ContactsObjectRepositery.HomePage;
import ContactsObjectRepositery.LoginPage;
import GenericUtilities.ExcelFileUtility;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.SeleniumUtility;

public class CreateAnewContactTest {
	@Test (groups = "RegressionSuite")
	public void createContactWithMandataoryFields() throws Throwable
	{
		// 1.We have to create an object of all utilities(don't distrub)
		 ExcelFileUtility EUTIL=new ExcelFileUtility();
		 PropertyFileUtility PUTIL=new PropertyFileUtility();
		 SeleniumUtility SUTIL=new SeleniumUtility();
		//2.using properties utility(don't distrub)
				String URL=PUTIL.readDataFromPropertyFile("url");
				String USERNAME=PUTIL.readDataFromPropertyFile("username");
				String PASSWORD=PUTIL.readDataFromPropertyFile("password");
				//3.using excel utility
				String LASTNAME=EUTIL.readDataFromExcelFile("Contacts", 1, 2);
				//4)launch the browser 
				WebDriver driver=new ChromeDriver();
				SUTIL.implicitWait(driver);
				SUTIL.maximizeWindow(driver);
				//5)load the url
				driver.get(URL);
				//6. use loginpage POM
				LoginPage lp=new LoginPage(driver);
				lp.loginToApp(USERNAME, PASSWORD);
				
				//7.navigate to contacts link and click on it using Contacts POM
				HomePage hp=new HomePage(driver);
				hp.clickOnContactsLink();
				//8.click on new contact look up icon using contactspage POM
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
				//9.signout done by using Home page POM
				hp.logoutApp(driver);
				System.out.println("sign out done successfully");
				driver.quit();	
}
}
