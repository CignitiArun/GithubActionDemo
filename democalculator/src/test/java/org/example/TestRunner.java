
package org.example;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources",
				 glue = { "org.example.stepdefs" }, 
				 plugin = { "pretty","html:target/cucumber-reports/Cucumber.html" },
				 tags = "@smoke", monochrome = true)

public class TestRunner extends AbstractTestNGCucumberTests {
}
