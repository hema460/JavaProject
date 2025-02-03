package myTestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/bddcucumber",
        glue="stepDefinitions",monochrome=true,dryRun=false,
        plugin= {"pretty","html:target/cucumber.html"})
        
                       
public class TestRunner extends AbstractTestNGCucumberTests{
	
}
