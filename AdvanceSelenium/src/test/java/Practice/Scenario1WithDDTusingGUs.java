package Practice;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import GenericUtilities.ExcelFileUtility;
import GenericUtilities.PropertyFileUtility;
import GenericUtilities.SeleniumUtility;

public class Scenario1WithDDTusingGUs {

	public static void main(String[] args)throws Exception {
		// We have to create an object of all utilities
		 ExcelFileUtility EUTIL=new ExcelFileUtility();
		 PropertyFileUtility PUTIL=new PropertyFileUtility();
		 SeleniumUtility SUTIL=new SeleniumUtility();
		//2.using properties utility
				String URL=PUTIL.readDataFromPropertyFile("url");
				String USERNAME=PUTIL.readDataFromPropertyFile("username");
				String PASSWORD=PUTIL.readDataFromPropertyFile("password");
				//2.using excel utility
				
				String LASTNAME=EUTIL.readDataFromExcelFile("Contacts", 1, 2);
				//1)launch the browser
				WebDriver driver=new ChromeDriver();
				SUTIL.maximizeWindow(driver);
			    SUTIL.implicitWait(driver);
				//2)load the url
				driver.get(URL);
				//3.login to the application
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				//4.navigate to contacts link
				driver.findElement(By.linkText("Contacts")).click();
				//5.click on new contact look up icon
				driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
				//6.enter last name into create new conact
				driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
				//7.click on save
				driver.findElement(By.name("button")).click();
				//8.validate
				String conheader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(conheader.contains(LASTNAME))
				{
					
					System.out.println("pass");
					System.out.println(conheader);
				}
				else
					System.out.println("fail");
				//9.signout
				WebElement element=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				SUTIL.mouseMoveToElement(driver, element);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
				System.out.println("sign out done successfully");
				driver.quit();
				
	}

}
