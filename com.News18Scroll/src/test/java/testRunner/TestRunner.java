package testRunner;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features="classpath:features" ,
		glue="stepDefinition",

tags = {"@OpenBrowser"}, monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {

}
