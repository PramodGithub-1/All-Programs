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

public class Scenario1WithDDT {

	public static void main(String[] args) throws Exception {
		//1.Read common data from properties file
		FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\CommonData.Properties");
		Properties p=new Properties();
		p.load(fisp);
		String URL=p.getProperty("url");
		String USERNAME=p.getProperty("username");
		String PASSWORD=p.getProperty("password");
		//2.Read data from excel file
		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\LeadsTestData.xlsx");
		Workbook wb=WorkbookFactory.create(fise);
		String LASTNAME=wb.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue();
		//1)launch the browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
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
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		System.out.println("sign out done successfully");
		driver.quit();
		
		

	}

}
