package rahulshettyacademy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckOutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class PageObjectModelTest {

	public static void main(String[] args) throws Exception {
		String productName = "ZARA COAT 3";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LandingPage landingPage= new LandingPage(driver);
		landingPage.goTo();
		ProductCatalogue productCatalogue=landingPage.loginApplication("kavya.19jan@gmail.com", "Test@123");
		List<WebElement>products=productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);		
		
		
		CartPage cartPage=productCatalogue.goToCartPage();		
		Boolean match =cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		
		CheckOutPage checkoutPage=cartPage.goToCheckOut();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmpage=checkoutPage.submitOrder();
		
		String confirmMsg=confirmpage.getConfirmationMsg();
		
		Assert.assertTrue(confirmMsg.equalsIgnoreCase("Thankyou for the order."));
		Thread.sleep(2000);
		driver.close();

	}

}
