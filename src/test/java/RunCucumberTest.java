
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

public class RunCucumberTest {

    @RunWith(Cucumber.class)
    @CucumberOptions(
            plugin = {"pretty", "json:target/cucumber.json", "junit:target/cucumber.xml", "html:target/cucumber-reports"},
            features = "src/test/resources/features")
    public class RunCucumberCucumberTest {

    }
}
