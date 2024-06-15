package LeadsObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage{
@FindBy (name = "lastname")
private WebElement lastnameEdt;

@FindBy (name = "company")
private WebElement companyEdt;

@FindBy (xpath = "(//input[@title='Save [Alt+S]'])[2]")
private WebElement saveBtn;

public LeadsPage(WebDriver driver)
{
	PageFactory.initElements(driver,this);
}

public WebElement getLastnameEdt() {
	return lastnameEdt;
}


public WebElement getCompanyEdt() {
	return companyEdt;
}

public WebElement getSaveBtn() {
	return saveBtn;
}

public void saveLead(String LASTNAME,String COMPANY)
{
	lastnameEdt.sendKeys(LASTNAME);
	companyEdt.sendKeys(COMPANY);
	saveBtn.click();
}
}
