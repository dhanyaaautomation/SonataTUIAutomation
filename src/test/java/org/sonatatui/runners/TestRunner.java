package org.sonatatui.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/features",
        glue = {
                "org.sonatatui.hooks",
                "org.sonatatui.stepdefinitions"

        },
        plugin = {"pretty","html:target/cucumber-report.html"},

        tags= "@smoke or @regression"


)
public class TestRunner extends AbstractTestNGCucumberTests {
}
