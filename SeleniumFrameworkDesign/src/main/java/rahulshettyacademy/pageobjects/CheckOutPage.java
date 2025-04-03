package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent{
WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement countryTextBox;
	
	By txtBox=By.cssSelector("[placeholder='Select Country']");
	
	By CountryListDrpDown= By.cssSelector(".ta-results");
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement selectingCountryFromList;
	
	@FindBy(xpath="//a[contains(@class,'action__submit')]")
	WebElement placeOrder;
//
	public void selectCountry(String Country) {
		Actions actions= new Actions(driver);
		actions.sendKeys(countryTextBox, "india").build().perform();
		//waitForElementToAppear(txtBox);	
		
		waitForElementToAppear(CountryListDrpDown);	
		selectingCountryFromList.click();
		
	}

	public ConfirmationPage submitOrder() {
		//scrollToViewElement(placeOrder);
		//placeOrder.click();
		Actions actions= new Actions(driver);
		actions.moveToElement(placeOrder).click().perform();
		return new ConfirmationPage(driver);
		
	}
}
