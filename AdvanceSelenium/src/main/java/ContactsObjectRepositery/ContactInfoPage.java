package ContactsObjectRepositery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage  {//1.name of the page
	
	//2.declaration

	@FindBy (className = "dvHeaderText")
	private WebElement contactHeader;
	
	//3.initialization
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//4.utilization
	public WebElement getContactHeader() {
		return contactHeader;
	}
	/**
	 * This method is used to capture the header information
	 * @return
	 */
	public String captureHeaderText()
	{
		return contactHeader.getText();
	}
	
}
