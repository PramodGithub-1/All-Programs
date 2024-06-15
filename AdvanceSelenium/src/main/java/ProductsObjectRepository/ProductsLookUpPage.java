package ProductsObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsLookUpPage {
@FindBy (xpath = "//img[@title='Create Product...']")
private WebElement productLookupIcon;

public ProductsLookUpPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}

public WebElement getProductLookupIcon() {
	return productLookupIcon;
}
public void clickOnProductsLookUp()
{
	productLookupIcon.click();
}
}
