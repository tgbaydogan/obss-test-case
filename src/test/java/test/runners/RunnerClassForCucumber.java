package test.runners;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterSuite;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/obss/feature/obss.feature", glue = { "obss.scenarios" }, plugin = {
		"pretty", "json:target/cucumber-reports/Cucumber.json", "junit:target/cucumber-reports/Cucumber.xml",
		"html:target/cucumber-reports/Cucumber.html" }, monochrome = true)
public class RunnerClassForCucumber extends AbstractTestNGCucumberTests {

	@AfterSuite
	public void tearDown() {
	}
}