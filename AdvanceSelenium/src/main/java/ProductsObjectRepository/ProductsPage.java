package ProductsObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage{
@FindBy (name = "productname")
private WebElement productnameEdt;


@FindBy (xpath = "(//input[@title='Save [Alt+S]'])[2]")
private WebElement saveBtn;

public ProductsPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}

public WebElement getProductnameEdt() {
	return productnameEdt;
}

public WebElement getSaveBtn() {
	return saveBtn;
}

public void saveProduct(String PRODUCTNAME)
{
	productnameEdt.sendKeys(PRODUCTNAME);
		saveBtn.click();
}
}
