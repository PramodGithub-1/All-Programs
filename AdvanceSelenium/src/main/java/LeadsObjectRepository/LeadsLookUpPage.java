package LeadsObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsLookUpPage {
@FindBy (xpath = "//img[@title='Create Lead...']")
private WebElement leadsLookupIcon;

public LeadsLookUpPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}

public WebElement getLookupIcon() {
	return leadsLookupIcon;
}
public void clickOnLeadLookUp()
{
	leadsLookupIcon.click();
}
}
