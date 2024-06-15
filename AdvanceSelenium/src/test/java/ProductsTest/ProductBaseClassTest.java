package ProductsTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import ProductsObjectRepository.HomePage;
import ProductsObjectRepository.LoginPage;
import ProductsObjectRepository.ProductValidation;
import ProductsObjectRepository.ProductsLookUpPage;
import ProductsObjectRepository.ProductsPage;
@Listeners (GenericUtilities.ListenersImplimentation.class)
public class ProductBaseClassTest extends BaseClass {
	@Test (groups = "SmokeSuite")//(groups = "RegressionSuite")
	public void createProductWithMandatoryFields() throws Throwable
	{
		    String PRODUCTNAME=EUTIL.readDataFromExcelFile("Products", 1, 2);
		    HomePage hp=new HomePage(driver);
		    hp.clickOnProductsLink();
		    ProductsLookUpPage plp=new ProductsLookUpPage(driver);
		    plp.clickOnProductsLookUp();
		    ProductsPage pp=new ProductsPage(driver);
		    pp.saveProduct(PRODUCTNAME);
		    ProductValidation pv=new ProductValidation(driver);
			String proHeader=pv.validateProduct();
		    Assert.assertTrue(proHeader.contains(PRODUCTNAME));//hard assert using
		    /*if(proHeader.contains(PRODUCTNAME))
		    {
		    	System.out.println("product is created");
		    }
		    else
		    {
		    	System.out.println("product is not created");
		    }*/
		   
		    System.out.println("product is created");
	}
}
