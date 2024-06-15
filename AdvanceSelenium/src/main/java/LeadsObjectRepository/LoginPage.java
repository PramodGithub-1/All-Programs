package LeadsObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This is the class used for login to application
 * @author LENOVO
 *
 */
public class LoginPage {
@FindBy (name = "user_name")
private WebElement usernameEdt;

@FindBy (name = "user_password")
private WebElement passwordEdt;

@FindBy (id="submitButton")
private WebElement loginBtn;

public LoginPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

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
 * This is the business library for accessing the information
 * @param driver
 * @param USERNAME
 * @param PASSWORD
 */
public void loginToApp(WebDriver driver,String USERNAME,String PASSWORD ) {
	usernameEdt.sendKeys(USERNAME);
	passwordEdt.sendKeys(PASSWORD);
	loginBtn.click();
}

}
