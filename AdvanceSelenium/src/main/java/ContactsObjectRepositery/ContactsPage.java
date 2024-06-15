package ContactsObjectRepositery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {//1.Name of page 
      //2.Declaration
	
	@FindBy (xpath = "//img[@title='Create Contact...']")
	private WebElement contactLookup;
	
	//3.Initialization
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//4.utilization
	public WebElement getContactLookup() {
		return contactLookup;
	}
	/**
	 * This is the method for click on contacts lookup icon
	 */
	public void ClickOnContactsLookUp()
	{
		contactLookup.click();
	}
	
	
}
