package myTestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources",
        glue="stepDefinitions",monochrome=true,dryRun=false,
        plugin= {"pretty","json:target/cucumber.json", "html:target/cucumber-report-html/cucumber-html-reports" })
        
                       
public class TestRunner extends AbstractTestNGCucumberTests{
	
}
