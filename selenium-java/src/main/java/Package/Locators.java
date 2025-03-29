package Package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//implicit wait- wait 5sec timeout-it keeps on wait till 5sec, it if doesn't show selenium could not find element
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("kavya");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		driver.findElement(By.className("submit")).click();
		driver.findElement(By.cssSelector("p.error")).getText();
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Sreekavya");
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Sree@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).clear();
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("kavya@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("7989919561");
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		
		
		
	}

}
