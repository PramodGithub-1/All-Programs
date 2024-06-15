package ProductsTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtilities.ExcelFileUtility;

import GenericUtilities.PropertyFileUtility;
import GenericUtilities.SeleniumUtility;
import ProductsObjectRepository.HomePage;
import ProductsObjectRepository.LoginPage;
import ProductsObjectRepository.ProductValidation;
import ProductsObjectRepository.ProductsLookUpPage;
import ProductsObjectRepository.ProductsPage;

public class CreateProductTest {
	@Test(groups = "RegressionSuite") // (groups = "SmokeSuite")
	public void createProductWithMF() throws Throwable {
		PropertyFileUtility PUTIL = new PropertyFileUtility();
		ExcelFileUtility EUTIL = new ExcelFileUtility();
		SeleniumUtility SUTIL = new SeleniumUtility();
		String URL = PUTIL.readDataFromPropertyFile("url");
		String USERNAME = PUTIL.readDataFromPropertyFile("username");
		String PASSWORD = PUTIL.readDataFromPropertyFile("password");
		String PRODUCTNAME = EUTIL.readDataFromExcelFile("Products", 1, 2);
		WebDriver driver = new ChromeDriver();
		SUTIL.implicitWait(driver);
		SUTIL.maximizeWindow(driver);
		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(driver, USERNAME, PASSWORD);
		HomePage hp = new HomePage(driver);
		hp.clickOnProductsLink();
		ProductsLookUpPage plp = new ProductsLookUpPage(driver);
		plp.clickOnProductsLookUp();
		ProductsPage pp = new ProductsPage(driver);
		pp.saveProduct(PRODUCTNAME);
		ProductValidation pv = new ProductValidation(driver);
		String proHeader = pv.validateProduct();
		Assert.assertTrue(proHeader.contains(PRODUCTNAME));
		/*
		 * if(proHeader.contains(PRODUCTNAME)) {
		 * System.out.println("product is created"); } else {
		 * System.out.println("product is not created"); }
		 */
		hp.logoutFromApp(driver);
		driver.quit();
	}
}
