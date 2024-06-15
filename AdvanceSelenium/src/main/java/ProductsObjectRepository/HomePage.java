package ProductsObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtilities.SeleniumUtility;

public class HomePage extends SeleniumUtility{
@FindBy (linkText = "Products")
private WebElement productsLink;

@FindBy (xpath = "//img[@src='themes/softed/images/user.PNG']")
private WebElement adminImg;

@FindBy (linkText = "Sign Out")
private WebElement signoutLink;

public HomePage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}

public WebElement getProductsLink() {
	return productsLink;
}

public WebElement getAdminImg() {
	return adminImg;
}

public WebElement getSignoutLink() {
	return signoutLink;
}

public void clickOnProductsLink() throws Throwable
{
	productsLink.click();
}

public void logoutFromApp(WebDriver driver) throws Throwable
{
	SeleniumUtility SUTIL=new SeleniumUtility();
	SUTIL.mouseMoveToElement(driver, adminImg);
	signoutLink.click();
	
}
}
