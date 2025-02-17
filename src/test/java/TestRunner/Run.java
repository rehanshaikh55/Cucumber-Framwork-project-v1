package TestRunner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = {"Features"},
		glue={"StepDefinition"},
		
		monochrome = true,
		plugin = {"pretty","html:target/htmlreport.html"}
		)
public class Run extends AbstractTestNGCucumberTests  {

}
