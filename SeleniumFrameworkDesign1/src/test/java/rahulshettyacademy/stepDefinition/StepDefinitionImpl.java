package rahulshettyacademy.stepDefinition;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckOutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class StepDefinitionImpl extends BaseTest{

	public LandingPage landingpage;
	public ProductCatalogue productCatalogue;
	public ConfirmationPage confirmpage;
	@Given("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_page() throws Exception {
		landingpage=launchApplication();
	}
	
	@Given("^Loggedin with Username (.+) and Password (.+)$")
	public void loggedIn_username_and_password(String username , String password) {
		productCatalogue=landingPage.loginApplication(username,password);
	}
	@When("^I add the product (.+) to Cart$")
	public void i_add_product_to_Cart(String productName) throws Exception {
		List<WebElement>products=productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);	
	}
	
	@And("^Checkout (.+) and submit the order$")
	public void Checkout_and_submit_the_order(String productName) throws Exception {
		 CartPage cartPage=productCatalogue.goToCartPage();		
		  Boolean match =cartPage.verifyProductDisplay(productName);
		  Assert.assertTrue(match);
		  
		  CheckOutPage checkoutPage=cartPage.goToCheckOut();
		  checkoutPage.selectCountry("india"); 
		  confirmpage =checkoutPage.submitOrder();
	}

	@Then("{string} message is displayed on Confirmation Page")
	public void message_displayed_ConfirmationPage(String string) throws Exception {
		 String confirmMsg=confirmpage.getConfirmationMsg();
		  
		  Assert.assertTrue(confirmMsg.equalsIgnoreCase(string));
		  Thread.sleep(2000);
	}
	
	@Then("{string} message is displayed")
	public void error_messageDisplayed(String string) {
		Assert.assertEquals(string,landingPage.getErrorMsg());
		driver.close();
	}
}
