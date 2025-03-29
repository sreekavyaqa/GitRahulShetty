package streams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableSoring {
public static void main(String[] args) throws Exception {
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
	Thread.sleep(2000);
	//click on column,it gets sorted
	driver.findElement(By.xpath("//tr//th[1]")).click();
	Thread.sleep(2000);
	//capture all the webelements into list
	List<WebElement>elementlist=driver.findElements(By.xpath("//tr//td[1]"));
	//capture text of allwebelements into new list(Original ist)
	List<String> originalList=elementlist.stream().map(s->s.getText()).collect(Collectors.toList());
	
	//Apply sort on the original  in list of step3->Sorted list
	List<String>sortedList=originalList.stream().sorted().collect(Collectors.toList());
	//Compare original list vs sorted list
	Assert.assertTrue(originalList.equals(sortedList));
	//Scan the name column with the get text ->Rice and print the price of Rice
	//Filter-if we want to apply any condition
	List<String>price;
	do {
		//capture all the webelements into list
		List<WebElement>rows=driver.findElements(By.xpath("//tr//td[1]"));	
		price=rows.stream().filter(s->s.getText().contains("Rice")).
	map(s->getPriceVeggie(s)).collect(Collectors.toList());
	price.forEach(a->System.out.println(a));
	if(price.size()<1) {
		driver.findElement(By.cssSelector("[aria-label='Next']")).click();
	}
	}while(price.size()<1);
}

private static String getPriceVeggie(WebElement s ) {
	// TODO Auto-generated method stub
	String priceValue=s.findElement(By.xpath("following-sibling::td[1]")).getText();
	return priceValue;
}
}
