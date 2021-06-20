package com.smartbear.parallel;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions( features = "src/test/resources/com/smartbear/parallel/LoginToSingleProducts.feature",
        glue = {"com/smartbear/parallel/stepdefs",
                "com/smartbear/hooks"},
        plugin = {"pretty", "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json", "rerun:target/cucumber-reports/rerun.txt"},
        monochrome = true,
        dryRun = false
)

public class RunCucumberTest {

}
