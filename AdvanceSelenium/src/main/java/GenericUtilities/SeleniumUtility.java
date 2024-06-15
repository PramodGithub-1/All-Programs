package GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consists of  generic methods related to selenium
 * @author LENOVO
 *
 */
public class SeleniumUtility {
	/**
	 * This is the method for maximize
	 * @param driver
	 */
public void maximizeWindow(WebDriver driver)
{
	driver.manage().window().maximize();
}
/**
 * This is the method to minimize
 * @param driver
 */
public void minimizeWindow(WebDriver driver)
{
	driver.manage().window().minimize();
}
/**
 * this is the method to give wait window for 10 seconds
 * @param driver
 */
public void implicitWait(WebDriver driver)
{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
/**
 * This is the methood wait for 10 seconds the element to be visible
 * @param driver
 * @param element
 */
public void explicitWait(WebDriver driver,WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(element));
}
/**
 * This method return handling of drop down based on index
 * @param element
 * @param index
 */
public void dropDownHandle(WebElement element, int index)
{
	Select s=new Select(element);
	s.selectByIndex(index);
}
/**
 * This method return handling of drop down based on value
 * @param element
 * @param value
 */
public void dropDownHandle(WebElement element, String value)
{
	Select s=new Select(element);
	s.selectByValue(value);
}
/**
 * This method return handling of drop down based on visible o text
 * @param text
 * @param element
 */
public void dropDownHandle(String text,WebElement element)
{
	Select s=new Select(element);
	s.selectByVisibleText(text);
}
/**
 * This method used for move mouse cursor
 * @param driver
 * @param element
 */
public void mouseMoveToElement(WebDriver driver,WebElement element)
{
	Actions act=new Actions(driver);
	act.moveToElement(element).perform();
}
/**
 * this is the method to perform right click operation
 * @param driver
 * @param element
 */
public void mouseRightClick(WebDriver driver,WebElement element)
{
	Actions act=new Actions(driver);
	act.contextClick(element).perform();
}
/**
 * This is the method to perform doble click operation
 * @param driver
 * @param element
 */
public void mouseDoubleClick(WebDriver driver,WebElement element)
{
	Actions act=new Actions(driver);
	act.doubleClick(element).perform();
}
/**
 * This method is used for performing of drag and drop operations
 * @param driver
 * @param srcimage
 * @param destimage
 */
public void mouseDragAndDrop(WebDriver driver,WebElement srcimage,WebElement destimage)
{
	Actions act=new Actions(driver);
	act.dragAndDrop(srcimage, destimage).perform();
}
/**
 * This method perform scroll operation
 * @param driver
 * @param element
 */
public void mouseScrollToElement(WebDriver driver, WebElement element)
{
	Actions act=new Actions(driver);
	act.scrollToElement(element);
}
/**
 * this method performs scroll down action
 * @param driver
 */
public void scollDownAction(WebDriver driver)
{
	JavascriptExecutor jse=(JavascriptExecutor) driver;
	jse.executeScript("Windows.scrollBy(0,500);", "");
}
/**
 * this is the method performs scoll up action
 * @param driver
 */
public void scollUpAction(WebDriver driver)
{
	JavascriptExecutor jse=(JavascriptExecutor) driver;
	jse.executeScript("Windows.scrollBy(0,-500);", "");
}
/**
 * This method handles frame based on index
 * @param driver
 * @param frameindex
 */
public void handleFrame(WebDriver driver, int frameindex)
{
	driver.switchTo().frame(frameindex);
}
/**
 * This method handles based on element
 * @param driver
 * @param frameElement
 */
public void handleFrame(WebDriver driver, WebElement frameElement)
{
	driver.switchTo().frame(frameElement);
}
/**
 * This method handles based on element
 * @param driver
 * @param frameValueOrID
 */
public void handleFrame(WebDriver driver,String frameValueOrID )
{
	driver.switchTo().frame(frameValueOrID);
}
/**
 * This method returns accept operation of alert
 * @param driver
 */
public void acceptAlert(WebDriver driver)
{
	driver.switchTo().alert().accept();
}
/**
 * This method returns dismiss operation of alert
 * @param driver
 */
public void cancelAlert(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}
/**
 * This method is used to get the text of alert message
 * @param driver
 */
public void alertGetText(WebDriver driver)
{
	driver.switchTo().alert().getText();
}
//
public String takingScreenShot(WebDriver driver,String screenshotName) throws Throwable
{
	TakesScreenshot ts=(TakesScreenshot) driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	File dest=new File(".\\Screenshots\\"+screenshotName+".PNG");
	Files.copy(src, dest);
	return dest.getAbsolutePath();
}
}
