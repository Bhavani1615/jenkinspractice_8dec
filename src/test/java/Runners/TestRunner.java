package Runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "E:\\javaselenium\\DemoWebShopMaven\\src\\test\\java\\features"  // path of feature file
,glue={"StepDefinitions"}  //path of step definition class
,tags={"@SuccessfulLogin"}  //to run exactly the required scenario
//,plugin = {"pretty", "html:target/cucumber-html-report"}
,monochrome=true// console output is much more readable
,plugin = {"json:target/cucumber-reports/CucumberTestReport.json"}

)
public class TestRunner extends AbstractTestNGCucumberTests {

}
