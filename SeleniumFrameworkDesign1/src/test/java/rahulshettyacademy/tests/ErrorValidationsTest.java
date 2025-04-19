package rahulshettyacademy.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckOutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest {

	
	  @Test
	  public void loginErrorValidation() throws Exception {
	  landingPage.loginApplication("kavya.19jan@gmail.com", "Test@1234");
	  Thread.sleep(1000);
	  Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMsg()); }
	 

	//@Test
	public void productErrorvalidation() throws Exception {

		ProductCatalogue productCatalogue = landingPage.loginApplication("harekrishna@gmail.com", "Test@123");
		String productName = "ZARA COAT 3";
		//List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.verifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);

	}

}
