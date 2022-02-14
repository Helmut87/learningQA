package scenarios;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "steps",
        features = "src/test/resources",
        tags = "@find_course",
        snippets = SnippetType.UNDERSCORE
)
public class RunnerTest {
}
