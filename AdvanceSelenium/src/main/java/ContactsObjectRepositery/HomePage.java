package ContactsObjectRepositery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.SeleniumUtility;

public class HomePage extends SeleniumUtility{//1. name of the page
	//2. declaration 
	@FindBy (linkText =  "Contacts")
    private WebElement contactsLink;

	@FindBy (xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstratorImg;
	
	@FindBy (linkText = "Sign Out")
	private WebElement signoutLink;
	
	//3.initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//4.utilization
	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getAdminstratotImg() {
		return adminstratorImg;
	}
/**
 * This method used for click on contacts link
 * @return
 */
	public WebElement getSignoutLink() {
		return signoutLink;
	}
	
	public void clickOnContactsLink()
	{
		contactsLink.click();
	}
	/**
	 * This method used for logout operation
	 * @param driver
	 * @throws Exception
	 */
	public void logoutApp(WebDriver driver) throws Exception
	{
		mouseMoveToElement(driver, adminstratorImg);
		Thread.sleep(2000);
		signoutLink.click();
	}
	
}
