package bddcucumber;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/bddcucumber",
        glue="stepDefinitions",strict=true,plugin="html:target/cucumber.html"
		)
public class JunitTestRunner {

}
