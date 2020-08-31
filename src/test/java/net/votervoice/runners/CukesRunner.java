package net.votervoice.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/default-cucumber-reports",
                "json:target/cucumber.json"
        },

        features = "src/test/resources/features",
        glue = "net/votervoice/step_definitions",
        dryRun = false,
        tags = "@wip"
)
public class CukesRunner {
}
