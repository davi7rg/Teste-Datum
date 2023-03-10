package davirodrigues;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/CompraDeProduto.feature",
				 glue = { },
				 tags = {"@CompraDeProduto"},
				 monochrome = true, 
				 dryRun = false)

public class RunTest {

}
