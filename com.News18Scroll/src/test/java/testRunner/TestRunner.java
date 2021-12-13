package testRunner;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features="classpath:features" ,
		glue="stepDefinition",

tags = {"@tag"}, monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {

}
