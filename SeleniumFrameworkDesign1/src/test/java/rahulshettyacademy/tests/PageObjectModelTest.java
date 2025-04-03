package rahulshettyacademy.tests;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckOutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.OrdersPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class PageObjectModelTest extends BaseTest {
	
	String productName = "ZARA COAT 3";

	@Test(dataProvider = "getData", groups="Purchase")
	public void placetheOrder(HashMap<String, String>input) throws Exception {	

		ProductCatalogue productCatalogue=landingPage.loginApplication(input.get("email"),input.get("password"));
		List<WebElement>products=productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("newProduct"));		
		
		
		CartPage cartPage=productCatalogue.goToCartPage();		
		Boolean match =cartPage.verifyProductDisplay(input.get("newProduct"));
		Assert.assertTrue(match);
		
		CheckOutPage checkoutPage=cartPage.goToCheckOut();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmpage=checkoutPage.submitOrder();
		
		String confirmMsg=confirmpage.getConfirmationMsg();
		
		Assert.assertTrue(confirmMsg.equalsIgnoreCase("Thankyou for the order."));
		Thread.sleep(2000);

	}
	
	//verify ZARA COAT 3 is displaying in orders page
	
	@Test(dependsOnMethods= {"placetheOrder"})
	public void orderHistoryTest() {
		ProductCatalogue productCatalogue=landingPage.loginApplication("kavya.19jan@gmail.com", "Test@123");
		OrdersPage ordersPage=productCatalogue.goToOrdersPage();
		Assert.assertTrue(ordersPage.verifyOrderDisplay(productName));	
	}
	
	@DataProvider
	public Object[][] getData() throws Exception {
	
		List<HashMap<String, String>>data=getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\rahulshettyacademy\\data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	/*
	 * @DataProvider public Object[][] getData1() { return new Object[][]
	 * {{"kavya.19jan@gmail.com",
	 * "Test@123","ZARA COAT 3"},{"harekrishna@gmail.com",
	 * "Test@123","ADIDAS ORIGINAL"}}; }
	 */
	/*
	 * HashMap<String,String>map = new HashMap<String,String>(); map.put("email",
	 * "kavya.19jan@gmail.com"); map.put("password", "Test@123");
	 * map.put("newProduct", "ZARA COAT 3");
	 * 
	 * HashMap<String,String>map1 = new HashMap<String,String>(); map1.put("email",
	 * "harekrishna@gmail.com"); map1.put("password", "Test@123");
	 * map1.put("newProduct", "ADIDAS ORIGINAL"); return new Object[][]
	 * {{map},{map1}};
	 */
	
}
