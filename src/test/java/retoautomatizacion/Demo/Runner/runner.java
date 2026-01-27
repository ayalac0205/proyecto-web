package retoautomatizacion.Demo.Runner;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "retoautomatizacion.Demo",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {"pretty"},
        monochrome = true,
    tags = "@compra"
)
public class runner { }
