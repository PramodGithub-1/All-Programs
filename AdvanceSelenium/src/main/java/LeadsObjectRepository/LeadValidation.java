package LeadsObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadValidation {
@FindBy (className = "dvHeaderText")
private WebElement leadHeader;

public LeadValidation(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}

public WebElement getleadHeader() {
	return leadHeader;
}
public String validateLead() throws Throwable{
	return leadHeader.getText();
	
}
}
