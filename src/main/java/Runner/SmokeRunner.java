package Runner;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = {"Step"},features = {"src/main/java/Features"}, tags = "@smoke",plugin= {"json:src/main/java/Result/cucumberResult.json"})

public class SmokeRunner {
}
