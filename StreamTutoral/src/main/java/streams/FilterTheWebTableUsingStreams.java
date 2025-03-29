package streams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FilterTheWebTableUsingStreams {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[type='search']")).sendKeys("Rice");
		List<WebElement>veggies=driver.findElements(By.xpath("//tr//td[1]"));
		List<WebElement>filteredList=veggies.stream().filter(veggie->veggie.getText().contains("Rice"))
		.collect(Collectors.toList());
		Assert.assertEquals(veggies.size(), filteredList.size());
	}

}
