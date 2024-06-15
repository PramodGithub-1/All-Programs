package ContactsObjectRepositery;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {// rule:1 naming of page
	// rule:2 declaration
	@FindBy (name="user_name")
	private WebElement usernameEdt;
	
	@FindBy (name="user_password")
    private WebElement passwordEdt;
	
	@FindBy (id="submitButton")
	private WebElement loginBtn;
	
	//3.Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//4.utilization
	
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
/**
 * Business library for login
 * This is the method for login to application	
 * @param USERANME
 * @param PASSWORD
 */
public void loginToApp(String USERANME,String PASSWORD)
{
	usernameEdt.sendKeys(USERANME);
	passwordEdt.sendKeys(PASSWORD);
	loginBtn.click();
}
	
}
