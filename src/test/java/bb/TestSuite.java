package bb;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"bb.defs", "bb.Hooks"},
        tags = "@TestCase-5",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {
                "pretty",
                "summary",
                "json:target/serenity-reports/cucumber_report.json"
        },
        monochrome = true
)
public class TestSuite {
}
