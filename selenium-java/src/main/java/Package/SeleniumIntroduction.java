package Package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumIntroduction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Selenium invokes chromedriver.exe to launch chromebrowser
		//if we we are running manually, we have to use System.setproperty
		//System.setProperty("webdriver.chrome.driver", "Launch chrome driver");
		//Selenium manager to invoke chromedriver-it connects to web directly and invokes appropriate wedriver file, 
	WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
		driver.quit();

	}

}
