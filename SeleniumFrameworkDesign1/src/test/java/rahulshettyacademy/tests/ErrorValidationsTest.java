package rahulshettyacademy.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckOutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest {
	
	@Test(groups= {"ErrorHandling"})
	public void loginErrorValidation() {
	landingPage.loginApplication("kavya.19jan@gmail.com", "Test@1234");
	Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMsg());
	}
	
	@Test
	public void productErrorvalidation() throws Exception {
		String productName = "ZARA COAT 3";
		
		ProductCatalogue productCatalogue=landingPage.loginApplication("harekrishna@gmail.com", "Test@123");
		List<WebElement>products=productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);		
		
		
		CartPage cartPage=productCatalogue.goToCartPage();		
		Boolean match =cartPage.verifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);

	}
}
