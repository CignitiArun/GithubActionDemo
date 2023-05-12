package org.example;

import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org.example.stepdefs"},
        plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json"},
        tags = {"@add"},
        monochrome = true

)
public class TestRunner extends AbstractTestNGCucumberParallelTests {
}
