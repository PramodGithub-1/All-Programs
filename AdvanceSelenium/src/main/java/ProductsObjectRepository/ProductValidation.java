package ProductsObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductValidation {
@FindBy (className = "lvtHeaderText")
private WebElement productHeader;

public ProductValidation(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}

public WebElement getProductHeader() {
	return productHeader;
}
public String validateProduct() throws Throwable{
	return productHeader.getText();
	
}
}
