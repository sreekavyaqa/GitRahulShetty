package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//Cucumber ->Testng , junit
@CucumberOptions(features="src/test/java/cucumber" , glue="rahulshettyacademy.stepDefinition",
monochrome=true,tags="@Regression",plugin= {"html:target/cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

}
