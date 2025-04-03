package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent{

	WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".hero-primary")
	WebElement confirmMsg;
	//String confirmMsg = driver.findElement(By.cssSelector(".hero-primary")).getText();
	//Assert.assertTrue(confirmMsg.equalsIgnoreCase("Thankyou for the order."));
	
	public String getConfirmationMsg() {
		return confirmMsg.getText();
	}
}
