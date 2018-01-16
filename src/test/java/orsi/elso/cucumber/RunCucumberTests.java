package orsi.elso.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

/**
 * Created by msimon on 16.1.2018.
 */
@CucumberOptions(features = "src/test/resources/features/",
        glue = "orsi.elso.cucumber")
public class RunCucumberTests extends AbstractTestNGCucumberTests {

    @Test
    public void doNothing() { }
}
