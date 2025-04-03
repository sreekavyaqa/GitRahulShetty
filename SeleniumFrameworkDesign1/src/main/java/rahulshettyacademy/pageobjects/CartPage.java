package rahulshettyacademy.pageobjects;

import java.util.List;
import java.util.zip.CheckedOutputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	private List<WebElement> productTitles;
	
	@FindBy(xpath="(//button[@class='btn btn-primary'])[3]")
	WebElement checkOutEle;

	By CheckoutElementBy=By.xpath("(//button[@class='btn btn-primary'])[3]");
	
	public Boolean verifyProductDisplay(String productName) {
		Boolean match = productTitles.stream()
				.anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public CheckOutPage goToCheckOut() {
		waitForElementToAppear(CheckoutElementBy);
		Actions a = new Actions(driver);	
		a.moveToElement(checkOutEle).click().perform();
		return new CheckOutPage(driver);
	}
	
	
	
}
