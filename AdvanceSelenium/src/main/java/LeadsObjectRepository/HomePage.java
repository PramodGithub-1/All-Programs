package LeadsObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.SeleniumUtility;

public class HomePage extends SeleniumUtility{
@FindBy (linkText = "Leads")
private WebElement leadsLink;

@FindBy (xpath = "//img[@src='themes/softed/images/user.PNG']")
private WebElement adminImg;

@FindBy (linkText = "Sign Out")
private WebElement signoutLink;

public HomePage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}

public WebElement getLeadsLink() {
	return leadsLink;
}

public WebElement getAdminImg() {
	return adminImg;
}

public WebElement getSignoutLink() {
	return signoutLink;
}

public void clickOnLeadsLink() throws Throwable
{
	leadsLink.click();
}

public void logoutFromApp(WebDriver driver) throws Throwable
{
	SeleniumUtility SUTIL=new SeleniumUtility();
	SUTIL.mouseMoveToElement(driver, adminImg);
	signoutLink.click();
	
}
}
