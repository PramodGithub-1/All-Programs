package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Scenario1 {
public static void main(String[] args) throws Exception{

	//1)launch the browser
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	//2)load the url
	driver.get("http://localhost:8888");
	//3.login to the application
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	//4.navigate to contacts link
	driver.findElement(By.linkText("Contacts")).click();
	//5.click on new contact look up icon
	driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	//6.enter last name into create new conact
	driver.findElement(By.name("lastname")).sendKeys("batman");
	//7.click on save
	driver.findElement(By.name("button")).click();
	//8.validate
	String conheader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	Assert.assertTrue(conheader.contains("batman"));
	/*if(conheader.contains("batman"))
	{
		
		System.out.println("pass");
		System.out.println(conheader);
	}
	else
		System.out.println("fail");*/
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
