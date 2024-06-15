package ContactsObjectRepositery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.SeleniumUtility;

public class CreateNewContactPage extends SeleniumUtility{//1.Name of page
	//2.declaration
	@FindBy (xpath = "//input[@name='lastname']")
	private WebElement lastnameEdt;
	
	@FindBy (xpath = "(//input[@title='Save [Alt+S]'])[2]")
	private WebElement savebtn;
	
	@FindBy (name = "leadsource")
	private WebElement leadsourcedropDown;
	
	//Initialization(constructor)
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
//4.utilization
	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}
	public WebElement getSavebtn() {
		return savebtn;
	}
/**
 * This is the method for creating a contact
 * @param LASTNAME
 */
public void CreateNewContact(String LASTNAME)
{
	lastnameEdt.sendKeys(LASTNAME);
	savebtn.click();
}

/**
 * This method used for creating a contact with lead source
 * @param LASTNAME
 */

public void CreateNewContact(String LASTNAME,String LEADSOURCE)
{
	lastnameEdt.sendKeys(LASTNAME);
	dropDownHandle(lastnameEdt, LEADSOURCE);
	savebtn.click();
}
	
}
